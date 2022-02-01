package com.tencent.mm.plugin.ax;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxAdAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;)V", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "", "key", "replaceAdData", "data", "setAdExposeParams", "exposureRatio", "exposureTme", "setAdInsertType", "type", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a<e>
{
  public d(e parame)
  {
    super("wxAd", (b)parame);
    AppMethodBeat.i(260769);
    AppMethodBeat.o(260769);
  }
  
  @JavascriptInterface
  public final void deleteAd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(260782);
    s.u(paramString, "msgId");
    ((e)this.WlE).deleteAd(paramString, paramBoolean);
    AppMethodBeat.o(260782);
  }
  
  @JavascriptInterface
  public final String getAdContext(int paramInt)
  {
    AppMethodBeat.i(260778);
    String str = ((e)this.WlE).getAdContext(paramInt);
    AppMethodBeat.o(260778);
    return str;
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(260790);
    s.u(paramString, "key");
    paramString = ((e)this.WlE).getInfo(paramString);
    AppMethodBeat.o(260790);
    return paramString;
  }
  
  @JavascriptInterface
  public final void replaceAdData(String paramString)
  {
    AppMethodBeat.i(260774);
    s.u(paramString, "data");
    ((e)this.WlE).replaceAdData(paramString);
    AppMethodBeat.o(260774);
  }
  
  @JavascriptInterface
  public final void setAdExposeParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260801);
    ((e)this.WlE).setAdExposeParams(paramInt1, paramInt2);
    AppMethodBeat.o(260801);
  }
  
  @JavascriptInterface
  public final void setAdInsertType(int paramInt)
  {
    AppMethodBeat.i(260797);
    ((e)this.WlE).setAdInsertType(paramInt);
    AppMethodBeat.o(260797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.d
 * JD-Core Version:    0.7.0.1
 */