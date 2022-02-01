package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  implements n
{
  final n cFa;
  private final j cGp;
  private final long cYO;
  private final long cYP;
  boolean cYS;
  boolean cYT;
  
  public d$a(j paramj, n paramn, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.cGp = paramj;
    this.cFa = paramn;
    this.cYO = paramLong1;
    this.cYP = paramLong2;
    this.cYS = paramBoolean;
  }
  
  public final void ST()
  {
    AppMethodBeat.i(92612);
    this.cFa.ST();
    AppMethodBeat.o(92612);
  }
  
  public final int b(k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(92613);
    if (this.cYS)
    {
      AppMethodBeat.o(92613);
      return -3;
    }
    if (this.cYT)
    {
      parame.flags = 4;
      AppMethodBeat.o(92613);
      return -4;
    }
    int i = this.cFa.b(paramk, parame, paramBoolean);
    if ((this.cYP != -9223372036854775808L) && (((i == -4) && (parame.timeUs >= this.cYP)) || ((i == -3) && (this.cGp.SR() == -9223372036854775808L))))
    {
      parame.clear();
      parame.flags = 4;
      this.cYT = true;
      AppMethodBeat.o(92613);
      return -4;
    }
    if ((i == -4) && (!parame.Ry())) {
      parame.timeUs -= this.cYO;
    }
    AppMethodBeat.o(92613);
    return i;
  }
  
  public final void cp(long paramLong)
  {
    AppMethodBeat.i(92614);
    this.cFa.cp(this.cYO + paramLong);
    AppMethodBeat.o(92614);
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(92611);
    boolean bool = this.cFa.isReady();
    AppMethodBeat.o(92611);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d.a
 * JD-Core Version:    0.7.0.1
 */