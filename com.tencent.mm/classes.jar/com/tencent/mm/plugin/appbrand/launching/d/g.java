package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.gb.b;
import com.tencent.mm.g.b.a.gb.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.uw;
import d.g.b.k;
import d.l;
import java.util.concurrent.FutureTask;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends a<c.a<bkx>>
{
  public static final a kOg;
  private final String appId;
  private final AppBrandLaunchReferrer cfi;
  private final int enterScene;
  private final int gXn;
  private final AppBrandStatObject iJL;
  private final String iJb;
  public boolean iwh;
  private boolean jTB;
  private final String jdA;
  private c.a<bkx> kOe;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    kOg = new a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4)
  {
    this.userName = paramString1;
    this.gXn = paramInt1;
    this.enterScene = paramInt2;
    this.iJb = paramString2;
    this.iJL = paramAppBrandStatObject;
    this.cfi = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.jdA = paramString4;
  }
  
  public final int Ei()
  {
    return 0;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(196403);
    k.h(paramQualitySession, "qualitySession");
    if (this.kOe == null)
    {
      AppMethodBeat.o(196403);
      return;
    }
    gb localgb = f.f(paramQualitySession);
    String str = this.appId;
    paramQualitySession = str;
    if (str == null) {
      paramQualitySession = "";
    }
    localgb.lP(paramQualitySession);
    localgb.lQ(this.userName);
    localgb.Sh();
    localgb.jJ(f.getNetworkType());
    long l;
    if (this.iwh)
    {
      paramQualitySession = gb.b.efF;
      localgb.a(paramQualitySession);
      localgb.jH(this.cik);
      localgb.jI(this.cil);
      localgb.jF(this.cil - this.cik);
      if (!this.jTB) {
        break label276;
      }
      l = 1L;
      label147:
      localgb.jK(l);
      paramQualitySession = this.kOe;
      if (paramQualitySession == null) {
        k.fvU();
      }
      int i = paramQualitySession.errType;
      paramQualitySession = this.kOe;
      if (paramQualitySession == null) {
        k.fvU();
      }
      int j = paramQualitySession.errCode;
      paramQualitySession = this.kOe;
      if (paramQualitySession == null) {
        k.fvU();
      }
      if (!com.tencent.mm.plugin.appbrand.p.a.a(i, j, paramQualitySession.gUK)) {
        break label343;
      }
      paramQualitySession = this.kOe;
      if (paramQualitySession == null) {
        k.fvU();
      }
      paramQualitySession = paramQualitySession.gUK;
      if (paramQualitySession == null) {
        k.fvU();
      }
      if (((bkx)paramQualitySession).DIL != null) {
        break label282;
      }
      localgb.a(gb.c.efK);
    }
    for (;;)
    {
      localgb.aBj();
      AppMethodBeat.o(196403);
      return;
      paramQualitySession = gb.b.efG;
      break;
      label276:
      l = 0L;
      break label147;
      label282:
      paramQualitySession = this.kOe;
      if (paramQualitySession == null) {
        k.fvU();
      }
      paramQualitySession = paramQualitySession.gUK;
      if (paramQualitySession == null) {
        k.fvU();
      }
      if (((bkx)paramQualitySession).DIL.CWN == null)
      {
        localgb.a(gb.c.efL);
      }
      else
      {
        localgb.a(gb.c.efI);
        continue;
        label343:
        localgb.a(gb.c.efJ);
      }
    }
  }
  
  public final c.a<bkx> sT(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (((com.tencent.luggage.sdk.e.a)this).cij == null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(180641);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cij;
    if (localObject == null) {
      k.aPZ("futureTask");
    }
    if (((FutureTask)localObject).isDone()) {
      b.lI(5);
    }
    for (;;)
    {
      localObject = (c.a)super.gN(paramInt);
      AppMethodBeat.o(180641);
      return localObject;
      b.lI(6);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */