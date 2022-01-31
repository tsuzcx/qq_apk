package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class HighThreadExecutor$1
  implements ThreadFactory
{
  private final AtomicInteger b;
  
  HighThreadExecutor$1(HighThreadExecutor paramHighThreadExecutor)
  {
    AppMethodBeat.i(98177);
    this.b = new AtomicInteger(1);
    AppMethodBeat.o(98177);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(98178);
    paramRunnable = new Thread(paramRunnable, "AsyncTask High #" + this.b.getAndIncrement());
    paramRunnable.setPriority(6);
    AppMethodBeat.o(98178);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor.1
 * JD-Core Version:    0.7.0.1
 */