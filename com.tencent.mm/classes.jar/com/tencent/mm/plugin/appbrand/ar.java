package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "updatedConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class ar
  implements aj
{
  @Deprecated
  public static final a kFl;
  private AppBrandInitConfigWC kFj;
  private final q kFk;
  
  static
  {
    AppMethodBeat.i(227933);
    kFl = new a((byte)0);
    AppMethodBeat.o(227933);
  }
  
  public ar(AppBrandInitConfigWC paramAppBrandInitConfigWC, q paramq)
  {
    AppMethodBeat.i(227932);
    this.kFj = paramAppBrandInitConfigWC;
    this.kFk = paramq;
    AppMethodBeat.o(227932);
  }
  
  public final Boolean b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(227930);
    p.h(paramAppBrandInitConfigWC, "newConfig");
    Object localObject = this.kFk.bsz();
    if (localObject != null) {}
    for (localObject = ((ag)localObject).bRl();; localObject = null)
    {
      String str = paramAppBrandInitConfigWC.kHw;
      int i = this.kFj.Nz().scene;
      int j = paramAppBrandInitConfigWC.Nz().scene;
      if ((this.kFj.cyz != b.cBC) || (this.kFj.cyz == paramAppBrandInitConfigWC.cyz) || (!p.j(localObject, str)) || (i != j)) {
        break;
      }
      Log.i("MicroMsg.AppBrand.PreRenderAutoRelaunchLogicInterceptor", "shouldReLaunchOnConfigWillUpdate returns false, appId:" + this.kFk.getAppId() + ", currentOriginRouteUrl:" + (String)localObject + ", newRouteUrl:" + str + ", oldScene:" + i + ", newScene:" + j);
      paramAppBrandInitConfigWC = Boolean.FALSE;
      AppMethodBeat.o(227930);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(227930);
    return null;
  }
  
  public final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(227931);
    p.h(paramAppBrandInitConfigWC, "newConfig");
    this.kFj = paramAppBrandInitConfigWC;
    AppMethodBeat.o(227931);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ar
 * JD-Core Version:    0.7.0.1
 */