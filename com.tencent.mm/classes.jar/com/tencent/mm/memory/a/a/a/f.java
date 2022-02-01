package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  h<T, V> hxF;
  b<T, V> hxG = null;
  f.b<T, V> hxH;
  f.c<T, V> hxI;
  a hxk = null;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.hxk = parama;
    this.hxH = paramb;
    this.hxI = paramc;
    this.hxF = new h(this.hxk.hxp, new f.b()new f.c {}, new f.c() {});
    this.hxG = new b(this.hxk, new b.a()new b.b {}, new b.b() {});
  }
  
  public final boolean A(T paramT1, T paramT2)
  {
    boolean bool1 = this.hxF.aN(u(paramT1, paramT2));
    boolean bool2 = this.hxG.bS(paramT1).aN(paramT2);
    return (bool1) || (bool2);
  }
  
  public final void ahi()
  {
    ad.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.hxk.hxp) });
    this.hxF.setMaxSize(this.hxk.hxp);
  }
  
  public final void ayV()
  {
    ad.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.hxk.hxp), Integer.valueOf((int)(this.hxk.hxp * 2.0D)) });
    this.hxF.setMaxSize((int)(this.hxk.hxp * 2.0D));
  }
  
  public final int size()
  {
    return this.hxF.size();
  }
  
  public final void trimToSize(int paramInt)
  {
    this.hxF.trimToSize(paramInt);
  }
  
  protected abstract T u(T paramT1, T paramT2);
  
  public final boolean v(T paramT1, T paramT2)
  {
    return (this.hxF.aM(u(paramT1, paramT2))) || (this.hxG.v(paramT1, paramT2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */