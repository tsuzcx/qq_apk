package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ah.a;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.jsapi.x.f.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class h
{
  public static final String mrn = f.c.ljA.value;
  public static final String mro = f.c.ljz.value;
  public static final String mrp = f.c.ljv.value;
  public static final String mrq = f.c.ljw.value;
  public static final String mrr = f.c.ljx.value;
  
  public static void F(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(48064);
    AppBrandStatObject localAppBrandStatObject = com.tencent.mm.plugin.appbrand.a.Kl(paramString1);
    if (localAppBrandStatObject == null)
    {
      ad.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
      AppMethodBeat.o(48064);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.a.Kk(paramString1);
    if (localObject == null) {}
    for (int i = 0;; i = ((k)localObject).jYh.jIU + 1)
    {
      int j = Ui(paramString1);
      String str2 = bt.nullAsNil(localAppBrandStatObject.dkh);
      if (localAppBrandStatObject.scene == 0) {
        localAppBrandStatObject.scene = 1000;
      }
      long l = bt.aQJ();
      localObject = "";
      try
      {
        String str1 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString2), "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ad.e("MicroMsg.AppBrandReporterManager", "reportBackHome, encode page path error!, appId = %s", new Object[] { paramString1 });
          ad.printErrStackTrace("MicroMsg.AppBrandReporterManager", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      ad.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, appid : %s, appState : %d, pagePath : %s, actionTime : %s,  appType : %d", new Object[] { Integer.valueOf(18189), Integer.valueOf(localAppBrandStatObject.scene), str2, paramString1, Integer.valueOf(i), paramString2, Long.valueOf(l), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.g.yhR.f(18189, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(localAppBrandStatObject.scene), str2, localObject, Integer.valueOf(paramInt) });
      AppMethodBeat.o(48064);
      return;
    }
  }
  
  public static void S(String paramString, int paramInt1, int paramInt2)
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
    if (!bt.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.plugin.appbrand.a.Kl(paramString);
      if (localObject != null) {
        if (((AppBrandStatObject)localObject).scene == 0)
        {
          i = 1000;
          str = bt.nullAsNil(((AppBrandStatObject)localObject).dkh);
          j = ((AppBrandStatObject)localObject).mrx;
          localObject = com.tencent.mm.plugin.appbrand.a.Kk(paramString);
          k = m;
          if (localObject != null)
          {
            k = m;
            if (((k)localObject).jYh != null) {
              k = ((k)localObject).jYh.pkgVersion;
            }
          }
          m = paramInt2;
          if (paramInt2 == 0)
          {
            m = paramInt2;
            if (localObject != null)
            {
              m = paramInt2;
              if (((k)localObject).jYh != null) {
                m = ((k)localObject).jYh.jIU + 1;
              }
            }
          }
          n = Ui(paramString);
          paramInt2 = m;
          m = k;
          k = j;
          j = n;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", new Object[] { Integer.valueOf(13541), Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.g.yhR.f(13541, new Object[] { Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), "", Integer.valueOf(j) });
      if ((!TextUtils.isEmpty(str)) && (str.contains("isWidget=1"))) {
        f.n(paramInt1, paramString, str);
      }
      if (("wxb6d22f922f37b35a".equals(paramString)) && (paramInt2 <= 1)) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1089, paramInt1);
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
  
  public static int Ui(String paramString)
  {
    AppMethodBeat.i(48065);
    if ("@LibraryAppId".equals(paramString))
    {
      AppMethodBeat.o(48065);
      return 0;
    }
    int j = i.Uj(paramString);
    int i = j;
    Object localObject;
    if (j < 0)
    {
      if (!aj.cnC()) {
        break label95;
      }
      localObject = j.aYP().e(paramString, new String[] { "appInfo" });
      if (localObject == null) {
        break label83;
      }
      i = ((WxaAttributes)localObject).bel().cQN;
      i.bT(paramString, i);
    }
    for (;;)
    {
      AppMethodBeat.o(48065);
      return i + 1000;
      label83:
      ad.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
      i = j;
      continue;
      label95:
      localObject = com.tencent.mm.plugin.appbrand.a.Kj(paramString);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((o)localObject).aXc())
      {
        if (localObject == null) {
          break label131;
        }
        i = ((AppBrandInitConfigWC)localObject).cmr;
        i.bT(paramString, i);
        break;
      }
      label131:
      ad.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(j) });
      i = j;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48048);
    ad.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s  sceneNote %s", new Object[] { Integer.valueOf(13533), Integer.valueOf(paramInt1), bt.nullAsNil(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.g.yhR.f(13533, new Object[] { Integer.valueOf(paramInt1), bt.nullAsNil(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(0), paramString4 });
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
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(j, i, 1L, false);
          if (!paramBoolean1) {
            break label346;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(j, 7L, 1L, false);
        }
      }
      for (;;)
      {
        ad.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1) });
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
        label346:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(j, 0L, 1L, false);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(48061);
    a locala = a.mqo;
    a.f(14369, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    AppMethodBeat.o(48061);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(48049);
    Object localObject2 = q.dK(aj.getContext());
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = mrn;
    }
    int j = Ui(paramString);
    long l = bt.aQJ();
    ad.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", new Object[] { Integer.valueOf(13537), Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean), Integer.valueOf(j) });
    localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject2).f(13537, new Object[] { Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(48049);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, String paramString5, long paramLong, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(48051);
    i = 3;
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(48051);
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!bt.isNullOrNil(paramString4))
    {
      str1 = str2;
      if (paramString4.contains(".html")) {
        str1 = paramString4.substring(0, paramString4.lastIndexOf(".html") + 5);
      }
    }
    paramString4 = "";
    try
    {
      str2 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(str1), "UTF-8");
      paramString4 = str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int j;
        boolean bool;
        ad.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
        ad.printErrStackTrace("MicroMsg.AppBrandReporterManager", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        if (bool) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
    paramString3 = bt.nullAsNil(paramString3);
    paramString5 = bt.nullAsNil(paramString5);
    str2 = bt.nullAsNil(paramString2);
    j = Ui(paramString2);
    if (paramInt1 > 0)
    {
      i = paramInt1 - 1;
      bool = j.aYV().be(paramString1, i);
      if (j.aYW().bb(paramString1, i)) {
        i = 1;
      }
    }
    else
    {
      ad.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", new Object[] { Integer.valueOf(13540), Integer.valueOf(paramInt2), paramString3, str2, Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), str1, Integer.valueOf(paramInt3), paramString5, Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.g.yhR.f(13540, new Object[] { Integer.valueOf(paramInt2), paramString3, str2, Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt3), paramString5, Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(j) });
      AppMethodBeat.o(48051);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(48050);
    AppBrandStatObject localAppBrandStatObject = com.tencent.mm.plugin.appbrand.a.Kl(paramString1);
    if (localAppBrandStatObject == null)
    {
      ad.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
      AppMethodBeat.o(48050);
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!bt.isNullOrNil(paramString2))
    {
      str1 = str2;
      if (paramString2.contains(".html")) {
        str1 = paramString2.substring(0, paramString2.lastIndexOf(".html") + 5);
      }
    }
    str2 = "";
    try
    {
      paramString2 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(str1), "UTF-8");
      str2 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        String str3;
        ad.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", new Object[] { paramString1 });
        ad.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString2, "", new Object[0]);
        continue;
        int i = paramString2.jYh.pkgVersion;
        continue;
        int j = paramString2.jYh.jIU + 1;
      }
    }
    paramString2 = com.tencent.mm.plugin.appbrand.a.Kk(paramString1);
    if (paramString2 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label576;
      }
      j = 0;
      str3 = bt.nullAsNil(paramString3);
      paramString2 = str3;
      if (paramInt1 == 18)
      {
        paramString2 = str3;
        if (!bt.isNullOrNil(paramString3))
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
      paramString3 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString2), "UTF-8");
      paramString2 = paramString3;
    }
    catch (UnsupportedEncodingException paramString3)
    {
      for (;;)
      {
        String str4;
        ad.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
        ad.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString3, "", new Object[0]);
      }
    }
    str4 = bt.nullAsNil(localAppBrandStatObject.dkh);
    paramString3 = null;
    try
    {
      str3 = bt.nullAsNil(com.tencent.mm.plugin.appbrand.a.Kj(paramString1).aXc().Ec());
      paramString3 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        ad.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", new Object[] { paramString1, localException });
      }
    }
    if (localAppBrandStatObject.scene == 0) {
      localAppBrandStatObject.scene = 1000;
    }
    k = localAppBrandStatObject.dJQ;
    str3 = localAppBrandStatObject.dJR;
    m = Ui(paramString1);
    ad.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", new Object[] { Integer.valueOf(13539), Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.mrx), str1, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    com.tencent.mm.plugin.report.service.g.yhR.f(13539, new Object[] { Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.mrx), str2, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    AppMethodBeat.o(48050);
  }
  
  public static void aq(int paramInt, String paramString)
  {
    AppMethodBeat.i(48054);
    List localList = ((ah)com.tencent.mm.kernel.g.ab(ah.class)).a(2147483647, ah.a.jPV);
    StringBuilder localStringBuilder = new StringBuilder();
    localList = b.C(localList);
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
    ad.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] scene=".concat(String.valueOf(paramInt)));
    ad.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] appIdStr=".concat(String.valueOf(localStringBuilder)));
    ad.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] sceneNote=".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.g.yhR.f(13800, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((ah)com.tencent.mm.kernel.g.ab(ah.class)).getCount()), localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(48054);
  }
  
  public static void ar(int paramInt, String paramString)
  {
    AppMethodBeat.i(48062);
    com.tencent.mm.plugin.report.service.g.yhR.f(15651, new Object[] { Integer.valueOf(paramInt), bt.nullAsNil(paramString) });
    AppMethodBeat.o(48062);
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(48060);
    a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, 1L);
    AppMethodBeat.o(48060);
  }
  
  public static void bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(48052);
    S(paramString, paramInt, 0);
    AppMethodBeat.o(48052);
  }
  
  public static void bxj()
  {
    AppMethodBeat.i(48055);
    aq(2, "");
    AppMethodBeat.o(48055);
  }
  
  public static void bxk()
  {
    AppMethodBeat.i(48057);
    int i = bt.jo(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca);
    ad.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[] { Integer.valueOf(bt.jo(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca)) });
    if (i <= 90) {
      i = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, i, 1L, false);
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
  
  public static String getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(48047);
    paramContext = q.dK(paramContext);
    AppMethodBeat.o(48047);
    return paramContext;
  }
  
  public static void hy(boolean paramBoolean)
  {
    AppMethodBeat.i(48059);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      localg.a(482, 482, 1, i, 1, 1, false);
      AppMethodBeat.o(48059);
      return;
    }
  }
  
  public static void u(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(188713);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(188713);
      return;
    case 10: 
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 13L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 8L, 1L, false);
        AppMethodBeat.o(188713);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 12L, 1L, false);
      }
    case 15: 
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 11L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 7L, 1L, false);
        AppMethodBeat.o(188713);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 10L, 1L, false);
      }
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 15L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 9L, 1L, false);
      break;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(386L, 14L, 1L, false);
    }
  }
  
  public static void vh(int paramInt)
  {
    AppMethodBeat.i(48063);
    com.tencent.mm.plugin.report.service.g.yhR.dD(891, paramInt);
    AppMethodBeat.o(48063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */