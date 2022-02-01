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
  protected a hAj;
  public f<T, X> hAo = null;
  public d<T, Y> hAp = null;
  public f.b<T, V> hAq = null;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.hAq = paramb;
    this.maxSize = paramInt;
    this.hAj = parama;
    init();
  }
  
  public e(f.b<T, V> paramb)
  {
    this.hAq = paramb;
    this.maxSize = 10;
    init();
  }
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.hAo.a(new f.a() {});
  }
  
  public V aL(T paramT)
  {
    Object localObject = bP(this.hAo.aL(paramT));
    if (this.hAp != null) {
      this.hAp.z(aza(), paramT);
    }
    return localObject;
  }
  
  public final boolean aM(T paramT)
  {
    boolean bool = this.hAo.aM(paramT);
    if (this.hAp != null) {
      this.hAp.v(aza(), paramT);
    }
    return bool;
  }
  
  public final boolean aN(T paramT)
  {
    boolean bool = this.hAo.aN(paramT);
    if (this.hAp != null) {
      this.hAp.A(aza(), paramT);
    }
    return bool;
  }
  
  protected abstract T aza();
  
  protected f<T, X> azb()
  {
    new h(this.maxSize, new f.b()
    {
      public final void c(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.hAq != null) {
          e.this.hAq.c(paramAnonymousT, e.this.bP(paramAnonymousX1), e.this.bP(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  protected abstract V bP(X paramX);
  
  protected abstract X bR(V paramV);
  
  public final void clear()
  {
    this.hAo.clear();
  }
  
  public final int createCount()
  {
    return this.hAo.createCount();
  }
  
  public final int evictionCount()
  {
    return this.hAo.evictionCount();
  }
  
  public V get(T paramT)
  {
    Object localObject = bP(this.hAo.get(paramT));
    if (this.hAp != null) {
      this.hAp.y(aza(), paramT);
    }
    return localObject;
  }
  
  public final int hitCount()
  {
    return this.hAo.hitCount();
  }
  
  protected void init()
  {
    this.hAo = azb();
    this.hAp = a(this.hAj);
  }
  
  public final Set<T> keySet()
  {
    return this.hAo.keySet();
  }
  
  public final int maxSize()
  {
    return this.hAo.maxSize();
  }
  
  public final int missCount()
  {
    return this.hAo.missCount();
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = bP(this.hAo.put(paramT, bR(paramV)));
    if (this.hAp != null)
    {
      Object localObject2 = aza();
      this.hAp.g(localObject2, paramT, t(paramT, paramV));
    }
    return localObject1;
  }
  
  public final int putCount()
  {
    return this.hAo.putCount();
  }
  
  public void q(T paramT, V paramV)
  {
    this.hAo.q(paramT, bR(paramV));
    if (this.hAp != null)
    {
      Object localObject = aza();
      this.hAp.f(localObject, paramT, t(paramT, paramV));
    }
  }
  
  public V remove(T paramT)
  {
    Object localObject = bP(this.hAo.remove(paramT));
    if (this.hAp != null) {
      this.hAp.x(aza(), paramT);
    }
    return localObject;
  }
  
  public final int size()
  {
    return this.hAo.size();
  }
  
  public final int sizeOf(T paramT, V paramV)
  {
    return this.hAo.sizeOf(paramT, bR(paramV));
  }
  
  protected abstract Y t(T paramT, V paramV);
  
  public final void trimToSize(int paramInt)
  {
    this.hAo.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */