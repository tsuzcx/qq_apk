package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class b<Component extends f>
  extends c<Component>
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public void a(Component paramComponent, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144495);
    h.rG(116);
    paramJSONObject = paramComponent.getAppId();
    Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.aao(paramJSONObject);
    Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    switch (paramJSONObject.errCode)
    {
    default: 
      paramComponent.callback(paramInt, a(paramJSONObject.errMsg, paramJSONObject.rKn, null));
      h.rG(118);
      AppMethodBeat.o(144495);
      return;
    }
    paramComponent.callback(paramInt, a(null, a.e.rVt, null));
    h.rG(117);
    AppMethodBeat.o(144495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.b
 * JD-Core Version:    0.7.0.1
 */