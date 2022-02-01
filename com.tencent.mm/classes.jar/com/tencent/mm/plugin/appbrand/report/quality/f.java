package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.g.b.a.fq.a;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.fy.a;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.g.b.a.ga.a;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.gb.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.g.b.v.c;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "isLaunch", "", "appId", "versionType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f lsW;
  
  static
  {
    AppMethodBeat.i(51058);
    lsW = new f();
    AppMethodBeat.o(51058);
  }
  
  public static final String a(final d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51055);
    k.h(paramd, "from");
    k.h(paramLaunchParcel, "parcel");
    v.c localc = new v.c();
    localc.Jhu = 0;
    Object localObject1 = com.tencent.mm.plugin.appbrand.a.CR(paramLaunchParcel.appId);
    if (localObject1 != null)
    {
      if ((!((o)localObject1).aLT()) || (((o)localObject1).isDestroyed()) || (((o)localObject1).aLI() != paramLaunchParcel.gXn)) {
        break label164;
      }
      localObject1 = a.ME(((o)localObject1).getAppId());
      if (localObject1 == null) {
        break label164;
      }
    }
    label164:
    for (localObject1 = ((QualitySessionRuntime)localObject1).kGa;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (String)((d.g.a.a)new b(localc, paramd)).invoke();
      }
      paramd = new fq();
      paramd.ls((String)localObject2);
      paramd.iM(localc.Jhu);
      a(paramd, paramLaunchParcel);
      paramd.iL(System.currentTimeMillis());
      paramd.aBj();
      AppMethodBeat.o(51055);
      return localObject2;
    }
  }
  
  private static void a(fq paramfq, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51056);
    paramfq.lt(paramLaunchParcel.appId);
    paramfq.iI(paramLaunchParcel.version);
    paramfq.a(fq.a.iX(paramLaunchParcel.gXn + 1));
    paramfq.iK(paramLaunchParcel.kOh.scene);
    paramfq.lu(q.dC(aj.getContext()));
    paramfq.lv(paramLaunchParcel.username);
    AppMethodBeat.o(51056);
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51054);
    k.h(paramLaunchParcel, "parcel");
    k.h(paramString1, "instanceId");
    fq localfq = new fq();
    localfq.ls(paramString1);
    paramString1 = (CharSequence)com.tencent.mm.plugin.appbrand.task.f.bT(paramString2, paramLaunchParcel.gXn);
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label158;
      }
    }
    label158:
    for (long l = 1L;; l = 0L)
    {
      localfq.iM(l);
      a(localfq, paramLaunchParcel);
      localfq.iL(System.currentTimeMillis());
      ad.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString2 + "] instanceId[" + localfq.Sc() + ']');
      localfq.aBj();
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
    k.h(paramo, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = a.ME(paramo.getAppId());
    if (localQualitySessionRuntime != null)
    {
      fq localfq = new fq();
      localfq.lt(localQualitySessionRuntime.appId);
      localfq.iI(localQualitySessionRuntime.lty);
      localfq.a(fq.a.iX(localQualitySessionRuntime.lrW));
      localfq.iJ(localQualitySessionRuntime.apptype);
      localfq.iK(paramo.CY().scene);
      localfq.lu(q.dC(aj.getContext()));
      localfq.lv(paramo.aNc().username);
      localfq.ls(localQualitySessionRuntime.kGa);
      if (paramBoolean1)
      {
        l1 = 0L;
        localfq.iM(l1);
        localfq.iL(System.currentTimeMillis());
        if (!paramBoolean2) {
          break label255;
        }
      }
      label255:
      for (long l1 = l2;; l1 = 0L)
      {
        localfq.iN(l1);
        k.g(localQualitySessionRuntime, "session");
        localfq.iO(localQualitySessionRuntime.bmX());
        ad.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report appId[" + paramo.getAppId() + "], instanceId[" + localQualitySessionRuntime.kGa + ']');
        localfq.aBj();
        AppMethodBeat.o(51053);
        return;
        l1 = 1L;
        break;
      }
    }
    ((d.g.a.a)new f.a(paramo)).invoke();
    AppMethodBeat.o(51053);
  }
  
  public static final void a(kv_14609 paramkv_14609, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51057);
    k.h(paramkv_14609, "$this$assignFromQualitySession");
    k.h(paramQualitySession, "session");
    paramkv_14609.MD(paramQualitySession.kGa);
    paramkv_14609.appType = paramQualitySession.apptype;
    paramkv_14609.scene = paramQualitySession.scene;
    AppMethodBeat.o(51057);
  }
  
  public static final fy e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    k.h(paramQualitySession, "session");
    fy localfy = new fy();
    localfy.lI(paramQualitySession.appId);
    localfy.lH(paramQualitySession.kGa);
    localfy.a(fy.a.je(paramQualitySession.lrW));
    localfy.jk(paramQualitySession.apptype);
    localfy.jm(paramQualitySession.scene);
    localfy.jj(paramQualitySession.lty);
    AppMethodBeat.o(51050);
    return localfy;
  }
  
  public static final gb f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    k.h(paramQualitySession, "session");
    gb localgb = new gb();
    localgb.lP(paramQualitySession.appId);
    localgb.lO(paramQualitySession.kGa);
    localgb.a(gb.a.ji(paramQualitySession.lrW));
    localgb.jE(paramQualitySession.apptype);
    localgb.jG(paramQualitySession.scene);
    localgb.jD(paramQualitySession.lty);
    AppMethodBeat.o(51051);
    return localgb;
  }
  
  public static final ga g(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(196416);
    k.h(paramQualitySession, "session");
    ga localga = new ga();
    localga.lN(paramQualitySession.appId);
    localga.lM(paramQualitySession.kGa);
    localga.a(ga.a.jh(paramQualitySession.lrW));
    localga.jy(paramQualitySession.apptype);
    localga.jA(paramQualitySession.scene);
    localga.jx(paramQualitySession.lty);
    AppMethodBeat.o(196416);
    return localga;
  }
  
  public static final int getNetworkType()
  {
    AppMethodBeat.i(51049);
    String str = h.getNetworkType(aj.getContext());
    if (str == null) {
      k.fvU();
    }
    if (k.g(str, h.lpB))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (k.g(str, h.lpC))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (k.g(str, h.lpD))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (k.g(str, h.lpE))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (k.g(str, h.lpF))
    {
      AppMethodBeat.o(51049);
      return 4;
    }
    if (k.g(str, "offline"))
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
    k.h(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramQualitySession.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQualitySession = new QualitySessionRuntime(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(51052);
    return paramQualitySession;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    b(v.c paramc, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */