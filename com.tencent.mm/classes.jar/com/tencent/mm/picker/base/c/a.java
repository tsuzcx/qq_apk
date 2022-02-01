package com.tencent.mm.picker.base.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class a
  implements b
{
  private final ScheduledExecutorService mBe;
  
  public a()
  {
    AppMethodBeat.i(249655);
    this.mBe = Executors.newSingleThreadScheduledExecutor();
    AppMethodBeat.o(249655);
  }
  
  public final Future<?> e(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(249656);
    paramRunnable = this.mBe.scheduleWithFixedDelay(paramRunnable, 0L, paramLong, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(249656);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */