package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactory;", "()V", "createPipStablePosLogic", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "plugin-appbrand-integration_release"})
public final class k
  implements j
{
  public static final k mth;
  
  static
  {
    AppMethodBeat.i(223831);
    mth = new k();
    AppMethodBeat.o(223831);
  }
  
  public final i a(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    AppMethodBeat.i(223830);
    p.h(paramString, "appId");
    p.h(paramAppBrandPipContainerView, "pipContainerView");
    paramString = (i)new l(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.o(223830);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.k
 * JD-Core Version:    0.7.0.1
 */