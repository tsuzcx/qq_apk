package com.tencent.mm.plugin.brandservice.ui.c;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;)V", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.plugin.ab.a<b>
{
  public a(b paramb)
  {
    super("wxBizCanvas", (com.tencent.mm.plugin.ab.b)paramb);
    AppMethodBeat.i(196006);
    AppMethodBeat.o(196006);
  }
  
  @JavascriptInterface
  public final void adRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(196003);
    p.h(paramString1, "message");
    p.h(paramString2, "subType");
    p.h(paramString3, "callback");
    ((b)this.IBa).adRequest(paramString1, paramString2, paramString3);
    AppMethodBeat.o(196003);
  }
  
  @JavascriptInterface
  public final void canvasRequest(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196004);
    p.h(paramNumber, "businessId");
    p.h(paramString1, "reqJson");
    p.h(paramString2, "callback");
    ((b)this.IBa).canvasRequest(paramNumber, paramString1, paramString2);
    AppMethodBeat.o(196004);
  }
  
  @JavascriptInterface
  public final void deleteCanvasCard(String paramString)
  {
    AppMethodBeat.i(196002);
    p.h(paramString, "fieldId");
    ((b)this.IBa).deleteCanvasCard(paramString);
    AppMethodBeat.o(196002);
  }
  
  @JavascriptInterface
  public final String getData()
  {
    AppMethodBeat.i(196001);
    String str = ((b)this.IBa).getData();
    AppMethodBeat.o(196001);
    return str;
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(196000);
    p.h(paramString, "key");
    paramString = ((b)this.IBa).getInfo(paramString);
    AppMethodBeat.o(196000);
    return paramString;
  }
  
  @JavascriptInterface
  public final void onItemClick(String paramString, int paramInt)
  {
    AppMethodBeat.i(196005);
    p.h(paramString, "fieldId");
    ((b)this.IBa).onItemClick(paramString, paramInt);
    AppMethodBeat.o(196005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c.a
 * JD-Core Version:    0.7.0.1
 */