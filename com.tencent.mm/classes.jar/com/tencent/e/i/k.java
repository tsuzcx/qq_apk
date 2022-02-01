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
  private static final com.tencent.e.g.a.b MpW;
  private static final com.tencent.e.f.a Msk;
  private static final AtomicLong Msl;
  private static final long Mss;
  private boolean Msi;
  private f Msj;
  private volatile long Msm;
  public Object Msn;
  private String Mso;
  private com.tencent.e.g.g Msp;
  public com.tencent.e.h.d Msq;
  public final int Msr;
  private final long aDT;
  private final long period;
  protected Thread thread;
  private Throwable throwable;
  protected long time;
  protected long wYx;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    Msk = com.tencent.e.c.b.Mrh;
    Msl = new AtomicLong();
    MpW = com.tencent.e.g.h.MrI;
    Mss = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.Msi = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.wYx = 0L;
    this.Msj = f.Mqz;
    this.aDT = Msl.getAndIncrement();
    this.Msn = paramRunnable;
    this.Msm = paramLong1;
    this.period = paramLong2;
    this.Mso = getKey();
    this.Msr = paramRunnable.hashCode();
    this.Msi = paramBoolean;
    if ((paramBoolean) && (Msk != null)) {
      Msk.a(this);
    }
    com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.Msi = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.wYx = 0L;
    this.Msj = f.Mqz;
    this.aDT = Msl.getAndIncrement();
    this.Msn = paramRunnable;
    this.Msm = paramLong;
    this.period = 0L;
    this.Mso = getKey();
    this.Msr = paramRunnable.hashCode();
    this.Msi = paramBoolean;
    if ((paramBoolean) && (Msk != null)) {
      Msk.a(this);
    }
    com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.Msi = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.wYx = 0L;
    this.Msj = f.Mqz;
    this.aDT = Msl.getAndIncrement();
    this.Msn = paramCallable;
    this.Msm = paramLong;
    this.period = 0L;
    this.Mso = getKey();
    this.Msr = paramCallable.hashCode();
    this.Msi = paramBoolean;
    if ((paramBoolean) && (Msk != null)) {
      Msk.a(this);
    }
    com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  private void gao()
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
  
  public static com.tencent.e.g.a.b gap()
  {
    return MpW;
  }
  
  private void o(Looper paramLooper)
  {
    AppMethodBeat.i(216746);
    g.b localb = com.tencent.e.a.Mqa;
    if ((localb.dCm()) && (Mss != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.dCn()) {
        try
        {
          ((ThreadLocal)com.tencent.e.k.c.f(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(216746);
          return;
        }
        catch (Exception paramLooper)
        {
          this.throwable = paramLooper;
        }
      }
    }
    AppMethodBeat.o(216746);
  }
  
  public final void a(com.tencent.e.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.Msq = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.Msj = f.Mqy;
      if ((this.Msi) && (Msk != null)) {
        Msk.b(this);
      }
      com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, 0L, 0L, "", this.Msi);
      if (this.Msq != null) {
        this.Msq.j(this);
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
    this.Msn = null;
    AppMethodBeat.o(183388);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.Msj == f.Mqz) || (this.Msj == f.MqA)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public final com.tencent.e.g.g gaq()
  {
    AppMethodBeat.i(183383);
    if (this.Msp == null) {
      this.Msp = MpW.bbh(this.Mso);
    }
    com.tencent.e.g.g localg = this.Msp;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  public final long[] gar()
  {
    if (this.Msj == f.MqC) {
      return new long[] { this.wYx, this.time };
    }
    return new long[2];
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.Msm - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.Mso == null)
    {
      if ((this.Msn instanceof g))
      {
        str = ((g)this.Msn).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.Msn.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.Mso;
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
    if (!MpW.c(gaq()))
    {
      l1 = MpW.a(gaq(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.Msm = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.Msj = f.MqA;
        this.Msq.h(this);
        com.tencent.e.d.Mqt.a(getKey(), this.Msr, gaq().gaj(), this.Msm - System.nanoTime(), this.Msq.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.Msj = f.Mqw;
      if ((this.Msi) && (Msk != null)) {
        Msk.f(this);
      }
      com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, 0L, 0L, this.Msq.getName(), this.Msi);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.wYx = SystemClock.currentThreadTimeMillis();
    this.Msj = f.MqB;
    com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, this.time, this.wYx, this.Msq.getName(), this.Msi);
    if ((this.Msi) && (Msk != null)) {
      Msk.d(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.Msq.isShutdown())
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
        this.wYx = (SystemClock.currentThreadTimeMillis() - this.wYx);
        if (this.Msj != f.Mqx) {
          this.Msj = f.MqC;
        }
        if (Msk != null) {}
        switch (1.Mst[this.Msj.ordinal()])
        {
        default: 
          label432:
          o(localLooper);
          gao();
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
      this.wYx = (SystemClock.currentThreadTimeMillis() - this.wYx);
      if (this.Msj != f.Mqx) {
        this.Msj = f.MqC;
      }
      if (Msk != null) {
        switch (1.Mst[this.Msj.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      gao();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.period;
      long l2;
      if (l1 > 0L) {
        l2 = this.Msm;
      }
      for (;;)
      {
        this.Msm = (l1 + l2);
        if ((this.Msi) && (Msk != null)) {
          Msk.a(this);
        }
        this.Msq.h(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.Msi) {
        Msk.e(this);
      }
      com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.throwable);
      break label432;
      if (this.Msi) {
        Msk.c(this);
      }
      com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, this.time, this.wYx, this.Msq.getName(), this.Msi);
      break label432;
      if (this.Msi) {
        Msk.e(this);
      }
      com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.throwable);
      continue;
      if (this.Msi) {
        Msk.c(this);
      }
      com.tencent.e.d.Mqt.a(getKey(), this.Msr, this.Msj, this.time, this.wYx, this.Msq.getName(), this.Msi);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.Msj = f.Mqx;
    this.throwable = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.i.k
 * JD-Core Version:    0.7.0.1
 */