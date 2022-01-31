package com.tencent.mm.loader.g;

import a.f.b.j;

public final class i
  implements Runnable
{
  private c ePB;
  private i.a ePC;
  private b ePd;
  
  public i(c paramc, b paramb, i.a parama)
  {
    this.ePB = paramc;
    this.ePd = paramb;
    this.ePC = parama;
  }
  
  public final void run()
  {
    c localc = this.ePB;
    b localb = this.ePd;
    i.a locala = this.ePC;
    j.q(localb, "loader");
    j.q(locala, "watch");
    localc.ePd = localb;
    localc.ePe = locala;
    localc.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */