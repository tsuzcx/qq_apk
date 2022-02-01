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
  private static final com.bumptech.glide.f.e aBk;
  private static final com.bumptech.glide.f.e aBy;
  private static final com.bumptech.glide.f.e aBz;
  private final Handler aAO;
  protected final c aAq;
  final h aBA;
  final n aBB;
  private final m aBC;
  final o aBD;
  private final Runnable aBE;
  private final com.bumptech.glide.manager.c aBF;
  com.bumptech.glide.f.e aBn;
  protected final Context context;
  
  static
  {
    AppMethodBeat.i(76832);
    com.bumptech.glide.f.e locale = com.bumptech.glide.f.e.v(Bitmap.class);
    locale.aGn = true;
    aBy = locale;
    locale = com.bumptech.glide.f.e.v(com.bumptech.glide.c.d.e.c.class);
    locale.aGn = true;
    aBz = locale;
    aBk = com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aFs).b(g.aAY).pE();
    AppMethodBeat.o(76832);
  }
  
  public j(c paramc, h paramh, m paramm, Context paramContext)
  {
    this(paramc, paramh, paramm, new n(), paramc.aAA, paramContext);
    AppMethodBeat.i(76821);
    AppMethodBeat.o(76821);
  }
  
  private j(c paramc, h arg2, m paramm, n paramn, d paramd, Context paramContext)
  {
    AppMethodBeat.i(76822);
    this.aBD = new o();
    this.aBE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76818);
        j.this.aBA.a(j.this);
        AppMethodBeat.o(76818);
      }
    };
    this.aAO = new Handler(Looper.getMainLooper());
    this.aAq = paramc;
    this.aBA = ???;
    this.aBC = paramm;
    this.aBB = paramn;
    this.context = paramContext;
    this.aBF = paramd.a(paramContext.getApplicationContext(), new a(paramn));
    if (com.bumptech.glide.h.j.qc()) {
      this.aAO.post(this.aBE);
    }
    for (;;)
    {
      ???.a(this.aBF);
      this.aBn = paramc.aAw.aAJ.pF().pG();
      synchronized (paramc.aAB)
      {
        if (!paramc.aAB.contains(this)) {
          break;
        }
        paramc = new IllegalStateException("Cannot register already registered manager");
        AppMethodBeat.o(76822);
        throw paramc;
      }
      ???.a(this);
    }
    paramc.aAB.add(this);
    AppMethodBeat.o(76822);
  }
  
  private void d(com.bumptech.glide.f.a.e<?> parame)
  {
    AppMethodBeat.i(76828);
    if ((!e(parame)) && (!this.aAq.a(parame)) && (parame.pU() != null))
    {
      b localb = parame.pU();
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
    if (com.bumptech.glide.h.j.qb())
    {
      d(parame);
      AppMethodBeat.o(76827);
      return;
    }
    this.aAO.post(new Runnable()
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
    b localb = parame.pU();
    if (localb == null)
    {
      AppMethodBeat.o(76829);
      return true;
    }
    if (this.aBB.a(localb, true))
    {
      this.aBD.f(parame);
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
    Object localObject3 = this.aAq.aAw;
    Object localObject2 = (k)((e)localObject3).aAD.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = ((e)localObject3).aAD.entrySet().iterator();
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
        paramClass = e.aAN;
      }
      AppMethodBeat.o(76830);
      return paramClass;
    }
  }
  
  public final i<Bitmap> nw()
  {
    AppMethodBeat.i(76826);
    i locali = new i(this.aAq, this, Bitmap.class, this.context).a(aBy);
    AppMethodBeat.o(76826);
    return locali;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(76825);
    this.aBD.onDestroy();
    ??? = com.bumptech.glide.h.j.c(this.aBD.aLd).iterator();
    while (((Iterator)???).hasNext()) {
      c((com.bumptech.glide.f.a.e)((Iterator)???).next());
    }
    this.aBD.aLd.clear();
    ??? = this.aBB;
    Object localObject2 = com.bumptech.glide.h.j.c(((n)???).aKY).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((n)???).a((b)((Iterator)localObject2).next(), false);
    }
    ((n)???).aKZ.clear();
    this.aBA.b(this);
    this.aBA.b(this.aBF);
    this.aAO.removeCallbacks(this.aBE);
    localObject2 = this.aAq;
    synchronized (((c)localObject2).aAB)
    {
      if (!((c)localObject2).aAB.contains(this))
      {
        localObject2 = new IllegalStateException("Cannot unregister not yet registered manager");
        AppMethodBeat.o(76825);
        throw ((Throwable)localObject2);
      }
    }
    localObject3.aAB.remove(this);
    AppMethodBeat.o(76825);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(76823);
    com.bumptech.glide.h.j.qa();
    n localn = this.aBB;
    localn.isPaused = false;
    Iterator localIterator = com.bumptech.glide.h.j.c(localn.aKY).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!localb.isComplete()) && (!localb.isCancelled()) && (!localb.isRunning())) {
        localb.begin();
      }
    }
    localn.aKZ.clear();
    this.aBD.onStart();
    AppMethodBeat.o(76823);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(76824);
    com.bumptech.glide.h.j.qa();
    n localn = this.aBB;
    localn.isPaused = true;
    Iterator localIterator = com.bumptech.glide.h.j.c(localn.aKY).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.isRunning())
      {
        localb.pause();
        localn.aKZ.add(localb);
      }
    }
    this.aBD.onStop();
    AppMethodBeat.o(76824);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76831);
    String str = super.toString() + "{tracker=" + this.aBB + ", treeNode=" + this.aBC + "}";
    AppMethodBeat.o(76831);
    return str;
  }
  
  static final class a
    implements c.a
  {
    private final n aBB;
    
    a(n paramn)
    {
      this.aBB = paramn;
    }
    
    public final void aG(boolean paramBoolean)
    {
      AppMethodBeat.i(76820);
      if (paramBoolean)
      {
        n localn = this.aBB;
        Iterator localIterator = com.bumptech.glide.h.j.c(localn.aKY).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((!localb.isComplete()) && (!localb.isCancelled()))
          {
            localb.pause();
            if (!localn.isPaused) {
              localb.begin();
            } else {
              localn.aKZ.add(localb);
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