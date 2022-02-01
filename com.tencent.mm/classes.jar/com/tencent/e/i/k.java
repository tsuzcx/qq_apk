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
  private static final com.tencent.e.g.a.b JZe;
  private static final long KbA;
  private static final com.tencent.e.f.a Kbs;
  private static final AtomicLong Kbt;
  private Throwable KbB;
  private boolean Kbq;
  private f Kbr;
  private volatile long Kbu;
  public Object Kbv;
  private String Kbw;
  private com.tencent.e.g.g Kbx;
  public com.tencent.e.h.d Kby;
  public final int Kbz;
  private final long aCc;
  private final long period;
  protected Thread thread;
  protected long time;
  protected long vCR;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    Kbs = com.tencent.e.c.b.Kap;
    Kbt = new AtomicLong();
    JZe = com.tencent.e.g.h.KaQ;
    KbA = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.Kbq = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.vCR = 0L;
    this.Kbr = f.JZH;
    this.aCc = Kbt.getAndIncrement();
    this.Kbv = paramRunnable;
    this.Kbu = paramLong1;
    this.period = paramLong2;
    this.Kbw = getKey();
    this.Kbz = paramRunnable.hashCode();
    this.Kbq = paramBoolean;
    if ((paramBoolean) && (Kbs != null)) {
      Kbs.a(this);
    }
    com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.Kbq = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.vCR = 0L;
    this.Kbr = f.JZH;
    this.aCc = Kbt.getAndIncrement();
    this.Kbv = paramRunnable;
    this.Kbu = paramLong;
    this.period = 0L;
    this.Kbw = getKey();
    this.Kbz = paramRunnable.hashCode();
    this.Kbq = paramBoolean;
    if ((paramBoolean) && (Kbs != null)) {
      Kbs.a(this);
    }
    com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.Kbq = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.vCR = 0L;
    this.Kbr = f.JZH;
    this.aCc = Kbt.getAndIncrement();
    this.Kbv = paramCallable;
    this.Kbu = paramLong;
    this.period = 0L;
    this.Kbw = getKey();
    this.Kbz = paramCallable.hashCode();
    this.Kbq = paramBoolean;
    if ((paramBoolean) && (Kbs != null)) {
      Kbs.a(this);
    }
    com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  private void fEx()
  {
    AppMethodBeat.i(183380);
    if (this.KbB != null)
    {
      if ((this.KbB instanceof RuntimeException))
      {
        localObject = (RuntimeException)this.KbB;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      if ((this.KbB instanceof Error))
      {
        localObject = (Error)this.KbB;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      Object localObject = new Error(this.KbB);
      AppMethodBeat.o(183380);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(183380);
  }
  
  public static com.tencent.e.g.a.b fEy()
  {
    return JZe;
  }
  
  private void o(Looper paramLooper)
  {
    AppMethodBeat.i(191088);
    g.b localb = com.tencent.e.a.JZi;
    if ((localb.doB()) && (KbA != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.doC()) {
        try
        {
          ((ThreadLocal)com.tencent.e.k.c.f(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(191088);
          return;
        }
        catch (Exception paramLooper)
        {
          this.KbB = paramLooper;
        }
      }
    }
    AppMethodBeat.o(191088);
  }
  
  public final void a(com.tencent.e.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.Kby = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.Kbr = f.JZG;
      if ((this.Kbq) && (Kbs != null)) {
        Kbs.b(this);
      }
      com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, 0L, 0L, "", this.Kbq);
      if (this.Kby != null) {
        this.Kby.j(this);
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
    this.Kbv = null;
    AppMethodBeat.o(183388);
  }
  
  public final long[] fEA()
  {
    if (this.Kbr == f.JZK) {
      return new long[] { this.vCR, this.time };
    }
    return new long[2];
  }
  
  public final com.tencent.e.g.g fEz()
  {
    AppMethodBeat.i(183383);
    if (this.Kbx == null) {
      this.Kbx = JZe.aTE(this.Kbw);
    }
    com.tencent.e.g.g localg = this.Kbx;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.Kbr == f.JZH) || (this.Kbr == f.JZI)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.Kbu - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.Kbw == null)
    {
      if ((this.Kbv instanceof g))
      {
        str = ((g)this.Kbv).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.Kbv.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.Kbw;
    AppMethodBeat.o(183385);
    return str;
  }
  
  public final Thread getThread()
  {
    return this.thread;
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
    if (!JZe.c(fEz()))
    {
      l1 = JZe.a(fEz(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.Kbu = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.Kbr = f.JZI;
        this.Kby.h(this);
        com.tencent.e.d.JZB.a(getKey(), this.Kbz, fEz().fEs(), this.Kbu - System.nanoTime(), this.Kby.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.Kbr = f.JZE;
      if ((this.Kbq) && (Kbs != null)) {
        Kbs.f(this);
      }
      com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, 0L, 0L, this.Kby.getName(), this.Kbq);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.vCR = SystemClock.currentThreadTimeMillis();
    this.Kbr = f.JZJ;
    com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, this.time, this.vCR, this.Kby.getName(), this.Kbq);
    if ((this.Kbq) && (Kbs != null)) {
      Kbs.d(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.Kby.isShutdown())
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
        this.vCR = (SystemClock.currentThreadTimeMillis() - this.vCR);
        if (this.Kbr != f.JZF) {
          this.Kbr = f.JZK;
        }
        if (Kbs != null) {}
        switch (1.KbC[this.Kbr.ordinal()])
        {
        default: 
          label432:
          o(localLooper);
          fEx();
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
      o(localLooper);
    }
    finally
    {
      this.time = (SystemClock.uptimeMillis() - this.time);
      this.vCR = (SystemClock.currentThreadTimeMillis() - this.vCR);
      if (this.Kbr != f.JZF) {
        this.Kbr = f.JZK;
      }
      if (Kbs != null) {
        switch (1.KbC[this.Kbr.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      fEx();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.period;
      long l2;
      if (l1 > 0L) {
        l2 = this.Kbu;
      }
      for (;;)
      {
        this.Kbu = (l1 + l2);
        if ((this.Kbq) && (Kbs != null)) {
          Kbs.a(this);
        }
        this.Kby.h(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.Kbq) {
        Kbs.e(this);
      }
      com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.KbB);
      break label432;
      if (this.Kbq) {
        Kbs.c(this);
      }
      com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, this.time, this.vCR, this.Kby.getName(), this.Kbq);
      break label432;
      if (this.Kbq) {
        Kbs.e(this);
      }
      com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.KbB);
      continue;
      if (this.Kbq) {
        Kbs.c(this);
      }
      com.tencent.e.d.JZB.a(getKey(), this.Kbz, this.Kbr, this.time, this.vCR, this.Kby.getName(), this.Kbq);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.Kbr = f.JZF;
    this.KbB = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.i.k
 * JD-Core Version:    0.7.0.1
 */