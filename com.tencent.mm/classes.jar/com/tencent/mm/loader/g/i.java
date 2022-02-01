package com.tencent.mm.loader.g;

import d.g.b.k;

public final class i
  implements Runnable
{
  private b gkI;
  private c glg;
  private a glh;
  
  public i(c paramc, b paramb, a parama)
  {
    this.glg = paramc;
    this.gkI = paramb;
    this.glh = parama;
  }
  
  public final void run()
  {
    c localc = this.glg;
    b localb = this.gkI;
    a locala = this.glh;
    k.h(localb, "loader");
    k.h(locala, "watch");
    localc.gkI = localb;
    localc.gkJ = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */