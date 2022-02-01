package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m biD;
  private u bnm;
  private boolean bsw;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92285);
    this.bnm = paramu;
    paramd.uR();
    this.biD = paramg.eb(paramd.getTrackId());
    this.biD.f(Format.k(paramd.uS(), "application/x-scte35"));
    AppMethodBeat.o(92285);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(92286);
    if (!this.bsw)
    {
      if (this.bnm.xk() == -9223372036854775807L)
      {
        AppMethodBeat.o(92286);
        return;
      }
      this.biD.f(Format.c("application/x-scte35", this.bnm.xk()));
      this.bsw = true;
    }
    int i = paramm.wV();
    this.biD.a(paramm, i);
    paramm = this.biD;
    u localu = this.bnm;
    if (localu.bHp != -9223372036854775807L) {
      l = localu.bHp;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(92286);
      return;
      if (localu.bqp != 9223372036854775807L) {
        l = localu.bqp;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.t
 * JD-Core Version:    0.7.0.1
 */