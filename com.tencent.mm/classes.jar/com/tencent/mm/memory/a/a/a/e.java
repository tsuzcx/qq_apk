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
  protected a iuq;
  public f<T, X> iuv = null;
  public d<T, Y> iuw = null;
  public f.b<T, V> iux = null;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb)
  {
    this.iux = paramb;
    this.maxSize = 10;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.iux = paramb;
    this.maxSize = paramInt;
    this.iuq = parama;
    init();
  }
  
  protected abstract Y A(T paramT, V paramV);
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.iuv.a(new f.a() {});
  }
  
  protected abstract T aSg();
  
  protected f<T, X> aSh()
  {
    new h(this.maxSize, new f.b()
    {
      public final void c(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.iux != null) {
          e.this.iux.c(paramAnonymousT, e.this.bY(paramAnonymousX1), e.this.bY(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  public V aT(T paramT)
  {
    Object localObject = bY(this.iuv.aT(paramT));
    if (this.iuw != null) {
      this.iuw.G(aSg(), paramT);
    }
    return localObject;
  }
  
  protected abstract V bY(X paramX);
  
  protected abstract X ca(V paramV);
  
  public boolean check(T paramT)
  {
    boolean bool = this.iuv.check(paramT);
    if (this.iuw != null) {
      this.iuw.C(aSg(), paramT);
    }
    return bool;
  }
  
  public boolean checkAndUpTime(T paramT)
  {
    boolean bool = this.iuv.checkAndUpTime(paramT);
    if (this.iuw != null) {
      this.iuw.H(aSg(), paramT);
    }
    return bool;
  }
  
  public final void clear()
  {
    this.iuv.clear();
  }
  
  public int createCount()
  {
    int i = this.iuv.createCount();
    if (this.iuw != null) {
      this.iuw.createCount();
    }
    return i;
  }
  
  public int evictionCount()
  {
    int i = this.iuv.evictionCount();
    if (this.iuw != null) {
      this.iuw.evictionCount();
    }
    return i;
  }
  
  public V get(T paramT)
  {
    Object localObject = bY(this.iuv.get(paramT));
    if (this.iuw != null) {
      this.iuw.F(aSg(), paramT);
    }
    return localObject;
  }
  
  public int hitCount()
  {
    int i = this.iuv.hitCount();
    if (this.iuw != null) {
      this.iuw.hitCount();
    }
    return i;
  }
  
  protected void init()
  {
    this.iuv = aSh();
    this.iuw = a(this.iuq);
  }
  
  public Set<T> keySet()
  {
    return this.iuv.keySet();
  }
  
  public int maxSize()
  {
    int i = this.iuv.maxSize();
    if (this.iuw != null) {
      this.iuw.maxSize();
    }
    return i;
  }
  
  public int missCount()
  {
    int i = this.iuv.missCount();
    if (this.iuw != null) {
      this.iuw.missCount();
    }
    return i;
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = bY(this.iuv.put(paramT, ca(paramV)));
    if (this.iuw != null)
    {
      Object localObject2 = aSg();
      this.iuw.g(localObject2, paramT, A(paramT, paramV));
    }
    return localObject1;
  }
  
  public int putCount()
  {
    int i = this.iuv.putCount();
    if (this.iuw != null) {
      this.iuw.putCount();
    }
    return i;
  }
  
  public V remove(T paramT)
  {
    Object localObject = bY(this.iuv.remove(paramT));
    if (this.iuw != null) {
      this.iuw.E(aSg(), paramT);
    }
    return localObject;
  }
  
  public int size()
  {
    int i = this.iuv.size();
    if (this.iuw != null) {
      this.iuw.size();
    }
    return i;
  }
  
  public int sizeOf(T paramT, V paramV)
  {
    return this.iuv.sizeOf(paramT, ca(paramV));
  }
  
  public void trimToSize(int paramInt)
  {
    this.iuv.trimToSize(paramInt);
  }
  
  public void x(T paramT, V paramV)
  {
    this.iuv.x(paramT, ca(paramV));
    if (this.iuw != null)
    {
      Object localObject = aSg();
      this.iuw.f(localObject, paramT, A(paramT, paramV));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */