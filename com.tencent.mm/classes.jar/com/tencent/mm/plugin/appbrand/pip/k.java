package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactory;", "()V", "createPipStablePosLogic", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "plugin-appbrand-integration_release"})
public final class k
  implements j
{
  public static final k nDP;
  
  static
  {
    AppMethodBeat.i(229263);
    nDP = new k();
    AppMethodBeat.o(229263);
  }
  
  public final i a(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    AppMethodBeat.i(229262);
    p.h(paramString, "appId");
    p.h(paramAppBrandPipContainerView, "pipContainerView");
    paramString = (i)new l(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.o(229262);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.k
 * JD-Core Version:    0.7.0.1
 */