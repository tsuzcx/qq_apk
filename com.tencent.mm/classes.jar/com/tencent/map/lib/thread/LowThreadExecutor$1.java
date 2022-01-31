package com.tencent.map.lib.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class LowThreadExecutor$1
  implements ThreadFactory
{
  private final AtomicInteger b = new AtomicInteger(1);
  
  LowThreadExecutor$1(LowThreadExecutor paramLowThreadExecutor) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AsyncTask Low #" + this.b.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.thread.LowThreadExecutor.1
 * JD-Core Version:    0.7.0.1
 */