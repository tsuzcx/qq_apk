package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.c.r;
import com.tencent.mobileqq.msf.core.c.r.a;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.LinkedBlockingQueue;

class j
{
  private String _bootBroadcastName;
  protected int appid;
  IErrorHandler errorHandler;
  protected String msfServiceName;
  protected String processName;
  protected final LinkedBlockingQueue serviceRespMessagePairs = new LinkedBlockingQueue();
  private Object syncQueueLock = new Object();
  
  public boolean addServicePushMsg(FromServiceMsg arg1)
  {
    boolean bool = this.serviceRespMessagePairs.add(new MsfMessagePair(null, ???));
    if ((??? != null) && (???.getServiceCmd() != null) && (???.getServiceCmd().equals("SharpSvr.s2c"))) {
      r.a().a(r.a.e, ???.getWupBuffer(), 0);
    }
    synchronized (this.syncQueueLock)
    {
      this.syncQueueLock.notify();
      return bool;
    }
  }
  
  public boolean addServiceRespMsg(MsfMessagePair arg1)
  {
    boolean bool = this.serviceRespMessagePairs.add(???);
    synchronized (this.syncQueueLock)
    {
      this.syncQueueLock.notify();
      return bool;
    }
  }
  
  public String getBootBroadcastName()
  {
    return this._bootBroadcastName;
  }
  
  public IErrorHandler getErrorHandler()
  {
    return this.errorHandler;
  }
  
  public LinkedBlockingQueue getRespMsgQueue()
  {
    return this.serviceRespMessagePairs;
  }
  
  public MsfMessagePair getServiceRespMsg()
  {
    return (MsfMessagePair)this.serviceRespMessagePairs.poll();
  }
  
  public void initSub(String paramString1, int paramInt, String paramString2, IErrorHandler paramIErrorHandler)
  {
    this.appid = paramInt;
    setBootBroadcastName(paramString2);
    this.processName = paramString1;
    this.errorHandler = paramIErrorHandler;
  }
  
  public void queueWait()
  {
    try
    {
      synchronized (this.syncQueueLock)
      {
        if (this.serviceRespMessagePairs.size() == 0) {
          this.syncQueueLock.wait();
        }
        label24:
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label24;
    }
  }
  
  public void setBootBroadcastName(String paramString)
  {
    this._bootBroadcastName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.j
 * JD-Core Version:    0.7.0.1
 */