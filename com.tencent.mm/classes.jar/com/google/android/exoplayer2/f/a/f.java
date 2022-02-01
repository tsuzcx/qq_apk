package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class f
  implements d
{
  private final List<com.google.android.exoplayer2.f.a> deb;
  
  public f(List<com.google.android.exoplayer2.f.a> paramList)
  {
    this.deb = paramList;
  }
  
  public final int TD()
  {
    return 1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> cA(long paramLong)
  {
    AppMethodBeat.i(92786);
    if (paramLong >= 0L)
    {
      localList = this.deb;
      AppMethodBeat.o(92786);
      return localList;
    }
    List localList = Collections.emptyList();
    AppMethodBeat.o(92786);
    return localList;
  }
  
  public final int cz(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return -1;
  }
  
  public final long in(int paramInt)
  {
    AppMethodBeat.i(92785);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      AppMethodBeat.o(92785);
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.f
 * JD-Core Version:    0.7.0.1
 */