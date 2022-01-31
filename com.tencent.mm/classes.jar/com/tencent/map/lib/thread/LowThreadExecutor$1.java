package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class LowThreadExecutor$1
  implements ThreadFactory
{
  private final AtomicInteger b;
  
  LowThreadExecutor$1(LowThreadExecutor paramLowThreadExecutor)
  {
    AppMethodBeat.i(98203);
    this.b = new AtomicInteger(1);
    AppMethodBeat.o(98203);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(98204);
    paramRunnable = new Thread(paramRunnable, "AsyncTask Low #" + this.b.getAndIncrement());
    AppMethodBeat.o(98204);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.thread.LowThreadExecutor.1
 * JD-Core Version:    0.7.0.1
 */