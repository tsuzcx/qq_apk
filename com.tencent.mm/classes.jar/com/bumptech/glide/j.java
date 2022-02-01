package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.f.b;
import com.bumptech.glide.manager.c.a;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  implements com.bumptech.glide.manager.i
{
  private static final com.bumptech.glide.f.e aDb;
  private static final com.bumptech.glide.f.e aDp;
  private static final com.bumptech.glide.f.e aDq;
  private final Handler aCF;
  protected final c aCh;
  com.bumptech.glide.f.e aDe;
  final h aDr;
  final n aDs;
  private final m aDt;
  final o aDu;
  private final Runnable aDv;
  private final com.bumptech.glide.manager.c aDw;
  protected final Context context;
  
  static
  {
    AppMethodBeat.i(76832);
    com.bumptech.glide.f.e locale = com.bumptech.glide.f.e.v(Bitmap.class);
    locale.aIe = true;
    aDp = locale;
    locale = com.bumptech.glide.f.e.v(com.bumptech.glide.c.d.e.c.class);
    locale.aIe = true;
    aDq = locale;
    aDb = com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aHj).b(g.aCP).pW();
    AppMethodBeat.o(76832);
  }
  
  public j(c paramc, h paramh, m paramm, Context paramContext)
  {
    this(paramc, paramh, paramm, new n(), paramc.aCr, paramContext);
    AppMethodBeat.i(76821);
    AppMethodBeat.o(76821);
  }
  
  private j(c paramc, h arg2, m paramm, n paramn, d paramd, Context paramContext)
  {
    AppMethodBeat.i(76822);
    this.aDu = new o();
    this.aDv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76818);
        j.this.aDr.a(j.this);
        AppMethodBeat.o(76818);
      }
    };
    this.aCF = new Handler(Looper.getMainLooper());
    this.aCh = paramc;
    this.aDr = ???;
    this.aDt = paramm;
    this.aDs = paramn;
    this.context = paramContext;
    this.aDw = paramd.a(paramContext.getApplicationContext(), new a(paramn));
    if (com.bumptech.glide.h.j.qu()) {
      this.aCF.post(this.aDv);
    }
    for (;;)
    {
      ???.a(this.aDw);
      this.aDe = paramc.aCn.aCA.pX().pY();
      synchronized (paramc.aCs)
      {
        if (!paramc.aCs.contains(this)) {
          break;
        }
        paramc = new IllegalStateException("Cannot register already registered manager");
        AppMethodBeat.o(76822);
        throw paramc;
      }
      ???.a(this);
    }
    paramc.aCs.add(this);
    AppMethodBeat.o(76822);
  }
  
  private void d(com.bumptech.glide.f.a.e<?> parame)
  {
    AppMethodBeat.i(76828);
    if ((!e(parame)) && (!this.aCh.a(parame)) && (parame.qm() != null))
    {
      b localb = parame.qm();
      parame.h(null);
      localb.clear();
    }
    AppMethodBeat.o(76828);
  }
  
  public final void c(final com.bumptech.glide.f.a.e<?> parame)
  {
    AppMethodBeat.i(76827);
    if (parame == null)
    {
      AppMethodBeat.o(76827);
      return;
    }
    if (com.bumptech.glide.h.j.qt())
    {
      d(parame);
      AppMethodBeat.o(76827);
      return;
    }
    this.aCF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76819);
        j.this.c(parame);
        AppMethodBeat.o(76819);
      }
    });
    AppMethodBeat.o(76827);
  }
  
  final boolean e(com.bumptech.glide.f.a.e<?> parame)
  {
    AppMethodBeat.i(76829);
    b localb = parame.qm();
    if (localb == null)
    {
      AppMethodBeat.o(76829);
      return true;
    }
    if (this.aDs.a(localb, true))
    {
      this.aDu.f(parame);
      parame.h(null);
      AppMethodBeat.o(76829);
      return true;
    }
    AppMethodBeat.o(76829);
    return false;
  }
  
  final <T> k<?, T> j(Class<T> paramClass)
  {
    AppMethodBeat.i(76830);
    Object localObject3 = this.aCh.aCn;
    Object localObject2 = (k)((e)localObject3).aCu.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = ((e)localObject3).aCu.entrySet().iterator();
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject3).next();
        if (!((Class)((Map.Entry)localObject2).getKey()).isAssignableFrom(paramClass)) {
          break label123;
        }
        localObject1 = (k)((Map.Entry)localObject2).getValue();
      }
    }
    label123:
    for (;;)
    {
      break;
      paramClass = (Class<T>)localObject1;
      if (localObject1 == null) {
        paramClass = e.aCE;
      }
      AppMethodBeat.o(76830);
      return paramClass;
    }
  }
  
  public final i<Bitmap> nO()
  {
    AppMethodBeat.i(76826);
    i locali = new i(this.aCh, this, Bitmap.class, this.context).a(aDp);
    AppMethodBeat.o(76826);
    return locali;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(76825);
    this.aDu.onDestroy();
    ??? = com.bumptech.glide.h.j.c(this.aDu.aMU).iterator();
    while (((Iterator)???).hasNext()) {
      c((com.bumptech.glide.f.a.e)((Iterator)???).next());
    }
    this.aDu.aMU.clear();
    ??? = this.aDs;
    Object localObject2 = com.bumptech.glide.h.j.c(((n)???).aMP).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((n)???).a((b)((Iterator)localObject2).next(), false);
    }
    ((n)???).aMQ.clear();
    this.aDr.b(this);
    this.aDr.b(this.aDw);
    this.aCF.removeCallbacks(this.aDv);
    localObject2 = this.aCh;
    synchronized (((c)localObject2).aCs)
    {
      if (!((c)localObject2).aCs.contains(this))
      {
        localObject2 = new IllegalStateException("Cannot unregister not yet registered manager");
        AppMethodBeat.o(76825);
        throw ((Throwable)localObject2);
      }
    }
    localObject3.aCs.remove(this);
    AppMethodBeat.o(76825);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(76823);
    com.bumptech.glide.h.j.qs();
    n localn = this.aDs;
    localn.isPaused = false;
    Iterator localIterator = com.bumptech.glide.h.j.c(localn.aMP).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!localb.isComplete()) && (!localb.isCancelled()) && (!localb.isRunning())) {
        localb.begin();
      }
    }
    localn.aMQ.clear();
    this.aDu.onStart();
    AppMethodBeat.o(76823);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(76824);
    com.bumptech.glide.h.j.qs();
    n localn = this.aDs;
    localn.isPaused = true;
    Iterator localIterator = com.bumptech.glide.h.j.c(localn.aMP).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.isRunning())
      {
        localb.pause();
        localn.aMQ.add(localb);
      }
    }
    this.aDu.onStop();
    AppMethodBeat.o(76824);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76831);
    String str = super.toString() + "{tracker=" + this.aDs + ", treeNode=" + this.aDt + "}";
    AppMethodBeat.o(76831);
    return str;
  }
  
  static final class a
    implements c.a
  {
    private final n aDs;
    
    a(n paramn)
    {
      this.aDs = paramn;
    }
    
    public final void aG(boolean paramBoolean)
    {
      AppMethodBeat.i(76820);
      if (paramBoolean)
      {
        n localn = this.aDs;
        Iterator localIterator = com.bumptech.glide.h.j.c(localn.aMP).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((!localb.isComplete()) && (!localb.isCancelled()))
          {
            localb.pause();
            if (!localn.isPaused) {
              localb.begin();
            } else {
              localn.aMQ.add(localb);
            }
          }
        }
      }
      AppMethodBeat.o(76820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.j
 * JD-Core Version:    0.7.0.1
 */