package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b
  extends com.tencent.e.b
  implements a
{
  private ReentrantLock hiL = new ReentrantLock();
  private Condition hiM = this.hiL.newCondition();
  private BlockingQueue<Runnable> hiN;
  private boolean isPaused;
  
  public b(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramString, paramInt1, paramInt2, paramBlockingQueue);
    this.hiN = paramBlockingQueue;
  }
  
  /* Error */
  public final void beforeExecute(java.lang.Thread paramThread, Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 43	com/tencent/e/b:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   6: aload_0
    //   7: getfield 26	com/tencent/mm/loader/g/a/b:hiL	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   13: aload_0
    //   14: getfield 48	com/tencent/mm/loader/g/a/b:isPaused	Z
    //   17: ifeq +46 -> 63
    //   20: aload_0
    //   21: getfield 32	com/tencent/mm/loader/g/a/b:hiM	Ljava/util/concurrent/locks/Condition;
    //   24: invokeinterface 53 1 0
    //   29: goto -16 -> 13
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 58	java/lang/Thread:interrupt	()V
    //   37: ldc 60
    //   39: ldc 62
    //   41: iconst_1
    //   42: anewarray 64	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_2
    //   48: invokevirtual 68	java/lang/Exception:toString	()Ljava/lang/String;
    //   51: aastore
    //   52: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: getfield 26	com/tencent/mm/loader/g/a/b:hiL	Ljava/util/concurrent/locks/ReentrantLock;
    //   59: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   62: return
    //   63: aload_0
    //   64: getfield 26	com/tencent/mm/loader/g/a/b:hiL	Ljava/util/concurrent/locks/ReentrantLock;
    //   67: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 26	com/tencent/mm/loader/g/a/b:hiL	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.b
 * JD-Core Version:    0.7.0.1
 */