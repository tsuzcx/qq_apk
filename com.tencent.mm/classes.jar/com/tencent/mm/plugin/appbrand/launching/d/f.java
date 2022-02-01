package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.g.b.a.fz.a;
import com.tencent.mm.g.b.a.fz.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cbr;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends a<c.a<cbr>>
{
  public static final a kOf;
  private final String appId;
  private final String iJb;
  private c.a<cbr> kOe;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    kOf = new a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.iJb = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final int Ei()
  {
    return 1;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(196402);
    k.h(paramQualitySession, "qualitySession");
    if (this.kOe == null)
    {
      AppMethodBeat.o(196402);
      return;
    }
    long l1 = this.cil;
    long l2 = this.cik;
    fz localfz = new fz();
    localfz.lJ(paramQualitySession.kGa);
    String str2 = localfz.getAppId();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localfz.lK(str1);
    localfz.jp(paramQualitySession.lty);
    localfz.a(fz.a.jf(paramQualitySession.lrW));
    localfz.jq(paramQualitySession.apptype);
    localfz.jr(l1 - l2);
    localfz.js(paramQualitySession.scene);
    localfz.jt(localfz.RR());
    localfz.ju(localfz.RS());
    if (com.tencent.mm.plugin.appbrand.p.a.d(this.kOe))
    {
      paramQualitySession = fz.b.efk;
      localfz.a(paramQualitySession);
      localfz.jv(com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType());
      localfz.lL(this.userName);
      localfz.Sg();
      if (!this.cim) {
        break label242;
      }
    }
    label242:
    for (l1 = 1L;; l1 = 0L)
    {
      localfz.jw(l1);
      localfz.aBj();
      AppMethodBeat.o(196402);
      return;
      paramQualitySession = fz.b.efl;
      break;
    }
  }
  
  public final c.a<cbr> sT(int paramInt)
  {
    AppMethodBeat.i(180640);
    c.a locala = (c.a)super.gN(paramInt);
    if (locala != null) {
      b.lI(7);
    }
    AppMethodBeat.o(180640);
    return locala;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */