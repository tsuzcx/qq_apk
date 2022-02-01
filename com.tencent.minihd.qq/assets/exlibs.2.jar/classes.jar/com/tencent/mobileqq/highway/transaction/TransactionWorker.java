package com.tencent.mobileqq.highway.transaction;

import android.os.Handler;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionWorker
  implements IHwManager
{
  public static final int TRANS_OP_CNCL = 2;
  public static final int TRANS_OP_SEND = 1;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private HwEngine engine;
  private ArrayList<Transaction> transQueue = new ArrayList();
  
  public TransactionWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  public void cancelTransaction(Transaction paramTransaction)
  {
    paramTransaction.cancelTransaction();
    this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
  }
  
  void dumpEngineInfo()
  {
    int i = this.engine.mRequestWorker.mCurrentRequests;
    int j = this.engine.mTransWorker.transQueue.size();
    int k = this.engine.mConnManager.connectedConn;
    QLog.d("E", 1, "EngineInfo : Request:" + i + " TransCnt:" + j + " ConnCnt:" + k);
  }
  
  int getConnErroCode()
  {
    return this.engine.mConnManager.vConnErrCode;
  }
  
  String getHeartBreakInfo()
  {
    return this.engine.mConnManager.getHeartBreakInfo();
  }
  
  public long getIpConnectCost()
  {
    return this.engine.mConnManager.getConnCost();
  }
  
  long[] getReportDataFlow()
  {
    return new long[] { this.engine.upFlow_Wifi.getAndSet(0L), this.engine.dwFlow_Wifi.getAndSet(0L), this.engine.upFlow_Xg.getAndSet(0L), this.engine.dwFlow_Xg.getAndSet(0L) };
  }
  
  public Transaction getTransactionById(int paramInt)
  {
    Object localObject1 = null;
    synchronized (this.transQueue)
    {
      Iterator localIterator = this.transQueue.iterator();
      while (localIterator.hasNext())
      {
        Transaction localTransaction = (Transaction)localIterator.next();
        if (localTransaction.getTransationId() == paramInt) {
          localObject1 = localTransaction;
        }
      }
      return localObject1;
    }
  }
  
  public int getTransactionNum()
  {
    return this.transQueue.size();
  }
  
  public boolean isNetworkConnected()
  {
    return HwNetworkUtil.isNetworkConnected(this.engine.getAppContext());
  }
  
  public void notifyToSend()
  {
    this.engine.mRequestWorker.notifyTransactionChange(1, null);
  }
  
  public void onDestroy()
  {
    synchronized (this.transQueue)
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.transQueue);
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        cancelTransaction((Transaction)((Iterator)localObject1).next());
      }
    }
    this.transQueue.clear();
  }
  
  public void onInit() {}
  
  public void onTransactionFinish(boolean paramBoolean, Transaction paramTransaction)
  {
    synchronized (this.transQueue)
    {
      this.transQueue.remove(paramTransaction);
      if (!paramBoolean) {
        this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
      }
      return;
    }
  }
  
  public DataTransInfo pullNextSegment(int paramInt, HwNetSegConf paramHwNetSegConf)
  {
    Object localObject2 = null;
    synchronized (this.transQueue)
    {
      Iterator localIterator = this.transQueue.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((Transaction)localIterator.next()).peekNextSegment(paramInt, paramHwNetSegConf);
      } while (localObject1 == null);
      return localObject1;
    }
  }
  
  public void queryTransaction(Transaction paramTransaction, byte[] paramArrayOfByte)
  {
    this.engine.mRequestWorker.sendInfoQueryRequest(paramTransaction, paramArrayOfByte);
  }
  
  public void resumeTransaction(Transaction paramTransaction)
  {
    paramTransaction.setPause(false);
    this.engine.mRequestWorker.notifyTransactionChange(1, paramTransaction);
  }
  
  void startTransRunnable(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    if (localRequestHandler != null)
    {
      if (paramRunnable1 != null) {
        localRequestHandler.removeCallbacks(paramRunnable1);
      }
      localRequestHandler.postDelayed(paramRunnable2, 600000L);
    }
  }
  
  void stopTransRunnable(Runnable paramRunnable)
  {
    RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    if (localRequestHandler != null) {
      localRequestHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void stopTransaction(Transaction paramTransaction)
  {
    paramTransaction.setPause(true);
    this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
  }
  
  public int submitTransation(Transaction paramTransaction)
  {
    int i;
    if ((paramTransaction == null) || (paramTransaction.filePath == null) || (paramTransaction.transationId != -1))
    {
      i = 9042;
      return i;
    }
    boolean bool;
    if (this.engine.mConnManager.getCurrentConnNum() > 0) {
      bool = true;
    }
    for (;;)
    {
      int j = paramTransaction.initSegmentList(this, bool);
      i = j;
      if (j != 0) {
        break;
      }
      paramTransaction.transationId = seqFactory.incrementAndGet();
      BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " ukey:" + String.valueOf(paramTransaction.ticket));
      synchronized (this.transQueue)
      {
        this.transQueue.add(paramTransaction);
        notifyToSend();
        return j;
        bool = false;
      }
    }
  }
  
  public void switchToBackupChannel()
  {
    synchronized (this.transQueue)
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.transQueue);
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Transaction localTransaction = (Transaction)((Iterator)localObject1).next();
        cancelTransaction(localTransaction);
        localTransaction.onSwitchToBackupChannel();
      }
    }
  }
  
  boolean updateAndCheckNet()
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    return HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType() != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransactionWorker
 * JD-Core Version:    0.7.0.1
 */