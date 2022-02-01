package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements g.a
{
  private final a bFT;
  private final d.a bGc;
  private final g.a bGn;
  private final g.a bGo;
  private final f.a bGp;
  private final int flags;
  
  public e(a parama, g.a parama1)
  {
    this(parama, parama1, (byte)0);
  }
  
  private e(a parama, g.a parama1, byte paramByte)
  {
    this(parama, parama1, '\000');
  }
  
  private e(a parama, g.a parama1, char paramChar)
  {
    this(parama, parama1, new r(), new c(parama, 2097152L), 0, null);
    AppMethodBeat.i(196062);
    AppMethodBeat.o(196062);
  }
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, int paramInt, d.a parama4)
  {
    this.bFT = parama;
    this.bGn = parama1;
    this.bGo = parama2;
    this.bGp = parama3;
    this.flags = paramInt;
    this.bGc = parama4;
  }
  
  public final d wR()
  {
    AppMethodBeat.i(92974);
    a locala = this.bFT;
    g localg1 = this.bGn.wG();
    g localg2 = this.bGo.wG();
    if (this.bGp != null) {}
    for (Object localObject = this.bGp.wF();; localObject = null)
    {
      localObject = new d(locala, localg1, localg2, (f)localObject, this.flags, this.bGc);
      AppMethodBeat.o(92974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */