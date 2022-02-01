package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxMessageAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;)V", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"})
public final class l
  extends a<m>
{
  public l(m paramm)
  {
    super("wxMessage", (b)paramm);
    AppMethodBeat.i(224837);
    AppMethodBeat.o(224837);
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224836);
    p.h(paramString1, "message");
    p.h(paramString2, "targetOrigin");
    ((m)this.IBa).postMessage(paramString1, paramString2);
    AppMethodBeat.o(224836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.l
 * JD-Core Version:    0.7.0.1
 */