package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long aTs;
  private final long[] aXq;
  private final long[] bao;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.aXq = paramArrayOfLong1;
    this.bao = paramArrayOfLong2;
    this.aTs = paramLong;
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92046);
    paramLong = this.bao[com.google.android.exoplayer2.i.x.a(this.aXq, paramLong, true)];
    AppMethodBeat.o(92046);
    return paramLong;
  }
  
  public final long N(long paramLong)
  {
    AppMethodBeat.i(92047);
    paramLong = this.aXq[com.google.android.exoplayer2.i.x.a(this.bao, paramLong, true)];
    AppMethodBeat.o(92047);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.aTs;
  }
  
  public final boolean sQ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */