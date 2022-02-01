package com.tencent.luggage.sdk.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/wxa_ktx/CountDownLock;", "", "countDownCallback", "Ljava/lang/Runnable;", "count", "", "(Ljava/lang/Runnable;I)V", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "countDown", "", "luggage-wechat-full-sdk_release"})
public final class b
{
  private final Runnable cDk;
  private final AtomicInteger counter;
  
  public b(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(237051);
    this.cDk = paramRunnable;
    if (paramInt > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRunnable = (Throwable)new IllegalArgumentException("count <= 0".toString());
      AppMethodBeat.o(237051);
      throw paramRunnable;
    }
    this.counter = new AtomicInteger(paramInt);
    AppMethodBeat.o(237051);
  }
  
  public final void Sz()
  {
    AppMethodBeat.i(237050);
    if (this.counter.decrementAndGet() == 0)
    {
      Runnable localRunnable = this.cDk;
      if (localRunnable != null)
      {
        localRunnable.run();
        AppMethodBeat.o(237050);
        return;
      }
    }
    AppMethodBeat.o(237050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.b
 * JD-Core Version:    0.7.0.1
 */