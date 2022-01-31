package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

final class a$2
  implements com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a
{
  a$2(a parama, k paramk, com.tencent.luggage.c.a.a parama1, c paramc, int paramInt) {}
  
  public final void Df(String paramString)
  {
    AppMethodBeat.i(94369);
    d.a(null);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94368);
        if (a.2.this.ihv != null) {
          a.2.this.ihx.a(a.2.this.ihv);
        }
        AppMethodBeat.o(94368);
      }
    });
    if (paramString.equals("ok"))
    {
      paramString = d.aGr();
      ab.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[] { paramString });
      if (paramString == null)
      {
        ab.e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
        paramString = new HashMap();
        paramString.put("errCode", Integer.valueOf(12006));
        this.hxW.h(this.bAX, this.ihw.j("ok:can't gain current wifi may be not open GPS", paramString));
        AppMethodBeat.o(94369);
        return;
      }
      try
      {
        localHashMap = new HashMap();
        localHashMap.put("wifi", paramString.toJSONObject());
        localHashMap.put("errCode", Integer.valueOf(0));
        this.hxW.h(this.bAX, this.ihw.j("ok", localHashMap));
        AppMethodBeat.o(94369);
        return;
      }
      catch (JSONException paramString)
      {
        ab.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
        ab.printErrStackTrace("MicroMsg.JsApiConenctWifi", paramString, "", new Object[0]);
        paramString = new HashMap();
        paramString.put("errCode", Integer.valueOf(12010));
        this.hxW.h(this.bAX, this.ihw.j("fail:parse json err", paramString));
        AppMethodBeat.o(94369);
        return;
      }
    }
    HashMap localHashMap = new HashMap();
    if (paramString.equals("duplicated request")) {
      localHashMap.put("errCode", Integer.valueOf(12004));
    }
    for (;;)
    {
      ab.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", new Object[] { paramString });
      this.hxW.h(this.bAX, this.ihw.j("fail:".concat(String.valueOf(paramString)), localHashMap));
      AppMethodBeat.o(94369);
      return;
      if (paramString.equals("password error")) {
        localHashMap.put("errCode", Integer.valueOf(12002));
      } else if (paramString.equals("wifi config may be expired")) {
        localHashMap.put("errCode", Integer.valueOf(12013));
      } else {
        localHashMap.put("errCode", Integer.valueOf(12003));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a.2
 * JD-Core Version:    0.7.0.1
 */