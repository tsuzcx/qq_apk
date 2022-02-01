package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.b;
import com.tencent.mm.ipcinvoker.h.c;
import java.util.concurrent.ExecutorService;

class n
{
  private static volatile n jYU;
  private static b jYV;
  private static final HandlerThread jYW;
  ExecutorService mExecutorService;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(179050);
    jYV = null;
    HandlerThread localHandlerThread = new HandlerThread("IPCThreadPool#WorkerThread");
    jYW = localHandlerThread;
    localHandlerThread.start();
    AppMethodBeat.o(179050);
  }
  
  private n()
  {
    AppMethodBeat.i(179046);
    this.mHandler = new Handler(jYW.getLooper());
    if (jYV == null) {
      jYV = new n.a();
    }
    this.mExecutorService = jYV.aFv();
    c.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179046);
  }
  
  private static n aFt()
  {
    AppMethodBeat.i(179045);
    if (jYU == null) {}
    try
    {
      if (jYU == null) {
        jYU = new n();
      }
      n localn = jYU;
      AppMethodBeat.o(179045);
      return localn;
    }
    finally
    {
      AppMethodBeat.o(179045);
    }
  }
  
  public static Handler aFu()
  {
    AppMethodBeat.i(179047);
    Handler localHandler = new Handler(jYW.getLooper());
    AppMethodBeat.o(179047);
    return localHandler;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(179048);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(179048);
      return false;
    }
    aFt().mExecutorService.execute(paramRunnable);
    AppMethodBeat.o(179048);
    return true;
  }
  
  public static boolean x(Runnable paramRunnable)
  {
    AppMethodBeat.i(179049);
    boolean bool = aFt().mHandler.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(179049);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.n
 * JD-Core Version:    0.7.0.1
 */