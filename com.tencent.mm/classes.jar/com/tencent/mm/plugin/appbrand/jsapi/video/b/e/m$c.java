package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class m$c
  extends ThreadPoolExecutor
{
  public m$c()
  {
    this(TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
    AppMethodBeat.i(194043);
    AppMethodBeat.o(194043);
  }
  
  private m$c(TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(2, 2, 0L, paramTimeUnit, paramBlockingQueue);
  }
  
  public final void k(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(194044);
    super.execute(new m.a(paramRunnable, paramLong));
    AppMethodBeat.o(194044);
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return (RunnableFuture)paramRunnable;
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return (RunnableFuture)paramCallable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.c
 * JD-Core Version:    0.7.0.1
 */