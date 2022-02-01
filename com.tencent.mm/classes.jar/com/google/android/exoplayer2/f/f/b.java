package com.google.android.exoplayer2.f.f;

import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  public static final b bDq;
  private final List<com.google.android.exoplayer2.f.a> bAD;
  
  static
  {
    AppMethodBeat.i(92875);
    bDq = new b();
    AppMethodBeat.o(92875);
  }
  
  private b()
  {
    AppMethodBeat.i(92872);
    this.bAD = Collections.emptyList();
    AppMethodBeat.o(92872);
  }
  
  public b(com.google.android.exoplayer2.f.a parama)
  {
    AppMethodBeat.i(92871);
    this.bAD = Collections.singletonList(parama);
    AppMethodBeat.o(92871);
  }
  
  public final int ai(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> aj(long paramLong)
  {
    AppMethodBeat.i(92874);
    if (paramLong >= 0L)
    {
      localList = this.bAD;
      AppMethodBeat.o(92874);
      return localList;
    }
    List localList = Collections.emptyList();
    AppMethodBeat.o(92874);
    return localList;
  }
  
  public final long eI(int paramInt)
  {
    AppMethodBeat.i(92873);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      AppMethodBeat.o(92873);
      return 0L;
    }
  }
  
  public final int vV()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.b
 * JD-Core Version:    0.7.0.1
 */