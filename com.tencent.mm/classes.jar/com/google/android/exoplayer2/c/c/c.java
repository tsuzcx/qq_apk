package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long bdM;
  private final long[] bhL;
  private final long[] bkJ;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.bhL = paramArrayOfLong1;
    this.bkJ = paramArrayOfLong2;
    this.bdM = paramLong;
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92046);
    paramLong = this.bkJ[com.google.android.exoplayer2.i.x.a(this.bhL, paramLong, true)];
    AppMethodBeat.o(92046);
    return paramLong;
  }
  
  public final long N(long paramLong)
  {
    AppMethodBeat.i(92047);
    paramLong = this.bhL[com.google.android.exoplayer2.i.x.a(this.bkJ, paramLong, true)];
    AppMethodBeat.o(92047);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.bdM;
  }
  
  public final boolean up()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */