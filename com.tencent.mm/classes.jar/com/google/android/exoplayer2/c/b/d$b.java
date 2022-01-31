package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.a;

final class d$b
{
  public final g aCs = new g();
  public final k aCt;
  public e aCu;
  public c aCv;
  public int aCw;
  public int aCx;
  public int aCy;
  
  public d$b(k paramk)
  {
    this.aCt = paramk;
  }
  
  public final void a(e parame, c paramc)
  {
    this.aCu = ((e)a.E(parame));
    this.aCv = ((c)a.E(paramc));
    this.aCt.f(parame.auL);
    reset();
  }
  
  public final void reset()
  {
    g localg = this.aCs;
    localg.aCO = 0;
    localg.aDb = 0L;
    localg.aCV = false;
    localg.aDa = false;
    localg.aCX = null;
    this.aCw = 0;
    this.aCy = 0;
    this.aCx = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.d.b
 * JD-Core Version:    0.7.0.1
 */