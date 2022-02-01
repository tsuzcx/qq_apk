package com.tencent.mm.plugin.appbrand.n;

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
  public final IJSRuntime hnh = g(paramConfig);
  public final com.tencent.mm.appbrand.v8.m sSU;
  public final e sSV;
  private ArrayList<m.a> sSW = new ArrayList();
  private ArrayList<m.a> sSX = new ArrayList();
  private final Object sSY = new byte[0];
  private ArrayList<p.a> sSZ = new ArrayList();
  private final boolean sTa;
  
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
    if ((paramConfig != null) && (paramConfig.hme)) {}
    for (boolean bool = true;; bool = false)
    {
      this.sTa = bool;
      this.sSU = a(this.hnh, e.czl());
      this.hnh.u(new Runnable()
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
              ((p.a)((Iterator)???).next()).coH();
            }
          }
        }
      });
      this.sSV = new e(new e.a()
      {
        public final com.tencent.mm.appbrand.v8.m BP(int paramAnonymousInt)
        {
          AppMethodBeat.i(144155);
          com.tencent.mm.appbrand.v8.m localm = a.d(a.this).nN(paramAnonymousInt);
          AppMethodBeat.o(144155);
          return localm;
        }
      });
      paramConfig = this.sSV;
      Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
      paramConfig.sTj.put(1, this);
      return;
    }
  }
  
  public final g BK(int paramInt)
  {
    return this.sSV.BK(paramInt);
  }
  
  public final void BL(int paramInt)
  {
    e locale = this.sSV;
    Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.sTj)
    {
      d locald = (d)locale.sTj.get(paramInt);
      locale.sTj.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    if ((paramClass == n.class) && (!this.sTa)) {
      return null;
    }
    return super.Z(paramClass);
  }
  
  protected abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      a(parama, false);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(m.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.sSX.add(parama);
        return;
      }
      finally {}
      this.sSW.add(parama);
    }
  }
  
  public final void a(p.a parama)
  {
    synchronized (this.sSY)
    {
      if (this.sSZ != null) {
        this.sSZ.add(parama);
      }
      return;
    }
  }
  
  public final IJSRuntime cze()
  {
    return this.hnh;
  }
  
  public final com.tencent.mm.appbrand.v8.m czf()
  {
    return this.sSU;
  }
  
  public final boolean czg()
  {
    return true;
  }
  
  public final int czh()
  {
    return e.czl();
  }
  
  public final g czi()
  {
    return this.sSV.BK(1);
  }
  
  public final g czj()
  {
    return this.sSV.czj();
  }
  
  public void destroy()
  {
    this.sSU.hmL.w(new a.3(this));
    e locale = this.sSV;
    SparseArray localSparseArray = locale.sTj;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.sTj.size())
        {
          int j = locale.sTj.keyAt(i);
          if (j == 1) {
            break label165;
          }
          Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.sTj.get(j) == null) {
            Log.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.sTj.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.sTj.clear();
      super.destroy();
      this.hnh.quit();
      return;
      label165:
      i += 1;
    }
  }
  
  protected abstract IJSRuntime g(IJSRuntime.Config paramConfig);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.sSU.a(e.czl(), paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a
 * JD-Core Version:    0.7.0.1
 */