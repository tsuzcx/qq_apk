package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactory;", "()V", "createPipStablePosLogic", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "plugin-appbrand-integration_release"})
public final class k
  implements j
{
  public static final k lOt;
  
  static
  {
    AppMethodBeat.i(187353);
    lOt = new k();
    AppMethodBeat.o(187353);
  }
  
  public final i a(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    AppMethodBeat.i(187352);
    d.g.b.k.h(paramString, "appId");
    d.g.b.k.h(paramAppBrandPipContainerView, "pipContainerView");
    paramString = (i)new l(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.o(187352);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.k
 * JD-Core Version:    0.7.0.1
 */