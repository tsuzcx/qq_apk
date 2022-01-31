package com.tencent.mm.at.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.h;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class a$c
  extends ThreadPoolExecutor
  implements h
{
  private ReentrantLock ePI;
  private Condition ePJ;
  private BlockingQueue<Runnable> ePK;
  private boolean isPaused;
  
  public a$c(int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, 0L, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    AppMethodBeat.i(116058);
    this.ePI = new ReentrantLock();
    this.ePJ = this.ePI.newCondition();
    this.ePK = paramBlockingQueue;
    AppMethodBeat.o(116058);
  }
  
  public final boolean Ds()
  {
    return this.isPaused;
  }
  
  /* Error */
  protected final void beforeExecute(java.lang.Thread paramThread, Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 60
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 62	java/util/concurrent/ThreadPoolExecutor:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   11: aload_0
    //   12: getfield 37	com/tencent/mm/at/a/a/a$c:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   15: invokevirtual 65	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   18: aload_0
    //   19: getfield 55	com/tencent/mm/at/a/a/a$c:isPaused	Z
    //   22: ifeq +51 -> 73
    //   25: aload_0
    //   26: getfield 43	com/tencent/mm/at/a/a/a$c:ePJ	Ljava/util/concurrent/locks/Condition;
    //   29: invokeinterface 70 1 0
    //   34: goto -16 -> 18
    //   37: astore_2
    //   38: aload_1
    //   39: invokevirtual 75	java/lang/Thread:interrupt	()V
    //   42: ldc 77
    //   44: ldc 79
    //   46: iconst_1
    //   47: anewarray 81	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_2
    //   53: invokevirtual 85	java/lang/Exception:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: getfield 37	com/tencent/mm/at/a/a/a$c:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   64: invokevirtual 94	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   67: ldc 60
    //   69: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: aload_0
    //   74: getfield 37	com/tencent/mm/at/a/a/a$c:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   77: invokevirtual 94	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: ldc 60
    //   82: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 37	com/tencent/mm/at/a/a/a$c:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 94	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: ldc 60
    //   96: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	c
    //   0	101	1	paramThread	java.lang.Thread
    //   0	101	2	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   18	34	37	java/lang/Exception
    //   18	34	86	finally
    //   38	60	86	finally
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(116062);
    super.execute(paramRunnable);
    AppMethodBeat.o(116062);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116060);
    this.ePI.lock();
    try
    {
      this.isPaused = true;
      return;
    }
    finally
    {
      this.ePI.unlock();
      AppMethodBeat.o(116060);
    }
  }
  
  public final void remove(Object paramObject)
  {
    AppMethodBeat.i(116063);
    if (this.ePK != null) {
      this.ePK.remove(paramObject);
    }
    AppMethodBeat.o(116063);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(116061);
    this.ePI.lock();
    try
    {
      this.isPaused = false;
      this.ePJ.signalAll();
      return;
    }
    finally
    {
      this.ePI.unlock();
      AppMethodBeat.o(116061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */