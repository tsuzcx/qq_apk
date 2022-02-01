package com.tencent.mm.picker.base.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class a
  implements b
{
  private final ScheduledExecutorService pxO;
  
  public a()
  {
    AppMethodBeat.i(231597);
    this.pxO = Executors.newSingleThreadScheduledExecutor();
    AppMethodBeat.o(231597);
  }
  
  public final Future<?> f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(231598);
    paramRunnable = this.pxO.scheduleWithFixedDelay(paramRunnable, 0L, paramLong, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(231598);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */