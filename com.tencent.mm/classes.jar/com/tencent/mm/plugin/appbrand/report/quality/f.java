package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.d.a;
import com.tencent.luggage.sdk.config.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ss;
import com.tencent.mm.autogen.mmdata.rpt.tb;
import com.tencent.mm.autogen.mmdata.rpt.tb.a;
import com.tencent.mm.autogen.mmdata.rpt.tk;
import com.tencent.mm.autogen.mmdata.rpt.tk.a;
import com.tencent.mm.autogen.mmdata.rpt.tm;
import com.tencent.mm.autogen.mmdata.rpt.tm.a;
import com.tencent.mm.autogen.mmdata.rpt.tn;
import com.tencent.mm.autogen.mmdata.rpt.tn.a;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "forceCreateNewInstanceId", "reportGetA8KeyIfScanEnterBeforeLaunch", "instanceId", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f tRG;
  
  static
  {
    AppMethodBeat.i(51058);
    tRG = new f();
    AppMethodBeat.o(51058);
  }
  
  public static final String a(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    int j = 1;
    AppMethodBeat.i(321447);
    s.u(paramLaunchParcel, "parcel");
    Object localObject1;
    int i;
    label67:
    long l;
    label74:
    String str2;
    tb localtb;
    if (!paramBoolean)
    {
      localObject1 = i.tWq;
      localObject1 = i.a.cJV();
      i = paramLaunchParcel.euz;
      if (paramString == null)
      {
        localObject1 = null;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label567;
        }
        i = 1;
        if (i != 0) {
          break label572;
        }
        l = 0L;
        str2 = e.a.eqq.aqQ();
        paramLaunchParcel.eoP = str2;
        localtb = new tb();
        localtb.zx((String)localObject1);
        localtb.jAI = l;
        localtb.zy(paramLaunchParcel.appId);
        localtb.ind = paramLaunchParcel.version;
        localtb.jAH = tb.a.oT(paramLaunchParcel.euz + 1);
        localtb.iqr = paramLaunchParcel.siB.scene;
        localtb.zz(com.tencent.mm.plugin.appbrand.report.w.fg(MMApplicationContext.getContext()));
        localtb.zA(paramLaunchParcel.username);
        String str1 = paramLaunchParcel.qAF;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        localtb.zC(r.cg((String)localObject2));
        localObject2 = paramLaunchParcel.ted;
        if (!(localObject2 instanceof AppBrandRuntimeReloadReportBundle)) {
          break label596;
        }
        localObject2 = (AppBrandRuntimeReloadReportBundle)localObject2;
        label234:
        if (localObject2 != null)
        {
          localtb.zD(((AppBrandRuntimeReloadReportBundle)localObject2).teY);
          localtb.zE(((AppBrandRuntimeReloadReportBundle)localObject2).teZ);
        }
        localObject2 = (CharSequence)paramLaunchParcel.username;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label602;
        }
        i = 1;
        label287:
        if ((i == 0) && (MMApplicationContext.isMainProcess()))
        {
          if (!((com.tencent.mm.plugin.appbrand.appusage.j)n.ag(com.tencent.mm.plugin.appbrand.appusage.j.class)).WI(paramLaunchParcel.username)) {
            break label607;
          }
          i = 0;
          label317:
          localtb.jAN = i;
        }
        localtb.jAO = paramLaunchParcel.launchMode;
        localtb.jAP = paramLaunchParcel.epm.etL;
        localtb.jAQ = localtb.F("shortLink", paramLaunchParcel.qAX, true);
        localObject2 = paramLaunchParcel.siB;
        if ((localObject2 == null) || (1036 != ((AppBrandStatObject)localObject2).scene)) {
          break label612;
        }
        i = j;
        label388:
        if (i != 0)
        {
          localObject2 = paramLaunchParcel.eoV;
          if (localObject2 != null) {
            break label617;
          }
          localObject2 = null;
          label406:
          localtb.zB((String)localObject2);
        }
        localObject2 = paramLaunchParcel.siB;
        if (localObject2 != null) {
          break label627;
        }
      }
    }
    label567:
    label572:
    label596:
    label602:
    label607:
    label612:
    label617:
    label627:
    for (Object localObject2 = localObject3;; localObject2 = ((AppBrandStatObject)localObject2).hzx)
    {
      localtb.zG((String)localObject2);
      localtb.gb(System.currentTimeMillis());
      localtb.zF(str2);
      Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString + "] instanceId[" + localtb.ilM + "] sessionId[" + localtb.ilK + ']');
      localtb.bMH();
      AppMethodBeat.o(321447);
      return localObject1;
      localObject1 = ((com.tencent.luggage.sdk.processes.d)localObject1).E(paramString, i);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.luggage.sdk.processes.e)localObject1).eup;
      break;
      i = 0;
      break label67;
      localObject1 = d.a.eqo.aqP();
      s.s(localObject1, "INSTANCE.createInstanceId()");
      l = 1L;
      break label74;
      localObject2 = null;
      break label234;
      i = 0;
      break label287;
      i = 1;
      break label317;
      i = 0;
      break label388;
      localObject2 = ((AppBrandLaunchReferrer)localObject2).appId;
      break label406;
    }
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(321455);
    s.u(paramLaunchParcel, "parcel");
    s.u(paramString1, "instanceId");
    if (paramLaunchParcel.siB.tOm != null)
    {
      ss localss = new ss();
      localss.zi(paramString1);
      localss.jzD = paramLaunchParcel.siB.tOm.getInt("CgiSpeedOutSideStructCgiNo");
      localss.zl(paramLaunchParcel.siB.tOm.getString("CgiSpeedOutSideStructNetworkType"));
      localss.zk(paramLaunchParcel.username);
      localss.zj(paramString2);
      localss.jzC = paramLaunchParcel.siB.tOm.getInt("CgiSpeedOutSideStructBizRet");
      localss.iQF = paramLaunchParcel.siB.tOm.getLong("CgiSpeedOutSideStructCostTime");
      localss.jzz = paramLaunchParcel.siB.tOm.getLong("CgiSpeedOutSideStructEndTimeStamp");
      localss.jzA = paramLaunchParcel.siB.tOm.getLong("CgiSpeedOutSideStructResponseSize");
      localss.jzB = paramLaunchParcel.siB.tOm.getInt("CgiSpeedOutSideStructRet");
      localss.jzy = paramLaunchParcel.siB.tOm.getLong("CgiSpeedOutSideStructStartTimeStamp");
      localss.bMH();
    }
    AppMethodBeat.o(321455);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.w paramw, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 1L;
    Object localObject = null;
    tb localtb = null;
    AppMethodBeat.i(51053);
    s.u(paramw, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = b.afZ(paramw.mAppId);
    if (localQualitySessionRuntime == null)
    {
      localObject = localtb;
      if (localObject == null)
      {
        s.u(paramw, "$runtime");
        Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen NULL session, appId[" + paramw.mAppId + ']');
      }
      AppMethodBeat.o(51053);
      return;
    }
    localtb = new tb();
    localtb.zy(localQualitySessionRuntime.appId);
    localtb.ind = localQualitySessionRuntime.tSh;
    localtb.jAH = tb.a.oT(localQualitySessionRuntime.tQx);
    localtb.jax = localQualitySessionRuntime.apptype;
    localtb.iqr = paramw.asA().epn.scene;
    localtb.zG(paramw.asA().epn.hzx);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer;
    label207:
    long l1;
    if (1036 == paramw.asA().epn.scene)
    {
      localAppBrandLaunchReferrer = paramw.getInitConfig().eoV;
      if (localAppBrandLaunchReferrer == null) {
        localtb.zB((String)localObject);
      }
    }
    else
    {
      localtb.zz(com.tencent.mm.plugin.appbrand.report.w.fg(MMApplicationContext.getContext()));
      localtb.zA(paramw.getInitConfig().username);
      localtb.zx(localQualitySessionRuntime.eup);
      localtb.zF(paramw.getInitConfig().eoP);
      if (!paramBoolean1) {
        break label504;
      }
      l1 = 0L;
      label271:
      localtb.jAI = l1;
      localtb.gb(System.currentTimeMillis());
      if (!paramBoolean2) {
        break label510;
      }
      l1 = l2;
      label295:
      localtb.jAJ = l1;
      localtb.jAq = localQualitySessionRuntime.cJl();
      localtb.zC(r.cg(paramw.cby()));
      localObject = paramw.getInitConfig().qYu;
      if (localObject != null)
      {
        localtb.zD(((AppBrandRuntimeReloadReportBundle)localObject).teY);
        localtb.zE(((AppBrandRuntimeReloadReportBundle)localObject).teZ);
      }
      if (!localQualitySessionRuntime.tSj) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      localtb.jAN = i;
      localtb.jAO = paramw.getInitConfig().launchMode;
      localtb.jAP = paramw.getInitConfig().epm.etL;
      Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report username[" + paramw.getInitConfig().username + "] appId[" + paramw.mAppId + "], instanceId[" + localtb.ilM + "], sessionId[" + localtb.ilK + ']');
      localtb.bMH();
      localObject = localtb;
      break;
      localObject = localAppBrandLaunchReferrer.appId;
      break label207;
      label504:
      l1 = 1L;
      break label271;
      label510:
      l1 = 0L;
      break label295;
    }
  }
  
  public static final tk d(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    s.u(paramQualitySession, "session");
    tk localtk = new tk();
    localtk.zP(paramQualitySession.appId);
    localtk.zO(paramQualitySession.eup);
    localtk.jCT = tk.a.pa(paramQualitySession.tQx);
    localtk.jax = paramQualitySession.apptype;
    localtk.iqr = paramQualitySession.scene;
    localtk.ind = paramQualitySession.tSh;
    AppMethodBeat.o(51050);
    return localtk;
  }
  
  public static final String d(LaunchParcel paramLaunchParcel, String paramString)
  {
    AppMethodBeat.i(321459);
    s.u(paramLaunchParcel, "parcel");
    paramLaunchParcel = a(paramLaunchParcel, paramString, false);
    AppMethodBeat.o(321459);
    return paramLaunchParcel;
  }
  
  public static final tn e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    s.u(paramQualitySession, "session");
    tn localtn = new tn();
    localtn.zV(paramQualitySession.appId);
    localtn.ilM = localtn.F("InstanceId", paramQualitySession.eup, true);
    localtn.jDC = tn.a.pe(paramQualitySession.tQx);
    localtn.jax = paramQualitySession.apptype;
    localtn.iqr = paramQualitySession.scene;
    localtn.ind = paramQualitySession.tSh;
    AppMethodBeat.o(51051);
    return localtn;
  }
  
  public static final tm f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(321423);
    s.u(paramQualitySession, "session");
    tm localtm = new tm();
    localtm.imT = localtm.F("AppId", paramQualitySession.appId, true);
    localtm.ilM = localtm.F("InstanceId", paramQualitySession.eup, true);
    localtm.jDs = tm.a.pd(paramQualitySession.tQx);
    localtm.jax = paramQualitySession.apptype;
    localtm.iqr = paramQualitySession.scene;
    localtm.ind = paramQualitySession.tSh;
    AppMethodBeat.o(321423);
    return localtm;
  }
  
  public static final QualitySessionRuntime g(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51052);
    s.u(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    s.s(localParcel, "obtain()");
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
    String str = com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext());
    s.checkNotNull(str);
    if (s.p(str, com.tencent.mm.plugin.appbrand.report.j.tNY))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (s.p(str, com.tencent.mm.plugin.appbrand.report.j.tNZ))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (s.p(str, com.tencent.mm.plugin.appbrand.report.j.tOa))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (s.p(str, com.tencent.mm.plugin.appbrand.report.j.tOb))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (s.p(str, com.tencent.mm.plugin.appbrand.report.j.tOc))
    {
      AppMethodBeat.o(51049);
      return 4;
    }
    if (s.p(str, "offline"))
    {
      AppMethodBeat.o(51049);
      return 5;
    }
    AppMethodBeat.o(51049);
    return 10000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */