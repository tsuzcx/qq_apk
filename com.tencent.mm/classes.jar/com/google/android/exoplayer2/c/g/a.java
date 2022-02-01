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
  public static final h aRP;
  private g aRV;
  private com.google.android.exoplayer2.c.m aUa;
  private b bcr;
  private int bcs;
  private int bct;
  
  static
  {
    AppMethodBeat.i(92311);
    aRP = new h()
    {
      public final e[] ss()
      {
        AppMethodBeat.i(92306);
        a locala = new a();
        AppMethodBeat.o(92306);
        return new e[] { locala };
      }
    };
    AppMethodBeat.o(92311);
  }
  
  public final long O(long paramLong)
  {
    AppMethodBeat.i(92310);
    b localb = this.bcr;
    paramLong = Math.min(localb.bcu * paramLong / 1000000L / localb.bcv * localb.bcv, localb.bcy - localb.bcv);
    long l = localb.bcx;
    AppMethodBeat.o(92310);
    return l + paramLong;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92309);
    if (this.bcr == null)
    {
      this.bcr = c.m(paramf);
      if (this.bcr == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(92309);
        throw paramf;
      }
      paramk = this.bcr;
      i = paramk.aPP;
      j = paramk.bcw;
      paramk = Format.a(null, "audio/raw", paramk.aQe * (i * j), 32768, this.bcr.aQe, this.bcr.aPP, this.bcr.encoding, null, null, 0, null);
      this.aUa.f(paramk);
      this.bcs = this.bcr.bcv;
    }
    paramk = this.bcr;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.bcx != 0L) && (paramk.bcy != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.bcr;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.sp();
        localm = new com.google.android.exoplayer2.i.m(8);
      }
    }
    else
    {
      for (paramk = c.a.a(paramf, localm);; paramk = c.a.a(paramf, localm))
      {
        if (paramk.id == x.bU("data")) {
          break label317;
        }
        new StringBuilder("Ignoring unknown WAV chunk: ").append(paramk.id);
        l1 = 8L + paramk.size;
        if (paramk.id == x.bU("RIFF")) {
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
        paramf.ed((int)l1);
      }
      label317:
      paramf.ed(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.bcx = l1;
      localb.bcy = l2;
      this.aRV.a(this);
    }
    int i = this.aUa.a(paramf, 32768 - this.bct, true);
    if (i != -1) {
      this.bct += i;
    }
    int j = this.bct / this.bcs;
    if (j > 0)
    {
      paramk = this.bcr;
      l1 = (paramf.getPosition() - this.bct) * 1000000L / paramk.bcu;
      j *= this.bcs;
      this.bct -= j;
      this.aUa.a(l1, 1, j, this.bct, null);
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
    this.aRV = paramg;
    this.aUa = paramg.ej(0);
    this.bcr = null;
    paramg.st();
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
  
  public final void g(long paramLong1, long paramLong2)
  {
    this.bct = 0;
  }
  
  public final long getDurationUs()
  {
    b localb = this.bcr;
    return localb.bcy / localb.bcv * 1000000L / localb.aPP;
  }
  
  public final boolean so()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */