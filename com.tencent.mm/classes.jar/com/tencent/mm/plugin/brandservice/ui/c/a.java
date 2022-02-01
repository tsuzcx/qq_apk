package com.tencent.mm.plugin.brandservice.ui.c;

import android.webkit.JavascriptInterface;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;)V", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "preloadImage", "url", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.ax.a<b>
{
  public a(b paramb)
  {
    super("wxBizCanvas", (com.tencent.mm.plugin.ax.b)paramb);
    AppMethodBeat.i(301732);
    AppMethodBeat.o(301732);
  }
  
  @JavascriptInterface
  public final void adRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(301747);
    s.u(paramString1, "message");
    s.u(paramString2, "subType");
    s.u(paramString3, "callback");
    ((b)this.WlE).adRequest(paramString1, paramString2, paramString3);
    AppMethodBeat.o(301747);
  }
  
  @JavascriptInterface
  public final void canvasRequest(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(301757);
    s.u(paramNumber, "businessId");
    s.u(paramString1, "reqJson");
    s.u(paramString2, "callback");
    ((b)this.WlE).canvasRequest(paramNumber, paramString1, paramString2);
    AppMethodBeat.o(301757);
  }
  
  @JavascriptInterface
  public final void deleteCanvasCard(String paramString)
  {
    AppMethodBeat.i(301745);
    s.u(paramString, "fieldId");
    ((b)this.WlE).deleteCanvasCard(paramString);
    AppMethodBeat.o(301745);
  }
  
  @JavascriptInterface
  public final String getData()
  {
    AppMethodBeat.i(301740);
    String str = ((b)this.WlE).getData();
    AppMethodBeat.o(301740);
    return str;
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(301736);
    s.u(paramString, "key");
    paramString = ((b)this.WlE).getInfo(paramString);
    AppMethodBeat.o(301736);
    return paramString;
  }
  
  @JavascriptInterface
  public final void onItemClick(String paramString, int paramInt)
  {
    AppMethodBeat.i(301761);
    s.u(paramString, "fieldId");
    ((b)this.WlE).onItemClick(paramString, paramInt);
    AppMethodBeat.o(301761);
  }
  
  @JavascriptInterface
  public final void preloadImage(String paramString)
  {
    AppMethodBeat.i(301751);
    s.u(paramString, "url");
    new com.tencent.mm.plugin.webcanvas.b().a(paramString, new ImageDecodeConfig());
    AppMethodBeat.o(301751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c.a
 * JD-Core Version:    0.7.0.1
 */