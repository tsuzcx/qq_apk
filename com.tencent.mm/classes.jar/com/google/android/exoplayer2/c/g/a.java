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
  public static final h aBP;
  private g aBV;
  private com.google.android.exoplayer2.c.m aEe;
  private b aMw;
  private int aMx;
  private int aMy;
  
  static
  {
    AppMethodBeat.i(95189);
    aBP = new a.1();
    AppMethodBeat.o(95189);
  }
  
  public final long E(long paramLong)
  {
    AppMethodBeat.i(95188);
    b localb = this.aMw;
    paramLong = Math.min(localb.aMz * paramLong / 1000000L / localb.aMA * localb.aMA, localb.dataSize - localb.aMA);
    long l = localb.aMC;
    AppMethodBeat.o(95188);
    return l + paramLong;
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(95187);
    if (this.aMw == null)
    {
      this.aMw = c.m(paramf);
      if (this.aMw == null)
      {
        paramf = new o("Unsupported or unrecognized wav header.");
        AppMethodBeat.o(95187);
        throw paramf;
      }
      paramk = this.aMw;
      i = paramk.azR;
      j = paramk.aMB;
      paramk = Format.a(null, "audio/raw", paramk.aAg * (i * j), 32768, this.aMw.aAg, this.aMw.azR, this.aMw.encoding, null, null, 0, null);
      this.aEe.f(paramk);
      this.aMx = this.aMw.aMA;
    }
    paramk = this.aMw;
    b localb;
    com.google.android.exoplayer2.i.m localm;
    long l1;
    if ((paramk.aMC != 0L) && (paramk.dataSize != 0L))
    {
      i = 1;
      if (i == 0)
      {
        localb = this.aMw;
        com.google.android.exoplayer2.i.a.checkNotNull(paramf);
        com.google.android.exoplayer2.i.a.checkNotNull(localb);
        paramf.nW();
        localm = new com.google.android.exoplayer2.i.m(8);
      }
    }
    else
    {
      for (paramk = c.a.a(paramf, localm);; paramk = c.a.a(paramf, localm))
      {
        if (paramk.id == x.aS("data")) {
          break label317;
        }
        new StringBuilder("Ignoring unknown WAV chunk: ").append(paramk.id);
        l1 = 8L + paramk.size;
        if (paramk.id == x.aS("RIFF")) {
          l1 = 12L;
        }
        if (l1 > 2147483647L)
        {
          paramf = new o("Chunk is too large (~2GB+) to skip; id: " + paramk.id);
          AppMethodBeat.o(95187);
          throw paramf;
          i = 0;
          break;
        }
        paramf.dg((int)l1);
      }
      label317:
      paramf.dg(8);
      l1 = paramf.getPosition();
      long l2 = paramk.size;
      localb.aMC = l1;
      localb.dataSize = l2;
      this.aBV.a(this);
    }
    int i = this.aEe.a(paramf, 32768 - this.aMy, true);
    if (i != -1) {
      this.aMy += i;
    }
    int j = this.aMy / this.aMx;
    if (j > 0)
    {
      paramk = this.aMw;
      l1 = (paramf.getPosition() - this.aMy) * 1000000L / paramk.aMz;
      j *= this.aMx;
      this.aMy -= j;
      this.aEe.a(l1, 1, j, this.aMy, null);
    }
    if (i == -1)
    {
      AppMethodBeat.o(95187);
      return -1;
    }
    AppMethodBeat.o(95187);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(95186);
    this.aBV = paramg;
    this.aEe = paramg.dm(0);
    this.aMw = null;
    paramg.nZ();
    AppMethodBeat.o(95186);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(95185);
    if (c.m(paramf) != null)
    {
      AppMethodBeat.o(95185);
      return true;
    }
    AppMethodBeat.o(95185);
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    this.aMy = 0;
  }
  
  public final long getDurationUs()
  {
    b localb = this.aMw;
    return localb.dataSize / localb.aMA * 1000000L / localb.azR;
  }
  
  public final boolean nV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */