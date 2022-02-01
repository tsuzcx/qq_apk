package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  a gEB = null;
  h<T, V> gEW;
  b<T, V> gEX = null;
  f.b<T, V> gEY;
  f.c<T, V> gEZ;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.gEB = parama;
    this.gEY = paramb;
    this.gEZ = paramc;
    this.gEW = new h(this.gEB.gEG, new f.b()new f.c {}, new f.c() {});
    this.gEX = new b(this.gEB, new b.a()new b.b {}, new b.b() {});
  }
  
  public final void adg()
  {
    ad.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.gEB.gEG) });
    this.gEW.setMaxSize(this.gEB.gEG);
  }
  
  public final void apr()
  {
    ad.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.gEB.gEG), Integer.valueOf((int)(this.gEB.gEG * 2.0D)) });
    this.gEW.setMaxSize((int)(this.gEB.gEG * 2.0D));
  }
  
  protected abstract T s(T paramT1, T paramT2);
  
  public final int size()
  {
    return this.gEW.size();
  }
  
  public final boolean t(T paramT1, T paramT2)
  {
    return (this.gEW.aN(s(paramT1, paramT2))) || (this.gEX.t(paramT1, paramT2));
  }
  
  public final void trimToSize(int paramInt)
  {
    this.gEW.trimToSize(paramInt);
  }
  
  public final boolean y(T paramT1, T paramT2)
  {
    boolean bool1 = this.gEW.aO(s(paramT1, paramT2));
    boolean bool2 = this.gEX.bS(paramT1).aO(paramT2);
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */