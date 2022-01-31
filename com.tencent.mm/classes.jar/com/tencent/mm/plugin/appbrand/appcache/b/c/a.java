package com.tencent.mm.plugin.appbrand.appcache.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public enum a
{
  public static final a.a gXX;
  public static final a.a gXY;
  public static final a.a gXZ;
  public static final a.a gYa;
  
  static
  {
    AppMethodBeat.i(129502);
    gXW = new a("INSTANCE");
    gYb = new a[] { gXW };
    gXX = new a.1();
    gXY = new a.2();
    gXZ = new a.3();
    gYa = new a.4();
    AppMethodBeat.o(129502);
  }
  
  private a() {}
  
  public static void B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129501);
    if (paramLong2 < 0L)
    {
      ab.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(129501);
      return;
    }
    if (paramLong1 > 0L)
    {
      h.qsU.j(paramLong1, paramLong2, 1L);
      h.qsU.e(15272, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    if (843L != paramLong1)
    {
      h.qsU.j(843L, paramLong2, 1L);
      h.qsU.e(15272, new Object[] { Integer.valueOf(843), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(129501);
  }
  
  public static void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156894);
    B(paramInt1, paramInt2);
    AppMethodBeat.o(156894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.a
 * JD-Core Version:    0.7.0.1
 */