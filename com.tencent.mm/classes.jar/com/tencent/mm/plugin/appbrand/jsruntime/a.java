package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
  extends d
  implements i, k, m, p, t, u, v
{
  private final IJSRuntime cZJ = g(paramConfig);
  final com.tencent.mm.appbrand.v8.m lFS;
  private final e lFT;
  private ArrayList<m.a> lFU = new ArrayList();
  private final Object lFV = new byte[0];
  private ArrayList<p.a> lFW = new ArrayList();
  private final boolean lFX;
  
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
    if ((paramConfig != null) && (paramConfig.cYI)) {}
    for (boolean bool = true;; bool = false)
    {
      this.lFX = bool;
      this.lFS = a(this.cZJ, e.bqU());
      this.cZJ.r(new Runnable()
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
      this.lFT = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m ud(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).hv(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.lFT;
      ae.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.lGi.put(1, this);
      return;
    }
  }
  
  public final IJSRuntime Nx()
  {
    return this.cZJ;
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.lFX)) {
      return null;
    }
    return super.P(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.lFU.add(parama);
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
    synchronized (this.lFV)
    {
      if (this.lFW != null) {
        this.lFW.add(parama);
      }
      return;
    }
  }
  
  public final com.tencent.mm.appbrand.v8.m bqO()
  {
    return this.lFS;
  }
  
  public final boolean bqP()
  {
    return true;
  }
  
  public final int bqQ()
  {
    return e.bqU();
  }
  
  public final g bqR()
  {
    return this.lFT.tY(1);
  }
  
  public final g bqS()
  {
    return this.lFT.bqS();
  }
  
  public void destroy()
  {
    this.lFS.cZl.s(new a.3(this));
    e locale = this.lFT;
    SparseArray localSparseArray = locale.lGi;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.lGi.size())
        {
          int j = locale.lGi.keyAt(i);
          if (j == 1) {
            break label163;
          }
          ae.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.lGi.get(j) == null) {
            ae.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.lGi.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.lGi.clear();
      super.destroy();
      this.cZJ.quit();
      return;
      label163:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.lFS.a(e.bqU(), paramh);
  }
  
  public final g tY(int paramInt)
  {
    return this.lFT.tY(paramInt);
  }
  
  public final void tZ(int paramInt)
  {
    e locale = this.lFT;
    ae.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.lGi)
    {
      d locald = (d)locale.lGi.get(paramInt);
      locale.lGi.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a
 * JD-Core Version:    0.7.0.1
 */