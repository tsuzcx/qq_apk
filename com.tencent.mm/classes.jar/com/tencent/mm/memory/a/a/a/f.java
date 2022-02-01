package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  a nNZ = null;
  h<T, V> nOu;
  b<T, V> nOv = null;
  f.b<T, V> nOw;
  f.c<T, V> nOx;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.nNZ = parama;
    this.nOw = paramb;
    this.nOx = paramc;
    this.nOu = new h(this.nNZ.nOe, new f.b()new f.c {}, new f.c() {});
    this.nOv = new b(this.nNZ, new b.a()new b.b {}, new b.b() {});
  }
  
  protected abstract T F(T paramT1, T paramT2);
  
  public final boolean G(T paramT1, T paramT2)
  {
    return (this.nOu.check(F(paramT1, paramT2))) || (this.nOv.G(paramT1, paramT2));
  }
  
  public final boolean L(T paramT1, T paramT2)
  {
    boolean bool1 = this.nOu.checkAndUpTime(F(paramT1, paramT2));
    boolean bool2 = this.nOv.du(paramT1).checkAndUpTime(paramT2);
    return (bool1) || (bool2);
  }
  
  public final void bwi()
  {
    Log.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.nNZ.nOe), Integer.valueOf((int)(this.nNZ.nOe * 2.0D)) });
    this.nOu.setMaxSize((int)(this.nNZ.nOe * 2.0D));
  }
  
  public final int createCount()
  {
    return this.nOu.createCount();
  }
  
  public final int evictionCount()
  {
    return this.nOu.evictionCount();
  }
  
  public final int hitCount()
  {
    return this.nOu.hitCount();
  }
  
  public final int maxSize()
  {
    return this.nOu.maxSize();
  }
  
  public final int missCount()
  {
    return this.nOu.missCount();
  }
  
  public final int putCount()
  {
    return this.nOu.putCount();
  }
  
  public final void resetSize()
  {
    Log.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.nNZ.nOe) });
    this.nOu.setMaxSize(this.nNZ.nOe);
  }
  
  public final int size()
  {
    return this.nOu.size();
  }
  
  public final void trimToSize(int paramInt)
  {
    this.nOu.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */