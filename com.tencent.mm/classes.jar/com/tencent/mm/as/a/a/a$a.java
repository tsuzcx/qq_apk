package com.tencent.mm.as.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class a$a
  implements ThreadFactory
{
  private static final AtomicInteger eqF = new AtomicInteger(1);
  private final ThreadGroup eqG;
  private final AtomicInteger eqH = new AtomicInteger(1);
  private final String eqI;
  private final int eqJ;
  
  a$a(int paramInt, String paramString)
  {
    this.eqJ = paramInt;
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.eqG = ((ThreadGroup)localObject);
      this.eqI = (paramString + eqF.getAndIncrement() + "-thread-");
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.eqG, paramRunnable, this.eqI + this.eqH.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    paramRunnable.setPriority(this.eqJ);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */