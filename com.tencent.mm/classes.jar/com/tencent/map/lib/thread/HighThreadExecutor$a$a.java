package com.tencent.map.lib.thread;

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
    HighThreadExecutor.a.a(this.a);
    try
    {
      if (this.b == null) {
        throw new NoSuchElementException();
      }
    }
    finally
    {
      this.a.a();
    }
    Object localObject3 = this.d;
    this.c = this.b;
    this.b = a(this.b);
    if (this.b == null) {}
    for (Object localObject2 = null;; localObject2 = this.b.a)
    {
      this.d = localObject2;
      this.a.a();
      return localObject3;
    }
  }
  
  /* Error */
  public void remove()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   4: invokestatic 27	com/tencent/map/lib/thread/HighThreadExecutor$a:a	(Lcom/tencent/map/lib/thread/HighThreadExecutor$a;)V
    //   7: aload_0
    //   8: getfield 53	com/tencent/map/lib/thread/HighThreadExecutor$a$a:c	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   11: astore 4
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield 53	com/tencent/map/lib/thread/HighThreadExecutor$a$a:c	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   18: aload_0
    //   19: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   22: getfield 29	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   25: astore_2
    //   26: aload_2
    //   27: getfield 33	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +18 -> 50
    //   35: aload_1
    //   36: aload 4
    //   38: if_acmpne +20 -> 58
    //   41: aload_0
    //   42: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 60	com/tencent/map/lib/thread/HighThreadExecutor$a:a	(Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;)V
    //   50: aload_0
    //   51: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   54: invokevirtual 40	com/tencent/map/lib/thread/HighThreadExecutor$a:a	()V
    //   57: return
    //   58: aload_1
    //   59: getfield 33	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload_3
    //   66: astore_1
    //   67: goto -36 -> 31
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 22	com/tencent/map/lib/thread/HighThreadExecutor$a$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a;
    //   75: invokevirtual 40	com/tencent/map/lib/thread/HighThreadExecutor$a:a	()V
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	a
    //   30	37	1	localObject1	Object
    //   70	9	1	localObject2	Object
    //   25	40	2	localObject3	Object
    //   62	4	3	localb1	HighThreadExecutor.a.b
    //   11	26	4	localb2	HighThreadExecutor.a.b
    // Exception table:
    //   from	to	target	type
    //   7	31	70	finally
    //   41	50	70	finally
    //   58	63	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor.a.a
 * JD-Core Version:    0.7.0.1
 */