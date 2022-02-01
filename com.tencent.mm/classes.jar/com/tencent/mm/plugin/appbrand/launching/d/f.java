package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.g.b.a.ix.a;
import com.tencent.mm.g.b.a.ix.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cmm;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends a<a.a<cmm>>
{
  public static final a lRy;
  private final String appId;
  private final String jFL;
  private a.a<cmm> lRx;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    lRy = new a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.jFL = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final int Fp()
  {
    return 1;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(223592);
    p.h(paramQualitySession, "qualitySession");
    if (this.lRx == null)
    {
      AppMethodBeat.o(223592);
      return;
    }
    long l1 = this.cqa;
    long l2 = this.cpZ;
    ix localix = new ix();
    localix.rQ(paramQualitySession.lIU);
    String str2 = localix.getAppId();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localix.rR(str1);
    localix.pc(paramQualitySession.mAf);
    localix.a(ix.a.jC(paramQualitySession.myD));
    localix.pd(paramQualitySession.apptype);
    localix.pe(l1 - l2);
    localix.pf(paramQualitySession.scene);
    localix.pg(localix.Ve());
    localix.ph(localix.Vf());
    if (com.tencent.mm.plugin.appbrand.n.a.e(this.lRx))
    {
      paramQualitySession = ix.b.eAa;
      localix.a(paramQualitySession);
      localix.pi(com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType());
      localix.rS(this.userName);
      localix.Vu();
      if (!this.cqb) {
        break label242;
      }
    }
    label242:
    for (l1 = 1L;; l1 = 0L)
    {
      localix.pj(l1);
      localix.aLH();
      AppMethodBeat.o(223592);
      return;
      paramQualitySession = ix.b.eAb;
      break;
    }
  }
  
  public final a.a<cmm> uu(int paramInt)
  {
    AppMethodBeat.i(180640);
    a.a locala = (a.a)super.gD(paramInt);
    if (locala != null) {
      b.md(7);
    }
    AppMethodBeat.o(180640);
    return locala;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */