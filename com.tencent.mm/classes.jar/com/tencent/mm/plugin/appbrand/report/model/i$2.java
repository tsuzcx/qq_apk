package com.tencent.mm.plugin.appbrand.report.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class i$2
  extends ThreadPoolExecutor
{
  i$2(TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(1, 1, 1000L, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if ((paramRunnable instanceof i.a)) {
      i.aom().a((i.a)paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.2
 * JD-Core Version:    0.7.0.1
 */