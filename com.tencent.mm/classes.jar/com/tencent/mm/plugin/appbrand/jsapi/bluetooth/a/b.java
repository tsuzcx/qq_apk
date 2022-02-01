package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

@TargetApi(18)
public final class b
  extends d
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144495);
    c.pl(116);
    paramJSONObject = paramf.getAppId();
    Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.ZD(paramJSONObject);
    Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    switch (paramJSONObject.errCode)
    {
    default: 
      paramf.i(paramInt, h(paramJSONObject.errMsg, null));
      c.pl(118);
      AppMethodBeat.o(144495);
      return;
    }
    paramf.i(paramInt, h("ok", null));
    c.pl(117);
    AppMethodBeat.o(144495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.b
 * JD-Core Version:    0.7.0.1
 */