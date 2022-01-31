package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.widget.b.h;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 316;
  public static final String NAME = "connectWifi";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!d.gGR)
    {
      y.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.C(paramInt, h("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("SSID")))
    {
      y.e("MicroMsg.JsApiConenctWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      return;
    }
    Object localObject2 = paramc.getContext();
    if (localObject2 == null)
    {
      y.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:context is null", paramJSONObject));
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cp((Context)localObject2);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      y.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.C(paramInt, h("fail:wifi is disable", paramJSONObject));
      return;
    }
    Object localObject1 = (com.tencent.luggage.d.a.a)e.i(com.tencent.luggage.d.a.a.class);
    localObject2 = ((com.tencent.luggage.d.a.a)localObject1).ac((Context)localObject2);
    ai.d(new Runnable()
    {
      public final void run()
      {
        paramc.Zm().b(this.gGN);
      }
    });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.a(new a.2(this, (h)localObject2, (com.tencent.luggage.d.a.a)localObject1, paramc, paramInt));
    localObject1 = new a.3(this, paramc);
    g.a(paramc.getAppId(), (g.b)localObject1);
    localObject1 = paramJSONObject.optString("SSID");
    localObject2 = paramJSONObject.optString("BSSID");
    paramJSONObject = paramJSONObject.optString("password");
    if (((String)localObject1).equals(""))
    {
      y.e("MicroMsg.JsApiConenctWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12008));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      return;
    }
    y.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", new Object[] { localObject1, localObject2 });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.C((String)localObject1, (String)localObject2, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a
 * JD-Core Version:    0.7.0.1
 */