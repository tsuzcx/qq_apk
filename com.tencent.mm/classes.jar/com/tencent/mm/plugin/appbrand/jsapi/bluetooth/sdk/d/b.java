package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.j.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"HEX", "", "TAG", "", "byteArrayToHexString", "bytes", "", "getRandomId", "", "isPeripheralBleSupported", "", "callbackFail", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "env", "errCode", "errMsg", "callbackSuccess", "params", "Ljava/util/HashMap;", "", "toArray", "", "T", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b
{
  private static final char[] oLo = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static final void a(com.tencent.mm.plugin.appbrand.jsapi.c<e> paramc, int paramInt1, e parame, int paramInt2, String paramString)
  {
    AppMethodBeat.i(144798);
    p.k(paramc, "$this$callbackFail");
    p.k(parame, "env");
    p.k(paramString, "errMsg");
    Log.d("MicroMsg.BLE.BleHelpExt", "callbackFail: api = %s, reason = %s", new Object[] { paramc.getClass().getSimpleName(), paramString });
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("errCode", Integer.valueOf(paramInt2));
    parame.j(paramInt1, paramc.m(paramString, (Map)localHashMap));
    AppMethodBeat.o(144798);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.jsapi.c<e> paramc, int paramInt, e parame, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(144796);
    p.k(paramc, "$this$callbackSuccess");
    p.k(parame, "env");
    Log.d("MicroMsg.BLE.BleHelpExt", "callbackSuccess: api = " + paramc.getClass().getSimpleName());
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)paramHashMap).put("errCode", Integer.valueOf(0));
      parame.j(paramInt, paramc.m("ok", (Map)paramHashMap));
      AppMethodBeat.o(144796);
      return;
    }
  }
  
  public static final boolean bRh()
  {
    boolean bool2 = true;
    AppMethodBeat.i(144795);
    aa.a locala = new aa.a();
    BluetoothAdapter localBluetoothAdapter = c.bRk();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(144795);
      return false;
    }
    p.j(localBluetoothAdapter, "getBleAdapter() ?: return false");
    StringBuilder localStringBuilder = new StringBuilder("isPeripheralBleSupported: isMultipleAdvertisementSupported = ").append(localBluetoothAdapter.isMultipleAdvertisementSupported()).append('\n').append("isOffloadedFilteringSupported = ").append(localBluetoothAdapter.isOffloadedFilteringSupported()).append('\n').append("isOffloadedScanBatchingSupported = ").append(localBluetoothAdapter.isOffloadedScanBatchingSupported()).append('\n').append("bluetoothLeAdvertiser != null? = ");
    if (localBluetoothAdapter.getBluetoothLeAdvertiser() != null)
    {
      bool1 = true;
      Log.d("MicroMsg.BLE.BleHelpExt", bool1 + '\n');
      if (localBluetoothAdapter.getBluetoothLeAdvertiser() == null) {
        break label157;
      }
    }
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.aaBx = bool1;
      bool1 = locala.aaBx;
      AppMethodBeat.o(144795);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final int bRi()
  {
    AppMethodBeat.i(144799);
    int i = d.Xv(System.currentTimeMillis()).os(1, 2147483647);
    AppMethodBeat.o(144799);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */