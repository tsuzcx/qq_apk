package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.h;
import java.util.Set;

public abstract class e<T, V, X, Y>
  implements f<T, V>
{
  protected a feC;
  public f<T, X> feH = null;
  public d<T, Y> feI = null;
  public f.b<T, V> feJ = null;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.feJ = paramb;
    this.maxSize = paramInt;
    this.feC = parama;
    init();
  }
  
  public e(f.b<T, V> paramb)
  {
    this.feJ = paramb;
    this.maxSize = 10;
    init();
  }
  
  protected abstract T XY();
  
  protected f<T, X> XZ()
  {
    new h(this.maxSize, new f.b()
    {
      public final void c(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(115467);
        if (e.this.feJ != null) {
          e.this.feJ.c(paramAnonymousT, e.this.aK(paramAnonymousX1), e.this.aK(paramAnonymousX2));
        }
        AppMethodBeat.o(115467);
      }
    });
  }
  
  public V Y(T paramT)
  {
    Object localObject = aK(this.feH.Y(paramT));
    if (this.feI != null) {
      this.feI.p(XY(), paramT);
    }
    return localObject;
  }
  
  public final boolean Z(T paramT)
  {
    boolean bool = this.feH.Z(paramT);
    if (this.feI != null) {
      this.feI.l(XY(), paramT);
    }
    return bool;
  }
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.feH.a(new f.a() {});
  }
  
  protected abstract V aK(X paramX);
  
  protected abstract X aM(V paramV);
  
  public final boolean aa(T paramT)
  {
    boolean bool = this.feH.aa(paramT);
    if (this.feI != null) {
      this.feI.q(XY(), paramT);
    }
    return bool;
  }
  
  public final void clear()
  {
    this.feH.clear();
  }
  
  public final int createCount()
  {
    return this.feH.createCount();
  }
  
  public final int evictionCount()
  {
    return this.feH.evictionCount();
  }
  
  public void f(T paramT, V paramV)
  {
    this.feH.f(paramT, aM(paramV));
    if (this.feI != null)
    {
      Object localObject = XY();
      this.feI.f(localObject, paramT, j(paramT, paramV));
    }
  }
  
  public V get(T paramT)
  {
    Object localObject = aK(this.feH.get(paramT));
    if (this.feI != null) {
      this.feI.o(XY(), paramT);
    }
    return localObject;
  }
  
  public final int hitCount()
  {
    return this.feH.hitCount();
  }
  
  protected void init()
  {
    this.feH = XZ();
    this.feI = a(this.feC);
  }
  
  protected abstract Y j(T paramT, V paramV);
  
  public final Set<T> keySet()
  {
    return this.feH.keySet();
  }
  
  public final int maxSize()
  {
    return this.feH.maxSize();
  }
  
  public final int missCount()
  {
    return this.feH.missCount();
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = aK(this.feH.put(paramT, aM(paramV)));
    if (this.feI != null)
    {
      Object localObject2 = XY();
      this.feI.g(localObject2, paramT, j(paramT, paramV));
    }
    return localObject1;
  }
  
  public final int putCount()
  {
    return this.feH.putCount();
  }
  
  public V remove(T paramT)
  {
    Object localObject = aK(this.feH.remove(paramT));
    if (this.feI != null) {
      this.feI.n(XY(), paramT);
    }
    return localObject;
  }
  
  public final int size()
  {
    return this.feH.size();
  }
  
  public final int sizeOf(T paramT, V paramV)
  {
    return this.feH.sizeOf(paramT, aM(paramV));
  }
  
  public final void trimToSize(int paramInt)
  {
    this.feH.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */