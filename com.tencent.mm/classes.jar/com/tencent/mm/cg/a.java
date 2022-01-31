package com.tencent.mm.cg;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;

public class a
{
  private static volatile a uFO;
  private ah mHandler;
  private HandlerThread mHandlerThread = e.aap("WorkerThread#" + hashCode());
  private ah uFP;
  
  private a()
  {
    this.mHandlerThread.start();
    this.mHandler = new ah(this.mHandlerThread.getLooper());
    this.uFP = new ah(Looper.getMainLooper());
  }
  
  private static a cxv()
  {
    if (uFO == null) {}
    try
    {
      if (uFO == null) {
        uFO = new a();
      }
      return uFO;
    }
    finally {}
  }
  
  public static HandlerThread cxw()
  {
    return cxv().mHandlerThread;
  }
  
  public static boolean e(Runnable paramRunnable, long paramLong)
  {
    return cxv().uFP.postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean m(Runnable paramRunnable)
  {
    return cxv().uFP.post(paramRunnable);
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    return cxv().mHandler.post(paramRunnable);
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return cxv().mHandler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cg.a
 * JD-Core Version:    0.7.0.1
 */