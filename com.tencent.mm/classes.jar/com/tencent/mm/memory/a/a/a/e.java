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
  public int maxSize;
  protected a nOk;
  public f<T, X> nOp = null;
  public d<T, Y> nOq = null;
  public f.b<T, V> nOr = null;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb)
  {
    this.nOr = paramb;
    this.maxSize = 10;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.nOr = paramb;
    this.maxSize = paramInt;
    this.nOk = parama;
    init();
  }
  
  public void B(T paramT, V paramV)
  {
    this.nOp.B(paramT, dt(paramV));
    if (this.nOq != null)
    {
      Object localObject = bvY();
      this.nOq.d(localObject, paramT, E(paramT, paramV));
    }
  }
  
  protected abstract Y E(T paramT, V paramV);
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.nOp.a(new f.a() {});
  }
  
  protected abstract T bvY();
  
  protected f<T, X> bvZ()
  {
    new h(this.maxSize, new f.b()
    {
      public final void preRemoveCallback(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.nOr != null) {
          e.this.nOr.preRemoveCallback(paramAnonymousT, e.this.dr(paramAnonymousX1), e.this.dr(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  public boolean check(T paramT)
  {
    boolean bool = this.nOp.check(paramT);
    if (this.nOq != null) {
      this.nOq.G(bvY(), paramT);
    }
    return bool;
  }
  
  public boolean checkAndUpTime(T paramT)
  {
    boolean bool = this.nOp.checkAndUpTime(paramT);
    if (this.nOq != null) {
      this.nOq.L(bvY(), paramT);
    }
    return bool;
  }
  
  public final void clear()
  {
    this.nOp.clear();
  }
  
  public int createCount()
  {
    int i = this.nOp.createCount();
    if (this.nOq != null) {
      this.nOq.createCount();
    }
    return i;
  }
  
  public V ct(T paramT)
  {
    Object localObject = dr(this.nOp.ct(paramT));
    if (this.nOq != null) {
      this.nOq.K(bvY(), paramT);
    }
    return localObject;
  }
  
  protected abstract V dr(X paramX);
  
  protected abstract X dt(V paramV);
  
  public int evictionCount()
  {
    int i = this.nOp.evictionCount();
    if (this.nOq != null) {
      this.nOq.evictionCount();
    }
    return i;
  }
  
  public V get(T paramT)
  {
    Object localObject = dr(this.nOp.get(paramT));
    if (this.nOq != null) {
      this.nOq.J(bvY(), paramT);
    }
    return localObject;
  }
  
  public int hitCount()
  {
    int i = this.nOp.hitCount();
    if (this.nOq != null) {
      this.nOq.hitCount();
    }
    return i;
  }
  
  protected void init()
  {
    this.nOp = bvZ();
    this.nOq = a(this.nOk);
  }
  
  public Set<T> keySet()
  {
    return this.nOp.keySet();
  }
  
  public int maxSize()
  {
    int i = this.nOp.maxSize();
    if (this.nOq != null) {
      this.nOq.maxSize();
    }
    return i;
  }
  
  public int missCount()
  {
    int i = this.nOp.missCount();
    if (this.nOq != null) {
      this.nOq.missCount();
    }
    return i;
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = dr(this.nOp.put(paramT, dt(paramV)));
    if (this.nOq != null)
    {
      Object localObject2 = bvY();
      this.nOq.e(localObject2, paramT, E(paramT, paramV));
    }
    return localObject1;
  }
  
  public int putCount()
  {
    int i = this.nOp.putCount();
    if (this.nOq != null) {
      this.nOq.putCount();
    }
    return i;
  }
  
  public V remove(T paramT)
  {
    Object localObject = dr(this.nOp.remove(paramT));
    if (this.nOq != null) {
      this.nOq.I(bvY(), paramT);
    }
    return localObject;
  }
  
  public int size()
  {
    int i = this.nOp.size();
    if (this.nOq != null) {
      this.nOq.size();
    }
    return i;
  }
  
  public int sizeOf(T paramT, V paramV)
  {
    return this.nOp.sizeOf(paramT, dt(paramV));
  }
  
  public void trimToSize(int paramInt)
  {
    this.nOp.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */