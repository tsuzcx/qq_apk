package com.tencent.mm.plugin.av;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxMessageAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;)V", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"})
public final class l
  extends a<m>
{
  public l(m paramm)
  {
    super("wxMessage", (b)paramm);
    AppMethodBeat.i(206512);
    AppMethodBeat.o(206512);
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206510);
    p.k(paramString1, "message");
    p.k(paramString2, "targetOrigin");
    ((m)this.Pvj).postMessage(paramString1, paramString2);
    AppMethodBeat.o(206510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.l
 * JD-Core Version:    0.7.0.1
 */