package com.tencent.mm.plugin.appbrand.appcache.b.c;

import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.g;
import com.tencent.mm.sdk.platformtools.y;

public enum a
{
  public static final a.a fFC = new a.1();
  public static final a.a fFD = new a.a() {};
  public static final a.a fFE = new a.a() {};
  public static final a.a fFF = new a.4();
  
  private a() {}
  
  public static void s(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L) {
      y.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    do
    {
      return;
      if (paramLong1 > 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.h(paramLong1, paramLong2, 1L);
        com.tencent.mm.plugin.report.service.h.nFQ.f(15272, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      }
    } while (843L == paramLong1);
    com.tencent.mm.plugin.report.service.h.nFQ.h(843L, paramLong2, 1L);
    com.tencent.mm.plugin.report.service.h.nFQ.f(15272, new Object[] { Integer.valueOf(843), Long.valueOf(paramLong2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.a
 * JD-Core Version:    0.7.0.1
 */