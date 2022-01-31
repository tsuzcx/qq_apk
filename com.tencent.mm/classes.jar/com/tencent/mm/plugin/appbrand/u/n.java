package com.tencent.mm.plugin.appbrand.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;

public final class n
{
  private static volatile ai edy;
  private static final Object hkZ = new Object();
  private static Handler hla = null;
  
  public static ai DS()
  {
    if (edy == null) {}
    synchronized (hkZ)
    {
      if (edy == null)
      {
        edy = new ai("SubCoreAppBrand#WorkerThread");
        g.a("SubCoreAppBrand#WorkerThread", new h(edy.mnU.getLooper(), "SubCoreAppBrand#WorkerThread"));
      }
      return edy;
    }
  }
  
  public static void aqp()
  {
    if (edy == null) {
      return;
    }
    synchronized (hkZ)
    {
      if (edy != null)
      {
        g.aeK("SubCoreAppBrand#WorkerThread");
        edy.mnU.quit();
        edy = null;
      }
      return;
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    if (hla == null) {
      hla = new Handler(Looper.getMainLooper());
    }
    hla.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.n
 * JD-Core Version:    0.7.0.1
 */