package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  implements d.b
{
  final l[] bkV;
  private final int[] bmk;
  
  public b(int[] paramArrayOfInt, l[] paramArrayOfl)
  {
    this.bmk = paramArrayOfInt;
    this.bkV = paramArrayOfl;
  }
  
  public final void ae(long paramLong)
  {
    l[] arrayOfl = this.bkV;
    int j = arrayOfl.length;
    int i = 0;
    while (i < j)
    {
      l locall = arrayOfl[i];
      if ((locall != null) && (locall.blV != paramLong))
      {
        locall.blV = paramLong;
        locall.blT = true;
      }
      i += 1;
    }
  }
  
  public final m eF(int paramInt)
  {
    AppMethodBeat.i(92578);
    int i = 0;
    while (i < this.bmk.length)
    {
      if (paramInt == this.bmk[i])
      {
        localObject = this.bkV[i];
        AppMethodBeat.o(92578);
        return localObject;
      }
      i += 1;
    }
    Object localObject = new d();
    AppMethodBeat.o(92578);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.b
 * JD-Core Version:    0.7.0.1
 */