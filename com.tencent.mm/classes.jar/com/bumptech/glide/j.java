package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.f;
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
import java.util.concurrent.CopyOnWriteArrayList;

public final class j
  implements com.bumptech.glide.manager.i
{
  private static final f aDb;
  private static final f aDo;
  private static final f aDp;
  protected final c aCg;
  final h aDq;
  private final n aDr;
  private final m aDs;
  private final o aDt;
  private final Runnable aDu;
  private final Handler aDv;
  private final com.bumptech.glide.manager.c aDw;
  final CopyOnWriteArrayList<com.bumptech.glide.e.e<Object>> aDx;
  private f aDy;
  protected final Context context;
  
  static
  {
    AppMethodBeat.i(76832);
    f localf = f.x(Bitmap.class);
    localf.aHY = true;
    aDo = (f)localf;
    localf = f.x(com.bumptech.glide.load.d.e.c.class);
    localf.aHY = true;
    aDp = (f)localf;
    aDb = (f)((f)f.b(com.bumptech.glide.load.b.j.aHb).b(g.aCP)).pX();
    AppMethodBeat.o(76832);
  }
  
  public j(c paramc, h paramh, m paramm, Context paramContext)
  {
    this(paramc, paramh, paramm, new n(), paramc.aCq, paramContext);
    AppMethodBeat.i(76821);
    AppMethodBeat.o(76821);
  }
  
  private j(c paramc, h arg2, m paramm, n paramn, d paramd, Context paramContext)
  {
    AppMethodBeat.i(76822);
    this.aDt = new o();
    this.aDu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76818);
        j.this.aDq.a(j.this);
        AppMethodBeat.o(76818);
      }
    };
    this.aDv = new Handler(Looper.getMainLooper());
    this.aCg = paramc;
    this.aDq = ???;
    this.aDs = paramm;
    this.aDr = paramn;
    this.context = paramContext;
    this.aDw = paramd.a(paramContext.getApplicationContext(), new a(paramn));
    if (com.bumptech.glide.g.k.qx()) {
      this.aDv.post(this.aDu);
    }
    for (;;)
    {
      ???.a(this.aDw);
      this.aDx = new CopyOnWriteArrayList(paramc.aCm.aCD);
      a(paramc.aCm.aCz);
      synchronized (paramc.aCr)
      {
        if (!paramc.aCr.contains(this)) {
          break;
        }
        paramc = new IllegalStateException("Cannot register already registered manager");
        AppMethodBeat.o(76822);
        throw paramc;
      }
      ???.a(this);
    }
    paramc.aCr.add(this);
    AppMethodBeat.o(76822);
  }
  
  private void a(f paramf)
  {
    try
    {
      AppMethodBeat.i(204450);
      paramf = (f)paramf.nQ();
      if ((paramf.aHY) && (!paramf.aNg))
      {
        paramf = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        AppMethodBeat.o(204450);
        throw paramf;
      }
    }
    finally {}
    paramf.aNg = true;
    paramf.aHY = true;
    this.aDy = ((f)paramf);
    AppMethodBeat.o(204450);
  }
  
  private void nR()
  {
    try
    {
      AppMethodBeat.i(204451);
      n localn = this.aDr;
      localn.isPaused = true;
      Iterator localIterator = com.bumptech.glide.g.k.c(localn.aMG).iterator();
      while (localIterator.hasNext())
      {
        com.bumptech.glide.e.c localc = (com.bumptech.glide.e.c)localIterator.next();
        if (localc.isRunning())
        {
          localc.clear();
          localn.aMH.add(localc);
        }
      }
      AppMethodBeat.o(204451);
    }
    finally {}
  }
  
  private void nS()
  {
    try
    {
      AppMethodBeat.i(204452);
      n localn = this.aDr;
      localn.isPaused = false;
      Iterator localIterator = com.bumptech.glide.g.k.c(localn.aMG).iterator();
      while (localIterator.hasNext())
      {
        com.bumptech.glide.e.c localc = (com.bumptech.glide.e.c)localIterator.next();
        if ((!localc.isComplete()) && (!localc.isRunning())) {
          localc.begin();
        }
      }
      localObject.aMH.clear();
    }
    finally {}
    AppMethodBeat.o(204452);
  }
  
  /* Error */
  final void a(com.bumptech.glide.e.a.e<?> parame, com.bumptech.glide.e.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 279
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 119	com/bumptech/glide/j:aDt	Lcom/bumptech/glide/manager/o;
    //   12: getfield 282	com/bumptech/glide/manager/o:aML	Ljava/util/Set;
    //   15: aload_1
    //   16: invokeinterface 285 2 0
    //   21: pop
    //   22: aload_0
    //   23: getfield 145	com/bumptech/glide/j:aDr	Lcom/bumptech/glide/manager/n;
    //   26: astore_1
    //   27: aload_1
    //   28: getfield 240	com/bumptech/glide/manager/n:aMG	Ljava/util/Set;
    //   31: aload_2
    //   32: invokeinterface 285 2 0
    //   37: pop
    //   38: aload_1
    //   39: getfield 236	com/bumptech/glide/manager/n:isPaused	Z
    //   42: ifne +18 -> 60
    //   45: aload_2
    //   46: invokeinterface 276 1 0
    //   51: ldc_w 279
    //   54: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_2
    //   61: invokeinterface 265 1 0
    //   66: ldc_w 287
    //   69: iconst_2
    //   70: invokestatic 293	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   73: pop
    //   74: aload_1
    //   75: getfield 268	com/bumptech/glide/manager/n:aMH	Ljava/util/List;
    //   78: aload_2
    //   79: invokeinterface 220 2 0
    //   84: pop
    //   85: ldc_w 279
    //   88: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: goto -34 -> 57
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	j
    //   0	99	1	parame	com.bumptech.glide.e.a.e<?>
    //   0	99	2	paramc	com.bumptech.glide.e.c
    // Exception table:
    //   from	to	target	type
    //   2	57	94	finally
    //   60	91	94	finally
  }
  
  /* Error */
  public final void c(com.bumptech.glide.e.a.e<?> parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 297
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: ldc_w 297
    //   15: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 301	com/bumptech/glide/j:d	(Lcom/bumptech/glide/e/a/e;)Z
    //   26: ifne +43 -> 69
    //   29: aload_0
    //   30: getfield 139	com/bumptech/glide/j:aCg	Lcom/bumptech/glide/c;
    //   33: aload_1
    //   34: invokevirtual 303	com/bumptech/glide/c:a	(Lcom/bumptech/glide/e/a/e;)Z
    //   37: ifne +32 -> 69
    //   40: aload_1
    //   41: invokeinterface 309 1 0
    //   46: ifnull +23 -> 69
    //   49: aload_1
    //   50: invokeinterface 309 1 0
    //   55: astore_2
    //   56: aload_1
    //   57: aconst_null
    //   58: invokeinterface 313 2 0
    //   63: aload_2
    //   64: invokeinterface 265 1 0
    //   69: ldc_w 297
    //   72: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -57 -> 18
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	j
    //   0	83	1	parame	com.bumptech.glide.e.a.e<?>
    //   55	9	2	localc	com.bumptech.glide.e.c
    // Exception table:
    //   from	to	target	type
    //   2	8	78	finally
    //   12	18	78	finally
    //   21	69	78	finally
    //   69	75	78	finally
  }
  
  final boolean d(com.bumptech.glide.e.a.e<?> parame)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(76829);
        com.bumptech.glide.e.c localc = parame.qn();
        if (localc == null)
        {
          AppMethodBeat.o(76829);
          return bool;
        }
        if (this.aDr.a(localc, true))
        {
          this.aDt.aML.remove(parame);
          parame.h(null);
          AppMethodBeat.o(76829);
          continue;
        }
        bool = false;
      }
      finally {}
      AppMethodBeat.o(76829);
    }
  }
  
  final <T> k<?, T> k(Class<T> paramClass)
  {
    AppMethodBeat.i(76830);
    Object localObject3 = this.aCg.aCm;
    Object localObject2 = (k)((e)localObject3).aCt.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = ((e)localObject3).aCt.entrySet().iterator();
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
        paramClass = e.aCF;
      }
      AppMethodBeat.o(76830);
      return paramClass;
    }
  }
  
  public final i<Bitmap> nT()
  {
    AppMethodBeat.i(76826);
    i locali = new i(this.aCg, this, Bitmap.class, this.context).a(aDo);
    AppMethodBeat.o(76826);
    return locali;
  }
  
  final f nU()
  {
    try
    {
      f localf = this.aDy;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onDestroy()
  {
    try
    {
      AppMethodBeat.i(76825);
      this.aDt.onDestroy();
      Iterator localIterator = com.bumptech.glide.g.k.c(this.aDt.aML).iterator();
      while (localIterator.hasNext()) {
        c((com.bumptech.glide.e.a.e)localIterator.next());
      }
      this.aDt.aML.clear();
    }
    finally {}
    ??? = this.aDr;
    Object localObject3 = com.bumptech.glide.g.k.c(((n)???).aMG).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((n)???).a((com.bumptech.glide.e.c)((Iterator)localObject3).next(), false);
    }
    ((n)???).aMH.clear();
    this.aDq.b(this);
    this.aDq.b(this.aDw);
    this.aDv.removeCallbacks(this.aDu);
    localObject3 = this.aCg;
    synchronized (((c)localObject3).aCr)
    {
      if (!((c)localObject3).aCr.contains(this))
      {
        localObject3 = new IllegalStateException("Cannot unregister not yet registered manager");
        AppMethodBeat.o(76825);
        throw ((Throwable)localObject3);
      }
    }
    localObject4.aCr.remove(this);
    AppMethodBeat.o(76825);
  }
  
  public final void onStart()
  {
    try
    {
      AppMethodBeat.i(76823);
      nS();
      this.aDt.onStart();
      AppMethodBeat.o(76823);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onStop()
  {
    try
    {
      AppMethodBeat.i(76824);
      nR();
      this.aDt.onStop();
      AppMethodBeat.o(76824);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(76831);
      String str = super.toString() + "{tracker=" + this.aDr + ", treeNode=" + this.aDs + "}";
      AppMethodBeat.o(76831);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class a
    implements c.a
  {
    private final n aDr;
    
    a(n paramn)
    {
      this.aDr = paramn;
    }
    
    public final void aE(boolean paramBoolean)
    {
      AppMethodBeat.i(76820);
      if (paramBoolean)
      {
        for (;;)
        {
          com.bumptech.glide.e.c localc;
          synchronized (j.this)
          {
            n localn = this.aDr;
            Iterator localIterator = com.bumptech.glide.g.k.c(localn.aMG).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localc = (com.bumptech.glide.e.c)localIterator.next();
            if ((localc.isComplete()) || (localc.qc())) {
              continue;
            }
            localc.clear();
            if (!localn.isPaused) {
              localc.begin();
            }
          }
          localObject.aMH.add(localc);
        }
        AppMethodBeat.o(76820);
        return;
      }
      AppMethodBeat.o(76820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.j
 * JD-Core Version:    0.7.0.1
 */