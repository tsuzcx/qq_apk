package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxAdAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;)V", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "", "key", "replaceAdData", "data", "webview-sdk_release"})
public final class d
  extends a<e>
{
  public d(e parame)
  {
    super("wxAd", (b)parame);
    AppMethodBeat.i(224776);
    AppMethodBeat.o(224776);
  }
  
  @JavascriptInterface
  public final void deleteAd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(224774);
    p.h(paramString, "msgId");
    ((e)this.IBa).deleteAd(paramString, paramBoolean);
    AppMethodBeat.o(224774);
  }
  
  @JavascriptInterface
  public final String getAdContext(int paramInt)
  {
    AppMethodBeat.i(224773);
    String str = ((e)this.IBa).getAdContext(paramInt);
    AppMethodBeat.o(224773);
    return str;
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(224775);
    p.h(paramString, "key");
    paramString = ((e)this.IBa).getInfo(paramString);
    AppMethodBeat.o(224775);
    return paramString;
  }
  
  @JavascriptInterface
  public final void replaceAdData(String paramString)
  {
    AppMethodBeat.i(224772);
    p.h(paramString, "data");
    ((e)this.IBa).replaceAdData(paramString);
    AppMethodBeat.o(224772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.d
 * JD-Core Version:    0.7.0.1
 */