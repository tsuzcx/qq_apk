package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.g.b.a.hi.a;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.g.b.a.hq.a;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.g.b.a.hs.a;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.ht.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.g.b.v.d;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "getNetworkType", "", "isLaunch", "", "appId", "versionType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f lUQ;
  
  static
  {
    AppMethodBeat.i(51058);
    lUQ = new f();
    AppMethodBeat.o(51058);
  }
  
  public static final String a(final d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51055);
    k.h(paramd, "from");
    k.h(paramLaunchParcel, "parcel");
    v.d locald = new v.d();
    locald.KUO = 0;
    Object localObject1 = com.tencent.mm.plugin.appbrand.a.GU(paramLaunchParcel.appId);
    if (localObject1 != null)
    {
      if ((!((o)localObject1).aSJ()) || (((o)localObject1).isDestroyed()) || (((o)localObject1).aSy() != paramLaunchParcel.hxM)) {
        break label164;
      }
      localObject1 = a.QN(((o)localObject1).getAppId());
      if (localObject1 == null) {
        break label164;
      }
    }
    label164:
    for (localObject1 = ((QualitySessionRuntime)localObject1).lht;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (String)((d.g.a.a)new b(locald, paramd)).invoke();
      }
      paramd = new hi();
      paramd.ox((String)localObject2);
      paramd.mo(locald.KUO);
      a(paramd, paramLaunchParcel);
      paramd.mn(System.currentTimeMillis());
      paramd.aHZ();
      AppMethodBeat.o(51055);
      return localObject2;
    }
  }
  
  private static void a(hi paramhi, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(51056);
    paramhi.oy(paramLaunchParcel.appId);
    paramhi.mk(paramLaunchParcel.version);
    paramhi.a(hi.a.iV(paramLaunchParcel.hxM + 1));
    paramhi.mm(paramLaunchParcel.lpG.scene);
    paramhi.oz(p.dL(ai.getContext()));
    paramhi.oA(paramLaunchParcel.username);
    AppMethodBeat.o(51056);
  }
  
  public static final void a(LaunchParcel paramLaunchParcel, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51054);
    k.h(paramLaunchParcel, "parcel");
    k.h(paramString1, "instanceId");
    hi localhi = new hi();
    localhi.ox(paramString1);
    paramString1 = (CharSequence)com.tencent.mm.plugin.appbrand.task.f.bY(paramString2, paramLaunchParcel.hxM);
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
      localhi.mo(l);
      a(localhi, paramLaunchParcel);
      localhi.mn(System.currentTimeMillis());
      ac.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + paramLaunchParcel.username + "] appId[" + paramString2 + "] instanceId[" + localhi.SV() + ']');
      localhi.aHZ();
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
    QualitySessionRuntime localQualitySessionRuntime = a.QN(paramo.getAppId());
    if (localQualitySessionRuntime != null)
    {
      hi localhi = new hi();
      localhi.oy(localQualitySessionRuntime.appId);
      localhi.mk(localQualitySessionRuntime.lVs);
      localhi.a(hi.a.iV(localQualitySessionRuntime.lTR));
      localhi.ml(localQualitySessionRuntime.apptype);
      localhi.mm(paramo.CB().scene);
      localhi.oz(p.dL(ai.getContext()));
      localhi.oA(paramo.aTS().username);
      localhi.ox(localQualitySessionRuntime.lht);
      if (paramBoolean1)
      {
        l1 = 0L;
        localhi.mo(l1);
        localhi.mn(System.currentTimeMillis());
        if (!paramBoolean2) {
          break label255;
        }
      }
      label255:
      for (long l1 = l2;; l1 = 0L)
      {
        localhi.mp(l1);
        k.g(localQualitySessionRuntime, "session");
        localhi.mq(localQualitySessionRuntime.btT());
        ac.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report appId[" + paramo.getAppId() + "], instanceId[" + localQualitySessionRuntime.lht + ']');
        localhi.aHZ();
        AppMethodBeat.o(51053);
        return;
        l1 = 1L;
        break;
      }
    }
    ((d.g.a.a)new a(paramo)).invoke();
    AppMethodBeat.o(51053);
  }
  
  public static final void a(kv_14609 paramkv_14609, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51057);
    k.h(paramkv_14609, "$this$assignFromQualitySession");
    k.h(paramQualitySession, "session");
    paramkv_14609.QM(paramQualitySession.lht);
    paramkv_14609.appType = paramQualitySession.apptype;
    paramkv_14609.scene = paramQualitySession.scene;
    AppMethodBeat.o(51057);
  }
  
  public static final hq e(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51050);
    k.h(paramQualitySession, "session");
    hq localhq = new hq();
    localhq.oN(paramQualitySession.appId);
    localhq.oM(paramQualitySession.lht);
    localhq.a(hq.a.jc(paramQualitySession.lTR));
    localhq.mM(paramQualitySession.apptype);
    localhq.mO(paramQualitySession.scene);
    localhq.mL(paramQualitySession.lVs);
    AppMethodBeat.o(51050);
    return localhq;
  }
  
  public static final ht f(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(51051);
    k.h(paramQualitySession, "session");
    ht localht = new ht();
    localht.oU(paramQualitySession.appId);
    localht.oT(paramQualitySession.lht);
    localht.a(ht.a.jg(paramQualitySession.lTR));
    localht.ng(paramQualitySession.apptype);
    localht.ni(paramQualitySession.scene);
    localht.nf(paramQualitySession.lVs);
    AppMethodBeat.o(51051);
    return localht;
  }
  
  public static final hs g(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(187377);
    k.h(paramQualitySession, "session");
    hs localhs = new hs();
    localhs.oS(paramQualitySession.appId);
    localhs.oR(paramQualitySession.lht);
    localhs.a(hs.a.jf(paramQualitySession.lTR));
    localhs.na(paramQualitySession.apptype);
    localhs.nc(paramQualitySession.scene);
    localhs.mZ(paramQualitySession.lVs);
    AppMethodBeat.o(187377);
    return localhs;
  }
  
  public static final int getNetworkType()
  {
    AppMethodBeat.i(51049);
    String str = g.getNetworkType(ai.getContext());
    if (str == null) {
      k.fOy();
    }
    if (k.g(str, g.lRx))
    {
      AppMethodBeat.o(51049);
      return 0;
    }
    if (k.g(str, g.lRy))
    {
      AppMethodBeat.o(51049);
      return 1;
    }
    if (k.g(str, g.lRz))
    {
      AppMethodBeat.o(51049);
      return 2;
    }
    if (k.g(str, g.lRA))
    {
      AppMethodBeat.o(51049);
      return 3;
    }
    if (k.g(str, g.lRB))
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    b(v.d paramd, d paramd1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */