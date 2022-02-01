package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bz;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h tRJ;
  
  static
  {
    AppMethodBeat.i(321433);
    tRJ = new h();
    AppMethodBeat.o(321433);
  }
  
  public static final void a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(321411);
    s.u(paramQualitySession, "session");
    s.u(paramkv_14609, "kv14609");
    s.u(parama, "downloadRequest");
    s.u(paramWebPageProfile, "profile");
    d.B((kotlin.g.a.a)new h.a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(321411);
  }
  
  private static String d(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(321416);
    if ((parama instanceof bz))
    {
      parama = ((bz)parama).chi();
      AppMethodBeat.o(321416);
      return parama;
    }
    if ((parama instanceof ba))
    {
      parama = ((ba)parama).cgF();
      AppMethodBeat.o(321416);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(321416);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.h
 * JD-Core Version:    0.7.0.1
 */