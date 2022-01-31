package com.tencent.mm.game.report;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.game.report.a.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b
  extends com.tencent.mm.game.report.api.c
{
  static void b(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    long l1;
    if (paramGameWebPerformanceInfo.dCE > 0L) {
      l1 = paramGameWebPerformanceInfo.dCE - paramGameWebPerformanceInfo.startTime;
    }
    for (;;)
    {
      long l7 = paramGameWebPerformanceInfo.dCF - paramGameWebPerformanceInfo.startTime;
      int i;
      label41:
      long l3;
      long l2;
      long l5;
      long l4;
      long l8;
      long l9;
      long l10;
      long l11;
      long l6;
      long l12;
      long l13;
      long l14;
      long l15;
      long l16;
      long l17;
      int j;
      label254:
      Object localObject;
      if (paramGameWebPerformanceInfo.dCG > 0L)
      {
        i = 1;
        l3 = 0L;
        l2 = 0L;
        if (i == 1)
        {
          l3 = paramGameWebPerformanceInfo.dCG - paramGameWebPerformanceInfo.startTime;
          l2 = paramGameWebPerformanceInfo.dCH - paramGameWebPerformanceInfo.startTime;
        }
        l5 = 0L;
        l4 = 0L;
        if (paramGameWebPerformanceInfo.dCC == 1)
        {
          l5 = paramGameWebPerformanceInfo.dCI - paramGameWebPerformanceInfo.startTime;
          l4 = paramGameWebPerformanceInfo.dCJ - paramGameWebPerformanceInfo.startTime;
        }
        l8 = paramGameWebPerformanceInfo.dCK - paramGameWebPerformanceInfo.startTime;
        l9 = paramGameWebPerformanceInfo.dCL - paramGameWebPerformanceInfo.startTime;
        l10 = paramGameWebPerformanceInfo.dCM - paramGameWebPerformanceInfo.startTime;
        l11 = paramGameWebPerformanceInfo.dCN - paramGameWebPerformanceInfo.startTime;
        l6 = 0L;
        if (paramGameWebPerformanceInfo.dCO != 0L) {
          l6 = paramGameWebPerformanceInfo.dCO - paramGameWebPerformanceInfo.startTime;
        }
        l12 = paramGameWebPerformanceInfo.dCP - paramGameWebPerformanceInfo.startTime;
        l13 = paramGameWebPerformanceInfo.dCQ - paramGameWebPerformanceInfo.startTime;
        l14 = paramGameWebPerformanceInfo.dCR - paramGameWebPerformanceInfo.startTime;
        l15 = paramGameWebPerformanceInfo.dCS - paramGameWebPerformanceInfo.startTime;
        l16 = paramGameWebPerformanceInfo.dCT - paramGameWebPerformanceInfo.startTime;
        l17 = paramGameWebPerformanceInfo.dCV - paramGameWebPerformanceInfo.startTime;
        if (paramGameWebPerformanceInfo.dCR <= 0L) {
          break label758;
        }
        j = 1;
        localObject = paramGameWebPerformanceInfo.url;
        if (!bk.bl((String)localObject)) {
          break label763;
        }
        localObject = "";
        y.d("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", new Object[] { localObject, paramGameWebPerformanceInfo.dCD, Integer.valueOf(paramGameWebPerformanceInfo.dCA), Integer.valueOf(paramGameWebPerformanceInfo.dCB), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.dCC), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l7), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l6), Long.valueOf(l12), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(paramGameWebPerformanceInfo.dCU), Long.valueOf(l17) });
      }
      try
      {
        localObject = URLEncoder.encode((String)localObject, "utf-8");
        h.nFQ.f(16141, new Object[] { localObject, Integer.valueOf(paramGameWebPerformanceInfo.dCA), Integer.valueOf(paramGameWebPerformanceInfo.dCB), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.dCC), Long.valueOf(l1), Long.valueOf(l7), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l6), Long.valueOf(l12), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(paramGameWebPerformanceInfo.dCU), Long.valueOf(l17), Integer.valueOf(j), paramGameWebPerformanceInfo.dCD });
        return;
        l1 = 0L;
        continue;
        i = 0;
        break label41;
        label758:
        j = 0;
        break label254;
        label763:
        localObject = Uri.parse((String)localObject);
        localObject = ((Uri)localObject).getScheme() + "://" + ((Uri)localObject).getHost() + ((Uri)localObject).getPath();
        y.i("MicroMsg.GameReportImpl", "getDomainAndPath, newUrl: %s", new Object[] { localObject });
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          String str = "";
        }
      }
    }
  }
  
  public final void J(String paramString1, String paramString2)
  {
    h.nFQ.f(16171, new Object[] { Integer.valueOf(0), Integer.valueOf(1), paramString1, paramString2, Long.valueOf(0L) });
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, long paramLong, String paramString5)
  {
    y.d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString5 });
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    paramContext = g.by(paramString1, false);
    if (paramContext == null)
    {
      y.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
      return;
    }
    c.a(d.c(10531, new Object[] { paramString1, Integer.valueOf(a.B(localContext, paramString2)), a.BI(), paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(a.getNetworkType(localContext)), bk.pm(paramContext.field_packageName), bk.pm(paramContext.field_signature), Long.toString(paramLong), "", paramString5 }));
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    y.d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    c.a(d.c(10583, new Object[] { paramString1, Integer.valueOf(a.B(localContext, paramString2)), a.BI(), paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(a.getNetworkType(localContext)) }));
  }
  
  public final void a(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    if (paramGameWebPerformanceInfo == null)
    {
      y.e("MicroMsg.GameReportImpl", "info is null");
      return;
    }
    if (ae.cqV())
    {
      b(paramGameWebPerformanceInfo);
      return;
    }
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", paramGameWebPerformanceInfo, b.a.class, null);
  }
  
  public final void a(d paramd)
  {
    c.a(paramd);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    y.d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + paramString1 + ", appId = " + paramString2 + ", msgType = " + paramInt1 + ", scene = " + paramInt2 + ", actionName = " + paramString3);
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
      return;
    }
    h.nFQ.f(10546, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), a.BI(), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3) });
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong)
  {
    y.d("MicroMsg.GameReportImpl", "reportReadMsg, appId = " + paramString1);
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
      return;
    }
    String str = a.bv(paramLong);
    h.nFQ.f(10532, new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2) });
  }
  
  public final void f(String paramString, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + paramString + ", scene = " + paramInt1);
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
      return;
    }
    h.nFQ.f(10700, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void h(Context paramContext, String paramString1, String paramString2)
  {
    y.d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
      return;
    }
    h.nFQ.f(10534, new Object[] { paramString1, Integer.valueOf(a.B(paramContext, paramString2)), a.BI(), Long.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.GameReportImpl", "null open or null username");
      return;
    }
    h.nFQ.f(10738, new Object[] { paramString1, paramString2, paramString1, paramString3 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.game.report.b
 * JD-Core Version:    0.7.0.1
 */