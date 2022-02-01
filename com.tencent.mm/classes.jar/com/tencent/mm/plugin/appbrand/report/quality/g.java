package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.luggage.sdk.config.c;
import com.tencent.luggage.sdk.config.c.a;
import com.tencent.luggage.sdk.config.d;
import com.tencent.luggage.sdk.config.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mb;
import com.tencent.mm.g.b.a.mk;
import com.tencent.mm.g.b.a.mk.a;
import com.tencent.mm.g.b.a.ms;
import com.tencent.mm.g.b.a.ms.a;
import com.tencent.mm.g.b.a.mu;
import com.tencent.mm.g.b.a.mu.a;
import com.tencent.mm.g.b.a.mv;
import com.tencent.mm.g.b.a.mv.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "reportGetA8KeyIfScanEnterBeforeLaunch", "instanceId", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g nKK;
  
  static
  {
    AppMethodBeat.i(51058);
    nKK = new g();
    AppMethodBeat.o(51058);
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(229315);
    kotlin.g.b.p.h(paramLaunchParcel, "parcel");
    kotlin.g.b.p.h(paramString1, "instanceId");
    if (paramLaunchParcel.mYK.nHw != null)
    {
      mb localmb = new mb();
      localmb.zl(paramString1);
      localmb.mp(paramLaunchParcel.mYK.nHw.getInt("CgiSpeedOutSideStructCgiNo"));
      localmb.zo(paramLaunchParcel.mYK.nHw.getString("CgiSpeedOutSideStructNetworkType"));
      localmb.zn(paramLaunchParcel.username);
      localmb.zm(paramString2);
      localmb.mo(paramLaunchParcel.mYK.nHw.getInt("CgiSpeedOutSideStructBizRet"));
      localmb.vD(paramLaunchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructCostTime"));
      localmb.vC(paramLaunchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructEndTimeStamp"));
      localmb.vE(paramLaunchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructResponseSize"));
      localmb.mn(paramLaunchParcel.mYK.nHw.getInt("CgiSpeedOutSideStructRet"));
      localmb.vB(paramLaunchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructStartTimeStamp"));
      localmb.bfK();
    }
    AppMethodBeat.o(229315);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.q paramq, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 1L;
    AppMethodBeat.i(51053);
    kotlin.g.b.p.h(paramq, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = b.aeU(paramq.getAppId());
    if (localQualitySessionRuntime != null)
    {
      mk localmk = new mk();
      localmk.zC(localQualitySessionRuntime.appId);
      localmk.we(localQualitySessionRuntime.nLk);
      localmk.a(mk.a.mw(localQualitySessionRuntime.nJE));
      localmk.wf(localQualitySessionRuntime.apptype);
      localmk.wg(paramq.Nz().scene);
      localmk.zD(t.el(MMApplicationContext.getContext()));
      localmk.zE(paramq.bsC().username);
      localmk.zB(localQualitySessionRuntime.kEY);
      Object localObject = paramq.bsC();
      kotlin.g.b.p.g(localObject, "runtime.initConfig");
      localmk.zJ(((AppBrandInitConfigWC)localObject).NB());
      long l1;
      if (paramBoolean1)
      {
        l1 = 0L;
        localmk.wi(l1);
        localmk.wh(System.currentTimeMillis());
        if (!paramBoolean2) {
          break label393;
        }
        l1 = l2;
        label193:
        localmk.wj(l1);
        kotlin.g.b.p.g(localQualitySessionRuntime, "session");
        localmk.wk(localQualitySessionRuntime.bVj());
        localmk.zF(com.tencent.mm.compatible.util.q.encode(paramq.brs()));
        localObject = paramq.bsC().lef;
        if (localObject != null)
        {
          localmk.zG(((AppBrandRuntimeReloadReportBundle)localObject).mZr);
          localmk.zH(((AppBrandRuntimeReloadReportBundle)localObject).mZs);
        }
        if (!localQualitySessionRuntime.nLm) {
          break label399;
        }
      }
      label393:
      label399:
      for (int i = 1;; i = 0)
      {
        localmk.mv(i);
        localmk.wl(paramq.bsC().launchMode);
        localmk.wm(paramq.bsC().cyz.OC());
        Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report appId[" + paramq.getAppId() + "], instanceId[" + localmk.aiv() + "], sessionId[" + localmk.getSessionId() + ']');
        localmk.bfK();
        AppMethodBeat.o(51053);
        return;
        l1 = 1L;
        break;
        l1 = 0L;
        break label193;
      }
    }
    ((a)new a(paramq)).invoke();
    AppMethodBeat.o(51053);
  }
  
  public static final void a(kv_14609 paramkv_14609, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51057);
    kotlin.g.b.p.h(paramkv_14609, "$this$assignFromQualitySession");
    kotlin.g.b.p.h(paramQualitySession, "session");
    paramkv_14609.aeS(paramQualitySession.kEY);
    paramkv_14609.appType = paramQualitySession.apptype;
    paramkv_14609.scene = paramQualitySession.scene;
    AppMethodBeat.o(51057);
  }
  
  public static final String c(LaunchParcel paramLaunchParcel, String paramString)
  {
    AppMethodBeat.i(229314);
    kotlin.g.b.p.h(paramLaunchParcel, "parcel");
    String str1 = h.bWb().co(paramString, paramLaunchParcel.iOo);
    Object localObject1 = (CharSequence)str1;
    long l;
    label57:
    String str2;
    mk localmk;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label459;
      }
      l = 0L;
      str2 = d.a.czj.NJ();
      paramLaunchParcel.acj(str2);
      localmk = new mk();
      localmk.zB(str1);
      localmk.wi(l);
      localmk.zC(paramLaunchParcel.appId);
      localmk.we(paramLaunchParcel.version);
      localmk.a(mk.a.mw(paramLaunchParcel.iOo + 1));
      localmk.wg(paramLaunchParcel.mYK.scene);
      localmk.zD(t.el(MMApplicationContext.getContext()));
      localmk.zE(paramLaunchParcel.username);
      Object localObject2 = paramLaunchParcel.kHw;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localmk.zF(com.tencent.mm.compatible.util.q.encode((String)localObject1));
      localObject2 = paramLaunchParcel.mYR;
      localObject1 = localObject2;
      if (!(localObject2 instanceof AppBrandRuntimeReloadReportBundle)) {
        localObject1 = null;
      }
      localObject1 = (AppBrandRuntimeReloadReportBundle)localObject1;
      if (localObject1 != null)
      {
        localmk.zG(((AppBrandRuntimeReloadReportBundle)localObject1).mZr);
        localmk.zH(((AppBrandRuntimeReloadReportBundle)localObject1).mZs);
      }
      localObject1 = (CharSequence)paramLaunchParcel.username;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label482;
      }
      i = 1;
      label281:
      if ((i == 0) && (MMApplicationContext.isMainProcess())) {
        if (!((k)n.W(k.class)).Wt(paramLaunchParcel.username)) {
          break label487;
        }
      }
    }
    label459:
    label482:
    label487:
    for (int i = 0;; i = 1)
    {
      localmk.mv(i);
      localmk.wl(paramLaunchParcel.launchMode);
      localmk.wm(paramLaunchParcel.cyz.OC());
      localmk.zI(paramLaunchParcel.kHQ);
      localmk.wh(System.currentTimeMillis());
      localmk.zJ(str2);
      Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString + "] instanceId[" + localmk.aiv() + "] sessionId[" + localmk.getSessionId() + ']');
      localmk.bfK();
      AppMethodBeat.o(229314);
      return str1;
      i = 0;
      break;
      str1 = c.a.czh.NI();
      kotlin.g.b.p.g(str1, "MPInstanceIdFactory.IMPL…STANCE.createInstanceId()");
      l = 1L;
      break label57;
      i = 0;
      break label281;
    }
  }
  
  public static final ms d(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    kotlin.g.b.p.h(paramQualitySession, "session");
    ms localms = new ms();
    localms.zX(paramQualitySession.appId);
    localms.zW(paramQualitySession.kEY);
    localms.a(ms.a.mD(paramQualitySession.nJE));
    localms.wI(paramQualitySession.apptype);
    localms.wK(paramQualitySession.scene);
    localms.wH(paramQualitySession.nLk);
    AppMethodBeat.o(51050);
    return localms;
  }
  
  public static final mv e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    kotlin.g.b.p.h(paramQualitySession, "session");
    mv localmv = new mv();
    localmv.Ae(paramQualitySession.appId);
    localmv.Ad(paramQualitySession.kEY);
    localmv.a(mv.a.mH(paramQualitySession.nJE));
    localmv.xc(paramQualitySession.apptype);
    localmv.xe(paramQualitySession.scene);
    localmv.xb(paramQualitySession.nLk);
    AppMethodBeat.o(51051);
    return localmv;
  }
  
  public static final mu f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(229313);
    kotlin.g.b.p.h(paramQualitySession, "session");
    mu localmu = new mu();
    localmu.Ac(paramQualitySession.appId);
    localmu.Ab(paramQualitySession.kEY);
    localmu.a(mu.a.mG(paramQualitySession.nJE));
    localmu.wW(paramQualitySession.apptype);
    localmu.wY(paramQualitySession.scene);
    localmu.wV(paramQualitySession.nLk);
    AppMethodBeat.o(229313);
    return localmu;
  }
  
  public static final QualitySessionRuntime g(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51052);
    kotlin.g.b.p.h(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    kotlin.g.b.p.g(localParcel, "Parcel.obtain()");
    localParcel.setDataPosition(0);
    paramQualitySession.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQualitySession = new QualitySessionRuntime(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(51052);
    return paramQualitySession;
  }
  
  public static final int getNetworkType()
  {
    AppMethodBeat.i(51049);
    String str = i.getNetworkType(MMApplicationContext.getContext());
    if (str == null) {
      kotlin.g.b.p.hyc();
    }
    if (kotlin.g.b.p.j(str, i.nHj))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (kotlin.g.b.p.j(str, i.nHk))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (kotlin.g.b.p.j(str, i.nHl))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (kotlin.g.b.p.j(str, i.nHm))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (kotlin.g.b.p.j(str, i.nHn))
    {
      AppMethodBeat.o(51049);
      return 4;
    }
    if (kotlin.g.b.p.j(str, "offline"))
    {
      AppMethodBeat.o(51049);
      return 5;
    }
    AppMethodBeat.o(51049);
    return 10000;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<x>
  {
    a(com.tencent.mm.plugin.appbrand.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */