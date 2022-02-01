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
  public f<T, X> hxA = null;
  public d<T, Y> hxB = null;
  public f.b<T, V> hxC = null;
  protected a hxv;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.hxC = paramb;
    this.maxSize = paramInt;
    this.hxv = parama;
    init();
  }
  
  public e(f.b<T, V> paramb)
  {
    this.hxC = paramb;
    this.maxSize = 10;
    init();
  }
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.hxA.a(new f.a() {});
  }
  
  public V aL(T paramT)
  {
    Object localObject = bP(this.hxA.aL(paramT));
    if (this.hxB != null) {
      this.hxB.z(ayL(), paramT);
    }
    return localObject;
  }
  
  public final boolean aM(T paramT)
  {
    boolean bool = this.hxA.aM(paramT);
    if (this.hxB != null) {
      this.hxB.v(ayL(), paramT);
    }
    return bool;
  }
  
  public final boolean aN(T paramT)
  {
    boolean bool = this.hxA.aN(paramT);
    if (this.hxB != null) {
      this.hxB.A(ayL(), paramT);
    }
    return bool;
  }
  
  protected abstract T ayL();
  
  protected f<T, X> ayM()
  {
    new h(this.maxSize, new f.b()
    {
      public final void c(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.hxC != null) {
          e.this.hxC.c(paramAnonymousT, e.this.bP(paramAnonymousX1), e.this.bP(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  protected abstract V bP(X paramX);
  
  protected abstract X bR(V paramV);
  
  public final void clear()
  {
    this.hxA.clear();
  }
  
  public final int createCount()
  {
    return this.hxA.createCount();
  }
  
  public final int evictionCount()
  {
    return this.hxA.evictionCount();
  }
  
  public V get(T paramT)
  {
    Object localObject = bP(this.hxA.get(paramT));
    if (this.hxB != null) {
      this.hxB.y(ayL(), paramT);
    }
    return localObject;
  }
  
  public final int hitCount()
  {
    return this.hxA.hitCount();
  }
  
  protected void init()
  {
    this.hxA = ayM();
    this.hxB = a(this.hxv);
  }
  
  public final Set<T> keySet()
  {
    return this.hxA.keySet();
  }
  
  public final int maxSize()
  {
    return this.hxA.maxSize();
  }
  
  public final int missCount()
  {
    return this.hxA.missCount();
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = bP(this.hxA.put(paramT, bR(paramV)));
    if (this.hxB != null)
    {
      Object localObject2 = ayL();
      this.hxB.g(localObject2, paramT, t(paramT, paramV));
    }
    return localObject1;
  }
  
  public final int putCount()
  {
    return this.hxA.putCount();
  }
  
  public void q(T paramT, V paramV)
  {
    this.hxA.q(paramT, bR(paramV));
    if (this.hxB != null)
    {
      Object localObject = ayL();
      this.hxB.f(localObject, paramT, t(paramT, paramV));
    }
  }
  
  public V remove(T paramT)
  {
    Object localObject = bP(this.hxA.remove(paramT));
    if (this.hxB != null) {
      this.hxB.x(ayL(), paramT);
    }
    return localObject;
  }
  
  public final int size()
  {
    return this.hxA.size();
  }
  
  public final int sizeOf(T paramT, V paramV)
  {
    return this.hxA.sizeOf(paramT, bR(paramV));
  }
  
  protected abstract Y t(T paramT, V paramV);
  
  public final void trimToSize(int paramInt)
  {
    this.hxA.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */