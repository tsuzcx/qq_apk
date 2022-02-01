package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a;

import android.content.Context;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.ay.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsRuntimeAdapter;", "Lcom/tencent/luggage/container/LuggageRuntime;", "Lcom/tencent/luggage/container/LuggageComponent;", "()V", "TAG", "", "jsCore", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsCoreAdapter;", "attach", "", "appId", "contextName", "evaluateJavascript", "script", "resultCallback", "Landroid/webkit/ValueCallback;", "getBridge", "Lcom/tencent/luggage/bridge/LuggageBridge;", "getContext", "Landroid/content/Context;", "getRuntime", "getUserAgent", "init", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "url", "initCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "isService", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends n
  implements com.tencent.luggage.d.a
{
  public static final b vVH;
  private static a vVI;
  
  static
  {
    AppMethodBeat.i(303176);
    vVH = new b();
    AppMethodBeat.o(303176);
  }
  
  public static final void a(g paramg, String paramString, m<? super Boolean, ? super String, ah> paramm, d paramd)
  {
    AppMethodBeat.i(303170);
    s.u(paramg, "context");
    s.u(paramm, "initCallback");
    s.u(paramd, "contextReporter");
    a.a(paramg, paramString, paramm, paramd);
    vVI = a.vVy;
    paramg = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b.a.vVJ;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b.a.a((n)vVH, (c)vVH);
    AppMethodBeat.o(303170);
  }
  
  public static final void fZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303163);
    s.u(paramString1, "appId");
    s.u(paramString2, "contextName");
    a.fZ(paramString1, paramString2);
    AppMethodBeat.o(303163);
  }
  
  public final n aod()
  {
    return (n)this;
  }
  
  public final o getBridge()
  {
    AppMethodBeat.i(303183);
    if (vVI == null) {
      s.bIx("jsCore");
    }
    o localo = a.getBridge();
    AppMethodBeat.o(303183);
    return localo;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(303193);
    a locala = vVI;
    Object localObject = locala;
    if (locala == null)
    {
      s.bIx("jsCore");
      localObject = null;
    }
    localObject = ((a)localObject).getContext();
    AppMethodBeat.o(303193);
    return localObject;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(303187);
    a locala = vVI;
    Object localObject = locala;
    if (locala == null)
    {
      s.bIx("jsCore");
      localObject = null;
    }
    localObject = ((a)localObject).getUserAgent();
    if (localObject == null)
    {
      AppMethodBeat.o(303187);
      return "";
    }
    AppMethodBeat.o(303187);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */