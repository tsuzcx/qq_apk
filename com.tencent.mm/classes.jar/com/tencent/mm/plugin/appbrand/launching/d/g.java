package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.f.b.a.pu;
import com.tencent.mm.f.b.a.pu.b;
import com.tencent.mm.f.b.a.pu.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.yw;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "openMaterialMimeType", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setIsUsed", "used", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends a<c.a<cqa>>
{
  public static final a pZi;
  private final String appId;
  private final int cBU;
  private final AppBrandLaunchReferrer cwV;
  private final int enterScene;
  private final String nBq;
  private final String nYy;
  public boolean nip;
  private final AppBrandStatObject nyh;
  private boolean oWq;
  private c.a<cqa> pZf;
  private final String pZh;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    pZi = new a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4, String paramString5)
  {
    this.userName = paramString1;
    this.cBU = paramInt1;
    this.enterScene = paramInt2;
    this.nBq = paramString2;
    this.nyh = paramAppBrandStatObject;
    this.cwV = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.nYy = paramString4;
    this.pZh = paramString5;
  }
  
  public final c.a<cqa> BN(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (((com.tencent.luggage.sdk.f.a)this).cCU == null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(180641);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cCU;
    if (localObject == null) {
      p.bGy("futureTask");
    }
    if (((FutureTask)localObject).isDone()) {
      b.rE(5);
    }
    for (;;)
    {
      localObject = (c.a)super.iU(paramInt);
      AppMethodBeat.o(180641);
      return localObject;
      b.rE(6);
    }
  }
  
  public final int Sw()
  {
    return 0;
  }
  
  public final void a(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(264588);
    p.k(paramQualitySession, "qualitySession");
    if (this.pZf == null)
    {
      AppMethodBeat.o(264588);
      return;
    }
    pu localpu = com.tencent.mm.plugin.appbrand.report.quality.g.d(paramQualitySession);
    String str = this.appId;
    paramQualitySession = str;
    if (str == null) {
      paramQualitySession = "";
    }
    localpu.GP(paramQualitySession);
    localpu.GQ(this.userName);
    localpu.aoS();
    localpu.Dh(com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType());
    long l;
    if (this.nip)
    {
      paramQualitySession = pu.b.hhS;
      localpu.a(paramQualitySession);
      localpu.Df(St());
      localpu.Dg(Su());
      localpu.Dd(Su() - St());
      if (!this.oWq) {
        break label276;
      }
      l = 1L;
      label147:
      localpu.Di(l);
      paramQualitySession = this.pZf;
      if (paramQualitySession == null) {
        p.iCn();
      }
      int i = paramQualitySession.errType;
      paramQualitySession = this.pZf;
      if (paramQualitySession == null) {
        p.iCn();
      }
      int j = paramQualitySession.errCode;
      paramQualitySession = this.pZf;
      if (paramQualitySession == null) {
        p.iCn();
      }
      if (!com.tencent.mm.plugin.appbrand.r.a.a(i, j, paramQualitySession.lBJ)) {
        break label343;
      }
      paramQualitySession = this.pZf;
      if (paramQualitySession == null) {
        p.iCn();
      }
      paramQualitySession = paramQualitySession.lBJ;
      if (paramQualitySession == null) {
        p.iCn();
      }
      if (((cqa)paramQualitySession).Txv != null) {
        break label282;
      }
      localpu.a(pu.c.hhX);
    }
    for (;;)
    {
      localpu.bpa();
      AppMethodBeat.o(264588);
      return;
      paramQualitySession = pu.b.hhT;
      break;
      label276:
      l = 0L;
      break label147;
      label282:
      paramQualitySession = this.pZf;
      if (paramQualitySession == null) {
        p.iCn();
      }
      paramQualitySession = paramQualitySession.lBJ;
      if (paramQualitySession == null) {
        p.iCn();
      }
      if (((cqa)paramQualitySession).Txv.SkZ == null)
      {
        localpu.a(pu.c.hhY);
      }
      else
      {
        localpu.a(pu.c.hhV);
        continue;
        label343:
        localpu.a(pu.c.hhW);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */