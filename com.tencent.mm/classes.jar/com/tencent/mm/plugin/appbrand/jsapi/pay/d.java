package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yj.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    ae.i("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "invoke JsApiHandleWCPayOverseaWalletBuffer!");
    if (paramc == null)
    {
      ae.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:component is null");
      AppMethodBeat.o(46716);
      return;
    }
    if (paramc.getContext() == null)
    {
      ae.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:context is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46716);
      return;
    }
    final yj localyj = new yj();
    localyj.dNJ.action = paramJSONObject.optString("action");
    localyj.dNJ.buffer = paramJSONObject.optString("buffer");
    localyj.dNJ.appId = paramJSONObject.optString("appId");
    localyj.dNJ.dNN = bu.getInt(paramJSONObject.optString("walletRegion"), 0);
    localyj.dNJ.cVJ = paramJSONObject.optString("timeStamp");
    localyj.dNJ.nonceStr = paramJSONObject.optString("nonceStr");
    localyj.dNJ.dNM = paramJSONObject.optString("paySign");
    localyj.dNJ.signType = paramJSONObject.optString("signType");
    localyj.dNJ.dNL = paramJSONObject.optString("package");
    localyj.dNJ.url = paramJSONObject.optString("url");
    localyj.dNK.dNO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localyj.dNK.retCode == 0)
        {
          new HashMap().put("buffer", localyj.dNK.buffer);
          paramc.h(paramInt, d.this.e("ok", null));
          AppMethodBeat.o(46715);
          return;
        }
        if (localyj.dNK.retCode == -2)
        {
          paramc.h(paramInt, d.this.e("null", null));
          AppMethodBeat.o(46715);
          return;
        }
        paramc.h(paramInt, d.this.e("fail", null));
        AppMethodBeat.o(46715);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l(localyj);
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */