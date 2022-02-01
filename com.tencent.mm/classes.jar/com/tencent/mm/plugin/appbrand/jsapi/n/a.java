package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "Companion", "luggage-wxa-app-jsapi_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.p
{
  private static final int CTRL_INDEX = 881;
  private static final String NAME = "onNavigateBackIntercept";
  public static final a leU;
  
  static
  {
    AppMethodBeat.i(209702);
    leU = new a((byte)0);
    AppMethodBeat.o(209702);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "dispatch", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, int paramInt)
    {
      AppMethodBeat.i(209701);
      d.g.b.p.h(paramAppBrandRuntime, "rt");
      a locala = new a((byte)0);
      ae.i("AppBrandOnNavigateBackInterceptEvent", "[dispatch] type=".concat(String.valueOf(paramInt)));
      HashMap localHashMap = new HashMap(1);
      ((Map)localHashMap).put("type", Integer.valueOf(paramInt));
      locala.H((Map)localHashMap).g((c)paramAppBrandRuntime.Ey()).bja();
      paramAppBrandRuntime = paramAppBrandRuntime.aWm();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = paramAppBrandRuntime.getPageView();
        if (paramAppBrandRuntime != null)
        {
          locala.H((Map)localHashMap).g((c)paramAppBrandRuntime).bja();
          AppMethodBeat.o(209701);
          return;
        }
      }
      AppMethodBeat.o(209701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a
 * JD-Core Version:    0.7.0.1
 */