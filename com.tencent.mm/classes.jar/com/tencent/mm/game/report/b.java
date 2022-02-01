package com.tencent.mm.game.report;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b
  extends com.tencent.mm.game.report.api.a
{
  static void b(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    AppMethodBeat.i(108251);
    ae.i("MicroMsg.GameReportImpl", "reportWebPerformanceInMM, %s", new Object[] { paramGameWebPerformanceInfo.toString() });
    long l4;
    long l13;
    int i;
    label70:
    long l6;
    long l5;
    long l8;
    long l7;
    long l14;
    long l15;
    long l16;
    long l17;
    long l1;
    long l2;
    long l18;
    long l9;
    label273:
    int j;
    if (paramGameWebPerformanceInfo.guP - paramGameWebPerformanceInfo.startTime > 0L)
    {
      l4 = paramGameWebPerformanceInfo.guP - paramGameWebPerformanceInfo.startTime;
      l13 = paramGameWebPerformanceInfo.guQ - paramGameWebPerformanceInfo.startTime;
      if (paramGameWebPerformanceInfo.guR <= 0L) {
        break label1041;
      }
      i = 1;
      l6 = 0L;
      l5 = 0L;
      if (i == 1)
      {
        l6 = paramGameWebPerformanceInfo.guR - paramGameWebPerformanceInfo.startTime;
        l5 = paramGameWebPerformanceInfo.guS - paramGameWebPerformanceInfo.startTime;
      }
      l8 = 0L;
      l7 = 0L;
      if (paramGameWebPerformanceInfo.guI == 1)
      {
        l8 = paramGameWebPerformanceInfo.guT - paramGameWebPerformanceInfo.startTime;
        l7 = paramGameWebPerformanceInfo.guU - paramGameWebPerformanceInfo.startTime;
      }
      l14 = paramGameWebPerformanceInfo.guV - paramGameWebPerformanceInfo.startTime;
      l15 = paramGameWebPerformanceInfo.guW - paramGameWebPerformanceInfo.startTime;
      l16 = paramGameWebPerformanceInfo.guX - paramGameWebPerformanceInfo.startTime;
      l17 = paramGameWebPerformanceInfo.guY - paramGameWebPerformanceInfo.startTime;
      l1 = 0L;
      if (paramGameWebPerformanceInfo.guZ != 0L)
      {
        l2 = paramGameWebPerformanceInfo.guZ - paramGameWebPerformanceInfo.startTime;
        l1 = l2;
        if (paramGameWebPerformanceInfo.guI == 0)
        {
          l1 = l2;
          if (l2 < 0L) {
            l1 = -1L;
          }
        }
      }
      l18 = paramGameWebPerformanceInfo.gva - paramGameWebPerformanceInfo.startTime;
      l2 = paramGameWebPerformanceInfo.gvb - paramGameWebPerformanceInfo.startTime;
      l9 = l2;
      if (paramGameWebPerformanceInfo.guI == 0)
      {
        if (l2 <= 0L) {
          break label1046;
        }
        l9 = l2;
      }
      if (paramGameWebPerformanceInfo.gvc <= 0L) {
        break label1054;
      }
      j = 1;
      label284:
      l2 = paramGameWebPerformanceInfo.gvc - paramGameWebPerformanceInfo.startTime;
      if (j == 0) {
        break label1059;
      }
      l10 = l2;
      if (paramGameWebPerformanceInfo.guI == 0) {
        if (l2 <= 0L) {
          break label1059;
        }
      }
    }
    label660:
    label1046:
    label1054:
    label1059:
    for (long l10 = l2;; l10 = -1L)
    {
      long l11 = 0L;
      long l3 = 0L;
      if (paramGameWebPerformanceInfo.guK == 0)
      {
        l3 = paramGameWebPerformanceInfo.gvd - paramGameWebPerformanceInfo.startTime;
        l2 = l3;
        if (l3 <= 0L) {
          l2 = -1L;
        }
        long l12 = paramGameWebPerformanceInfo.gve - paramGameWebPerformanceInfo.startTime;
        l11 = l2;
        l3 = l12;
        if (l12 <= 0L)
        {
          l3 = -1L;
          l11 = l2;
        }
      }
      l2 = paramGameWebPerformanceInfo.gvg - paramGameWebPerformanceInfo.startTime;
      ae.i("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", new Object[] { paramGameWebPerformanceInfo.url, paramGameWebPerformanceInfo.guO, Integer.valueOf(paramGameWebPerformanceInfo.guG), Integer.valueOf(paramGameWebPerformanceInfo.guH), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.guI), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l13), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l8), Long.valueOf(l7), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Long.valueOf(l1), Long.valueOf(l18), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(paramGameWebPerformanceInfo.gvf), Long.valueOf(l2) });
      Object localObject = "";
      try
      {
        String str = URLEncoder.encode(paramGameWebPerformanceInfo.url, "utf-8");
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label660;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(16141, new Object[] { localObject, Integer.valueOf(paramGameWebPerformanceInfo.guG), Integer.valueOf(paramGameWebPerformanceInfo.guH), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.guI), Long.valueOf(l4), Long.valueOf(l13), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l8), Long.valueOf(l7), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Long.valueOf(l1), Long.valueOf(l18), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(paramGameWebPerformanceInfo.gvf), Long.valueOf(l2), Integer.valueOf(j), paramGameWebPerformanceInfo.guO, Integer.valueOf(paramGameWebPerformanceInfo.guJ), paramGameWebPerformanceInfo.guF, az.iW(ak.getContext()), Integer.valueOf(paramGameWebPerformanceInfo.guM), Integer.valueOf(paramGameWebPerformanceInfo.guK), Integer.valueOf(paramGameWebPerformanceInfo.guN), paramGameWebPerformanceInfo.gvj, paramGameWebPerformanceInfo.gvk, paramGameWebPerformanceInfo.gvl });
      if (j != 1) {
        break label1067;
      }
      if (paramGameWebPerformanceInfo.guM == 0) {
        com.tencent.mm.plugin.report.service.g.yxI.n(949L, 4L, 1L);
      }
      if (paramGameWebPerformanceInfo.gve != -1L) {
        break label1107;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(949L, 7L, 1L);
      AppMethodBeat.o(108251);
      return;
      l4 = 0L;
      break;
      i = 0;
      break label70;
      l9 = -1L;
      break label273;
      j = 0;
      break label284;
    }
    label1041:
    label1067:
    if (paramGameWebPerformanceInfo.guH == 1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(949L, 5L, 1L);
      AppMethodBeat.o(108251);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.n(949L, 6L, 1L);
    label1107:
    AppMethodBeat.o(108251);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(184036);
    ae.d("MicroMsg.GameReportImpl", "reportGameCommEvent, opId:%d, params:%s, result:%s, costTime:%d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
    com.tencent.mm.plugin.report.service.g.yxI.f(16171, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(184036);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt4)
  {
    AppMethodBeat.i(108248);
    ae.d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString5 });
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
      AppMethodBeat.o(108248);
      return;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = ak.getContext();
    }
    paramContext = com.tencent.mm.pluginsdk.model.app.h.m(paramString1, false, false);
    if (paramContext == null)
    {
      ae.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
      AppMethodBeat.o(108248);
      return;
    }
    int j = com.tencent.mm.game.report.e.a.F((Context)localObject, paramString2);
    paramString2 = com.tencent.mm.game.report.e.a.agU();
    int k = com.tencent.mm.game.report.e.a.getNetworkType((Context)localObject);
    localObject = bu.nullAsNil(paramContext.field_packageName);
    String str1 = bu.nullAsNil(paramContext.field_signature);
    String str2 = Long.toString(paramLong);
    if (paramContext.Ee()) {}
    for (int i = 1;; i = 0)
    {
      paramContext = com.tencent.mm.game.report.api.b.c(10531, new Object[] { paramString1, Integer.valueOf(j), paramString2, paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), localObject, str1, str2, "", paramString5, "", Integer.valueOf(i), paramString6, "", Integer.valueOf(paramInt4) });
      ae.i("MicroMsg.reportMsgClick", paramContext.guE);
      e.a(paramContext);
      AppMethodBeat.o(108248);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(108247);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5, paramString6, 0);
    AppMethodBeat.o(108247);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(108242);
    ae.d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
      AppMethodBeat.o(108242);
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ak.getContext();
    }
    e.a(com.tencent.mm.game.report.api.b.c(10583, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.game.report.e.a.F(localContext, paramString2)), com.tencent.mm.game.report.e.a.agU(), paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.game.report.e.a.getNetworkType(localContext)) }));
    AppMethodBeat.o(108242);
  }
  
  public final void a(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    AppMethodBeat.i(108249);
    if ((paramGameWebPerformanceInfo == null) || (bu.isNullOrNil(paramGameWebPerformanceInfo.url)))
    {
      ae.e("MicroMsg.GameReportImpl", "info is null");
      AppMethodBeat.o(108249);
      return;
    }
    if (ak.cpe())
    {
      b(paramGameWebPerformanceInfo);
      AppMethodBeat.o(108249);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", paramGameWebPerformanceInfo, a.class, null);
    AppMethodBeat.o(108249);
  }
  
  public final void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108240);
    e.a(paramb);
    AppMethodBeat.o(108240);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(108241);
    ae.d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + paramString1 + ", appId = " + paramString2 + ", msgType = " + paramInt1 + ", scene = " + paramInt2 + ", actionName = " + paramString3);
    if (bu.isNullOrNil(paramString2))
    {
      ae.e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
      AppMethodBeat.o(108241);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(10546, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), com.tencent.mm.game.report.e.a.agU(), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(108241);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(108243);
    ae.d("MicroMsg.GameReportImpl", "reportReadMsg, appId = ".concat(String.valueOf(paramString1)));
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
      AppMethodBeat.o(108243);
      return;
    }
    String str = com.tencent.mm.game.report.e.a.rk(paramLong);
    com.tencent.mm.plugin.report.service.g localg;
    if (paramBoolean)
    {
      i = 1;
      ae.i("MicroMsg.reportReadMsg", "%s,%s,%s,%s,%s,%s,%s,%s,%d", new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt3) });
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (!paramBoolean) {
        break label225;
      }
    }
    label225:
    for (int i = 1;; i = 0)
    {
      localg.f(10532, new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(108243);
      return;
      i = 0;
      break;
    }
  }
  
  public final void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175994);
    a.agR();
    a.b(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    AppMethodBeat.o(175994);
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108246);
    ae.d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
      AppMethodBeat.o(108246);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(10534, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.game.report.e.a.F(paramContext, paramString2)), com.tencent.mm.game.report.e.a.agU(), Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(108246);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108245);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.GameReportImpl", "null open or null username");
      AppMethodBeat.o(108245);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(10738, new Object[] { paramString1, paramString2, paramString1, paramString3 });
    AppMethodBeat.o(108245);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108244);
    ae.d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + paramString + ", scene = " + paramInt1);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
      AppMethodBeat.o(108244);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(10700, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(108244);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<GameWebPerformanceInfo, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.b
 * JD-Core Version:    0.7.0.1
 */