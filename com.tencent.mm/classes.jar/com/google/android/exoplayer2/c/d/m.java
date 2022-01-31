package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
{
  public final int[] aBk;
  public final int aGC;
  public final int[] aGE;
  public final long[] aIw;
  public final long[] offsets;
  public final int sampleCount;
  
  public m(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(95016);
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
      this.aBk = paramArrayOfInt1;
      this.aGC = paramInt;
      this.aIw = paramArrayOfLong2;
      this.aGE = paramArrayOfInt2;
      this.sampleCount = paramArrayOfLong1.length;
      AppMethodBeat.o(95016);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label39;
    }
  }
  
  public final int I(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = x.a(this.aIw, paramLong, false);
    while (i >= 0)
    {
      if ((this.aGE[i] & 0x1) != 0)
      {
        AppMethodBeat.o(95017);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(95017);
    return -1;
  }
  
  public final int J(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = x.a(this.aIw, paramLong, true, false);
    while (i < this.aIw.length)
    {
      if ((this.aGE[i] & 0x1) != 0)
      {
        AppMethodBeat.o(95018);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(95018);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.m
 * JD-Core Version:    0.7.0.1
 */