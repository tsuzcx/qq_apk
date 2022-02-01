package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "Companion", "luggage-wxa-app-jsapi_release"})
public final class a
  extends s
{
  private static final int CTRL_INDEX = 881;
  private static final String NAME = "onNavigateBackIntercept";
  public static final a mkm;
  
  static
  {
    AppMethodBeat.i(240918);
    mkm = new a((byte)0);
    AppMethodBeat.o(240918);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "dispatch", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, int paramInt)
    {
      AppMethodBeat.i(240917);
      p.h(paramAppBrandRuntime, "rt");
      a locala = new a((byte)0);
      Log.i("AppBrandOnNavigateBackInterceptEvent", "[dispatch] type=".concat(String.valueOf(paramInt)));
      HashMap localHashMap = new HashMap(1);
      ((Map)localHashMap).put("type", Integer.valueOf(paramInt));
      locala.K((Map)localHashMap).g((f)paramAppBrandRuntime.NY()).bEo();
      paramAppBrandRuntime = paramAppBrandRuntime.brh();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = paramAppBrandRuntime.getPageView();
        if (paramAppBrandRuntime != null)
        {
          locala.K((Map)localHashMap).g((f)paramAppBrandRuntime).bEo();
          AppMethodBeat.o(240917);
          return;
        }
      }
      AppMethodBeat.o(240917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a
 * JD-Core Version:    0.7.0.1
 */