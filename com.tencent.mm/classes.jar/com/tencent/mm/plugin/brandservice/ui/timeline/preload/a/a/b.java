package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiRequest;", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/JsApiRequest;", "()V", "invokeInOwn", "", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "tryInitXWalk", "callback", "Lkotlin/Function0;", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<T extends com.tencent.luggage.d.a>
  extends bc<T>
{
  public static final a vVr;
  
  static
  {
    AppMethodBeat.i(303168);
    vVr = new a((byte)0);
    AppMethodBeat.o(303168);
  }
  
  private static final void aG(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(303155);
    s.u(parama, "$callback");
    ao.initWebviewCore(MMApplicationContext.getContext(), WebView.WebViewKind.aifI, null, (WebView.PreInitCallback)new c(parama));
    AppMethodBeat.o(303155);
  }
  
  public final void b(final com.tencent.luggage.d.b<T>.a paramb)
  {
    AppMethodBeat.i(303181);
    WebView.WebViewKind localWebViewKind = WebView.getCurWebType();
    Log.i("MicroMsg.GamePrefetchJsApiRequest", s.X("[game-web-prefetch] request curWebType: ", localWebViewKind));
    if (localWebViewKind == WebView.WebViewKind.aifI)
    {
      paramb = (kotlin.g.a.a)new b(this, paramb);
      Log.i("MicroMsg.GamePrefetchJsApiRequest", "tryInitXWalk isXWalkCoreInited: %s", new Object[] { Boolean.valueOf(ao.isXWebCoreInited()) });
      if (!ao.isXWebCoreInited())
      {
        h.ahAA.bk(new b..ExternalSyntheticLambda0(paramb));
        AppMethodBeat.o(303181);
        return;
      }
      paramb.invoke();
      AppMethodBeat.o(303181);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(303181);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiRequest$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/luggage/container/LuggageComponent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b<T> paramb, com.tencent.luggage.d.b<T>.a paramb1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiRequest$tryInitXWalk$1$1", "Lcom/tencent/xweb/WebView$PreInitCallback;", "onCoreInitFailed", "", "onCoreInitFinished", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements WebView.PreInitCallback
  {
    c(kotlin.g.a.a<ah> parama) {}
    
    public final void aDm()
    {
      AppMethodBeat.i(303147);
      Log.i("MicroMsg.GamePrefetchJsApiRequest", "tryInitXWalk failed");
      AppMethodBeat.o(303147);
    }
    
    public final void onCoreInitFinished()
    {
      AppMethodBeat.i(303142);
      boolean bool = ao.isXWebCoreInited();
      Log.i("MicroMsg.GamePrefetchJsApiRequest", "tryInitXWalk success, isXWalkCoreInited: %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.nBK.invoke();
      }
      AppMethodBeat.o(303142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b
 * JD-Core Version:    0.7.0.1
 */