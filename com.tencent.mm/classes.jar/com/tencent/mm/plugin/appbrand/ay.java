package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "updatedConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  implements ao
{
  private static final a qxW;
  private AppBrandInitConfigWC qxX;
  private final w qxY;
  
  static
  {
    AppMethodBeat.i(316627);
    qxW = new a((byte)0);
    AppMethodBeat.o(316627);
  }
  
  public ay(AppBrandInitConfigWC paramAppBrandInitConfigWC, w paramw)
  {
    AppMethodBeat.i(316622);
    this.qxX = paramAppBrandInitConfigWC;
    this.qxY = paramw;
    AppMethodBeat.o(316622);
  }
  
  public final Boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(316634);
    s.u(paramAppBrandInitConfigWC, "newConfig");
    Object localObject = this.qxY.ccK();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ad)localObject).txo)
    {
      String str = paramAppBrandInitConfigWC.qAF;
      int i = this.qxX.epn.scene;
      int j = paramAppBrandInitConfigWC.epn.scene;
      if ((this.qxX.epm != e.etJ) || (this.qxX.epm == paramAppBrandInitConfigWC.epm) || (!s.p(localObject, str)) || (i != j)) {
        break;
      }
      Log.i("MicroMsg.AppBrand.PreRenderAutoRelaunchLogicInterceptor", "shouldReLaunchOnConfigWillUpdate returns false, appId:" + this.qxY.mAppId + ", currentOriginRouteUrl:" + localObject + ", newRouteUrl:" + str + ", oldScene:" + i + ", newScene:" + j);
      paramAppBrandInitConfigWC = Boolean.FALSE;
      AppMethodBeat.o(316634);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(316634);
    return null;
  }
  
  public final void e(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(316640);
    s.u(paramAppBrandInitConfigWC, "newConfig");
    this.qxX = paramAppBrandInitConfigWC;
    AppMethodBeat.o(316640);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ay
 * JD-Core Version:    0.7.0.1
 */