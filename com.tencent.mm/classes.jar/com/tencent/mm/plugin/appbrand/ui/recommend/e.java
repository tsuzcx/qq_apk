package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.report.service.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e mmy;
  
  static
  {
    AppMethodBeat.i(51358);
    mmy = new e();
    AppMethodBeat.o(51358);
  }
  
  public static final void P(o paramo)
  {
    AppMethodBeat.i(51354);
    k.h(paramo, "runtime");
    if (R(paramo)) {
      h.wUl.dB(1089, 51);
    }
    AppMethodBeat.o(51354);
  }
  
  public static final void Q(o paramo)
  {
    AppMethodBeat.i(51355);
    k.h(paramo, "runtime");
    if (R(paramo)) {
      h.wUl.dB(1089, 50);
    }
    AppMethodBeat.o(51355);
  }
  
  private static boolean R(o paramo)
  {
    AppMethodBeat.i(51356);
    boolean bool = cb(paramo.getAppId(), paramo.aSy());
    AppMethodBeat.o(51356);
    return bool;
  }
  
  public static final boolean cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(51357);
    if ((k.g("wxb6d22f922f37b35a", paramString)) && (j.a.rq(paramInt)))
    {
      AppMethodBeat.o(51357);
      return true;
    }
    AppMethodBeat.o(51357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.e
 * JD-Core Version:    0.7.0.1
 */