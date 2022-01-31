package com.tencent.mm.at.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.sdk.g.b.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class a$a
  extends c
  implements h
{
  private ReentrantLock ePI;
  private Condition ePJ;
  private BlockingQueue<Runnable> ePK;
  private boolean isPaused;
  
  public a$a(int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super("image_loader_", paramInt1, paramInt2, paramBlockingQueue);
    AppMethodBeat.i(116048);
    this.ePI = new ReentrantLock();
    this.ePJ = this.ePI.newCondition();
    this.ePK = paramBlockingQueue;
    AppMethodBeat.o(116048);
  }
  
  public final boolean Ds()
  {
    return this.isPaused;
  }
  
  /* Error */
  public final void beforeExecute(java.lang.Thread paramThread, Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 64	com/tencent/mm/sdk/g/b/c:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   11: aload_0
    //   12: getfield 39	com/tencent/mm/at/a/a/a$a:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   15: invokevirtual 67	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   18: aload_0
    //   19: getfield 57	com/tencent/mm/at/a/a/a$a:isPaused	Z
    //   22: ifeq +51 -> 73
    //   25: aload_0
    //   26: getfield 45	com/tencent/mm/at/a/a/a$a:ePJ	Ljava/util/concurrent/locks/Condition;
    //   29: invokeinterface 72 1 0
    //   34: goto -16 -> 18
    //   37: astore_2
    //   38: aload_1
    //   39: invokevirtual 77	java/lang/Thread:interrupt	()V
    //   42: ldc 79
    //   44: ldc 81
    //   46: iconst_1
    //   47: anewarray 83	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_2
    //   53: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: getfield 39	com/tencent/mm/at/a/a/a$a:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   64: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   67: ldc 62
    //   69: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: aload_0
    //   74: getfield 39	com/tencent/mm/at/a/a/a$a:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   77: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: ldc 62
    //   82: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 39	com/tencent/mm/at/a/a/a$a:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: ldc 62
    //   96: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
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
    AppMethodBeat.i(116052);
    super.execute(paramRunnable);
    AppMethodBeat.o(116052);
  }
  
  public final boolean isShutdown()
  {
    AppMethodBeat.i(116054);
    boolean bool = super.isShutdown();
    AppMethodBeat.o(116054);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116050);
    this.ePI.lock();
    try
    {
      this.isPaused = true;
      return;
    }
    finally
    {
      this.ePI.unlock();
      AppMethodBeat.o(116050);
    }
  }
  
  public final void remove(Object paramObject)
  {
    AppMethodBeat.i(116053);
    if (this.ePK != null) {
      this.ePK.remove(paramObject);
    }
    AppMethodBeat.o(116053);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(116051);
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
      AppMethodBeat.o(116051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */