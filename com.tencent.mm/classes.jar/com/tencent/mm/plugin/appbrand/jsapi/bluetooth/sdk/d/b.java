package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.v.a;
import d.j.d;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"HEX", "", "TAG", "", "byteArrayToHexString", "bytes", "", "getRandomId", "", "isPeripheralBleSupported", "", "callbackFail", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "env", "errCode", "errMsg", "callbackSuccess", "params", "Ljava/util/HashMap;", "", "toArray", "", "T", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b
{
  private static final char[] klZ = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static final void a(a<com.tencent.mm.plugin.appbrand.jsapi.c> parama, int paramInt1, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt2, String paramString)
  {
    AppMethodBeat.i(144798);
    k.h(parama, "$this$callbackFail");
    k.h(paramc, "env");
    k.h(paramString, "errMsg");
    ac.d("MicroMsg.BLE.BleHelpExt", "callbackFail: api = %s, reason = %s", new Object[] { parama.getClass().getSimpleName(), paramString });
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("errCode", Integer.valueOf(paramInt2));
    paramc.h(paramInt1, parama.k(paramString, (Map)localHashMap));
    AppMethodBeat.o(144798);
  }
  
  public static final void a(a<com.tencent.mm.plugin.appbrand.jsapi.c> parama, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.c paramc, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(144796);
    k.h(parama, "$this$callbackSuccess");
    k.h(paramc, "env");
    ac.d("MicroMsg.BLE.BleHelpExt", "callbackSuccess: api = " + parama.getClass().getSimpleName());
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)paramHashMap).put("errCode", Integer.valueOf(0));
      paramc.h(paramInt, parama.k("ok", (Map)paramHashMap));
      AppMethodBeat.o(144796);
      return;
    }
  }
  
  public static final boolean bfQ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(144795);
    v.a locala = new v.a();
    BluetoothAdapter localBluetoothAdapter = c.bfT();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(144795);
      return false;
    }
    k.g(localBluetoothAdapter, "getBleAdapter() ?: return false");
    StringBuilder localStringBuilder = new StringBuilder("isPeripheralBleSupported: isMultipleAdvertisementSupported = ").append(localBluetoothAdapter.isMultipleAdvertisementSupported()).append('\n').append("isOffloadedFilteringSupported = ").append(localBluetoothAdapter.isOffloadedFilteringSupported()).append('\n').append("isOffloadedScanBatchingSupported = ").append(localBluetoothAdapter.isOffloadedScanBatchingSupported()).append('\n').append("bluetoothLeAdvertiser != null? = ");
    if (localBluetoothAdapter.getBluetoothLeAdvertiser() != null)
    {
      bool1 = true;
      ac.d("MicroMsg.BLE.BleHelpExt", bool1 + '\n');
      if (localBluetoothAdapter.getBluetoothLeAdvertiser() == null) {
        break label157;
      }
    }
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.KUL = bool1;
      bool1 = locala.KUL;
      AppMethodBeat.o(144795);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final int bfR()
  {
    AppMethodBeat.i(144799);
    int i = d.Cq(System.currentTimeMillis()).nextInt(1, 2147483647);
    AppMethodBeat.o(144799);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */