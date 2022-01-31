package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;

public class l
{
  private static volatile l dGO;
  private Handler dGP;
  private m dGQ;
  private Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread("ThreadCaller#Worker-" + hashCode());
  
  private l()
  {
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.dGP = new Handler(Looper.getMainLooper());
    this.dGQ = m.BZ();
  }
  
  private static l BX()
  {
    if (dGO == null) {}
    try
    {
      if (dGO == null) {
        dGO = new l();
      }
      return dGO;
    }
    finally {}
  }
  
  public static boolean e(Runnable paramRunnable, long paramLong)
  {
    return BX().dGP.postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean m(Runnable paramRunnable)
  {
    return BX().dGP.post(paramRunnable);
  }
  
  public static boolean n(Runnable paramRunnable)
  {
    BX().dGQ.mExecutorService.execute(paramRunnable);
    return true;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    return BX().mHandler.post(paramRunnable);
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return BX().mHandler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.l
 * JD-Core Version:    0.7.0.1
 */