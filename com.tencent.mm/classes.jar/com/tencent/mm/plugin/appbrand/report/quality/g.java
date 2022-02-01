package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.luggage.sdk.config.c;
import com.tencent.luggage.sdk.config.c.a;
import com.tencent.luggage.sdk.config.d.a;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.b.a.oz;
import com.tencent.mm.f.b.a.pi;
import com.tencent.mm.f.b.a.pi.a;
import com.tencent.mm.f.b.a.pr;
import com.tencent.mm.f.b.a.pr.a;
import com.tencent.mm.f.b.a.pt;
import com.tencent.mm.f.b.a.pt.a;
import com.tencent.mm.f.b.a.pu;
import com.tencent.mm.f.b.a.pu.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.u;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "reportGetA8KeyIfScanEnterBeforeLaunch", "instanceId", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g qMW;
  
  static
  {
    AppMethodBeat.i(51058);
    qMW = new g();
    AppMethodBeat.o(51058);
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(283869);
    p.k(paramLaunchParcel, "parcel");
    p.k(paramString1, "instanceId");
    if (paramLaunchParcel.pdk.qJI != null)
    {
      oz localoz = new oz();
      localoz.FR(paramString1);
      localoz.oA(paramLaunchParcel.pdk.qJI.getInt("CgiSpeedOutSideStructCgiNo"));
      localoz.FU(paramLaunchParcel.pdk.qJI.getString("CgiSpeedOutSideStructNetworkType"));
      localoz.FT(paramLaunchParcel.username);
      localoz.FS(paramString2);
      localoz.oz(paramLaunchParcel.pdk.qJI.getInt("CgiSpeedOutSideStructBizRet"));
      localoz.By(paramLaunchParcel.pdk.qJI.getLong("CgiSpeedOutSideStructCostTime"));
      localoz.Bx(paramLaunchParcel.pdk.qJI.getLong("CgiSpeedOutSideStructEndTimeStamp"));
      localoz.Bz(paramLaunchParcel.pdk.qJI.getLong("CgiSpeedOutSideStructResponseSize"));
      localoz.oy(paramLaunchParcel.pdk.qJI.getInt("CgiSpeedOutSideStructRet"));
      localoz.Bw(paramLaunchParcel.pdk.qJI.getLong("CgiSpeedOutSideStructStartTimeStamp"));
      localoz.bpa();
    }
    AppMethodBeat.o(283869);
  }
  
  public static final void a(kv_14609 paramkv_14609, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51057);
    p.k(paramkv_14609, "$this$assignFromQualitySession");
    p.k(paramQualitySession, "session");
    paramkv_14609.ei(paramQualitySession.cBH);
    paramkv_14609.appType = paramQualitySession.apptype;
    paramkv_14609.scene = paramQualitySession.scene;
    AppMethodBeat.o(51057);
  }
  
  public static final void a(t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 1L;
    AppMethodBeat.i(51053);
    p.k(paramt, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = b.amO(paramt.getAppId());
    if (localQualitySessionRuntime != null)
    {
      pi localpi = new pi();
      localpi.Gi(localQualitySessionRuntime.appId);
      localpi.BZ(localQualitySessionRuntime.qNx);
      localpi.a(pi.a.oH(localQualitySessionRuntime.qLQ));
      localpi.Ca(localQualitySessionRuntime.apptype);
      localpi.Cb(paramt.Qu().scene);
      localpi.Gj(u.ek(MMApplicationContext.getContext()));
      localpi.Gk(paramt.bDy().username);
      localpi.Gh(localQualitySessionRuntime.cBH);
      Object localObject = paramt.bDy();
      p.j(localObject, "runtime.initConfig");
      localpi.Gp(((AppBrandInitConfigWC)localObject).Qw());
      long l1;
      if (paramBoolean1)
      {
        l1 = 0L;
        localpi.Cd(l1);
        localpi.Cc(System.currentTimeMillis());
        if (!paramBoolean2) {
          break label408;
        }
        l1 = l2;
        label193:
        localpi.Ce(l1);
        p.j(localQualitySessionRuntime, "session");
        localpi.Cf(localQualitySessionRuntime.ciu());
        localpi.Gl(q.aT(paramt.bCi()));
        localObject = paramt.bDy().nYt;
        if (localObject != null)
        {
          localpi.Gm(((AppBrandRuntimeReloadReportBundle)localObject).pZP);
          localpi.Gn(((AppBrandRuntimeReloadReportBundle)localObject).pZQ);
        }
        if (!localQualitySessionRuntime.qNz) {
          break label414;
        }
      }
      label408:
      label414:
      for (int i = 1;; i = 0)
      {
        localpi.oG(i);
        localpi.Cg(paramt.bDy().launchMode);
        localpi.Ch(paramt.bDy().cxe.RJ());
        Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report username[" + paramt.bDy().username + "] appId[" + paramt.getAppId() + "], instanceId[" + localpi.anX() + "], sessionId[" + localpi.getSessionId() + ']');
        localpi.bpa();
        AppMethodBeat.o(51053);
        return;
        l1 = 1L;
        break;
        l1 = 0L;
        break label193;
      }
    }
    ((a)new g.a(paramt)).invoke();
    AppMethodBeat.o(51053);
  }
  
  public static final pr c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    p.k(paramQualitySession, "session");
    pr localpr = new pr();
    localpr.GI(paramQualitySession.appId);
    localpr.GH(paramQualitySession.cBH);
    localpr.a(pr.a.oO(paramQualitySession.qLQ));
    localpr.CI(paramQualitySession.apptype);
    localpr.CK(paramQualitySession.scene);
    localpr.CH(paramQualitySession.qNx);
    AppMethodBeat.o(51050);
    return localpr;
  }
  
  public static final String c(LaunchParcel paramLaunchParcel, String paramString)
  {
    AppMethodBeat.i(283867);
    p.k(paramLaunchParcel, "parcel");
    Object localObject1 = i.qRL;
    localObject1 = i.a.cjb();
    int i = paramLaunchParcel.cBU;
    label58:
    long l;
    label64:
    String str;
    pi localpi;
    if (paramString == null)
    {
      localObject1 = null;
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label491;
      }
      i = 1;
      if (i != 0) {
        break label496;
      }
      l = 0L;
      str = d.a.cxV.QE();
      paramLaunchParcel.akd(str);
      localpi = new pi();
      localpi.Gh((String)localObject1);
      localpi.Cd(l);
      localpi.Gi(paramLaunchParcel.appId);
      localpi.BZ(paramLaunchParcel.version);
      localpi.a(pi.a.oH(paramLaunchParcel.cBU + 1));
      localpi.Cb(paramLaunchParcel.pdk.scene);
      localpi.Gj(u.ek(MMApplicationContext.getContext()));
      localpi.Gk(paramLaunchParcel.username);
      Object localObject3 = paramLaunchParcel.nBq;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localpi.Gl(q.aT((String)localObject2));
      localObject3 = paramLaunchParcel.pZp;
      localObject2 = localObject3;
      if (!(localObject3 instanceof AppBrandRuntimeReloadReportBundle)) {
        localObject2 = null;
      }
      localObject2 = (AppBrandRuntimeReloadReportBundle)localObject2;
      if (localObject2 != null)
      {
        localpi.Gm(((AppBrandRuntimeReloadReportBundle)localObject2).pZP);
        localpi.Gn(((AppBrandRuntimeReloadReportBundle)localObject2).pZQ);
      }
      localObject2 = (CharSequence)paramLaunchParcel.username;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label519;
      }
      i = 1;
      label288:
      if ((i == 0) && (MMApplicationContext.isMainProcess())) {
        if (!((k)m.W(k.class)).aef(paramLaunchParcel.username)) {
          break label524;
        }
      }
    }
    label519:
    label524:
    for (i = 0;; i = 1)
    {
      localpi.oG(i);
      localpi.Cg(paramLaunchParcel.launchMode);
      localpi.Ch(paramLaunchParcel.cxe.RJ());
      localpi.Go(paramLaunchParcel.nBJ);
      localpi.Cc(System.currentTimeMillis());
      localpi.Gp(str);
      Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString + "] instanceId[" + localpi.anX() + "] sessionId[" + localpi.getSessionId() + ']');
      localpi.bpa();
      AppMethodBeat.o(283867);
      return localObject1;
      localObject1 = ((com.tencent.luggage.sdk.processes.d)localObject1).x(paramString, i);
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).cBH;
        break;
      }
      localObject1 = null;
      break;
      label491:
      i = 0;
      break label58;
      label496:
      localObject1 = c.a.cxT.QD();
      p.j(localObject1, "MPInstanceIdFactory.IMPL…STANCE.createInstanceId()");
      l = 1L;
      break label64;
      i = 0;
      break label288;
    }
  }
  
  public static final pu d(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    p.k(paramQualitySession, "session");
    pu localpu = new pu();
    localpu.GP(paramQualitySession.appId);
    localpu.GO(paramQualitySession.cBH);
    localpu.a(pu.a.oS(paramQualitySession.qLQ));
    localpu.Dc(paramQualitySession.apptype);
    localpu.De(paramQualitySession.scene);
    localpu.Db(paramQualitySession.qNx);
    AppMethodBeat.o(51051);
    return localpu;
  }
  
  public static final pt e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(283866);
    p.k(paramQualitySession, "session");
    pt localpt = new pt();
    localpt.GN(paramQualitySession.appId);
    localpt.GM(paramQualitySession.cBH);
    localpt.a(pt.a.oR(paramQualitySession.qLQ));
    localpt.CW(paramQualitySession.apptype);
    localpt.CY(paramQualitySession.scene);
    localpt.CV(paramQualitySession.qNx);
    AppMethodBeat.o(283866);
    return localpt;
  }
  
  public static final QualitySessionRuntime f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51052);
    p.k(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    p.j(localParcel, "Parcel.obtain()");
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
    String str = j.getNetworkType(MMApplicationContext.getContext());
    if (str == null) {
      p.iCn();
    }
    if (p.h(str, j.qJv))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (p.h(str, j.qJw))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (p.h(str, j.qJx))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (p.h(str, j.qJy))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (p.h(str, j.qJz))
    {
      AppMethodBeat.o(51049);
      return 4;
    }
    if (p.h(str, "offline"))
    {
      AppMethodBeat.o(51049);
      return 5;
    }
    AppMethodBeat.o(51049);
    return 10000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */