package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.g.a.yd.b;
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
    final yd localyd = new yd();
    localyd.dMt.action = paramJSONObject.optString("action");
    localyd.dMt.buffer = paramJSONObject.optString("buffer");
    localyd.dMt.appId = paramJSONObject.optString("appId");
    localyd.dMt.dMx = bt.getInt(paramJSONObject.optString("walletRegion"), 0);
    localyd.dMt.cUM = paramJSONObject.optString("timeStamp");
    localyd.dMt.nonceStr = paramJSONObject.optString("nonceStr");
    localyd.dMt.dMw = paramJSONObject.optString("paySign");
    localyd.dMt.signType = paramJSONObject.optString("signType");
    localyd.dMt.dMv = paramJSONObject.optString("package");
    localyd.dMt.url = paramJSONObject.optString("url");
    localyd.dMu.dMy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localyd.dMu.retCode == 0)
        {
          new HashMap().put("buffer", localyd.dMu.buffer);
          paramc.h(paramInt, d.this.e("ok", null));
          AppMethodBeat.o(46715);
          return;
        }
        if (localyd.dMu.retCode == -2)
        {
          paramc.h(paramInt, d.this.e("null", null));
          AppMethodBeat.o(46715);
          return;
        }
        paramc.h(paramInt, d.this.e("fail", null));
        AppMethodBeat.o(46715);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l(localyd);
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */