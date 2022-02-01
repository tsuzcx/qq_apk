package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
{
  private static volatile p gxU;
  private Handler gxV;
  private Handler mHandler;
  
  private p()
  {
    AppMethodBeat.i(158760);
    this.mHandler = l.ahA();
    this.gxV = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(158760);
  }
  
  public static boolean A(Runnable paramRunnable)
  {
    AppMethodBeat.i(158766);
    l.post(paramRunnable);
    AppMethodBeat.o(158766);
    return true;
  }
  
  private static p ahD()
  {
    AppMethodBeat.i(158759);
    if (gxU == null) {}
    try
    {
      if (gxU == null) {
        gxU = new p();
      }
      p localp = gxU;
      AppMethodBeat.o(158759);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(158759);
    }
  }
  
  public static HandlerThread ahE()
  {
    AppMethodBeat.i(158761);
    HandlerThread localHandlerThread = (HandlerThread)ahD().mHandler.getLooper().getThread();
    AppMethodBeat.o(158761);
    return localHandlerThread;
  }
  
  public static boolean f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(186714);
    boolean bool = ahD().gxV.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(186714);
    return bool;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(158762);
    boolean bool = ahD().mHandler.post(paramRunnable);
    AppMethodBeat.o(158762);
    return bool;
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(158763);
    boolean bool = ahD().mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(158763);
    return bool;
  }
  
  public static boolean z(Runnable paramRunnable)
  {
    AppMethodBeat.i(158764);
    boolean bool = ahD().gxV.post(paramRunnable);
    AppMethodBeat.o(158764);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.p
 * JD-Core Version:    0.7.0.1
 */