package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class c
  implements d
{
  private final List<com.google.android.exoplayer2.f.a> aUg;
  
  public c(List<com.google.android.exoplayer2.f.a> paramList)
  {
    AppMethodBeat.i(95720);
    this.aUg = Collections.unmodifiableList(paramList);
    AppMethodBeat.o(95720);
  }
  
  public final int ab(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> ac(long paramLong)
  {
    AppMethodBeat.i(95722);
    if (paramLong >= 0L)
    {
      localList = this.aUg;
      AppMethodBeat.o(95722);
      return localList;
    }
    List localList = Collections.emptyList();
    AppMethodBeat.o(95722);
    return localList;
  }
  
  public final long dT(int paramInt)
  {
    AppMethodBeat.i(95721);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      AppMethodBeat.o(95721);
      return 0L;
    }
  }
  
  public final int pH()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.c
 * JD-Core Version:    0.7.0.1
 */