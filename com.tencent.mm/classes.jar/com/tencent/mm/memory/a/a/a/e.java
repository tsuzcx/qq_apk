package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.h;
import java.util.Set;

public abstract class e<T, V, X, Y>
  implements f<T, V>
{
  protected a hfn;
  public f<T, X> hfs = null;
  public d<T, Y> hft = null;
  public f.b<T, V> hfu = null;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.hfu = paramb;
    this.maxSize = paramInt;
    this.hfn = parama;
    init();
  }
  
  public e(f.b<T, V> paramb)
  {
    this.hfu = paramb;
    this.maxSize = 10;
    init();
  }
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.hfs.a(new f.a() {});
  }
  
  public V aJ(T paramT)
  {
    Object localObject = bN(this.hfs.aJ(paramT));
    if (this.hft != null) {
      this.hft.x(avY(), paramT);
    }
    return localObject;
  }
  
  public final boolean aK(T paramT)
  {
    boolean bool = this.hfs.aK(paramT);
    if (this.hft != null) {
      this.hft.t(avY(), paramT);
    }
    return bool;
  }
  
  public final boolean aL(T paramT)
  {
    boolean bool = this.hfs.aL(paramT);
    if (this.hft != null) {
      this.hft.y(avY(), paramT);
    }
    return bool;
  }
  
  protected abstract T avY();
  
  protected f<T, X> avZ()
  {
    new h(this.maxSize, new f.b()
    {
      public final void c(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.hfu != null) {
          e.this.hfu.c(paramAnonymousT, e.this.bN(paramAnonymousX1), e.this.bN(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  protected abstract V bN(X paramX);
  
  protected abstract X bP(V paramV);
  
  public final void clear()
  {
    this.hfs.clear();
  }
  
  public final int createCount()
  {
    return this.hfs.createCount();
  }
  
  public final int evictionCount()
  {
    return this.hfs.evictionCount();
  }
  
  public V get(T paramT)
  {
    Object localObject = bN(this.hfs.get(paramT));
    if (this.hft != null) {
      this.hft.w(avY(), paramT);
    }
    return localObject;
  }
  
  public final int hitCount()
  {
    return this.hfs.hitCount();
  }
  
  protected void init()
  {
    this.hfs = avZ();
    this.hft = a(this.hfn);
  }
  
  public final Set<T> keySet()
  {
    return this.hfs.keySet();
  }
  
  public final int maxSize()
  {
    return this.hfs.maxSize();
  }
  
  public final int missCount()
  {
    return this.hfs.missCount();
  }
  
  public void o(T paramT, V paramV)
  {
    this.hfs.o(paramT, bP(paramV));
    if (this.hft != null)
    {
      Object localObject = avY();
      this.hft.f(localObject, paramT, r(paramT, paramV));
    }
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = bN(this.hfs.put(paramT, bP(paramV)));
    if (this.hft != null)
    {
      Object localObject2 = avY();
      this.hft.g(localObject2, paramT, r(paramT, paramV));
    }
    return localObject1;
  }
  
  public final int putCount()
  {
    return this.hfs.putCount();
  }
  
  protected abstract Y r(T paramT, V paramV);
  
  public V remove(T paramT)
  {
    Object localObject = bN(this.hfs.remove(paramT));
    if (this.hft != null) {
      this.hft.v(avY(), paramT);
    }
    return localObject;
  }
  
  public final int size()
  {
    return this.hfs.size();
  }
  
  public final int sizeOf(T paramT, V paramV)
  {
    return this.hfs.sizeOf(paramT, bP(paramV));
  }
  
  public final void trimToSize(int paramInt)
  {
    this.hfs.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */