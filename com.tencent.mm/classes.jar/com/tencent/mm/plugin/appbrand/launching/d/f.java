package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.tl;
import com.tencent.mm.autogen.mmdata.rpt.tl.a;
import com.tencent.mm.autogen.mmdata.rpt.tl.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a<b.a<ege>>
{
  public static final f.a tdS;
  private final String appId;
  private final String qAF;
  private b.a<ege> tdT;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    tdS = new f.a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.qAF = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final void a(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(321068);
    s.u(paramQualitySession, "qualitySession");
    if (this.tdT == null)
    {
      AppMethodBeat.o(321068);
      return;
    }
    long l1 = asJ();
    long l2 = asI();
    tl localtl = new tl();
    localtl.zR(paramQualitySession.eup);
    String str2 = localtl.imT;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localtl.zS(str1);
    localtl.ind = paramQualitySession.tSh;
    localtl.jDh = tl.a.pb(paramQualitySession.tQx);
    localtl.jax = paramQualitySession.apptype;
    localtl.go(l1 - l2);
    localtl.iqr = paramQualitySession.scene;
    localtl.gp(localtl.jyI);
    localtl.gq(localtl.jyJ);
    if (com.tencent.mm.plugin.appbrand.s.a.d(this.tdT))
    {
      paramQualitySession = tl.b.jDp;
      localtl.jDi = paramQualitySession;
      localtl.iVU = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      localtl.zU(j.getNetworkType(MMApplicationContext.getContext()));
      localtl.zT(this.userName);
      localtl.jDj = 1L;
      if (!this.evB) {
        break label247;
      }
    }
    label247:
    for (l1 = 1L;; l1 = 0L)
    {
      localtl.jDk = l1;
      localtl.bMH();
      AppMethodBeat.o(321068);
      return;
      paramQualitySession = tl.b.jDq;
      break;
    }
  }
  
  public final int asL()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */