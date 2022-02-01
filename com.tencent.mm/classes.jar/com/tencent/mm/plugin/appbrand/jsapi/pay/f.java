package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f
  extends c
{
  public static final int CTRL_INDEX = 680;
  public static final String NAME = "openWCPayOverseaPaymentReceive";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46721);
    Log.i("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "invoke JsApiOpenWCPayOverseaPaymentReceive!");
    if (parame == null)
    {
      Log.e("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "fail:component is null");
      AppMethodBeat.o(46721);
      return;
    }
    paramJSONObject = parame.getContext();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "fail:context is null");
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(46721);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.aV(paramJSONObject, 7);
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(46721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.f
 * JD-Core Version:    0.7.0.1
 */