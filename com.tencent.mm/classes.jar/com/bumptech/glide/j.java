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
  private static final com.bumptech.glide.f.e aAE;
  private static final com.bumptech.glide.f.e aAF;
  private static final com.bumptech.glide.f.e aAq;
  final h aAG;
  final n aAH;
  private final m aAI;
  final o aAJ;
  private final Runnable aAK;
  private final com.bumptech.glide.manager.c aAL;
  com.bumptech.glide.f.e aAt;
  private final Handler azU;
  protected final c azw;
  protected final Context context;
  
  static
  {
    AppMethodBeat.i(76832);
    com.bumptech.glide.f.e locale = com.bumptech.glide.f.e.v(Bitmap.class);
    locale.aFx = true;
    aAE = locale;
    locale = com.bumptech.glide.f.e.v(com.bumptech.glide.c.d.e.c.class);
    locale.aFx = true;
    aAF = locale;
    aAq = com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aEC).b(g.aAe).pu();
    AppMethodBeat.o(76832);
  }
  
  public j(c paramc, h paramh, m paramm, Context paramContext)
  {
    this(paramc, paramh, paramm, new n(), paramc.azG, paramContext);
    AppMethodBeat.i(76821);
    AppMethodBeat.o(76821);
  }
  
  private j(c paramc, h arg2, m paramm, n paramn, d paramd, Context paramContext)
  {
    AppMethodBeat.i(76822);
    this.aAJ = new o();
    this.aAK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76818);
        j.this.aAG.a(j.this);
        AppMethodBeat.o(76818);
      }
    };
    this.azU = new Handler(Looper.getMainLooper());
    this.azw = paramc;
    this.aAG = ???;
    this.aAI = paramm;
    this.aAH = paramn;
    this.context = paramContext;
    this.aAL = paramd.a(paramContext.getApplicationContext(), new a(paramn));
    if (com.bumptech.glide.h.j.pS()) {
      this.azU.post(this.aAK);
    }
    for (;;)
    {
      ???.a(this.aAL);
      this.aAt = paramc.azC.azP.pv().pw();
      synchronized (paramc.azH)
      {
        if (!paramc.azH.contains(this)) {
          break;
        }
        paramc = new IllegalStateException("Cannot register already registered manager");
        AppMethodBeat.o(76822);
        throw paramc;
      }
      ???.a(this);
    }
    paramc.azH.add(this);
    AppMethodBeat.o(76822);
  }
  
  private void d(com.bumptech.glide.f.a.e<?> parame)
  {
    AppMethodBeat.i(76828);
    if ((!e(parame)) && (!this.azw.a(parame)) && (parame.pK() != null))
    {
      b localb = parame.pK();
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
    if (com.bumptech.glide.h.j.pR())
    {
      d(parame);
      AppMethodBeat.o(76827);
      return;
    }
    this.azU.post(new Runnable()
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
    b localb = parame.pK();
    if (localb == null)
    {
      AppMethodBeat.o(76829);
      return true;
    }
    if (this.aAH.a(localb, true))
    {
      this.aAJ.f(parame);
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
    Object localObject3 = this.azw.azC;
    Object localObject2 = (k)((e)localObject3).azJ.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = ((e)localObject3).azJ.entrySet().iterator();
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
        paramClass = e.azT;
      }
      AppMethodBeat.o(76830);
      return paramClass;
    }
  }
  
  public final i<Bitmap> nm()
  {
    AppMethodBeat.i(76826);
    i locali = new i(this.azw, this, Bitmap.class, this.context).a(aAE);
    AppMethodBeat.o(76826);
    return locali;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(76825);
    this.aAJ.onDestroy();
    ??? = com.bumptech.glide.h.j.c(this.aAJ.aKn).iterator();
    while (((Iterator)???).hasNext()) {
      c((com.bumptech.glide.f.a.e)((Iterator)???).next());
    }
    this.aAJ.aKn.clear();
    ??? = this.aAH;
    Object localObject2 = com.bumptech.glide.h.j.c(((n)???).aKi).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((n)???).a((b)((Iterator)localObject2).next(), false);
    }
    ((n)???).aKj.clear();
    this.aAG.b(this);
    this.aAG.b(this.aAL);
    this.azU.removeCallbacks(this.aAK);
    localObject2 = this.azw;
    synchronized (((c)localObject2).azH)
    {
      if (!((c)localObject2).azH.contains(this))
      {
        localObject2 = new IllegalStateException("Cannot unregister not yet registered manager");
        AppMethodBeat.o(76825);
        throw ((Throwable)localObject2);
      }
    }
    localObject3.azH.remove(this);
    AppMethodBeat.o(76825);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(76823);
    com.bumptech.glide.h.j.pQ();
    n localn = this.aAH;
    localn.isPaused = false;
    Iterator localIterator = com.bumptech.glide.h.j.c(localn.aKi).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!localb.isComplete()) && (!localb.isCancelled()) && (!localb.isRunning())) {
        localb.begin();
      }
    }
    localn.aKj.clear();
    this.aAJ.onStart();
    AppMethodBeat.o(76823);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(76824);
    com.bumptech.glide.h.j.pQ();
    n localn = this.aAH;
    localn.isPaused = true;
    Iterator localIterator = com.bumptech.glide.h.j.c(localn.aKi).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.isRunning())
      {
        localb.pause();
        localn.aKj.add(localb);
      }
    }
    this.aAJ.onStop();
    AppMethodBeat.o(76824);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76831);
    String str = super.toString() + "{tracker=" + this.aAH + ", treeNode=" + this.aAI + "}";
    AppMethodBeat.o(76831);
    return str;
  }
  
  static final class a
    implements c.a
  {
    private final n aAH;
    
    a(n paramn)
    {
      this.aAH = paramn;
    }
    
    public final void aG(boolean paramBoolean)
    {
      AppMethodBeat.i(76820);
      if (paramBoolean)
      {
        n localn = this.aAH;
        Iterator localIterator = com.bumptech.glide.h.j.c(localn.aKi).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((!localb.isComplete()) && (!localb.isCancelled()))
          {
            localb.pause();
            if (!localn.isPaused) {
              localb.begin();
            } else {
              localn.aKj.add(localb);
            }
          }
        }
      }
      AppMethodBeat.o(76820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.j
 * JD-Core Version:    0.7.0.1
 */