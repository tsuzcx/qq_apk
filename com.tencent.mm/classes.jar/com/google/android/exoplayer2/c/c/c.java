package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long aNk;
  private final long[] aRm;
  private final long[] aUg;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.aRm = paramArrayOfLong1;
    this.aUg = paramArrayOfLong2;
    this.aNk = paramLong;
  }
  
  public final long O(long paramLong)
  {
    AppMethodBeat.i(92046);
    paramLong = this.aUg[com.google.android.exoplayer2.i.x.a(this.aRm, paramLong, true)];
    AppMethodBeat.o(92046);
    return paramLong;
  }
  
  public final long Q(long paramLong)
  {
    AppMethodBeat.i(92047);
    paramLong = this.aRm[com.google.android.exoplayer2.i.x.a(this.aUg, paramLong, true)];
    AppMethodBeat.o(92047);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.aNk;
  }
  
  public final boolean so()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */