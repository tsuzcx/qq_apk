package com.google.b.b.a;

import com.google.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class a<V>
  extends com.google.b.b.a.a.a
  implements f<V>
{
  private static final boolean bfC = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
  private static final Logger bfD = Logger.getLogger(a.class.getName());
  private static final Object bfF;
  private static final a dAU;
  private volatile d dAV;
  volatile j dAW;
  private volatile Object value;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 52
    //   2: ldc 54
    //   4: invokestatic 60	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7: invokestatic 66	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   10: putstatic 68	com/google/b/b/a/a:bfC	Z
    //   13: ldc 2
    //   15: invokevirtual 74	java/lang/Class:getName	()Ljava/lang/String;
    //   18: invokestatic 80	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   21: putstatic 82	com/google/b/b/a/a:bfD	Ljava/util/logging/Logger;
    //   24: new 31	com/google/b/b/a/a$i
    //   27: dup
    //   28: iconst_0
    //   29: invokespecial 86	com/google/b/b/a/a$i:<init>	(B)V
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_0
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_2
    //   38: putstatic 88	com/google/b/b/a/a:dAU	Lcom/google/b/b/a/a$a;
    //   41: aload_0
    //   42: ifnull +27 -> 69
    //   45: getstatic 82	com/google/b/b/a/a:bfD	Ljava/util/logging/Logger;
    //   48: getstatic 94	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   51: ldc 96
    //   53: aload_1
    //   54: invokevirtual 100	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: getstatic 82	com/google/b/b/a/a:bfD	Ljava/util/logging/Logger;
    //   60: getstatic 94	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   63: ldc 102
    //   65: aload_0
    //   66: invokevirtual 100	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: new 104	java/lang/Object
    //   72: dup
    //   73: invokespecial 106	java/lang/Object:<init>	()V
    //   76: putstatic 108	com/google/b/b/a/a:bfF	Ljava/lang/Object;
    //   79: return
    //   80: astore_0
    //   81: new 20	com/google/b/b/a/a$e
    //   84: dup
    //   85: ldc 34
    //   87: ldc 110
    //   89: ldc 112
    //   91: invokestatic 118	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   94: ldc 34
    //   96: ldc 34
    //   98: ldc 120
    //   100: invokestatic 118	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   103: ldc 2
    //   105: ldc 34
    //   107: ldc 121
    //   109: invokestatic 118	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   112: ldc 2
    //   114: ldc 17
    //   116: ldc 122
    //   118: invokestatic 118	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   121: ldc 2
    //   123: ldc 104
    //   125: ldc 123
    //   127: invokestatic 118	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   130: invokespecial 126	com/google/b/b/a/a$e:<init>	(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;)V
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_0
    //   137: astore_1
    //   138: aload_3
    //   139: astore_0
    //   140: goto -103 -> 37
    //   143: astore_1
    //   144: new 25	com/google/b/b/a/a$g
    //   147: dup
    //   148: iconst_0
    //   149: invokespecial 127	com/google/b/b/a/a$g:<init>	(B)V
    //   152: astore_3
    //   153: aload_0
    //   154: astore_2
    //   155: aload_1
    //   156: astore_0
    //   157: aload_2
    //   158: astore_1
    //   159: aload_3
    //   160: astore_2
    //   161: goto -124 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	32	0	localThrowable	Throwable
    //   80	57	0	localObject1	Object
    //   139	18	0	localObject2	Object
    //   36	102	1	localObject3	Object
    //   143	13	1	localObject4	Object
    //   158	1	1	localObject5	Object
    //   32	129	2	localObject6	Object
    //   135	25	3	localg	g
    // Exception table:
    //   from	to	target	type
    //   24	33	80	finally
    //   81	134	143	finally
  }
  
  private void Cl()
  {
    j localj;
    do
    {
      localj = this.dAW;
    } while (!dAU.a(this, localj, j.dBh));
    while (localj != null)
    {
      localj.Co();
      localj = localj.dBi;
    }
  }
  
  private d XS()
  {
    Object localObject1;
    do
    {
      localObject1 = this.dAV;
    } while (!dAU.a(this, (d)localObject1, d.dBa));
    Object localObject2 = null;
    while (localObject1 != null)
    {
      d locald = ((d)localObject1).dBb;
      ((d)localObject1).dBb = localObject2;
      localObject2 = localObject1;
      localObject1 = locald;
    }
    return localObject2;
  }
  
  private void a(j paramj)
  {
    paramj.thread = null;
    paramj = this.dAW;
    if (paramj == j.dBh) {}
    label18:
    label82:
    for (;;)
    {
      return;
      for (;;)
      {
        if (paramj == null) {
          break label82;
        }
        j localj2 = paramj.dBi;
        if (paramj.thread != null) {}
        for (;;)
        {
          localj1 = paramj;
          paramj = localj2;
          break label18;
          if (localj1 != null)
          {
            localj1.dBi = localj2;
            paramj = localj1;
            if (localj1.thread != null) {
              continue;
            }
            break;
          }
          if (!dAU.a(this, paramj, localj2)) {
            break;
          }
          paramj = localj1;
        }
        j localj1 = null;
      }
    }
  }
  
  private static void a(a<?> parama)
  {
    parama.Cl();
    d locald;
    for (parama = parama.XS(); parama != null; parama = locald)
    {
      locald = parama.dBb;
      Runnable localRunnable = parama.task;
      if ((localRunnable instanceof a.f)) {
        throw null;
      }
      b(localRunnable, parama.executor);
    }
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    try
    {
      Object localObject = b(this);
      paramStringBuilder.append("SUCCESS, result=[").append(aq(localObject)).append("]");
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      paramStringBuilder.append("FAILURE, cause=[").append(localExecutionException.getCause()).append("]");
      return;
    }
    catch (CancellationException localCancellationException)
    {
      paramStringBuilder.append("CANCELLED");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramStringBuilder.append("UNKNOWN, cause=[").append(localRuntimeException.getClass()).append(" thrown from get()]");
    }
  }
  
  private static V ao(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      throw g("Task was cancelled.", ((b)paramObject).cause);
    }
    if ((paramObject instanceof a.c)) {
      throw new ExecutionException(((a.c)paramObject).exception);
    }
    Object localObject = paramObject;
    if (paramObject == bfF) {
      localObject = null;
    }
    return localObject;
  }
  
  private String aq(Object paramObject)
  {
    if (paramObject == this) {
      return "this future";
    }
    return String.valueOf(paramObject);
  }
  
  /* Error */
  private static <V> V b(java.util.concurrent.Future<V> paramFuture)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 264 1 0
    //   8: astore_2
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: invokestatic 268	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 271	java/lang/Thread:interrupt	()V
    //   19: aload_2
    //   20: areturn
    //   21: astore_2
    //   22: iconst_1
    //   23: istore_1
    //   24: goto -22 -> 2
    //   27: astore_0
    //   28: iload_1
    //   29: ifeq +9 -> 38
    //   32: invokestatic 268	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 271	java/lang/Thread:interrupt	()V
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramFuture	java.util.concurrent.Future<V>
    //   1	28	1	i	int
    //   8	12	2	localObject	Object
    //   21	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	21	java/lang/InterruptedException
    //   2	9	27	finally
  }
  
  private static void b(Runnable paramRunnable, Executor paramExecutor)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      bfD.log(Level.SEVERE, "RuntimeException while executing runnable " + paramRunnable + " with executor " + paramExecutor, localRuntimeException);
    }
  }
  
  private static CancellationException g(String paramString, Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  public void a(Runnable paramRunnable, Executor paramExecutor)
  {
    com.google.b.a.b.checkNotNull(paramRunnable, "Runnable was null.");
    com.google.b.a.b.checkNotNull(paramExecutor, "Executor was null.");
    if (!isDone())
    {
      Object localObject = this.dAV;
      if (localObject != d.dBa)
      {
        d locald2 = new d(paramRunnable, paramExecutor);
        d locald1;
        do
        {
          locald2.dBb = ((d)localObject);
          if (dAU.a(this, (d)localObject, locald2)) {
            return;
          }
          locald1 = this.dAV;
          localObject = locald1;
        } while (locald1 != d.dBa);
      }
    }
    b(paramRunnable, paramExecutor);
  }
  
  protected boolean ap(V paramV)
  {
    Object localObject = paramV;
    if (paramV == null) {
      localObject = bfF;
    }
    if (dAU.a(this, null, localObject))
    {
      a(this);
      return true;
    }
    return false;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    Object localObject1 = this.value;
    int i;
    b localb;
    if (localObject1 == null)
    {
      i = 1;
      if ((i | localObject1 instanceof a.f) == 0) {
        break label116;
      }
      if (!bfC) {
        break label80;
      }
      localb = new b(paramBoolean, new CancellationException("Future.cancel() was called."));
    }
    label80:
    label98:
    Object localObject2;
    do
    {
      for (;;)
      {
        if (!dAU.a(this, localObject1, localb)) {
          break label98;
        }
        a(this);
        if (!(localObject1 instanceof a.f)) {
          break label118;
        }
        throw null;
        i = 0;
        break;
        if (paramBoolean) {
          localb = b.dAX;
        } else {
          localb = b.dAY;
        }
      }
      localObject2 = this.value;
      localObject1 = localObject2;
    } while ((localObject2 instanceof a.f));
    label116:
    return false;
    label118:
    return true;
  }
  
  public V get()
  {
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    Object localObject = this.value;
    int i;
    if (localObject != null)
    {
      i = 1;
      if ((localObject instanceof a.f)) {
        break label50;
      }
    }
    label50:
    for (int j = 1;; j = 0)
    {
      if ((i & j) == 0) {
        break label55;
      }
      return ao(localObject);
      i = 0;
      break;
    }
    label55:
    localObject = this.dAW;
    if (localObject != j.dBh)
    {
      j localj2 = new j((byte)0);
      label156:
      label159:
      j localj1;
      do
      {
        localj2.b((j)localObject);
        if (dAU.a(this, (j)localObject, localj2)) {
          for (;;)
          {
            LockSupport.park(this);
            if (Thread.interrupted())
            {
              a(localj2);
              throw new InterruptedException();
            }
            localObject = this.value;
            if (localObject != null)
            {
              i = 1;
              if ((localObject instanceof a.f)) {
                break label156;
              }
            }
            for (j = 1;; j = 0)
            {
              if ((i & j) == 0) {
                break label159;
              }
              return ao(localObject);
              i = 0;
              break;
            }
          }
        }
        localj1 = this.dAW;
        localObject = localj1;
      } while (localj1 != j.dBh);
    }
    return ao(this.value);
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    long l3 = paramTimeUnit.toNanos(paramLong);
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    Object localObject1 = this.value;
    if (localObject1 != null)
    {
      i = 1;
      if ((localObject1 instanceof a.f)) {
        break label66;
      }
    }
    label66:
    for (int j = 1;; j = 0)
    {
      if ((i & j) == 0) {
        break label72;
      }
      return ao(localObject1);
      i = 0;
      break;
    }
    label72:
    long l2;
    if (l3 > 0L)
    {
      l2 = System.nanoTime() + l3;
      l1 = l3;
      if (l3 >= 1000L)
      {
        localObject1 = this.dAW;
        if (localObject1 == j.dBh) {
          break label327;
        }
        localObject3 = new j((byte)0);
        ((j)localObject3).b((j)localObject1);
        if (!dAU.a(this, (j)localObject1, (j)localObject3)) {
          break label309;
        }
        l1 = l3;
      }
    }
    else
    {
      label226:
      label232:
      do
      {
        LockSupport.parkNanos(this, l1);
        if (Thread.interrupted())
        {
          a((j)localObject3);
          throw new InterruptedException();
          l2 = 0L;
          break;
        }
        localObject1 = this.value;
        if (localObject1 != null)
        {
          i = 1;
          if ((localObject1 instanceof a.f)) {
            break label226;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i & j) == 0) {
            break label232;
          }
          return ao(localObject1);
          i = 0;
          break;
        }
        l3 = l2 - System.nanoTime();
        l1 = l3;
      } while (l3 >= 1000L);
      a((j)localObject3);
    }
    for (long l1 = l3;; l1 = l2 - System.nanoTime())
    {
      if (l1 <= 0L) {
        break label372;
      }
      localObject1 = this.value;
      if (localObject1 != null)
      {
        i = 1;
        label284:
        if ((localObject1 instanceof a.f)) {
          break label341;
        }
      }
      label309:
      label327:
      label341:
      for (j = 1;; j = 0)
      {
        if ((i & j) == 0) {
          break label347;
        }
        return ao(localObject1);
        localObject2 = this.dAW;
        localObject1 = localObject2;
        if (localObject2 != j.dBh) {
          break;
        }
        return ao(this.value);
        i = 0;
        break label284;
      }
      label347:
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
    }
    label372:
    Object localObject3 = toString();
    String str = paramTimeUnit.toString().toLowerCase(Locale.ROOT);
    Object localObject2 = "Waited " + paramLong + " " + paramTimeUnit.toString().toLowerCase(Locale.ROOT);
    localObject1 = localObject2;
    if (1000L + l1 < 0L)
    {
      localObject1 = (String)localObject2 + " (plus ";
      l1 = -l1;
      paramLong = paramTimeUnit.convert(l1, TimeUnit.NANOSECONDS);
      l1 -= paramTimeUnit.toNanos(paramLong);
      if ((paramLong != 0L) && (l1 <= 1000L)) {
        break label695;
      }
    }
    label695:
    for (int i = 1;; i = 0)
    {
      paramTimeUnit = (TimeUnit)localObject1;
      if (paramLong > 0L)
      {
        localObject1 = (String)localObject1 + paramLong + " " + str;
        paramTimeUnit = (TimeUnit)localObject1;
        if (i != 0) {
          paramTimeUnit = (String)localObject1 + ",";
        }
        paramTimeUnit = paramTimeUnit + " ";
      }
      localObject1 = paramTimeUnit;
      if (i != 0) {
        localObject1 = paramTimeUnit + l1 + " nanoseconds ";
      }
      localObject1 = (String)localObject1 + "delay)";
      if (!isDone()) {
        break;
      }
      throw new TimeoutException((String)localObject1 + " but future completed as timeout expired");
    }
    throw new TimeoutException((String)localObject1 + " for " + (String)localObject3);
  }
  
  protected boolean h(Throwable paramThrowable)
  {
    paramThrowable = new a.c((Throwable)com.google.b.a.b.checkNotNull(paramThrowable));
    if (dAU.a(this, null, paramThrowable))
    {
      a(this);
      return true;
    }
    return false;
  }
  
  public boolean isCancelled()
  {
    return this.value instanceof b;
  }
  
  public boolean isDone()
  {
    int j = 1;
    Object localObject = this.value;
    int i;
    if (localObject != null)
    {
      i = 1;
      if ((localObject instanceof a.f)) {
        break label29;
      }
    }
    for (;;)
    {
      return i & j;
      i = 0;
      break;
      label29:
      j = 0;
    }
  }
  
  public String toString()
  {
    Object localObject = null;
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("[status=");
    if (isCancelled()) {
      localStringBuilder.append("CANCELLED");
    }
    for (;;)
    {
      return "]";
      if (isDone()) {
        a(localStringBuilder);
      } else {
        try
        {
          if ((this.value instanceof a.f)) {
            throw null;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          String str = "Exception thrown from implementation: " + localRuntimeException.getClass();
          for (;;)
          {
            if ((str == null) || (str.isEmpty())) {
              break label172;
            }
            localStringBuilder.append("PENDING, info=[").append(str).append("]");
            break;
            if ((this instanceof ScheduledFuture)) {
              str = "remaining delay=[" + ((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
            }
          }
          label172:
          if (isDone()) {
            a(localStringBuilder);
          } else {
            localStringBuilder.append("PENDING");
          }
        }
      }
    }
  }
  
  static abstract class a
  {
    abstract void a(a.j paramj1, a.j paramj2);
    
    abstract void a(a.j paramj, Thread paramThread);
    
    abstract boolean a(a<?> parama, a.d paramd1, a.d paramd2);
    
    abstract boolean a(a<?> parama, a.j paramj1, a.j paramj2);
    
    abstract boolean a(a<?> parama, Object paramObject1, Object paramObject2);
  }
  
  static final class b
  {
    static final b dAX;
    static final b dAY;
    final boolean bfK;
    final Throwable cause;
    
    static
    {
      AppMethodBeat.i(208716);
      if (a.XU())
      {
        dAY = null;
        dAX = null;
        AppMethodBeat.o(208716);
        return;
      }
      dAY = new b(false, null);
      dAX = new b(true, null);
      AppMethodBeat.o(208716);
    }
    
    b(boolean paramBoolean, Throwable paramThrowable)
    {
      this.bfK = paramBoolean;
      this.cause = paramThrowable;
    }
  }
  
  static final class d
  {
    static final d dBa;
    d dBb;
    final Executor executor;
    final Runnable task;
    
    static
    {
      AppMethodBeat.i(208708);
      dBa = new d(null, null);
      AppMethodBeat.o(208708);
    }
    
    d(Runnable paramRunnable, Executor paramExecutor)
    {
      this.task = paramRunnable;
      this.executor = paramExecutor;
    }
  }
  
  static final class e
    extends a.a
  {
    final AtomicReferenceFieldUpdater<a.j, Thread> bfO;
    final AtomicReferenceFieldUpdater<a.j, a.j> bfP;
    final AtomicReferenceFieldUpdater<a, a.j> bfQ;
    final AtomicReferenceFieldUpdater<a, a.d> bfR;
    final AtomicReferenceFieldUpdater<a, Object> bfS;
    
    e(AtomicReferenceFieldUpdater<a.j, Thread> paramAtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<a.j, a.j> paramAtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<a, a.j> paramAtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, a.d> paramAtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, Object> paramAtomicReferenceFieldUpdater4)
    {
      super();
      this.bfO = paramAtomicReferenceFieldUpdater;
      this.bfP = paramAtomicReferenceFieldUpdater1;
      this.bfQ = paramAtomicReferenceFieldUpdater2;
      this.bfR = paramAtomicReferenceFieldUpdater3;
      this.bfS = paramAtomicReferenceFieldUpdater4;
    }
    
    final void a(a.j paramj1, a.j paramj2)
    {
      AppMethodBeat.i(208734);
      this.bfP.lazySet(paramj1, paramj2);
      AppMethodBeat.o(208734);
    }
    
    final void a(a.j paramj, Thread paramThread)
    {
      AppMethodBeat.i(208731);
      this.bfO.lazySet(paramj, paramThread);
      AppMethodBeat.o(208731);
    }
    
    final boolean a(a<?> parama, a.d paramd1, a.d paramd2)
    {
      AppMethodBeat.i(208743);
      boolean bool = this.bfR.compareAndSet(parama, paramd1, paramd2);
      AppMethodBeat.o(208743);
      return bool;
    }
    
    final boolean a(a<?> parama, a.j paramj1, a.j paramj2)
    {
      AppMethodBeat.i(208738);
      boolean bool = this.bfQ.compareAndSet(parama, paramj1, paramj2);
      AppMethodBeat.o(208738);
      return bool;
    }
    
    final boolean a(a<?> parama, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(208745);
      boolean bool = this.bfS.compareAndSet(parama, paramObject1, paramObject2);
      AppMethodBeat.o(208745);
      return bool;
    }
  }
  
  static final class g
    extends a.a
  {
    private g()
    {
      super();
    }
    
    final void a(a.j paramj1, a.j paramj2)
    {
      paramj1.dBi = paramj2;
    }
    
    final void a(a.j paramj, Thread paramThread)
    {
      paramj.thread = paramThread;
    }
    
    final boolean a(a<?> parama, a.d paramd1, a.d paramd2)
    {
      AppMethodBeat.i(208739);
      try
      {
        if (a.d(parama) == paramd1)
        {
          a.a(parama, paramd2);
          return true;
        }
        return false;
      }
      finally
      {
        AppMethodBeat.o(208739);
      }
    }
    
    final boolean a(a<?> parama, a.j paramj1, a.j paramj2)
    {
      AppMethodBeat.i(208736);
      try
      {
        if (a.c(parama) == paramj1)
        {
          a.a(parama, paramj2);
          return true;
        }
        return false;
      }
      finally
      {
        AppMethodBeat.o(208736);
      }
    }
    
    final boolean a(a<?> parama, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(208741);
      try
      {
        if (a.b(parama) == paramObject1)
        {
          a.a(parama, paramObject2);
          return true;
        }
        return false;
      }
      finally
      {
        AppMethodBeat.o(208741);
      }
    }
  }
  
  static abstract class h<V>
    extends a<V>
    implements b<V>
  {
    public final void a(Runnable paramRunnable, Executor paramExecutor)
    {
      super.a(paramRunnable, paramExecutor);
    }
    
    public final boolean cancel(boolean paramBoolean)
    {
      return super.cancel(paramBoolean);
    }
    
    public final V get()
    {
      return super.get();
    }
    
    public final V get(long paramLong, TimeUnit paramTimeUnit)
    {
      return super.get(paramLong, paramTimeUnit);
    }
    
    public final boolean isCancelled()
    {
      return super.isCancelled();
    }
    
    public final boolean isDone()
    {
      return super.isDone();
    }
  }
  
  static final class i
    extends a.a
  {
    static final Unsafe UNSAFE;
    static final long dBc;
    static final long dBd;
    static final long dBe;
    static final long dBf;
    static final long dBg;
    
    static
    {
      AppMethodBeat.i(208728);
      try
      {
        localUnsafe1 = Unsafe.getUnsafe();
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          try
          {
            Unsafe localUnsafe1;
            dBd = localUnsafe1.objectFieldOffset(a.class.getDeclaredField("dAW"));
            dBc = localUnsafe1.objectFieldOffset(a.class.getDeclaredField("listeners"));
            dBe = localUnsafe1.objectFieldOffset(a.class.getDeclaredField("value"));
            dBf = localUnsafe1.objectFieldOffset(a.j.class.getDeclaredField("thread"));
            dBg = localUnsafe1.objectFieldOffset(a.j.class.getDeclaredField("dBi"));
            UNSAFE = localUnsafe1;
            AppMethodBeat.o(208728);
            return;
          }
          catch (Exception localException)
          {
            d.n(localException);
            RuntimeException localRuntimeException2 = new RuntimeException(localException);
            AppMethodBeat.o(208728);
            throw localRuntimeException2;
          }
          localSecurityException = localSecurityException;
          try
          {
            Unsafe localUnsafe2 = (Unsafe)AccessController.doPrivileged(new a.i.1());
          }
          catch (PrivilegedActionException localPrivilegedActionException)
          {
            RuntimeException localRuntimeException1 = new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
            AppMethodBeat.o(208728);
            throw localRuntimeException1;
          }
        }
      }
    }
    
    private i()
    {
      super();
    }
    
    final void a(a.j paramj1, a.j paramj2)
    {
      AppMethodBeat.i(208735);
      UNSAFE.putObject(paramj1, dBg, paramj2);
      AppMethodBeat.o(208735);
    }
    
    final void a(a.j paramj, Thread paramThread)
    {
      AppMethodBeat.i(208732);
      UNSAFE.putObject(paramj, dBf, paramThread);
      AppMethodBeat.o(208732);
    }
    
    final boolean a(a<?> parama, a.d paramd1, a.d paramd2)
    {
      AppMethodBeat.i(208742);
      boolean bool = UNSAFE.compareAndSwapObject(parama, dBc, paramd1, paramd2);
      AppMethodBeat.o(208742);
      return bool;
    }
    
    final boolean a(a<?> parama, a.j paramj1, a.j paramj2)
    {
      AppMethodBeat.i(208740);
      boolean bool = UNSAFE.compareAndSwapObject(parama, dBd, paramj1, paramj2);
      AppMethodBeat.o(208740);
      return bool;
    }
    
    final boolean a(a<?> parama, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(208746);
      boolean bool = UNSAFE.compareAndSwapObject(parama, dBe, paramObject1, paramObject2);
      AppMethodBeat.o(208746);
      return bool;
    }
  }
  
  static final class j
  {
    static final j dBh;
    volatile j dBi;
    volatile Thread thread;
    
    static
    {
      AppMethodBeat.i(208729);
      dBh = new j();
      AppMethodBeat.o(208729);
    }
    
    j() {}
    
    j(byte paramByte)
    {
      AppMethodBeat.i(208727);
      a.XT().a(this, Thread.currentThread());
      AppMethodBeat.o(208727);
    }
    
    final void Co()
    {
      AppMethodBeat.i(208737);
      Thread localThread = this.thread;
      if (localThread != null)
      {
        this.thread = null;
        LockSupport.unpark(localThread);
      }
      AppMethodBeat.o(208737);
    }
    
    final void b(j paramj)
    {
      AppMethodBeat.i(208733);
      a.XT().a(this, paramj);
      AppMethodBeat.o(208733);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */