package com.tencent.map.lib.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class HighThreadExecutor$1
  implements ThreadFactory
{
  private final AtomicInteger b = new AtomicInteger(1);
  
  HighThreadExecutor$1(HighThreadExecutor paramHighThreadExecutor) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "AsyncTask High #" + this.b.getAndIncrement());
    paramRunnable.setPriority(6);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor.1
 * JD-Core Version:    0.7.0.1
 */