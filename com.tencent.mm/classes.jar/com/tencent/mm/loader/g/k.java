package com.tencent.mm.loader.g;

import d.g.b.p;

public final class k
  implements Runnable
{
  private c hfQ;
  private a hfR;
  private b hfk;
  
  public k(c paramc, b paramb, a parama)
  {
    this.hfQ = paramc;
    this.hfk = paramb;
    this.hfR = parama;
  }
  
  public final void run()
  {
    c localc = this.hfQ;
    b localb = this.hfk;
    a locala = this.hfR;
    p.h(localb, "loader");
    p.h(locala, "watch");
    localc.hfk = localb;
    localc.hfl = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.k
 * JD-Core Version:    0.7.0.1
 */