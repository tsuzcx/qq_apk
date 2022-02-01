package com.tencent.mm.plugin.appbrand.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
  extends d
  implements i, k, m, p, t, u, v
{
  public final IJSRuntime dqn = g(paramConfig);
  public final com.tencent.mm.appbrand.v8.m mNC;
  private final e mND;
  private ArrayList<m.a> mNE = new ArrayList();
  private final Object mNF = new byte[0];
  private ArrayList<p.a> mNG = new ArrayList();
  private final boolean mNH;
  
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
    if ((paramConfig != null) && (paramConfig.dpm)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mNH = bool;
      this.mNC = a(this.dqn, e.bMG());
      this.dqn.r(new Runnable()
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
      this.mND = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m yc(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).iP(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.mND;
      Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.mNS.put(1, this);
      return;
    }
  }
  
  public final <T extends j> T R(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.mNH)) {
      return null;
    }
    return super.R(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.mNE.add(parama);
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
    synchronized (this.mNF)
    {
      if (this.mNG != null) {
        this.mNG.add(parama);
      }
      return;
    }
  }
  
  public final com.tencent.mm.appbrand.v8.m bMA()
  {
    return this.mNC;
  }
  
  public final boolean bMB()
  {
    return true;
  }
  
  public final int bMC()
  {
    return e.bMG();
  }
  
  public final g bMD()
  {
    return this.mND.xX(1);
  }
  
  public final g bME()
  {
    return this.mND.bME();
  }
  
  public final IJSRuntime bMz()
  {
    return this.dqn;
  }
  
  public void destroy()
  {
    this.mNC.dpQ.t(new Runnable()
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
        if (BuildInfo.IS_FLAVOR_RED)
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
    e locale = this.mND;
    SparseArray localSparseArray = locale.mNS;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.mNS.size())
        {
          int j = locale.mNS.keyAt(i);
          if (j == 1) {
            break label163;
          }
          Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.mNS.get(j) == null) {
            Log.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.mNS.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.mNS.clear();
      super.destroy();
      this.dqn.quit();
      return;
      label163:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.mNC.a(e.bMG(), paramh);
  }
  
  public final g xX(int paramInt)
  {
    return this.mND.xX(paramInt);
  }
  
  public final void xY(int paramInt)
  {
    e locale = this.mND;
    Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.mNS)
    {
      d locald = (d)locale.mNS.get(paramInt);
      locale.mNS.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.a
 * JD-Core Version:    0.7.0.1
 */