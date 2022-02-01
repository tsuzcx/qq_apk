package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

final class g$3
  extends k
{
  g$3(g paramg, z paramz) {}
  
  public final void PX(String paramString)
  {
    AppMethodBeat.i(220785);
    ae.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, onLinkClick url:%s", new Object[] { paramString });
    c localc = new c();
    localc.url = paramString;
    paramString = this.kDF;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", localc.url);
    ae.i("MicroMsg.JsApiEventTextViewLinkClick", "onTextViewLinkClick, url:%s", new Object[] { localc.url });
    localc.I(localHashMap).h(paramString).bja();
    AppMethodBeat.o(220785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.3
 * JD-Core Version:    0.7.0.1
 */