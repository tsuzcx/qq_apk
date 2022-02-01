package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m aYi;
  private u bcR;
  private boolean bic;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92285);
    this.bcR = paramu;
    paramd.ts();
    this.aYi = paramg.dW(paramd.getTrackId());
    this.aYi.f(Format.k(paramd.tt(), "application/x-scte35"));
    AppMethodBeat.o(92285);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(92286);
    if (!this.bic)
    {
      if (this.bcR.vN() == -9223372036854775807L)
      {
        AppMethodBeat.o(92286);
        return;
      }
      this.aYi.f(Format.c("application/x-scte35", this.bcR.vN()));
      this.bic = true;
    }
    int i = paramm.vy();
    this.aYi.a(paramm, i);
    paramm = this.aYi;
    u localu = this.bcR;
    if (localu.bxb != -9223372036854775807L) {
      l = localu.bxb;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(92286);
      return;
      if (localu.bfV != 9223372036854775807L) {
        l = localu.bfV;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.t
 * JD-Core Version:    0.7.0.1
 */