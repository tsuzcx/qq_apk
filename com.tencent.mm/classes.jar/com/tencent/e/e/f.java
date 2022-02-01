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
  
  private g fob()
  {
    AppMethodBeat.i(183310);
    if ((com.tencent.e.j.a.fom() == null) && (Looper.myLooper() == null))
    {
      localObject = new RuntimeException(String.format("fail to create DefaultScheduler. Current thread[%s-%s] without a Looper or Serial.", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()) }));
      AppMethodBeat.o(183310);
      throw ((Throwable)localObject);
    }
    Object localObject = new g()
    {
      private com.tencent.e.d.a IyY;
      
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(183303);
        this.IyY.post(paramAnonymousRunnable);
        AppMethodBeat.o(183303);
      }
      
      public final String getTag()
      {
        AppMethodBeat.i(183304);
        if ((this.IyY instanceof c))
        {
          str = this.IyY.getSerialTag();
          AppMethodBeat.o(183304);
          return str;
        }
        String str = com.tencent.e.j.a.p(this.IyY.getLooper());
        AppMethodBeat.o(183304);
        return str;
      }
      
      public final void onShutdown()
      {
        AppMethodBeat.i(183305);
        this.IyY.removeCallbacksAndMessages(null);
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
    if (!this.ndV.compareAndSet(false, true))
    {
      d.IxU.w("Pipeline", "this pipeline has begin.", new Object[0]);
      AppMethodBeat.o(183307);
      return;
    }
    while (((e)localObject).IyT != null) {
      localObject = ((e)localObject).IyT;
    }
    ((e)localObject).b(((e)localObject).IyR);
    AppMethodBeat.o(183307);
  }
  
  public final <R> f<R> c(a<E, R> parama)
  {
    AppMethodBeat.i(183306);
    Objects.requireNonNull(parama);
    f localf = new f();
    localf.IyQ = fnZ();
    localf.IyT = this;
    this.IyU = localf;
    this.IyR = parama;
    AppMethodBeat.o(183306);
    return localf;
  }
  
  final a<Throwable, ?> fnW()
  {
    for (Object localObject = this; (localObject != null) && (((e)localObject).IyS == null); localObject = ((e)localObject).IyU) {}
    if (localObject != null) {
      return ((e)localObject).IyS;
    }
    return null;
  }
  
  public final g fnZ()
  {
    AppMethodBeat.i(183309);
    if (this.IyQ == null)
    {
      localg = fob();
      AppMethodBeat.o(183309);
      return localg;
    }
    g localg = this.IyQ;
    AppMethodBeat.o(183309);
    return localg;
  }
  
  public final f<E> foa()
  {
    this.IyQ = IyL;
    return this;
  }
  
  public final E take()
  {
    AppMethodBeat.i(183308);
    if (this.IyP == null)
    {
      localObject = com.tencent.e.j.a.fom();
      String str;
      if (localObject == null)
      {
        str = com.tencent.e.j.a.p(Looper.myLooper());
        localObject = this;
      }
      while (((e)localObject).IyT != null) {
        if (((e)localObject).IyQ.getTag().equals(str))
        {
          localObject = new RuntimeException("this pipeline will happen dead lock in future. please to check it. serialTag=".concat(String.valueOf(str)));
          AppMethodBeat.o(183308);
          throw ((Throwable)localObject);
          str = ((com.tencent.e.j.a)localObject).tag;
          localObject = this;
        }
        else
        {
          localObject = ((e)localObject).IyT;
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