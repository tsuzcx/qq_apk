package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements l
{
  private final long bdM;
  public final int[] bhJ;
  public final long[] bhK;
  public final long[] bhL;
  public final int length;
  public final long[] offsets;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    AppMethodBeat.i(91954);
    this.bhJ = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.bhK = paramArrayOfLong2;
    this.bhL = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.bdM = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      AppMethodBeat.o(91954);
      return;
    }
    this.bdM = 0L;
    AppMethodBeat.o(91954);
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(91956);
    paramLong = this.offsets[com.google.android.exoplayer2.i.x.a(this.bhL, paramLong, true)];
    AppMethodBeat.o(91956);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.7.0.1
 */