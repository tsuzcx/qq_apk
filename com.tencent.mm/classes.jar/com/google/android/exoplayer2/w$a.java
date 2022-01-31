package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w$a
{
  public int awC;
  public Object awo;
  public Object axK;
  public long axL;
  public long[] axM;
  public int[] axN;
  public int[] axO;
  public int[] axP;
  public long[][] axQ;
  public long axR;
  public long axh;
  
  public final boolean aT(int paramInt1, int paramInt2)
  {
    return paramInt2 < this.axO[paramInt1];
  }
  
  public final long aU(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.axQ[paramInt1].length) {
      return -9223372036854775807L;
    }
    return this.axQ[paramInt1][paramInt2];
  }
  
  public final boolean cY(int paramInt)
  {
    return (this.axN[paramInt] != -1) && (this.axP[paramInt] == this.axN[paramInt]);
  }
  
  public final int ng()
  {
    if (this.axM == null) {
      return 0;
    }
    return this.axM.length;
  }
  
  public final int x(long paramLong)
  {
    AppMethodBeat.i(95755);
    if (this.axM == null)
    {
      AppMethodBeat.o(95755);
      return -1;
    }
    int i = this.axM.length - 1;
    while ((i >= 0) && ((this.axM[i] == -9223372036854775808L) || (this.axM[i] > paramLong))) {
      i -= 1;
    }
    if ((i >= 0) && (!cY(i)))
    {
      AppMethodBeat.o(95755);
      return i;
    }
    AppMethodBeat.o(95755);
    return -1;
  }
  
  public final int y(long paramLong)
  {
    AppMethodBeat.i(95756);
    if (this.axM == null)
    {
      AppMethodBeat.o(95756);
      return -1;
    }
    int i = 0;
    while ((i < this.axM.length) && (this.axM[i] != -9223372036854775808L) && ((paramLong >= this.axM[i]) || (cY(i)))) {
      i += 1;
    }
    if (i < this.axM.length)
    {
      AppMethodBeat.o(95756);
      return i;
    }
    AppMethodBeat.o(95756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.w.a
 * JD-Core Version:    0.7.0.1
 */