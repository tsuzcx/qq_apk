package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.tn;
import com.tencent.mm.autogen.mmdata.rpt.tn.b;
import com.tencent.mm.autogen.mmdata.rpt.tn.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "openMaterialMimeType", "wxaColdStartMode", "Lcom/tencent/luggage/sdk/launching/WxaColdStartMode;", "instanceId", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/WxaColdStartMode;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "getInstanceId", "isBackground", "", "isBackground$annotations", "()V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getWxaColdStartMode", "()Lcom/tencent/luggage/sdk/launching/WxaColdStartMode;", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setIsUsed", "used", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a<b.a<dgu>>
{
  public static final g.a tdU;
  private final String appId;
  private final int enterScene;
  private final AppBrandLaunchReferrer eoV;
  private final e epm;
  private final String eup;
  private final int euz;
  private boolean mUq;
  private final String qAF;
  private final String qYA;
  private final AppBrandStatObject qxv;
  private b.a<dgu> tdT;
  private final String tdV;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50815);
    tdU = new g.a((byte)0);
    AppMethodBeat.o(50815);
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, String paramString4, String paramString5, e parame, String paramString6)
  {
    this.userName = paramString1;
    this.euz = paramInt1;
    this.enterScene = paramInt2;
    this.qAF = paramString2;
    this.qxv = paramAppBrandStatObject;
    this.eoV = paramAppBrandLaunchReferrer;
    this.appId = paramString3;
    this.qYA = paramString4;
    this.tdV = paramString5;
    this.epm = parame;
    this.eup = paramString6;
  }
  
  public final b.a<dgu> Cc(int paramInt)
  {
    AppMethodBeat.i(180641);
    if (isDone()) {
      b.rG(5);
    }
    for (;;)
    {
      b.a locala = (b.a)super.mv(paramInt);
      AppMethodBeat.o(180641);
      return locala;
      b.rG(6);
    }
  }
  
  public final void a(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(321061);
    s.u(paramQualitySession, "qualitySession");
    if (this.tdT == null)
    {
      AppMethodBeat.o(321061);
      return;
    }
    tn localtn = f.e(paramQualitySession);
    paramQualitySession = (CharSequence)localtn.imT;
    int i;
    label69:
    long l;
    if ((paramQualitySession == null) || (paramQualitySession.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        paramQualitySession = this.tdT;
        if (paramQualitySession != null) {
          break label282;
        }
        paramQualitySession = null;
        localtn.zV(paramQualitySession);
      }
      localtn.iqX = localtn.F("username", this.userName, true);
      localtn.jDj = 1L;
      localtn.iVU = f.getNetworkType();
      localtn.zW(j.getNetworkType(MMApplicationContext.getContext()));
      localtn.jDE = tn.b.jDK;
      localtn.gv(asI());
      localtn.gw(asJ());
      localtn.gu(asJ() - asI());
      if (!this.mUq) {
        break label307;
      }
      l = 1L;
      label173:
      localtn.jDF = l;
      paramQualitySession = this.tdT;
      s.checkNotNull(paramQualitySession);
      i = paramQualitySession.errType;
      paramQualitySession = this.tdT;
      s.checkNotNull(paramQualitySession);
      int j = paramQualitySession.errCode;
      paramQualitySession = this.tdT;
      s.checkNotNull(paramQualitySession);
      if (!com.tencent.mm.plugin.appbrand.s.a.a(i, j, paramQualitySession.ott)) {
        break label366;
      }
      paramQualitySession = this.tdT;
      s.checkNotNull(paramQualitySession);
      paramQualitySession = paramQualitySession.ott;
      s.checkNotNull(paramQualitySession);
      if (((dgu)paramQualitySession).aaMa != null) {
        break label313;
      }
      localtn.jDD = tn.c.jDQ;
    }
    for (;;)
    {
      localtn.bMH();
      AppMethodBeat.o(321061);
      return;
      i = 0;
      break;
      label282:
      paramQualitySession = (dgu)paramQualitySession.ott;
      if (paramQualitySession == null)
      {
        paramQualitySession = null;
        break label69;
      }
      paramQualitySession = paramQualitySession.appid;
      break label69;
      label307:
      l = 0L;
      break label173;
      label313:
      paramQualitySession = this.tdT;
      s.checkNotNull(paramQualitySession);
      paramQualitySession = paramQualitySession.ott;
      s.checkNotNull(paramQualitySession);
      if (((dgu)paramQualitySession).aaMa.Zjj == null)
      {
        localtn.jDD = tn.c.jDR;
      }
      else
      {
        localtn.jDD = tn.c.jDO;
        continue;
        label366:
        localtn.jDD = tn.c.jDP;
      }
    }
  }
  
  public final int asL()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.g
 * JD-Core Version:    0.7.0.1
 */