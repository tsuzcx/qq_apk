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
  public static final h bio;
  private static final int bqo;
  private final long bqp;
  private final b bqq;
  private final m bqr;
  private boolean bqs;
  
  static
  {
    AppMethodBeat.i(92196);
    bio = new h()
    {
      public final e[] us()
      {
        AppMethodBeat.i(92190);
        a locala = new a();
        AppMethodBeat.o(92190);
        return new e[] { locala };
      }
    };
    bqo = x.bJ("ID3");
    AppMethodBeat.o(92196);
  }
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(92191);
    this.bqp = paramLong;
    this.bqq = new b();
    this.bqr = new m(2786);
    AppMethodBeat.o(92191);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92195);
    int i = paramf.read(this.bqr.data, 0, 2786);
    if (i == -1)
    {
      AppMethodBeat.o(92195);
      return -1;
    }
    this.bqr.setPosition(0);
    this.bqr.eZ(i);
    if (!this.bqs)
    {
      this.bqq.timeUs = this.bqp;
      this.bqs = true;
    }
    this.bqq.t(this.bqr);
    AppMethodBeat.o(92195);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92193);
    this.bqq.a(paramg, new v.d(0, 1));
    paramg.ut();
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
    int j = 0;
    int k = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 5);
      localm.setPosition(0);
      if (localm.readUnsignedShort() != 2935)
      {
        paramf.uq();
        k += 1;
        if (k - i >= 8192)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.dV(k);
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
        int m = com.google.android.exoplayer2.a.a.n(localm.data);
        if (m == -1)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.dV(m - 5);
      }
    }
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92194);
    this.bqs = false;
    this.bqq.uF();
    AppMethodBeat.o(92194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.a
 * JD-Core Version:    0.7.0.1
 */