package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "Companion", "luggage-wxa-app-jsapi_release"})
public final class a
  extends r
{
  private static final int CTRL_INDEX = 881;
  private static final String NAME = "onNavigateBackIntercept";
  public static final a pir;
  
  static
  {
    AppMethodBeat.i(209118);
    pir = new a((byte)0);
    AppMethodBeat.o(209118);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "dispatch", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "type", "luggage-wxa-app-jsapi_release"})
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, int paramInt)
    {
      AppMethodBeat.i(209150);
      p.k(paramAppBrandRuntime, "rt");
      a locala = new a((byte)0);
      Log.i("AppBrandOnNavigateBackInterceptEvent", "[dispatch] type=".concat(String.valueOf(paramInt)));
      HashMap localHashMap = new HashMap(1);
      ((Map)localHashMap).put("type", Integer.valueOf(paramInt));
      locala.D((Map)localHashMap).i((e)paramAppBrandRuntime.QW()).bPO();
      paramAppBrandRuntime = paramAppBrandRuntime.bBX();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = paramAppBrandRuntime.getPageView();
        if (paramAppBrandRuntime != null)
        {
          locala.D((Map)localHashMap).i((e)paramAppBrandRuntime).bPO();
          AppMethodBeat.o(209150);
          return;
        }
      }
      AppMethodBeat.o(209150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.a
 * JD-Core Version:    0.7.0.1
 */