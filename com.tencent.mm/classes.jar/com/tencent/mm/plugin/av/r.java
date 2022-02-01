package com.tencent.mm.plugin.av;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;)V", "cacheVideo", "", "data", "", "webview-sdk_release"})
public final class r
  extends a<s>
{
  public r(s params)
  {
    super("wxVideoPrefetcher", (b)params);
    AppMethodBeat.i(205494);
    AppMethodBeat.o(205494);
  }
  
  @JavascriptInterface
  public final void cacheVideo(String paramString)
  {
    AppMethodBeat.i(205492);
    p.k(paramString, "data");
    ((s)this.Pvj).cacheVideo(paramString);
    AppMethodBeat.o(205492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.r
 * JD-Core Version:    0.7.0.1
 */