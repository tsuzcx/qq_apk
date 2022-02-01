package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends c
{
  public static final int CTRL_INDEX = 314;
  public static final String NAME = "startWifi";
  public static boolean pIH = false;
  
  public final void a(final e parame, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144691);
    Log.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
    paramJSONObject = parame.getContext();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144691);
      return;
    }
    f.eb(paramJSONObject);
    if (!pIH)
    {
      a.dZ(paramJSONObject);
      a.a(new a.b()
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.ah.a.d paramAnonymousd)
        {
          AppMethodBeat.i(198703);
          try
          {
            a.a locala = new a.a();
            HashMap localHashMap = new HashMap();
            localHashMap.put("wifi", paramAnonymousd.toJSONObject());
            locala.b(parame, 0).E(localHashMap).bPO();
            AppMethodBeat.o(198703);
            return;
          }
          catch (JSONException paramAnonymousd)
          {
            Log.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
            Log.printErrStackTrace("MicroMsg.JsApiStartWifi", paramAnonymousd, "", new Object[0]);
            AppMethodBeat.o(198703);
          }
        }
        
        public final void aFw()
        {
          AppMethodBeat.i(198705);
          d.I(parame);
          AppMethodBeat.o(198705);
        }
      });
      pIH = true;
    }
    paramJSONObject = new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(144690);
        a.ea(paramJSONObject);
        d.pIH = false;
        k.b(parame.getAppId(), this);
        AppMethodBeat.o(144690);
      }
    };
    k.a(parame.getAppId(), paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    parame.j(paramInt, m("ok", paramJSONObject));
    AppMethodBeat.o(144691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.d
 * JD-Core Version:    0.7.0.1
 */