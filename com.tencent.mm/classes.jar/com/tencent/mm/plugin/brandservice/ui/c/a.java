package com.tencent.mm.plugin.brandservice.ui.c;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;)V", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.plugin.av.a<b>
{
  public a(b paramb)
  {
    super("wxBizCanvas", (com.tencent.mm.plugin.av.b)paramb);
    AppMethodBeat.i(258030);
    AppMethodBeat.o(258030);
  }
  
  @JavascriptInterface
  public final void adRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(258027);
    p.k(paramString1, "message");
    p.k(paramString2, "subType");
    p.k(paramString3, "callback");
    ((b)this.Pvj).adRequest(paramString1, paramString2, paramString3);
    AppMethodBeat.o(258027);
  }
  
  @JavascriptInterface
  public final void canvasRequest(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(258028);
    p.k(paramNumber, "businessId");
    p.k(paramString1, "reqJson");
    p.k(paramString2, "callback");
    ((b)this.Pvj).canvasRequest(paramNumber, paramString1, paramString2);
    AppMethodBeat.o(258028);
  }
  
  @JavascriptInterface
  public final void deleteCanvasCard(String paramString)
  {
    AppMethodBeat.i(258026);
    p.k(paramString, "fieldId");
    ((b)this.Pvj).deleteCanvasCard(paramString);
    AppMethodBeat.o(258026);
  }
  
  @JavascriptInterface
  public final String getData()
  {
    AppMethodBeat.i(258025);
    String str = ((b)this.Pvj).getData();
    AppMethodBeat.o(258025);
    return str;
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(258024);
    p.k(paramString, "key");
    paramString = ((b)this.Pvj).getInfo(paramString);
    AppMethodBeat.o(258024);
    return paramString;
  }
  
  @JavascriptInterface
  public final void onItemClick(String paramString, int paramInt)
  {
    AppMethodBeat.i(258029);
    p.k(paramString, "fieldId");
    ((b)this.Pvj).onItemClick(paramString, paramInt);
    AppMethodBeat.o(258029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c.a
 * JD-Core Version:    0.7.0.1
 */