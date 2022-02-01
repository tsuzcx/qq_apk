package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.g.b.a.io;
import com.tencent.mm.g.b.a.io.a;
import com.tencent.mm.g.b.a.iw;
import com.tencent.mm.g.b.a.iw.a;
import com.tencent.mm.g.b.a.iy;
import com.tencent.mm.g.b.a.iy.a;
import com.tencent.mm.g.b.a.iz;
import com.tencent.mm.g.b.a.iz.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.y.d;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "isLaunch", "", "appId", "versionType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "reportGetA8KeyIfScanEnterBeforeLaunch", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f mzD;
  
  static
  {
    AppMethodBeat.i(51058);
    mzD = new f();
    AppMethodBeat.o(51058);
  }
  
  public static final String a(final d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51055);
    d.g.b.p.h(paramd, "from");
    d.g.b.p.h(paramLaunchParcel, "parcel");
    y.d locald = new y.d();
    locald.NiW = 0;
    Object localObject1 = com.tencent.mm.plugin.appbrand.a.KI(paramLaunchParcel.appId);
    if (localObject1 != null)
    {
      if ((!((com.tencent.mm.plugin.appbrand.p)localObject1).aWy()) || (((com.tencent.mm.plugin.appbrand.p)localObject1).isDestroyed()) || (((com.tencent.mm.plugin.appbrand.p)localObject1).aWk() != paramLaunchParcel.hSZ)) {
        break label164;
      }
      localObject1 = a.Ve(((com.tencent.mm.plugin.appbrand.p)localObject1).getAppId());
      if (localObject1 == null) {
        break label164;
      }
    }
    label164:
    for (localObject1 = ((QualitySessionRuntime)localObject1).lIU;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (String)((d.g.a.a)new b(locald, paramd)).invoke();
      }
      paramd = new io();
      paramd.rw((String)localObject2);
      paramd.oy(locald.NiW);
      a(paramd, paramLaunchParcel);
      paramd.ox(System.currentTimeMillis());
      paramd.aLH();
      AppMethodBeat.o(51055);
      return localObject2;
    }
  }
  
  private static void a(io paramio, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51056);
    paramio.rx(paramLaunchParcel.appId);
    paramio.ou(paramLaunchParcel.version);
    paramio.a(io.a.ju(paramLaunchParcel.hSZ + 1));
    paramio.ow(paramLaunchParcel.lRA.scene);
    paramio.ry(com.tencent.mm.plugin.appbrand.report.q.dO(ak.getContext()));
    paramio.rz(paramLaunchParcel.username);
    Object localObject2 = paramLaunchParcel.jFL;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    paramio.rA(com.tencent.mm.compatible.util.q.encode((String)localObject1));
    localObject2 = paramLaunchParcel.lRH;
    localObject1 = localObject2;
    if (!(localObject2 instanceof AppBrandRuntimeReloadReportBundle)) {
      localObject1 = null;
    }
    localObject1 = (AppBrandRuntimeReloadReportBundle)localObject1;
    if (localObject1 != null)
    {
      paramio.rB(((AppBrandRuntimeReloadReportBundle)localObject1).lSf);
      paramio.rC(((AppBrandRuntimeReloadReportBundle)localObject1).lSg);
    }
    localObject1 = (CharSequence)paramLaunchParcel.username;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if ((i == 0) && (ak.coh())) {
        if (!((k)j.T(k.class)).Nl(paramLaunchParcel.username)) {
          break label229;
        }
      }
    }
    label229:
    for (int i = 0;; i = 1)
    {
      paramio.jt(i);
      paramio.oB(paramLaunchParcel.launchMode);
      paramio.Vq();
      AppMethodBeat.o(51056);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51054);
    d.g.b.p.h(paramLaunchParcel, "parcel");
    d.g.b.p.h(paramString1, "instanceId");
    io localio = new io();
    localio.rw(paramString1);
    paramString1 = (CharSequence)com.tencent.mm.plugin.appbrand.task.f.cf(paramString2, paramLaunchParcel.hSZ);
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
      localio.oy(l);
      a(localio, paramLaunchParcel);
      localio.ox(System.currentTimeMillis());
      ae.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString2 + "] instanceId[" + localio.UF() + ']');
      localio.aLH();
      AppMethodBeat.o(51054);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.p paramp, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 1L;
    AppMethodBeat.i(51053);
    d.g.b.p.h(paramp, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = a.Ve(paramp.getAppId());
    if (localQualitySessionRuntime != null)
    {
      io localio = new io();
      localio.rx(localQualitySessionRuntime.appId);
      localio.ou(localQualitySessionRuntime.mAf);
      localio.a(io.a.ju(localQualitySessionRuntime.myD));
      localio.ov(localQualitySessionRuntime.apptype);
      localio.ow(paramp.Ed().scene);
      localio.ry(com.tencent.mm.plugin.appbrand.report.q.dO(ak.getContext()));
      localio.rz(paramp.aXx().username);
      localio.rw(localQualitySessionRuntime.lIU);
      long l1;
      if (paramBoolean1)
      {
        l1 = 0L;
        localio.oy(l1);
        localio.ox(System.currentTimeMillis());
        if (!paramBoolean2) {
          break label347;
        }
        l1 = l2;
        label170:
        localio.oz(l1);
        d.g.b.p.g(localQualitySessionRuntime, "session");
        localio.oA(localQualitySessionRuntime.byQ());
        localio.rA(com.tencent.mm.compatible.util.q.encode(paramp.aWx()));
        AppBrandRuntimeReloadReportBundle localAppBrandRuntimeReloadReportBundle = paramp.aXx().kbb;
        if (localAppBrandRuntimeReloadReportBundle != null)
        {
          localio.rB(localAppBrandRuntimeReloadReportBundle.lSf);
          localio.rC(localAppBrandRuntimeReloadReportBundle.lSg);
        }
        if (!localQualitySessionRuntime.mAh) {
          break label353;
        }
      }
      label347:
      label353:
      for (int i = 1;; i = 0)
      {
        localio.jt(i);
        localio.oB(paramp.aXx().launchMode);
        localio.Vq();
        ae.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report appId[" + paramp.getAppId() + "], instanceId[" + localQualitySessionRuntime.lIU + ']');
        localio.aLH();
        AppMethodBeat.o(51053);
        return;
        l1 = 1L;
        break;
        l1 = 0L;
        break label170;
      }
    }
    ((d.g.a.a)new a(paramp)).invoke();
    AppMethodBeat.o(51053);
  }
  
  public static final void a(kv_14609 paramkv_14609, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51057);
    d.g.b.p.h(paramkv_14609, "$this$assignFromQualitySession");
    d.g.b.p.h(paramQualitySession, "session");
    paramkv_14609.Vd(paramQualitySession.lIU);
    paramkv_14609.appType = paramQualitySession.apptype;
    paramkv_14609.scene = paramQualitySession.scene;
    AppMethodBeat.o(51057);
  }
  
  public static final void b(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(223858);
    d.g.b.p.h(paramLaunchParcel, "parcel");
    d.g.b.p.h(paramString1, "instanceId");
    if (paramLaunchParcel.lRA.mwy != null)
    {
      ig localig = new ig();
      localig.ri(paramString1);
      localig.jn(paramLaunchParcel.lRA.mwy.getInt("CgiSpeedOutSideStructCgiNo"));
      localig.rl(paramLaunchParcel.lRA.mwy.getString("CgiSpeedOutSideStructNetworkType"));
      localig.rk(paramLaunchParcel.username);
      localig.rj(paramString2);
      localig.jm(paramLaunchParcel.lRA.mwy.getInt("CgiSpeedOutSideStructBizRet"));
      localig.nT(paramLaunchParcel.lRA.mwy.getLong("CgiSpeedOutSideStructCostTime"));
      localig.nS(paramLaunchParcel.lRA.mwy.getLong("CgiSpeedOutSideStructEndTimeStamp"));
      localig.nU(paramLaunchParcel.lRA.mwy.getLong("CgiSpeedOutSideStructResponseSize"));
      localig.jl(paramLaunchParcel.lRA.mwy.getInt("CgiSpeedOutSideStructRet"));
      localig.nR(paramLaunchParcel.lRA.mwy.getLong("CgiSpeedOutSideStructStartTimeStamp"));
      localig.aLH();
    }
    AppMethodBeat.o(223858);
  }
  
  public static final iw e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    d.g.b.p.h(paramQualitySession, "session");
    iw localiw = new iw();
    localiw.rP(paramQualitySession.appId);
    localiw.rO(paramQualitySession.lIU);
    localiw.a(iw.a.jB(paramQualitySession.myD));
    localiw.oX(paramQualitySession.apptype);
    localiw.oZ(paramQualitySession.scene);
    localiw.oW(paramQualitySession.mAf);
    AppMethodBeat.o(51050);
    return localiw;
  }
  
  public static final iz f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    d.g.b.p.h(paramQualitySession, "session");
    iz localiz = new iz();
    localiz.rW(paramQualitySession.appId);
    localiz.rV(paramQualitySession.lIU);
    localiz.a(iz.a.jF(paramQualitySession.myD));
    localiz.pr(paramQualitySession.apptype);
    localiz.pt(paramQualitySession.scene);
    localiz.pq(paramQualitySession.mAf);
    AppMethodBeat.o(51051);
    return localiz;
  }
  
  public static final iy g(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(223857);
    d.g.b.p.h(paramQualitySession, "session");
    iy localiy = new iy();
    localiy.rU(paramQualitySession.appId);
    localiy.rT(paramQualitySession.lIU);
    localiy.a(iy.a.jE(paramQualitySession.myD));
    localiy.pl(paramQualitySession.apptype);
    localiy.pn(paramQualitySession.scene);
    localiy.pk(paramQualitySession.mAf);
    AppMethodBeat.o(223857);
    return localiy;
  }
  
  public static final int getNetworkType()
  {
    AppMethodBeat.i(51049);
    String str = h.getNetworkType(ak.getContext());
    if (str == null) {
      d.g.b.p.gkB();
    }
    if (d.g.b.p.i(str, h.mwl))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (d.g.b.p.i(str, h.mwm))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (d.g.b.p.i(str, h.mwn))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (d.g.b.p.i(str, h.mwo))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (d.g.b.p.i(str, h.mwp))
    {
      AppMethodBeat.o(51049);
      return 4;
    }
    if (d.g.b.p.i(str, "offline"))
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
    d.g.b.p.h(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramQualitySession.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQualitySession = new QualitySessionRuntime(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(51052);
    return paramQualitySession;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(com.tencent.mm.plugin.appbrand.p paramp)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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