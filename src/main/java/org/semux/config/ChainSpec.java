/**
 * Copyright (c) 2017-2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.config;

import java.util.List;

import org.semux.core.Amount;
import org.semux.core.TransactionType;

/**
 * Chain specifications define the parameters that are agreed by the network and
 * enforced as part of the consensus.
 */
public interface ChainSpec {

    /**
     * Returns the maximum gas limit for any block
     *
     * @return
     */
    long maxBlockGasLimit();

    /**
     * Returns the max total size of all transactions in a block, encoding overhead
     * not counted.
     *
     * @return
     */
    int maxBlockTransactionsSize();

    /**
     * Returns the max data size for the given transaction type.
     *
     * @return
     */
    int maxTransactionDataSize(TransactionType type);

    /**
     * Returns the min transaction fee.
     *
     * @return
     */
    Amount minTransactionFee();

    /**
     * Returns the min amount of value burned when registering as a delegate.
     *
     * @return
     */
    Amount minDelegateBurnAmount();

    /**
     * Returns the block reward for a specific block.
     *
     * @param number
     *            block number
     * @return the block reward
     */
    Amount getBlockReward(long number);

    /**
     * Returns the validator update rate.
     *
     * @return
     */
    long getValidatorUpdateInterval();

    /**
     * Returns the number of validators.
     *
     * @param number
     * @return
     */
    int getNumberOfValidators(long number);

    /**
     * Returns the primary validator for a specific [height, view].
     *
     * @param validators
     * @param height
     * @param view
     * @param uniformDist
     * @return
     */
    String getPrimaryValidator(List<String> validators, long height, int view, boolean uniformDist);
}
