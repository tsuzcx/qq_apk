package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

public final class b
{
  private static ak hna;
  private static ak hnb;
  private static ak hnc;
  
  static
  {
    AppMethodBeat.i(10659);
    HandlerThread localHandlerThread = d.aqu("DynamicPage#WorkerThread");
    localHandlerThread.start();
    hna = new ak(localHandlerThread.getLooper());
    localHandlerThread = d.aqu("DynamicPage#IPCThread");
    localHandlerThread.start();
    hnb = new ak(localHandlerThread.getLooper());
    hnc = new ak(Looper.getMainLooper());
    AppMethodBeat.o(10659);
  }
  
  public static boolean C(Runnable paramRunnable)
  {
    AppMethodBeat.i(10656);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(10656);
      return false;
    }
    boolean bool = hna.post(paramRunnable);
    AppMethodBeat.o(10656);
    return bool;
  }
  
  public static boolean D(Runnable paramRunnable)
  {
    AppMethodBeat.i(10658);
    boolean bool = hnc.post(paramRunnable);
    AppMethodBeat.o(10658);
    return bool;
  }
  
  public static boolean l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(10657);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(10657);
      return false;
    }
    boolean bool = hna.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(10657);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b
 * JD-Core Version:    0.7.0.1
 */