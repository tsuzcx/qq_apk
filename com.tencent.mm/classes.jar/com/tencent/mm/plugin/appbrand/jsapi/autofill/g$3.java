package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

final class g$3
  extends k
{
  g$3(g paramg, ac paramac) {}
  
  public final void Zr(String paramString)
  {
    AppMethodBeat.i(229892);
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, onLinkClick url:%s", new Object[] { paramString });
    c localc = new c();
    localc.url = paramString;
    paramString = this.lIf;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", localc.url);
    Log.i("MicroMsg.JsApiEventTextViewLinkClick", "onTextViewLinkClick, url:%s", new Object[] { localc.url });
    localc.L(localHashMap).h(paramString).bEo();
    AppMethodBeat.o(229892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.3
 * JD-Core Version:    0.7.0.1
 */