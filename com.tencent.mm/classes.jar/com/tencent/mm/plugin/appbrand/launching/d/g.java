package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.g.b.a.ix.b;
import com.tencent.mm.g.b.a.ix.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.xf;
import d.g.b.p;
import d.l;
import java.util.concurrent.FutureTask;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setIsUsed", "used", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends a<a.a<btg>>
{
  public static final a lMY;
  private final String appId;
  private final AppBrandLaunchReferrer cmv;
  private final int enterScene;
  private final int hQh;
  private final String jCN;
  private final AppBrandStatObject jDH;
  private final String jXO;
  public boolean jpu;
  private boolean kPK;
  private a.a<btg> lMW;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    lMY = new a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4)
  {
    this.userName = paramString1;
    this.hQh = paramInt1;
    this.enterScene = paramInt2;
    this.jCN = paramString2;
    this.jDH = paramAppBrandStatObject;
    this.cmv = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.jXO = paramString4;
  }
  
  public final int Fk()
  {
    return 0;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(189333);
    p.h(paramQualitySession, "qualitySession");
    if (this.lMW == null)
    {
      AppMethodBeat.o(189333);
      return;
    }
    ix localix = f.f(paramQualitySession);
    String str = this.appId;
    paramQualitySession = str;
    if (str == null) {
      paramQualitySession = "";
    }
    localix.rB(paramQualitySession);
    localix.rC(this.userName);
    localix.Vn();
    localix.pj(f.getNetworkType());
    long l;
    if (this.jpu)
    {
      paramQualitySession = ix.b.eyM;
      localix.a(paramQualitySession);
      localix.ph(this.cpw);
      localix.pi(this.cpx);
      localix.pf(this.cpx - this.cpw);
      if (!this.kPK) {
        break label276;
      }
      l = 1L;
      label147:
      localix.pk(l);
      paramQualitySession = this.lMW;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      int i = paramQualitySession.errType;
      paramQualitySession = this.lMW;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      int j = paramQualitySession.errCode;
      paramQualitySession = this.lMW;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      if (!com.tencent.mm.plugin.appbrand.n.a.a(i, j, paramQualitySession.hNC)) {
        break label343;
      }
      paramQualitySession = this.lMW;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      paramQualitySession = paramQualitySession.hNC;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      if (((btg)paramQualitySession).GNK != null) {
        break label282;
      }
      localix.a(ix.c.eyR);
    }
    for (;;)
    {
      localix.aLk();
      AppMethodBeat.o(189333);
      return;
      paramQualitySession = ix.b.eyN;
      break;
      label276:
      l = 0L;
      break label147;
      label282:
      paramQualitySession = this.lMW;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      paramQualitySession = paramQualitySession.hNC;
      if (paramQualitySession == null) {
        p.gfZ();
      }
      if (((btg)paramQualitySession).GNK.FWI == null)
      {
        localix.a(ix.c.eyS);
      }
      else
      {
        localix.a(ix.c.eyP);
        continue;
        label343:
        localix.a(ix.c.eyQ);
      }
    }
  }
  
  public final a.a<btg> uo(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (((com.tencent.luggage.sdk.e.a)this).cpv == null)
    {
      localObject = (Throwable)new IllegalStateException();
      AppMethodBeat.o(180641);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cpv;
    if (localObject == null) {
      p.bcb("futureTask");
    }
    if (((FutureTask)localObject).isDone()) {
      b.ma(5);
    }
    for (;;)
    {
      localObject = (a.a)super.gC(paramInt);
      AppMethodBeat.o(180641);
      return localObject;
      b.ma(6);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */