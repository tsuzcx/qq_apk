package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.ht.b;
import com.tencent.mm.g.b.a.ht.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.vg;
import d.g.b.k;
import d.l;
import java.util.concurrent.FutureTask;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends a<c.a<bot>>
{
  public static final a lpF;
  private final String appId;
  private final AppBrandLaunchReferrer cce;
  private final int enterScene;
  private final int hxM;
  public boolean iWl;
  private final String jDN;
  private final AppBrandStatObject jjR;
  private final String jjf;
  private boolean kum;
  private c.a<bot> lpD;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    lpF = new a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4)
  {
    this.userName = paramString1;
    this.hxM = paramInt1;
    this.enterScene = paramInt2;
    this.jjf = paramString2;
    this.jjR = paramAppBrandStatObject;
    this.cce = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.jDN = paramString4;
  }
  
  public final int DL()
  {
    return 0;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(187341);
    k.h(paramQualitySession, "qualitySession");
    if (this.lpD == null)
    {
      AppMethodBeat.o(187341);
      return;
    }
    ht localht = f.f(paramQualitySession);
    String str = this.appId;
    paramQualitySession = str;
    if (str == null) {
      paramQualitySession = "";
    }
    localht.oU(paramQualitySession);
    localht.oV(this.userName);
    localht.Ta();
    localht.nl(f.getNetworkType());
    long l;
    if (this.iWl)
    {
      paramQualitySession = ht.b.ehM;
      localht.a(paramQualitySession);
      localht.nj(this.cff);
      localht.nk(this.cfh);
      localht.nh(this.cfh - this.cff);
      if (!this.kum) {
        break label276;
      }
      l = 1L;
      label147:
      localht.nm(l);
      paramQualitySession = this.lpD;
      if (paramQualitySession == null) {
        k.fOy();
      }
      int i = paramQualitySession.errType;
      paramQualitySession = this.lpD;
      if (paramQualitySession == null) {
        k.fOy();
      }
      int j = paramQualitySession.errCode;
      paramQualitySession = this.lpD;
      if (paramQualitySession == null) {
        k.fOy();
      }
      if (!com.tencent.mm.plugin.appbrand.o.a.a(i, j, paramQualitySession.hvj)) {
        break label343;
      }
      paramQualitySession = this.lpD;
      if (paramQualitySession == null) {
        k.fOy();
      }
      paramQualitySession = paramQualitySession.hvj;
      if (paramQualitySession == null) {
        k.fOy();
      }
      if (((bot)paramQualitySession).Feg != null) {
        break label282;
      }
      localht.a(ht.c.ehR);
    }
    for (;;)
    {
      localht.aHZ();
      AppMethodBeat.o(187341);
      return;
      paramQualitySession = ht.b.ehN;
      break;
      label276:
      l = 0L;
      break label147;
      label282:
      paramQualitySession = this.lpD;
      if (paramQualitySession == null) {
        k.fOy();
      }
      paramQualitySession = paramQualitySession.hvj;
      if (paramQualitySession == null) {
        k.fOy();
      }
      if (((bot)paramQualitySession).Feg.Epw == null)
      {
        localht.a(ht.c.ehS);
      }
      else
      {
        localht.a(ht.c.ehP);
        continue;
        label343:
        localht.a(ht.c.ehQ);
      }
    }
  }
  
  public final c.a<bot> tK(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (((com.tencent.luggage.sdk.e.a)this).cfe == null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(180641);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cfe;
    if (localObject == null) {
      k.aVY("futureTask");
    }
    if (((FutureTask)localObject).isDone()) {
      b.lA(5);
    }
    for (;;)
    {
      localObject = (c.a)super.gx(paramInt);
      AppMethodBeat.o(180641);
      return localObject;
      b.lA(6);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */