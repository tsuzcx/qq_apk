package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.report.service.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e mSd;
  
  static
  {
    AppMethodBeat.i(51358);
    mSd = new e();
    AppMethodBeat.o(51358);
  }
  
  public static final void H(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(51354);
    d.g.b.p.h(paramp, "runtime");
    if (J(paramp)) {
      g.yxI.dD(1089, 51);
    }
    AppMethodBeat.o(51354);
  }
  
  public static final void I(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(51355);
    d.g.b.p.h(paramp, "runtime");
    if (J(paramp)) {
      g.yxI.dD(1089, 50);
    }
    AppMethodBeat.o(51355);
  }
  
  private static boolean J(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(51356);
    boolean bool = ci(paramp.getAppId(), paramp.aWk());
    AppMethodBeat.o(51356);
    return bool;
  }
  
  public static final boolean ci(String paramString, int paramInt)
  {
    AppMethodBeat.i(51357);
    if ((d.g.b.p.i("wxb6d22f922f37b35a", paramString)) && (j.a.rT(paramInt)))
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