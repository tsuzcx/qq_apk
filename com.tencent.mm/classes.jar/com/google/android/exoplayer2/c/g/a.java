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
  public static final h bil;
  private g bir;
  private com.google.android.exoplayer2.c.m bky;
  private b bsP;
  private int bsQ;
  private int bsR;
  
  static
  {
    AppMethodBeat.i(92311);
    bil = new h()
    {
      public final e[] ux()
      {
        AppMethodBeat.i(92306);
        a locala = new a();
        AppMethodBeat.o(92306);
        return new e[] { locala };
      }
    };
    AppMethodBeat.o(92311);
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92310);
    b localb = this.bsP;
    paramLong = Math.min(localb.bsS * paramLong / 1000000L / localb.bsT * localb.bsT, localb.dataSize - localb.bsT);
    long l = localb.bsV;
    AppMethodBeat.o(92310);
    return l + paramLong;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92309);
    if (this.bsP == null)
    {
      this.bsP = c.m(paramf);
      if (this.bsP == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(92309);
        throw paramf;
      }
      paramk = this.bsP;
      i = paramk.bgp;
      j = paramk.bsU;
      paramk = Format.a(null, "audio/raw", paramk.bgE * (i * j), 32768, this.bsP.bgE, this.bsP.bgp, this.bsP.encoding, null, null, 0, null);
      this.bky.f(paramk);
      this.bsQ = this.bsP.bsT;
    }
    paramk = this.bsP;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.bsV != 0L) && (paramk.dataSize != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.bsP;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.uv();
        localm = new com.google.android.exoplayer2.i.m(8);
      }
    }
    else
    {
      for (paramk = c.a.a(paramf, localm);; paramk = c.a.a(paramf, localm))
      {
        if (paramk.id == x.bJ("data")) {
          break label317;
        }
        new StringBuilder("Ignoring unknown WAV chunk: ").append(paramk.id);
        l1 = 8L + paramk.size;
        if (paramk.id == x.bJ("RIFF")) {
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
        paramf.dP((int)l1);
      }
      label317:
      paramf.dP(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.bsV = l1;
      localb.dataSize = l2;
      this.bir.a(this);
    }
    int i = this.bky.a(paramf, 32768 - this.bsR, true);
    if (i != -1) {
      this.bsR += i;
    }
    int j = this.bsR / this.bsQ;
    if (j > 0)
    {
      paramk = this.bsP;
      l1 = (paramf.getPosition() - this.bsR) * 1000000L / paramk.bsS;
      j *= this.bsQ;
      this.bsR -= j;
      this.bky.a(l1, 1, j, this.bsR, null);
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
    this.bir = paramg;
    this.bky = paramg.dV(0);
    this.bsP = null;
    paramg.uy();
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
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.bsR = 0;
  }
  
  public final long getDurationUs()
  {
    b localb = this.bsP;
    return localb.dataSize / localb.bsT * 1000000L / localb.bgp;
  }
  
  public final boolean uu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */