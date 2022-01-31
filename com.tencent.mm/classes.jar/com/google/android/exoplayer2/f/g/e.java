package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.f.a;

final class e
  extends a
{
  public final long endTime;
  public final long startTime;
  
  public e(long paramLong1, long paramLong2, CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3);
    this.startTime = paramLong1;
    this.endTime = paramLong2;
  }
  
  public e(CharSequence paramCharSequence)
  {
    this(paramCharSequence, (byte)0);
  }
  
  private e(CharSequence paramCharSequence, byte paramByte)
  {
    this(0L, 0L, paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.e
 * JD-Core Version:    0.7.0.1
 */