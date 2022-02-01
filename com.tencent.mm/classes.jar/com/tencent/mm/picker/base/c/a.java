package com.tencent.mm.picker.base.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class a
  implements b
{
  private final ScheduledExecutorService jKb;
  
  public a()
  {
    AppMethodBeat.i(204554);
    this.jKb = Executors.newSingleThreadScheduledExecutor();
    AppMethodBeat.o(204554);
  }
  
  public final Future<?> h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(204555);
    paramRunnable = this.jKb.scheduleWithFixedDelay(paramRunnable, 0L, paramLong, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(204555);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */