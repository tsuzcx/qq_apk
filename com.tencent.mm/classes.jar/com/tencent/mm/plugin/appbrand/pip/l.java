package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactory;", "()V", "createPipStablePosLogic", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements k
{
  public static final l tKP;
  
  static
  {
    AppMethodBeat.i(319631);
    tKP = new l();
    AppMethodBeat.o(319631);
  }
  
  public final j a(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    AppMethodBeat.i(319641);
    s.u(paramString, "appId");
    s.u(paramAppBrandPipContainerView, "pipContainerView");
    paramString = (j)new m(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.o(319641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.l
 * JD-Core Version:    0.7.0.1
 */