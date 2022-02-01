package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements e
{
  public static final h cLL;
  private static final int cTG;
  private final long cTH;
  private boolean cTK;
  private final d cTR;
  private final m cTS;
  
  static
  {
    AppMethodBeat.i(92209);
    cLL = new h()
    {
      public final e[] RV()
      {
        AppMethodBeat.i(92203);
        c localc = new c();
        AppMethodBeat.o(92203);
        return new e[] { localc };
      }
    };
    cTG = x.du("ID3");
    AppMethodBeat.o(92209);
  }
  
  public c()
  {
    this(0L);
  }
  
  public c(long paramLong)
  {
    AppMethodBeat.i(92204);
    this.cTH = paramLong;
    this.cTR = new d();
    this.cTS = new m(200);
    AppMethodBeat.o(92204);
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92207);
    this.cTK = false;
    this.cTR.Sl();
    AppMethodBeat.o(92207);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92208);
    int i = paramf.read(this.cTS.data, 0, 200);
    if (i == -1)
    {
      AppMethodBeat.o(92208);
      return -1;
    }
    this.cTS.setPosition(0);
    this.cTS.iG(i);
    if (!this.cTK)
    {
      this.cTR.timeUs = this.cTH;
      this.cTK = true;
    }
    this.cTR.t(this.cTS);
    AppMethodBeat.o(92208);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92206);
    this.cTR.a(paramg, new v.d(0, 1));
    paramg.RW();
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(92206);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92205);
    m localm = new m(10);
    l locall = new l(localm.data);
    int i = 0;
    for (;;)
    {
      paramf.b(localm.data, 0, 10);
      localm.setPosition(0);
      if (localm.UI() != cTG) {
        break;
      }
      localm.iH(3);
      j = localm.UM();
      i += j + 10;
      paramf.hu(j);
    }
    paramf.RS();
    paramf.hu(i);
    int k = 0;
    int j = 0;
    int m = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 2);
      localm.setPosition(0);
      if ((localm.readUnsignedShort() & 0xFFF6) != 65520)
      {
        paramf.RS();
        m += 1;
        if (m - i >= 8192)
        {
          AppMethodBeat.o(92205);
          return false;
        }
        paramf.hu(m);
        k = 0;
        j = 0;
      }
      else
      {
        k += 1;
        if ((k >= 4) && (j > 188))
        {
          AppMethodBeat.o(92205);
          return true;
        }
        paramf.b(localm.data, 0, 4);
        locall.setPosition(14);
        int n = locall.hQ(13);
        if (n <= 6)
        {
          AppMethodBeat.o(92205);
          return false;
        }
        paramf.hu(n - 6);
        j += n;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.c
 * JD-Core Version:    0.7.0.1
 */