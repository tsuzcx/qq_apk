package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  h<T, V> hAt;
  b<T, V> hAu = null;
  f.b<T, V> hAv;
  f.c<T, V> hAw;
  a hzY = null;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.hzY = parama;
    this.hAv = paramb;
    this.hAw = paramc;
    this.hAt = new h(this.hzY.hAd, new f.b()new f.c {}, new f.c() {});
    this.hAu = new b(this.hzY, new b.a()new b.b {}, new b.b() {});
  }
  
  public final boolean A(T paramT1, T paramT2)
  {
    boolean bool1 = this.hAt.aN(u(paramT1, paramT2));
    boolean bool2 = this.hAu.bS(paramT1).aN(paramT2);
    return (bool1) || (bool2);
  }
  
  public final void ahx()
  {
    ae.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.hzY.hAd) });
    this.hAt.setMaxSize(this.hzY.hAd);
  }
  
  public final void azk()
  {
    ae.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.hzY.hAd), Integer.valueOf((int)(this.hzY.hAd * 2.0D)) });
    this.hAt.setMaxSize((int)(this.hzY.hAd * 2.0D));
  }
  
  public final int size()
  {
    return this.hAt.size();
  }
  
  public final void trimToSize(int paramInt)
  {
    this.hAt.trimToSize(paramInt);
  }
  
  protected abstract T u(T paramT1, T paramT2);
  
  public final boolean v(T paramT1, T paramT2)
  {
    return (this.hAt.aM(u(paramT1, paramT2))) || (this.hAu.v(paramT1, paramT2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */