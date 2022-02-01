package com.tencent.mm.loader.g;

import d.g.b.k;

public final class i
  implements Runnable
{
  private c gLT;
  private a gLU;
  private b gLv;
  
  public i(c paramc, b paramb, a parama)
  {
    this.gLT = paramc;
    this.gLv = paramb;
    this.gLU = parama;
  }
  
  public final void run()
  {
    c localc = this.gLT;
    b localb = this.gLv;
    a locala = this.gLU;
    k.h(localb, "loader");
    k.h(locala, "watch");
    localc.gLv = localb;
    localc.gLw = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */