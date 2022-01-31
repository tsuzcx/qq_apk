package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;

public class l
{
  private static volatile l eEr;
  private Handler eEs;
  private m eEt;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  
  private l()
  {
    AppMethodBeat.i(114050);
    this.mHandlerThread = new HandlerThread("ThreadCaller#Worker-" + hashCode());
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.eEs = new Handler(Looper.getMainLooper());
    this.eEt = m.PR();
    AppMethodBeat.o(114050);
  }
  
  private static l PO()
  {
    AppMethodBeat.i(114049);
    if (eEr == null) {}
    try
    {
      if (eEr == null) {
        eEr = new l();
      }
      l locall = eEr;
      AppMethodBeat.o(114049);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(114049);
    }
  }
  
  public static HandlerThread PP()
  {
    AppMethodBeat.i(143026);
    HandlerThread localHandlerThread = PO().mHandlerThread;
    AppMethodBeat.o(143026);
    return localHandlerThread;
  }
  
  public static boolean h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(143027);
    boolean bool = PO().eEs.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(143027);
    return bool;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(114051);
    boolean bool = PO().mHandler.post(paramRunnable);
    AppMethodBeat.o(114051);
    return bool;
  }
  
  public static boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(114052);
    boolean bool = PO().mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(114052);
    return bool;
  }
  
  public static boolean q(Runnable paramRunnable)
  {
    AppMethodBeat.i(114053);
    boolean bool = PO().eEs.post(paramRunnable);
    AppMethodBeat.o(114053);
    return bool;
  }
  
  public static boolean r(Runnable paramRunnable)
  {
    AppMethodBeat.i(114055);
    PO().eEt.mExecutorService.execute(paramRunnable);
    AppMethodBeat.o(114055);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.l
 * JD-Core Version:    0.7.0.1
 */