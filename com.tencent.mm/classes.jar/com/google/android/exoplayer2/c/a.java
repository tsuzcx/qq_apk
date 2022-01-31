package com.google.android.exoplayer2.c;

public final class a
  implements j
{
  private final long auP;
  public final int[] ayV;
  public final long[] ayW;
  public final long[] ayX;
  public final int length;
  public final long[] offsets;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.ayV = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.ayW = paramArrayOfLong2;
    this.ayX = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.auP = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      return;
    }
    this.auP = 0L;
  }
  
  public final boolean lS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a
 * JD-Core Version:    0.7.0.1
 */