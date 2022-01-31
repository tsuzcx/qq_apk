package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.widget.b.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

final class a$2
  implements com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a
{
  a$2(a parama, h paramh, com.tencent.luggage.d.a.a parama1, c paramc, int paramInt) {}
  
  public final void uM(String paramString)
  {
    d.a(null);
    ai.d(new a.2.1(this));
    if (paramString.equals("ok"))
    {
      paramString = d.alo();
      y.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[] { paramString });
      if (paramString == null)
      {
        y.e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
        paramString = new HashMap();
        paramString.put("errCode", Integer.valueOf(0));
        this.ggH.C(this.dIS, this.gGO.h("ok:can't gain current wifi may be not open GPS", paramString));
        return;
      }
      try
      {
        localHashMap = new HashMap();
        localHashMap.put("wifi", paramString.rB());
        localHashMap.put("errCode", Integer.valueOf(0));
        this.ggH.C(this.dIS, this.gGO.h("ok", localHashMap));
        return;
      }
      catch (JSONException paramString)
      {
        y.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
        y.printErrStackTrace("MicroMsg.JsApiConenctWifi", paramString, "", new Object[0]);
        paramString = new HashMap();
        paramString.put("errCode", Integer.valueOf(12010));
        this.ggH.C(this.dIS, this.gGO.h("fail:parse json err", paramString));
        return;
      }
    }
    HashMap localHashMap = new HashMap();
    if (paramString.equals("duplicated request")) {
      localHashMap.put("errCode", Integer.valueOf(12004));
    }
    for (;;)
    {
      y.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", new Object[] { paramString });
      this.ggH.C(this.dIS, this.gGO.h("fail:" + paramString, localHashMap));
      return;
      if (paramString.equals("password error")) {
        localHashMap.put("errCode", Integer.valueOf(12002));
      } else {
        localHashMap.put("errCode", Integer.valueOf(12003));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a.2
 * JD-Core Version:    0.7.0.1
 */