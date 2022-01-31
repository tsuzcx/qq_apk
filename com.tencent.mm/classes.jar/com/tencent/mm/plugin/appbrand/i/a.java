package com.tencent.mm.plugin.appbrand.i;

import android.util.SparseArray;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public abstract class a
  extends d
  implements i, k, m, q, r, s
{
  private final c cbT = r(paramString, paramArrayOfByte);
  final l ijd = a(this.cbT, e.aGE());
  private final e ije = new e(new a.1(this));
  private ArrayList<m.a> ijf = new ArrayList();
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = this.ije;
    ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
    paramString.ijl.put(1, this);
  }
  
  protected abstract l a(c paramc, int paramInt);
  
  public final void a(m.a parama)
  {
    try
    {
      this.ijf.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final int aGA()
  {
    return e.aGE();
  }
  
  public final g aGB()
  {
    return this.ije.ow(1);
  }
  
  public final g aGC()
  {
    return this.ije.aGC();
  }
  
  protected final c aGx()
  {
    return this.cbT;
  }
  
  protected final l aGy()
  {
    return this.ijd;
  }
  
  public final boolean aGz()
  {
    return true;
  }
  
  public void destroy()
  {
    this.ijd.cbC.l(new a.2(this));
    e locale = this.ije;
    SparseArray localSparseArray = locale.ijl;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < locale.ijl.size())
        {
          int j = locale.ijl.keyAt(i);
          if (j == 1) {
            break label163;
          }
          ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
          if (locale.ijl.get(j) == null) {
            ab.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
          } else {
            ((d)locale.ijl.get(j)).destroy();
          }
        }
      }
      finally {}
      localObject.ijl.clear();
      super.destroy();
      this.cbT.quit();
      return;
      label163:
      i += 1;
    }
  }
  
  public final g ow(int paramInt)
  {
    return this.ije.ow(paramInt);
  }
  
  public final void ox(int paramInt)
  {
    e locale = this.ije;
    ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (locale.ijl)
    {
      d locald = (d)locale.ijl.get(paramInt);
      locale.ijl.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
  
  protected abstract c r(String paramString, byte[] paramArrayOfByte);
  
  public void setJsExceptionHandler(h paramh)
  {
    this.ijd.a(e.aGE(), paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.a
 * JD-Core Version:    0.7.0.1
 */