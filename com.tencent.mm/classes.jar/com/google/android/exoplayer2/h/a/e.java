package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements g.a
{
  private final g.a bvI;
  private final g.a bvJ;
  private final f.a bvK;
  private final a bvo;
  private final d.a bvx;
  private final int flags;
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, d.a parama4)
  {
    this.bvo = parama;
    this.bvI = parama1;
    this.bvJ = parama2;
    this.bvK = parama3;
    this.flags = 3;
    this.bvx = parama4;
  }
  
  public final d vm()
  {
    AppMethodBeat.i(92974);
    a locala = this.bvo;
    g localg1 = this.bvI.vc();
    g localg2 = this.bvJ.vc();
    if (this.bvK != null) {}
    for (Object localObject = this.bvK.vb();; localObject = null)
    {
      localObject = new d(locala, localg1, localg2, (f)localObject, this.flags, this.bvx);
      AppMethodBeat.o(92974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */