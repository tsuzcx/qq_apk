package com.tencent.map.lib.thread;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class HighThreadExecutor$a<E>
  extends AbstractQueue<E>
  implements Serializable, BlockingQueue<E>
{
  transient a<E>.b<E> a;
  private int c;
  private final AtomicInteger d = new AtomicInteger();
  private final ReentrantLock e = new ReentrantLock();
  private final Condition f = this.e.newCondition();
  private final ReentrantLock g = new ReentrantLock();
  private final Condition h = this.g.newCondition();
  
  public HighThreadExecutor$a(HighThreadExecutor paramHighThreadExecutor, int paramInt)
  {
    this.c = paramInt;
    this.a = new b(null);
  }
  
  private void a(a<E>.b<E> parama)
  {
    parama.b = this.a.b;
    this.a.b = parama;
  }
  
  private E b()
  {
    b localb = this.a.b;
    if (localb != null)
    {
      this.a.b = localb.b;
      localb.b = null;
      Object localObject = localb.a;
      localb.a = null;
      return localObject;
    }
    return null;
  }
  
  private void c()
  {
    this.g.lock();
    this.e.lock();
  }
  
  private void d()
  {
    ReentrantLock localReentrantLock = this.g;
    localReentrantLock.lock();
    try
    {
      this.h.signal();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private void e()
  {
    ReentrantLock localReentrantLock = this.e;
    localReentrantLock.lock();
    try
    {
      this.f.signal();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  void a()
  {
    this.e.unlock();
    this.g.unlock();
  }
  
  void a(a<E>.b<E> parama1, a<E>.b<E> parama2)
  {
    parama1.a = null;
    parama2.b = parama1.b;
    if (this.d.getAndDecrement() == this.c) {
      this.h.signal();
    }
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }
  
  /* Error */
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_1
    //   6: ifnonnull +11 -> 17
    //   9: new 104	java/lang/NullPointerException
    //   12: dup
    //   13: invokespecial 105	java/lang/NullPointerException:<init>	()V
    //   16: athrow
    //   17: aload_1
    //   18: aload_0
    //   19: if_acmpne +11 -> 30
    //   22: new 107	java/lang/IllegalArgumentException
    //   25: dup
    //   26: invokespecial 108	java/lang/IllegalArgumentException:<init>	()V
    //   29: athrow
    //   30: iload_2
    //   31: ifgt +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 47	com/tencent/map/lib/thread/HighThreadExecutor$a:e	Ljava/util/concurrent/locks/ReentrantLock;
    //   40: astore 8
    //   42: aload 8
    //   44: invokevirtual 81	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   47: iload_2
    //   48: aload_0
    //   49: getfield 42	com/tencent/map/lib/thread/HighThreadExecutor$a:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   52: invokevirtual 111	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   55: invokestatic 117	java/lang/Math:min	(II)I
    //   58: istore 5
    //   60: aload_0
    //   61: getfield 64	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   64: astore 6
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: iload 5
    //   71: if_icmpge +46 -> 117
    //   74: aload 6
    //   76: getfield 68	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   79: astore 7
    //   81: aload_1
    //   82: aload 7
    //   84: getfield 77	com/tencent/map/lib/thread/HighThreadExecutor$a$b:a	Ljava/lang/Object;
    //   87: invokeinterface 123 2 0
    //   92: pop
    //   93: aload 7
    //   95: aconst_null
    //   96: putfield 77	com/tencent/map/lib/thread/HighThreadExecutor$a$b:a	Ljava/lang/Object;
    //   99: aload 6
    //   101: aload 6
    //   103: putfield 68	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: aload 7
    //   112: astore 6
    //   114: goto -46 -> 68
    //   117: iload_2
    //   118: ifle +122 -> 240
    //   121: aload_0
    //   122: aload 6
    //   124: putfield 64	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   127: aload_0
    //   128: getfield 42	com/tencent/map/lib/thread/HighThreadExecutor$a:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   131: iload_2
    //   132: ineg
    //   133: invokevirtual 127	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   136: istore_2
    //   137: aload_0
    //   138: getfield 59	com/tencent/map/lib/thread/HighThreadExecutor$a:c	I
    //   141: istore 4
    //   143: iload_2
    //   144: iload 4
    //   146: if_icmpne +21 -> 167
    //   149: iload_3
    //   150: istore_2
    //   151: aload 8
    //   153: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   156: iload_2
    //   157: ifeq +7 -> 164
    //   160: aload_0
    //   161: invokespecial 129	com/tencent/map/lib/thread/HighThreadExecutor$a:d	()V
    //   164: iload 5
    //   166: ireturn
    //   167: iconst_0
    //   168: istore_2
    //   169: goto -18 -> 151
    //   172: astore_1
    //   173: iload_2
    //   174: ifle +61 -> 235
    //   177: aload_0
    //   178: aload 6
    //   180: putfield 64	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   183: aload_0
    //   184: getfield 42	com/tencent/map/lib/thread/HighThreadExecutor$a:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   187: iload_2
    //   188: ineg
    //   189: invokevirtual 127	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   192: istore_2
    //   193: aload_0
    //   194: getfield 59	com/tencent/map/lib/thread/HighThreadExecutor$a:c	I
    //   197: istore_3
    //   198: iload_2
    //   199: iload_3
    //   200: if_icmpne +24 -> 224
    //   203: iload 4
    //   205: istore_2
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: aload 8
    //   211: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   214: iload_2
    //   215: ifeq +7 -> 222
    //   218: aload_0
    //   219: invokespecial 129	com/tencent/map/lib/thread/HighThreadExecutor$a:d	()V
    //   222: aload_1
    //   223: athrow
    //   224: iconst_0
    //   225: istore_2
    //   226: goto -20 -> 206
    //   229: astore_1
    //   230: iconst_0
    //   231: istore_2
    //   232: goto -23 -> 209
    //   235: iconst_0
    //   236: istore_2
    //   237: goto -31 -> 206
    //   240: iconst_0
    //   241: istore_2
    //   242: goto -91 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	a
    //   0	245	1	paramCollection	Collection<? super E>
    //   0	245	2	paramInt	int
    //   4	197	3	i	int
    //   1	203	4	j	int
    //   58	107	5	k	int
    //   64	115	6	localObject	Object
    //   79	32	7	localb	b
    //   40	170	8	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   74	106	172	finally
    //   206	208	208	finally
    //   47	66	229	finally
    //   121	143	229	finally
    //   177	198	229	finally
  }
  
  public Iterator<E> iterator()
  {
    return new HighThreadExecutor.a.a(this);
  }
  
  public boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    AtomicInteger localAtomicInteger = this.d;
    if (localAtomicInteger.get() == this.c) {
      return false;
    }
    int i = -1;
    b localb = new b(paramE);
    paramE = this.g;
    paramE.lock();
    try
    {
      if (localAtomicInteger.get() < this.c)
      {
        a(localb);
        int j = localAtomicInteger.getAndIncrement();
        i = j;
        if (j + 1 < this.c)
        {
          this.h.signal();
          i = j;
        }
      }
      paramE.unlock();
      if (i == 0) {
        e();
      }
      if (i >= 0) {
        return true;
      }
    }
    finally
    {
      paramE.unlock();
    }
    return false;
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.g;
    AtomicInteger localAtomicInteger = this.d;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        i = localAtomicInteger.get();
        int j = this.c;
        if (i != j) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.h.awaitNanos(paramLong);
      }
      a(new b(paramE));
      int i = localAtomicInteger.getAndIncrement();
      if (i + 1 < this.c) {
        this.h.signal();
      }
      paramTimeUnit.unlock();
      if (i == 0) {
        e();
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E peek()
  {
    if (this.d.get() == 0) {
      return null;
    }
    ReentrantLock localReentrantLock = this.e;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = this.a.b;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((b)localObject1).a;
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E poll()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    AtomicInteger localAtomicInteger = this.d;
    if (localAtomicInteger.get() == 0) {}
    for (;;)
    {
      return localObject3;
      int i = -1;
      ReentrantLock localReentrantLock = this.e;
      localReentrantLock.lock();
      try
      {
        if (localAtomicInteger.get() > 0)
        {
          localObject3 = b();
          int j = localAtomicInteger.getAndDecrement();
          i = j;
          localObject1 = localObject3;
          if (j > 1)
          {
            this.f.signal();
            localObject1 = localObject3;
            i = j;
          }
        }
        localReentrantLock.unlock();
        localObject3 = localObject1;
        if (i != this.c) {
          continue;
        }
        d();
        return localObject1;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    AtomicInteger localAtomicInteger = this.d;
    paramTimeUnit = this.e;
    paramTimeUnit.lockInterruptibly();
    try
    {
      int i = localAtomicInteger.get();
      if (i == 0) {
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          paramTimeUnit = null;
        }
      }
      Object localObject1;
      do
      {
        return paramTimeUnit;
        paramLong = this.f.awaitNanos(paramLong);
        break;
        localObject1 = b();
        i = localAtomicInteger.getAndDecrement();
        if (i > 1) {
          this.f.signal();
        }
        paramTimeUnit.unlock();
        paramTimeUnit = localObject1;
      } while (i != this.c);
      d();
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public void put(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    b localb1 = new b(paramE);
    paramE = this.g;
    AtomicInteger localAtomicInteger = this.d;
    paramE.lockInterruptibly();
    try
    {
      while (localAtomicInteger.get() == this.c) {
        this.h.await();
      }
      a(localb2);
    }
    finally
    {
      paramE.unlock();
    }
    int i = localAtomicInteger.getAndIncrement();
    if (i + 1 < this.c) {
      this.h.signal();
    }
    paramE.unlock();
    if (i == 0) {
      e();
    }
  }
  
  public int remainingCapacity()
  {
    return this.c - this.d.get();
  }
  
  public int size()
  {
    return this.d.get();
  }
  
  public E take()
  {
    AtomicInteger localAtomicInteger = this.d;
    ReentrantLock localReentrantLock = this.e;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (localAtomicInteger.get() == 0) {
        this.f.await();
      }
      localObject2 = b();
    }
    finally
    {
      localReentrantLock.unlock();
    }
    Object localObject2;
    int i = localObject1.getAndDecrement();
    if (i > 1) {
      this.f.signal();
    }
    localReentrantLock.unlock();
    if (i == this.c) {
      d();
    }
    return localObject2;
  }
  
  class b<E>
  {
    E a;
    HighThreadExecutor.a<E>.b<E> b;
    
    b()
    {
      Object localObject;
      this.a = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor.a
 * JD-Core Version:    0.7.0.1
 */