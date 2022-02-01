package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClient;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClientContext;", "context", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClientContext;)V", "error", "", "msg", "", "log", "postMessage", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.plugin.av.a<b>
{
  public a(b paramb)
  {
    super("WxGameJsCoreNative", (com.tencent.mm.plugin.av.b)paramb);
    AppMethodBeat.i(262022);
    AppMethodBeat.o(262022);
  }
  
  @JavascriptInterface
  public final void error(String paramString)
  {
    AppMethodBeat.i(262017);
    ((b)this.Pvj).error(paramString);
    AppMethodBeat.o(262017);
  }
  
  @JavascriptInterface
  public final void log(String paramString)
  {
    AppMethodBeat.i(262015);
    ((b)this.Pvj).log(paramString);
    AppMethodBeat.o(262015);
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(262011);
    ((b)this.Pvj).postMessage(paramString);
    AppMethodBeat.o(262011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a
 * JD-Core Version:    0.7.0.1
 */