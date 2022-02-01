package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 680;
  public static final String NAME = "openWCPayOverseaPaymentReceive";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46721);
    ad.i("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "invoke JsApiOpenWCPayOverseaPaymentReceive!");
    if (paramc == null)
    {
      ad.e("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "fail:component is null");
      AppMethodBeat.o(46721);
      return;
    }
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "fail:context is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46721);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.au(paramJSONObject, 7);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(46721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.f
 * JD-Core Version:    0.7.0.1
 */