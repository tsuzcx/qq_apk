package com.tencent.mm.plugin.appbrand.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
  extends d
  implements m, p, t
{
  private final IJSRuntime fiU = g(paramConfig);
  private ArrayList<p.a> pOA = new ArrayList();
  private final boolean pOB;
  public final com.tencent.mm.appbrand.v8.m pOw;
  private final e pOx;
  private ArrayList<m.a> pOy = new ArrayList();
  private final Object pOz = new byte[0];
  
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
    if ((paramConfig != null) && (paramConfig.fhS)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pOB = bool;
      this.pOw = a(this.fiU, e.bYX());
      this.fiU.q(new Runnable()
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
        }
      });
      this.pOx = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m BC(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).kf(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.pOx;
      Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.pOK.put(1, this);
      return;
    }
  }
  
  public final g Bx(int paramInt)
  {
    return this.pOx.Bx(paramInt);
  }
  
  public final void By(int paramInt)
  {
    e locale = this.pOx;
    Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.pOK)
    {
      d locald = (d)locale.pOK.get(paramInt);
      locale.pOK.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
  
  public final <T extends j> T Q(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.pOB)) {
      return null;
    }
    return super.Q(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.pOy.add(parama);
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
    synchronized (this.pOz)
    {
      if (this.pOA != null) {
        this.pOA.add(parama);
      }
      return;
    }
  }
  
  public final IJSRuntime bYQ()
  {
    return this.fiU;
  }
  
  public final com.tencent.mm.appbrand.v8.m bYR()
  {
    return this.pOw;
  }
  
  public final boolean bYS()
  {
    return true;
  }
  
  public final int bYT()
  {
    return e.bYX();
  }
  
  public final g bYU()
  {
    return this.pOx.Bx(1);
  }
  
  public final g bYV()
  {
    return this.pOx.bYV();
  }
  
  public void destroy()
  {
    this.pOw.fiy.s(new Runnable()
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
        AppMethodBeat.o(144156);
      }
    });
    e locale = this.pOx;
    SparseArray localSparseArray = locale.pOK;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.pOK.size())
        {
          int j = locale.pOK.keyAt(i);
          if (j == 1) {
            break label164;
          }
          Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.pOK.get(j) == null) {
            Log.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.pOK.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.pOK.clear();
      super.destroy();
      this.fiU.quit();
      return;
      label164:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.pOw.a(e.bYX(), paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.a
 * JD-Core Version:    0.7.0.1
 */