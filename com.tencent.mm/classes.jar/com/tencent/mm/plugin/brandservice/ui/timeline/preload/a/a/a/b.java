package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a;

import android.content.Context;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.aw.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsRuntimeAdapter;", "Lcom/tencent/luggage/container/LuggageRuntime;", "Lcom/tencent/luggage/container/LuggageComponent;", "()V", "TAG", "", "jsCore", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsCoreAdapter;", "attach", "", "appId", "contextName", "evaluateJavascript", "script", "resultCallback", "Landroid/webkit/ValueCallback;", "getBridge", "Lcom/tencent/luggage/bridge/LuggageBridge;", "getContext", "Landroid/content/Context;", "getRuntime", "getUserAgent", "init", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "url", "initCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "isService", "plugin-brandservice_release"})
public final class b
  extends n
  implements com.tencent.luggage.d.a
{
  private static a sQt;
  public static final b sQu;
  
  static
  {
    AppMethodBeat.i(262328);
    sQu = new b();
    AppMethodBeat.o(262328);
  }
  
  public static final void a(g paramg, String paramString, m<? super Boolean, ? super String, x> paramm, f paramf)
  {
    AppMethodBeat.i(262310);
    p.k(paramg, "context");
    p.k(paramm, "initCallback");
    p.k(paramf, "contextReporter");
    a.a(paramg, paramString, paramm, paramf);
    sQt = a.sQi;
    paramg = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b.a.sQw;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b.a.a((n)sQu, (c)sQu);
    AppMethodBeat.o(262310);
  }
  
  public static final void fz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(262306);
    p.k(paramString1, "appId");
    p.k(paramString2, "contextName");
    a.fz(paramString1, paramString2);
    AppMethodBeat.o(262306);
  }
  
  public final n NS()
  {
    return (n)this;
  }
  
  public final o getBridge()
  {
    AppMethodBeat.i(262313);
    if (sQt == null) {
      p.bGy("jsCore");
    }
    o localo = a.getBridge();
    AppMethodBeat.o(262313);
    return localo;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(262322);
    Object localObject = sQt;
    if (localObject == null) {
      p.bGy("jsCore");
    }
    localObject = ((a)localObject).getContext();
    AppMethodBeat.o(262322);
    return localObject;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(262316);
    Object localObject = sQt;
    if (localObject == null) {
      p.bGy("jsCore");
    }
    String str = ((a)localObject).getUserAgent();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(262316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */