package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m biA;
  private u bnh;
  private boolean bsr;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92285);
    this.bnh = paramu;
    paramd.uW();
    this.biA = paramg.dV(paramd.getTrackId());
    this.biA.f(Format.k(paramd.uX(), "application/x-scte35"));
    AppMethodBeat.o(92285);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(92286);
    if (!this.bsr)
    {
      if (this.bnh.xs() == -9223372036854775807L)
      {
        AppMethodBeat.o(92286);
        return;
      }
      this.biA.f(Format.d("application/x-scte35", this.bnh.xs()));
      this.bsr = true;
    }
    int i = paramm.xd();
    this.biA.a(paramm, i);
    paramm = this.biA;
    u localu = this.bnh;
    if (localu.bHG != -9223372036854775807L) {
      l = localu.bHG;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(92286);
      return;
      if (localu.bqk != 9223372036854775807L) {
        l = localu.bqk;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.t
 * JD-Core Version:    0.7.0.1
 */