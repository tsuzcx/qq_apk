package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
{
  public final int[] cLg;
  public final int cQu;
  public final int[] cQw;
  public final long[] cSo;
  public final long[] offsets;
  public final int sampleCount;
  
  public m(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(92132);
    if (paramArrayOfInt1.length == paramArrayOfLong2.length)
    {
      bool1 = true;
      a.checkArgument(bool1);
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        break label107;
      }
      bool1 = true;
      label39:
      a.checkArgument(bool1);
      if (paramArrayOfInt2.length != paramArrayOfLong2.length) {
        break label113;
      }
    }
    label107:
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a.checkArgument(bool1);
      this.offsets = paramArrayOfLong1;
      this.cLg = paramArrayOfInt1;
      this.cQu = paramInt;
      this.cSo = paramArrayOfLong2;
      this.cQw = paramArrayOfInt2;
      this.sampleCount = paramArrayOfLong1.length;
      AppMethodBeat.o(92132);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label39;
    }
  }
  
  public final int cg(long paramLong)
  {
    AppMethodBeat.i(92133);
    int i = x.a(this.cSo, paramLong, false);
    while (i >= 0)
    {
      if ((this.cQw[i] & 0x1) != 0)
      {
        AppMethodBeat.o(92133);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(92133);
    return -1;
  }
  
  public final int ch(long paramLong)
  {
    AppMethodBeat.i(92134);
    int i = x.a(this.cSo, paramLong, true, false);
    while (i < this.cSo.length)
    {
      if ((this.cQw[i] & 0x1) != 0)
      {
        AppMethodBeat.o(92134);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(92134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.m
 * JD-Core Version:    0.7.0.1
 */