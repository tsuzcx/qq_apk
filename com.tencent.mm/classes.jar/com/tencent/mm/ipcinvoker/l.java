package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

class l
{
  private static volatile l gxL;
  private static com.tencent.mm.ipcinvoker.a.b gxM;
  private static final HandlerThread gxN;
  ExecutorService mExecutorService;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(179050);
    gxM = null;
    HandlerThread localHandlerThread = new HandlerThread("IPCThreadPool#WorkerThread");
    gxN = localHandlerThread;
    localHandlerThread.start();
    AppMethodBeat.o(179050);
  }
  
  private l()
  {
    AppMethodBeat.i(179046);
    this.mHandler = new Handler(gxN.getLooper());
    if (gxM == null) {
      gxM = new a();
    }
    this.mExecutorService = gxM.ahB();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(179046);
  }
  
  public static Handler ahA()
  {
    AppMethodBeat.i(179047);
    Handler localHandler = new Handler(gxN.getLooper());
    AppMethodBeat.o(179047);
    return localHandler;
  }
  
  private static l ahz()
  {
    AppMethodBeat.i(179045);
    if (gxL == null) {}
    try
    {
      if (gxL == null) {
        gxL = new l();
      }
      l locall = gxL;
      AppMethodBeat.o(179045);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(179045);
    }
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(179048);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(179048);
      return false;
    }
    ahz().mExecutorService.execute(paramRunnable);
    AppMethodBeat.o(179048);
    return true;
  }
  
  public static boolean y(Runnable paramRunnable)
  {
    AppMethodBeat.i(179049);
    boolean bool = ahz().mHandler.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(179049);
    return bool;
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.a.b
  {
    private int gxO;
    HandlerThread mHandlerThread;
    
    a()
    {
      AppMethodBeat.i(179043);
      this.gxO = 3;
      HandlerThread localHandlerThread = new HandlerThread("IPCThreadPool#InnerWorkerThread-" + hashCode());
      localHandlerThread.start();
      com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", new Object[] { Integer.valueOf(localHandlerThread.hashCode()) });
      this.mHandlerThread = localHandlerThread;
      AppMethodBeat.o(179043);
    }
    
    public final ExecutorService ahB()
    {
      AppMethodBeat.i(179044);
      ScheduledThreadPoolExecutor local2 = new ScheduledThreadPoolExecutor(this.gxO, new ThreadFactory()
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
              ThreadLocal localThreadLocal = (ThreadLocal)new a(Looper.class, "sThreadLocal").ahH();
              if ((localThreadLocal != null) && (localThreadLocal.get() == null))
              {
                com.tencent.mm.ipcinvoker.h.b.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
                localThreadLocal.set(l.a.this.mHandlerThread.getLooper());
              }
              for (;;)
              {
                paramAnonymousRunnable.run();
                AppMethodBeat.o(179038);
                return;
                com.tencent.mm.ipcinvoker.h.b.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", new Object[] { localThreadLocal });
              }
            }
          }, (String)localObject);
          com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", new Object[] { localObject });
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
      local2.setMaximumPoolSize((int)(this.gxO * 1.5D));
      local2.setRejectedExecutionHandler(new RejectedExecutionHandler()
      {
        public final void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor)
        {
          AppMethodBeat.i(179042);
          com.tencent.mm.ipcinvoker.h.b.w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", new Object[] { paramAnonymousRunnable });
          AppMethodBeat.o(179042);
        }
      });
      AppMethodBeat.o(179044);
      return local2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.l
 * JD-Core Version:    0.7.0.1
 */