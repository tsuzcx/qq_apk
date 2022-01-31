package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b
  extends ThreadPoolExecutor
  implements a
{
  private ReentrantLock ePI = new ReentrantLock();
  private Condition ePJ = this.ePI.newCondition();
  private BlockingQueue<Runnable> ePK;
  private boolean isPaused;
  
  public b(int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, 0L, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    this.ePK = paramBlockingQueue;
  }
  
  /* Error */
  protected final void beforeExecute(java.lang.Thread paramThread, Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 44	java/util/concurrent/ThreadPoolExecutor:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   6: aload_0
    //   7: getfield 27	com/tencent/mm/loader/g/a/b:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: invokevirtual 47	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   13: aload_0
    //   14: getfield 49	com/tencent/mm/loader/g/a/b:isPaused	Z
    //   17: ifeq +46 -> 63
    //   20: aload_0
    //   21: getfield 33	com/tencent/mm/loader/g/a/b:ePJ	Ljava/util/concurrent/locks/Condition;
    //   24: invokeinterface 54 1 0
    //   29: goto -16 -> 13
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 59	java/lang/Thread:interrupt	()V
    //   37: ldc 61
    //   39: ldc 63
    //   41: iconst_1
    //   42: anewarray 65	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_2
    //   48: invokevirtual 69	java/lang/Exception:toString	()Ljava/lang/String;
    //   51: aastore
    //   52: invokestatic 75	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: getfield 27	com/tencent/mm/loader/g/a/b:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   59: invokevirtual 78	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   62: return
    //   63: aload_0
    //   64: getfield 27	com/tencent/mm/loader/g/a/b:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   67: invokevirtual 78	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 27	com/tencent/mm/loader/g/a/b:ePI	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 78	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	b
    //   0	81	1	paramThread	java.lang.Thread
    //   0	81	2	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   13	29	32	java/lang/Exception
    //   13	29	71	finally
    //   33	55	71	finally
  }
  
  public final void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.b
 * JD-Core Version:    0.7.0.1
 */