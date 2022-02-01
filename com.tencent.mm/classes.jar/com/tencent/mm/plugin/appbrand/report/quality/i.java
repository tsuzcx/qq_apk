package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.ca;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class i
{
  public static final i qMZ;
  
  static
  {
    AppMethodBeat.i(280897);
    qMZ = new i();
    AppMethodBeat.o(280897);
  }
  
  public static final void a(QualitySession paramQualitySession, final kv_14609 paramkv_14609, final com.tencent.mm.plugin.appbrand.appcache.a.a parama, final CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(280895);
    p.k(paramQualitySession, "session");
    p.k(paramkv_14609, "kv14609");
    p.k(parama, "downloadRequest");
    p.k(paramWebPageProfile, "profile");
    d.h((kotlin.g.a.a)new a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(280895);
  }
  
  private static String d(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(280896);
    if ((parama instanceof ca))
    {
      parama = ((ca)parama).bHM();
      AppMethodBeat.o(280896);
      return parama;
    }
    if ((parama instanceof az))
    {
      parama = ((az)parama).bHi();
      AppMethodBeat.o(280896);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(280896);
    return parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */