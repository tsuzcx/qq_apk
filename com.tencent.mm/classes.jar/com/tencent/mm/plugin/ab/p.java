package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClient;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;)V", "getId", "", "getUserHash", "", "webview-sdk_release"})
public final class p
  extends a<q>
{
  public p(q paramq)
  {
    super("wxPrefetcherClient", (b)paramq);
    AppMethodBeat.i(224845);
    AppMethodBeat.o(224845);
  }
  
  @JavascriptInterface
  public final String getId()
  {
    AppMethodBeat.i(224843);
    String str = ((q)this.IBa).getId();
    AppMethodBeat.o(224843);
    return str;
  }
  
  @JavascriptInterface
  public final int getUserHash()
  {
    AppMethodBeat.i(224844);
    int i = com.tencent.mm.kernel.a.azs();
    i = Math.abs((i + '-' + com.tencent.mm.compatible.deviceinfo.q.aoz()).hashCode() % 10000);
    AppMethodBeat.o(224844);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.p
 * JD-Core Version:    0.7.0.1
 */