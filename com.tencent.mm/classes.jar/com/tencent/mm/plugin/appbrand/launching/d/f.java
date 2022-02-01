package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.g.b.a.iv;
import com.tencent.mm.g.b.a.iv.a;
import com.tencent.mm.g.b.a.iv.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cls;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends a<a.a<cls>>
{
  public static final a lMX;
  private final String appId;
  private final String jCN;
  private a.a<cls> lMW;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    lMX = new a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.jCN = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final int Fk()
  {
    return 1;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(189332);
    p.h(paramQualitySession, "qualitySession");
    if (this.lMW == null)
    {
      AppMethodBeat.o(189332);
      return;
    }
    long l1 = this.cpx;
    long l2 = this.cpw;
    iv localiv = new iv();
    localiv.rv(paramQualitySession.lEv);
    String str2 = localiv.getAppId();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localiv.rw(str1);
    localiv.oP(paramQualitySession.mvi);
    localiv.a(iv.a.jA(paramQualitySession.mtG));
    localiv.oQ(paramQualitySession.apptype);
    localiv.oR(l1 - l2);
    localiv.oS(paramQualitySession.scene);
    localiv.oT(localiv.UY());
    localiv.oU(localiv.UZ());
    if (com.tencent.mm.plugin.appbrand.n.a.e(this.lMW))
    {
      paramQualitySession = iv.b.eyr;
      localiv.a(paramQualitySession);
      localiv.oV(com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType());
      localiv.rx(this.userName);
      localiv.Vm();
      if (!this.cpy) {
        break label242;
      }
    }
    label242:
    for (l1 = 1L;; l1 = 0L)
    {
      localiv.oW(l1);
      localiv.aLk();
      AppMethodBeat.o(189332);
      return;
      paramQualitySession = iv.b.eys;
      break;
    }
  }
  
  public final a.a<cls> uo(int paramInt)
  {
    AppMethodBeat.i(180640);
    a.a locala = (a.a)super.gC(paramInt);
    if (locala != null) {
      b.ma(7);
    }
    AppMethodBeat.o(180640);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */