package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long bdJ;
  private final long[] bhI;
  private final long[] bkE;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.bhI = paramArrayOfLong1;
    this.bkE = paramArrayOfLong2;
    this.bdJ = paramLong;
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92046);
    paramLong = this.bkE[com.google.android.exoplayer2.i.x.a(this.bhI, paramLong, true)];
    AppMethodBeat.o(92046);
    return paramLong;
  }
  
  public final long N(long paramLong)
  {
    AppMethodBeat.i(92047);
    paramLong = this.bhI[com.google.android.exoplayer2.i.x.a(this.bkE, paramLong, true)];
    AppMethodBeat.o(92047);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.bdJ;
  }
  
  public final boolean uu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */