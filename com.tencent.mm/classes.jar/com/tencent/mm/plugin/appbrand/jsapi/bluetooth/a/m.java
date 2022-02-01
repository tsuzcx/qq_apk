package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class m
  extends c<f>
{
  public static final int CTRL_INDEX = 173;
  public static final String NAME = "openBluetoothAdapter";
  
  protected k a(f paramf, k paramk)
  {
    return paramk;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144515);
    h.rG(0);
    Object localObject = paramf.getAppId();
    Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", new Object[] { localObject });
    k localk = a(paramf, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.a((String)localObject, new b.a()new m.2
    {
      public final void onBluetoothStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(144506);
        m.d.a(paramf, paramAnonymousBoolean, false);
        AppMethodBeat.o(144506);
      }
    }, new m.2(this, paramf), new m.3(this, paramf), new m.4(this, paramf)));
    localObject = new HashMap();
    switch (localk.errCode)
    {
    default: 
      ((Map)localObject).put("errCode", Integer.valueOf(localk.errCode));
      paramf.callback(paramInt, a(localk.errMsg, localk.rKn, (Map)localObject));
      h.rG(2);
      AppMethodBeat.o(144515);
      return;
    case 0: 
      if (paramJSONObject != null)
      {
        Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "doSomeGlobalConfigAfterOpenBluetoothAdapter, data: ".concat(String.valueOf(paramJSONObject)));
        if (!paramJSONObject.has("refreshCache")) {
          break;
        }
      }
      break;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jg(paramJSONObject.getBoolean("refreshCache"));
      label215:
      paramf.callback(paramInt, a(a.e.rVt, (Map)localObject));
      h.rG(1);
      AppMethodBeat.o(144515);
      return;
      ((Map)localObject).put("errCode", Integer.valueOf(10009));
      paramf.callback(paramInt, a(a.c.rUI, (Map)localObject));
      h.fr(2, 8);
      AppMethodBeat.o(144515);
      return;
      ((Map)localObject).put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, (Map)localObject));
      h.fr(2, 7);
      AppMethodBeat.o(144515);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label215;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m
 * JD-Core Version:    0.7.0.1
 */