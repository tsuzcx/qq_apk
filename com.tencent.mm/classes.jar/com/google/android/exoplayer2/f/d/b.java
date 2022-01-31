package com.google.android.exoplayer2.f.d;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.google.android.exoplayer2.f.a[] aWg;
  private final long[] aWh;
  
  public b(com.google.android.exoplayer2.f.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.aWg = paramArrayOfa;
    this.aWh = paramArrayOfLong;
  }
  
  public final int ab(long paramLong)
  {
    AppMethodBeat.i(95651);
    int i = x.a(this.aWh, paramLong, false, false);
    if (i < this.aWh.length)
    {
      AppMethodBeat.o(95651);
      return i;
    }
    AppMethodBeat.o(95651);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> ac(long paramLong)
  {
    AppMethodBeat.i(95653);
    int i = x.a(this.aWh, paramLong, false);
    if ((i == -1) || (this.aWg[i] == null))
    {
      localList = Collections.emptyList();
      AppMethodBeat.o(95653);
      return localList;
    }
    List localList = Collections.singletonList(this.aWg[i]);
    AppMethodBeat.o(95653);
    return localList;
  }
  
  public final long dT(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(95652);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.aWh.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.aWh[paramInt];
      AppMethodBeat.o(95652);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int pH()
  {
    return this.aWh.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.f.d.b
 * JD-Core Version:    0.7.0.1
 */