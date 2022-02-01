package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.l.b;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.share.y;
import com.tencent.mm.plugin.appbrand.jsapi.share.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class j
{
  public static final String tNY = k.c.swQ.value;
  public static final String tNZ = k.c.swP.value;
  public static final String tOa = k.c.swL.value;
  public static final String tOb = k.c.swM.value;
  public static final String tOc = k.c.swN.value;
  public static final String tOd = k.c.swO.value;
  
  public static void CZ(int paramInt)
  {
    AppMethodBeat.i(48063);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(891, paramInt);
    AppMethodBeat.o(48063);
  }
  
  public static void N(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(48064);
    AppBrandStatObject localAppBrandStatObject = d.Ue(paramString1);
    if (localAppBrandStatObject == null)
    {
      Log.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
      AppMethodBeat.o(48064);
      return;
    }
    Object localObject = d.Ud(paramString1);
    if (localObject == null) {}
    for (int i = 0;; i = ((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY.qHO + 1)
    {
      int j = afN(paramString1);
      String str2 = Util.nullAsNil(localAppBrandStatObject.hzx);
      if (localAppBrandStatObject.scene == 0) {
        localAppBrandStatObject.scene = 1000;
      }
      long l = Util.nowSecond();
      localObject = "";
      try
      {
        String str1 = r.as(Util.nullAsNil(paramString2), "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrandReporterManager", "reportBackHome, encode page path error!, appId = %s", new Object[] { paramString1 });
          Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, appid : %s, appState : %d, pagePath : %s, actionTime : %s,  appType : %d", new Object[] { Integer.valueOf(18189), Integer.valueOf(localAppBrandStatObject.scene), str2, paramString1, Integer.valueOf(i), paramString2, Long.valueOf(l), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.OAn.b(18189, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(localAppBrandStatObject.scene), str2, localObject, Integer.valueOf(paramInt) });
      AppMethodBeat.o(48064);
      return;
    }
  }
  
  public static void Z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48053);
    if ("@LibraryAppId".equals(paramString))
    {
      AppMethodBeat.o(48053);
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
    if (!Util.isNullOrNil(paramString))
    {
      localObject = d.Ue(paramString);
      if (localObject != null) {
        if (((AppBrandStatObject)localObject).scene == 0)
        {
          i = 1000;
          str = Util.nullAsNil(((AppBrandStatObject)localObject).hzx);
          j = ((AppBrandStatObject)localObject).tOj;
          localObject = d.Ud(paramString);
          k = m;
          if (localObject != null)
          {
            k = m;
            if (((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY != null) {
              k = ((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY.pkgVersion;
            }
          }
          m = paramInt2;
          if (paramInt2 == 0)
          {
            m = paramInt2;
            if (localObject != null)
            {
              m = paramInt2;
              if (((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY != null) {
                m = ((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY.qHO + 1;
              }
            }
          }
          n = afN(paramString);
          paramInt2 = m;
          m = k;
          k = j;
          j = n;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", new Object[] { Integer.valueOf(13541), Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.OAn.b(13541, new Object[] { Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), "", Integer.valueOf(j) });
      if ((!TextUtils.isEmpty(str)) && (str.contains("isWidget=1"))) {
        f.r(paramInt1, paramString, str);
      }
      if (("wxb6d22f922f37b35a".equals(paramString)) && (paramInt2 <= 1)) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1089, paramInt1);
      }
      AppMethodBeat.o(48053);
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
    AppMethodBeat.i(48048);
    Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s  sceneNote %s", new Object[] { Integer.valueOf(13533), Integer.valueOf(paramInt1), Util.nullAsNil(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.h.OAn.b(13533, new Object[] { Integer.valueOf(paramInt1), Util.nullAsNil(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(0), paramString4 });
    AppMethodBeat.o(48048);
  }
  
  public static void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(48056);
    if (paramBoolean2) {}
    for (int j = 775;; j = 367)
    {
      int i;
      if (paramLong <= 2000L) {
        if (paramBoolean1)
        {
          i = 8;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(j, i, 1L, false);
          if (!paramBoolean1) {
            break label343;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(j, 7L, 1L, false);
        }
      }
      for (;;)
      {
        Log.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1) });
        AppMethodBeat.o(48056);
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
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(j, 0L, 1L, false);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(48061);
    a.tMQ.b(14369, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    AppMethodBeat.o(48061);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(48049);
    Object localObject2 = w.fg(MMApplicationContext.getContext());
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = tNY;
    }
    int j = afN(paramString);
    long l = Util.nowSecond();
    Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", new Object[] { Integer.valueOf(13537), Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean), Integer.valueOf(j) });
    localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(13537, new Object[] { Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(48049);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong, int paramInt5, int paramInt6, String paramString6)
  {
    AppMethodBeat.i(321393);
    i = 3;
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(321393);
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!Util.isNullOrNil(paramString4))
    {
      str1 = str2;
      if (paramString4.contains(".html")) {
        str1 = paramString4.substring(0, paramString4.lastIndexOf(".html") + 5);
      }
    }
    paramString4 = "";
    try
    {
      str2 = r.as(Util.nullAsNil(str1), "UTF-8");
      paramString4 = str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int k;
        boolean bool;
        y localy;
        int j;
        String str3;
        Log.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
        Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        if (bool)
        {
          i = 2;
        }
        else
        {
          i = 3;
          continue;
          j = localy.svF;
          continue;
          paramString1 = localy.svG;
          continue;
          paramString1 = localy.svH;
          continue;
          paramString1 = localy.svI;
        }
      }
    }
    paramString3 = Util.nullAsNil(paramString3);
    paramString5 = Util.nullAsNil(paramString5);
    str2 = Util.nullAsNil(paramString2);
    k = afN(paramString2);
    if (paramInt2 > 0)
    {
      i = paramInt2 - 1;
      bool = com.tencent.mm.plugin.appbrand.app.n.cfk().bX(paramString1, i);
      if (com.tencent.mm.plugin.appbrand.app.n.cfl().bU(paramString1, i)) {
        i = 1;
      }
    }
    else
    {
      localy = z.abE(paramString6);
      if (localy != null) {
        break label557;
      }
      j = 0;
      if (localy != null) {
        break label567;
      }
      paramString1 = "";
      paramString2 = Util.nullAsNil(paramString1);
      if (localy != null) {
        break label576;
      }
      paramString1 = "";
      str3 = r.cg(Util.nullAsNil(paramString1));
      if (localy != null) {
        break label585;
      }
      paramString1 = "";
      paramString1 = r.cg(Util.nullAsNil(paramString1));
      Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d,shareActionId:%s, shareActionType:%d, shareTitle:%s, sharePath:%s, shareImgUrl:%s", new Object[] { Integer.valueOf(13540), Integer.valueOf(paramInt3), paramString3, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), str1, Integer.valueOf(paramInt4), paramString5, Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(k), paramString6, Integer.valueOf(j), paramString2, str3, paramString1 });
      com.tencent.mm.plugin.report.service.h.OAn.b(13540, new Object[] { Integer.valueOf(paramInt3), paramString3, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt4), paramString5, Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(k), paramString6, Integer.valueOf(j), paramString2, str3, paramString1 });
      AppMethodBeat.o(321393);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(48050);
    AppBrandStatObject localAppBrandStatObject = d.Ue(paramString1);
    if (localAppBrandStatObject == null)
    {
      Log.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
      AppMethodBeat.o(48050);
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!Util.isNullOrNil(paramString2))
    {
      str1 = str2;
      if (paramString2.contains(".html")) {
        str1 = paramString2.substring(0, paramString2.lastIndexOf(".html") + 5);
      }
    }
    str2 = "";
    try
    {
      paramString2 = r.as(Util.nullAsNil(str1), "UTF-8");
      str2 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        String str3;
        Log.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", new Object[] { paramString1 });
        Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString2, "", new Object[0]);
        continue;
        int i = paramString2.qYY.pkgVersion;
        continue;
        int j = paramString2.qYY.qHO + 1;
      }
    }
    paramString2 = d.Ud(paramString1);
    if (paramString2 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label576;
      }
      j = 0;
      str3 = Util.nullAsNil(paramString3);
      paramString2 = str3;
      if (paramInt1 == 18)
      {
        paramString2 = str3;
        if (!Util.isNullOrNil(paramString3))
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
      paramString3 = r.as(Util.nullAsNil(paramString2), "UTF-8");
      paramString2 = paramString3;
    }
    catch (UnsupportedEncodingException paramString3)
    {
      for (;;)
      {
        String str4;
        Log.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
        Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString3, "", new Object[0]);
      }
    }
    str4 = Util.nullAsNil(localAppBrandStatObject.hzx);
    paramString3 = null;
    try
    {
      str3 = Util.nullAsNil(d.Uc(paramString1).getInitConfig().eoP);
      paramString3 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        Log.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", new Object[] { paramString1, localException });
      }
    }
    if (localAppBrandStatObject.scene == 0) {
      localAppBrandStatObject.scene = 1000;
    }
    k = localAppBrandStatObject.icZ;
    str3 = localAppBrandStatObject.ida;
    m = afN(paramString1);
    Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", new Object[] { Integer.valueOf(13539), Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.tOj), str1, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    com.tencent.mm.plugin.report.service.h.OAn.b(13539, new Object[] { Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.tOj), str2, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    AppMethodBeat.o(48050);
  }
  
  public static void aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(48054);
    List localList = ((com.tencent.mm.plugin.appbrand.appusage.af)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appusage.af.class)).a(2147483647, af.a.qPX);
    StringBuilder localStringBuilder = new StringBuilder();
    localList = b.bb(localList);
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
    Log.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] scene=".concat(String.valueOf(paramInt)));
    Log.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] appIdStr=".concat(String.valueOf(localStringBuilder)));
    Log.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] sceneNote=".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.h.OAn.b(13800, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.appbrand.appusage.af)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appusage.af.class)).getCount()), localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(48054);
  }
  
  public static void aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(48062);
    com.tencent.mm.plugin.report.service.h.OAn.b(15651, new Object[] { Integer.valueOf(paramInt), Util.nullAsNil(paramString) });
    AppMethodBeat.o(48062);
  }
  
  public static int afN(String paramString)
  {
    AppMethodBeat.i(48065);
    if ("@LibraryAppId".equals(paramString))
    {
      AppMethodBeat.o(48065);
      return 0;
    }
    int j = k.afP(paramString);
    String str = afO(paramString);
    int i = j;
    if (j < 0)
    {
      if (!MMApplicationContext.isMMProcess()) {
        break label105;
      }
      paramString = com.tencent.mm.plugin.appbrand.app.n.cfc().e(str, new String[] { "appInfo" });
      if (paramString == null) {
        break label92;
      }
      i = paramString.cld().serviceType;
      k.df(str, i);
    }
    for (;;)
    {
      AppMethodBeat.o(48065);
      return i + 1000;
      label92:
      Log.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
      i = j;
      continue;
      label105:
      paramString = d.Uc(str);
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.getInitConfig())
      {
        if (paramString == null) {
          break label141;
        }
        i = paramString.appServiceType;
        k.df(str, i);
        break;
      }
      label141:
      Log.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(j) });
      i = j;
    }
  }
  
  private static String afO(String paramString)
  {
    AppMethodBeat.i(321460);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(321460);
      return paramString;
    }
    int i = paramString.indexOf('$');
    if (i >= 0)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(321460);
      return paramString;
    }
    AppMethodBeat.o(321460);
    return paramString;
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(48060);
    a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, 1L);
    AppMethodBeat.o(48060);
  }
  
  public static void cIx()
  {
    AppMethodBeat.i(48055);
    aG(2, "");
    AppMethodBeat.o(48055);
  }
  
  public static void cIy()
  {
    AppMethodBeat.i(48057);
    int i = Util.getSelfMemInMB(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP);
    Log.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[] { Integer.valueOf(i) });
    if (i <= 90) {
      i = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, i, 1L, false);
      AppMethodBeat.o(48057);
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
  
  public static void de(String paramString, int paramInt)
  {
    AppMethodBeat.i(48052);
    Z(paramString, paramInt, 0);
    AppMethodBeat.o(48052);
  }
  
  public static String getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(48047);
    paramContext = w.fg(paramContext);
    AppMethodBeat.o(48047);
    return paramContext;
  }
  
  public static void w(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(321431);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(321431);
      return;
    case 10: 
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 13L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 8L, 1L, false);
        AppMethodBeat.o(321431);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 12L, 1L, false);
      }
    case 15: 
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 11L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 7L, 1L, false);
        AppMethodBeat.o(321431);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 10L, 1L, false);
      }
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 15L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 9L, 1L, false);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(386L, 14L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j
 * JD-Core Version:    0.7.0.1
 */