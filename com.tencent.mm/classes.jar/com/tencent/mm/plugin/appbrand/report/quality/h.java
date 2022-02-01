package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", "profile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h mzI;
  
  static
  {
    AppMethodBeat.i(223862);
    mzI = new h();
    AppMethodBeat.o(223862);
  }
  
  public static final void a(QualitySession paramQualitySession, kv_14609 paramkv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a parama, CdnLogic.WebPageProfile paramWebPageProfile)
  {
    AppMethodBeat.i(223860);
    p.h(paramQualitySession, "session");
    p.h(paramkv_14609, "kv14609");
    p.h(parama, "downloadRequest");
    p.h(paramWebPageProfile, "profile");
    c.b(null, (d.g.a.a)new h.a(paramQualitySession, paramkv_14609, parama, paramWebPageProfile));
    AppMethodBeat.o(223860);
  }
  
  private static String d(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(223861);
    if ((parama instanceof bs))
    {
      parama = ((bs)parama).bbp();
      AppMethodBeat.o(223861);
      return parama;
    }
    if ((parama instanceof aw))
    {
      parama = ((aw)parama).baN();
      AppMethodBeat.o(223861);
      return parama;
    }
    parama = parama.getFilePath();
    AppMethodBeat.o(223861);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.h
 * JD-Core Version:    0.7.0.1
 */