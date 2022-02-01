package com.tencent.mm.ipcinvoker;

import android.os.Handler;
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

class n
{
  private static volatile n myR;
  private static b myS;
  private static final HandlerThread myT;
  static j.b myU;
  ExecutorService mExecutorService;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(179050);
    myS = null;
    HandlerThread localHandlerThread = new HandlerThread("IPCThreadPool#WorkerThread");
    myT = localHandlerThread;
    localHandlerThread.start();
    AppMethodBeat.o(179050);
  }
  
  private n()
  {
    AppMethodBeat.i(179046);
    this.mHandler = new Handler(myT.getLooper());
    if (myS == null) {
      myS = new a();
    }
    this.mExecutorService = myS.aYw();
    c.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179046);
  }
  
  public static boolean C(Runnable paramRunnable)
  {
    AppMethodBeat.i(179049);
    boolean bool = aYu().mHandler.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(179049);
    return bool;
  }
  
  private static n aYu()
  {
    AppMethodBeat.i(179045);
    if (myR == null) {}
    try
    {
      if (myR == null) {
        myR = new n();
      }
      n localn = myR;
      AppMethodBeat.o(179045);
      return localn;
    }
    finally
    {
      AppMethodBeat.o(179045);
    }
  }
  
  public static Handler aYv()
  {
    AppMethodBeat.i(179047);
    Handler localHandler = new Handler(myT.getLooper());
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
    aYu().mExecutorService.execute(paramRunnable);
    AppMethodBeat.o(179048);
    return true;
  }
  
  static final class a
    implements b
  {
    HandlerThread mHandlerThread;
    private int myV;
    
    a()
    {
      AppMethodBeat.i(179043);
      this.myV = 3;
      HandlerThread localHandlerThread = new HandlerThread("IPCThreadPool#InnerWorkerThread-" + hashCode());
      localHandlerThread.start();
      c.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", new Object[] { Integer.valueOf(localHandlerThread.hashCode()) });
      this.mHandlerThread = localHandlerThread;
      AppMethodBeat.o(179043);
    }
    
    public final ExecutorService aYw()
    {
      AppMethodBeat.i(179044);
      ScheduledThreadPoolExecutor local2 = new ScheduledThreadPoolExecutor(this.myV, new ThreadFactory()
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
              ThreadLocal localThreadLocal = (ThreadLocal)new a(Looper.class, "sThreadLocal").aYE();
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
                if (n.myU != null) {
                  n.myU.b(paramAnonymousRunnable, n.myU.A(paramAnonymousRunnable));
                }
                paramAnonymousRunnable.run();
                if (n.myU != null)
                {
                  n.myU.c(paramAnonymousRunnable, n.myU.A(paramAnonymousRunnable));
                  n.myU.B(paramAnonymousRunnable);
                  AppMethodBeat.o(179040);
                  return;
                }
              }
              finally
              {
                try
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
                finally
                {
                  if (n.myU != null)
                  {
                    n.myU.c(paramAnonymousRunnable, n.myU.A(paramAnonymousRunnable));
                    n.myU.B(paramAnonymousRunnable);
                  }
                  AppMethodBeat.o(179040);
                }
                AppMethodBeat.o(179040);
              }
            }
          });
          AppMethodBeat.o(179041);
        }
      };
      local2.setMaximumPoolSize((int)(this.myV * 1.5D));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.n
 * JD-Core Version:    0.7.0.1
 */