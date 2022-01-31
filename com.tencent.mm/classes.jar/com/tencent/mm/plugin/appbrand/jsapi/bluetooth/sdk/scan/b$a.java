package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.support.v4.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@TargetApi(18)
final class b$a
  implements b.e
{
  static final m<e, b.b> hHp;
  
  static
  {
    AppMethodBeat.i(94294);
    hHp = new m();
    AppMethodBeat.o(94294);
  }
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    AppMethodBeat.i(94293);
    parame = (b.b)hHp.remove(parame);
    if (parame == null)
    {
      AppMethodBeat.o(94293);
      return false;
    }
    paramBluetoothAdapter.stopLeScan(parame);
    AppMethodBeat.o(94293);
    return true;
  }
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    AppMethodBeat.i(94292);
    paramScanSettingsCompat = (b.b)hHp.get(parame);
    if (paramScanSettingsCompat != null) {
      paramList = paramScanSettingsCompat;
    }
    for (;;)
    {
      boolean bool = paramBluetoothAdapter.startLeScan(paramList);
      AppMethodBeat.o(94292);
      return bool;
      paramList = new b.b(paramList, parame);
      hHp.put(parame, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.a
 * JD-Core Version:    0.7.0.1
 */