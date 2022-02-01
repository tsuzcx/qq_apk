package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acs;
import com.tencent.mm.autogen.a.acs.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends c
{
  public static final int CTRL_INDEX = 681;
  public static final String NAME = "handleWCPayOverseaWalletBuffer";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46716);
    Log.i("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "invoke JsApiHandleWCPayOverseaWalletBuffer!");
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:component is null");
      AppMethodBeat.o(46716);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:context is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46716);
      return;
    }
    final acs localacs = new acs();
    localacs.igc.action = paramJSONObject.optString("action");
    localacs.igc.igg = paramJSONObject.optString("buffer");
    localacs.igc.appId = paramJSONObject.optString("appId");
    localacs.igc.igf = Util.getInt(paramJSONObject.optString("walletRegion"), 0);
    localacs.igc.hhx = paramJSONObject.optString("timeStamp");
    localacs.igc.nonceStr = paramJSONObject.optString("nonceStr");
    localacs.igc.hPe = paramJSONObject.optString("paySign");
    localacs.igc.signType = paramJSONObject.optString("signType");
    localacs.igc.ige = paramJSONObject.optString("package");
    localacs.igc.url = paramJSONObject.optString("url");
    localacs.igd.igh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localacs.igd.retCode == 0)
        {
          new HashMap().put("buffer", localacs.igd.igg);
          paramf.callback(paramInt, d.this.ZP("ok"));
          AppMethodBeat.o(46715);
          return;
        }
        if (localacs.igd.retCode == -2)
        {
          paramf.callback(paramInt, d.this.ZP("null"));
          AppMethodBeat.o(46715);
          return;
        }
        paramf.callback(paramInt, d.this.ZP("fail"));
        AppMethodBeat.o(46715);
      }
    };
    localacs.publish();
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */