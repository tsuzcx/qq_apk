package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class s
{
  private static volatile s jZd;
  private Handler jZe;
  private Handler mHandler;
  
  private s()
  {
    AppMethodBeat.i(158760);
    this.mHandler = n.aFu();
    this.jZe = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(158760);
  }
  
  public static boolean A(Runnable paramRunnable)
  {
    AppMethodBeat.i(158766);
    n.post(paramRunnable);
    AppMethodBeat.o(158766);
    return true;
  }
  
  private static s aFy()
  {
    AppMethodBeat.i(158759);
    if (jZd == null) {}
    try
    {
      if (jZd == null) {
        jZd = new s();
      }
      s locals = jZd;
      AppMethodBeat.o(158759);
      return locals;
    }
    finally
    {
      AppMethodBeat.o(158759);
    }
  }
  
  public static HandlerThread aFz()
  {
    AppMethodBeat.i(158761);
    HandlerThread localHandlerThread = (HandlerThread)aFy().mHandler.getLooper().getThread();
    AppMethodBeat.o(158761);
    return localHandlerThread;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(158762);
    boolean bool = aFy().mHandler.post(paramRunnable);
    AppMethodBeat.o(158762);
    return bool;
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(158763);
    boolean bool = aFy().mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(158763);
    return bool;
  }
  
  public static boolean y(Runnable paramRunnable)
  {
    AppMethodBeat.i(158764);
    boolean bool = aFy().jZe.post(paramRunnable);
    AppMethodBeat.o(158764);
    return bool;
  }
  
  public static boolean z(Runnable paramRunnable)
  {
    AppMethodBeat.i(158765);
    boolean bool = aFy().jZe.postDelayed(paramRunnable, 100L);
    AppMethodBeat.o(158765);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.s
 * JD-Core Version:    0.7.0.1
 */