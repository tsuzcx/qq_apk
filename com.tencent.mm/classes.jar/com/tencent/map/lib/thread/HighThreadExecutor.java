package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class HighThreadExecutor
  implements Executor
{
  private final ThreadFactory a;
  private final BlockingQueue<Runnable> b;
  private final Executor c;
  
  public HighThreadExecutor()
  {
    AppMethodBeat.i(98201);
    this.a = new HighThreadExecutor.1(this);
    this.b = new HighThreadExecutor.a(this, 5);
    this.c = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, this.b, this.a, new ThreadPoolExecutor.DiscardOldestPolicy());
    AppMethodBeat.o(98201);
  }
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(98202);
    this.c.execute(paramRunnable);
    AppMethodBeat.o(98202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor
 * JD-Core Version:    0.7.0.1
 */