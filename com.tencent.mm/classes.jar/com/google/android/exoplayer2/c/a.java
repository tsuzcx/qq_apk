package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements l
{
  private final long cHg;
  public final int[] cLg;
  public final long[] cLh;
  public final long[] cLi;
  public final int length;
  public final long[] offsets;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    AppMethodBeat.i(91954);
    this.cLg = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.cLh = paramArrayOfLong2;
    this.cLi = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.cHg = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      AppMethodBeat.o(91954);
      return;
    }
    this.cHg = 0L;
    AppMethodBeat.o(91954);
  }
  
  public final boolean RR()
  {
    return true;
  }
  
  public final long cc(long paramLong)
  {
    AppMethodBeat.i(91956);
    paramLong = this.offsets[com.google.android.exoplayer2.i.x.a(this.cLi, paramLong, true)];
    AppMethodBeat.o(91956);
    return paramLong;
  }
  
  public final long getDurationUs()
  {
    return this.cHg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.7.0.1
 */