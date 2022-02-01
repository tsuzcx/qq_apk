package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
  extends d
  implements i, k, m, p, t, u, v
{
  private final IJSRuntime cQa = g(paramConfig);
  final com.tencent.mm.appbrand.v8.m kDd;
  private final e kDe;
  private ArrayList<m.a> kDf = new ArrayList();
  private final Object kDg = new byte[0];
  private ArrayList<p.a> kDh = new ArrayList();
  private final boolean kDi;
  
  public a()
  {
    this(null);
  }
  
  public a(byte paramByte)
  {
    this(new IJSRuntime.Config(null, null));
  }
  
  public a(IJSRuntime.Config paramConfig)
  {
    if ((paramConfig != null) && (paramConfig.cPa)) {}
    for (boolean bool = true;; bool = false)
    {
      this.kDi = bool;
      this.kDd = a(this.cQa, e.bfF());
      this.cQa.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144154);
          synchronized (a.a(a.this))
          {
            ArrayList localArrayList = new ArrayList(a.b(a.this));
            a.b(a.this).clear();
            a.c(a.this);
            ??? = localArrayList.iterator();
            if (((Iterator)???).hasNext()) {
              ((p.a)((Iterator)???).next()).onInitialized();
            }
          }
          AppMethodBeat.o(144154);
        }
      });
      this.kDe = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m sD(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).hE(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.kDe;
      ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.kDs.put(1, this);
      return;
    }
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.kDi)) {
      return null;
    }
    return super.P(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.kDf.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(p.a parama)
  {
    synchronized (this.kDg)
    {
      if (this.kDh != null) {
        this.kDh.add(parama);
      }
      return;
    }
  }
  
  protected final com.tencent.mm.appbrand.v8.m bfA()
  {
    return this.kDd;
  }
  
  public final boolean bfB()
  {
    return true;
  }
  
  public final int bfC()
  {
    return e.bfF();
  }
  
  public final g bfD()
  {
    return this.kDe.sy(1);
  }
  
  public final g bfE()
  {
    return this.kDe.bfE();
  }
  
  protected final IJSRuntime bfz()
  {
    return this.cQa;
  }
  
  public void destroy()
  {
    this.kDd.cPC.s(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144156);
        synchronized (a.this)
        {
          ArrayList localArrayList = new ArrayList(a.e(a.this));
          a.e(a.this).clear();
          int i = 0;
          if (i < localArrayList.size())
          {
            ??? = (m.a)localArrayList.get(i);
            if (??? != null) {
              ((m.a)???).onDestroy();
            }
            i += 1;
          }
        }
        if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
        {
          synchronized (a.this)
          {
            if (a.e(a.this).size() != 0)
            {
              IllegalStateException localIllegalStateException = new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
              AppMethodBeat.o(144156);
              throw localIllegalStateException;
            }
          }
          AppMethodBeat.o(144156);
          return;
        }
        AppMethodBeat.o(144156);
      }
    });
    e locale = this.kDe;
    SparseArray localSparseArray = locale.kDs;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.kDs.size())
        {
          int j = locale.kDs.keyAt(i);
          if (j == 1) {
            break label163;
          }
          ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.kDs.get(j) == null) {
            ad.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.kDs.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.kDs.clear();
      super.destroy();
      this.cQa.quit();
      return;
      label163:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.kDd.a(e.bfF(), paramh);
  }
  
  public final g sy(int paramInt)
  {
    return this.kDe.sy(paramInt);
  }
  
  public final void sz(int paramInt)
  {
    e locale = this.kDe;
    ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.kDs)
    {
      d locald = (d)locale.kDs.get(paramInt);
      locale.kDs.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a
 * JD-Core Version:    0.7.0.1
 */