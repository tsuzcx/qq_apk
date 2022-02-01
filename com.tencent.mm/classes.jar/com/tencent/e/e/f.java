package com.tencent.e.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.e.d;
import com.tencent.e.d.a;
import com.tencent.e.d.b;
import com.tencent.e.j.c;
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
  
  private g fEr()
  {
    AppMethodBeat.i(183310);
    if ((com.tencent.e.j.a.fEC() == null) && (Looper.myLooper() == null))
    {
      localObject = new RuntimeException(String.format("fail to create DefaultScheduler. Current thread[%s-%s] without a Looper or Serial.", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()) }));
      AppMethodBeat.o(183310);
      throw ((Throwable)localObject);
    }
    Object localObject = new g()
    {
      private com.tencent.e.d.a KaH;
      
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(183303);
        this.KaH.post(paramAnonymousRunnable);
        AppMethodBeat.o(183303);
      }
      
      public final String getTag()
      {
        AppMethodBeat.i(183304);
        if ((this.KaH instanceof c))
        {
          str = this.KaH.getSerialTag();
          AppMethodBeat.o(183304);
          return str;
        }
        String str = com.tencent.e.j.a.p(this.KaH.getLooper());
        AppMethodBeat.o(183304);
        return str;
      }
      
      public final void onShutdown()
      {
        AppMethodBeat.i(183305);
        this.KaH.removeCallbacksAndMessages(null);
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
    if (!this.nGH.compareAndSet(false, true))
    {
      d.JZD.w("Pipeline", "this pipeline has begin.", new Object[0]);
      AppMethodBeat.o(183307);
      return;
    }
    while (((e)localObject).KaC != null) {
      localObject = ((e)localObject).KaC;
    }
    ((e)localObject).b(((e)localObject).KaA);
    AppMethodBeat.o(183307);
  }
  
  public final <R> f<R> c(a<E, R> parama)
  {
    AppMethodBeat.i(183306);
    Objects.requireNonNull(parama);
    f localf = new f();
    localf.Kaz = fEp();
    localf.KaC = this;
    this.KaD = localf;
    this.KaA = parama;
    AppMethodBeat.o(183306);
    return localf;
  }
  
  final a<Throwable, ?> fEm()
  {
    for (Object localObject = this; (localObject != null) && (((e)localObject).KaB == null); localObject = ((e)localObject).KaD) {}
    if (localObject != null) {
      return ((e)localObject).KaB;
    }
    return null;
  }
  
  public final g fEp()
  {
    AppMethodBeat.i(183309);
    if (this.Kaz == null)
    {
      localg = fEr();
      AppMethodBeat.o(183309);
      return localg;
    }
    g localg = this.Kaz;
    AppMethodBeat.o(183309);
    return localg;
  }
  
  public final f<E> fEq()
  {
    this.Kaz = Kau;
    return this;
  }
  
  public final E take()
  {
    AppMethodBeat.i(183308);
    if (this.Kay == null)
    {
      localObject = com.tencent.e.j.a.fEC();
      String str;
      if (localObject == null)
      {
        str = com.tencent.e.j.a.p(Looper.myLooper());
        localObject = this;
      }
      while (((e)localObject).KaC != null) {
        if (((e)localObject).Kaz.getTag().equals(str))
        {
          localObject = new RuntimeException("this pipeline will happen dead lock in future. please to check it. serialTag=".concat(String.valueOf(str)));
          AppMethodBeat.o(183308);
          throw ((Throwable)localObject);
          str = ((com.tencent.e.j.a)localObject).tag;
          localObject = this;
        }
        else
        {
          localObject = ((e)localObject).KaC;
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
 * Qualified Name:     com.tencent.e.e.f
 * JD-Core Version:    0.7.0.1
 */