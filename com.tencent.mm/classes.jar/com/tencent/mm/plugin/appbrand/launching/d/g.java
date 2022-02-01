package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.mv;
import com.tencent.mm.g.b.a.mv.b;
import com.tencent.mm.g.b.a.mv.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.ys;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "openMaterialMimeType", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setIsUsed", "used", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends a<c.a<che>>
{
  public static final a mYJ;
  private final String appId;
  private final AppBrandLaunchReferrer cys;
  private final int enterScene;
  private final int iOo;
  private final AppBrandStatObject kEH;
  private final String kHw;
  public boolean kqC;
  private boolean lYx;
  private final String lek;
  private c.a<che> mYG;
  private final String mYI;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    mYJ = new a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4, String paramString5)
  {
    this.userName = paramString1;
    this.iOo = paramInt1;
    this.enterScene = paramInt2;
    this.kHw = paramString2;
    this.kEH = paramAppBrandStatObject;
    this.cys = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.lek = paramString4;
    this.mYI = paramString5;
  }
  
  public final int OY()
  {
    return 0;
  }
  
  public final void b(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(228754);
    p.h(paramQualitySession, "qualitySession");
    if (this.mYG == null)
    {
      AppMethodBeat.o(228754);
      return;
    }
    mv localmv = com.tencent.mm.plugin.appbrand.report.quality.g.e(paramQualitySession);
    String str = this.appId;
    paramQualitySession = str;
    if (str == null) {
      paramQualitySession = "";
    }
    localmv.Ae(paramQualitySession);
    localmv.Af(this.userName);
    localmv.ajl();
    localmv.xh(com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType());
    long l;
    if (this.kqC)
    {
      paramQualitySession = mv.b.feS;
      localmv.a(paramQualitySession);
      localmv.xf(this.cCs);
      localmv.xg(this.cCt);
      localmv.xd(this.cCt - this.cCs);
      if (!this.lYx) {
        break label276;
      }
      l = 1L;
      label147:
      localmv.xi(l);
      paramQualitySession = this.mYG;
      if (paramQualitySession == null) {
        p.hyc();
      }
      int i = paramQualitySession.errType;
      paramQualitySession = this.mYG;
      if (paramQualitySession == null) {
        p.hyc();
      }
      int j = paramQualitySession.errCode;
      paramQualitySession = this.mYG;
      if (paramQualitySession == null) {
        p.hyc();
      }
      if (!com.tencent.mm.plugin.appbrand.r.a.a(i, j, paramQualitySession.iLC)) {
        break label343;
      }
      paramQualitySession = this.mYG;
      if (paramQualitySession == null) {
        p.hyc();
      }
      paramQualitySession = paramQualitySession.iLC;
      if (paramQualitySession == null) {
        p.hyc();
      }
      if (((che)paramQualitySession).MmA != null) {
        break label282;
      }
      localmv.a(mv.c.feX);
    }
    for (;;)
    {
      localmv.bfK();
      AppMethodBeat.o(228754);
      return;
      paramQualitySession = mv.b.feT;
      break;
      label276:
      l = 0L;
      break label147;
      label282:
      paramQualitySession = this.mYG;
      if (paramQualitySession == null) {
        p.hyc();
      }
      paramQualitySession = paramQualitySession.iLC;
      if (paramQualitySession == null) {
        p.hyc();
      }
      if (((che)paramQualitySession).MmA.LjS == null)
      {
        localmv.a(mv.c.feY);
      }
      else
      {
        localmv.a(mv.c.feV);
        continue;
        label343:
        localmv.a(mv.c.feW);
      }
    }
  }
  
  public final c.a<che> yn(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (((com.tencent.luggage.sdk.e.a)this).cCr == null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(180641);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cCr;
    if (localObject == null) {
      p.btv("futureTask");
    }
    if (((FutureTask)localObject).isDone()) {
      b.pl(5);
    }
    for (;;)
    {
      localObject = (c.a)super.hS(paramInt);
      AppMethodBeat.o(180641);
      return localObject;
      b.pl(6);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */