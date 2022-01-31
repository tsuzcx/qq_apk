package com.google.android.exoplayer2.f.f;

import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  public static final b aWX;
  private final List<com.google.android.exoplayer2.f.a> aUg;
  
  static
  {
    AppMethodBeat.i(95707);
    aWX = new b();
    AppMethodBeat.o(95707);
  }
  
  private b()
  {
    AppMethodBeat.i(95704);
    this.aUg = Collections.emptyList();
    AppMethodBeat.o(95704);
  }
  
  public b(com.google.android.exoplayer2.f.a parama)
  {
    AppMethodBeat.i(95703);
    this.aUg = Collections.singletonList(parama);
    AppMethodBeat.o(95703);
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
    AppMethodBeat.i(95706);
    if (paramLong >= 0L)
    {
      localList = this.aUg;
      AppMethodBeat.o(95706);
      return localList;
    }
    List localList = Collections.emptyList();
    AppMethodBeat.o(95706);
    return localList;
  }
  
  public final long dT(int paramInt)
  {
    AppMethodBeat.i(95705);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      AppMethodBeat.o(95705);
      return 0L;
    }
  }
  
  public final int pH()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.b
 * JD-Core Version:    0.7.0.1
 */