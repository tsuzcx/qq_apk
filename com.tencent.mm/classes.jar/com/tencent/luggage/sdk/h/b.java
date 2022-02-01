package com.tencent.luggage.sdk.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/CountDownLock;", "", "countDownCallback", "Ljava/lang/Runnable;", "count", "", "(Ljava/lang/Runnable;I)V", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "countDown", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final Runnable evI;
  private final AtomicInteger evJ;
  
  public b(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(220564);
    this.evI = paramRunnable;
    if (paramInt > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRunnable = (Throwable)new IllegalArgumentException("count <= 0".toString());
      AppMethodBeat.o(220564);
      throw paramRunnable;
    }
    this.evJ = new AtomicInteger(paramInt);
    AppMethodBeat.o(220564);
  }
  
  public final void asP()
  {
    AppMethodBeat.i(220568);
    if (this.evJ.decrementAndGet() == 0)
    {
      Runnable localRunnable = this.evI;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
    AppMethodBeat.o(220568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.b
 * JD-Core Version:    0.7.0.1
 */