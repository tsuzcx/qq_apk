package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
  extends d
  implements i, k, m, p, t, u, v
{
  private final IJSRuntime cNv = g(paramConfig);
  private final boolean leA;
  final com.tencent.mm.appbrand.v8.m lev;
  private final e lew;
  private ArrayList<m.a> lex = new ArrayList();
  private final Object ley = new byte[0];
  private ArrayList<p.a> lez = new ArrayList();
  
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
    if ((paramConfig != null) && (paramConfig.cMv)) {}
    for (boolean bool = true;; bool = false)
    {
      this.leA = bool;
      this.lev = a(this.cNv, e.bmz());
      this.cNv.r(new Runnable()
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
      this.lew = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m tu(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).ho(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.lew;
      ac.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.leK.put(1, this);
      return;
    }
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.leA)) {
      return null;
    }
    return super.P(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.lex.add(parama);
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
    synchronized (this.ley)
    {
      if (this.lez != null) {
        this.lez.add(parama);
      }
      return;
    }
  }
  
  protected final IJSRuntime bmt()
  {
    return this.cNv;
  }
  
  protected final com.tencent.mm.appbrand.v8.m bmu()
  {
    return this.lev;
  }
  
  public final boolean bmv()
  {
    return true;
  }
  
  public final int bmw()
  {
    return e.bmz();
  }
  
  public final g bmx()
  {
    return this.lew.tp(1);
  }
  
  public final g bmy()
  {
    return this.lew.bmy();
  }
  
  public void destroy()
  {
    this.lev.cMX.t(new Runnable()
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
    e locale = this.lew;
    SparseArray localSparseArray = locale.leK;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.leK.size())
        {
          int j = locale.leK.keyAt(i);
          if (j == 1) {
            break label163;
          }
          ac.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.leK.get(j) == null) {
            ac.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.leK.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.leK.clear();
      super.destroy();
      this.cNv.quit();
      return;
      label163:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.lev.a(e.bmz(), paramh);
  }
  
  public final g tp(int paramInt)
  {
    return this.lew.tp(paramInt);
  }
  
  public final void tq(int paramInt)
  {
    e locale = this.lew;
    ac.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.leK)
    {
      d locald = (d)locale.leK.get(paramInt);
      locale.leK.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a
 * JD-Core Version:    0.7.0.1
 */