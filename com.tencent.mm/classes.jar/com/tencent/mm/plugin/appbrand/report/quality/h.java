package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h ltb;
  
  static
  {
    AppMethodBeat.i(196420);
    ltb = new h();
    AppMethodBeat.o(196420);
  }
  
  public static final void a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(196418);
    k.h(paramQualitySession, "session");
    k.h(paramkv_14609, "kv14609");
    k.h(parama, "downloadRequest");
    k.h(paramWebPageProfile, "profile");
    c.b(null, (d.g.a.a)new h.a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(196418);
  }
  
  private static String c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(196419);
    if ((parama instanceof bo))
    {
      parama = ((bo)parama).aQA();
      AppMethodBeat.o(196419);
      return parama;
    }
    if ((parama instanceof au))
    {
      parama = ((au)parama).aPZ();
      AppMethodBeat.o(196419);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(196419);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.h
 * JD-Core Version:    0.7.0.1
 */