package com.tencent.mm.loader.g;

import kotlin.g.b.p;

public final class k
  implements Runnable
{
  private b kPB;
  private c kQj;
  private a kQk;
  
  public k(c paramc, b paramb, a parama)
  {
    this.kQj = paramc;
    this.kPB = paramb;
    this.kQk = parama;
  }
  
  public final void run()
  {
    c localc = this.kQj;
    b localb = this.kPB;
    a locala = this.kQk;
    p.k(localb, "loader");
    p.k(locala, "watch");
    localc.kPB = localb;
    localc.kPC = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.k
 * JD-Core Version:    0.7.0.1
 */