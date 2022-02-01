package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aav;
import com.tencent.mm.f.a.aav.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.event.EventCenter;
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
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46716);
    Log.i("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "invoke JsApiHandleWCPayOverseaWalletBuffer!");
    if (parame == null)
    {
      Log.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:component is null");
      AppMethodBeat.o(46716);
      return;
    }
    if (parame.getContext() == null)
    {
      Log.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:context is null");
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(46716);
      return;
    }
    final aav localaav = new aav();
    localaav.fZU.action = paramJSONObject.optString("action");
    localaav.fZU.fZY = paramJSONObject.optString("buffer");
    localaav.fZU.appId = paramJSONObject.optString("appId");
    localaav.fZU.fZX = Util.getInt(paramJSONObject.optString("walletRegion"), 0);
    localaav.fZU.fdH = paramJSONObject.optString("timeStamp");
    localaav.fZU.nonceStr = paramJSONObject.optString("nonceStr");
    localaav.fZU.fJB = paramJSONObject.optString("paySign");
    localaav.fZU.signType = paramJSONObject.optString("signType");
    localaav.fZU.fZW = paramJSONObject.optString("package");
    localaav.fZU.url = paramJSONObject.optString("url");
    localaav.fZV.fZZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46715);
        if (localaav.fZV.retCode == 0)
        {
          new HashMap().put("buffer", localaav.fZV.fZY);
          parame.j(paramInt, d.this.h("ok", null));
          AppMethodBeat.o(46715);
          return;
        }
        if (localaav.fZV.retCode == -2)
        {
          parame.j(paramInt, d.this.h("null", null));
          AppMethodBeat.o(46715);
          return;
        }
        parame.j(paramInt, d.this.h("fail", null));
        AppMethodBeat.o(46715);
      }
    };
    EventCenter.instance.publish(localaav);
    AppMethodBeat.o(46716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.d
 * JD-Core Version:    0.7.0.1
 */