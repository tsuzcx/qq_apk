package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.d;

@Metadata(d1={""}, d2={"HEX", "", "TAG", "", "byteArrayToHexString", "bytes", "", "getRandomId", "", "isPeripheralBleSupported", "", "callbackFail", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "env", "errCode", "errMsg", "params", "Ljava/util/HashMap;", "", "callbackSuccess", "toArray", "", "T", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "luggage-commons-jsapi-connectivity-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final char[] rPi = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static final void a(com.tencent.mm.plugin.appbrand.jsapi.c<f> paramc, int paramInt, f paramf, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(144796);
    s.u(paramc, "<this>");
    s.u(paramf, "env");
    Log.d("MicroMsg.BLE.BleHelpExt", s.X("callbackSuccess: api = ", paramc.getClass().getSimpleName()));
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)paramHashMap).put("errCode", Integer.valueOf(0));
      paramf.callback(paramInt, paramc.a(null, a.e.rVt, (Map)paramHashMap));
      AppMethodBeat.o(144796);
      return;
    }
  }
  
  public static final boolean crp()
  {
    AppMethodBeat.i(144795);
    BluetoothAdapter localBluetoothAdapter = c.crs();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(144795);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isPeripheralBleSupported: isMultipleAdvertisementSupported = ").append(localBluetoothAdapter.isMultipleAdvertisementSupported()).append("\nisOffloadedFilteringSupported = ").append(localBluetoothAdapter.isOffloadedFilteringSupported()).append("\nisOffloadedScanBatchingSupported = ").append(localBluetoothAdapter.isOffloadedScanBatchingSupported()).append("\nbluetoothLeAdvertiser != null? = ");
    if (localBluetoothAdapter.getBluetoothLeAdvertiser() != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.BLE.BleHelpExt", bool + '\n');
      if (localBluetoothAdapter.getBluetoothLeAdvertiser() == null) {
        break;
      }
      AppMethodBeat.o(144795);
      return true;
    }
    AppMethodBeat.o(144795);
    return false;
  }
  
  public static final int crq()
  {
    AppMethodBeat.i(144799);
    int i = d.BG(System.currentTimeMillis()).qq(1, 2147483647);
    AppMethodBeat.o(144799);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */