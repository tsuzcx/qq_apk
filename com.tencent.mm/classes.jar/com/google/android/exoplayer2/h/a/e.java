package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements g.a
{
  private final a bxF;
  private final d.a bxO;
  private final g.a bxZ;
  private final g.a bya;
  private final f.a byb;
  private final int flags;
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, d.a parama4)
  {
    this.bxF = parama;
    this.bxZ = parama1;
    this.bya = parama2;
    this.byb = parama3;
    this.flags = 3;
    this.bxO = parama4;
  }
  
  public final d vv()
  {
    AppMethodBeat.i(92974);
    a locala = this.bxF;
    g localg1 = this.bxZ.vi();
    g localg2 = this.bya.vi();
    if (this.byb != null) {}
    for (Object localObject = this.byb.vh();; localObject = null)
    {
      localObject = new d(locala, localg1, localg2, (f)localObject, this.flags, this.bxO);
      AppMethodBeat.o(92974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */