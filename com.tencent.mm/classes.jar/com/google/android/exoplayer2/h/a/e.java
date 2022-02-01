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
  private final a dja;
  private final d.a djk;
  private final g.a djv;
  private final g.a djw;
  private final f.a djx;
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
    AppMethodBeat.i(210322);
    AppMethodBeat.o(210322);
  }
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, int paramInt, d.a parama4)
  {
    this.dja = parama;
    this.djv = parama1;
    this.djw = parama2;
    this.djx = parama3;
    this.flags = paramInt;
    this.djk = parama4;
  }
  
  public final d Us()
  {
    AppMethodBeat.i(92974);
    a locala = this.dja;
    g localg1 = this.djv.createDataSource();
    g localg2 = this.djw.createDataSource();
    if (this.djx != null) {}
    for (Object localObject = this.djx.Uj();; localObject = null)
    {
      localObject = new d(locala, localg1, localg2, (f)localObject, this.flags, this.djk);
      AppMethodBeat.o(92974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */