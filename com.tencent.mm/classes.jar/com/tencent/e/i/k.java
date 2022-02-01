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
  private static final com.tencent.e.g.a.b LSZ;
  private static final com.tencent.e.f.a LVp;
  private static final AtomicLong LVq;
  private static final long LVx;
  private boolean LVn;
  private f LVo;
  private volatile long LVr;
  public Object LVs;
  private String LVt;
  private com.tencent.e.g.g LVu;
  public com.tencent.e.h.d LVv;
  public final int LVw;
  private final long aDT;
  private final long period;
  protected Thread thread;
  private Throwable throwable;
  protected long time;
  protected long wIM;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    LVp = com.tencent.e.c.b.LUm;
    LVq = new AtomicLong();
    LSZ = com.tencent.e.g.h.LUN;
    LVx = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.LVn = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.wIM = 0L;
    this.LVo = f.LTC;
    this.aDT = LVq.getAndIncrement();
    this.LVs = paramRunnable;
    this.LVr = paramLong1;
    this.period = paramLong2;
    this.LVt = getKey();
    this.LVw = paramRunnable.hashCode();
    this.LVn = paramBoolean;
    if ((paramBoolean) && (LVp != null)) {
      LVp.a(this);
    }
    com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.LVn = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.wIM = 0L;
    this.LVo = f.LTC;
    this.aDT = LVq.getAndIncrement();
    this.LVs = paramRunnable;
    this.LVr = paramLong;
    this.period = 0L;
    this.LVt = getKey();
    this.LVw = paramRunnable.hashCode();
    this.LVn = paramBoolean;
    if ((paramBoolean) && (LVp != null)) {
      LVp.a(this);
    }
    com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.LVn = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.wIM = 0L;
    this.LVo = f.LTC;
    this.aDT = LVq.getAndIncrement();
    this.LVs = paramCallable;
    this.LVr = paramLong;
    this.period = 0L;
    this.LVt = getKey();
    this.LVw = paramCallable.hashCode();
    this.LVn = paramBoolean;
    if ((paramBoolean) && (LVp != null)) {
      LVp.a(this);
    }
    com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  private void fVP()
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
  
  public static com.tencent.e.g.a.b fVQ()
  {
    return LSZ;
  }
  
  private void o(Looper paramLooper)
  {
    AppMethodBeat.i(219284);
    g.b localb = com.tencent.e.a.LTd;
    if ((localb.dyV()) && (LVx != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.dyW()) {
        try
        {
          ((ThreadLocal)com.tencent.e.k.c.f(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(219284);
          return;
        }
        catch (Exception paramLooper)
        {
          this.throwable = paramLooper;
        }
      }
    }
    AppMethodBeat.o(219284);
  }
  
  public final void a(com.tencent.e.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.LVv = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.LVo = f.LTB;
      if ((this.LVn) && (LVp != null)) {
        LVp.b(this);
      }
      com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, 0L, 0L, "", this.LVn);
      if (this.LVv != null) {
        this.LVv.j(this);
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
    this.LVs = null;
    AppMethodBeat.o(183388);
  }
  
  public final com.tencent.e.g.g fVR()
  {
    AppMethodBeat.i(183383);
    if (this.LVu == null) {
      this.LVu = LSZ.aZE(this.LVt);
    }
    com.tencent.e.g.g localg = this.LVu;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  public final long[] fVS()
  {
    if (this.LVo == f.LTG) {
      return new long[] { this.wIM, this.time };
    }
    return new long[2];
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.LVo == f.LTC) || (this.LVo == f.LTD)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.LVr - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.LVt == null)
    {
      if ((this.LVs instanceof g))
      {
        str = ((g)this.LVs).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.LVs.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.LVt;
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
    if (!LSZ.c(fVR()))
    {
      l1 = LSZ.a(fVR(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.LVr = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.LVo = f.LTD;
        this.LVv.h(this);
        com.tencent.e.d.LTw.a(getKey(), this.LVw, fVR().fVK(), this.LVr - System.nanoTime(), this.LVv.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.LVo = f.LTz;
      if ((this.LVn) && (LVp != null)) {
        LVp.f(this);
      }
      com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, 0L, 0L, this.LVv.getName(), this.LVn);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.wIM = SystemClock.currentThreadTimeMillis();
    this.LVo = f.LTF;
    com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, this.time, this.wIM, this.LVv.getName(), this.LVn);
    if ((this.LVn) && (LVp != null)) {
      LVp.d(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.LVv.isShutdown())
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
        this.wIM = (SystemClock.currentThreadTimeMillis() - this.wIM);
        if (this.LVo != f.LTA) {
          this.LVo = f.LTG;
        }
        if (LVp != null) {}
        switch (1.LVy[this.LVo.ordinal()])
        {
        default: 
          label432:
          o(localLooper);
          fVP();
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
      this.wIM = (SystemClock.currentThreadTimeMillis() - this.wIM);
      if (this.LVo != f.LTA) {
        this.LVo = f.LTG;
      }
      if (LVp != null) {
        switch (1.LVy[this.LVo.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      fVP();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.period;
      long l2;
      if (l1 > 0L) {
        l2 = this.LVr;
      }
      for (;;)
      {
        this.LVr = (l1 + l2);
        if ((this.LVn) && (LVp != null)) {
          LVp.a(this);
        }
        this.LVv.h(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.LVn) {
        LVp.e(this);
      }
      com.tencent.e.d.LTw.a(getKey(), this.LVw, this.throwable);
      break label432;
      if (this.LVn) {
        LVp.c(this);
      }
      com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, this.time, this.wIM, this.LVv.getName(), this.LVn);
      break label432;
      if (this.LVn) {
        LVp.e(this);
      }
      com.tencent.e.d.LTw.a(getKey(), this.LVw, this.throwable);
      continue;
      if (this.LVn) {
        LVp.c(this);
      }
      com.tencent.e.d.LTw.a(getKey(), this.LVw, this.LVo, this.time, this.wIM, this.LVv.getName(), this.LVn);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.LVo = f.LTA;
    this.throwable = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.i.k
 * JD-Core Version:    0.7.0.1
 */