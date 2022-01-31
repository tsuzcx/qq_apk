package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;

class m
{
  private static volatile m dGR;
  private static com.tencent.mm.ipcinvoker.a.b dGS = new m.a();
  ExecutorService mExecutorService;
  private Handler mHandler;
  
  private m()
  {
    HandlerThread localHandlerThread = new HandlerThread("ThreadPool#WorkerThread-" + hashCode());
    localHandlerThread.start();
    Handler localHandler = new Handler(localHandlerThread.getLooper());
    localHandler.post(new m.1(this, localHandlerThread));
    this.mHandler = localHandler;
    this.mExecutorService = dGS.Ca();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.ThreadPool", "initialize IPCInvoker ThreadPool(hashCode : %s)", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  private static m BY()
  {
    if (dGR == null) {}
    try
    {
      if (dGR == null) {
        dGR = new m();
      }
      return dGR;
    }
    finally {}
  }
  
  static m BZ()
  {
    return new m();
  }
  
  public static boolean o(Runnable paramRunnable)
  {
    return BY().mHandler.postDelayed(paramRunnable, 2000L);
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    BY().mExecutorService.execute(paramRunnable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m
 * JD-Core Version:    0.7.0.1
 */