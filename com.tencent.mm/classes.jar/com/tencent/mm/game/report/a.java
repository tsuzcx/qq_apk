package com.tencent.mm.game.report;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class a
  extends com.tencent.mm.game.report.api.a
{
  static void b(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    AppMethodBeat.i(59583);
    ab.i("MicroMsg.GameReportImpl", "reportWebPerformanceInMM, %s", new Object[] { paramGameWebPerformanceInfo.toString() });
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
    if (paramGameWebPerformanceInfo.ezZ - paramGameWebPerformanceInfo.startTime > 0L)
    {
      l4 = paramGameWebPerformanceInfo.ezZ - paramGameWebPerformanceInfo.startTime;
      l13 = paramGameWebPerformanceInfo.eAa - paramGameWebPerformanceInfo.startTime;
      if (paramGameWebPerformanceInfo.eAb <= 0L) {
        break label1041;
      }
      i = 1;
      l6 = 0L;
      l5 = 0L;
      if (i == 1)
      {
        l6 = paramGameWebPerformanceInfo.eAb - paramGameWebPerformanceInfo.startTime;
        l5 = paramGameWebPerformanceInfo.eAc - paramGameWebPerformanceInfo.startTime;
      }
      l8 = 0L;
      l7 = 0L;
      if (paramGameWebPerformanceInfo.ezS == 1)
      {
        l8 = paramGameWebPerformanceInfo.eAd - paramGameWebPerformanceInfo.startTime;
        l7 = paramGameWebPerformanceInfo.eAe - paramGameWebPerformanceInfo.startTime;
      }
      l14 = paramGameWebPerformanceInfo.eAf - paramGameWebPerformanceInfo.startTime;
      l15 = paramGameWebPerformanceInfo.eAg - paramGameWebPerformanceInfo.startTime;
      l16 = paramGameWebPerformanceInfo.eAh - paramGameWebPerformanceInfo.startTime;
      l17 = paramGameWebPerformanceInfo.eAi - paramGameWebPerformanceInfo.startTime;
      l1 = 0L;
      if (paramGameWebPerformanceInfo.eAj != 0L)
      {
        l2 = paramGameWebPerformanceInfo.eAj - paramGameWebPerformanceInfo.startTime;
        l1 = l2;
        if (paramGameWebPerformanceInfo.ezS == 0)
        {
          l1 = l2;
          if (l2 < 0L) {
            l1 = -1L;
          }
        }
      }
      l18 = paramGameWebPerformanceInfo.eAk - paramGameWebPerformanceInfo.startTime;
      l2 = paramGameWebPerformanceInfo.eAl - paramGameWebPerformanceInfo.startTime;
      l9 = l2;
      if (paramGameWebPerformanceInfo.ezS == 0)
      {
        if (l2 <= 0L) {
          break label1046;
        }
        l9 = l2;
      }
      if (paramGameWebPerformanceInfo.eAm <= 0L) {
        break label1054;
      }
      j = 1;
      label284:
      l2 = paramGameWebPerformanceInfo.eAm - paramGameWebPerformanceInfo.startTime;
      if (j == 0) {
        break label1059;
      }
      l10 = l2;
      if (paramGameWebPerformanceInfo.ezS == 0) {
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
      if (paramGameWebPerformanceInfo.ezU == 0)
      {
        l3 = paramGameWebPerformanceInfo.eAn - paramGameWebPerformanceInfo.startTime;
        l2 = l3;
        if (l3 <= 0L) {
          l2 = -1L;
        }
        long l12 = paramGameWebPerformanceInfo.eAo - paramGameWebPerformanceInfo.startTime;
        l11 = l2;
        l3 = l12;
        if (l12 <= 0L)
        {
          l3 = -1L;
          l11 = l2;
        }
      }
      l2 = paramGameWebPerformanceInfo.eAq - paramGameWebPerformanceInfo.startTime;
      ab.i("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", new Object[] { paramGameWebPerformanceInfo.url, paramGameWebPerformanceInfo.ezY, Integer.valueOf(paramGameWebPerformanceInfo.ezQ), Integer.valueOf(paramGameWebPerformanceInfo.ezR), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.ezS), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l13), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l8), Long.valueOf(l7), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Long.valueOf(l1), Long.valueOf(l18), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(paramGameWebPerformanceInfo.eAp), Long.valueOf(l2) });
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
      h.qsU.e(16141, new Object[] { localObject, Integer.valueOf(paramGameWebPerformanceInfo.ezQ), Integer.valueOf(paramGameWebPerformanceInfo.ezR), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.ezS), Long.valueOf(l4), Long.valueOf(l13), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l8), Long.valueOf(l7), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Long.valueOf(l1), Long.valueOf(l18), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(paramGameWebPerformanceInfo.eAp), Long.valueOf(l2), Integer.valueOf(j), paramGameWebPerformanceInfo.ezY, Integer.valueOf(paramGameWebPerformanceInfo.ezT), paramGameWebPerformanceInfo.ezP, at.gU(ah.getContext()), Integer.valueOf(paramGameWebPerformanceInfo.ezW), Integer.valueOf(paramGameWebPerformanceInfo.ezU), Integer.valueOf(paramGameWebPerformanceInfo.ezX), paramGameWebPerformanceInfo.eAt, paramGameWebPerformanceInfo.eAu, paramGameWebPerformanceInfo.eAv });
      if (j != 1) {
        break label1067;
      }
      if (paramGameWebPerformanceInfo.ezW == 0) {
        h.qsU.j(949L, 4L, 1L);
      }
      if (paramGameWebPerformanceInfo.eAo != -1L) {
        break label1107;
      }
      h.qsU.j(949L, 7L, 1L);
      AppMethodBeat.o(59583);
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
    if (paramGameWebPerformanceInfo.ezR == 1)
    {
      h.qsU.j(949L, 5L, 1L);
      AppMethodBeat.o(59583);
      return;
    }
    h.qsU.j(949L, 6L, 1L);
    label1107:
    AppMethodBeat.o(59583);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, long paramLong, String paramString5, String paramString6)
  {
    AppMethodBeat.i(59580);
    ab.d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString5 });
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
      AppMethodBeat.o(59580);
      return;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = ah.getContext();
    }
    paramContext = g.ca(paramString1, false);
    if (paramContext == null)
    {
      ab.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
      AppMethodBeat.o(59580);
      return;
    }
    int j = com.tencent.mm.game.report.c.a.F((Context)localObject, paramString2);
    paramString2 = com.tencent.mm.game.report.c.a.Pu();
    int k = com.tencent.mm.game.report.c.a.getNetworkType((Context)localObject);
    localObject = bo.nullAsNil(paramContext.field_packageName);
    String str1 = bo.nullAsNil(paramContext.field_signature);
    String str2 = Long.toString(paramLong);
    if (paramContext.vY()) {}
    for (int i = 1;; i = 0)
    {
      paramContext = com.tencent.mm.game.report.api.b.b(10531, new Object[] { paramString1, Integer.valueOf(j), paramString2, paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), localObject, str1, str2, "", paramString5, "", Integer.valueOf(i), paramString6 });
      ab.i("MicroMsg.reportMsgClick", paramContext.ezO);
      b.a(paramContext);
      AppMethodBeat.o(59580);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(59575);
    ab.d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
      AppMethodBeat.o(59575);
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    b.a(com.tencent.mm.game.report.api.b.b(10583, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.game.report.c.a.F(localContext, paramString2)), com.tencent.mm.game.report.c.a.Pu(), paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.game.report.c.a.getNetworkType(localContext)) }));
    AppMethodBeat.o(59575);
  }
  
  public final void a(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    AppMethodBeat.i(59581);
    if ((paramGameWebPerformanceInfo == null) || (bo.isNullOrNil(paramGameWebPerformanceInfo.url)))
    {
      ab.e("MicroMsg.GameReportImpl", "info is null");
      AppMethodBeat.o(59581);
      return;
    }
    if (ah.brt())
    {
      b(paramGameWebPerformanceInfo);
      AppMethodBeat.o(59581);
      return;
    }
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", paramGameWebPerformanceInfo, a.class, null);
    AppMethodBeat.o(59581);
  }
  
  public final void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(59573);
    b.a(paramb);
    AppMethodBeat.o(59573);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(59574);
    ab.d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + paramString1 + ", appId = " + paramString2 + ", msgType = " + paramInt1 + ", scene = " + paramInt2 + ", actionName = " + paramString3);
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
      AppMethodBeat.o(59574);
      return;
    }
    h.qsU.e(10546, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), com.tencent.mm.game.report.c.a.Pu(), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(59574);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(59576);
    ab.d("MicroMsg.GameReportImpl", "reportReadMsg, appId = ".concat(String.valueOf(paramString1)));
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
      AppMethodBeat.o(59576);
      return;
    }
    String str = com.tencent.mm.game.report.c.a.gf(paramLong);
    h localh;
    if (paramBoolean)
    {
      i = 1;
      ab.i("MicroMsg.reportReadMsg", "%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4 });
      localh = h.qsU;
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (int i = 1;; i = 0)
    {
      localh.e(10532, new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4 });
      AppMethodBeat.o(59576);
      return;
      i = 0;
      break;
    }
  }
  
  public final void g(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(59582);
    h.qsU.e(16171, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(0L) });
    AppMethodBeat.o(59582);
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(59579);
    ab.d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
      AppMethodBeat.o(59579);
      return;
    }
    h.qsU.e(10534, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.game.report.c.a.F(paramContext, paramString2)), com.tencent.mm.game.report.c.a.Pu(), Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(59579);
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(59578);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.GameReportImpl", "null open or null username");
      AppMethodBeat.o(59578);
      return;
    }
    h.qsU.e(10738, new Object[] { paramString1, paramString2, paramString1, paramString3 });
    AppMethodBeat.o(59578);
  }
  
  public final void o(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59577);
    ab.d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + paramString + ", scene = " + paramInt1);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
      AppMethodBeat.o(59577);
      return;
    }
    h.qsU.e(10700, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(59577);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.a<GameWebPerformanceInfo, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.game.report.a
 * JD-Core Version:    0.7.0.1
 */