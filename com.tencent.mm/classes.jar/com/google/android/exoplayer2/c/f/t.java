package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  implements q
{
  private com.google.android.exoplayer2.c.m aCe;
  private u aGN;
  private boolean aLX;
  
  public final void a(u paramu, g paramg, v.d paramd)
  {
    AppMethodBeat.i(95163);
    this.aGN = paramu;
    paramd.ox();
    this.aCe = paramg.dm(paramd.oy());
    this.aCe.f(Format.k(paramd.oz(), "application/x-scte35"));
    AppMethodBeat.o(95163);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(95164);
    if (!this.aLX)
    {
      if (this.aGN.rb() == -9223372036854775807L)
      {
        AppMethodBeat.o(95164);
        return;
      }
      this.aCe.f(Format.c("application/x-scte35", this.aGN.rb()));
      this.aLX = true;
    }
    int i = paramm.qM();
    this.aCe.a(paramm, i);
    paramm = this.aCe;
    u localu = this.aGN;
    if (localu.bbs != -9223372036854775807L) {
      l = localu.bbs;
    }
    for (;;)
    {
      paramm.a(l, 1, i, 0, null);
      AppMethodBeat.o(95164);
      return;
      if (localu.aJP != 9223372036854775807L) {
        l = localu.aJP;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.t
 * JD-Core Version:    0.7.0.1
 */