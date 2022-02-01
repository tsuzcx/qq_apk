package com.tencent.mm.plugin.av;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxAdAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;)V", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "", "key", "replaceAdData", "data", "webview-sdk_release"})
public final class d
  extends a<e>
{
  public d(e parame)
  {
    super("wxAd", (b)parame);
    AppMethodBeat.i(207271);
    AppMethodBeat.o(207271);
  }
  
  @JavascriptInterface
  public final void deleteAd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207266);
    p.k(paramString, "msgId");
    ((e)this.Pvj).deleteAd(paramString, paramBoolean);
    AppMethodBeat.o(207266);
  }
  
  @JavascriptInterface
  public final String getAdContext(int paramInt)
  {
    AppMethodBeat.i(207262);
    String str = ((e)this.Pvj).getAdContext(paramInt);
    AppMethodBeat.o(207262);
    return str;
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(207269);
    p.k(paramString, "key");
    paramString = ((e)this.Pvj).getInfo(paramString);
    AppMethodBeat.o(207269);
    return paramString;
  }
  
  @JavascriptInterface
  public final void replaceAdData(String paramString)
  {
    AppMethodBeat.i(207261);
    p.k(paramString, "data");
    ((e)this.Pvj).replaceAdData(paramString);
    AppMethodBeat.o(207261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.d
 * JD-Core Version:    0.7.0.1
 */