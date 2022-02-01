package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 184;
  private static final String NAME = "writeBLECharacteristicValue";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144527);
    h.rG(56);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, null));
      h.fr(58, 59);
      AppMethodBeat.o(144527);
      return;
    }
    Log.i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.aan(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(58, 61);
      AppMethodBeat.o(144527);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(58, 63);
      AppMethodBeat.o(144527);
      return;
    }
    String str3 = paramJSONObject.optString("deviceId");
    String str4 = paramJSONObject.optString("serviceId");
    String str5 = paramJSONObject.optString("characteristicId");
    str2 = null;
    Object localObject = str2;
    if (paramJSONObject.has("handle")) {}
    try
    {
      i = paramJSONObject.getInt("handle");
      localObject = Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        String str1 = str2;
      }
    }
    str2 = paramJSONObject.optString("value");
    bool1 = paramJSONObject.optBoolean("debug", false);
    bool2 = paramJSONObject.optBoolean("mainThread", false);
    bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = paramJSONObject.optString("writeType");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      i = -1;
    }
    switch (paramJSONObject.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        i = 0;
      }
      break;
    }
    for (;;)
    {
      paramJSONObject = new j(str4, str5, (Integer)localObject, i, str2);
      paramJSONObject.debug = bool1;
      paramJSONObject.rMf = bool2;
      paramJSONObject.rMh = bool3;
      localb.a(str3, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void onResult(k paramAnonymousk)
        {
          AppMethodBeat.i(144526);
          switch (paramAnonymousk.errCode)
          {
          default: 
            HashMap localHashMap = new HashMap();
            localHashMap.put("errCode", Integer.valueOf(paramAnonymousk.errCode));
            paramf.callback(paramInt, r.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, localHashMap));
            h.rG(58);
            AppMethodBeat.o(144526);
            return;
          }
          paramAnonymousk = new HashMap();
          paramAnonymousk.put("errCode", Integer.valueOf(0));
          paramf.callback(paramInt, r.this.a(null, a.e.rVt, paramAnonymousk));
          h.rG(58);
          AppMethodBeat.o(144526);
        }
      });
      AppMethodBeat.o(144527);
      return;
      if (!paramJSONObject.equals("write")) {
        break;
      }
      i = 0;
      break;
      if (!paramJSONObject.equals("writeNoResponse")) {
        break;
      }
      i = 1;
      break;
      i = 1;
      continue;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.r
 * JD-Core Version:    0.7.0.1
 */