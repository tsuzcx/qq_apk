package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h muL;
  
  static
  {
    AppMethodBeat.i(189593);
    muL = new h();
    AppMethodBeat.o(189593);
  }
  
  public static final void a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(189591);
    p.h(paramQualitySession, "session");
    p.h(paramkv_14609, "kv14609");
    p.h(parama, "downloadRequest");
    p.h(paramWebPageProfile, "profile");
    c.b(null, (d.g.a.a)new h.a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(189591);
  }
  
  private static String d(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(189592);
    if ((parama instanceof bq))
    {
      parama = ((bq)parama).baQ();
      AppMethodBeat.o(189592);
      return parama;
    }
    if ((parama instanceof av))
    {
      parama = ((av)parama).bao();
      AppMethodBeat.o(189592);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(189592);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.h
 * JD-Core Version:    0.7.0.1
 */