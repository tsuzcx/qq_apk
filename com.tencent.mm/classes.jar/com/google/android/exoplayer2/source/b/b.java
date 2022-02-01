package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements d
{
  private final g.a cZG;
  
  public b(g.a parama)
  {
    this.cZG = parama;
  }
  
  public final g Tp()
  {
    AppMethodBeat.i(62822);
    g localg = this.cZG.createDataSource();
    AppMethodBeat.o(62822);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.b
 * JD-Core Version:    0.7.0.1
 */