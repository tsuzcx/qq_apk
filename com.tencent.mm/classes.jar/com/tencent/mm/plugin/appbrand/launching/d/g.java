package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.b.a.iz;
import com.tencent.mm.g.b.a.iz.b;
import com.tencent.mm.g.b.a.iz.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.xi;
import d.g.b.p;
import d.l;
import java.util.concurrent.FutureTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setIsUsed", "used", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends a<a.a<bua>>
{
  public static final a lRz;
  private final String appId;
  private final AppBrandLaunchReferrer cmx;
  private final int enterScene;
  private final int hSZ;
  private final String jFL;
  private final AppBrandStatObject jGF;
  public boolean jsn;
  private boolean kTs;
  private final String kbd;
  private a.a<bua> lRx;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    lRz = new a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4)
  {
    this.userName = paramString1;
    this.hSZ = paramInt1;
    this.enterScene = paramInt2;
    this.jFL = paramString2;
    this.jGF = paramAppBrandStatObject;
    this.cmx = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.kbd = paramString4;
  }
  
  public final int Fp()
  {
    return 0;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(223593);
    p.h(paramQualitySession, "qualitySession");
    if (this.lRx == null)
    {
      AppMethodBeat.o(223593);
      return;
    }
    iz localiz = f.f(paramQualitySession);
    String str = this.appId;
    paramQualitySession = str;
    if (str == null) {
      paramQualitySession = "";
    }
    localiz.rW(paramQualitySession);
    localiz.rX(this.userName);
    localiz.Vv();
    localiz.pw(f.getNetworkType());
    long l;
    if (this.jsn)
    {
      paramQualitySession = iz.b.eAv;
      localiz.a(paramQualitySession);
      localiz.pu(this.cpZ);
      localiz.pv(this.cqa);
      localiz.ps(this.cqa - this.cpZ);
      if (!this.kTs) {
        break label276;
      }
      l = 1L;
      label147:
      localiz.px(l);
      paramQualitySession = this.lRx;
      if (paramQualitySession == null) {
        p.gkB();
      }
      int i = paramQualitySession.errType;
      paramQualitySession = this.lRx;
      if (paramQualitySession == null) {
        p.gkB();
      }
      int j = paramQualitySession.errCode;
      paramQualitySession = this.lRx;
      if (paramQualitySession == null) {
        p.gkB();
      }
      if (!com.tencent.mm.plugin.appbrand.n.a.a(i, j, paramQualitySession.hQv)) {
        break label343;
      }
      paramQualitySession = this.lRx;
      if (paramQualitySession == null) {
        p.gkB();
      }
      paramQualitySession = paramQualitySession.hQv;
      if (paramQualitySession == null) {
        p.gkB();
      }
      if (((bua)paramQualitySession).Hhk != null) {
        break label282;
      }
      localiz.a(iz.c.eAA);
    }
    for (;;)
    {
      localiz.aLH();
      AppMethodBeat.o(223593);
      return;
      paramQualitySession = iz.b.eAw;
      break;
      label276:
      l = 0L;
      break label147;
      label282:
      paramQualitySession = this.lRx;
      if (paramQualitySession == null) {
        p.gkB();
      }
      paramQualitySession = paramQualitySession.hQv;
      if (paramQualitySession == null) {
        p.gkB();
      }
      if (((bua)paramQualitySession).Hhk.Gph == null)
      {
        localiz.a(iz.c.eAB);
      }
      else
      {
        localiz.a(iz.c.eAy);
        continue;
        label343:
        localiz.a(iz.c.eAz);
      }
    }
  }
  
  public final a.a<bua> uu(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (((com.tencent.luggage.sdk.e.a)this).cpY == null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(180641);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cpY;
    if (localObject == null) {
      p.bdF("futureTask");
    }
    if (((FutureTask)localObject).isDone()) {
      b.md(5);
    }
    for (;;)
    {
      localObject = (a.a)super.gD(paramInt);
      AppMethodBeat.o(180641);
      return localObject;
      b.md(6);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */