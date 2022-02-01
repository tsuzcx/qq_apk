package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class p$2
  implements j
{
  p$2(p paramp, f paramf) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(144519);
    f localf = this.erj;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
      AppMethodBeat.o(144519);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(paramd.cqc());
      paramd = new p.a();
      localJSONObject = new JSONObject();
    }
    catch (JSONException paramd)
    {
      try
      {
        JSONObject localJSONObject;
        localJSONObject.remove("devices");
        localJSONObject.put("devices", localJSONArray);
        paramd.b(localf, localf.getComponentId()).ZR(localJSONObject.toString()).cpV();
        Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { localJSONObject.toString() });
        AppMethodBeat.o(144519);
        return;
        paramd = paramd;
        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramd });
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
        }
      }
    }
  }
  
  public final void dj(List<d> paramList)
  {
    AppMethodBeat.i(144520);
    f localf = this.erj;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
      AppMethodBeat.o(144520);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      try
      {
        localJSONArray.put(locald.cqc());
      }
      catch (JSONException localJSONException2)
      {
        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException2 });
      }
    }
    paramList = new p.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.remove("devices");
      localJSONObject.put("devices", localJSONArray);
      paramList.b(localf, localf.getComponentId()).ZR(localJSONObject.toString()).cpV();
      Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(144520);
      return;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.p.2
 * JD-Core Version:    0.7.0.1
 */