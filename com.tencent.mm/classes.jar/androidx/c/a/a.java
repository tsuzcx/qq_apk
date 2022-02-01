package androidx.c.a;

import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public abstract class a<V>
  implements f<V>
{
  static final boolean bfC = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
  private static final Logger bfD = Logger.getLogger(a.class.getName());
  static final a bfE;
  private static final Object bfF = new Object();
  volatile d bfG;
  volatile h bfH;
  volatile Object value;
  
  static
  {
    try
    {
      localObject2 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "bfU"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "bfH"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "bfG"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "value"));
      localThrowable = null;
    }
    finally
    {
      for (;;)
      {
        Throwable localThrowable;
        Object localObject2 = new g();
      }
    }
    bfE = (a)localObject2;
    if (localThrowable != null) {
      bfD.log(Level.SEVERE, "SafeAtomicHelper is broken!", localThrowable);
    }
  }
  
  private void Cl()
  {
    h localh;
    do
    {
      localh = this.bfH;
    } while (!bfE.a(this, localh, h.bfT));
    while (localh != null)
    {
      localh.Co();
      localh = localh.bfU;
    }
  }
  
  private d Cm()
  {
    Object localObject1;
    do
    {
      localObject1 = this.bfG;
    } while (!bfE.a(this, (d)localObject1, d.bfM));
    Object localObject2 = null;
    while (localObject1 != null)
    {
      d locald = ((d)localObject1).bfN;
      ((d)localObject1).bfN = localObject2;
      localObject2 = localObject1;
      localObject1 = locald;
    }
    return localObject2;
  }
  
  private void a(h paramh)
  {
    paramh.thread = null;
    paramh = this.bfH;
    if (paramh == h.bfT) {}
    label18:
    label82:
    for (;;)
    {
      return;
      for (;;)
      {
        if (paramh == null) {
          break label82;
        }
        h localh2 = paramh.bfU;
        if (paramh.thread != null) {}
        for (;;)
        {
          localh1 = paramh;
          paramh = localh2;
          break label18;
          if (localh1 != null)
          {
            localh1.bfU = localh2;
            paramh = localh1;
            if (localh1.thread != null) {
              continue;
            }
            break;
          }
          if (!bfE.a(this, paramh, localh2)) {
            break;
          }
          paramh = localh1;
        }
        h localh1 = null;
      }
    }
  }
  
  private static void a(a<?> parama)
  {
    parama.Cl();
    d locald;
    for (parama = parama.Cm(); parama != null; parama = locald)
    {
      locald = parama.bfN;
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
  static <V> V b(java.util.concurrent.Future<V> paramFuture)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 240 1 0
    //   8: astore_2
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: invokestatic 244	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 247	java/lang/Thread:interrupt	()V
    //   19: aload_2
    //   20: areturn
    //   21: astore_2
    //   22: iconst_1
    //   23: istore_1
    //   24: goto -22 -> 2
    //   27: astore_0
    //   28: iload_1
    //   29: ifeq +9 -> 38
    //   32: invokestatic 244	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 247	java/lang/Thread:interrupt	()V
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
  
  static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  private static CancellationException g(String paramString, Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  protected String Cn()
  {
    String str = null;
    if ((this.value instanceof a.f)) {
      throw null;
    }
    if ((this instanceof ScheduledFuture)) {
      str = "remaining delay=[" + ((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }
    return str;
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    checkNotNull(paramRunnable);
    checkNotNull(paramExecutor);
    Object localObject = this.bfG;
    if (localObject != d.bfM)
    {
      d locald2 = new d(paramRunnable, paramExecutor);
      d locald1;
      do
      {
        locald2.bfN = ((d)localObject);
        if (bfE.a(this, (d)localObject, locald2)) {
          return;
        }
        locald1 = this.bfG;
        localObject = locald1;
      } while (locald1 != d.bfM);
    }
    b(paramRunnable, paramExecutor);
  }
  
  protected boolean ap(V paramV)
  {
    Object localObject = paramV;
    if (paramV == null) {
      localObject = bfF;
    }
    if (bfE.a(this, null, localObject))
    {
      a(this);
      return true;
    }
    return false;
  }
  
  public final boolean cancel(boolean paramBoolean)
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
        if (!bfE.a(this, localObject1, localb)) {
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
          localb = b.bfI;
        } else {
          localb = b.bfJ;
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
  
  public final V get()
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
    localObject = this.bfH;
    if (localObject != h.bfT)
    {
      h localh2 = new h((byte)0);
      label156:
      label159:
      h localh1;
      do
      {
        localh2.b((h)localObject);
        if (bfE.a(this, (h)localObject, localh2)) {
          for (;;)
          {
            LockSupport.park(this);
            if (Thread.interrupted())
            {
              a(localh2);
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
        localh1 = this.bfH;
        localObject = localh1;
      } while (localh1 != h.bfT);
    }
    return ao(this.value);
  }
  
  public final V get(long paramLong, TimeUnit paramTimeUnit)
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
        localObject1 = this.bfH;
        if (localObject1 == h.bfT) {
          break label327;
        }
        localObject3 = new h((byte)0);
        ((h)localObject3).b((h)localObject1);
        if (!bfE.a(this, (h)localObject1, (h)localObject3)) {
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
          a((h)localObject3);
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
      a((h)localObject3);
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
        localObject2 = this.bfH;
        localObject1 = localObject2;
        if (localObject2 != h.bfT) {
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
    paramThrowable = new a.c((Throwable)checkNotNull(paramThrowable));
    if (bfE.a(this, null, paramThrowable))
    {
      a(this);
      return true;
    }
    return false;
  }
  
  public final boolean isCancelled()
  {
    return this.value instanceof b;
  }
  
  public final boolean isDone()
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
          String str1 = Cn();
          if ((str1 != null) && (!str1.isEmpty())) {
            localStringBuilder.append("PENDING, info=[").append(str1).append("]");
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            String str2 = "Exception thrown from implementation: " + localRuntimeException.getClass();
          }
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
    abstract void a(a.h paramh1, a.h paramh2);
    
    abstract void a(a.h paramh, Thread paramThread);
    
    abstract boolean a(a<?> parama, a.d paramd1, a.d paramd2);
    
    abstract boolean a(a<?> parama, a.h paramh1, a.h paramh2);
    
    abstract boolean a(a<?> parama, Object paramObject1, Object paramObject2);
  }
  
  static final class b
  {
    static final b bfI;
    static final b bfJ;
    final boolean bfK;
    final Throwable cause;
    
    static
    {
      AppMethodBeat.i(195299);
      if (a.bfC)
      {
        bfJ = null;
        bfI = null;
        AppMethodBeat.o(195299);
        return;
      }
      bfJ = new b(false, null);
      bfI = new b(true, null);
      AppMethodBeat.o(195299);
    }
    
    b(boolean paramBoolean, Throwable paramThrowable)
    {
      this.bfK = paramBoolean;
      this.cause = paramThrowable;
    }
  }
  
  static final class d
  {
    static final d bfM;
    d bfN;
    final Executor executor;
    final Runnable task;
    
    static
    {
      AppMethodBeat.i(195288);
      bfM = new d(null, null);
      AppMethodBeat.o(195288);
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
    final AtomicReferenceFieldUpdater<a.h, Thread> bfO;
    final AtomicReferenceFieldUpdater<a.h, a.h> bfP;
    final AtomicReferenceFieldUpdater<a, a.h> bfQ;
    final AtomicReferenceFieldUpdater<a, a.d> bfR;
    final AtomicReferenceFieldUpdater<a, Object> bfS;
    
    e(AtomicReferenceFieldUpdater<a.h, Thread> paramAtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<a.h, a.h> paramAtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<a, a.h> paramAtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, a.d> paramAtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, Object> paramAtomicReferenceFieldUpdater4)
    {
      super();
      this.bfO = paramAtomicReferenceFieldUpdater;
      this.bfP = paramAtomicReferenceFieldUpdater1;
      this.bfQ = paramAtomicReferenceFieldUpdater2;
      this.bfR = paramAtomicReferenceFieldUpdater3;
      this.bfS = paramAtomicReferenceFieldUpdater4;
    }
    
    final void a(a.h paramh1, a.h paramh2)
    {
      AppMethodBeat.i(195316);
      this.bfP.lazySet(paramh1, paramh2);
      AppMethodBeat.o(195316);
    }
    
    final void a(a.h paramh, Thread paramThread)
    {
      AppMethodBeat.i(195309);
      this.bfO.lazySet(paramh, paramThread);
      AppMethodBeat.o(195309);
    }
    
    final boolean a(a<?> parama, a.d paramd1, a.d paramd2)
    {
      AppMethodBeat.i(195331);
      boolean bool = this.bfR.compareAndSet(parama, paramd1, paramd2);
      AppMethodBeat.o(195331);
      return bool;
    }
    
    final boolean a(a<?> parama, a.h paramh1, a.h paramh2)
    {
      AppMethodBeat.i(195323);
      boolean bool = this.bfQ.compareAndSet(parama, paramh1, paramh2);
      AppMethodBeat.o(195323);
      return bool;
    }
    
    final boolean a(a<?> parama, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195341);
      boolean bool = this.bfS.compareAndSet(parama, paramObject1, paramObject2);
      AppMethodBeat.o(195341);
      return bool;
    }
  }
  
  static final class g
    extends a.a
  {
    g()
    {
      super();
    }
    
    final void a(a.h paramh1, a.h paramh2)
    {
      paramh1.bfU = paramh2;
    }
    
    final void a(a.h paramh, Thread paramThread)
    {
      paramh.thread = paramThread;
    }
    
    final boolean a(a<?> parama, a.d paramd1, a.d paramd2)
    {
      try
      {
        if (parama.bfG == paramd1)
        {
          parama.bfG = paramd2;
          return true;
        }
        return false;
      }
      finally
      {
        paramd1 = finally;
        throw paramd1;
      }
    }
    
    final boolean a(a<?> parama, a.h paramh1, a.h paramh2)
    {
      try
      {
        if (parama.bfH == paramh1)
        {
          parama.bfH = paramh2;
          return true;
        }
        return false;
      }
      finally
      {
        paramh1 = finally;
        throw paramh1;
      }
    }
    
    final boolean a(a<?> parama, Object paramObject1, Object paramObject2)
    {
      try
      {
        if (parama.value == paramObject1)
        {
          parama.value = paramObject2;
          return true;
        }
        return false;
      }
      finally
      {
        paramObject1 = finally;
        throw paramObject1;
      }
    }
  }
  
  static final class h
  {
    static final h bfT;
    volatile h bfU;
    volatile Thread thread;
    
    static
    {
      AppMethodBeat.i(195303);
      bfT = new h();
      AppMethodBeat.o(195303);
    }
    
    h() {}
    
    h(byte paramByte)
    {
      AppMethodBeat.i(195294);
      a.bfE.a(this, Thread.currentThread());
      AppMethodBeat.o(195294);
    }
    
    final void Co()
    {
      AppMethodBeat.i(195313);
      Thread localThread = this.thread;
      if (localThread != null)
      {
        this.thread = null;
        LockSupport.unpark(localThread);
      }
      AppMethodBeat.o(195313);
    }
    
    final void b(h paramh)
    {
      AppMethodBeat.i(195306);
      a.bfE.a(this, paramh);
      AppMethodBeat.o(195306);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.c.a.a
 * JD-Core Version:    0.7.0.1
 */