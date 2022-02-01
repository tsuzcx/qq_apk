package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.g.b.a.im.a;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.g.b.a.iu.a;
import com.tencent.mm.g.b.a.iw;
import com.tencent.mm.g.b.a.iw.a;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.g.b.a.ix.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "isLaunch", "", "appId", "versionType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "reportGetA8KeyIfScanEnterBeforeLaunch", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f muG;
  
  static
  {
    AppMethodBeat.i(51058);
    muG = new f();
    AppMethodBeat.o(51058);
  }
  
  public static final String a(final d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51055);
    p.h(paramd, "from");
    p.h(paramLaunchParcel, "parcel");
    y.d locald = new y.d();
    locald.MLT = 0;
    Object localObject1 = com.tencent.mm.plugin.appbrand.a.Kj(paramLaunchParcel.appId);
    if (localObject1 != null)
    {
      if ((!((o)localObject1).aVX()) || (((o)localObject1).isDestroyed()) || (((o)localObject1).aVL() != paramLaunchParcel.hQh)) {
        break label164;
      }
      localObject1 = a.Ut(((o)localObject1).getAppId());
      if (localObject1 == null) {
        break label164;
      }
    }
    label164:
    for (localObject1 = ((QualitySessionRuntime)localObject1).lEv;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (String)((d.g.a.a)new b(locald, paramd)).invoke();
      }
      paramd = new im();
      paramd.rb((String)localObject2);
      paramd.om(locald.MLT);
      a(paramd, paramLaunchParcel);
      paramd.ol(System.currentTimeMillis());
      paramd.aLk();
      AppMethodBeat.o(51055);
      return localObject2;
    }
  }
  
  private static void a(im paramim, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51056);
    paramim.rc(paramLaunchParcel.appId);
    paramim.oi(paramLaunchParcel.version);
    paramim.a(im.a.js(paramLaunchParcel.hQh + 1));
    paramim.ok(paramLaunchParcel.lMZ.scene);
    paramim.rd(com.tencent.mm.plugin.appbrand.report.q.dK(aj.getContext()));
    paramim.re(paramLaunchParcel.username);
    Object localObject2 = paramLaunchParcel.jCN;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    paramim.rf(com.tencent.mm.compatible.util.q.encode((String)localObject1));
    localObject2 = paramLaunchParcel.lNg;
    localObject1 = localObject2;
    if (!(localObject2 instanceof AppBrandRuntimeReloadReportBundle)) {
      localObject1 = null;
    }
    localObject1 = (AppBrandRuntimeReloadReportBundle)localObject1;
    if (localObject1 != null)
    {
      paramim.rg(((AppBrandRuntimeReloadReportBundle)localObject1).lNE);
      paramim.rh(((AppBrandRuntimeReloadReportBundle)localObject1).lNF);
    }
    localObject1 = (CharSequence)paramLaunchParcel.username;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if ((i == 0) && (aj.cmR())) {
        if (!((k)j.T(k.class)).ME(paramLaunchParcel.username)) {
          break label214;
        }
      }
    }
    label214:
    for (int i = 0;; i = 1)
    {
      paramim.jr(i);
      AppMethodBeat.o(51056);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51054);
    p.h(paramLaunchParcel, "parcel");
    p.h(paramString1, "instanceId");
    im localim = new im();
    localim.rb(paramString1);
    paramString1 = (CharSequence)com.tencent.mm.plugin.appbrand.task.f.cb(paramString2, paramLaunchParcel.hQh);
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label165;
      }
    }
    label165:
    for (long l = 1L;; l = 0L)
    {
      localim.om(l);
      a(localim, paramLaunchParcel);
      localim.ol(System.currentTimeMillis());
      ad.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString2 + "] instanceId[" + localim.Uz() + ']');
      localim.aLk();
      AppMethodBeat.o(51054);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void a(o paramo, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 1L;
    AppMethodBeat.i(51053);
    p.h(paramo, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = a.Ut(paramo.getAppId());
    if (localQualitySessionRuntime != null)
    {
      im localim = new im();
      localim.rc(localQualitySessionRuntime.appId);
      localim.oi(localQualitySessionRuntime.mvi);
      localim.a(im.a.js(localQualitySessionRuntime.mtG));
      localim.oj(localQualitySessionRuntime.apptype);
      localim.ok(paramo.Ea().scene);
      localim.rd(com.tencent.mm.plugin.appbrand.report.q.dK(aj.getContext()));
      localim.re(paramo.aXc().username);
      localim.rb(localQualitySessionRuntime.lEv);
      long l1;
      if (paramBoolean1)
      {
        l1 = 0L;
        localim.om(l1);
        localim.ol(System.currentTimeMillis());
        if (!paramBoolean2) {
          break label327;
        }
        l1 = l2;
        label170:
        localim.on(l1);
        p.g(localQualitySessionRuntime, "session");
        localim.oo(localQualitySessionRuntime.bxX());
        localim.rf(com.tencent.mm.compatible.util.q.encode(paramo.aVW()));
        AppBrandRuntimeReloadReportBundle localAppBrandRuntimeReloadReportBundle = paramo.aXc().jXM;
        if (localAppBrandRuntimeReloadReportBundle != null)
        {
          localim.rg(localAppBrandRuntimeReloadReportBundle.lNE);
          localim.rh(localAppBrandRuntimeReloadReportBundle.lNF);
        }
        if (!localQualitySessionRuntime.mvk) {
          break label333;
        }
      }
      label327:
      label333:
      for (int i = 1;; i = 0)
      {
        localim.jr(i);
        ad.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report appId[" + paramo.getAppId() + "], instanceId[" + localQualitySessionRuntime.lEv + ']');
        localim.aLk();
        AppMethodBeat.o(51053);
        return;
        l1 = 1L;
        break;
        l1 = 0L;
        break label170;
      }
    }
    ((d.g.a.a)new a(paramo)).invoke();
    AppMethodBeat.o(51053);
  }
  
  public static final void a(kv_14609 paramkv_14609, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51057);
    p.h(paramkv_14609, "$this$assignFromQualitySession");
    p.h(paramQualitySession, "session");
    paramkv_14609.Us(paramQualitySession.lEv);
    paramkv_14609.appType = paramQualitySession.apptype;
    paramkv_14609.scene = paramQualitySession.scene;
    AppMethodBeat.o(51057);
  }
  
  public static final void b(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189589);
    p.h(paramLaunchParcel, "parcel");
    p.h(paramString1, "instanceId");
    if (paramLaunchParcel.lMZ.mrA != null)
    {
      ie localie = new ie();
      localie.qN(paramString1);
      localie.jl(paramLaunchParcel.lMZ.mrA.getInt("CgiSpeedOutSideStructCgiNo"));
      localie.qQ(paramLaunchParcel.lMZ.mrA.getString("CgiSpeedOutSideStructNetworkType"));
      localie.qP(paramLaunchParcel.username);
      localie.qO(paramString2);
      localie.jk(paramLaunchParcel.lMZ.mrA.getInt("CgiSpeedOutSideStructBizRet"));
      localie.nH(paramLaunchParcel.lMZ.mrA.getLong("CgiSpeedOutSideStructCostTime"));
      localie.nG(paramLaunchParcel.lMZ.mrA.getLong("CgiSpeedOutSideStructEndTimeStamp"));
      localie.nI(paramLaunchParcel.lMZ.mrA.getLong("CgiSpeedOutSideStructResponseSize"));
      localie.jj(paramLaunchParcel.lMZ.mrA.getInt("CgiSpeedOutSideStructRet"));
      localie.nF(paramLaunchParcel.lMZ.mrA.getLong("CgiSpeedOutSideStructStartTimeStamp"));
      localie.aLk();
    }
    AppMethodBeat.o(189589);
  }
  
  public static final iu e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    p.h(paramQualitySession, "session");
    iu localiu = new iu();
    localiu.ru(paramQualitySession.appId);
    localiu.rt(paramQualitySession.lEv);
    localiu.a(iu.a.jz(paramQualitySession.mtG));
    localiu.oK(paramQualitySession.apptype);
    localiu.oM(paramQualitySession.scene);
    localiu.oJ(paramQualitySession.mvi);
    AppMethodBeat.o(51050);
    return localiu;
  }
  
  public static final ix f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    p.h(paramQualitySession, "session");
    ix localix = new ix();
    localix.rB(paramQualitySession.appId);
    localix.rA(paramQualitySession.lEv);
    localix.a(ix.a.jD(paramQualitySession.mtG));
    localix.pe(paramQualitySession.apptype);
    localix.pg(paramQualitySession.scene);
    localix.pd(paramQualitySession.mvi);
    AppMethodBeat.o(51051);
    return localix;
  }
  
  public static final iw g(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(189588);
    p.h(paramQualitySession, "session");
    iw localiw = new iw();
    localiw.rz(paramQualitySession.appId);
    localiw.ry(paramQualitySession.lEv);
    localiw.a(iw.a.jC(paramQualitySession.mtG));
    localiw.oY(paramQualitySession.apptype);
    localiw.pa(paramQualitySession.scene);
    localiw.oX(paramQualitySession.mvi);
    AppMethodBeat.o(189588);
    return localiw;
  }
  
  public static final int getNetworkType()
  {
    AppMethodBeat.i(51049);
    String str = h.getNetworkType(aj.getContext());
    if (str == null) {
      p.gfZ();
    }
    if (p.i(str, h.mrn))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (p.i(str, h.mro))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (p.i(str, h.mrp))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (p.i(str, h.mrq))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (p.i(str, h.mrr))
    {
      AppMethodBeat.o(51049);
      return 4;
    }
    if (p.i(str, "offline"))
    {
      AppMethodBeat.o(51049);
      return 5;
    }
    AppMethodBeat.o(51049);
    return 10000;
  }
  
  public static final QualitySessionRuntime h(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51052);
    p.h(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramQualitySession.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQualitySession = new QualitySessionRuntime(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(51052);
    return paramQualitySession;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    b(y.d paramd, d paramd1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */