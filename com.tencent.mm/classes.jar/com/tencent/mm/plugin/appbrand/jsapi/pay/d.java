package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.g.a.xj.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    ac.i("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "invoke JsApiHandleWCPayOverseaWalletBuffer!");
    if (paramc == null)
    {
      ac.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:component is null");
      AppMethodBeat.o(46716);
      return;
    }
    if (paramc.getContext() == null)
    {
      ac.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:context is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46716);
      return;
    }
    final xj localxj = new xj();
    localxj.dAg.action = paramJSONObject.optString("action");
    localxj.dAg.buffer = paramJSONObject.optString("buffer");
    localxj.dAg.appId = paramJSONObject.optString("appId");
    localxj.dAg.dAk = bs.getInt(paramJSONObject.optString("walletRegion"), 0);
    localxj.dAg.cJz = paramJSONObject.optString("timeStamp");
    localxj.dAg.nonceStr = paramJSONObject.optString("nonceStr");
    localxj.dAg.dAj = paramJSONObject.optString("paySign");
    localxj.dAg.signType = paramJSONObject.optString("signType");
    localxj.dAg.dAi = paramJSONObject.optString("package");
    localxj.dAg.url = paramJSONObject.optString("url");
    localxj.dAh.dAl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localxj.dAh.retCode == 0)
        {
          new HashMap().put("buffer", localxj.dAh.buffer);
          paramc.h(paramInt, d.this.e("ok", null));
          AppMethodBeat.o(46715);
          return;
        }
        if (localxj.dAh.retCode == -2)
        {
          paramc.h(paramInt, d.this.e("null", null));
          AppMethodBeat.o(46715);
          return;
        }
        paramc.h(paramInt, d.this.e("fail", null));
        AppMethodBeat.o(46715);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l(localxj);
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */