package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;)V", "cacheVideo", "", "data", "", "webview-sdk_release"})
public final class r
  extends a<s>
{
  public r(s params)
  {
    super("wxVideoPrefetcher", (b)params);
    AppMethodBeat.i(224847);
    AppMethodBeat.o(224847);
  }
  
  @JavascriptInterface
  public final void cacheVideo(String paramString)
  {
    AppMethodBeat.i(224846);
    p.h(paramString, "data");
    ((s)this.IBa).cacheVideo(paramString);
    AppMethodBeat.o(224846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.r
 * JD-Core Version:    0.7.0.1
 */