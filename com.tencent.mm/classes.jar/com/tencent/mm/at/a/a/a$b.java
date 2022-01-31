package com.tencent.mm.at.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class a$b
  implements ThreadFactory
{
  private static final AtomicInteger ePN;
  private final ThreadGroup cfU;
  private final AtomicInteger cfV;
  private final String cfW;
  private final int ePO;
  
  static
  {
    AppMethodBeat.i(116057);
    ePN = new AtomicInteger(1);
    AppMethodBeat.o(116057);
  }
  
  a$b(int paramInt, String paramString)
  {
    AppMethodBeat.i(116055);
    this.cfV = new AtomicInteger(1);
    this.ePO = paramInt;
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.cfU = ((ThreadGroup)localObject);
      this.cfW = (paramString + ePN.getAndIncrement() + "-thread-");
      AppMethodBeat.o(116055);
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(116056);
    paramRunnable = new Thread(this.cfU, paramRunnable, this.cfW + this.cfV.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    paramRunnable.setPriority(this.ePO);
    AppMethodBeat.o(116056);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */