package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  h<T, V> ljJ;
  b<T, V> ljK = null;
  f.b<T, V> ljL;
  f.c<T, V> ljM;
  a ljo = null;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.ljo = parama;
    this.ljL = paramb;
    this.ljM = paramc;
    this.ljJ = new h(this.ljo.ljt, new f.b()new f.c {}, new f.c() {});
    this.ljK = new b(this.ljo, new b.a()new b.b {}, new b.b() {});
  }
  
  public final boolean A(T paramT1, T paramT2)
  {
    boolean bool1 = this.ljJ.checkAndUpTime(u(paramT1, paramT2));
    boolean bool2 = this.ljK.cc(paramT1).checkAndUpTime(paramT2);
    return (bool1) || (bool2);
  }
  
  public final void aFa()
  {
    Log.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.ljo.ljt) });
    this.ljJ.setMaxSize(this.ljo.ljt);
  }
  
  public final void bbn()
  {
    Log.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.ljo.ljt), Integer.valueOf((int)(this.ljo.ljt * 2.0D)) });
    this.ljJ.setMaxSize((int)(this.ljo.ljt * 2.0D));
  }
  
  public final int createCount()
  {
    return this.ljJ.createCount();
  }
  
  public final int evictionCount()
  {
    return this.ljJ.evictionCount();
  }
  
  public final int hitCount()
  {
    return this.ljJ.hitCount();
  }
  
  public final int maxSize()
  {
    return this.ljJ.maxSize();
  }
  
  public final int missCount()
  {
    return this.ljJ.missCount();
  }
  
  public final int putCount()
  {
    return this.ljJ.putCount();
  }
  
  public final int size()
  {
    return this.ljJ.size();
  }
  
  public final void trimToSize(int paramInt)
  {
    this.ljJ.trimToSize(paramInt);
  }
  
  protected abstract T u(T paramT1, T paramT2);
  
  public final boolean v(T paramT1, T paramT2)
  {
    return (this.ljJ.check(u(paramT1, paramT2))) || (this.ljK.v(paramT1, paramT2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */