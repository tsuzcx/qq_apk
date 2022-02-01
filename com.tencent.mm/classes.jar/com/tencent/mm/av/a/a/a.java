package com.tencent.mm.av.a.a;

import com.tencent.e.b;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  public static Executor aJi()
  {
    AppMethodBeat.i(182800);
    b localb = h.MqF.bbd("image_loader_ImageTempFile");
    AppMethodBeat.o(182800);
    return localb;
  }
  
  public static j pH(int paramInt)
  {
    AppMethodBeat.i(182799);
    a locala = new a("image_loader_default", paramInt, paramInt, new com.tencent.mm.av.a.e.a());
    AppMethodBeat.o(182799);
    return locala;
  }
  
  static final class a
    extends b
    implements j
  {
    private ReentrantLock hiL;
    private Condition hiM;
    private BlockingQueue<Runnable> hiN;
    private boolean isPaused;
    
    public a(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
    {
      super(paramInt1, paramInt2, paramBlockingQueue, null);
      AppMethodBeat.i(182797);
      this.hiL = new ReentrantLock();
      this.hiM = this.hiL.newCondition();
      this.hiN = paramBlockingQueue;
      AppMethodBeat.o(182797);
    }
    
    public final boolean OG()
    {
      return this.isPaused;
    }
    
    public final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      AppMethodBeat.i(182798);
      super.afterExecute(paramRunnable, paramThrowable);
      AppMethodBeat.o(182798);
    }
    
    /* Error */
    public final void beforeExecute(java.lang.Thread paramThread, Runnable paramRunnable)
    {
      // Byte code:
      //   0: ldc 65
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: aload_1
      //   7: aload_2
      //   8: invokespecial 67	com/tencent/e/b:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
      //   11: aload_0
      //   12: getfield 37	com/tencent/mm/av/a/a/a$a:hiL	Ljava/util/concurrent/locks/ReentrantLock;
      //   15: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: getfield 55	com/tencent/mm/av/a/a/a$a:isPaused	Z
      //   22: ifeq +51 -> 73
      //   25: aload_0
      //   26: getfield 43	com/tencent/mm/av/a/a/a$a:hiM	Ljava/util/concurrent/locks/Condition;
      //   29: invokeinterface 75 1 0
      //   34: goto -16 -> 18
      //   37: astore_2
      //   38: aload_1
      //   39: invokevirtual 80	java/lang/Thread:interrupt	()V
      //   42: ldc 82
      //   44: ldc 84
      //   46: iconst_1
      //   47: anewarray 86	java/lang/Object
      //   50: dup
      //   51: iconst_0
      //   52: aload_2
      //   53: invokevirtual 90	java/lang/Exception:toString	()Ljava/lang/String;
      //   56: aastore
      //   57: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   60: aload_0
      //   61: getfield 37	com/tencent/mm/av/a/a/a$a:hiL	Ljava/util/concurrent/locks/ReentrantLock;
      //   64: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   67: ldc 65
      //   69: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   72: return
      //   73: aload_0
      //   74: getfield 37	com/tencent/mm/av/a/a/a$a:hiL	Ljava/util/concurrent/locks/ReentrantLock;
      //   77: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   80: ldc 65
      //   82: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: return
      //   86: astore_1
      //   87: aload_0
      //   88: getfield 37	com/tencent/mm/av/a/a/a$a:hiL	Ljava/util/concurrent/locks/ReentrantLock;
      //   91: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   94: ldc 65
      //   96: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(130381);
      super.execute(paramRunnable);
      AppMethodBeat.o(130381);
    }
    
    public final boolean isShutdown()
    {
      AppMethodBeat.i(130383);
      boolean bool = super.isShutdown();
      AppMethodBeat.o(130383);
      return bool;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(130379);
      this.hiL.lock();
      try
      {
        this.isPaused = true;
        return;
      }
      finally
      {
        this.hiL.unlock();
        AppMethodBeat.o(130379);
      }
    }
    
    public final void remove(Object paramObject)
    {
      AppMethodBeat.i(130382);
      if (this.hiN != null) {
        this.hiN.remove(paramObject);
      }
      AppMethodBeat.o(130382);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(130380);
      this.hiL.lock();
      try
      {
        this.isPaused = false;
        this.hiM.signalAll();
        return;
      }
      finally
      {
        this.hiL.unlock();
        AppMethodBeat.o(130380);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.a.a.a
 * JD-Core Version:    0.7.0.1
 */