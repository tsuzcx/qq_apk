package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e mNa;
  
  static
  {
    AppMethodBeat.i(51358);
    mNa = new e();
    AppMethodBeat.o(51358);
  }
  
  public static final void G(o paramo)
  {
    AppMethodBeat.i(51354);
    p.h(paramo, "runtime");
    if (I(paramo)) {
      g.yhR.dD(1089, 51);
    }
    AppMethodBeat.o(51354);
  }
  
  public static final void H(o paramo)
  {
    AppMethodBeat.i(51355);
    p.h(paramo, "runtime");
    if (I(paramo)) {
      g.yhR.dD(1089, 50);
    }
    AppMethodBeat.o(51355);
  }
  
  private static boolean I(o paramo)
  {
    AppMethodBeat.i(51356);
    boolean bool = ce(paramo.getAppId(), paramo.aVL());
    AppMethodBeat.o(51356);
    return bool;
  }
  
  public static final boolean ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(51357);
    if ((p.i("wxb6d22f922f37b35a", paramString)) && (j.a.rQ(paramInt)))
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