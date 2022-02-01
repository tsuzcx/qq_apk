package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "updatedConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class as
  implements aj
{
  @Deprecated
  public static final as.a nyR;
  private AppBrandInitConfigWC nyP;
  private final t nyQ;
  
  static
  {
    AppMethodBeat.i(271248);
    nyR = new as.a((byte)0);
    AppMethodBeat.o(271248);
  }
  
  public as(AppBrandInitConfigWC paramAppBrandInitConfigWC, t paramt)
  {
    AppMethodBeat.i(271247);
    this.nyP = paramAppBrandInitConfigWC;
    this.nyQ = paramt;
    AppMethodBeat.o(271247);
  }
  
  public final Boolean b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(271245);
    p.k(paramAppBrandInitConfigWC, "newConfig");
    Object localObject = this.nyQ.bDv();
    if (localObject != null) {}
    for (localObject = ((ah)localObject).ceb();; localObject = null)
    {
      String str = paramAppBrandInitConfigWC.nBq;
      int i = this.nyP.Qu().scene;
      int j = paramAppBrandInitConfigWC.Qu().scene;
      if ((this.nyP.cxe != b.cBf) || (this.nyP.cxe == paramAppBrandInitConfigWC.cxe) || (!p.h(localObject, str)) || (i != j)) {
        break;
      }
      Log.i("MicroMsg.AppBrand.PreRenderAutoRelaunchLogicInterceptor", "shouldReLaunchOnConfigWillUpdate returns false, appId:" + this.nyQ.getAppId() + ", currentOriginRouteUrl:" + (String)localObject + ", newRouteUrl:" + str + ", oldScene:" + i + ", newScene:" + j);
      paramAppBrandInitConfigWC = Boolean.FALSE;
      AppMethodBeat.o(271245);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(271245);
    return null;
  }
  
  public final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(271246);
    p.k(paramAppBrandInitConfigWC, "newConfig");
    this.nyP = paramAppBrandInitConfigWC;
    AppMethodBeat.o(271246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.as
 * JD-Core Version:    0.7.0.1
 */