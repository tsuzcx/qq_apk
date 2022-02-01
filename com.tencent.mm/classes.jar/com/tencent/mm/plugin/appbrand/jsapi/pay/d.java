package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.wy.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 681;
  public static final String NAME = "handleWCPayOverseaWalletBuffer";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46716);
    ad.i("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "invoke JsApiHandleWCPayOverseaWalletBuffer!");
    if (paramc == null)
    {
      ad.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:component is null");
      AppMethodBeat.o(46716);
      return;
    }
    if (paramc.getContext() == null)
    {
      ad.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:context is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46716);
      return;
    }
    final wy localwy = new wy();
    localwy.dCu.action = paramJSONObject.optString("action");
    localwy.dCu.buffer = paramJSONObject.optString("buffer");
    localwy.dCu.appId = paramJSONObject.optString("appId");
    localwy.dCu.dCy = bt.getInt(paramJSONObject.optString("walletRegion"), 0);
    localwy.dCu.cMo = paramJSONObject.optString("timeStamp");
    localwy.dCu.nonceStr = paramJSONObject.optString("nonceStr");
    localwy.dCu.dCx = paramJSONObject.optString("paySign");
    localwy.dCu.signType = paramJSONObject.optString("signType");
    localwy.dCu.dCw = paramJSONObject.optString("package");
    localwy.dCu.url = paramJSONObject.optString("url");
    localwy.dCv.dCz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localwy.dCv.retCode == 0)
        {
          new HashMap().put("buffer", localwy.dCv.buffer);
          paramc.h(paramInt, d.this.e("ok", null));
          AppMethodBeat.o(46715);
          return;
        }
        if (localwy.dCv.retCode == -2)
        {
          paramc.h(paramInt, d.this.e("null", null));
          AppMethodBeat.o(46715);
          return;
        }
        paramc.h(paramInt, d.this.e("fail", null));
        AppMethodBeat.o(46715);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(localwy);
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */