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
  public static final h bil;
  private static final int bqj;
  private final long bqk;
  private final b bql;
  private final m bqm;
  private boolean bqn;
  
  static
  {
    AppMethodBeat.i(92196);
    bil = new h()
    {
      public final e[] ux()
      {
        AppMethodBeat.i(92190);
        a locala = new a();
        AppMethodBeat.o(92190);
        return new e[] { locala };
      }
    };
    bqj = x.bJ("ID3");
    AppMethodBeat.o(92196);
  }
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(92191);
    this.bqk = paramLong;
    this.bql = new b();
    this.bqm = new m(2786);
    AppMethodBeat.o(92191);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92195);
    int i = paramf.read(this.bqm.data, 0, 2786);
    if (i == -1)
    {
      AppMethodBeat.o(92195);
      return -1;
    }
    this.bqm.setPosition(0);
    this.bqm.eY(i);
    if (!this.bqn)
    {
      this.bql.timeUs = this.bqk;
      this.bqn = true;
    }
    this.bql.t(this.bqm);
    AppMethodBeat.o(92195);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92193);
    this.bql.a(paramg, new v.d(0, 1));
    paramg.uy();
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
      if (localm.xf() != bqj) {
        break;
      }
      localm.eZ(3);
      j = localm.xj();
      i += j + 10;
      paramf.dQ(j);
    }
    paramf.uv();
    paramf.dQ(i);
    int j = 0;
    int k = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 5);
      localm.setPosition(0);
      if (localm.readUnsignedShort() != 2935)
      {
        paramf.uv();
        k += 1;
        if (k - i >= 8192)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.dQ(k);
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
        paramf.dQ(m - 5);
      }
    }
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92194);
    this.bqn = false;
    this.bql.uK();
    AppMethodBeat.o(92194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.a
 * JD-Core Version:    0.7.0.1
 */