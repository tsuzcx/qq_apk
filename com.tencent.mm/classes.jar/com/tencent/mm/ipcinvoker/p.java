package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
{
  private static volatile p gAB;
  private Handler gAC;
  private Handler mHandler;
  
  private p()
  {
    AppMethodBeat.i(158760);
    this.mHandler = l.ahP();
    this.gAC = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(158760);
  }
  
  private static p ahS()
  {
    AppMethodBeat.i(158759);
    if (gAB == null) {}
    try
    {
      if (gAB == null) {
        gAB = new p();
      }
      p localp = gAB;
      AppMethodBeat.o(158759);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(158759);
    }
  }
  
  public static HandlerThread ahT()
  {
    AppMethodBeat.i(158761);
    HandlerThread localHandlerThread = (HandlerThread)ahS().mHandler.getLooper().getThread();
    AppMethodBeat.o(158761);
    return localHandlerThread;
  }
  
  public static boolean f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(197963);
    boolean bool = ahS().gAC.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(197963);
    return bool;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(158762);
    boolean bool = ahS().mHandler.post(paramRunnable);
    AppMethodBeat.o(158762);
    return bool;
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(158763);
    boolean bool = ahS().mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(158763);
    return bool;
  }
  
  public static boolean x(Runnable paramRunnable)
  {
    AppMethodBeat.i(158764);
    boolean bool = ahS().gAC.post(paramRunnable);
    AppMethodBeat.o(158764);
    return bool;
  }
  
  public static boolean y(Runnable paramRunnable)
  {
    AppMethodBeat.i(158766);
    l.post(paramRunnable);
    AppMethodBeat.o(158766);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.p
 * JD-Core Version:    0.7.0.1
 */