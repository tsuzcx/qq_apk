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
  public f<T, X> ljE = null;
  public d<T, Y> ljF = null;
  public f.b<T, V> ljG = null;
  protected a ljz;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb)
  {
    this.ljG = paramb;
    this.maxSize = 10;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.ljG = paramb;
    this.maxSize = paramInt;
    this.ljz = parama;
    init();
  }
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.ljE.a(new f.a() {});
  }
  
  public V aX(T paramT)
  {
    Object localObject = bY(this.ljE.aX(paramT));
    if (this.ljF != null) {
      this.ljF.z(bbd(), paramT);
    }
    return localObject;
  }
  
  protected abstract V bY(X paramX);
  
  protected abstract T bbd();
  
  protected f<T, X> bbe()
  {
    new h(this.maxSize, new f.b()
    {
      public final void preRemoveCallback(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.ljG != null) {
          e.this.ljG.preRemoveCallback(paramAnonymousT, e.this.bY(paramAnonymousX1), e.this.bY(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  protected abstract X ca(V paramV);
  
  public boolean check(T paramT)
  {
    boolean bool = this.ljE.check(paramT);
    if (this.ljF != null) {
      this.ljF.v(bbd(), paramT);
    }
    return bool;
  }
  
  public boolean checkAndUpTime(T paramT)
  {
    boolean bool = this.ljE.checkAndUpTime(paramT);
    if (this.ljF != null) {
      this.ljF.A(bbd(), paramT);
    }
    return bool;
  }
  
  public final void clear()
  {
    this.ljE.clear();
  }
  
  public int createCount()
  {
    int i = this.ljE.createCount();
    if (this.ljF != null) {
      this.ljF.createCount();
    }
    return i;
  }
  
  public int evictionCount()
  {
    int i = this.ljE.evictionCount();
    if (this.ljF != null) {
      this.ljF.evictionCount();
    }
    return i;
  }
  
  public V get(T paramT)
  {
    Object localObject = bY(this.ljE.get(paramT));
    if (this.ljF != null) {
      this.ljF.y(bbd(), paramT);
    }
    return localObject;
  }
  
  public int hitCount()
  {
    int i = this.ljE.hitCount();
    if (this.ljF != null) {
      this.ljF.hitCount();
    }
    return i;
  }
  
  protected void init()
  {
    this.ljE = bbe();
    this.ljF = a(this.ljz);
  }
  
  public Set<T> keySet()
  {
    return this.ljE.keySet();
  }
  
  public int maxSize()
  {
    int i = this.ljE.maxSize();
    if (this.ljF != null) {
      this.ljF.maxSize();
    }
    return i;
  }
  
  public int missCount()
  {
    int i = this.ljE.missCount();
    if (this.ljF != null) {
      this.ljF.missCount();
    }
    return i;
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = bY(this.ljE.put(paramT, ca(paramV)));
    if (this.ljF != null)
    {
      Object localObject2 = bbd();
      this.ljF.f(localObject2, paramT, t(paramT, paramV));
    }
    return localObject1;
  }
  
  public int putCount()
  {
    int i = this.ljE.putCount();
    if (this.ljF != null) {
      this.ljF.putCount();
    }
    return i;
  }
  
  public void q(T paramT, V paramV)
  {
    this.ljE.q(paramT, ca(paramV));
    if (this.ljF != null)
    {
      Object localObject = bbd();
      this.ljF.e(localObject, paramT, t(paramT, paramV));
    }
  }
  
  public V remove(T paramT)
  {
    Object localObject = bY(this.ljE.remove(paramT));
    if (this.ljF != null) {
      this.ljF.x(bbd(), paramT);
    }
    return localObject;
  }
  
  public int size()
  {
    int i = this.ljE.size();
    if (this.ljF != null) {
      this.ljF.size();
    }
    return i;
  }
  
  public int sizeOf(T paramT, V paramV)
  {
    return this.ljE.sizeOf(paramT, ca(paramV));
  }
  
  protected abstract Y t(T paramT, V paramV);
  
  public void trimToSize(int paramInt)
  {
    this.ljE.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */