package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class i
{
  public static final i nKN;
  
  static
  {
    AppMethodBeat.i(229319);
    nKN = new i();
    AppMethodBeat.o(229319);
  }
  
  public static final void a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(229317);
    p.h(paramQualitySession, "session");
    p.h(paramkv_14609, "kv14609");
    p.h(parama, "downloadRequest");
    p.h(paramWebPageProfile, "profile");
    d.i((kotlin.g.a.a)new i.a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(229317);
  }
  
  private static String d(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(229318);
    if ((parama instanceof bs))
    {
      parama = ((bs)parama).bwC();
      AppMethodBeat.o(229318);
      return parama;
    }
    if ((parama instanceof aw))
    {
      parama = ((aw)parama).bwb();
      AppMethodBeat.o(229318);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(229318);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */