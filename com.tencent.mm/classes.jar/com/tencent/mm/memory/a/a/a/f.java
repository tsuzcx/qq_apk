package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  h<T, V> iuA;
  b<T, V> iuB = null;
  f.b<T, V> iuC;
  f.c<T, V> iuD;
  a iuf = null;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.iuf = parama;
    this.iuC = paramb;
    this.iuD = paramc;
    this.iuA = new h(this.iuf.iuk, new f.b()new f.c {}, new f.c() {});
    this.iuB = new b(this.iuf, new b.a()new b.b {}, new b.b() {});
  }
  
  protected abstract T B(T paramT1, T paramT2);
  
  public final boolean C(T paramT1, T paramT2)
  {
    return (this.iuA.check(B(paramT1, paramT2))) || (this.iuB.C(paramT1, paramT2));
  }
  
  public final boolean H(T paramT1, T paramT2)
  {
    boolean bool1 = this.iuA.checkAndUpTime(B(paramT1, paramT2));
    boolean bool2 = this.iuB.cc(paramT1).checkAndUpTime(paramT2);
    return (bool1) || (bool2);
  }
  
  public final void aSq()
  {
    Log.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.iuf.iuk), Integer.valueOf((int)(this.iuf.iuk * 2.0D)) });
    this.iuA.setMaxSize((int)(this.iuf.iuk * 2.0D));
  }
  
  public final void axJ()
  {
    Log.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.iuf.iuk) });
    this.iuA.setMaxSize(this.iuf.iuk);
  }
  
  public final int createCount()
  {
    return this.iuA.createCount();
  }
  
  public final int evictionCount()
  {
    return this.iuA.evictionCount();
  }
  
  public final int hitCount()
  {
    return this.iuA.hitCount();
  }
  
  public final int maxSize()
  {
    return this.iuA.maxSize();
  }
  
  public final int missCount()
  {
    return this.iuA.missCount();
  }
  
  public final int putCount()
  {
    return this.iuA.putCount();
  }
  
  public final int size()
  {
    return this.iuA.size();
  }
  
  public final void trimToSize(int paramInt)
  {
    this.iuA.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */