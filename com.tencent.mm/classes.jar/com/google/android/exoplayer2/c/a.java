package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements l
{
  public final int[] aBk;
  public final long[] aBl;
  public final long[] aBm;
  private final long axh;
  public final int length;
  public final long[] offsets;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    AppMethodBeat.i(94840);
    this.aBk = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.aBl = paramArrayOfLong2;
    this.aBm = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.axh = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      AppMethodBeat.o(94840);
      return;
    }
    this.axh = 0L;
    AppMethodBeat.o(94840);
  }
  
  public final long E(long paramLong)
  {
    AppMethodBeat.i(94841);
    paramLong = this.offsets[com.google.android.exoplayer2.i.x.a(this.aBm, paramLong, true)];
    AppMethodBeat.o(94841);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.7.0.1
 */