package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;

public final class c
{
  public static void H(String paramString, int paramInt1, int paramInt2)
  {
    if ("@LibraryAppId".equals(paramString)) {
      return;
    }
    int i = 1000;
    String str = "";
    int n = 0;
    int m = 0;
    Object localObject;
    label54:
    int j;
    label71:
    int k;
    if (!bk.bl(paramString))
    {
      localObject = a.qp(paramString);
      if (localObject != null) {
        if (((AppBrandStatObject)localObject).scene == 0)
        {
          i = 1000;
          str = bk.pm(((AppBrandStatObject)localObject).bFv);
          j = ((AppBrandStatObject)localObject).gXG;
          localObject = a.qo(paramString);
          k = m;
          if (localObject != null)
          {
            k = m;
            if (((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS != null) {
              k = ((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS.fEN;
            }
          }
          m = paramInt2;
          if (paramInt2 == 0)
          {
            m = paramInt2;
            if (localObject != null)
            {
              m = paramInt2;
              if (((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS != null) {
                m = ((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS.fEM + 1;
              }
            }
          }
          n = vY(paramString);
          paramInt2 = m;
          m = k;
          k = j;
          j = n;
        }
      }
    }
    for (;;)
    {
      y.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", new Object[] { Integer.valueOf(13541), Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), Integer.valueOf(j) });
      h.nFQ.f(13541, new Object[] { Integer.valueOf(i), str, paramString, Integer.valueOf(m), Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(3), "", Integer.valueOf(j) });
      if ((TextUtils.isEmpty(str)) || (!str.contains("isWidget=1"))) {
        break;
      }
      f.f(paramInt1, paramString, str);
      return;
      i = ((AppBrandStatObject)localObject).scene;
      break label54;
      j = 0;
      break label71;
      j = 1000;
      k = 0;
      m = n;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    y.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", new Object[] { Integer.valueOf(13533), Integer.valueOf(paramInt1), bk.pm(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3 });
    h.nFQ.f(13533, new Object[] { Integer.valueOf(paramInt1), bk.pm(paramString1), Integer.valueOf(0), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(0), paramString4 });
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h.nFQ.f(14369, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(1) });
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject2 = cv(ae.getContext());
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = "unknown";
    }
    int j = vY(paramString);
    long l = bk.UX();
    y.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", new Object[] { Integer.valueOf(13537), Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean), Integer.valueOf(j) });
    localObject2 = h.nFQ;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((h)localObject2).f(13537, new Object[] { Integer.valueOf(1000), "", "", paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong, int paramInt2, int paramInt3)
  {
    AppBrandStatObject localAppBrandStatObject = a.qp(paramString1);
    if (localAppBrandStatObject == null)
    {
      y.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (!bk.bl(paramString2))
    {
      str1 = str2;
      if (paramString2.contains(".html")) {
        str1 = paramString2.substring(0, paramString2.lastIndexOf(".html") + 5);
      }
    }
    str2 = "";
    try
    {
      paramString2 = com.tencent.mm.compatible.util.q.encode(bk.pm(str1), "UTF-8");
      str2 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        String str3;
        y.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", new Object[] { paramString1 });
        y.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString2, "", new Object[0]);
        continue;
        int i = paramString2.fPS.fEN;
        continue;
        int j = paramString2.aej() + 1;
      }
    }
    paramString2 = a.qo(paramString1);
    if (paramString2 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label552;
      }
      j = 0;
      str3 = bk.pm(paramString3);
      paramString2 = str3;
      if (paramInt1 == 18)
      {
        paramString2 = str3;
        if (!bk.bl(paramString3))
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
      paramString3 = com.tencent.mm.compatible.util.q.encode(bk.pm(paramString2), "UTF-8");
      paramString2 = paramString3;
    }
    catch (UnsupportedEncodingException paramString3)
    {
      for (;;)
      {
        String str4;
        y.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
        y.printErrStackTrace("MicroMsg.AppBrandReporterManager", paramString3, "", new Object[0]);
      }
    }
    str4 = bk.pm(localAppBrandStatObject.bFv);
    paramString3 = null;
    try
    {
      str3 = bk.pm(a.qn(paramString1).aac().fJO);
      paramString3 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        y.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", new Object[] { paramString1, localException });
      }
    }
    if (localAppBrandStatObject.scene == 0) {
      localAppBrandStatObject.scene = 1000;
    }
    k = localAppBrandStatObject.caB;
    str3 = localAppBrandStatObject.caC;
    m = vY(paramString1);
    y.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", new Object[] { Integer.valueOf(13539), Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.gXG), str1, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
    h.nFQ.f(13539, new Object[] { Integer.valueOf(localAppBrandStatObject.scene), str4, paramString3, paramString1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localAppBrandStatObject.gXG), str2, Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), str3, Integer.valueOf(m) });
  }
  
  public static String cv(Context paramContext)
  {
    if (aq.isConnected(paramContext))
    {
      if (aq.isWifi(paramContext)) {
        return "wifi";
      }
      if (aq.is4G(paramContext)) {
        return "4g";
      }
      if (aq.is3G(paramContext)) {
        return "3g";
      }
      if (aq.is2G(paramContext)) {
        return "2g";
      }
      return "unknown";
    }
    return "offline";
  }
  
  public static int vY(String paramString)
  {
    if ("@LibraryAppId".equals(paramString)) {
      return 0;
    }
    int j = d.vZ(paramString);
    int i = j;
    Object localObject;
    if (j < 0)
    {
      if (!ae.cqV()) {
        break label82;
      }
      localObject = e.aaT().e(paramString, new String[] { "appInfo" });
      if (localObject == null) {
        break label69;
      }
      i = ((WxaAttributes)localObject).aen().dWx;
      d.aY(paramString, i);
    }
    for (;;)
    {
      return i + 1000;
      label69:
      y.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
      i = j;
      continue;
      label82:
      localObject = a.qn(paramString);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.i)localObject).ZA())
      {
        if (localObject == null) {
          break label118;
        }
        i = ((AppBrandInitConfig)localObject).bFB;
        d.aY(paramString, i);
        break;
      }
      label118:
      y.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(j) });
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */