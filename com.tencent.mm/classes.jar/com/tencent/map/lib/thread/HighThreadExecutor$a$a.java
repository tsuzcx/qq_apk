package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HighThreadExecutor$a$a
  implements Iterator<E>
{
  private HighThreadExecutor.a<E>.b<E> b;
  private HighThreadExecutor.a<E>.b<E> c;
  private E d;
  
  HighThreadExecutor$a$a(HighThreadExecutor.a parama)
  {
    AppMethodBeat.i(98179);
    HighThreadExecutor.a.a(parama);
    try
    {
      this.b = parama.a.b;
      if (this.b != null) {
        this.d = this.b.a;
      }
      return;
    }
    finally
    {
      parama.a();
      AppMethodBeat.o(98179);
    }
  }
  
  private HighThreadExecutor.a<E>.b<E> a(HighThreadExecutor.a<E>.b<E> parama)
  {
    HighThreadExecutor.a.b localb;
    do
    {
      localb = parama.b;
      if (localb == null) {
        break;
      }
      parama = localb;
    } while (localb.a == null);
    return localb;
  }
  
  public boolean hasNext()
  {
    return this.b != null;
  }
  
  public E next()
  {
    AppMethodBeat.i(98180);
    HighThreadExecutor.a.a(this.a);
    try
    {
      if (this.b == null)
      {
        NoSuchElementException localNoSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(98180);
        throw localNoSuchElementException;
      }
    }
    finally
    {
      this.a.a();
      AppMethodBeat.o(98180);
    }
    Object localObject3 = this.d;
    this.c = this.b;
    this.b = a(this.b);
    if (this.b == null) {}
    for (Object localObject2 = null;; localObject2 = this.b.a)
    {
      this.d = localObject2;
      this.a.a();
      AppMethodBeat.o(98180);
      return localObject3;
    }
  }
  
  /* Error */
  public void remove()
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   9: invokestatic 34	com/tencent/map/lib/thread/HighThreadExecutor$a:a	(Lcom/tencent/map/lib/thread/HighThreadExecutor$a;)V
    //   12: aload_0
    //   13: getfield 64	com/tencent/map/lib/thread/HighThreadExecutor$a$a:c	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   16: astore 4
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 64	com/tencent/map/lib/thread/HighThreadExecutor$a$a:c	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   23: aload_0
    //   24: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   27: getfield 36	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   30: astore_2
    //   31: aload_2
    //   32: getfield 40	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +18 -> 55
    //   40: aload_1
    //   41: aload 4
    //   43: if_acmpne +25 -> 68
    //   46: aload_0
    //   47: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 72	com/tencent/map/lib/thread/HighThreadExecutor$a:a	(Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;)V
    //   55: aload_0
    //   56: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   59: invokevirtual 47	com/tencent/map/lib/thread/HighThreadExecutor$a:a	()V
    //   62: ldc 69
    //   64: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: return
    //   68: aload_1
    //   69: getfield 40	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   72: astore_3
    //   73: aload_1
    //   74: astore_2
    //   75: aload_3
    //   76: astore_1
    //   77: goto -41 -> 36
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   85: invokevirtual 47	com/tencent/map/lib/thread/HighThreadExecutor$a:a	()V
    //   88: ldc 69
    //   90: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	a
    //   35	42	1	localObject1	Object
    //   80	14	1	localObject2	Object
    //   30	45	2	localObject3	Object
    //   72	4	3	localb1	HighThreadExecutor.a.b
    //   16	26	4	localb2	HighThreadExecutor.a.b
    // Exception table:
    //   from	to	target	type
    //   12	36	80	finally
    //   46	55	80	finally
    //   68	73	80	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor.a.a
 * JD-Core Version:    0.7.0.1
 */