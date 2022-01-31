package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mm.h.b.a.ae;
import com.tencent.mm.h.b.a.ae.a;
import com.tencent.mm.h.b.a.ae.b;
import com.tencent.mm.h.b.a.aj;
import com.tencent.mm.h.b.a.aj.a;
import com.tencent.mm.h.b.a.aj.b;
import com.tencent.mm.h.b.a.ap;
import com.tencent.mm.h.b.a.ap.a;
import com.tencent.mm.h.b.a.ap.b;
import com.tencent.mm.h.b.a.ar;
import com.tencent.mm.h.b.a.ar.a;
import com.tencent.mm.h.b.a.ar.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;

public final class b
{
  public static void a(String paramString, AppBrandPreloadProfiler paramAppBrandPreloadProfiler)
  {
    long l2 = 0L;
    ap localap = new ap();
    paramString = a.wg(paramString);
    if (paramString == null) {
      return;
    }
    localap.ckG = paramString.appId;
    localap.ckF = paramString.gKi;
    localap.coC = ap.a.eV(paramString.ham);
    localap.coD = ap.b.eW(paramString.apptype);
    localap.ckH = paramString.han;
    if ((paramAppBrandPreloadProfiler.endTime == 9223372036854775807L) || (paramAppBrandPreloadProfiler.hbd == 9223372036854775807L))
    {
      l1 = 0L;
      localap.aP(l1);
      l1 = l2;
      if (paramAppBrandPreloadProfiler.hbf != 9223372036854775807L) {
        if (paramAppBrandPreloadProfiler.endTime != 9223372036854775807L) {
          break label160;
        }
      }
    }
    label160:
    for (long l1 = l2;; l1 = paramAppBrandPreloadProfiler.endTime - paramAppBrandPreloadProfiler.hbf)
    {
      localap.aQ(l1);
      localap.QX();
      return;
      l1 = paramAppBrandPreloadProfiler.endTime - paramAppBrandPreloadProfiler.hbd;
      break;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, com.tencent.mm.plugin.appbrand.report.a parama)
  {
    ae localae = new ae();
    if (!paramBoolean)
    {
      paramString = a.wg(paramString);
      if (paramString == null) {
        return;
      }
      localae.ckG = paramString.appId;
      localae.ckF = paramString.gKi;
      localae.ckI = ae.a.eA(paramString.ham);
      localae.ckJ = ae.b.eB(paramString.apptype);
      localae.ckH = paramString.han;
      localae.cic = paramString.scene;
    }
    long l;
    if (paramBoolean)
    {
      l = 1L;
      localae.ckN = l;
      localae.ar(paramLong);
      localae.uS();
      localae.aq(localae.ckM - paramLong);
      switch (1.gZX[parama.ordinal()])
      {
      default: 
        localae.ckO = 2147483647L;
      }
    }
    for (;;)
    {
      localae.QX();
      return;
      l = 0L;
      break;
      localae.ckO = 1L;
      continue;
      localae.ckO = 2L;
      continue;
      localae.ckO = 3L;
      continue;
      localae.ckO = 4L;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, g paramg)
  {
    ar localar = new ar();
    if (!paramBoolean)
    {
      paramString = a.wg(paramString);
      if (paramString == null) {
        return;
      }
      localar.ckG = paramString.appId;
      localar.ckF = paramString.gKi;
      localar.cpp = ar.a.eZ(paramString.ham);
      localar.cpq = ar.b.fa(paramString.apptype);
      localar.ckH = paramString.han;
      localar.cic = paramString.scene;
    }
    localar.aU(paramLong);
    localar.vc();
    localar.aT(localar.ckM - paramLong);
    if (paramBoolean)
    {
      paramLong = 1L;
      localar.ckN = paramLong;
      switch (1.gZW[paramg.ordinal()])
      {
      default: 
        localar.ckO = 2147483647L;
      }
    }
    for (;;)
    {
      localar.QX();
      return;
      paramLong = 0L;
      break;
      localar.ckO = 2L;
      continue;
      localar.ckO = 4L;
      continue;
      localar.ckO = 3L;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, long paramLong1, String paramString2, long paramLong2)
  {
    aj localaj = new aj();
    if (!paramBoolean)
    {
      paramString1 = a.wg(paramString1);
      if (paramString1 == null) {
        return;
      }
      localaj.ckG = paramString1.appId;
      localaj.ckF = paramString1.gKi;
      localaj.cmk = aj.a.eK(paramString1.ham);
      localaj.cml = aj.b.eL(paramString1.apptype);
      localaj.ckH = paramString1.han;
      localaj.cic = paramString1.scene;
    }
    localaj.aB(paramLong1);
    localaj.uX();
    localaj.aA(localaj.ckM - paramLong1);
    localaj.cmm = paramString2;
    localaj.clr = paramLong2;
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localaj.ckN = paramLong1;
      localaj.cmn = WxaCommLibRuntimeReader.getVersionName();
      localaj.QX();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */