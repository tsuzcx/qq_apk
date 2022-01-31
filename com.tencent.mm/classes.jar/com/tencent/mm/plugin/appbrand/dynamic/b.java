package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  private static ah fTA;
  private static ah fTB = new ah(Looper.getMainLooper());
  private static ah fTz;
  
  static
  {
    HandlerThread localHandlerThread = e.aap("DynamicPage#WorkerThread");
    localHandlerThread.start();
    fTz = new ah(localHandlerThread.getLooper());
    localHandlerThread = e.aap("DynamicPage#IPCThread");
    localHandlerThread.start();
    fTA = new ah(localHandlerThread.getLooper());
  }
  
  public static boolean h(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    return fTz.postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean u(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    return fTz.post(paramRunnable);
  }
  
  public static boolean v(Runnable paramRunnable)
  {
    return fTB.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b
 * JD-Core Version:    0.7.0.1
 */