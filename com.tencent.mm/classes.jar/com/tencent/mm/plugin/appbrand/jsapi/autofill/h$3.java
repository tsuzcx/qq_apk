package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

final class h$3
  extends m
{
  h$3(h paramh, ad paramad) {}
  
  public final void aac(String paramString)
  {
    AppMethodBeat.i(326668);
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, onLinkClick url:%s", new Object[] { paramString });
    c localc = new c();
    localc.url = paramString;
    paramString = this.rHC;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", localc.url);
    Log.i("MicroMsg.JsApiEventTextViewLinkClick", "onTextViewLinkClick, url:%s", new Object[] { localc.url });
    localc.L(localHashMap).i(paramString).cpV();
    AppMethodBeat.o(326668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.h.3
 * JD-Core Version:    0.7.0.1
 */