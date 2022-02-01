package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements e, l
{
  public static final h cLL;
  private g cLR;
  private com.google.android.exoplayer2.c.m cNW;
  private b cWm;
  private int cWn;
  private int cWo;
  
  static
  {
    AppMethodBeat.i(92311);
    cLL = new h()
    {
      public final e[] RV()
      {
        AppMethodBeat.i(92306);
        a locala = new a();
        AppMethodBeat.o(92306);
        return new e[] { locala };
      }
    };
    AppMethodBeat.o(92311);
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    this.cWo = 0;
  }
  
  public final boolean RR()
  {
    return true;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92309);
    if (this.cWm == null)
    {
      this.cWm = c.m(paramf);
      if (this.cWm == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(92309);
        throw paramf;
      }
      paramk = this.cWm;
      i = paramk.cJL;
      j = paramk.cWr;
      paramk = Format.a(null, "audio/raw", paramk.cKa * (i * j), 32768, this.cWm.cKa, this.cWm.cJL, this.cWm.encoding, null, null, 0, null);
      this.cNW.f(paramk);
      this.cWn = this.cWm.cWq;
    }
    paramk = this.cWm;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.cWs != 0L) && (paramk.cWt != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.cWm;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.RS();
        localm = new com.google.android.exoplayer2.i.m(8);
      }
    }
    else
    {
      for (paramk = c.a.a(paramf, localm);; paramk = c.a.a(paramf, localm))
      {
        if (paramk.id == x.du("data")) {
          break label317;
        }
        new StringBuilder("Ignoring unknown WAV chunk: ").append(paramk.id);
        l1 = 8L + paramk.size;
        if (paramk.id == x.du("RIFF")) {
          l1 = 12L;
        }
        if (l1 > 2147483647L)
        {
          paramf = new o("Chunk is too large (~2GB+) to skip; id: " + paramk.id);
          AppMethodBeat.o(92309);
          throw paramf;
          i = 0;
          break;
        }
        paramf.eP((int)l1);
      }
      label317:
      paramf.eP(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.cWs = l1;
      localb.cWt = l2;
      this.cLR.a(this);
    }
    int i = this.cNW.a(paramf, 32768 - this.cWo, true);
    if (i != -1) {
      this.cWo += i;
    }
    int j = this.cWo / this.cWn;
    if (j > 0)
    {
      paramk = this.cWm;
      l1 = (paramf.getPosition() - this.cWo) * 1000000L / paramk.cWp;
      j *= this.cWn;
      this.cWo -= j;
      this.cNW.a(l1, 1, j, this.cWo, null);
    }
    if (i == -1)
    {
      AppMethodBeat.o(92309);
      return -1;
    }
    AppMethodBeat.o(92309);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92308);
    this.cLR = paramg;
    this.cNW = paramg.hz(0);
    this.cWm = null;
    paramg.RW();
    AppMethodBeat.o(92308);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92307);
    if (c.m(paramf) != null)
    {
      AppMethodBeat.o(92307);
      return true;
    }
    AppMethodBeat.o(92307);
    return false;
  }
  
  public final long cc(long paramLong)
  {
    AppMethodBeat.i(92310);
    b localb = this.cWm;
    paramLong = Math.min(localb.cWp * paramLong / 1000000L / localb.cWq * localb.cWq, localb.cWt - localb.cWq);
    long l = localb.cWs;
    AppMethodBeat.o(92310);
    return l + paramLong;
  }
  
  public final long getDurationUs()
  {
    b localb = this.cWm;
    return localb.cWt / localb.cWq * 1000000L / localb.cJL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */