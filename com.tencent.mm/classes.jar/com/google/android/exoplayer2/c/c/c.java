package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long aSz;
  private final long[] aWE;
  private final long[] aZC;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.aWE = paramArrayOfLong1;
    this.aZC = paramArrayOfLong2;
    this.aSz = paramLong;
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(92046);
    paramLong = this.aZC[com.google.android.exoplayer2.i.x.a(this.aWE, paramLong, true)];
    AppMethodBeat.o(92046);
    return paramLong;
  }
  
  public final long M(long paramLong)
  {
    AppMethodBeat.i(92047);
    paramLong = this.aWE[com.google.android.exoplayer2.i.x.a(this.aZC, paramLong, true)];
    AppMethodBeat.o(92047);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.aSz;
  }
  
  public final boolean sH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */