package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.h.b;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class m$a$3
  implements RejectedExecutionHandler
{
  m$a$3(m.a parama) {}
  
  public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    b.w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", new Object[] { paramRunnable });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m.a.3
 * JD-Core Version:    0.7.0.1
 */