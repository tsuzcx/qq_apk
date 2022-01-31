package com.tencent.mm.memory.a.a.a;

import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.a.h;

public abstract class f<T, V extends c<T>>
  implements d<T, V>
{
  h<T, V> feM;
  b<T, V> feN = null;
  f.b<T, V> feO;
  f.c<T, V> feP;
  a feq = null;
  
  public f(a parama, f.b<T, V> paramb, f.c<T, V> paramc)
  {
    this.feq = parama;
    this.feO = paramb;
    this.feP = paramc;
    this.feM = new h(this.feq.fev, new f.b()new f.c {}, new f.c() {});
    this.feN = new b(this.feq, new b.a()new b.b {}, new b.b() {});
  }
  
  protected abstract T k(T paramT1, T paramT2);
  
  public final boolean l(T paramT1, T paramT2)
  {
    return (this.feM.Z(k(paramT1, paramT2))) || (this.feN.l(paramT1, paramT2));
  }
  
  public final boolean q(T paramT1, T paramT2)
  {
    boolean bool1 = this.feM.aa(k(paramT1, paramT2));
    boolean bool2 = this.feN.aN(paramT1).aa(paramT2);
    return (bool1) || (bool2);
  }
  
  public final int size()
  {
    return this.feM.size();
  }
  
  public final void trimToSize(int paramInt)
  {
    this.feM.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */