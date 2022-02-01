package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.b;
import com.tencent.mm.ipcinvoker.g.a;
import com.tencent.mm.ipcinvoker.h.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

final class n$a
  implements b
{
  private int jYX;
  HandlerThread mHandlerThread;
  
  n$a()
  {
    AppMethodBeat.i(179043);
    this.jYX = 3;
    HandlerThread localHandlerThread = new HandlerThread("IPCThreadPool#InnerWorkerThread-" + hashCode());
    localHandlerThread.start();
    c.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", new Object[] { Integer.valueOf(localHandlerThread.hashCode()) });
    this.mHandlerThread = localHandlerThread;
    AppMethodBeat.o(179043);
  }
  
  public final ExecutorService aFv()
  {
    AppMethodBeat.i(179044);
    ScheduledThreadPoolExecutor local2 = new ScheduledThreadPoolExecutor(this.jYX, new ThreadFactory()
    {
      int index = 0;
      
      public final Thread newThread(final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(179039);
        Object localObject = new StringBuilder("IPCThreadPool#Thread-");
        int i = this.index;
        this.index = (i + 1);
        localObject = i;
        paramAnonymousRunnable = new Thread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179038);
            ThreadLocal localThreadLocal = (ThreadLocal)new a(Looper.class, "sThreadLocal").aFE();
            if ((localThreadLocal != null) && (localThreadLocal.get() == null))
            {
              c.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
              localThreadLocal.set(n.a.this.mHandlerThread.getLooper());
            }
            for (;;)
            {
              paramAnonymousRunnable.run();
              AppMethodBeat.o(179038);
              return;
              c.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", new Object[] { localThreadLocal });
            }
          }
        }, (String)localObject);
        c.i("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", new Object[] { localObject });
        AppMethodBeat.o(179039);
        return paramAnonymousRunnable;
      }
    })
    {
      public final void execute(final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(179041);
        super.execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179040);
            try
            {
              paramAnonymousRunnable.run();
              AppMethodBeat.o(179040);
              return;
            }
            catch (Throwable localThrowable)
            {
              Thread.UncaughtExceptionHandler localUncaughtExceptionHandler2 = Thread.currentThread().getUncaughtExceptionHandler();
              Thread.UncaughtExceptionHandler localUncaughtExceptionHandler1 = localUncaughtExceptionHandler2;
              if (localUncaughtExceptionHandler2 == null) {
                localUncaughtExceptionHandler1 = Thread.getDefaultUncaughtExceptionHandler();
              }
              if (localUncaughtExceptionHandler1 != null) {
                localUncaughtExceptionHandler1.uncaughtException(Thread.currentThread(), localThrowable);
              }
              AppMethodBeat.o(179040);
              throw localThrowable;
            }
          }
        });
        AppMethodBeat.o(179041);
      }
    };
    local2.setMaximumPoolSize((int)(this.jYX * 1.5D));
    local2.setRejectedExecutionHandler(new RejectedExecutionHandler()
    {
      public final void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor)
      {
        AppMethodBeat.i(179042);
        c.w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", new Object[] { paramAnonymousRunnable });
        AppMethodBeat.o(179042);
      }
    });
    AppMethodBeat.o(179044);
    return local2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.n.a
 * JD-Core Version:    0.7.0.1
 */