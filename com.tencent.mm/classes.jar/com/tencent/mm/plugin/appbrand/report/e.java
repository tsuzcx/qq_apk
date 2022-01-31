package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.jsapi.r.d.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class e
{
  public static final String iFN = d.a.iaO.value;
  public static final String iFO = d.a.iaN.value;
  public static final String iFP = d.a.iaK.value;
  public static final String iFQ = d.a.iaL.value;
  public static final String iFR = d.a.iaM.value;
  
  public static int ED(String paramString)
  {
    AppMethodBeat.i(132562);
    if ("@LibraryAppId".equals(paramString))
    {
      AppMethodBeat.o(132562);
      return 0;
    }
    int j = f.EE(paramString);
    int i = j;
    Object localObject;
    if (j < 0)
    {
      if (!ah.brt()) {
        break label95;
      }
      localObject = com.tencent.mm.plugin.appbrand.app.g.auF().e(paramString, new String[] { "appInfo" });
      if (localObject == null) {
        break label83;
      }
      i = ((WxaAttributes)localObject).ayC().fmF;
      f.br(paramString, i);
    }
    for (;;)
    {
      AppMethodBeat.o(132562);
      return i + 1000;
      label83:
      ab.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
      i = j;
      continue;
      label95:
      localObject = a.xL(paramString);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((o)localObject).atS())
      {
        if (localObject == null) {
          break label131;
        }
        i = ((AppBrandInitConfigWC)localObject).bCV;
        f.br(paramString, i);
        break;
      }
      label131:
      ab.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(j) });
      i = j;
    }
  }
  
  public static void U(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132552);
    if ("@LibraryAppId".equals(paramString))
    {
      AppMethodBeat.o(132552);
      return;
    }
    int i = 1000;
    String str = "";
    int n = 0;
    int m = 0;
    Object localObject;
    int j;
    label81:
    int k;
    if (!bo.isNullOrNil(paramString))
    {
      localObject = a.xN(paramString);
      if (localObject != null) {
        if (((AppBrandStatObject)localObject).scene == 0)
        {
          i = 1000;
          str = bo.nullAsNil(((AppBrandStatObject)localObject).cmF);
          j = ((AppBrandStatObject)localObject).iFX;
          localObject = a.xM(paramString);
          k = m;
          if (localObject != null)
          {
            k = m;
            if (((com.tencent.mm.plugin.appbrand.config.h)localObject).hiX != null) {
              k = ((com.tencent.mm.plugin.appbrand.config.h)localObject).hiX.gXf;
            }
          }
          m = paramInt2;
          if (paramInt2 == 0)
          {
            m = paramInt2;
            if (localObject != null)
            {
              m = paramInt2;
              if (((com.tencent.mm.plugin.appbrand.config.h)localObject).hiX != null) {
                m = ((com.tencent.mm.plugin.appbrand.config.h)localObject).hiX.gXe + 1;
              }
            }
          }
          n = ED(paramString);
          paramInt2 = m;
          m = k;
          k = j;
          j = n;
        }
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", new Object[] { Integer.valueOf(13541), Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.qsU.e(13541, new Object[] { Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), "", Integer.valueOf(j) });
      if ((!TextUtils.isEmpty(str)) && (str.contains("isWidget=1"))) {
        com.tencent.mm.plugin.appbrand.dynamic.f.n(paramInt1, paramString, str);
      }
      if (("wxb6d22f922f37b35a".equals(paramString)) && (paramInt2 <= 1)) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(1089, paramInt1);
      }
      AppMethodBeat.o(132552);
      return;
      i = ((AppBrandStatObject)localObject).scene;
      break;
      j = 0;
      break label81;
      j = 1000;
      k = 0;
      m = n;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(132547);
    ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", new Object[] { Integer.valueOf(13533), Integer.valueOf(paramInt1), bo.nullAsNil(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3 });
    com.tencent.mm.plugin.report.service.h.qsU.e(13533, new Object[] { Integer.valueOf(paramInt1), bo.nullAsNil(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(0), paramString4 });
    AppMethodBeat.o(132547);
  }
  
  public static void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(132554);
    if (paramBoolean2) {}
    for (int j = 775;; j = 367)
    {
      int i;
      if (paramLong <= 2000L) {
        if (paramBoolean1)
        {
          i = 8;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(j, i, 1L, false);
          if (!paramBoolean1) {
            break label343;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(j, 7L, 1L, false);
        }
      }
      for (;;)
      {
        ab.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1) });
        AppMethodBeat.o(132554);
        return;
        i = 1;
        break;
        if (paramLong <= 3000L)
        {
          if (paramBoolean1)
          {
            i = 9;
            break;
          }
          i = 2;
          break;
        }
        if (paramLong <= 4000L)
        {
          if (paramBoolean1)
          {
            i = 10;
            break;
          }
          i = 3;
          break;
        }
        if (paramLong <= 5000L)
        {
          if (paramBoolean1)
          {
            i = 11;
            break;
          }
          i = 4;
          break;
        }
        if (paramLong <= 6000L)
        {
          if (paramBoolean1)
          {
            i = 12;
            break;
          }
          i = 5;
          break;
        }
        if (paramBoolean2)
        {
          if (paramLong <= 7000L)
          {
            if (paramBoolean1)
            {
              i = 19;
              break;
            }
            i = 14;
            break;
          }
          if (paramLong <= 8000L)
          {
            if (paramBoolean1)
            {
              i = 20;
              break;
            }
            i = 15;
            break;
          }
          if (paramLong <= 9000L)
          {
            if (paramBoolean1)
            {
              i = 21;
              break;
            }
            i = 16;
            break;
          }
          if (paramLong <= 10000L)
          {
            if (paramBoolean1)
            {
              i = 22;
              break;
            }
            i = 17;
            break;
          }
          if (paramBoolean1)
          {
            i = 23;
            break;
          }
          i = 18;
          break;
        }
        if (paramBoolean1)
        {
          i = 13;
          break;
        }
        i = 6;
        break;
        label343:
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(j, 0L, 1L, false);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(154856);
    com.tencent.mm.plugin.report.service.h.qsU.e(14369, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    AppMethodBeat.o(154856);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(132548);
    Object localObject2 = m.da(ah.getContext());
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = iFN;
    }
    int j = ED(paramString);
    long l = bo.aox();
    ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", new Object[] { Integer.valueOf(13537), Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean), Integer.valueOf(j) });
    localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).e(13537, new Object[] { Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(132548);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, String paramString5, long paramLong, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(132550);
    i = 3;
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(132550);
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!bo.isNullOrNil(paramString4))
    {
      str1 = str2;
      if (paramString4.contains(".html")) {
        str1 = paramString4.substring(0, paramString4.lastIndexOf(".html") + 5);
      }
    }
    paramString4 = "";
    try
    {
      str2 = q.encode(bo.nullAsNil(str1), "UTF-8");
      paramString4 = str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int j;
        boolean bool;
        ab.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
        ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        if (bool) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
    paramString3 = bo.nullAsNil(paramString3);
    paramString5 = bo.nullAsNil(paramString5);
    str2 = bo.nullAsNil(paramString2);
    j = ED(paramString2);
    if (paramInt1 > 0)
    {
      i = paramInt1 - 1;
      bool = com.tencent.mm.plugin.appbrand.app.g.auK().aJ(paramString1, i);
      if (com.tencent.mm.plugin.appbrand.app.g.auL().aG(paramString1, i)) {
        i = 1;
      }
    }
    else
    {
      ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", new Object[] { Integer.valueOf(13540), Integer.valueOf(paramInt2), paramString3, str2, Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), str1, Integer.valueOf(paramInt3), paramString5, Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.qsU.e(13540, new Object[] { Integer.valueOf(paramInt2), paramString3, str2, Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt3), paramString5, Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(j) });
      AppMethodBeat.o(132550);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(132549);
    AppBrandStatObject localAppBrandStatObject = a.xN(paramString1);
    if (localAppBrandStatObject == null)
    {
      ab.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
      AppMethodBeat.o(132549);
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!bo.isNullOrNil(paramString2))
    {
      str1 = str2;
      if (paramString2.contains(".html")) {
        str1 = paramString2.substring(0, paramString2.lastIndexOf(".html") + 5);
      }
    }
    str2 = "";
    try
    {
      paramString2 = q.encode(bo.nullAsNil(str1), "UTF-8");
      str2 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        String str3;
        ab.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", new Object[] { paramString1 });
        ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString2, "", new Object[0]);
        continue;
        int i = paramString2.hiX.gXf;
        continue;
        int j = paramString2.hiX.gXe + 1;
      }
    }
    paramString2 = a.xM(paramString1);
    if (paramString2 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label579;
      }
      j = 0;
      str3 = bo.nullAsNil(paramString3);
      paramString2 = str3;
      if (paramInt1 == 18)
      {
        paramString2 = str3;
        if (!bo.isNullOrNil(paramString3))
        {
          paramString2 = str3;
          if (paramString3.contains(".html")) {
            paramString2 = paramString3.substring(0, paramString3.lastIndexOf(".html") + 5);
          }
        }
      }
    }
    try
    {
      paramString3 = q.encode(bo.nullAsNil(paramString2), "UTF-8");
      paramString2 = paramString3;
    }
    catch (UnsupportedEncodingException paramString3)
    {
      for (;;)
      {
        String str4;
        ab.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
        ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString3, "", new Object[0]);
      }
    }
    str4 = bo.nullAsNil(localAppBrandStatObject.cmF);
    paramString3 = null;
    try
    {
      str3 = bo.nullAsNil(a.xL(paramString1).atS().vZ());
      paramString3 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        ab.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", new Object[] { paramString1, localException });
      }
    }
    if (localAppBrandStatObject.scene == 0) {
      localAppBrandStatObject.scene = 1000;
    }
    k = localAppBrandStatObject.cJb;
    str3 = localAppBrandStatObject.cJc;
    m = ED(paramString1);
    ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", new Object[] { Integer.valueOf(13539), Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.iFX), str1, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    com.tencent.mm.plugin.report.service.h.qsU.e(13539, new Object[] { Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.iFX), str2, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    AppMethodBeat.o(132549);
  }
  
  public static void aKX()
  {
    AppMethodBeat.i(132555);
    int i = bo.hp(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).bX);
    ab.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[] { Integer.valueOf(bo.hp(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).bX)) });
    if (i <= 90) {
      i = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(386L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(386L, i, 1L, false);
      AppMethodBeat.o(132555);
      return;
      if (i <= 130) {
        i = 3;
      } else if (i <= 170) {
        i = 4;
      } else if (i <= 210) {
        i = 5;
      } else {
        i = 6;
      }
    }
  }
  
  public static void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(132560);
    com.tencent.mm.plugin.report.service.h.qsU.e(15651, new Object[] { Integer.valueOf(paramInt), bo.nullAsNil(paramString) });
    AppMethodBeat.o(132560);
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(132558);
    a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, 1L);
    AppMethodBeat.o(132558);
  }
  
  public static void bq(String paramString, int paramInt)
  {
    AppMethodBeat.i(132551);
    U(paramString, paramInt, 0);
    AppMethodBeat.o(132551);
  }
  
  public static String cZ(Context paramContext)
  {
    AppMethodBeat.i(132546);
    paramContext = m.da(paramContext);
    AppMethodBeat.o(132546);
    return paramContext;
  }
  
  public static void eL(boolean paramBoolean)
  {
    AppMethodBeat.i(132557);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      localh.a(482, 482, 1, i, 1, 1, false);
      AppMethodBeat.o(132557);
      return;
    }
  }
  
  public static void ps(int paramInt)
  {
    AppMethodBeat.i(132553);
    List localList = ((af)com.tencent.mm.kernel.g.E(af.class)).a(2147483647, af.a.hcJ);
    StringBuilder localStringBuilder = new StringBuilder();
    localList = c.A(localList);
    localList = localList.subList(0, Math.min(20, localList.size()));
    int i = 0;
    while (i < localList.size())
    {
      localStringBuilder.append(((LocalUsageInfo)localList.get(i)).appId);
      if (i != localList.size() - 1) {
        localStringBuilder.append("#");
      }
      i += 1;
    }
    ab.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] scene=".concat(String.valueOf(paramInt)));
    ab.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] appIdStr=".concat(String.valueOf(localStringBuilder)));
    com.tencent.mm.plugin.report.service.h.qsU.e(13800, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((af)com.tencent.mm.kernel.g.E(af.class)).getCount()), localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(132553);
  }
  
  public static void pt(int paramInt)
  {
    AppMethodBeat.i(132556);
    if (paramInt == 10)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(386L, 8L, 1L, false);
      AppMethodBeat.o(132556);
      return;
    }
    if (paramInt == 15) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(386L, 7L, 1L, false);
    }
    AppMethodBeat.o(132556);
  }
  
  public static void pu(int paramInt)
  {
    AppMethodBeat.i(132561);
    com.tencent.mm.plugin.report.service.h.qsU.cT(891, paramInt);
    AppMethodBeat.o(132561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e
 * JD-Core Version:    0.7.0.1
 */