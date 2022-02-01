package com.tencent.mm.plugin.ax;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;)V", "cacheVideo", "", "data", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends a<s>
{
  public r(s params)
  {
    super("wxVideoPrefetcher", (b)params);
    AppMethodBeat.i(260777);
    AppMethodBeat.o(260777);
  }
  
  @JavascriptInterface
  public final void cacheVideo(String paramString)
  {
    AppMethodBeat.i(260783);
    kotlin.g.b.s.u(paramString, "data");
    ((s)this.WlE).cacheVideo(paramString);
    AppMethodBeat.o(260783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.r
 * JD-Core Version:    0.7.0.1
 */