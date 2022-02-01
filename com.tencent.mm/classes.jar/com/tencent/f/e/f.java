package com.tencent.f.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.f.d;
import com.tencent.f.d.a;
import com.tencent.f.d.b;
import com.tencent.f.j.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f<E>
  extends e<E>
{
  f() {}
  
  f(E paramE)
  {
    super(paramE);
  }
  
  private g hmt()
  {
    AppMethodBeat.i(183310);
    if ((com.tencent.f.j.a.hmE() == null) && (Looper.myLooper() == null))
    {
      localObject = new RuntimeException(String.format("fail to create DefaultScheduler. Current thread[%s-%s] without a Looper or Serial.", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()) }));
      AppMethodBeat.o(183310);
      throw ((Throwable)localObject);
    }
    Object localObject = new g()
    {
      private com.tencent.f.d.a RTV;
      
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(183303);
        this.RTV.post(paramAnonymousRunnable);
        AppMethodBeat.o(183303);
      }
      
      public final String getTag()
      {
        AppMethodBeat.i(183304);
        if ((this.RTV instanceof c))
        {
          str = this.RTV.getSerialTag();
          AppMethodBeat.o(183304);
          return str;
        }
        String str = com.tencent.f.j.a.j(this.RTV.getLooper());
        AppMethodBeat.o(183304);
        return str;
      }
      
      public final void onShutdown()
      {
        AppMethodBeat.i(183305);
        this.RTV.removeCallbacksAndMessages(null);
        AppMethodBeat.o(183305);
      }
    };
    AppMethodBeat.o(183310);
    return localObject;
  }
  
  public final void begin()
  {
    AppMethodBeat.i(183307);
    Object localObject = this;
    if (!this.pCM.compareAndSet(false, true))
    {
      d.RSS.w("Pipeline", "this pipeline has begin.", new Object[0]);
      AppMethodBeat.o(183307);
      return;
    }
    while (((e)localObject).RTQ != null) {
      localObject = ((e)localObject).RTQ;
    }
    ((e)localObject).b(((e)localObject).RTO);
    AppMethodBeat.o(183307);
  }
  
  public final <R> f<R> c(a<E, R> parama)
  {
    AppMethodBeat.i(183306);
    Objects.requireNonNull(parama);
    f localf = new f();
    localf.RTN = hmr();
    localf.RTQ = this;
    this.RTR = localf;
    this.RTO = parama;
    AppMethodBeat.o(183306);
    return localf;
  }
  
  final a<Throwable, ?> hmo()
  {
    for (Object localObject = this; (localObject != null) && (((e)localObject).RTP == null); localObject = ((e)localObject).RTR) {}
    if (localObject != null) {
      return ((e)localObject).RTP;
    }
    return null;
  }
  
  public final g hmr()
  {
    AppMethodBeat.i(183309);
    if (this.RTN == null)
    {
      localg = hmt();
      AppMethodBeat.o(183309);
      return localg;
    }
    g localg = this.RTN;
    AppMethodBeat.o(183309);
    return localg;
  }
  
  public final f<E> hms()
  {
    this.RTN = RTH;
    return this;
  }
  
  public final E take()
  {
    AppMethodBeat.i(183308);
    if (this.RTM == null)
    {
      localObject = com.tencent.f.j.a.hmE();
      String str;
      if (localObject == null)
      {
        str = com.tencent.f.j.a.j(Looper.myLooper());
        localObject = this;
      }
      while (((e)localObject).RTQ != null) {
        if (((e)localObject).RTN.getTag().equals(str))
        {
          localObject = new RuntimeException("this pipeline will happen dead lock in future. please to check it. serialTag=".concat(String.valueOf(str)));
          AppMethodBeat.o(183308);
          throw ((Throwable)localObject);
          str = ((com.tencent.f.j.a)localObject).tag;
          localObject = this;
        }
        else
        {
          localObject = ((e)localObject).RTQ;
        }
      }
    }
    begin();
    Object localObject = super.take();
    AppMethodBeat.o(183308);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.e.f
 * JD-Core Version:    0.7.0.1
 */