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
  
  private g ipU()
  {
    AppMethodBeat.i(183310);
    if ((com.tencent.e.j.a.iqf() == null) && (Looper.myLooper() == null))
    {
      localObject = new RuntimeException(String.format("fail to create DefaultScheduler. Current thread[%s-%s] without a Looper or Serial.", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()) }));
      AppMethodBeat.o(183310);
      throw ((Throwable)localObject);
    }
    Object localObject = new g()
    {
      private com.tencent.e.d.a Zwx;
      
      public final void Xq()
      {
        AppMethodBeat.i(183305);
        this.Zwx.removeCallbacksAndMessages(null);
        AppMethodBeat.o(183305);
      }
      
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(183303);
        this.Zwx.post(paramAnonymousRunnable);
        AppMethodBeat.o(183303);
      }
      
      public final String getTag()
      {
        AppMethodBeat.i(183304);
        if ((this.Zwx instanceof c))
        {
          str = this.Zwx.getSerialTag();
          AppMethodBeat.o(183304);
          return str;
        }
        String str = com.tencent.e.j.a.l(this.Zwx.getLooper());
        AppMethodBeat.o(183304);
        return str;
      }
    };
    AppMethodBeat.o(183310);
    return localObject;
  }
  
  public final void begin()
  {
    AppMethodBeat.i(183307);
    Object localObject = this;
    if (!this.sMY.compareAndSet(false, true))
    {
      d.Zvw.w("Pipeline", "this pipeline has begin.", new Object[0]);
      AppMethodBeat.o(183307);
      return;
    }
    while (((e)localObject).Zws != null) {
      localObject = ((e)localObject).Zws;
    }
    ((e)localObject).b(((e)localObject).Zwq);
    AppMethodBeat.o(183307);
  }
  
  public final <R> f<R> c(a<E, R> parama)
  {
    AppMethodBeat.i(183306);
    Objects.requireNonNull(parama);
    f localf = new f();
    localf.Zwp = ipS();
    localf.Zws = this;
    this.Zwt = localf;
    this.Zwq = parama;
    AppMethodBeat.o(183306);
    return localf;
  }
  
  final a<Throwable, ?> ipO()
  {
    for (Object localObject = this; (localObject != null) && (((e)localObject).Zwr == null); localObject = ((e)localObject).Zwt) {}
    if (localObject != null) {
      return ((e)localObject).Zwr;
    }
    return null;
  }
  
  public final E ipQ()
  {
    AppMethodBeat.i(183308);
    if (this.Zwo == null)
    {
      localObject = com.tencent.e.j.a.iqf();
      String str;
      if (localObject == null)
      {
        str = com.tencent.e.j.a.l(Looper.myLooper());
        localObject = this;
      }
      while (((e)localObject).Zws != null) {
        if (((e)localObject).Zwp.getTag().equals(str))
        {
          localObject = new RuntimeException("this pipeline will happen dead lock in future. please to check it. serialTag=".concat(String.valueOf(str)));
          AppMethodBeat.o(183308);
          throw ((Throwable)localObject);
          str = ((com.tencent.e.j.a)localObject).tag;
          localObject = this;
        }
        else
        {
          localObject = ((e)localObject).Zws;
        }
      }
    }
    begin();
    Object localObject = super.ipQ();
    AppMethodBeat.o(183308);
    return localObject;
  }
  
  public final g ipS()
  {
    AppMethodBeat.i(183309);
    if (this.Zwp == null)
    {
      localg = ipU();
      AppMethodBeat.o(183309);
      return localg;
    }
    g localg = this.Zwp;
    AppMethodBeat.o(183309);
    return localg;
  }
  
  public final f<E> ipT()
  {
    this.Zwp = Zwk;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.e.f
 * JD-Core Version:    0.7.0.1
 */