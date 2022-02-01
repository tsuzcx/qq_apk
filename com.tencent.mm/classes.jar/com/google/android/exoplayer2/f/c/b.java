package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.google.android.exoplayer2.f.a[] bmf;
  private final long[] bmg;
  
  public b(com.google.android.exoplayer2.f.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.bmf = paramArrayOfa;
    this.bmg = paramArrayOfLong;
  }
  
  public final int al(long paramLong)
  {
    AppMethodBeat.i(92811);
    int i = x.a(this.bmg, paramLong, false, false);
    if (i < this.bmg.length)
    {
      AppMethodBeat.o(92811);
      return i;
    }
    AppMethodBeat.o(92811);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> am(long paramLong)
  {
    AppMethodBeat.i(92813);
    int i = x.a(this.bmg, paramLong, false);
    if ((i == -1) || (this.bmf[i] == null))
    {
      localList = Collections.emptyList();
      AppMethodBeat.o(92813);
      return localList;
    }
    List localList = Collections.singletonList(this.bmf[i]);
    AppMethodBeat.o(92813);
    return localList;
  }
  
  public final long eX(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92812);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.bmg.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.bmg[paramInt];
      AppMethodBeat.o(92812);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int ua()
  {
    return this.bmg.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c.b
 * JD-Core Version:    0.7.0.1
 */