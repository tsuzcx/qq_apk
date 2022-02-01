package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m cMa;
  private u cQF;
  private boolean cVO;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92285);
    this.cQF = paramu;
    paramd.Sv();
    this.cMa = paramg.hz(paramd.getTrackId());
    this.cMa.f(Format.t(paramd.Sw(), "application/x-scte35"));
    AppMethodBeat.o(92285);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(92286);
    if (!this.cVO)
    {
      if (this.cQF.UU() == -9223372036854775807L)
      {
        AppMethodBeat.o(92286);
        return;
      }
      this.cMa.f(Format.d("application/x-scte35", this.cQF.UU()));
      this.cVO = true;
    }
    int i = paramm.UF();
    this.cMa.a(paramm, i);
    paramm = this.cMa;
    u localu = this.cQF;
    if (localu.dkR != -9223372036854775807L) {
      l = localu.dkR;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(92286);
      return;
      if (localu.cTH != 9223372036854775807L) {
        l = localu.cTH;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.t
 * JD-Core Version:    0.7.0.1
 */