package com.tencent.mm.loader.g;

import kotlin.g.b.p;

public final class k
  implements Runnable
{
  private b iaV;
  private c ibC;
  private a ibD;
  
  public k(c paramc, b paramb, a parama)
  {
    this.ibC = paramc;
    this.iaV = paramb;
    this.ibD = parama;
  }
  
  public final void run()
  {
    c localc = this.ibC;
    b localb = this.iaV;
    a locala = this.ibD;
    p.h(localb, "loader");
    p.h(locala, "watch");
    localc.iaV = localb;
    localc.iaW = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.g.k
 * JD-Core Version:    0.7.0.1
 */