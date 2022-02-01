package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
{
  private static volatile p fZE;
  private Handler fZF;
  private Handler mHandler;
  
  private p()
  {
    AppMethodBeat.i(158760);
    this.mHandler = l.ady();
    this.fZF = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(158760);
  }
  
  public static boolean A(Runnable paramRunnable)
  {
    AppMethodBeat.i(158766);
    l.post(paramRunnable);
    AppMethodBeat.o(158766);
    return true;
  }
  
  private static p adB()
  {
    AppMethodBeat.i(158759);
    if (fZE == null) {}
    try
    {
      if (fZE == null) {
        fZE = new p();
      }
      p localp = fZE;
      AppMethodBeat.o(158759);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(158759);
    }
  }
  
  public static HandlerThread adC()
  {
    AppMethodBeat.i(158761);
    HandlerThread localHandlerThread = (HandlerThread)adB().mHandler.getLooper().getThread();
    AppMethodBeat.o(158761);
    return localHandlerThread;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(158762);
    boolean bool = adB().mHandler.post(paramRunnable);
    AppMethodBeat.o(158762);
    return bool;
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(158763);
    boolean bool = adB().mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(158763);
    return bool;
  }
  
  public static boolean y(Runnable paramRunnable)
  {
    AppMethodBeat.i(158764);
    boolean bool = adB().fZF.post(paramRunnable);
    AppMethodBeat.o(158764);
    return bool;
  }
  
  public static boolean z(Runnable paramRunnable)
  {
    AppMethodBeat.i(158765);
    boolean bool = adB().fZF.postDelayed(paramRunnable, 100L);
    AppMethodBeat.o(158765);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.p
 * JD-Core Version:    0.7.0.1
 */