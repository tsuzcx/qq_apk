package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClient;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClientContext;", "context", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClientContext;)V", "error", "", "msg", "", "log", "postMessage", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.ax.a<b>
{
  public a(b paramb)
  {
    super("WxGameJsCoreNative", (com.tencent.mm.plugin.ax.b)paramb);
    AppMethodBeat.i(303106);
    AppMethodBeat.o(303106);
  }
  
  @JavascriptInterface
  public final void error(String paramString)
  {
    AppMethodBeat.i(303127);
    ((b)this.WlE).error(paramString);
    AppMethodBeat.o(303127);
  }
  
  @JavascriptInterface
  public final void log(String paramString)
  {
    AppMethodBeat.i(303119);
    ((b)this.WlE).log(paramString);
    AppMethodBeat.o(303119);
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(303113);
    ((b)this.WlE).postMessage(paramString);
    AppMethodBeat.o(303113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a
 * JD-Core Version:    0.7.0.1
 */