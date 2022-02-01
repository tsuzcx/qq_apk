package com.google.android.exoplayer2.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements b.a
{
  private final long cHg;
  private final long[] cLi;
  private final long[] cOc;
  
  c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.cLi = paramArrayOfLong1;
    this.cOc = paramArrayOfLong2;
    this.cHg = paramLong;
  }
  
  public final boolean RR()
  {
    return true;
  }
  
  public final long cc(long paramLong)
  {
    AppMethodBeat.i(92046);
    paramLong = this.cOc[com.google.android.exoplayer2.i.x.a(this.cLi, paramLong, true)];
    AppMethodBeat.o(92046);
    return paramLong;
  }
  
  public final long ce(long paramLong)
  {
    AppMethodBeat.i(92047);
    paramLong = this.cLi[com.google.android.exoplayer2.i.x.a(this.cOc, paramLong, true)];
    AppMethodBeat.o(92047);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.cHg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */