package com.tencent.mm.plugin.appbrand.ac;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class m
{
  private static final Object ogA;
  private static volatile m.a ogB;
  
  static
  {
    AppMethodBeat.i(140849);
    ogA = new Object();
    ogB = null;
    AppMethodBeat.o(140849);
  }
  
  public static void bZm()
  {
    AppMethodBeat.i(140846);
    if (ogB != null) {
      try
      {
        if (ogB != null) {
          ogB.removeCallbacksAndMessages(null);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(140846);
      }
    }
    AppMethodBeat.o(140846);
  }
  
  public static m.a bZn()
  {
    AppMethodBeat.i(221352);
    if (ogB == null) {}
    try
    {
      if (ogB == null) {
        ogB = new m.a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      m.a locala = ogB;
      AppMethodBeat.o(221352);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(221352);
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140848);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(140848);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(140848);
      return;
    }
    h.RTc.aV(paramRunnable);
    AppMethodBeat.o(140848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.m
 * JD-Core Version:    0.7.0.1
 */