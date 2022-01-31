package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class s
  implements p
{
  private q aBX;
  private k aCt;
  private boolean aFi;
  
  public final void a(q paramq, f paramf, u.d paramd)
  {
    this.aBX = paramq;
    paramd.mg();
    this.aCt = paramf.cQ(paramd.mh());
    this.aCt.f(Format.j(paramd.mi(), "application/x-scte35"));
  }
  
  public final void b(j paramj)
  {
    long l = -9223372036854775807L;
    if (!this.aFi)
    {
      if (this.aBX.op() == -9223372036854775807L) {
        return;
      }
      this.aCt.f(Format.b("application/x-scte35", this.aBX.op()));
      this.aFi = true;
    }
    int i = paramj.oe();
    this.aCt.a(paramj, i);
    paramj = this.aCt;
    q localq = this.aBX;
    if (localq.aSR != -9223372036854775807L) {
      l = localq.aSR;
    }
    for (;;)
    {
      paramj.a(l, 1, i, 0, null);
      return;
      if (localq.aDd != 9223372036854775807L) {
        l = localq.aDd;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.s
 * JD-Core Version:    0.7.0.1
 */