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
  public static final h aBP;
  private static final int aJO;
  private final long aJP;
  private final b aJQ;
  private final m aJR;
  private boolean aJS;
  
  static
  {
    AppMethodBeat.i(95074);
    aBP = new a.1();
    aJO = x.aS("ID3");
    AppMethodBeat.o(95074);
  }
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(95069);
    this.aJP = paramLong;
    this.aJQ = new b();
    this.aJR = new m(2786);
    AppMethodBeat.o(95069);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(95073);
    int i = paramf.read(this.aJR.data, 0, 2786);
    if (i == -1)
    {
      AppMethodBeat.o(95073);
      return -1;
    }
    this.aJR.setPosition(0);
    this.aJR.em(i);
    if (!this.aJS)
    {
      this.aJQ.aAT = this.aJP;
      this.aJS = true;
    }
    this.aJQ.t(this.aJR);
    AppMethodBeat.o(95073);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(95071);
    this.aJQ.a(paramg, new v.d(0, 1));
    paramg.nZ();
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(95071);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(95070);
    m localm = new m(10);
    int i = 0;
    for (;;)
    {
      paramf.b(localm.data, 0, 10);
      localm.setPosition(0);
      if (localm.qO() != aJO) {
        break;
      }
      localm.en(3);
      j = localm.qS();
      i += j + 10;
      paramf.dh(j);
    }
    paramf.nW();
    paramf.dh(i);
    int j = 0;
    int k = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 5);
      localm.setPosition(0);
      if (localm.readUnsignedShort() != 2935)
      {
        paramf.nW();
        k += 1;
        if (k - i >= 8192)
        {
          AppMethodBeat.o(95070);
          return false;
        }
        paramf.dh(k);
        j = 0;
      }
      else
      {
        j += 1;
        if (j >= 4)
        {
          AppMethodBeat.o(95070);
          return true;
        }
        int m = com.google.android.exoplayer2.a.a.i(localm.data);
        if (m == -1)
        {
          AppMethodBeat.o(95070);
          return false;
        }
        paramf.dh(m - 5);
      }
    }
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95072);
    this.aJS = false;
    this.aJQ.ol();
    AppMethodBeat.o(95072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.a
 * JD-Core Version:    0.7.0.1
 */