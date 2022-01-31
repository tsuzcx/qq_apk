package com.tencent.mm.plugin.appbrand.s;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;

public final class m
{
  private static volatile al ftB;
  private static final Object iXt;
  private static Handler sMainHandler;
  
  static
  {
    AppMethodBeat.i(91176);
    iXt = new Object();
    sMainHandler = null;
    AppMethodBeat.o(91176);
  }
  
  public static void aNR()
  {
    AppMethodBeat.i(91173);
    if (ftB == null)
    {
      AppMethodBeat.o(91173);
      return;
    }
    synchronized (iXt)
    {
      if (ftB != null)
      {
        g.avC("SubCoreAppBrand#WorkerThread");
        ftB.oNc.quit();
        ftB = null;
      }
      AppMethodBeat.o(91173);
      return;
    }
  }
  
  public static al aNS()
  {
    AppMethodBeat.i(91174);
    if (ftB == null) {}
    synchronized (iXt)
    {
      if (ftB == null)
      {
        ftB = new al("SubCoreAppBrand#WorkerThread");
        g.a("SubCoreAppBrand#WorkerThread", new h(ftB.oNc.getLooper(), "SubCoreAppBrand#WorkerThread"));
      }
      ??? = ftB;
      AppMethodBeat.o(91174);
      return ???;
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(91175);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(91175);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(91175);
      return;
    }
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    sMainHandler.post(paramRunnable);
    AppMethodBeat.o(91175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.m
 * JD-Core Version:    0.7.0.1
 */