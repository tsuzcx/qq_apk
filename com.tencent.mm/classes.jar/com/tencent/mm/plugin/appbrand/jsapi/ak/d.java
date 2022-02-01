package com.tencent.mm.plugin.appbrand.jsapi.ak;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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
  public static boolean sNz = false;
  
  public final void a(final f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144691);
    Log.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
    paramJSONObject = paramf.getContext();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144691);
      return;
    }
    g.eW(paramJSONObject);
    if (!sNz)
    {
      a.eU(paramJSONObject);
      a.a(new com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.b()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(325765);
          try
          {
            a.a locala = new a.a();
            HashMap localHashMap = new HashMap();
            localHashMap.put("wifi", paramAnonymouse.aZh());
            locala.b(paramf, 0).L(localHashMap).cpV();
            AppMethodBeat.o(325765);
            return;
          }
          catch (JSONException paramAnonymouse)
          {
            Log.e("MicroMsg.JsApiStartWifi", "onConnect error");
            Log.printErrStackTrace("MicroMsg.JsApiStartWifi", paramAnonymouse, "", new Object[0]);
            AppMethodBeat.o(325765);
          }
        }
        
        public final void b(e paramAnonymouse)
        {
          AppMethodBeat.i(325775);
          try
          {
            a.b localb = new a.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("wifi", paramAnonymouse.aZh());
            localb.b(paramf, 0).L(localHashMap).cpV();
            AppMethodBeat.o(325775);
            return;
          }
          catch (JSONException paramAnonymouse)
          {
            Log.e("MicroMsg.JsApiStartWifi", "onConnectAcceptIncomplete error");
            Log.printErrStackTrace("MicroMsg.JsApiStartWifi", paramAnonymouse, "", new Object[0]);
            AppMethodBeat.o(325775);
          }
        }
        
        public final void onDisconnect()
        {
          AppMethodBeat.i(325776);
          d.K(paramf);
          AppMethodBeat.o(325776);
        }
      });
      sNz = true;
    }
    paramJSONObject = new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(144690);
        a.eV(paramJSONObject);
        d.sNz = false;
        k.b(paramf.getAppId(), this);
        AppMethodBeat.o(144690);
      }
    };
    k.a(paramf.getAppId(), paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramf.callback(paramInt, m("ok", paramJSONObject));
    AppMethodBeat.o(144691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.d
 * JD-Core Version:    0.7.0.1
 */