package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements e
{
  public static final h aRP;
  private static final int aZL;
  private final long aZM;
  private final b aZN;
  private final m aZO;
  private boolean aZP;
  
  static
  {
    AppMethodBeat.i(92196);
    aRP = new h()
    {
      public final e[] ss()
      {
        AppMethodBeat.i(92190);
        a locala = new a();
        AppMethodBeat.o(92190);
        return new e[] { locala };
      }
    };
    aZL = x.bU("ID3");
    AppMethodBeat.o(92196);
  }
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(92191);
    this.aZM = paramLong;
    this.aZN = new b();
    this.aZO = new m(2786);
    AppMethodBeat.o(92191);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92195);
    int i = paramf.read(this.aZO.data, 0, 2786);
    if (i == -1)
    {
      AppMethodBeat.o(92195);
      return -1;
    }
    this.aZO.setPosition(0);
    this.aZO.ft(i);
    if (!this.aZP)
    {
      this.aZN.timeUs = this.aZM;
      this.aZP = true;
    }
    this.aZN.t(this.aZO);
    AppMethodBeat.o(92195);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92193);
    this.aZN.a(paramg, new v.d(0, 1));
    paramg.st();
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(92193);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92192);
    m localm = new m(10);
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
    int j = 0;
    int k = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 5);
      localm.setPosition(0);
      if (localm.readUnsignedShort() != 2935)
      {
        paramf.sp();
        k += 1;
        if (k - i >= 8192)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.ee(k);
        j = 0;
      }
      else
      {
        j += 1;
        if (j >= 4)
        {
          AppMethodBeat.o(92192);
          return true;
        }
        int m = com.google.android.exoplayer2.a.a.l(localm.data);
        if (m == -1)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.ee(m - 5);
      }
    }
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92194);
    this.aZP = false;
    this.aZN.sF();
    AppMethodBeat.o(92194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.a
 * JD-Core Version:    0.7.0.1
 */