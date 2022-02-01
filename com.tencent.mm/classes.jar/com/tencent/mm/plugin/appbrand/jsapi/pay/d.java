package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zo;
import com.tencent.mm.g.a.zo.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
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
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(46716);
      return;
    }
    final zo localzo = new zo();
    localzo.efF.action = paramJSONObject.optString("action");
    localzo.efF.buffer = paramJSONObject.optString("buffer");
    localzo.efF.appId = paramJSONObject.optString("appId");
    localzo.efF.efI = Util.getInt(paramJSONObject.optString("walletRegion"), 0);
    localzo.efF.dmc = paramJSONObject.optString("timeStamp");
    localzo.efF.nonceStr = paramJSONObject.optString("nonceStr");
    localzo.efF.dQk = paramJSONObject.optString("paySign");
    localzo.efF.signType = paramJSONObject.optString("signType");
    localzo.efF.efH = paramJSONObject.optString("package");
    localzo.efF.url = paramJSONObject.optString("url");
    localzo.efG.efJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localzo.efG.retCode == 0)
        {
          new HashMap().put("buffer", localzo.efG.buffer);
          paramf.i(paramInt, d.this.h("ok", null));
          AppMethodBeat.o(46715);
          return;
        }
        if (localzo.efG.retCode == -2)
        {
          paramf.i(paramInt, d.this.h("null", null));
          AppMethodBeat.o(46715);
          return;
        }
        paramf.i(paramInt, d.this.h("fail", null));
        AppMethodBeat.o(46715);
      }
    };
    EventCenter.instance.publish(localzo);
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */