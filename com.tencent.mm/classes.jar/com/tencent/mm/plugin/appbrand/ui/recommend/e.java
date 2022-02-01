package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e rgS;
  
  static
  {
    AppMethodBeat.i(51358);
    rgS = new e();
    AppMethodBeat.o(51358);
  }
  
  public static final void P(t paramt)
  {
    AppMethodBeat.i(51354);
    p.k(paramt, "runtime");
    if (R(paramt)) {
      h.IzE.el(1089, 51);
    }
    AppMethodBeat.o(51354);
  }
  
  public static final void Q(t paramt)
  {
    AppMethodBeat.i(51355);
    p.k(paramt, "runtime");
    if (R(paramt)) {
      h.IzE.el(1089, 50);
    }
    AppMethodBeat.o(51355);
  }
  
  private static boolean R(t paramt)
  {
    AppMethodBeat.i(51356);
    boolean bool = cM(paramt.getAppId(), paramt.bBV());
    AppMethodBeat.o(51356);
    return bool;
  }
  
  public static final boolean cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(51357);
    if ((p.h("wxb6d22f922f37b35a", paramString)) && (j.a.za(paramInt)))
    {
      AppMethodBeat.o(51357);
      return true;
    }
    AppMethodBeat.o(51357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.e
 * JD-Core Version:    0.7.0.1
 */