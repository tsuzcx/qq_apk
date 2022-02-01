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
  public static final h bio;
  private static final int bqo;
  private final m bqA;
  private final long bqp;
  private boolean bqs;
  private final d bqz;
  
  static
  {
    AppMethodBeat.i(92209);
    bio = new h()
    {
      public final e[] us()
      {
        AppMethodBeat.i(92203);
        c localc = new c();
        AppMethodBeat.o(92203);
        return new e[] { localc };
      }
    };
    bqo = x.bJ("ID3");
    AppMethodBeat.o(92209);
  }
  
  public c()
  {
    this(0L);
  }
  
  public c(long paramLong)
  {
    AppMethodBeat.i(92204);
    this.bqp = paramLong;
    this.bqz = new d();
    this.bqA = new m(200);
    AppMethodBeat.o(92204);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92208);
    int i = paramf.read(this.bqA.data, 0, 200);
    if (i == -1)
    {
      AppMethodBeat.o(92208);
      return -1;
    }
    this.bqA.setPosition(0);
    this.bqA.eZ(i);
    if (!this.bqs)
    {
      this.bqz.timeUs = this.bqp;
      this.bqs = true;
    }
    this.bqz.t(this.bqA);
    AppMethodBeat.o(92208);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92206);
    this.bqz.a(paramg, new v.d(0, 1));
    paramg.ut();
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
      if (localm.wX() != bqo) {
        break;
      }
      localm.fa(3);
      j = localm.xb();
      i += j + 10;
      paramf.dV(j);
    }
    paramf.uq();
    paramf.dV(i);
    int k = 0;
    int j = 0;
    int m = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 2);
      localm.setPosition(0);
      if ((localm.readUnsignedShort() & 0xFFF6) != 65520)
      {
        paramf.uq();
        m += 1;
        if (m - i >= 8192)
        {
          AppMethodBeat.o(92205);
          return false;
        }
        paramf.dV(m);
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
        int n = locall.es(13);
        if (n <= 6)
        {
          AppMethodBeat.o(92205);
          return false;
        }
        paramf.dV(n - 6);
        j += n;
      }
    }
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92207);
    this.bqs = false;
    this.bqz.uI();
    AppMethodBeat.o(92207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.c
 * JD-Core Version:    0.7.0.1
 */