package com.tencent.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b
  extends AbstractExecutorService
{
  public static ConcurrentLinkedQueue<WeakReference<b>> JZl;
  private static final e JZw;
  public final AtomicInteger JZk;
  private final BlockingQueue<Runnable> JZm;
  private final HashSet<b> JZn;
  private final LinkedList<b> JZo;
  private final Condition JZp;
  private int JZq;
  private long JZr;
  private volatile ThreadFactory JZs;
  private volatile e JZt;
  private volatile long JZu;
  private volatile int JZv;
  private volatile int cSv;
  private volatile String name;
  private final ReentrantLock rwa;
  
  static
  {
    AppMethodBeat.i(183133);
    JZl = new ConcurrentLinkedQueue();
    JZw = new a();
    AppMethodBeat.o(183133);
  }
  
  public b(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this(paramString, paramInt1, paramInt2, paramBlockingQueue, null);
  }
  
  public b(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue, e parame) {}
  
  @Deprecated
  private b(String paramString, int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, e parame)
  {
    this(paramString, paramInt1, paramInt2, paramTimeUnit, paramBlockingQueue, Executors.defaultThreadFactory(), parame);
    AppMethodBeat.i(183120);
    AppMethodBeat.o(183120);
  }
  
  private b(String paramString, int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory, e parame)
  {
    AppMethodBeat.i(183121);
    this.JZk = new AtomicInteger(-536870912);
    this.rwa = new ReentrantLock();
    this.JZn = new HashSet();
    this.JZo = new LinkedList();
    this.JZp = this.rwa.newCondition();
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt2 < paramInt1) || (9223372036854775807L < 0L))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(183121);
      throw paramString;
    }
    if ((paramBlockingQueue == null) || (paramThreadFactory == null) || (parame == null))
    {
      paramString = new NullPointerException();
      AppMethodBeat.o(183121);
      throw paramString;
    }
    this.cSv = paramInt1;
    this.JZv = paramInt2;
    this.JZm = paramBlockingQueue;
    this.JZu = paramTimeUnit.toNanos(9223372036854775807L);
    this.JZs = paramThreadFactory;
    this.JZt = parame;
    this.name = paramString;
    AppMethodBeat.o(183121);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(183115);
    ReentrantLock localReentrantLock = this.rwa;
    localReentrantLock.lock();
    if (paramb != null) {}
    try
    {
      this.JZn.remove(paramb);
      fDX();
      fDY();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183115);
    }
  }
  
  private void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(183116);
    paramb.release(1);
    if (paramBoolean) {
      fDX();
    }
    localReentrantLock = this.rwa;
    localReentrantLock.lock();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.JZr += paramb.JZy.get();
        this.JZn.remove(paramb);
        paramb.JZx = null;
        paramb.cXV = null;
        return;
      }
      finally
      {
        localReentrantLock.unlock();
        fDY();
        AppMethodBeat.o(183116);
      }
      if (paramb.JZz.compareAndSet(false, true))
      {
        this.JZo.add(paramb);
        paramb = fDZ();
        if (paramb != null) {
          aO(paramb);
        }
      }
    }
  }
  
  private void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(183113);
    this.JZt.a(paramRunnable, this);
    AppMethodBeat.o(183113);
  }
  
  private boolean aO(Runnable paramRunnable)
  {
    AppMethodBeat.i(183123);
    if ((this.JZk.get() & 0xE0000000) >= 0)
    {
      AppMethodBeat.o(183123);
      return false;
    }
    ReentrantLock localReentrantLock = this.rwa;
    localReentrantLock.lock();
    try
    {
      if (this.JZo.isEmpty()) {}
      for (b localb = null; localb != null; localb = (b)this.JZo.remove())
      {
        localb.JZz.compareAndSet(true, false);
        localb.aP(paramRunnable);
        localb.start();
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183123);
    }
  }
  
  public static boolean aet(int paramInt)
  {
    return paramInt < 0;
  }
  
  private void aeu(int paramInt)
  {
    AppMethodBeat.i(183110);
    int i;
    do
    {
      i = this.JZk.get();
    } while ((!kC(i, paramInt)) && (!this.JZk.compareAndSet(i, 0x1FFFFFFF & i | paramInt)));
    AppMethodBeat.o(183110);
  }
  
  private boolean b(Runnable paramRunnable, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(183114);
    int i;
    int k;
    do
    {
      i = this.JZk.get();
      k = i & 0xE0000000;
      if (h.JZN.isShutdown())
      {
        AppMethodBeat.o(183114);
        return false;
      }
      if ((k < 0) || ((k == 0) && (paramRunnable == null) && (!this.JZm.isEmpty()))) {
        break label303;
      }
      AppMethodBeat.o(183114);
      return false;
      if (this.JZk.compareAndSet(i, i + 1)) {
        break;
      }
      i = this.JZk.get();
    } while ((i & 0xE0000000) != k);
    label141:
    label303:
    for (;;)
    {
      int m = i & 0x1FFFFFFF;
      if (m < 536870911) {
        if (!paramBoolean) {
          break label141;
        }
      }
      for (int j = this.cSv; m >= j; j = this.JZv)
      {
        AppMethodBeat.o(183114);
        return false;
      }
      break;
      for (;;)
      {
        try
        {
          localb = new b(paramRunnable);
        }
        finally
        {
          b localb;
          ReentrantLock localReentrantLock;
          continue;
          i = 0;
        }
        try
        {
          localReentrantLock = this.rwa;
          localReentrantLock.lock();
          try
          {
            i = this.JZk.get() & 0xE0000000;
            if ((i >= 0) && ((i != 0) || (paramRunnable != null))) {
              continue;
            }
            this.JZn.add(localb);
            i = this.JZn.size();
            if (i > this.JZq) {
              this.JZq = i;
            }
            i = 1;
            localReentrantLock.unlock();
            paramBoolean = bool;
            if (i != 0)
            {
              localb.start();
              paramBoolean = true;
            }
            if (!paramBoolean) {}
            return paramBoolean;
          }
          finally
          {
            localReentrantLock.unlock();
            AppMethodBeat.o(183114);
          }
          paramRunnable = finally;
        }
        finally
        {
          a(localb);
          AppMethodBeat.o(183114);
        }
      }
    }
  }
  
  private void fDX()
  {
    AppMethodBeat.i(183109);
    int i;
    do
    {
      i = this.JZk.get();
    } while (!this.JZk.compareAndSet(i, i - 1));
    AppMethodBeat.o(183109);
  }
  
  private void fDY()
  {
    AppMethodBeat.i(183111);
    ReentrantLock localReentrantLock;
    for (;;)
    {
      int j = this.JZk.get();
      if (j < 0) {}
      for (int i = 1; (i != 0) || (kC(j, 1073741824)) || (((0xE0000000 & j) == 0) && (!this.JZm.isEmpty())); i = 0)
      {
        AppMethodBeat.o(183111);
        return;
      }
      if ((0x1FFFFFFF & j) != 0)
      {
        yH(true);
        AppMethodBeat.o(183111);
        return;
      }
      localReentrantLock = this.rwa;
      localReentrantLock.lock();
      try
      {
        boolean bool = this.JZk.compareAndSet(j, 1073741824);
        if (bool) {
          try
          {
            terminated();
            this.JZk.set(1610612736);
            this.JZp.signalAll();
            return;
          }
          finally
          {
            this.JZk.set(1610612736);
            this.JZp.signalAll();
            AppMethodBeat.o(183111);
          }
        }
        localReentrantLock.unlock();
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(183111);
      }
    }
  }
  
  private Runnable fDZ()
  {
    AppMethodBeat.i(183117);
    int i = this.JZk.get() & 0xE0000000;
    if ((i >= 0) && ((i >= 536870912) || (this.JZm.isEmpty())))
    {
      fDX();
      AppMethodBeat.o(183117);
      return null;
    }
    Runnable localRunnable = (Runnable)this.JZm.poll();
    AppMethodBeat.o(183117);
    return localRunnable;
  }
  
  public static boolean kB(int paramInt1, int paramInt2)
  {
    return paramInt1 < paramInt2;
  }
  
  private static boolean kC(int paramInt1, int paramInt2)
  {
    return paramInt1 >= paramInt2;
  }
  
  private void yH(boolean paramBoolean)
  {
    AppMethodBeat.i(183112);
    ReentrantLock localReentrantLock = this.rwa;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.JZn.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        ((b)localIterator.next()).fEa();
      } while (!paramBoolean);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183112);
    }
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {}
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183128);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.rwa;
    paramTimeUnit.lock();
    try
    {
      for (;;)
      {
        boolean bool = kC(this.JZk.get(), 1610612736);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.JZp.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
      AppMethodBeat.o(183128);
    }
  }
  
  /* Error */
  final void b(b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_1
    //   4: istore_2
    //   5: ldc_w 338
    //   8: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: invokestatic 344	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: astore 7
    //   16: aload_1
    //   17: getfield 193	com/tencent/e/b$b:JZx	Ljava/lang/Runnable;
    //   20: astore 6
    //   22: aload_1
    //   23: aconst_null
    //   24: putfield 193	com/tencent/e/b$b:JZx	Ljava/lang/Runnable;
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 177	com/tencent/e/b$b:release	(I)Z
    //   32: pop
    //   33: aload 6
    //   35: astore 5
    //   37: aload 6
    //   39: ifnonnull +14 -> 53
    //   42: aload_0
    //   43: invokespecial 214	com/tencent/e/b:fDZ	()Ljava/lang/Runnable;
    //   46: astore 5
    //   48: aload 5
    //   50: ifnull +119 -> 169
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual 347	com/tencent/e/b$b:acquire	(I)V
    //   58: aload_0
    //   59: getfield 104	com/tencent/e/b:JZk	Ljava/util/concurrent/atomic/AtomicInteger;
    //   62: invokevirtual 230	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   65: ldc_w 301
    //   68: invokestatic 250	com/tencent/e/b:kC	(II)Z
    //   71: ifeq +28 -> 99
    //   74: aload 7
    //   76: invokevirtual 350	java/lang/Thread:isInterrupted	()Z
    //   79: ifne +20 -> 99
    //   82: aload_1
    //   83: invokevirtual 323	com/tencent/e/b$b:fEa	()V
    //   86: aload_0
    //   87: aload_1
    //   88: iconst_1
    //   89: invokespecial 352	com/tencent/e/b:a	(Lcom/tencent/e/b$b;Z)V
    //   92: ldc_w 338
    //   95: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: aload_0
    //   100: aload 7
    //   102: aload 5
    //   104: invokevirtual 356	com/tencent/e/b:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   107: aload 5
    //   109: invokeinterface 359 1 0
    //   114: aload_0
    //   115: aload 5
    //   117: aconst_null
    //   118: invokevirtual 361	com/tencent/e/b:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   121: aload_1
    //   122: getfield 183	com/tencent/e/b$b:JZy	Ljava/util/concurrent/atomic/AtomicLong;
    //   125: invokevirtual 364	java/util/concurrent/atomic/AtomicLong:getAndIncrement	()J
    //   128: pop2
    //   129: aload_0
    //   130: invokespecial 214	com/tencent/e/b:fDZ	()Ljava/lang/Runnable;
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +250 -> 387
    //   140: aload_1
    //   141: aload 4
    //   143: invokevirtual 237	com/tencent/e/b$b:aP	(Ljava/lang/Runnable;)V
    //   146: aload_1
    //   147: getstatic 261	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   150: aload_1
    //   151: invokeinterface 368 2 0
    //   156: putfield 197	com/tencent/e/b$b:cXV	Ljava/util/concurrent/Future;
    //   159: iconst_0
    //   160: istore_2
    //   161: iload_2
    //   162: istore_3
    //   163: aload_1
    //   164: iconst_1
    //   165: invokevirtual 177	com/tencent/e/b$b:release	(I)Z
    //   168: pop
    //   169: iload_2
    //   170: ifeq +191 -> 361
    //   173: aload_0
    //   174: aload_1
    //   175: iconst_0
    //   176: invokespecial 352	com/tencent/e/b:a	(Lcom/tencent/e/b$b;Z)V
    //   179: ldc_w 338
    //   182: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: astore 6
    //   188: aload 6
    //   190: astore 4
    //   192: ldc_w 338
    //   195: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 6
    //   200: astore 4
    //   202: aload 6
    //   204: athrow
    //   205: astore 6
    //   207: aload_0
    //   208: aload 5
    //   210: aload 4
    //   212: invokevirtual 361	com/tencent/e/b:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   215: ldc_w 338
    //   218: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 6
    //   223: athrow
    //   224: astore 4
    //   226: aload_1
    //   227: getfield 183	com/tencent/e/b$b:JZy	Ljava/util/concurrent/atomic/AtomicLong;
    //   230: invokevirtual 364	java/util/concurrent/atomic/AtomicLong:getAndIncrement	()J
    //   233: pop2
    //   234: aload_0
    //   235: invokespecial 214	com/tencent/e/b:fDZ	()Ljava/lang/Runnable;
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull +140 -> 382
    //   245: aload_1
    //   246: aload 5
    //   248: invokevirtual 237	com/tencent/e/b$b:aP	(Ljava/lang/Runnable;)V
    //   251: aload_1
    //   252: getstatic 261	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   255: aload_1
    //   256: invokeinterface 368 2 0
    //   261: putfield 197	com/tencent/e/b$b:cXV	Ljava/util/concurrent/Future;
    //   264: iconst_0
    //   265: istore_2
    //   266: iload_2
    //   267: istore_3
    //   268: aload_1
    //   269: iconst_1
    //   270: invokevirtual 177	com/tencent/e/b$b:release	(I)Z
    //   273: pop
    //   274: iload_2
    //   275: istore_3
    //   276: ldc_w 338
    //   279: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: iload_2
    //   283: istore_3
    //   284: aload 4
    //   286: athrow
    //   287: astore 4
    //   289: iload_3
    //   290: ifeq +9 -> 299
    //   293: aload_0
    //   294: aload_1
    //   295: iconst_1
    //   296: invokespecial 352	com/tencent/e/b:a	(Lcom/tencent/e/b$b;Z)V
    //   299: ldc_w 338
    //   302: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload 4
    //   307: athrow
    //   308: astore 6
    //   310: aload 6
    //   312: astore 4
    //   314: ldc_w 338
    //   317: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 6
    //   322: astore 4
    //   324: aload 6
    //   326: athrow
    //   327: astore 6
    //   329: aload 6
    //   331: astore 4
    //   333: new 335	java/lang/Error
    //   336: dup
    //   337: aload 6
    //   339: invokespecial 371	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   342: astore 7
    //   344: aload 6
    //   346: astore 4
    //   348: ldc_w 338
    //   351: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload 6
    //   356: astore 4
    //   358: aload 7
    //   360: athrow
    //   361: ldc_w 338
    //   364: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: return
    //   368: astore 4
    //   370: iconst_1
    //   371: istore_3
    //   372: goto -83 -> 289
    //   375: astore 4
    //   377: iconst_0
    //   378: istore_3
    //   379: goto -90 -> 289
    //   382: iconst_1
    //   383: istore_2
    //   384: goto -118 -> 266
    //   387: iconst_1
    //   388: istore_2
    //   389: goto -228 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	b
    //   0	392	1	paramb	b
    //   4	385	2	i	int
    //   162	217	3	j	int
    //   1	210	4	localObject1	Object
    //   224	61	4	localObject2	Object
    //   287	19	4	localObject3	Object
    //   312	45	4	localObject4	Object
    //   368	1	4	localObject5	Object
    //   375	1	4	localObject6	Object
    //   35	212	5	localRunnable1	Runnable
    //   20	18	6	localRunnable2	Runnable
    //   186	17	6	localRuntimeException	java.lang.RuntimeException
    //   205	17	6	localObject7	Object
    //   308	17	6	localError	java.lang.Error
    //   327	28	6	localThrowable	Throwable
    //   14	345	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   107	114	186	java/lang/RuntimeException
    //   107	114	205	finally
    //   192	198	205	finally
    //   202	205	205	finally
    //   314	320	205	finally
    //   324	327	205	finally
    //   333	344	205	finally
    //   348	354	205	finally
    //   358	361	205	finally
    //   99	107	224	finally
    //   114	121	224	finally
    //   207	224	224	finally
    //   163	169	287	finally
    //   268	274	287	finally
    //   276	282	287	finally
    //   284	287	287	finally
    //   107	114	308	java/lang/Error
    //   107	114	327	java/lang/Throwable
    //   42	48	368	finally
    //   53	86	368	finally
    //   121	135	368	finally
    //   226	240	368	finally
    //   140	159	375	finally
    //   245	264	375	finally
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {}
  
  public void execute(Runnable paramRunnable)
  {
    int j = 1;
    AppMethodBeat.i(183122);
    if (paramRunnable == null)
    {
      paramRunnable = new NullPointerException();
      AppMethodBeat.o(183122);
      throw paramRunnable;
    }
    int k = this.JZk.get();
    int i = k;
    if ((k & 0x1FFFFFFF) < this.cSv)
    {
      if (b(paramRunnable, true))
      {
        AppMethodBeat.o(183122);
        return;
      }
      i = this.JZk.get();
    }
    if (i < 0)
    {
      i = 1;
      if ((i == 0) || (!this.JZm.offer(paramRunnable))) {
        break label197;
      }
      k = this.JZk.get();
      if (k >= 0) {
        break label157;
      }
    }
    label157:
    for (i = j;; i = 0)
    {
      if (i != 0) {
        break label162;
      }
      boolean bool = this.JZm.remove(paramRunnable);
      fDY();
      if (!bool) {
        break label162;
      }
      aN(paramRunnable);
      AppMethodBeat.o(183122);
      return;
      i = 0;
      break;
    }
    label162:
    if ((k & 0x1FFFFFFF) == 0)
    {
      b(null, false);
      AppMethodBeat.o(183122);
      return;
    }
    aO(null);
    AppMethodBeat.o(183122);
    return;
    label197:
    if (!b(paramRunnable, false)) {
      aN(paramRunnable);
    }
    AppMethodBeat.o(183122);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183129);
    shutdown();
    AppMethodBeat.o(183129);
  }
  
  public final long getCompletedTaskCount()
  {
    AppMethodBeat.i(183130);
    ReentrantLock localReentrantLock = this.rwa;
    localReentrantLock.lock();
    try
    {
      long l1 = this.JZr;
      Iterator localIterator = this.JZn.iterator();
      while (localIterator.hasNext())
      {
        long l2 = ((b)localIterator.next()).JZy.get();
        l1 = l2 + l1;
      }
      return l1;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183130);
    }
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final BlockingQueue<Runnable> getQueue()
  {
    return this.JZm;
  }
  
  public boolean isShutdown()
  {
    AppMethodBeat.i(183126);
    if (this.JZk.get() < 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(183126);
      return true;
    }
    AppMethodBeat.o(183126);
    return false;
  }
  
  public boolean isTerminated()
  {
    AppMethodBeat.i(183127);
    boolean bool = kC(this.JZk.get(), 1610612736);
    AppMethodBeat.o(183127);
    return bool;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(183124);
    ReentrantLock localReentrantLock = this.rwa;
    localReentrantLock.lock();
    try
    {
      aeu(0);
      yH(false);
      localReentrantLock.unlock();
      fDY();
      AppMethodBeat.o(183124);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183124);
    }
  }
  
  public List<Runnable> shutdownNow()
  {
    int i = 0;
    AppMethodBeat.i(183125);
    ReentrantLock localReentrantLock1 = this.rwa;
    localReentrantLock1.lock();
    try
    {
      aeu(536870912);
      ReentrantLock localReentrantLock2 = this.rwa;
      localReentrantLock2.lock();
      try
      {
        Iterator localIterator = this.JZn.iterator();
        while (localIterator.hasNext())
        {
          ((b)localIterator.next()).fEa();
          continue;
          localObject1 = finally;
        }
      }
      finally {}
      localObject1.unlock();
    }
    finally
    {
      localReentrantLock1.unlock();
      AppMethodBeat.o(183125);
    }
    BlockingQueue localBlockingQueue = this.JZm;
    ArrayList localArrayList = new ArrayList();
    localBlockingQueue.drainTo(localArrayList);
    if (!localBlockingQueue.isEmpty())
    {
      Runnable[] arrayOfRunnable = (Runnable[])localBlockingQueue.toArray(new Runnable[0]);
      int j = arrayOfRunnable.length;
      while (i < j)
      {
        Runnable localRunnable = arrayOfRunnable[i];
        if (localBlockingQueue.remove(localRunnable)) {
          localArrayList.add(localRunnable);
        }
        i += 1;
      }
    }
    localReentrantLock1.unlock();
    fDY();
    AppMethodBeat.o(183125);
    return localArrayList;
  }
  
  protected void terminated()
  {
    AppMethodBeat.i(183132);
    Iterator localIterator = JZl.iterator();
    while (localIterator.hasNext()) {
      if (this == (b)((WeakReference)localIterator.next()).get()) {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(183132);
  }
  
  public String toString()
  {
    AppMethodBeat.i(183131);
    Object localObject1 = this.rwa;
    StringBuilder localStringBuilder = new StringBuilder();
    ((ReentrantLock)localObject1).lock();
    for (;;)
    {
      int j;
      try
      {
        long l = this.JZr;
        int k = this.JZn.size();
        Iterator localIterator = this.JZn.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          l += localb.JZy.get();
          j = i;
          if (localb.isLocked())
          {
            j = i + 1;
            localStringBuilder.append(localb.fQb);
          }
          i = j;
          continue;
        }
        ((ReentrantLock)localObject1).unlock();
        j = this.JZk.get();
        if (kB(j, 0))
        {
          localObject1 = "Running";
          localObject1 = super.toString() + "[" + (String)localObject1 + ", pool size = " + k + ", active threads = " + i + ", queued tasks = " + this.JZm.size() + ", completed tasks = " + l + ", running tasks = " + localStringBuilder + "]";
          AppMethodBeat.o(183131);
          return localObject1;
        }
      }
      finally
      {
        ((ReentrantLock)localObject1).unlock();
        AppMethodBeat.o(183131);
      }
      if (kC(j, 1610612736)) {
        localObject1 = "Terminated";
      } else {
        localObject1 = "Shutting down";
      }
    }
  }
  
  public static final class a
    implements e
  {
    public final void a(Runnable paramRunnable, b paramb)
    {
      AppMethodBeat.i(183099);
      paramRunnable = new RejectedExecutionException("Task " + paramRunnable.toString() + " rejected from " + paramb.toString());
      AppMethodBeat.o(183099);
      throw paramRunnable;
    }
  }
  
  final class b
    extends AbstractQueuedSynchronizer
    implements com.tencent.e.i.h
  {
    Runnable JZx;
    AtomicLong JZy;
    AtomicBoolean JZz;
    Future cXV;
    String fQb;
    
    b(Runnable paramRunnable)
    {
      AppMethodBeat.i(183100);
      this.JZy = new AtomicLong(0L);
      this.JZz = new AtomicBoolean(false);
      setState(-1);
      aP(paramRunnable);
      AppMethodBeat.o(183100);
    }
    
    final void aP(Runnable paramRunnable)
    {
      AppMethodBeat.i(183101);
      this.JZx = paramRunnable;
      if (paramRunnable == null)
      {
        this.fQb = (b.a(b.this) + "#Worker");
        AppMethodBeat.o(183101);
        return;
      }
      if ((paramRunnable instanceof com.tencent.e.i.h))
      {
        this.fQb = ((com.tencent.e.i.h)paramRunnable).getKey();
        AppMethodBeat.o(183101);
        return;
      }
      this.fQb = (b.a(b.this) + "#" + paramRunnable.getClass().getName());
      AppMethodBeat.o(183101);
    }
    
    final void fEa()
    {
      AppMethodBeat.i(183103);
      d.JZD.i("ForkThreadPoolExecutor", "[releaseWork] name=" + b.a(b.this), new Object[0]);
      if ((this.cXV != null) && (!this.cXV.isDone())) {
        this.cXV.cancel(true);
      }
      AppMethodBeat.o(183103);
    }
    
    public final String getKey()
    {
      return this.fQb;
    }
    
    protected final boolean isHeldExclusively()
    {
      AppMethodBeat.i(183105);
      if (getState() != 0)
      {
        AppMethodBeat.o(183105);
        return true;
      }
      AppMethodBeat.o(183105);
      return false;
    }
    
    public final boolean isLocked()
    {
      AppMethodBeat.i(183108);
      boolean bool = isHeldExclusively();
      AppMethodBeat.o(183108);
      return bool;
    }
    
    public final void run()
    {
      AppMethodBeat.i(183104);
      b.this.b(this);
      AppMethodBeat.o(183104);
    }
    
    final void start()
    {
      AppMethodBeat.i(183102);
      this.cXV = h.JZN.aS(this);
      AppMethodBeat.o(183102);
    }
    
    protected final boolean tryAcquire(int paramInt)
    {
      AppMethodBeat.i(183106);
      if (compareAndSetState(0, 1))
      {
        setExclusiveOwnerThread(Thread.currentThread());
        AppMethodBeat.o(183106);
        return true;
      }
      AppMethodBeat.o(183106);
      return false;
    }
    
    protected final boolean tryRelease(int paramInt)
    {
      AppMethodBeat.i(183107);
      setExclusiveOwnerThread(null);
      setState(0);
      AppMethodBeat.o(183107);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.b
 * JD-Core Version:    0.7.0.1
 */