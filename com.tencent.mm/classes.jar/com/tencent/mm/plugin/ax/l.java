package com.tencent.mm.plugin.ax;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxMessageAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;)V", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a<m>
{
  public l(m paramm)
  {
    super("wxMessage", (b)paramm);
    AppMethodBeat.i(260786);
    AppMethodBeat.o(260786);
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260794);
    s.u(paramString1, "message");
    s.u(paramString2, "targetOrigin");
    ((m)this.WlE).postMessage(paramString1, paramString2);
    AppMethodBeat.o(260794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.l
 * JD-Core Version:    0.7.0.1
 */