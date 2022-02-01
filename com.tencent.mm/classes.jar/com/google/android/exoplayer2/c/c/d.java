package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
  implements b.a
{
  private final long aNk;
  private final long aUh;
  private final long[] aUi;
  private final long aUj;
  private final int aUk;
  private final long firstFramePosition;
  
  d(long paramLong1, long paramLong2, long paramLong3)
  {
    this(paramLong1, paramLong2, paramLong3, null, 0L, 0);
  }
  
  d(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, long paramLong4, int paramInt)
  {
    this.firstFramePosition = paramLong1;
    this.aNk = paramLong2;
    this.aUh = paramLong3;
    this.aUi = paramArrayOfLong;
    this.aUj = paramLong4;
    this.aUk = paramInt;
  }
  
  private long ep(int paramInt)
  {
    return this.aNk * paramInt / 100L;
  }
  
  public final long O(long paramLong)
  {
    float f2 = 256.0F;
    float f3 = 0.0F;
    AppMethodBeat.i(92048);
    if (!so())
    {
      paramLong = this.firstFramePosition;
      AppMethodBeat.o(92048);
      return paramLong;
    }
    float f4 = (float)paramLong * 100.0F / (float)this.aNk;
    float f1;
    long l1;
    long l2;
    if (f4 <= 0.0F)
    {
      f1 = 0.0F;
      l1 = Math.round(f1 * 0.00390625D * this.aUj);
      l2 = this.firstFramePosition;
      if (this.aUh == -1L) {
        break label183;
      }
    }
    label183:
    for (paramLong = this.aUh - 1L;; paramLong = this.firstFramePosition - this.aUk + this.aUj - 1L)
    {
      paramLong = Math.min(l2 + l1, paramLong);
      AppMethodBeat.o(92048);
      return paramLong;
      f1 = f2;
      if (f4 >= 100.0F) {
        break;
      }
      int i = (int)f4;
      if (i == 0) {}
      for (f1 = f3;; f1 = (float)this.aUi[(i - 1)])
      {
        if (i < 99) {
          f2 = (float)this.aUi[i];
        }
        f1 = (f2 - f1) * (f4 - i) + f1;
        break;
      }
    }
  }
  
  public final long Q(long paramLong)
  {
    AppMethodBeat.i(92049);
    if ((!so()) || (paramLong < this.firstFramePosition))
    {
      AppMethodBeat.o(92049);
      return 0L;
    }
    double d1 = 256.0D * (paramLong - this.firstFramePosition) / this.aUj;
    int i = x.a(this.aUi, d1, false) + 1;
    long l2 = ep(i);
    long l1;
    label87:
    long l3;
    if (i == 0)
    {
      paramLong = 0L;
      if (i != 99) {
        break label129;
      }
      l1 = 256L;
      l3 = ep(i + 1);
      if (l1 != paramLong) {
        break label141;
      }
    }
    label129:
    label141:
    double d2;
    for (paramLong = 0L;; paramLong = ((d1 - paramLong) * d2 / (l1 - paramLong)))
    {
      AppMethodBeat.o(92049);
      return paramLong + l2;
      paramLong = this.aUi[(i - 1)];
      break;
      l1 = this.aUi[i];
      break label87;
      d2 = l3 - l2;
    }
  }
  
  public final long getDurationUs()
  {
    return this.aNk;
  }
  
  public final boolean so()
  {
    return this.aUi != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.d
 * JD-Core Version:    0.7.0.1
 */