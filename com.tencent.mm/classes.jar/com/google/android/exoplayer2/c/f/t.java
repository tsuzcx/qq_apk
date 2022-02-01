package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m aSe;
  private u aWJ;
  private boolean bbT;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92285);
    this.aWJ = paramu;
    paramd.sR();
    this.aSe = paramg.ej(paramd.getTrackId());
    this.aSe.f(Format.l(paramd.sS(), "application/x-scte35"));
    AppMethodBeat.o(92285);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(92286);
    if (!this.bbT)
    {
      if (this.aWJ.vv() == -9223372036854775807L)
      {
        AppMethodBeat.o(92286);
        return;
      }
      this.aSe.f(Format.d("application/x-scte35", this.aWJ.vv()));
      this.bbT = true;
    }
    int i = paramm.vg();
    this.aSe.a(paramm, i);
    paramm = this.aSe;
    u localu = this.aWJ;
    if (localu.brn != -9223372036854775807L) {
      l = localu.brn;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(92286);
      return;
      if (localu.aZM != 9223372036854775807L) {
        l = localu.aZM;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.t
 * JD-Core Version:    0.7.0.1
 */