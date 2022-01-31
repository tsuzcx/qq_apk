package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(132616);
    super.afterExecute(paramRunnable, paramThrowable);
    if ((paramRunnable instanceof i.a)) {
      i.aLl().a((i.a)paramRunnable);
    }
    AppMethodBeat.o(132616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.2
 * JD-Core Version:    0.7.0.1
 */