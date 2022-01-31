package com.tencent.map.lib.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class HighThreadExecutor
  implements Executor
{
  private final ThreadFactory a = new HighThreadExecutor.1(this);
  private final BlockingQueue<Runnable> b = new HighThreadExecutor.a(this, 5);
  private final Executor c = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, this.b, this.a, new ThreadPoolExecutor.DiscardOldestPolicy());
  
  public void execute(Runnable paramRunnable)
  {
    this.c.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor
 * JD-Core Version:    0.7.0.1
 */