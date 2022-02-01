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
  protected a gEM;
  public f<T, X> gER = null;
  public d<T, Y> gES = null;
  public f.b<T, V> gET = null;
  public int maxSize;
  
  public e(int paramInt)
  {
    this.maxSize = paramInt;
    init();
  }
  
  public e(int paramInt, f.b<T, V> paramb, a parama)
  {
    this.gET = paramb;
    this.maxSize = paramInt;
    this.gEM = parama;
    init();
  }
  
  public e(f.b<T, V> paramb)
  {
    this.gET = paramb;
    this.maxSize = 10;
    init();
  }
  
  protected d<T, Y> a(a parama)
  {
    return null;
  }
  
  public final void a(final f.a<T, V> parama)
  {
    this.gER.a(new f.a() {});
  }
  
  public V aM(T paramT)
  {
    Object localObject = bP(this.gER.aM(paramT));
    if (this.gES != null) {
      this.gES.x(aph(), paramT);
    }
    return localObject;
  }
  
  public final boolean aN(T paramT)
  {
    boolean bool = this.gER.aN(paramT);
    if (this.gES != null) {
      this.gES.t(aph(), paramT);
    }
    return bool;
  }
  
  public final boolean aO(T paramT)
  {
    boolean bool = this.gER.aO(paramT);
    if (this.gES != null) {
      this.gES.y(aph(), paramT);
    }
    return bool;
  }
  
  protected abstract T aph();
  
  protected f<T, X> api()
  {
    new h(this.maxSize, new f.b()
    {
      public final void c(T paramAnonymousT, X paramAnonymousX1, X paramAnonymousX2)
      {
        AppMethodBeat.i(156513);
        if (e.this.gET != null) {
          e.this.gET.c(paramAnonymousT, e.this.bP(paramAnonymousX1), e.this.bP(paramAnonymousX2));
        }
        AppMethodBeat.o(156513);
      }
    });
  }
  
  protected abstract V bP(X paramX);
  
  protected abstract X bR(V paramV);
  
  public final void clear()
  {
    this.gER.clear();
  }
  
  public final int createCount()
  {
    return this.gER.createCount();
  }
  
  public final int evictionCount()
  {
    return this.gER.evictionCount();
  }
  
  public V get(T paramT)
  {
    Object localObject = bP(this.gER.get(paramT));
    if (this.gES != null) {
      this.gES.w(aph(), paramT);
    }
    return localObject;
  }
  
  public final int hitCount()
  {
    return this.gER.hitCount();
  }
  
  protected void init()
  {
    this.gER = api();
    this.gES = a(this.gEM);
  }
  
  public final Set<T> keySet()
  {
    return this.gER.keySet();
  }
  
  public final int maxSize()
  {
    return this.gER.maxSize();
  }
  
  public final int missCount()
  {
    return this.gER.missCount();
  }
  
  public void o(T paramT, V paramV)
  {
    this.gER.o(paramT, bR(paramV));
    if (this.gES != null)
    {
      Object localObject = aph();
      this.gES.f(localObject, paramT, r(paramT, paramV));
    }
  }
  
  public V put(T paramT, V paramV)
  {
    Object localObject1 = bP(this.gER.put(paramT, bR(paramV)));
    if (this.gES != null)
    {
      Object localObject2 = aph();
      this.gES.g(localObject2, paramT, r(paramT, paramV));
    }
    return localObject1;
  }
  
  public final int putCount()
  {
    return this.gER.putCount();
  }
  
  protected abstract Y r(T paramT, V paramV);
  
  public V remove(T paramT)
  {
    Object localObject = bP(this.gER.remove(paramT));
    if (this.gES != null) {
      this.gES.v(aph(), paramT);
    }
    return localObject;
  }
  
  public final int size()
  {
    return this.gER.size();
  }
  
  public final int sizeOf(T paramT, V paramV)
  {
    return this.gER.sizeOf(paramT, bR(paramV));
  }
  
  public final void trimToSize(int paramInt)
  {
    this.gER.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */