package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long[] aBm;
  private final long[] aEk;
  private final long axh;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.aBm = paramArrayOfLong1;
    this.aEk = paramArrayOfLong2;
    this.axh = paramLong;
  }
  
  public final long E(long paramLong)
  {
    AppMethodBeat.i(94931);
    paramLong = this.aEk[com.google.android.exoplayer2.i.x.a(this.aBm, paramLong, true)];
    AppMethodBeat.o(94931);
    return paramLong;
  }
  
  public final long G(long paramLong)
  {
    AppMethodBeat.i(94932);
    paramLong = this.aBm[com.google.android.exoplayer2.i.x.a(this.aEk, paramLong, true)];
    AppMethodBeat.o(94932);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.axh;
  }
  
  public final boolean nV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */