package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class m
{
  public static void G(ArrayList<Runnable> paramArrayList)
  {
    try
    {
      AppMethodBeat.i(234901);
      m.c localc = new m.c(2);
      Iterator localIterator = paramArrayList.iterator();
      long l;
      for (paramArrayList = Long.valueOf(1L); localIterator.hasNext(); paramArrayList = Long.valueOf(l + 1L))
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        l = paramArrayList.longValue();
        localc.k(localRunnable, paramArrayList.longValue());
      }
      localc.shutdown();
      AppMethodBeat.o(234901);
      return;
    }
    finally {}
  }
  
  public static Object a(Callable<?> paramCallable, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234902);
    Object localObject = Executors.newSingleThreadExecutor();
    paramCallable = ((ExecutorService)localObject).submit(paramCallable);
    ((ExecutorService)localObject).shutdown();
    paramString1 = "job " + paramString1 + " ";
    long l = paramInt;
    try
    {
      localObject = paramCallable.get(l, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(234902);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      h.log(4, paramString2, paramString1 + "cancelled");
      paramCallable.cancel(true);
      AppMethodBeat.o(234902);
    }
    return null;
  }
  
  public static Future<?> a(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(234900);
    paramString = new b("job " + paramString + " ");
    paramRunnable = paramString.submit(paramRunnable);
    paramString.shutdown();
    AppMethodBeat.o(234900);
    return paramRunnable;
  }
  
  public static final class b
    extends ThreadPoolExecutor
  {
    String mAd;
    
    public b(String paramString)
    {
      super(1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      AppMethodBeat.i(234894);
      this.mAd = "";
      this.mAd = paramString;
      AppMethodBeat.o(234894);
    }
    
    public b(TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
    {
      super(10, 0L, paramTimeUnit, paramBlockingQueue);
      this.mAd = "";
    }
    
    protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      AppMethodBeat.i(234897);
      super.afterExecute(paramRunnable, paramThrowable);
      Throwable localThrowable1 = paramThrowable;
      if (paramThrowable == null)
      {
        localThrowable1 = paramThrowable;
        if (!(paramRunnable instanceof Future)) {}
      }
      try
      {
        paramRunnable = (Future)paramRunnable;
        localThrowable1 = paramThrowable;
        if (paramRunnable.isDone())
        {
          localThrowable1 = paramThrowable;
          if (!paramRunnable.isCancelled())
          {
            h.log(3, "ThreadUtils", "before future.get()");
            paramRunnable.get();
            h.log(3, "ThreadUtils", "after future.get()");
            localThrowable1 = paramThrowable;
          }
        }
      }
      catch (CancellationException localCancellationException)
      {
        for (;;)
        {
          h.log(5, "ThreadUtils", "CancellationException");
        }
      }
      catch (ExecutionException paramRunnable)
      {
        for (;;)
        {
          h.log(5, "ThreadUtils", "ExecutionException");
          localThrowable2 = paramRunnable.getCause();
        }
      }
      catch (InterruptedException paramRunnable)
      {
        for (;;)
        {
          h.log(5, "ThreadUtils", "InterruptedException");
          Thread.currentThread().interrupt();
          Throwable localThrowable2 = paramThrowable;
        }
      }
      if (localThrowable1 != null) {
        h.log(6, "ThreadUtils", this.mAd + " error occurred during processing request:" + h.i(localThrowable1));
      }
      AppMethodBeat.o(234897);
    }
    
    protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
    {
      AppMethodBeat.i(234896);
      super.beforeExecute(paramThread, paramRunnable);
      h.log(4, "ThreadUtils", "beforeExecute: thread=" + paramThread.toString() + " thread.state=" + paramThread.getState() + " runnable=" + paramRunnable.toString());
      AppMethodBeat.o(234896);
    }
    
    protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      AppMethodBeat.i(234895);
      paramRunnable = super.newTaskFor(paramRunnable, paramT);
      AppMethodBeat.o(234895);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m
 * JD-Core Version:    0.7.0.1
 */