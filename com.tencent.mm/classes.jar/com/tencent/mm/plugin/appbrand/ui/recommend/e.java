package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e uoO;
  
  static
  {
    AppMethodBeat.i(51358);
    uoO = new e();
    AppMethodBeat.o(51358);
  }
  
  public static final void Y(w paramw)
  {
    AppMethodBeat.i(51354);
    s.u(paramw, "runtime");
    if (aa(paramw)) {
      h.OAn.kJ(1089, 51);
    }
    AppMethodBeat.o(51354);
  }
  
  public static final void Z(w paramw)
  {
    AppMethodBeat.i(51355);
    s.u(paramw, "runtime");
    if (aa(paramw)) {
      h.OAn.kJ(1089, 50);
    }
    AppMethodBeat.o(51355);
  }
  
  private static boolean aa(w paramw)
  {
    AppMethodBeat.i(51356);
    boolean bool = jdMethod_do(paramw.mAppId, paramw.qsh.eul);
    AppMethodBeat.o(51356);
    return bool;
  }
  
  public static final boolean jdMethod_do(String paramString, int paramInt)
  {
    AppMethodBeat.i(51357);
    if ((s.p("wxb6d22f922f37b35a", paramString)) && (k.a.zn(paramInt)))
    {
      AppMethodBeat.o(51357);
      return true;
    }
    AppMethodBeat.o(51357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.e
 * JD-Core Version:    0.7.0.1
 */