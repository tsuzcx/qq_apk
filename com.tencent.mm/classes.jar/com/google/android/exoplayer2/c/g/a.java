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
  public static final h bio;
  private g biu;
  private com.google.android.exoplayer2.c.m bkD;
  private b bsU;
  private int bsV;
  private int bsW;
  
  static
  {
    AppMethodBeat.i(92311);
    bio = new h()
    {
      public final e[] us()
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
    b localb = this.bsU;
    paramLong = Math.min(localb.bsX * paramLong / 1000000L / localb.bsY * localb.bsY, localb.dataSize - localb.bsY);
    long l = localb.bta;
    AppMethodBeat.o(92310);
    return l + paramLong;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92309);
    if (this.bsU == null)
    {
      this.bsU = c.m(paramf);
      if (this.bsU == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(92309);
        throw paramf;
      }
      paramk = this.bsU;
      i = paramk.bgs;
      j = paramk.bsZ;
      paramk = Format.a(null, "audio/raw", paramk.bgH * (i * j), 32768, this.bsU.bgH, this.bsU.bgs, this.bsU.encoding, null, null, 0, null);
      this.bkD.f(paramk);
      this.bsV = this.bsU.bsY;
    }
    paramk = this.bsU;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.bta != 0L) && (paramk.dataSize != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.bsU;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.uq();
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
        paramf.dU((int)l1);
      }
      label317:
      paramf.dU(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.bta = l1;
      localb.dataSize = l2;
      this.biu.a(this);
    }
    int i = this.bkD.a(paramf, 32768 - this.bsW, true);
    if (i != -1) {
      this.bsW += i;
    }
    int j = this.bsW / this.bsV;
    if (j > 0)
    {
      paramk = this.bsU;
      l1 = (paramf.getPosition() - this.bsW) * 1000000L / paramk.bsX;
      j *= this.bsV;
      this.bsW -= j;
      this.bkD.a(l1, 1, j, this.bsW, null);
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
    this.biu = paramg;
    this.bkD = paramg.eb(0);
    this.bsU = null;
    paramg.ut();
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
    this.bsW = 0;
  }
  
  public final long getDurationUs()
  {
    b localb = this.bsU;
    return localb.dataSize / localb.bsY * 1000000L / localb.bgs;
  }
  
  public final boolean up()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */