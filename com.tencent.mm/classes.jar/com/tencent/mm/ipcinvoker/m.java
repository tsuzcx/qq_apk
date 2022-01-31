package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

class m
{
  private static volatile m eEu;
  private static com.tencent.mm.ipcinvoker.a.b eEv;
  ExecutorService mExecutorService;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(114069);
    eEv = new m.a();
    AppMethodBeat.o(114069);
  }
  
  private m()
  {
    AppMethodBeat.i(114066);
    final HandlerThread localHandlerThread = new HandlerThread("ThreadPool#WorkerThread-" + hashCode());
    localHandlerThread.start();
    Handler localHandler = new Handler(localHandlerThread.getLooper());
    localHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114056);
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ThreadPool", "createHandlerThread(id : %d)", new Object[] { Integer.valueOf(localHandlerThread.getThreadId()) });
        AppMethodBeat.o(114056);
      }
    });
    this.mHandler = localHandler;
    this.mExecutorService = eEv.PS();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.ThreadPool", "initialize IPCInvoker ThreadPool(hashCode : %s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(114066);
  }
  
  private static m PQ()
  {
    AppMethodBeat.i(114064);
    if (eEu == null) {}
    try
    {
      if (eEu == null) {
        eEu = new m();
      }
      m localm = eEu;
      AppMethodBeat.o(114064);
      return localm;
    }
    finally
    {
      AppMethodBeat.o(114064);
    }
  }
  
  static m PR()
  {
    AppMethodBeat.i(114065);
    m localm = new m();
    AppMethodBeat.o(114065);
    return localm;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(114067);
    PQ().mExecutorService.execute(paramRunnable);
    AppMethodBeat.o(114067);
    return true;
  }
  
  public static boolean s(Runnable paramRunnable)
  {
    AppMethodBeat.i(114068);
    boolean bool = PQ().mHandler.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(114068);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m
 * JD-Core Version:    0.7.0.1
 */