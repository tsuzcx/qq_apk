package com.google.android.exoplayer2.c.h;

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
  public static final h aXh;
  private g aXn;
  private com.google.android.exoplayer2.c.m aZw;
  private b bhV;
  private int bhW;
  private int bhX;
  
  static
  {
    AppMethodBeat.i(92311);
    aXh = new h()
    {
      public final e[] sK()
      {
        AppMethodBeat.i(92306);
        a locala = new a();
        AppMethodBeat.o(92306);
        return new e[] { locala };
      }
    };
    AppMethodBeat.o(92311);
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(92310);
    b localb = this.bhV;
    paramLong = Math.min(localb.bhY * paramLong / 1000000L / localb.bhZ * localb.bhZ, localb.dataSize - localb.bhZ);
    long l = localb.bib;
    AppMethodBeat.o(92310);
    return l + paramLong;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92309);
    if (this.bhV == null)
    {
      this.bhV = c.n(paramf);
      if (this.bhV == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(92309);
        throw paramf;
      }
      paramk = this.bhV;
      i = paramk.aVk;
      j = paramk.bia;
      paramk = Format.a(null, "audio/raw", paramk.aVz * (i * j), 32768, this.bhV.aVz, this.bhV.aVk, this.bhV.encoding, null, null, 0, null);
      this.aZw.f(paramk);
      this.bhW = this.bhV.bhZ;
    }
    paramk = this.bhV;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.bib != 0L) && (paramk.dataSize != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.bhV;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.sI();
        localm = new com.google.android.exoplayer2.i.m(8);
      }
    }
    else
    {
      for (paramk = c.a.a(paramf, localm);; paramk = c.a.a(paramf, localm))
      {
        if (paramk.id == x.aY("data")) {
          break label317;
        }
        new StringBuilder("Ignoring unknown WAV chunk: ").append(paramk.id);
        l1 = 8L + paramk.size;
        if (paramk.id == x.aY("RIFF")) {
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
        paramf.dR((int)l1);
      }
      label317:
      paramf.dR(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.bib = l1;
      localb.dataSize = l2;
      this.aXn.a(this);
    }
    int i = this.aZw.a(paramf, 32768 - this.bhX, true);
    if (i != -1) {
      this.bhX += i;
    }
    int j = this.bhX / this.bhW;
    if (j > 0)
    {
      paramk = this.bhV;
      l1 = (paramf.getPosition() - this.bhX) * 1000000L / paramk.bhY;
      j *= this.bhW;
      this.bhX -= j;
      this.aZw.a(l1, 1, j, this.bhX, null);
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
    this.aXn = paramg;
    this.aZw = paramg.bh(0, 1);
    this.bhV = null;
    paramg.sL();
    AppMethodBeat.o(92308);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92307);
    if (c.n(paramf) != null)
    {
      AppMethodBeat.o(92307);
      return true;
    }
    AppMethodBeat.o(92307);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.bhX = 0;
  }
  
  public final long getDurationUs()
  {
    b localb = this.bhV;
    return localb.dataSize / localb.bhZ * 1000000L / localb.aVk;
  }
  
  public final boolean sH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.h.a
 * JD-Core Version:    0.7.0.1
 */