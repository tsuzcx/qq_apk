package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.report.service.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e iWp;
  
  static
  {
    AppMethodBeat.i(154364);
    iWp = new e();
    AppMethodBeat.o(154364);
  }
  
  public static final boolean bz(String paramString, int paramInt)
  {
    AppMethodBeat.i(154363);
    if ((j.e("wxb6d22f922f37b35a", paramString)) && (j.a.nk(paramInt)))
    {
      AppMethodBeat.o(154363);
      return true;
    }
    AppMethodBeat.o(154363);
    return false;
  }
  
  public static final void s(o paramo)
  {
    AppMethodBeat.i(154360);
    j.q(paramo, "runtime");
    if (u(paramo)) {
      h.qsU.cT(1089, 51);
    }
    AppMethodBeat.o(154360);
  }
  
  public static final void t(o paramo)
  {
    AppMethodBeat.i(154361);
    j.q(paramo, "runtime");
    if (u(paramo)) {
      h.qsU.cT(1089, 50);
    }
    AppMethodBeat.o(154361);
  }
  
  private static boolean u(o paramo)
  {
    AppMethodBeat.i(154362);
    boolean bool = bz(paramo.getAppId(), paramo.ath());
    AppMethodBeat.o(154362);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.e
 * JD-Core Version:    0.7.0.1
 */