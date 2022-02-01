package com.tencent.mm.loader.g;

import d.g.b.p;

public final class k
  implements Runnable
{
  private b hhY;
  private c hiE;
  private a hiF;
  
  public k(c paramc, b paramb, a parama)
  {
    this.hiE = paramc;
    this.hhY = paramb;
    this.hiF = parama;
  }
  
  public final void run()
  {
    c localc = this.hiE;
    b localb = this.hhY;
    a locala = this.hiF;
    p.h(localb, "loader");
    p.h(locala, "watch");
    localc.hhY = localb;
    localc.hhZ = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.k
 * JD-Core Version:    0.7.0.1
 */