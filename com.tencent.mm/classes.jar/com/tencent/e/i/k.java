package com.tencent.e.i;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.d.e;
import com.tencent.e.f;
import com.tencent.e.g.b;
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
  private static final com.tencent.e.g.a.b ZuX;
  private static final com.tencent.e.f.a Zxg;
  private static final AtomicLong Zxh;
  private static final long Zxp;
  protected long GOR;
  private f GPl;
  private final long JiN;
  private final long Zxi;
  private volatile long Zxj;
  public Object Zxk;
  private String Zxl;
  private com.tencent.e.g.g Zxm;
  public com.tencent.e.h.d Zxn;
  public final int Zxo;
  private boolean isLogging;
  protected Thread thread;
  private Throwable throwable;
  protected long time;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    Zxg = new com.tencent.e.f.a()
    {
      public final void a(k paramAnonymousk)
      {
        AppMethodBeat.i(244387);
        if (com.tencent.e.c.b.Zwh != null) {
          com.tencent.e.c.b.Zwh.a(paramAnonymousk);
        }
        AppMethodBeat.o(244387);
      }
      
      public final void a(k paramAnonymousk, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(244386);
        if (com.tencent.e.c.b.Zwh != null) {
          com.tencent.e.c.b.Zwh.a(paramAnonymousk, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(244386);
      }
      
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(244384);
        if (com.tencent.e.c.b.Zwh != null) {
          com.tencent.e.c.b.Zwh.b(paramAnonymousk);
        }
        AppMethodBeat.o(244384);
      }
      
      public final void c(k paramAnonymousk)
      {
        AppMethodBeat.i(244388);
        if (com.tencent.e.c.b.Zwh != null) {
          com.tencent.e.c.b.Zwh.c(paramAnonymousk);
        }
        AppMethodBeat.o(244388);
      }
      
      public final void d(k paramAnonymousk)
      {
        AppMethodBeat.i(244383);
        if (com.tencent.e.c.b.Zwh != null) {
          com.tencent.e.c.b.Zwh.d(paramAnonymousk);
        }
        AppMethodBeat.o(244383);
      }
      
      public final void e(k paramAnonymousk)
      {
        AppMethodBeat.i(244389);
        if (com.tencent.e.c.b.Zwh != null) {
          com.tencent.e.c.b.Zwh.e(paramAnonymousk);
        }
        AppMethodBeat.o(244389);
      }
    };
    Zxh = new AtomicLong();
    ZuX = com.tencent.e.g.h.ZwG;
    Zxp = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.GOR = 0L;
    this.GPl = f.ZvA;
    this.Zxi = Zxh.getAndIncrement();
    this.Zxk = paramRunnable;
    this.Zxj = paramLong1;
    this.JiN = paramLong2;
    this.Zxl = getKey();
    this.Zxo = paramRunnable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (Zxg != null)) {
      Zxg.d(this);
    }
    com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.GOR = 0L;
    this.GPl = f.ZvA;
    this.Zxi = Zxh.getAndIncrement();
    this.Zxk = paramRunnable;
    this.Zxj = paramLong;
    this.JiN = 0L;
    this.Zxl = getKey();
    this.Zxo = paramRunnable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (Zxg != null)) {
      Zxg.d(this);
    }
    com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.GOR = 0L;
    this.GPl = f.ZvA;
    this.Zxi = Zxh.getAndIncrement();
    this.Zxk = paramCallable;
    this.Zxj = paramLong;
    this.JiN = 0L;
    this.Zxl = getKey();
    this.Zxo = paramCallable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (Zxg != null)) {
      Zxg.d(this);
    }
    com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  private void iqa()
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
  
  public static com.tencent.e.g.a.b iqb()
  {
    return ZuX;
  }
  
  private void k(Looper paramLooper)
  {
    AppMethodBeat.i(244395);
    g.b localb = com.tencent.e.a.Zvb;
    if ((localb.fop()) && (Zxp != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.foq()) {
        try
        {
          ((ThreadLocal)com.tencent.e.l.c.k(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(244395);
          return;
        }
        catch (Exception paramLooper)
        {
          this.throwable = paramLooper;
        }
      }
    }
    AppMethodBeat.o(244395);
  }
  
  public final void a(com.tencent.e.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.Zxn = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.GPl = f.Zvz;
      if ((this.isLogging) && (Zxg != null)) {
        Zxg.b(this);
      }
      com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, 0L, 0L, "", this.isLogging);
      if (this.Zxn != null) {
        this.Zxn.i(this);
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
    this.Zxk = null;
    AppMethodBeat.o(183388);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.GPl == f.ZvA) || (this.GPl == f.ZvB)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.Zxj - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.Zxl == null)
    {
      if ((this.Zxk instanceof g))
      {
        str = ((g)this.Zxk).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.Zxk.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.Zxl;
    AppMethodBeat.o(183385);
    return str;
  }
  
  public final Thread getThread()
  {
    return this.thread;
  }
  
  public final com.tencent.e.g.g iqc()
  {
    AppMethodBeat.i(183383);
    if (this.Zxm == null) {
      this.Zxm = ZuX.bDm(this.Zxl);
    }
    com.tencent.e.g.g localg = this.Zxm;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  public final long[] iqd()
  {
    if (this.GPl == f.ZvD) {
      return new long[] { this.GOR, this.time };
    }
    return new long[2];
  }
  
  public boolean isPeriodic()
  {
    return this.JiN != 0L;
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
    if (!ZuX.c(iqc()))
    {
      l1 = ZuX.a(iqc(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.Zxj = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.GPl = f.ZvB;
        this.Zxn.g(this);
        com.tencent.e.d.Zvu.a(getKey(), this.Zxo, iqc().ipV(), this.Zxj - System.nanoTime(), this.Zxn.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.GPl = f.Zvx;
      if ((this.isLogging) && (Zxg != null)) {
        Zxg.e(this);
      }
      com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, 0L, 0L, this.Zxn.getName(), this.isLogging);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.GOR = SystemClock.currentThreadTimeMillis();
    this.GPl = f.ZvC;
    com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, this.time, this.GOR, this.Zxn.getName(), this.isLogging);
    if ((this.isLogging) && (Zxg != null)) {
      Zxg.a(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.Zxn.isShutdown())
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
        this.GOR = (SystemClock.currentThreadTimeMillis() - this.GOR);
        if (this.GPl != f.Zvy) {
          this.GPl = f.ZvD;
        }
        if (Zxg != null) {}
        switch (2.Zxq[this.GPl.ordinal()])
        {
        default: 
          label432:
          k(localLooper);
          iqa();
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
      k(localLooper);
    }
    finally
    {
      this.time = (SystemClock.uptimeMillis() - this.time);
      this.GOR = (SystemClock.currentThreadTimeMillis() - this.GOR);
      if (this.GPl != f.Zvy) {
        this.GPl = f.ZvD;
      }
      if (Zxg != null) {
        switch (2.Zxq[this.GPl.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      iqa();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.JiN;
      long l2;
      if (l1 > 0L) {
        l2 = this.Zxj;
      }
      for (;;)
      {
        this.Zxj = (l1 + l2);
        if ((this.isLogging) && (Zxg != null)) {
          Zxg.d(this);
        }
        this.Zxn.g(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.isLogging) {
        Zxg.c(this);
      }
      com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.throwable);
      break label432;
      if (this.isLogging) {
        Zxg.a(this, this.GOR, this.time);
      }
      com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, this.time, this.GOR, this.Zxn.getName(), this.isLogging);
      break label432;
      if (this.isLogging) {
        Zxg.c(this);
      }
      com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.throwable);
      continue;
      if (this.isLogging) {
        Zxg.a(this, this.GOR, this.time);
      }
      com.tencent.e.d.Zvu.a(getKey(), this.Zxo, this.GPl, this.time, this.GOR, this.Zxn.getName(), this.isLogging);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.GPl = f.Zvy;
    this.throwable = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.i.k
 * JD-Core Version:    0.7.0.1
 */