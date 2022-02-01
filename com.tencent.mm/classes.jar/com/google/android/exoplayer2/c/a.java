package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements l
{
  private final long bdJ;
  public final int[] bhG;
  public final long[] bhH;
  public final long[] bhI;
  public final int length;
  public final long[] offsets;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    AppMethodBeat.i(91954);
    this.bhG = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.bhH = paramArrayOfLong2;
    this.bhI = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.bdJ = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      AppMethodBeat.o(91954);
      return;
    }
    this.bdJ = 0L;
    AppMethodBeat.o(91954);
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(91956);
    paramLong = this.offsets[com.google.android.exoplayer2.i.x.a(this.bhI, paramLong, true)];
    AppMethodBeat.o(91956);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.7.0.1
 */