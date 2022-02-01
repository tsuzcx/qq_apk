package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m aXw;
  private u bcf;
  private boolean bhw;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(92285);
    this.bcf = paramu;
    paramd.tj();
    this.aXw = paramg.bh(paramd.getTrackId(), 4);
    this.aXw.f(Format.j(paramd.tl(), "application/x-scte35"));
    AppMethodBeat.o(92285);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(92286);
    if (!this.bhw)
    {
      if (this.bcf.vY() == -9223372036854775807L)
      {
        AppMethodBeat.o(92286);
        return;
      }
      this.aXw.f(Format.c("application/x-scte35", this.bcf.vY()));
      this.bhw = true;
    }
    int i = paramm.vJ();
    this.aXw.a(paramm, i);
    paramm = this.aXw;
    u localu = this.bcf;
    if (localu.bzt != -9223372036854775807L) {
      l = localu.bzt;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(92286);
      return;
      if (localu.bfn != 9223372036854775807L) {
        l = localu.bfn;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.t
 * JD-Core Version:    0.7.0.1
 */