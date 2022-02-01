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
  public static final h aXT;
  private g aXZ;
  private com.google.android.exoplayer2.c.m bai;
  private b biA;
  private int biB;
  private int biC;
  
  static
  {
    AppMethodBeat.i(92311);
    aXT = new h()
    {
      public final e[] sT()
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
    b localb = this.biA;
    paramLong = Math.min(localb.biD * paramLong / 1000000L / localb.biE * localb.biE, localb.dataSize - localb.biE);
    long l = localb.biG;
    AppMethodBeat.o(92310);
    return l + paramLong;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92309);
    if (this.biA == null)
    {
      this.biA = c.m(paramf);
      if (this.biA == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(92309);
        throw paramf;
      }
      paramk = this.biA;
      i = paramk.aVX;
      j = paramk.biF;
      paramk = Format.a(null, "audio/raw", paramk.aWm * (i * j), 32768, this.biA.aWm, this.biA.aVX, this.biA.encoding, null, null, 0, null);
      this.bai.f(paramk);
      this.biB = this.biA.biE;
    }
    paramk = this.biA;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.biG != 0L) && (paramk.dataSize != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.biA;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.sR();
        localm = new com.google.android.exoplayer2.i.m(8);
      }
    }
    else
    {
      for (paramk = c.a.a(paramf, localm);; paramk = c.a.a(paramf, localm))
      {
        if (paramk.id == x.aQ("data")) {
          break label317;
        }
        new StringBuilder("Ignoring unknown WAV chunk: ").append(paramk.id);
        l1 = 8L + paramk.size;
        if (paramk.id == x.aQ("RIFF")) {
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
        paramf.dQ((int)l1);
      }
      label317:
      paramf.dQ(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.biG = l1;
      localb.dataSize = l2;
      this.aXZ.a(this);
    }
    int i = this.bai.a(paramf, 32768 - this.biC, true);
    if (i != -1) {
      this.biC += i;
    }
    int j = this.biC / this.biB;
    if (j > 0)
    {
      paramk = this.biA;
      l1 = (paramf.getPosition() - this.biC) * 1000000L / paramk.biD;
      j *= this.biB;
      this.biC -= j;
      this.bai.a(l1, 1, j, this.biC, null);
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
    this.aXZ = paramg;
    this.bai = paramg.dW(0);
    this.biA = null;
    paramg.sU();
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
    this.biC = 0;
  }
  
  public final long getDurationUs()
  {
    b localb = this.biA;
    return localb.dataSize / localb.biE * 1000000L / localb.aVX;
  }
  
  public final boolean sQ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */