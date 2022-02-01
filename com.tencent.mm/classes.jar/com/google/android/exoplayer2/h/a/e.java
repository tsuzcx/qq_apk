package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements g.a
{
  private final a bFC;
  private final d.a bFL;
  private final g.a bFW;
  private final g.a bFX;
  private final f.a bFY;
  private final int flags;
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, d.a parama4)
  {
    this.bFC = parama;
    this.bFW = parama1;
    this.bFX = parama2;
    this.bFY = parama3;
    this.flags = 3;
    this.bFL = parama4;
  }
  
  public final d wJ()
  {
    AppMethodBeat.i(92974);
    a locala = this.bFC;
    g localg1 = this.bFW.wB();
    g localg2 = this.bFX.wB();
    if (this.bFY != null) {}
    for (Object localObject = this.bFY.wA();; localObject = null)
    {
      localObject = new d(locala, localg1, localg2, (f)localObject, this.flags, this.bFL);
      AppMethodBeat.o(92974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */