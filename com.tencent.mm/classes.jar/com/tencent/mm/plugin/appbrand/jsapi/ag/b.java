package com.tencent.mm.plugin.appbrand.jsapi.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/version/PluginUpdateStatusChangeNotify;", "", "()V", "dispatch", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "state", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "pluginAppId", "", "UpdateJsEvent", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b syW;
  
  static
  {
    AppMethodBeat.i(326294);
    syW = new b();
    AppMethodBeat.o(326294);
  }
  
  public static final void a(y paramy, c paramc, String paramString)
  {
    AppMethodBeat.i(326290);
    kotlin.g.b.s.u(paramc, "state");
    kotlin.g.b.s.u(paramString, "pluginAppId");
    if (paramy == null)
    {
      AppMethodBeat.o(326290);
      return;
    }
    a locala = new a();
    locala.w("pluginAppid", paramString);
    locala.w("state", paramc.szc);
    locala.h((f)paramy).cpV();
    AppMethodBeat.o(326290);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/version/PluginUpdateStatusChangeNotify$UpdateJsEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    @Deprecated
    public static final int CTRL_INDEX = -2;
    @Deprecated
    public static final String NAME = "onPluginUpdateStatusChange";
    private static final a syX;
    
    static
    {
      AppMethodBeat.i(326292);
      syX = new a((byte)0);
      AppMethodBeat.o(326292);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/version/PluginUpdateStatusChangeNotify$UpdateJsEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b
 * JD-Core Version:    0.7.0.1
 */