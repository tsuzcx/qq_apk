package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class f
  implements d
{
  private final List<com.google.android.exoplayer2.f.a> aUg;
  
  public f(List<com.google.android.exoplayer2.f.a> paramList)
  {
    this.aUg = paramList;
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
    AppMethodBeat.i(95618);
    if (paramLong >= 0L)
    {
      localList = this.aUg;
      AppMethodBeat.o(95618);
      return localList;
    }
    List localList = Collections.emptyList();
    AppMethodBeat.o(95618);
    return localList;
  }
  
  public final long dT(int paramInt)
  {
    AppMethodBeat.i(95617);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      AppMethodBeat.o(95617);
      return 0L;
    }
  }
  
  public final int pH()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.f
 * JD-Core Version:    0.7.0.1
 */