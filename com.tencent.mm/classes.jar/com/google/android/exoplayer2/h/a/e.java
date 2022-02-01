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
  private final d.a bpG;
  private final g.a bpR;
  private final g.a bpS;
  private final f.a bpT;
  private final a bpx;
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
    AppMethodBeat.i(198993);
    AppMethodBeat.o(198993);
  }
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, int paramInt, d.a parama4)
  {
    this.bpx = parama;
    this.bpR = parama1;
    this.bpS = parama2;
    this.bpT = parama3;
    this.flags = paramInt;
    this.bpG = parama4;
  }
  
  public final d uT()
  {
    AppMethodBeat.i(92974);
    a locala = this.bpx;
    g localg1 = this.bpR.uH();
    g localg2 = this.bpS.uH();
    if (this.bpT != null) {}
    for (Object localObject = this.bpT.uG();; localObject = null)
    {
      localObject = new d(locala, localg1, localg2, (f)localObject, this.flags, this.bpG);
      AppMethodBeat.o(92974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */