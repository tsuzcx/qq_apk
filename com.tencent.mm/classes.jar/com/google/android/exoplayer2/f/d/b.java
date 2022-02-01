package com.google.android.exoplayer2.f.d;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.google.android.exoplayer2.f.a[] dga;
  private final long[] dgb;
  
  public b(com.google.android.exoplayer2.f.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.dga = paramArrayOfa;
    this.dgb = paramArrayOfLong;
  }
  
  public final int TD()
  {
    return this.dgb.length;
  }
  
  public final List<com.google.android.exoplayer2.f.a> cA(long paramLong)
  {
    AppMethodBeat.i(92821);
    int i = x.a(this.dgb, paramLong, false);
    if ((i == -1) || (this.dga[i] == null))
    {
      localList = Collections.emptyList();
      AppMethodBeat.o(92821);
      return localList;
    }
    List localList = Collections.singletonList(this.dga[i]);
    AppMethodBeat.o(92821);
    return localList;
  }
  
  public final int cz(long paramLong)
  {
    AppMethodBeat.i(92819);
    int i = x.a(this.dgb, paramLong, false, false);
    if (i < this.dgb.length)
    {
      AppMethodBeat.o(92819);
      return i;
    }
    AppMethodBeat.o(92819);
    return -1;
  }
  
  public final long in(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92820);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.dgb.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.dgb[paramInt];
      AppMethodBeat.o(92820);
      return l;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.d.b
 * JD-Core Version:    0.7.0.1
 */