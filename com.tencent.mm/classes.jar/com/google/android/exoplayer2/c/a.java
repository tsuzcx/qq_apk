package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements l
{
  private final long aSz;
  public final int[] aWC;
  public final long[] aWD;
  public final long[] aWE;
  public final int length;
  public final long[] offsets;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    AppMethodBeat.i(91954);
    this.aWC = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.aWD = paramArrayOfLong2;
    this.aWE = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.aSz = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      AppMethodBeat.o(91954);
      return;
    }
    this.aSz = 0L;
    AppMethodBeat.o(91954);
  }
  
  public final int J(long paramLong)
  {
    AppMethodBeat.i(91955);
    int i = x.a(this.aWE, paramLong, true);
    AppMethodBeat.o(91955);
    return i;
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(91956);
    paramLong = this.offsets[J(paramLong)];
    AppMethodBeat.o(91956);
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
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.7.0.1
 */