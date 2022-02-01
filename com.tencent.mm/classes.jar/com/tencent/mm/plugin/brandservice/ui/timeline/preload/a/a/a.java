package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.xwalk.b.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiRequest;", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/JsApiRequest;", "()V", "invokeInOwn", "", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "tryInitXWalk", "callback", "Lkotlin/Function0;", "Companion", "plugin-brandservice_release"})
public final class a<T extends com.tencent.luggage.d.a>
  extends ay<T>
{
  public static final a sQc;
  
  static
  {
    AppMethodBeat.i(264561);
    sQc = new a((byte)0);
    AppMethodBeat.o(264561);
  }
  
  public final void b(final b<T>.a paramb)
  {
    AppMethodBeat.i(264560);
    WebView.c localc = WebView.getCurWebType();
    Log.i("MicroMsg.GamePrefetchJsApiRequest", "[game-web-prefetch] request curWebType: ".concat(String.valueOf(localc)));
    if (localc == WebView.c.aabm)
    {
      paramb = (kotlin.g.a.a)new b(this, paramb);
      Log.i("MicroMsg.GamePrefetchJsApiRequest", "tryInitXWalk isXWalkCoreInited: %s", new Object[] { Boolean.valueOf(WebView.isXWebCoreInited()) });
      if (!WebView.isXWebCoreInited())
      {
        h.ZvG.bc((Runnable)new c(paramb));
        AppMethodBeat.o(264560);
        return;
      }
      paramb.invoke();
      AppMethodBeat.o(264560);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(264560);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiRequest$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama, b.a parama1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "run"})
  static final class c
    implements Runnable
  {
    c(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266876);
      boolean bool1 = g.mH(MMApplicationContext.getContext());
      boolean bool2 = WebView.isXWebCoreInited();
      Log.i("MicroMsg.GamePrefetchJsApiRequest", "tryInitXWalk ret: %s isXWalkCoreInited: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        this.kWs.invoke();
      }
      AppMethodBeat.o(266876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a
 * JD-Core Version:    0.7.0.1
 */