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
    AppMethodBeat.i(17033);
    this.counter = new AtomicInteger(0);
    AppMethodBeat.o(17033);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(17034);
    paramRunnable = new Thread(paramRunnable, "FacebookSdk #" + this.counter.incrementAndGet());
    AppMethodBeat.o(17034);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.FacebookSdk.1
 * JD-Core Version:    0.7.0.1
 */