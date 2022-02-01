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
  private static final com.tencent.e.g.a.b Ixv;
  private static final com.tencent.e.f.a IzJ;
  private static final AtomicLong IzK;
  private static final long IzR;
  private boolean IzH;
  private f IzI;
  private volatile long IzL;
  public Object IzM;
  private String IzN;
  private com.tencent.e.g.g IzO;
  public com.tencent.e.h.d IzP;
  public final int IzQ;
  private Throwable IzS;
  private final long aBj;
  private final long period;
  protected Thread thread;
  protected long time;
  protected long utu;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    IzJ = com.tencent.e.c.b.IyG;
    IzK = new AtomicLong();
    Ixv = com.tencent.e.g.h.Izh;
    IzR = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.IzH = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.utu = 0L;
    this.IzI = f.IxY;
    this.aBj = IzK.getAndIncrement();
    this.IzM = paramRunnable;
    this.IzL = paramLong1;
    this.period = paramLong2;
    this.IzN = getKey();
    this.IzQ = paramRunnable.hashCode();
    this.IzH = paramBoolean;
    if ((paramBoolean) && (IzJ != null)) {
      IzJ.a(this);
    }
    com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.IzH = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.utu = 0L;
    this.IzI = f.IxY;
    this.aBj = IzK.getAndIncrement();
    this.IzM = paramRunnable;
    this.IzL = paramLong;
    this.period = 0L;
    this.IzN = getKey();
    this.IzQ = paramRunnable.hashCode();
    this.IzH = paramBoolean;
    if ((paramBoolean) && (IzJ != null)) {
      IzJ.a(this);
    }
    com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.IzH = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.utu = 0L;
    this.IzI = f.IxY;
    this.aBj = IzK.getAndIncrement();
    this.IzM = paramCallable;
    this.IzL = paramLong;
    this.period = 0L;
    this.IzN = getKey();
    this.IzQ = paramCallable.hashCode();
    this.IzH = paramBoolean;
    if ((paramBoolean) && (IzJ != null)) {
      IzJ.a(this);
    }
    com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  private void foh()
  {
    AppMethodBeat.i(183380);
    if (this.IzS != null)
    {
      if ((this.IzS instanceof RuntimeException))
      {
        localObject = (RuntimeException)this.IzS;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      if ((this.IzS instanceof Error))
      {
        localObject = (Error)this.IzS;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      Object localObject = new Error(this.IzS);
      AppMethodBeat.o(183380);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(183380);
  }
  
  public static com.tencent.e.g.a.b foi()
  {
    return Ixv;
  }
  
  private void o(Looper paramLooper)
  {
    AppMethodBeat.i(186960);
    g.b localb = com.tencent.e.a.Ixz;
    if ((localb.daR()) && (IzR != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.daS()) {
        try
        {
          ((ThreadLocal)com.tencent.e.k.c.f(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(186960);
          return;
        }
        catch (Exception paramLooper)
        {
          this.IzS = paramLooper;
        }
      }
    }
    AppMethodBeat.o(186960);
  }
  
  public final void a(com.tencent.e.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.IzP = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.IzI = f.IxX;
      if ((this.IzH) && (IzJ != null)) {
        IzJ.b(this);
      }
      com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, 0L, 0L, "", this.IzH);
      if (this.IzP != null) {
        this.IzP.j(this);
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
    this.IzM = null;
    AppMethodBeat.o(183388);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.IzI == f.IxY) || (this.IzI == f.IxZ)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public final com.tencent.e.g.g foj()
  {
    AppMethodBeat.i(183383);
    if (this.IzO == null) {
      this.IzO = Ixv.aOb(this.IzN);
    }
    com.tencent.e.g.g localg = this.IzO;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  public final long[] fok()
  {
    if (this.IzI == f.Iyb) {
      return new long[] { this.utu, this.time };
    }
    return new long[2];
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.IzL - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.IzN == null)
    {
      if ((this.IzM instanceof g))
      {
        str = ((g)this.IzM).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.IzM.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.IzN;
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
    if (!Ixv.c(foj()))
    {
      l1 = Ixv.a(foj(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.IzL = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.IzI = f.IxZ;
        this.IzP.h(this);
        com.tencent.e.d.IxS.a(getKey(), this.IzQ, foj().foc(), this.IzL - System.nanoTime(), this.IzP.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.IzI = f.IxV;
      if ((this.IzH) && (IzJ != null)) {
        IzJ.f(this);
      }
      com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, 0L, 0L, this.IzP.getName(), this.IzH);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.utu = SystemClock.currentThreadTimeMillis();
    this.IzI = f.Iya;
    com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, this.time, this.utu, this.IzP.getName(), this.IzH);
    if ((this.IzH) && (IzJ != null)) {
      IzJ.d(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.IzP.isShutdown())
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
        this.utu = (SystemClock.currentThreadTimeMillis() - this.utu);
        if (this.IzI != f.IxW) {
          this.IzI = f.Iyb;
        }
        if (IzJ != null) {}
        switch (1.IzT[this.IzI.ordinal()])
        {
        default: 
          label432:
          o(localLooper);
          foh();
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
      this.utu = (SystemClock.currentThreadTimeMillis() - this.utu);
      if (this.IzI != f.IxW) {
        this.IzI = f.Iyb;
      }
      if (IzJ != null) {
        switch (1.IzT[this.IzI.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      foh();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.period;
      long l2;
      if (l1 > 0L) {
        l2 = this.IzL;
      }
      for (;;)
      {
        this.IzL = (l1 + l2);
        if ((this.IzH) && (IzJ != null)) {
          IzJ.a(this);
        }
        this.IzP.h(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.IzH) {
        IzJ.e(this);
      }
      com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzS);
      break label432;
      if (this.IzH) {
        IzJ.c(this);
      }
      com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, this.time, this.utu, this.IzP.getName(), this.IzH);
      break label432;
      if (this.IzH) {
        IzJ.e(this);
      }
      com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzS);
      continue;
      if (this.IzH) {
        IzJ.c(this);
      }
      com.tencent.e.d.IxS.a(getKey(), this.IzQ, this.IzI, this.time, this.utu, this.IzP.getName(), this.IzH);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.IzI = f.IxW;
    this.IzS = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.i.k
 * JD-Core Version:    0.7.0.1
 */