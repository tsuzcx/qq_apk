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
  public static final h cLL;
  private static final int cTG;
  private final long cTH;
  private final b cTI;
  private final m cTJ;
  private boolean cTK;
  
  static
  {
    AppMethodBeat.i(92196);
    cLL = new h()
    {
      public final e[] RV()
      {
        AppMethodBeat.i(92190);
        a locala = new a();
        AppMethodBeat.o(92190);
        return new e[] { locala };
      }
    };
    cTG = x.du("ID3");
    AppMethodBeat.o(92196);
  }
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(92191);
    this.cTH = paramLong;
    this.cTI = new b();
    this.cTJ = new m(2786);
    AppMethodBeat.o(92191);
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92194);
    this.cTK = false;
    this.cTI.Si();
    AppMethodBeat.o(92194);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92195);
    int i = paramf.read(this.cTJ.data, 0, 2786);
    if (i == -1)
    {
      AppMethodBeat.o(92195);
      return -1;
    }
    this.cTJ.setPosition(0);
    this.cTJ.iG(i);
    if (!this.cTK)
    {
      this.cTI.timeUs = this.cTH;
      this.cTK = true;
    }
    this.cTI.t(this.cTJ);
    AppMethodBeat.o(92195);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92193);
    this.cTI.a(paramg, new v.d(0, 1));
    paramg.RW();
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
    int j = 0;
    int k = i;
    for (;;)
    {
      paramf.b(localm.data, 0, 5);
      localm.setPosition(0);
      if (localm.readUnsignedShort() != 2935)
      {
        paramf.RS();
        k += 1;
        if (k - i >= 8192)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.hu(k);
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
        int m = com.google.android.exoplayer2.a.a.r(localm.data);
        if (m == -1)
        {
          AppMethodBeat.o(92192);
          return false;
        }
        paramf.hu(m - 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.a
 * JD-Core Version:    0.7.0.1
 */