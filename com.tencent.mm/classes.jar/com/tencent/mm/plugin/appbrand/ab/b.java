package com.tencent.mm.plugin.appbrand.ab;

import android.content.Context;
import com.tencent.luggage.h.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.page.cb;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/skyline/AppBrandPageViewSkylineRendererWC;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "component", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onCreateCustomWebView", "Lcom/tencent/mm/plugin/appbrand/page/MPWebViewRenderEngine;", "context", "Landroid/content/Context;", "onCreateJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "onCreatePageScriptInjectionMode", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer$IPageScriptInjectionMode;", "onCreateWxaPageSeparatedPluginsInjectHelper", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "onFillRouteInEventData", "", "map", "", "", "openType", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ag
{
  public b(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(316904);
    AppMethodBeat.o(316904);
  }
  
  public final void a(Map<String, Object> paramMap, cb paramcb)
  {
    AppMethodBeat.i(316926);
    s.u(paramMap, "map");
    super.a(paramMap, paramcb);
    paramMap.put("renderer", "skyline");
    AppMethodBeat.o(316926);
  }
  
  public final Map<String, p> aqh()
  {
    AppMethodBeat.i(316931);
    Map localMap = (Map)new HashMap();
    AppMethodBeat.o(316931);
    return localMap;
  }
  
  public final bj cDF()
  {
    AppMethodBeat.i(316917);
    bj localbj = (bj)new d();
    AppMethodBeat.o(316917);
    return localbj;
  }
  
  public final a.a cDG()
  {
    AppMethodBeat.i(316922);
    a.a locala = (a.a)new com.tencent.luggage.h.a.c();
    AppMethodBeat.o(316922);
    return locala;
  }
  
  public final bs fe(Context paramContext)
  {
    AppMethodBeat.i(316912);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.appbrand.jsapi.f localf = aqX();
    s.checkNotNull(localf);
    s.s(localf, "component!!");
    paramContext = (bs)new com.tencent.luggage.h.a.f((com.tencent.luggage.sdk.b.a.c)localf, paramContext);
    AppMethodBeat.o(316912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.b
 * JD-Core Version:    0.7.0.1
 */