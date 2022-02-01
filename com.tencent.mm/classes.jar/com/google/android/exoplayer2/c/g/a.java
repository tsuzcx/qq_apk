package com.google.android.exoplayer2.c.g;

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
  public static final h aXh;
  private static final int bfm;
  private final long bfn;
  private final b bfo;
  private final m bfp;
  private boolean bfq;
  
  static
  {
    AppMethodBeat.i(92196);
    aXh = new h()
    {
      public final e[] sK()
      {
        AppMethodBeat.i(92190);
        a locala = new a();
        AppMethodBeat.o(92190);
        return new e[] { locala };
      }
    };
    bfm = x.aY("ID3");
    AppMethodBeat.o(92196);
  }
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(92191);
    this.bfn = paramLong;
    this.bfo = new b();
    this.bfp = new m(2786);
    AppMethodBeat.o(92191);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92195);
    int i = paramf.read(this.bfp.data, 0, 2786);
    if (i == -1)
    {
      AppMethodBeat.o(92195);
      return -1;
    }
    this.bfp.setPosition(0);
    this.bfp.fk(i);
    if (!this.bfq)
    {
      this.bfo.timeUs = this.bfn;
      this.bfq = true;
    }
    this.bfo.t(this.bfp);
    AppMethodBeat.o(92195);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92193);
    this.bfo.a(paramg, new v.d(0, 1));
    paramg.sL();
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
      if (localm.vL() != bfm) {
        break;
      }
      localm.fl(3);
      j = localm.vP();
      i += j + 10;
      paramf.dS(j);
    }
    paramf.sI();
    paramf.dS(i);
    int j = 0;
    int k = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 5);
      localm.setPosition(0);
      if (localm.readUnsignedShort() != 2935)
      {
        paramf.sI();
        k += 1;
        if (k - i >= 8192)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.dS(k);
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
        paramf.dS(m - 5);
      }
    }
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92194);
    this.bfq = false;
    this.bfo.sX();
    AppMethodBeat.o(92194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.a
 * JD-Core Version:    0.7.0.1
 */