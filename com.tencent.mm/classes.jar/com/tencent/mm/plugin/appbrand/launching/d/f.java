package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.g.b.a.hr.a;
import com.tencent.mm.g.b.a.hr.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cgt;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends a<c.a<cgt>>
{
  public static final a lpE;
  private final String appId;
  private final String jjf;
  private c.a<cgt> lpD;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    lpE = new a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.jjf = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final int DL()
  {
    return 1;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(187340);
    k.h(paramQualitySession, "qualitySession");
    if (this.lpD == null)
    {
      AppMethodBeat.o(187340);
      return;
    }
    long l1 = this.cfh;
    long l2 = this.cff;
    hr localhr = new hr();
    localhr.oO(paramQualitySession.lht);
    String str2 = localhr.getAppId();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localhr.oP(str1);
    localhr.mR(paramQualitySession.lVs);
    localhr.a(hr.a.jd(paramQualitySession.lTR));
    localhr.mS(paramQualitySession.apptype);
    localhr.mT(l1 - l2);
    localhr.mU(paramQualitySession.scene);
    localhr.mV(localhr.SK());
    localhr.mW(localhr.SL());
    if (com.tencent.mm.plugin.appbrand.o.a.d(this.lpD))
    {
      paramQualitySession = hr.b.ehr;
      localhr.a(paramQualitySession);
      localhr.mX(com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType());
      localhr.oQ(this.userName);
      localhr.SZ();
      if (!this.cfi) {
        break label242;
      }
    }
    label242:
    for (l1 = 1L;; l1 = 0L)
    {
      localhr.mY(l1);
      localhr.aHZ();
      AppMethodBeat.o(187340);
      return;
      paramQualitySession = hr.b.ehs;
      break;
    }
  }
  
  public final c.a<cgt> tK(int paramInt)
  {
    AppMethodBeat.i(180640);
    c.a locala = (c.a)super.gx(paramInt);
    if (locala != null) {
      b.lA(7);
    }
    AppMethodBeat.o(180640);
    return locala;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */