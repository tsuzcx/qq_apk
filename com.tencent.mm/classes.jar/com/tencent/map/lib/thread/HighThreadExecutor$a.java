package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private final AtomicInteger d;
  private final ReentrantLock e;
  private final Condition f;
  private final ReentrantLock g;
  private final Condition h;
  
  public HighThreadExecutor$a(HighThreadExecutor paramHighThreadExecutor, int paramInt)
  {
    AppMethodBeat.i(98182);
    this.d = new AtomicInteger();
    this.e = new ReentrantLock();
    this.f = this.e.newCondition();
    this.g = new ReentrantLock();
    this.h = this.g.newCondition();
    this.c = paramInt;
    this.a = new b(null);
    AppMethodBeat.o(98182);
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
    AppMethodBeat.i(98195);
    this.g.lock();
    this.e.lock();
    AppMethodBeat.o(98195);
  }
  
  private void d()
  {
    AppMethodBeat.i(98198);
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
      AppMethodBeat.o(98198);
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(98199);
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
      AppMethodBeat.o(98199);
    }
  }
  
  void a()
  {
    AppMethodBeat.i(98196);
    this.e.unlock();
    this.g.unlock();
    AppMethodBeat.o(98196);
  }
  
  void a(a<E>.b<E> parama1, a<E>.b<E> parama2)
  {
    AppMethodBeat.i(98197);
    parama1.a = null;
    parama2.b = parama1.b;
    if (this.d.getAndDecrement() == this.c) {
      this.h.signal();
    }
    AppMethodBeat.o(98197);
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    AppMethodBeat.i(98185);
    int i = drainTo(paramCollection, 2147483647);
    AppMethodBeat.o(98185);
    return i;
  }
  
  /* Error */
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 8
    //   12: ldc 120
    //   14: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   17: aload_1
    //   18: ifnonnull +18 -> 36
    //   21: new 122	java/lang/NullPointerException
    //   24: dup
    //   25: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   28: astore_1
    //   29: ldc 120
    //   31: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: athrow
    //   36: aload_1
    //   37: aload_0
    //   38: if_acmpne +18 -> 56
    //   41: new 125	java/lang/IllegalArgumentException
    //   44: dup
    //   45: invokespecial 126	java/lang/IllegalArgumentException:<init>	()V
    //   48: astore_1
    //   49: ldc 120
    //   51: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    //   56: iload_2
    //   57: ifgt +10 -> 67
    //   60: ldc 120
    //   62: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: iconst_0
    //   66: ireturn
    //   67: aload_0
    //   68: getfield 54	com/tencent/map/lib/thread/HighThreadExecutor$a:e	Ljava/util/concurrent/locks/ReentrantLock;
    //   71: astore 12
    //   73: aload 12
    //   75: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   78: iload 6
    //   80: istore_3
    //   81: iload_2
    //   82: aload_0
    //   83: getfield 49	com/tencent/map/lib/thread/HighThreadExecutor$a:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   86: invokevirtual 129	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   89: invokestatic 135	java/lang/Math:min	(II)I
    //   92: istore 9
    //   94: iload 6
    //   96: istore_3
    //   97: aload_0
    //   98: getfield 71	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   101: astore 10
    //   103: iconst_0
    //   104: istore 4
    //   106: iload 4
    //   108: iload 9
    //   110: if_icmpge +48 -> 158
    //   113: aload 10
    //   115: getfield 78	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   118: astore 11
    //   120: aload_1
    //   121: aload 11
    //   123: getfield 88	com/tencent/map/lib/thread/HighThreadExecutor$a$b:a	Ljava/lang/Object;
    //   126: invokeinterface 141 2 0
    //   131: pop
    //   132: aload 11
    //   134: aconst_null
    //   135: putfield 88	com/tencent/map/lib/thread/HighThreadExecutor$a$b:a	Ljava/lang/Object;
    //   138: aload 10
    //   140: aload 10
    //   142: putfield 78	com/tencent/map/lib/thread/HighThreadExecutor$a$b:b	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   145: iload 4
    //   147: iconst_1
    //   148: iadd
    //   149: istore 4
    //   151: aload 11
    //   153: astore 10
    //   155: goto -49 -> 106
    //   158: iload 4
    //   160: ifle +151 -> 311
    //   163: iload 6
    //   165: istore_3
    //   166: aload_0
    //   167: aload 10
    //   169: putfield 71	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   172: iload 6
    //   174: istore_3
    //   175: aload_0
    //   176: getfield 49	com/tencent/map/lib/thread/HighThreadExecutor$a:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   179: iload 4
    //   181: ineg
    //   182: invokevirtual 145	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   185: istore_2
    //   186: iload 6
    //   188: istore_3
    //   189: aload_0
    //   190: getfield 66	com/tencent/map/lib/thread/HighThreadExecutor$a:c	I
    //   193: istore 4
    //   195: iload_2
    //   196: iload 4
    //   198: if_icmpne +27 -> 225
    //   201: iload 5
    //   203: istore_2
    //   204: aload 12
    //   206: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   209: iload_2
    //   210: ifeq +7 -> 217
    //   213: aload_0
    //   214: invokespecial 147	com/tencent/map/lib/thread/HighThreadExecutor$a:d	()V
    //   217: ldc 120
    //   219: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iload 9
    //   224: ireturn
    //   225: iconst_0
    //   226: istore_2
    //   227: goto -23 -> 204
    //   230: astore_1
    //   231: iload 8
    //   233: istore_2
    //   234: iload 4
    //   236: ifle +38 -> 274
    //   239: iload 6
    //   241: istore_3
    //   242: aload_0
    //   243: aload 10
    //   245: putfield 71	com/tencent/map/lib/thread/HighThreadExecutor$a:a	Lcom/tencent/map/lib/thread/HighThreadExecutor$a$b;
    //   248: iload 6
    //   250: istore_3
    //   251: aload_0
    //   252: getfield 49	com/tencent/map/lib/thread/HighThreadExecutor$a:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   255: iload 4
    //   257: ineg
    //   258: invokevirtual 145	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   261: aload_0
    //   262: getfield 66	com/tencent/map/lib/thread/HighThreadExecutor$a:c	I
    //   265: if_icmpne +41 -> 306
    //   268: iload 7
    //   270: istore_2
    //   271: goto +45 -> 316
    //   274: iload_2
    //   275: istore_3
    //   276: ldc 120
    //   278: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: iload_2
    //   282: istore_3
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload 12
    //   288: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   291: iload_3
    //   292: ifeq +7 -> 299
    //   295: aload_0
    //   296: invokespecial 147	com/tencent/map/lib/thread/HighThreadExecutor$a:d	()V
    //   299: ldc 120
    //   301: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_1
    //   305: athrow
    //   306: iconst_0
    //   307: istore_2
    //   308: goto +8 -> 316
    //   311: iconst_0
    //   312: istore_2
    //   313: goto -109 -> 204
    //   316: goto -42 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	a
    //   0	319	1	paramCollection	Collection<? super E>
    //   0	319	2	paramInt	int
    //   80	212	3	i	int
    //   104	152	4	j	int
    //   4	198	5	k	int
    //   7	242	6	m	int
    //   1	268	7	n	int
    //   10	222	8	i1	int
    //   92	131	9	i2	int
    //   101	143	10	localObject	Object
    //   118	34	11	localb	b
    //   71	216	12	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   113	145	230	finally
    //   81	94	285	finally
    //   97	103	285	finally
    //   166	172	285	finally
    //   175	186	285	finally
    //   189	195	285	finally
    //   242	248	285	finally
    //   251	268	285	finally
    //   276	281	285	finally
    //   283	285	285	finally
  }
  
  public Iterator<E> iterator()
  {
    AppMethodBeat.i(98183);
    HighThreadExecutor.a.a locala = new HighThreadExecutor.a.a(this);
    AppMethodBeat.o(98183);
    return locala;
  }
  
  public boolean offer(E paramE)
  {
    AppMethodBeat.i(98187);
    if (paramE == null)
    {
      paramE = new NullPointerException();
      AppMethodBeat.o(98187);
      throw paramE;
    }
    AtomicInteger localAtomicInteger = this.d;
    if (localAtomicInteger.get() == this.c)
    {
      AppMethodBeat.o(98187);
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
      if (i >= 0)
      {
        AppMethodBeat.o(98187);
        return true;
      }
    }
    finally
    {
      paramE.unlock();
      AppMethodBeat.o(98187);
    }
    AppMethodBeat.o(98187);
    return false;
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(98188);
    if (paramE == null)
    {
      paramE = new NullPointerException();
      AppMethodBeat.o(98188);
      throw paramE;
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
      AppMethodBeat.o(98188);
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
      AppMethodBeat.o(98188);
    }
  }
  
  public E peek()
  {
    AppMethodBeat.i(98193);
    if (this.d.get() == 0)
    {
      AppMethodBeat.o(98193);
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
      AppMethodBeat.o(98193);
    }
  }
  
  public E poll()
  {
    Object localObject1 = null;
    AppMethodBeat.i(98194);
    AtomicInteger localAtomicInteger = this.d;
    if (localAtomicInteger.get() == 0)
    {
      AppMethodBeat.o(98194);
      return null;
    }
    int i = -1;
    ReentrantLock localReentrantLock = this.e;
    localReentrantLock.lock();
    try
    {
      if (localAtomicInteger.get() > 0)
      {
        Object localObject3 = b();
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
      if (i == this.c) {
        d();
      }
      AppMethodBeat.o(98194);
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(98194);
    }
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(98189);
    paramLong = paramTimeUnit.toNanos(paramLong);
    AtomicInteger localAtomicInteger = this.d;
    paramTimeUnit = this.e;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        i = localAtomicInteger.get();
        if (i != 0) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.f.awaitNanos(paramLong);
      }
      Object localObject2 = b();
      int i = localAtomicInteger.getAndDecrement();
      if (i > 1) {
        this.f.signal();
      }
      paramTimeUnit.unlock();
      if (i == this.c) {
        d();
      }
      AppMethodBeat.o(98189);
      return localObject2;
    }
    finally
    {
      paramTimeUnit.unlock();
      AppMethodBeat.o(98189);
    }
  }
  
  public void put(E paramE)
  {
    AppMethodBeat.i(98190);
    if (paramE == null)
    {
      paramE = new NullPointerException();
      AppMethodBeat.o(98190);
      throw paramE;
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
      AppMethodBeat.o(98190);
    }
    int i = localAtomicInteger.getAndIncrement();
    if (i + 1 < this.c) {
      this.h.signal();
    }
    paramE.unlock();
    if (i == 0) {
      e();
    }
    AppMethodBeat.o(98190);
  }
  
  public int remainingCapacity()
  {
    AppMethodBeat.i(98191);
    int i = this.c;
    int j = this.d.get();
    AppMethodBeat.o(98191);
    return i - j;
  }
  
  public int size()
  {
    AppMethodBeat.i(98184);
    int i = this.d.get();
    AppMethodBeat.o(98184);
    return i;
  }
  
  public E take()
  {
    AppMethodBeat.i(98192);
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
      AppMethodBeat.o(98192);
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
    AppMethodBeat.o(98192);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.thread.HighThreadExecutor.a
 * JD-Core Version:    0.7.0.1
 */