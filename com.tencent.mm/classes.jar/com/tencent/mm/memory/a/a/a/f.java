package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  f.c<T, V> hfA;
  a hfc = null;
  h<T, V> hfx;
  b<T, V> hfy = null;
  f.b<T, V> hfz;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.hfc = parama;
    this.hfz = paramb;
    this.hfA = paramc;
    this.hfx = new h(this.hfc.hfh, new f.b()new f.c {}, new f.c() {});
    this.hfy = new b(this.hfc, new b.a()new b.b {}, new b.b() {});
  }
  
  public final void aew()
  {
    ac.i("MicroMsg.UsageLruMap", "resetSize %s", new Object[] { Integer.valueOf(this.hfc.hfh) });
    this.hfx.setMaxSize(this.hfc.hfh);
  }
  
  public final void awi()
  {
    ac.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", new Object[] { Double.valueOf(1.0D), Integer.valueOf(this.hfc.hfh), Integer.valueOf((int)(this.hfc.hfh * 2.0D)) });
    this.hfx.setMaxSize((int)(this.hfc.hfh * 2.0D));
  }
  
  protected abstract T s(T paramT1, T paramT2);
  
  public final int size()
  {
    return this.hfx.size();
  }
  
  public final boolean t(T paramT1, T paramT2)
  {
    return (this.hfx.aK(s(paramT1, paramT2))) || (this.hfy.t(paramT1, paramT2));
  }
  
  public final void trimToSize(int paramInt)
  {
    this.hfx.trimToSize(paramInt);
  }
  
  public final boolean y(T paramT1, T paramT2)
  {
    boolean bool1 = this.hfx.aL(s(paramT1, paramT2));
    boolean bool2 = this.hfy.bQ(paramT1).aL(paramT2);
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */