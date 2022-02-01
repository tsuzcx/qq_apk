package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b
{
  public final int pcL;
  public final int pcM;
  public final Executor pcN;
  
  public b(a parama)
  {
    this.pcL = parama.pcL;
    this.pcM = parama.pcM;
    this.pcN = parama.pcN;
  }
  
  public static final class a
  {
    int pcL;
    int pcM;
    Executor pcN;
  }
  
  public static final class b
    extends com.tencent.e.b
    implements j
  {
    private ReentrantLock gMa;
    private boolean isPaused;
    private Condition pcO;
    
    public b(int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
    {
      super(paramInt1, paramInt2, paramBlockingQueue);
      AppMethodBeat.i(108747);
      this.gMa = new ReentrantLock();
      this.pcO = this.gMa.newCondition();
      AppMethodBeat.o(108747);
    }
    
    public final boolean MZ()
    {
      return this.isPaused;
    }
    
    /* Error */
    public final void beforeExecute(java.lang.Thread paramThread, Runnable paramRunnable)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: aload_1
      //   7: aload_2
      //   8: invokespecial 59	com/tencent/e/b:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
      //   11: aload_0
      //   12: getfield 36	com/tencent/mm/plugin/emoji/sync/b$b:gMa	Ljava/util/concurrent/locks/ReentrantLock;
      //   15: invokevirtual 62	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: getfield 52	com/tencent/mm/plugin/emoji/sync/b$b:isPaused	Z
      //   22: ifeq +51 -> 73
      //   25: aload_0
      //   26: getfield 42	com/tencent/mm/plugin/emoji/sync/b$b:pcO	Ljava/util/concurrent/locks/Condition;
      //   29: invokeinterface 67 1 0
      //   34: goto -16 -> 18
      //   37: astore_2
      //   38: aload_1
      //   39: invokevirtual 72	java/lang/Thread:interrupt	()V
      //   42: ldc 74
      //   44: ldc 76
      //   46: iconst_1
      //   47: anewarray 78	java/lang/Object
      //   50: dup
      //   51: iconst_0
      //   52: aload_2
      //   53: invokevirtual 82	java/lang/Exception:toString	()Ljava/lang/String;
      //   56: aastore
      //   57: invokestatic 88	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   60: aload_0
      //   61: getfield 36	com/tencent/mm/plugin/emoji/sync/b$b:gMa	Ljava/util/concurrent/locks/ReentrantLock;
      //   64: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   67: ldc 57
      //   69: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   72: return
      //   73: aload_0
      //   74: getfield 36	com/tencent/mm/plugin/emoji/sync/b$b:gMa	Ljava/util/concurrent/locks/ReentrantLock;
      //   77: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   80: ldc 57
      //   82: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: return
      //   86: astore_1
      //   87: aload_0
      //   88: getfield 36	com/tencent/mm/plugin/emoji/sync/b$b:gMa	Ljava/util/concurrent/locks/ReentrantLock;
      //   91: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   94: ldc 57
      //   96: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	b
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
      AppMethodBeat.i(108751);
      super.execute(paramRunnable);
      AppMethodBeat.o(108751);
    }
    
    public final boolean isShutdown()
    {
      AppMethodBeat.i(108752);
      boolean bool = super.isShutdown();
      AppMethodBeat.o(108752);
      return bool;
    }
    
    public final void pause()
    {
      AppMethodBeat.i(108749);
      this.gMa.lock();
      try
      {
        this.isPaused = true;
        return;
      }
      finally
      {
        this.gMa.unlock();
        AppMethodBeat.o(108749);
      }
    }
    
    public final void remove(Object paramObject) {}
    
    public final void resume()
    {
      AppMethodBeat.i(108750);
      this.gMa.lock();
      try
      {
        this.isPaused = false;
        this.pcO.signalAll();
        return;
      }
      finally
      {
        this.gMa.unlock();
        AppMethodBeat.o(108750);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */