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
  public static final h aRP;
  private static final int aZL;
  private final long aZM;
  private boolean aZP;
  private final d aZW;
  private final m aZX;
  
  static
  {
    AppMethodBeat.i(92209);
    aRP = new h()
    {
      public final e[] ss()
      {
        AppMethodBeat.i(92203);
        c localc = new c();
        AppMethodBeat.o(92203);
        return new e[] { localc };
      }
    };
    aZL = x.bU("ID3");
    AppMethodBeat.o(92209);
  }
  
  public c()
  {
    this(0L);
  }
  
  public c(long paramLong)
  {
    AppMethodBeat.i(92204);
    this.aZM = paramLong;
    this.aZW = new d();
    this.aZX = new m(200);
    AppMethodBeat.o(92204);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92208);
    int i = paramf.read(this.aZX.data, 0, 200);
    if (i == -1)
    {
      AppMethodBeat.o(92208);
      return -1;
    }
    this.aZX.setPosition(0);
    this.aZX.ft(i);
    if (!this.aZP)
    {
      this.aZW.timeUs = this.aZM;
      this.aZP = true;
    }
    this.aZW.t(this.aZX);
    AppMethodBeat.o(92208);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92206);
    this.aZW.a(paramg, new v.d(0, 1));
    paramg.st();
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
      if (localm.vj() != aZL) {
        break;
      }
      localm.fu(3);
      j = localm.vn();
      i += j + 10;
      paramf.ee(j);
    }
    paramf.sp();
    paramf.ee(i);
    int k = 0;
    int j = 0;
    int m = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 2);
      localm.setPosition(0);
      if ((localm.readUnsignedShort() & 0xFFF6) != 65520)
      {
        paramf.sp();
        m += 1;
        if (m - i >= 8192)
        {
          AppMethodBeat.o(92205);
          return false;
        }
        paramf.ee(m);
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
        int n = locall.eA(13);
        if (n <= 6)
        {
          AppMethodBeat.o(92205);
          return false;
        }
        paramf.ee(n - 6);
        j += n;
      }
    }
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92207);
    this.aZP = false;
    this.aZW.sI();
    AppMethodBeat.o(92207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.c
 * JD-Core Version:    0.7.0.1
 */