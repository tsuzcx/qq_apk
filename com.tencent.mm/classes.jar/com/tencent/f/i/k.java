package com.tencent.f.i;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.f.d.e;
import com.tencent.f.f;
import com.tencent.f.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class k<V>
  extends FutureTask<V>
  implements c, d<V>, h, Delayed, RunnableScheduledFuture<V>
{
  private static final com.tencent.f.g.a.b RSt;
  private static final com.tencent.f.f.a RUF;
  private static final AtomicLong RUG;
  private static final long RUN;
  protected long AVw;
  private f RUE;
  private volatile long RUH;
  public Object RUI;
  private String RUJ;
  private com.tencent.f.g.g RUK;
  public com.tencent.f.h.d RUL;
  public final int RUM;
  private final long aDT;
  private boolean isLogging;
  private final long period;
  protected Thread thread;
  private Throwable throwable;
  protected long time;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    RUF = new com.tencent.f.f.a()
    {
      public final void a(k paramAnonymousk)
      {
        AppMethodBeat.i(256679);
        if (com.tencent.f.c.b.RTE != null) {
          com.tencent.f.c.b.RTE.a(paramAnonymousk);
        }
        AppMethodBeat.o(256679);
      }
      
      public final void a(k paramAnonymousk, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(256678);
        if (com.tencent.f.c.b.RTE != null) {
          com.tencent.f.c.b.RTE.a(paramAnonymousk, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(256678);
      }
      
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(256677);
        if (com.tencent.f.c.b.RTE != null) {
          com.tencent.f.c.b.RTE.b(paramAnonymousk);
        }
        AppMethodBeat.o(256677);
      }
      
      public final void c(k paramAnonymousk)
      {
        AppMethodBeat.i(256680);
        if (com.tencent.f.c.b.RTE != null) {
          com.tencent.f.c.b.RTE.c(paramAnonymousk);
        }
        AppMethodBeat.o(256680);
      }
      
      public final void d(k paramAnonymousk)
      {
        AppMethodBeat.i(256676);
        if (com.tencent.f.c.b.RTE != null) {
          com.tencent.f.c.b.RTE.d(paramAnonymousk);
        }
        AppMethodBeat.o(256676);
      }
      
      public final void e(k paramAnonymousk)
      {
        AppMethodBeat.i(256681);
        if (com.tencent.f.c.b.RTE != null) {
          com.tencent.f.c.b.RTE.e(paramAnonymousk);
        }
        AppMethodBeat.o(256681);
      }
    };
    RUG = new AtomicLong();
    RSt = com.tencent.f.g.h.RUe;
    RUN = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.AVw = 0L;
    this.RUE = f.RSW;
    this.aDT = RUG.getAndIncrement();
    this.RUI = paramRunnable;
    this.RUH = paramLong1;
    this.period = paramLong2;
    this.RUJ = getKey();
    this.RUM = paramRunnable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (RUF != null)) {
      RUF.d(this);
    }
    com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.AVw = 0L;
    this.RUE = f.RSW;
    this.aDT = RUG.getAndIncrement();
    this.RUI = paramRunnable;
    this.RUH = paramLong;
    this.period = 0L;
    this.RUJ = getKey();
    this.RUM = paramRunnable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (RUF != null)) {
      RUF.d(this);
    }
    com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.AVw = 0L;
    this.RUE = f.RSW;
    this.aDT = RUG.getAndIncrement();
    this.RUI = paramCallable;
    this.RUH = paramLong;
    this.period = 0L;
    this.RUJ = getKey();
    this.RUM = paramCallable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (RUF != null)) {
      RUF.d(this);
    }
    com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  public static com.tencent.f.g.a.b hmA()
  {
    return RSt;
  }
  
  private void hmz()
  {
    AppMethodBeat.i(183380);
    if (this.throwable != null)
    {
      if ((this.throwable instanceof RuntimeException))
      {
        localObject = (RuntimeException)this.throwable;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      if ((this.throwable instanceof Error))
      {
        localObject = (Error)this.throwable;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      Object localObject = new Error(this.throwable);
      AppMethodBeat.o(183380);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(183380);
  }
  
  private void i(Looper paramLooper)
  {
    AppMethodBeat.i(256683);
    g.b localb = com.tencent.f.a.RSx;
    if ((localb.eCC()) && (RUN != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.eCD()) {
        try
        {
          ((ThreadLocal)com.tencent.f.k.c.l(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(256683);
          return;
        }
        catch (Exception paramLooper)
        {
          this.throwable = paramLooper;
        }
      }
    }
    AppMethodBeat.o(256683);
  }
  
  public final void a(com.tencent.f.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.RUL = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.RUE = f.RSV;
      if ((this.isLogging) && (RUF != null)) {
        RUF.b(this);
      }
      com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, 0L, 0L, "", this.isLogging);
      if (this.RUL != null) {
        this.RUL.i(this);
      }
      AppMethodBeat.o(183381);
      return true;
    }
    AppMethodBeat.o(183381);
    return false;
  }
  
  protected void done()
  {
    AppMethodBeat.i(183388);
    super.done();
    this.RUI = null;
    AppMethodBeat.o(183388);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.RUE == f.RSW) || (this.RUE == f.RSX)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.RUH - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.RUJ == null)
    {
      if ((this.RUI instanceof g))
      {
        str = ((g)this.RUI).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.RUI.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.RUJ;
    AppMethodBeat.o(183385);
    return str;
  }
  
  public final Thread getThread()
  {
    return this.thread;
  }
  
  public final com.tencent.f.g.g hmB()
  {
    AppMethodBeat.i(183383);
    if (this.RUK == null) {
      this.RUK = RSt.bqs(this.RUJ);
    }
    com.tencent.f.g.g localg = this.RUK;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  public final long[] hmC()
  {
    if (this.RUE == f.RSZ) {
      return new long[] { this.AVw, this.time };
    }
    return new long[2];
  }
  
  public boolean isPeriodic()
  {
    return this.period != 0L;
  }
  
  public void run()
  {
    AppMethodBeat.i(183379);
    if (isCancelled())
    {
      AppMethodBeat.o(183379);
      return;
    }
    long l1;
    int i;
    if (!RSt.c(hmB()))
    {
      l1 = RSt.a(hmB(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.RUH = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.RUE = f.RSX;
        this.RUL.g(this);
        com.tencent.f.d.RSQ.a(getKey(), this.RUM, hmB().hmu(), this.RUH - System.nanoTime(), this.RUL.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.RUE = f.RST;
      if ((this.isLogging) && (RUF != null)) {
        RUF.e(this);
      }
      com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, 0L, 0L, this.RUL.getName(), this.isLogging);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.AVw = SystemClock.currentThreadTimeMillis();
    this.RUE = f.RSY;
    com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, this.time, this.AVw, this.RUL.getName(), this.isLogging);
    if ((this.isLogging) && (RUF != null)) {
      RUF.a(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.RUL.isShutdown())
      {
        i = 1;
        label342:
        if (i != 0) {
          break label454;
        }
        cancel(false);
      }
      for (;;)
      {
        this.time = (SystemClock.uptimeMillis() - this.time);
        this.AVw = (SystemClock.currentThreadTimeMillis() - this.AVw);
        if (this.RUE != f.RSU) {
          this.RUE = f.RSZ;
        }
        if (RUF != null) {}
        switch (2.RUO[this.RUE.ordinal()])
        {
        default: 
          label432:
          i(localLooper);
          hmz();
          AppMethodBeat.o(183379);
          return;
          i = 0;
          break label342;
          label454:
          if (bool) {
            break label567;
          }
          super.run();
        }
      }
      i(localLooper);
    }
    finally
    {
      this.time = (SystemClock.uptimeMillis() - this.time);
      this.AVw = (SystemClock.currentThreadTimeMillis() - this.AVw);
      if (this.RUE != f.RSU) {
        this.RUE = f.RSZ;
      }
      if (RUF != null) {
        switch (2.RUO[this.RUE.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      hmz();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.period;
      long l2;
      if (l1 > 0L) {
        l2 = this.RUH;
      }
      for (;;)
      {
        this.RUH = (l1 + l2);
        if ((this.isLogging) && (RUF != null)) {
          RUF.d(this);
        }
        this.RUL.g(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.isLogging) {
        RUF.c(this);
      }
      com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.throwable);
      break label432;
      if (this.isLogging) {
        RUF.a(this, this.AVw, this.time);
      }
      com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, this.time, this.AVw, this.RUL.getName(), this.isLogging);
      break label432;
      if (this.isLogging) {
        RUF.c(this);
      }
      com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.throwable);
      continue;
      if (this.isLogging) {
        RUF.a(this, this.AVw, this.time);
      }
      com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, this.time, this.AVw, this.RUL.getName(), this.isLogging);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.RUE = f.RSU;
    this.throwable = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.i.k
 * JD-Core Version:    0.7.0.1
 */