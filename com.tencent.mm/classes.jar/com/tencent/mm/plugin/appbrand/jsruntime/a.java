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
  private final IJSRuntime cYL = g(paramConfig);
  final com.tencent.mm.appbrand.v8.m lBu;
  private final e lBv;
  private ArrayList<m.a> lBw = new ArrayList();
  private final Object lBx = new byte[0];
  private ArrayList<p.a> lBy = new ArrayList();
  private final boolean lBz;
  
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
    if ((paramConfig != null) && (paramConfig.cXK)) {}
    for (boolean bool = true;; bool = false)
    {
      this.lBz = bool;
      this.lBu = a(this.cYL, e.bqk());
      this.cYL.r(new Runnable()
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
      this.lBv = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m tX(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).hv(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.lBv;
      ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.lBJ.put(1, this);
      return;
    }
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.lBz)) {
      return null;
    }
    return super.P(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.lBw.add(parama);
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
    synchronized (this.lBx)
    {
      if (this.lBy != null) {
        this.lBy.add(parama);
      }
      return;
    }
  }
  
  public final IJSRuntime bqe()
  {
    return this.cYL;
  }
  
  public final com.tencent.mm.appbrand.v8.m bqf()
  {
    return this.lBu;
  }
  
  public final boolean bqg()
  {
    return true;
  }
  
  public final int bqh()
  {
    return e.bqk();
  }
  
  public final g bqi()
  {
    return this.lBv.tS(1);
  }
  
  public final g bqj()
  {
    return this.lBv.bqj();
  }
  
  public void destroy()
  {
    this.lBu.cYn.t(new Runnable()
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
        if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
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
    e locale = this.lBv;
    SparseArray localSparseArray = locale.lBJ;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.lBJ.size())
        {
          int j = locale.lBJ.keyAt(i);
          if (j == 1) {
            break label163;
          }
          ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.lBJ.get(j) == null) {
            ad.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.lBJ.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.lBJ.clear();
      super.destroy();
      this.cYL.quit();
      return;
      label163:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.lBu.a(e.bqk(), paramh);
  }
  
  public final g tS(int paramInt)
  {
    return this.lBv.tS(paramInt);
  }
  
  public final void tT(int paramInt)
  {
    e locale = this.lBv;
    ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.lBJ)
    {
      d locald = (d)locale.lBJ.get(paramInt);
      locale.lBJ.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a
 * JD-Core Version:    0.7.0.1
 */