package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class FacebookSdk$1
  implements ThreadFactory
{
  private final AtomicInteger counter;
  
  FacebookSdk$1()
  {
    AppMethodBeat.i(71597);
    this.counter = new AtomicInteger(0);
    AppMethodBeat.o(71597);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(71598);
    paramRunnable = new Thread(paramRunnable, "FacebookSdk #" + this.counter.incrementAndGet());
    AppMethodBeat.o(71598);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.FacebookSdk.1
 * JD-Core Version:    0.7.0.1
 */