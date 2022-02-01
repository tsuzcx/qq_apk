package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactory;", "()V", "createPipStablePosLogic", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "plugin-appbrand-integration_release"})
public final class k
  implements j
{
  public static final k moj;
  
  static
  {
    AppMethodBeat.i(189562);
    moj = new k();
    AppMethodBeat.o(189562);
  }
  
  public final i a(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    AppMethodBeat.i(189561);
    p.h(paramString, "appId");
    p.h(paramAppBrandPipContainerView, "pipContainerView");
    paramString = (i)new l(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.o(189561);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.k
 * JD-Core Version:    0.7.0.1
 */