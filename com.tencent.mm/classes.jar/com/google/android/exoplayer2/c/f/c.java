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
  public static final h aBP;
  private static final int aJO;
  private final long aJP;
  private boolean aJS;
  private final d aJZ;
  private final m aKa;
  
  static
  {
    AppMethodBeat.i(95087);
    aBP = new c.1();
    aJO = x.aS("ID3");
    AppMethodBeat.o(95087);
  }
  
  public c()
  {
    this(0L);
  }
  
  public c(long paramLong)
  {
    AppMethodBeat.i(95082);
    this.aJP = paramLong;
    this.aJZ = new d();
    this.aKa = new m(200);
    AppMethodBeat.o(95082);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(95086);
    int i = paramf.read(this.aKa.data, 0, 200);
    if (i == -1)
    {
      AppMethodBeat.o(95086);
      return -1;
    }
    this.aKa.setPosition(0);
    this.aKa.em(i);
    if (!this.aJS)
    {
      this.aJZ.aAT = this.aJP;
      this.aJS = true;
    }
    this.aJZ.t(this.aKa);
    AppMethodBeat.o(95086);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(95084);
    this.aJZ.a(paramg, new v.d(0, 1));
    paramg.nZ();
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(95084);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(95083);
    m localm = new m(10);
    l locall = new l(localm.data);
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
    int k = 0;
    int j = 0;
    int m = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 2);
      localm.setPosition(0);
      if ((localm.readUnsignedShort() & 0xFFF6) != 65520)
      {
        paramf.nW();
        m += 1;
        if (m - i >= 8192)
        {
          AppMethodBeat.o(95083);
          return false;
        }
        paramf.dh(m);
        k = 0;
        j = 0;
      }
      else
      {
        k += 1;
        if ((k >= 4) && (j > 188))
        {
          AppMethodBeat.o(95083);
          return true;
        }
        paramf.b(localm.data, 0, 4);
        locall.setPosition(14);
        int n = locall.dD(13);
        if (n <= 6)
        {
          AppMethodBeat.o(95083);
          return false;
        }
        paramf.dh(n - 6);
        j += n;
      }
    }
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95085);
    this.aJS = false;
    this.aJZ.oo();
    AppMethodBeat.o(95085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.c
 * JD-Core Version:    0.7.0.1
 */