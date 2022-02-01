package com.tencent.e.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a
  extends e
{
  private final Condition LUG;
  private ReentrantLock cPz;
  
  public a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(183322);
    this.cPz = new ReentrantLock();
    this.LUG = this.cPz.newCondition();
    AppMethodBeat.o(183322);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(183323);
    super.a(paramg);
    try
    {
      this.cPz.lock();
      this.LUG.signal();
      return;
    }
    finally
    {
      this.cPz.unlock();
      AppMethodBeat.o(183323);
    }
  }
  
  /* Error */
  public final void b(g paramg)
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 58	com/tencent/e/g/e:b	(Lcom/tencent/e/g/g;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 62	com/tencent/e/g/a:c	(Lcom/tencent/e/g/g;)Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifne +51 -> 68
    //   20: aload_0
    //   21: getfield 26	com/tencent/e/g/a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
    //   24: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   27: aload_0
    //   28: getfield 32	com/tencent/e/g/a:LUG	Ljava/util/concurrent/locks/Condition;
    //   31: invokeinterface 65 1 0
    //   36: aload_0
    //   37: getfield 26	com/tencent/e/g/a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
    //   40: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: goto -33 -> 10
    //   46: astore_1
    //   47: ldc 56
    //   49: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 26	com/tencent/e/g/a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
    //   58: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: ldc 56
    //   63: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: ldc 56
    //   70: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramg	g
    //   15	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	16	46	java/lang/InterruptedException
    //   36	43	46	java/lang/InterruptedException
    //   54	68	46	java/lang/InterruptedException
    //   20	36	53	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.a
 * JD-Core Version:    0.7.0.1
 */