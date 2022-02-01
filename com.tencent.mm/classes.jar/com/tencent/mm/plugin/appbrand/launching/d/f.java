package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.f.b.a.ps;
import com.tencent.mm.f.b.a.ps.a;
import com.tencent.mm.f.b.a.ps.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.protocal.protobuf.dnp;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends a<c.a<dnp>>
{
  public static final a pZg;
  private final String appId;
  private final String nBq;
  private c.a<dnp> pZf;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    pZg = new a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.nBq = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final int Sw()
  {
    return 1;
  }
  
  public final void a(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(272500);
    p.k(paramQualitySession, "qualitySession");
    if (this.pZf == null)
    {
      AppMethodBeat.o(272500);
      return;
    }
    long l1 = Su();
    long l2 = St();
    ps localps = new ps();
    localps.GJ(paramQualitySession.cBH);
    String str2 = localps.getAppId();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localps.GK(str1);
    localps.CN(paramQualitySession.qNx);
    localps.a(ps.a.oP(paramQualitySession.qLQ));
    localps.CO(paramQualitySession.apptype);
    localps.CP(l1 - l2);
    localps.CQ(paramQualitySession.scene);
    localps.CR(localps.St());
    localps.CS(localps.Su());
    if (com.tencent.mm.plugin.appbrand.r.a.d(this.pZf))
    {
      paramQualitySession = ps.b.hhx;
      localps.a(paramQualitySession);
      localps.CT(g.getNetworkType());
      localps.GL(this.userName);
      localps.aoR();
      if (!this.cCX) {
        break label242;
      }
    }
    label242:
    for (l1 = 1L;; l1 = 0L)
    {
      localps.CU(l1);
      localps.bpa();
      AppMethodBeat.o(272500);
      return;
      paramQualitySession = ps.b.hhy;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */