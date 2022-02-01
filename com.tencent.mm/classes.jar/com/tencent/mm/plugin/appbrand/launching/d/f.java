package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.mt;
import com.tencent.mm.g.b.a.mt.a;
import com.tencent.mm.g.b.a.mt.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.protocal.protobuf.ddz;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends a<c.a<ddz>>
{
  public static final a mYH;
  private final String appId;
  private final String kHw;
  private c.a<ddz> mYG;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(50812);
    mYH = new a((byte)0);
    AppMethodBeat.o(50812);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.kHw = paramString1;
    this.userName = paramString2;
    this.appId = paramString3;
  }
  
  public final int OY()
  {
    return 1;
  }
  
  public final void b(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(228753);
    p.h(paramQualitySession, "qualitySession");
    if (this.mYG == null)
    {
      AppMethodBeat.o(228753);
      return;
    }
    long l1 = this.cCt;
    long l2 = this.cCs;
    mt localmt = new mt();
    localmt.zY(paramQualitySession.kEY);
    String str2 = localmt.getAppId();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localmt.zZ(str1);
    localmt.wN(paramQualitySession.nLk);
    localmt.a(mt.a.mE(paramQualitySession.nJE));
    localmt.wO(paramQualitySession.apptype);
    localmt.wP(l1 - l2);
    localmt.wQ(paramQualitySession.scene);
    localmt.wR(localmt.aiV());
    localmt.wS(localmt.aiW());
    if (com.tencent.mm.plugin.appbrand.r.a.d(this.mYG))
    {
      paramQualitySession = mt.b.fex;
      localmt.a(paramQualitySession);
      localmt.wT(g.getNetworkType());
      localmt.Aa(this.userName);
      localmt.ajk();
      if (!this.cCu) {
        break label242;
      }
    }
    label242:
    for (l1 = 1L;; l1 = 0L)
    {
      localmt.wU(l1);
      localmt.bfK();
      AppMethodBeat.o(228753);
      return;
      paramQualitySession = mt.b.fey;
      break;
    }
  }
  
  public final c.a<ddz> yn(int paramInt)
  {
    AppMethodBeat.i(180640);
    c.a locala = (c.a)super.hS(paramInt);
    if (locala != null) {
      b.pl(7);
    }
    AppMethodBeat.o(180640);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.f
 * JD-Core Version:    0.7.0.1
 */