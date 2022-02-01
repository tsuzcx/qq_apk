package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h lUV;
  
  static
  {
    AppMethodBeat.i(187381);
    lUV = new h();
    AppMethodBeat.o(187381);
  }
  
  public static final void a(QualitySession paramQualitySession, final kv_14609 paramkv_14609, final com.tencent.mm.plugin.appbrand.appcache.a.a parama, final CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(187379);
    k.h(paramQualitySession, "session");
    k.h(paramkv_14609, "kv14609");
    k.h(parama, "downloadRequest");
    k.h(paramWebPageProfile, "profile");
    c.b(null, (d.g.a.a)new a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(187379);
  }
  
  private static String c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(187380);
    if ((parama instanceof bo))
    {
      parama = ((bo)parama).aXs();
      AppMethodBeat.o(187380);
      return parama;
    }
    if ((parama instanceof au))
    {
      parama = ((au)parama).aWR();
      AppMethodBeat.o(187380);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(187380);
    return parama;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.h
 * JD-Core Version:    0.7.0.1
 */