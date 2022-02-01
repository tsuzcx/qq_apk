package com.tencent.mm.game.report;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b
  extends com.tencent.mm.game.report.api.a
{
  static void b(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    AppMethodBeat.i(108251);
    Log.i("MicroMsg.GameReportImpl", "reportWebPerformanceInMM, %s", new Object[] { paramGameWebPerformanceInfo.toString() });
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
    if (paramGameWebPerformanceInfo.mtU - paramGameWebPerformanceInfo.startTime > 0L)
    {
      l4 = paramGameWebPerformanceInfo.mtU - paramGameWebPerformanceInfo.startTime;
      l13 = paramGameWebPerformanceInfo.mtV - paramGameWebPerformanceInfo.startTime;
      if (paramGameWebPerformanceInfo.mtW <= 0L) {
        break label1041;
      }
      i = 1;
      l6 = 0L;
      l5 = 0L;
      if (i == 1)
      {
        l6 = paramGameWebPerformanceInfo.mtW - paramGameWebPerformanceInfo.startTime;
        l5 = paramGameWebPerformanceInfo.mtX - paramGameWebPerformanceInfo.startTime;
      }
      l8 = 0L;
      l7 = 0L;
      if (paramGameWebPerformanceInfo.mtN == 1)
      {
        l8 = paramGameWebPerformanceInfo.mtY - paramGameWebPerformanceInfo.startTime;
        l7 = paramGameWebPerformanceInfo.mtZ - paramGameWebPerformanceInfo.startTime;
      }
      l14 = paramGameWebPerformanceInfo.mua - paramGameWebPerformanceInfo.startTime;
      l15 = paramGameWebPerformanceInfo.mub - paramGameWebPerformanceInfo.startTime;
      l16 = paramGameWebPerformanceInfo.muc - paramGameWebPerformanceInfo.startTime;
      l17 = paramGameWebPerformanceInfo.mud - paramGameWebPerformanceInfo.startTime;
      l1 = 0L;
      if (paramGameWebPerformanceInfo.mue != 0L)
      {
        l2 = paramGameWebPerformanceInfo.mue - paramGameWebPerformanceInfo.startTime;
        l1 = l2;
        if (paramGameWebPerformanceInfo.mtN == 0)
        {
          l1 = l2;
          if (l2 < 0L) {
            l1 = -1L;
          }
        }
      }
      l18 = paramGameWebPerformanceInfo.muf - paramGameWebPerformanceInfo.startTime;
      l2 = paramGameWebPerformanceInfo.mug - paramGameWebPerformanceInfo.startTime;
      l9 = l2;
      if (paramGameWebPerformanceInfo.mtN == 0)
      {
        if (l2 <= 0L) {
          break label1046;
        }
        l9 = l2;
      }
      if (paramGameWebPerformanceInfo.muh <= 0L) {
        break label1054;
      }
      j = 1;
      label284:
      l2 = paramGameWebPerformanceInfo.muh - paramGameWebPerformanceInfo.startTime;
      if (j == 0) {
        break label1059;
      }
      l10 = l2;
      if (paramGameWebPerformanceInfo.mtN == 0) {
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
      if (paramGameWebPerformanceInfo.mtP == 0)
      {
        l3 = paramGameWebPerformanceInfo.mui - paramGameWebPerformanceInfo.startTime;
        l2 = l3;
        if (l3 <= 0L) {
          l2 = -1L;
        }
        long l12 = paramGameWebPerformanceInfo.muj - paramGameWebPerformanceInfo.startTime;
        l11 = l2;
        l3 = l12;
        if (l12 <= 0L)
        {
          l3 = -1L;
          l11 = l2;
        }
      }
      l2 = paramGameWebPerformanceInfo.mul - paramGameWebPerformanceInfo.startTime;
      Log.i("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", new Object[] { paramGameWebPerformanceInfo.url, paramGameWebPerformanceInfo.mtT, Integer.valueOf(paramGameWebPerformanceInfo.mtL), Integer.valueOf(paramGameWebPerformanceInfo.mtM), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.mtN), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l13), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l8), Long.valueOf(l7), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Long.valueOf(l1), Long.valueOf(l18), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(paramGameWebPerformanceInfo.muk), Long.valueOf(l2) });
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
      com.tencent.mm.plugin.report.service.h.OAn.b(16141, new Object[] { localObject, Integer.valueOf(paramGameWebPerformanceInfo.mtL), Integer.valueOf(paramGameWebPerformanceInfo.mtM), Integer.valueOf(i), Integer.valueOf(paramGameWebPerformanceInfo.mtN), Long.valueOf(l4), Long.valueOf(l13), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l8), Long.valueOf(l7), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Long.valueOf(l1), Long.valueOf(l18), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(paramGameWebPerformanceInfo.muk), Long.valueOf(l2), Integer.valueOf(j), paramGameWebPerformanceInfo.mtT, Integer.valueOf(paramGameWebPerformanceInfo.mtO), paramGameWebPerformanceInfo.mtK, NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()), Integer.valueOf(paramGameWebPerformanceInfo.mtR), Integer.valueOf(paramGameWebPerformanceInfo.mtP), Integer.valueOf(paramGameWebPerformanceInfo.mtS), paramGameWebPerformanceInfo.muo, paramGameWebPerformanceInfo.mup, paramGameWebPerformanceInfo.muq });
      if (j != 1) {
        break label1067;
      }
      if (paramGameWebPerformanceInfo.mtR == 0) {
        com.tencent.mm.plugin.report.service.h.OAn.p(949L, 4L, 1L);
      }
      if (paramGameWebPerformanceInfo.muj != -1L) {
        break label1107;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(949L, 7L, 1L);
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
    if (paramGameWebPerformanceInfo.mtM == 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(949L, 5L, 1L);
      AppMethodBeat.o(108251);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.p(949L, 6L, 1L);
    label1107:
    AppMethodBeat.o(108251);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(184036);
    Log.d("MicroMsg.GameReportImpl", "reportGameCommEvent, opId:%d, params:%s, result:%s, costTime:%d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
    com.tencent.mm.plugin.report.service.h.OAn.b(16171, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(184036);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, long paramLong, String paramString5, String paramString6)
  {
    AppMethodBeat.i(240756);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5, paramString6, 0);
    AppMethodBeat.o(240756);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt4)
  {
    AppMethodBeat.i(108248);
    Log.d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString5 });
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
      AppMethodBeat.o(108248);
      return;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = MMApplicationContext.getContext();
    }
    paramContext = com.tencent.mm.pluginsdk.model.app.h.s(paramString1, false, false);
    if (paramContext == null)
    {
      Log.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
      AppMethodBeat.o(108248);
      return;
    }
    int j = com.tencent.mm.game.report.e.a.L((Context)localObject, paramString2);
    paramString2 = com.tencent.mm.game.report.e.a.aXG();
    int k = com.tencent.mm.game.report.e.a.dt((Context)localObject);
    localObject = Util.nullAsNil(paramContext.field_packageName);
    String str1 = Util.nullAsNil(paramContext.field_signature);
    String str2 = Long.toString(paramLong);
    if (paramContext.aqJ()) {}
    for (int i = 1;; i = 0)
    {
      paramContext = com.tencent.mm.game.report.api.b.e(10531, new Object[] { paramString1, Integer.valueOf(j), paramString2, paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k), localObject, str1, str2, "", paramString5, "", Integer.valueOf(i), paramString6, "", Integer.valueOf(paramInt4) });
      Log.i("MicroMsg.reportMsgClick", paramContext.mtJ);
      f.a(paramContext);
      AppMethodBeat.o(108248);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(108242);
    Log.d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
      AppMethodBeat.o(108242);
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    f.a(com.tencent.mm.game.report.api.b.e(10583, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.game.report.e.a.L(localContext, paramString2)), com.tencent.mm.game.report.e.a.aXG(), paramString3, Integer.valueOf(paramInt1), paramString4, Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.game.report.e.a.dt(localContext)) }));
    AppMethodBeat.o(108242);
  }
  
  public final void a(GameWebPerformanceInfo paramGameWebPerformanceInfo)
  {
    AppMethodBeat.i(108249);
    if ((paramGameWebPerformanceInfo == null) || (Util.isNullOrNil(paramGameWebPerformanceInfo.url)))
    {
      Log.e("MicroMsg.GameReportImpl", "info is null");
      AppMethodBeat.o(108249);
      return;
    }
    if (MMApplicationContext.isMMProcess())
    {
      b(paramGameWebPerformanceInfo);
      AppMethodBeat.o(108249);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, paramGameWebPerformanceInfo, a.class, null);
    AppMethodBeat.o(108249);
  }
  
  public final void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108240);
    f.a(paramb);
    AppMethodBeat.o(108240);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(108241);
    Log.d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + paramString1 + ", appId = " + paramString2 + ", msgType = " + paramInt1 + ", scene = " + paramInt2 + ", actionName = " + paramString3);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
      AppMethodBeat.o(108241);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(10546, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), com.tencent.mm.game.report.e.a.aXG(), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(108241);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(108243);
    Log.d("MicroMsg.GameReportImpl", "reportReadMsg, appId = ".concat(String.valueOf(paramString1)));
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
      AppMethodBeat.o(108243);
      return;
    }
    String str = com.tencent.mm.game.report.e.a.hy(paramLong);
    com.tencent.mm.plugin.report.service.h localh;
    if (paramBoolean)
    {
      i = 1;
      Log.i("MicroMsg.reportReadMsg", "%s,%s,%s,%s,%s,%s,%s,%s,%d", new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt3) });
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      if (!paramBoolean) {
        break label225;
      }
    }
    label225:
    for (int i = 1;; i = 0)
    {
      localh.b(10532, new Object[] { paramString1, str, paramString2, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(108243);
      return;
      i = 0;
      break;
    }
  }
  
  public final void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175994);
    a.aXB();
    a.b(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    AppMethodBeat.o(175994);
  }
  
  public final void o(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108246);
    Log.d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + paramString1 + ", pkgName = " + paramString2);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
      AppMethodBeat.o(108246);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(10534, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.game.report.e.a.L(paramContext, paramString2)), com.tencent.mm.game.report.e.a.aXG(), Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(108246);
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108245);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.GameReportImpl", "null open or null username");
      AppMethodBeat.o(108245);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(10738, new Object[] { paramString1, paramString2, paramString1, paramString3 });
    AppMethodBeat.o(108245);
  }
  
  public final void q(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108244);
    Log.d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + paramString + ", scene = " + paramInt1);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
      AppMethodBeat.o(108244);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(10700, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(108244);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d<GameWebPerformanceInfo, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.b
 * JD-Core Version:    0.7.0.1
 */