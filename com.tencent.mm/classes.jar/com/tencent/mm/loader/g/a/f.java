package com.tencent.mm.loader.g.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
  implements ThreadFactory
{
  private static final AtomicInteger ePN = new AtomicInteger(1);
  private final ThreadGroup cfU;
  private final AtomicInteger cfV = new AtomicInteger(1);
  private final String cfW;
  private final int ePO;
  
  public f(int paramInt, String paramString)
  {
    this.ePO = paramInt;
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.cfU = ((ThreadGroup)localObject);
      this.cfW = (paramString + ePN.getAndIncrement() + "-thread-");
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.cfU, paramRunnable, this.cfW + this.cfV.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    paramRunnable.setPriority(this.ePO);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.f
 * JD-Core Version:    0.7.0.1
 */