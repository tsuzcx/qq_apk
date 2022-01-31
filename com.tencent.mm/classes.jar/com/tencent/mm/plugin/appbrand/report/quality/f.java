package com.tencent.mm.plugin.appbrand.report.quality;

import a.f.b.u.c;
import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.g.b.a.cn.a;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.cq.a;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.cs.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "generateInstanceId", "", "uin", "", "getNetworkType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "nilAs", "as", "Lkotlin/Function0;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f iIA;
  
  static
  {
    AppMethodBeat.i(134958);
    iIA = new f();
    AppMethodBeat.o(134958);
  }
  
  public static final cq a(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(134951);
    a.f.b.j.q(paramQualitySession, "session");
    cq localcq = new cq();
    localcq.hP(paramQualitySession.appId);
    localcq.hO(paramQualitySession.ikX);
    localcq.a(cq.a.hd(paramQualitySession.iIF));
    localcq.ff(paramQualitySession.apptype);
    localcq.fh(paramQualitySession.scene);
    localcq.fe(paramQualitySession.iIG);
    AppMethodBeat.o(134951);
    return localcq;
  }
  
  public static final String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(134955);
    a.f.b.j.q(paramLaunchParcel, "parcel");
    String str = paramLaunchParcel.appId;
    Object localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        str = q.Aq(paramLaunchParcel.username);
      }
      str = h.bw(str, paramLaunchParcel.hcr);
      localObject = (CharSequence)str;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label148;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label153;
      }
      a.f.b.j.p(g.RJ(), "MMKernel.account()");
      str = pz(com.tencent.mm.kernel.a.getUin());
    }
    label148:
    label153:
    for (int i = 1;; i = 0)
    {
      if (str == null) {
        a.f.b.j.ebi();
      }
      localObject = new cn();
      ((cn)localObject).hF(str);
      ((cn)localObject).fd(i);
      a((cn)localObject, paramLaunchParcel);
      ((cn)localObject).ake();
      AppMethodBeat.o(134955);
      return str;
      i = 0;
      break;
      i = 0;
      break label77;
    }
  }
  
  private static void a(cn paramcn, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(134957);
    paramcn.hG(paramLaunchParcel.appId);
    paramcn.fa(paramLaunchParcel.version);
    paramcn.a(cn.a.ha(paramLaunchParcel.hcr + 1));
    paramcn.fc(paramLaunchParcel.inG.scene);
    paramcn.hH(m.da(ah.getContext()));
    paramcn.hI(paramLaunchParcel.username);
    AppMethodBeat.o(134957);
  }
  
  public static final void a(o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(134954);
    a.f.b.j.q(paramo, "runtime");
    QualitySessionRuntime localQualitySessionRuntime = a.EM(paramo.getAppId());
    if (localQualitySessionRuntime != null)
    {
      cn localcn = new cn();
      localcn.hG(localQualitySessionRuntime.appId);
      localcn.fa(localQualitySessionRuntime.iIG);
      localcn.a(cn.a.ha(localQualitySessionRuntime.iIF));
      localcn.fb(localQualitySessionRuntime.apptype);
      localcn.fc(paramo.vX().scene);
      localcn.hH(m.da(ah.getContext()));
      localcn.hI(paramo.atS().username);
      localcn.hF(localQualitySessionRuntime.ikX);
      if (paramBoolean) {}
      for (long l = 0L;; l = 1L)
      {
        localcn.fd(l);
        localcn.ake();
        AppMethodBeat.o(134954);
        return;
      }
    }
    AppMethodBeat.o(134954);
  }
  
  public static final cs b(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(134952);
    a.f.b.j.q(paramQualitySession, "session");
    cs localcs = new cs();
    localcs.hT(paramQualitySession.appId);
    localcs.hS(paramQualitySession.ikX);
    localcs.a(cs.a.hg(paramQualitySession.iIF));
    localcs.fo(paramQualitySession.apptype);
    localcs.fq(paramQualitySession.scene);
    localcs.fn(paramQualitySession.iIG);
    AppMethodBeat.o(134952);
    return localcs;
  }
  
  public static final String b(d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(134956);
    a.f.b.j.q(paramd, "from");
    a.f.b.j.q(paramLaunchParcel, "parcel");
    u.c localc = new u.c();
    localc.BNp = 0;
    Object localObject1 = com.tencent.mm.plugin.appbrand.a.xL(paramLaunchParcel.appId);
    if (localObject1 != null)
    {
      if ((!((o)localObject1).atp()) || (((o)localObject1).finished()) || (((o)localObject1).ath() != paramLaunchParcel.hcr)) {
        break label159;
      }
      localObject1 = a.EM(((o)localObject1).getAppId());
      if (localObject1 == null) {
        break label159;
      }
    }
    label159:
    for (localObject1 = ((QualitySessionRuntime)localObject1).ikX;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (String)((a.f.a.a)new f.a(localc, paramd)).invoke();
      }
      paramd = new cn();
      paramd.hF((String)localObject2);
      paramd.fd(localc.BNp);
      a(paramd, paramLaunchParcel);
      paramd.ake();
      AppMethodBeat.o(134956);
      return localObject2;
    }
  }
  
  public static final QualitySessionRuntime c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(134953);
    a.f.b.j.q(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramQualitySession.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQualitySession = new QualitySessionRuntime(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(134953);
    return paramQualitySession;
  }
  
  public static final int getNetworkType()
  {
    AppMethodBeat.i(134949);
    String str = e.cZ(ah.getContext());
    if (str == null) {
      a.f.b.j.ebi();
    }
    if (a.f.b.j.e(str, e.iFN))
    {
      AppMethodBeat.o(134949);
      return 0;
    }
    if (a.f.b.j.e(str, e.iFO))
    {
      AppMethodBeat.o(134949);
      return 1;
    }
    if (a.f.b.j.e(str, e.iFP))
    {
      AppMethodBeat.o(134949);
      return 2;
    }
    if (a.f.b.j.e(str, e.iFQ))
    {
      AppMethodBeat.o(134949);
      return 3;
    }
    if (a.f.b.j.e(str, e.iFR))
    {
      AppMethodBeat.o(134949);
      return 4;
    }
    if (a.f.b.j.e(str, "offline"))
    {
      AppMethodBeat.o(134949);
      return 5;
    }
    AppMethodBeat.o(134949);
    return 10000;
  }
  
  public static final String pz(int paramInt)
  {
    AppMethodBeat.i(134950);
    String str = p.getString(paramInt);
    a.f.b.j.p(str, "UIN.getString(uin)");
    str = a.a.j.a((Iterable)a.a.j.listOf(new String[] { str, String.valueOf(bo.aoy()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(134950);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */