package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/CountDownLock;", "", "countDownCallback", "Ljava/lang/Runnable;", "count", "", "(Ljava/lang/Runnable;I)V", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "countDown", "", "plugin-appbrand-integration_release"})
public final class k
{
  private final AtomicInteger counter;
  private final Runnable mTQ;
  
  public k(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(51402);
    this.mTQ = paramRunnable;
    if (paramInt > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRunnable = (Throwable)new IllegalArgumentException("count <= 0".toString());
      AppMethodBeat.o(51402);
      throw paramRunnable;
    }
    this.counter = new AtomicInteger(paramInt);
    AppMethodBeat.o(51402);
  }
  
  public final void countDown()
  {
    AppMethodBeat.i(51401);
    if (this.counter.decrementAndGet() == 0)
    {
      Runnable localRunnable = this.mTQ;
      if (localRunnable != null)
      {
        localRunnable.run();
        AppMethodBeat.o(51401);
        return;
      }
    }
    AppMethodBeat.o(51401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.k
 * JD-Core Version:    0.7.0.1
 */