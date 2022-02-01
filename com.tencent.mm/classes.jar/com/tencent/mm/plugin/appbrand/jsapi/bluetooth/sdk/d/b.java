package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"HEX", "", "TAG", "", "byteArrayToHexString", "bytes", "", "getRandomId", "", "isPeripheralBleSupported", "", "callbackFail", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "env", "errCode", "errMsg", "callbackSuccess", "params", "Ljava/util/HashMap;", "", "toArray", "", "T", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b
{
  private static final char[] lOU = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static final void a(com.tencent.mm.plugin.appbrand.jsapi.d<f> paramd, int paramInt1, f paramf, int paramInt2, String paramString)
  {
    AppMethodBeat.i(144798);
    p.h(paramd, "$this$callbackFail");
    p.h(paramf, "env");
    p.h(paramString, "errMsg");
    Log.d("MicroMsg.BLE.BleHelpExt", "callbackFail: api = %s, reason = %s", new Object[] { paramd.getClass().getSimpleName(), paramString });
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("errCode", Integer.valueOf(paramInt2));
    paramf.i(paramInt1, paramd.n(paramString, (Map)localHashMap));
    AppMethodBeat.o(144798);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.jsapi.d<f> paramd, int paramInt, f paramf, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(144796);
    p.h(paramd, "$this$callbackSuccess");
    p.h(paramf, "env");
    Log.d("MicroMsg.BLE.BleHelpExt", "callbackSuccess: api = " + paramd.getClass().getSimpleName());
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    for (;;)
    {
      ((Map)paramHashMap).put("errCode", Integer.valueOf(0));
      paramf.i(paramInt, paramd.n("ok", (Map)paramHashMap));
      AppMethodBeat.o(144796);
      return;
    }
  }
  
  public static final int bFA()
  {
    AppMethodBeat.i(144799);
    int i = kotlin.j.d.Pf(System.currentTimeMillis()).nextInt(1, 2147483647);
    AppMethodBeat.o(144799);
    return i;
  }
  
  public static final boolean bFz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(144795);
    z.a locala = new z.a();
    BluetoothAdapter localBluetoothAdapter = c.bFC();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(144795);
      return false;
    }
    p.g(localBluetoothAdapter, "getBleAdapter() ?: return false");
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
      locala.SYB = bool1;
      bool1 = locala.SYB;
      AppMethodBeat.o(144795);
      return bool1;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */