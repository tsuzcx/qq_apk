package com.bumptech.glide.c.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements ExecutorService
{
  private static final long aJy;
  private static volatile int aJz;
  private final ExecutorService aJA;
  
  static
  {
    AppMethodBeat.i(77194);
    aJy = TimeUnit.SECONDS.toMillis(10L);
    AppMethodBeat.o(77194);
  }
  
  private a(ExecutorService paramExecutorService)
  {
    this.aJA = paramExecutorService;
  }
  
  public static a ph()
  {
    AppMethodBeat.i(77175);
    Object localObject = a.b.aJI;
    localObject = new a(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("disk-cache", (a.b)localObject, true)));
    AppMethodBeat.o(77175);
    return localObject;
  }
  
  public static a pi()
  {
    AppMethodBeat.i(77176);
    int i = pl();
    Object localObject = a.b.aJI;
    localObject = new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("source", (a.b)localObject, false)));
    AppMethodBeat.o(77176);
    return localObject;
  }
  
  public static a pj()
  {
    AppMethodBeat.i(77177);
    a locala = new a(new ThreadPoolExecutor(0, 2147483647, aJy, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", a.b.aJI, false)));
    AppMethodBeat.o(77177);
    return locala;
  }
  
  public static a pk()
  {
    AppMethodBeat.i(77178);
    if (pl() >= 4) {}
    for (int i = 2;; i = 1)
    {
      Object localObject = a.b.aJI;
      localObject = new a(new ThreadPoolExecutor(0, i, aJy, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", (a.b)localObject, true)));
      AppMethodBeat.o(77178);
      return localObject;
    }
  }
  
  private static int pl()
  {
    AppMethodBeat.i(77193);
    if (aJz == 0) {
      aJz = Math.min(4, b.availableProcessors());
    }
    int i = aJz;
    AppMethodBeat.o(77193);
    return i;
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(77191);
    boolean bool = this.aJA.awaitTermination(paramLong, paramTimeUnit);
    AppMethodBeat.o(77191);
    return bool;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(77179);
    this.aJA.execute(paramRunnable);
    AppMethodBeat.o(77179);
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
  {
    AppMethodBeat.i(77181);
    paramCollection = this.aJA.invokeAll(paramCollection);
    AppMethodBeat.o(77181);
    return paramCollection;
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(77182);
    paramCollection = this.aJA.invokeAll(paramCollection, paramLong, paramTimeUnit);
    AppMethodBeat.o(77182);
    return paramCollection;
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
  {
    AppMethodBeat.i(77183);
    paramCollection = this.aJA.invokeAny(paramCollection);
    AppMethodBeat.o(77183);
    return paramCollection;
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(77184);
    paramCollection = this.aJA.invokeAny(paramCollection, paramLong, paramTimeUnit);
    AppMethodBeat.o(77184);
    return paramCollection;
  }
  
  public final boolean isShutdown()
  {
    AppMethodBeat.i(77189);
    boolean bool = this.aJA.isShutdown();
    AppMethodBeat.o(77189);
    return bool;
  }
  
  public final boolean isTerminated()
  {
    AppMethodBeat.i(77190);
    boolean bool = this.aJA.isTerminated();
    AppMethodBeat.o(77190);
    return bool;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(77187);
    this.aJA.shutdown();
    AppMethodBeat.o(77187);
  }
  
  public final List<Runnable> shutdownNow()
  {
    AppMethodBeat.i(77188);
    List localList = this.aJA.shutdownNow();
    AppMethodBeat.o(77188);
    return localList;
  }
  
  public final Future<?> submit(Runnable paramRunnable)
  {
    AppMethodBeat.i(77180);
    paramRunnable = this.aJA.submit(paramRunnable);
    AppMethodBeat.o(77180);
    return paramRunnable;
  }
  
  public final <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    AppMethodBeat.i(77185);
    paramRunnable = this.aJA.submit(paramRunnable, paramT);
    AppMethodBeat.o(77185);
    return paramRunnable;
  }
  
  public final <T> Future<T> submit(Callable<T> paramCallable)
  {
    AppMethodBeat.i(77186);
    paramCallable = this.aJA.submit(paramCallable);
    AppMethodBeat.o(77186);
    return paramCallable;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77192);
    String str = this.aJA.toString();
    AppMethodBeat.o(77192);
    return str;
  }
  
  static final class a
    implements ThreadFactory
  {
    final a.b aJB;
    final boolean aJC;
    private int aJD;
    private final String name;
    
    a(String paramString, a.b paramb, boolean paramBoolean)
    {
      this.name = paramString;
      this.aJB = paramb;
      this.aJC = paramBoolean;
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      try
      {
        AppMethodBeat.i(77172);
        paramRunnable = new Thread(paramRunnable, "glide-" + this.name + "-thread-" + this.aJD)
        {
          public final void run()
          {
            AppMethodBeat.i(77171);
            Process.setThreadPriority(9);
            if (a.a.this.aJC) {
              StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
            }
            try
            {
              super.run();
              AppMethodBeat.o(77171);
              return;
            }
            catch (Throwable localThrowable)
            {
              a.a.this.aJB.c(localThrowable);
              AppMethodBeat.o(77171);
            }
          }
        };
        this.aJD += 1;
        AppMethodBeat.o(77172);
        return paramRunnable;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.c.a
 * JD-Core Version:    0.7.0.1
 */