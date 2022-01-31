package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class LowThreadExecutor
  implements Executor
{
  private final ThreadFactory a;
  private final BlockingQueue<Runnable> b;
  public final Executor mExecutor;
  
  public LowThreadExecutor()
  {
    AppMethodBeat.i(98205);
    this.a = new LowThreadExecutor.1(this);
    this.b = new LinkedBlockingQueue(20);
    this.mExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, this.b, this.a, new ThreadPoolExecutor.DiscardOldestPolicy());
    AppMethodBeat.o(98205);
  }
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(98206);
    this.mExecutor.execute(paramRunnable);
    AppMethodBeat.o(98206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.thread.LowThreadExecutor
 * JD-Core Version:    0.7.0.1
 */