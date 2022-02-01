package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  private static final int CTRL_INDEX = 881;
  private static final String NAME = "onNavigateBackIntercept";
  public static final a snJ;
  
  static
  {
    AppMethodBeat.i(327732);
    snJ = new a((byte)0);
    AppMethodBeat.o(327732);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "dispatch", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "type", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, int paramInt)
    {
      AppMethodBeat.i(327692);
      kotlin.g.b.s.u(paramAppBrandRuntime, "rt");
      a locala = new a((byte)0);
      Log.i("AppBrandOnNavigateBackInterceptEvent", kotlin.g.b.s.X("[dispatch] type=", Integer.valueOf(paramInt)));
      HashMap localHashMap = new HashMap(1);
      ((Map)localHashMap).put("type", Integer.valueOf(paramInt));
      locala.K((Map)localHashMap).h((f)paramAppBrandRuntime.ari()).cpV();
      paramAppBrandRuntime = paramAppBrandRuntime.getPageContainer();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime = paramAppBrandRuntime.getPageView();
        if (paramAppBrandRuntime != null) {
          locala.K((Map)localHashMap).h((f)paramAppBrandRuntime).cpV();
        }
      }
      AppMethodBeat.o(327692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a
 * JD-Core Version:    0.7.0.1
 */