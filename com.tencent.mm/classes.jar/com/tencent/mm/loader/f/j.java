package com.tencent.mm.loader.f;

import kotlin.g.b.s;

public final class j
  implements Runnable
{
  private c nrM;
  private a nrN;
  private b nre;
  
  public j(c paramc, b paramb, a parama)
  {
    this.nrM = paramc;
    this.nre = paramb;
    this.nrN = parama;
  }
  
  public final void run()
  {
    c localc = this.nrM;
    b localb = this.nre;
    a locala = this.nrN;
    s.u(localb, "loader");
    s.u(locala, "watch");
    localc.nre = localb;
    localc.nrf = locala;
    localc.call();
  }
  
  public static abstract interface a
  {
    public abstract void onTaskStatusCallback(c paramc, i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.j
 * JD-Core Version:    0.7.0.1
 */