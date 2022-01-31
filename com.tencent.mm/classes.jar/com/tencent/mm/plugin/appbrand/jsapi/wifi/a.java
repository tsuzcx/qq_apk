package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
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
    AppMethodBeat.i(94371);
    if (!d.ihz)
    {
      ab.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, j("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(94371);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("SSID")))
    {
      ab.e("MicroMsg.JsApiConenctWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, j("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(94371);
      return;
    }
    Object localObject2 = paramc.getContext();
    if (localObject2 == null)
    {
      ab.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, j("fail:context is null", paramJSONObject));
      AppMethodBeat.o(94371);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cR((Context)localObject2);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ab.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, j("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(94371);
      return;
    }
    if (paramc.asW() != b.gYe)
    {
      ab.e("MicroMsg.JsApiConenctWifi", "current state :%s isn't foreground", new Object[] { paramc.asW() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12011));
      paramc.h(paramInt, j("fail:weapp in background", paramJSONObject));
      AppMethodBeat.o(94371);
      return;
    }
    Object localObject1 = (com.tencent.luggage.c.a.a)com.tencent.luggage.a.e.q(com.tencent.luggage.c.a.a.class);
    localObject2 = ((com.tencent.luggage.c.a.a)localObject1).an((Context)localObject2);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94367);
        paramc.asX().b(this.ihv);
        AppMethodBeat.o(94367);
      }
    });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.a(new a.2(this, (k)localObject2, (com.tencent.luggage.c.a.a)localObject1, paramc, paramInt));
    localObject1 = new a.3(this, paramc);
    com.tencent.mm.plugin.appbrand.e.a(paramc.getAppId(), (e.c)localObject1);
    localObject1 = paramJSONObject.optString("SSID");
    localObject2 = paramJSONObject.optString("BSSID");
    paramJSONObject = paramJSONObject.optString("password");
    if (((String)localObject1).equals(""))
    {
      ab.e("MicroMsg.JsApiConenctWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12008));
      paramc.h(paramInt, j("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(94371);
      return;
    }
    ab.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", new Object[] { localObject1, localObject2 });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.F((String)localObject1, (String)localObject2, paramJSONObject);
    AppMethodBeat.o(94371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a
 * JD-Core Version:    0.7.0.1
 */