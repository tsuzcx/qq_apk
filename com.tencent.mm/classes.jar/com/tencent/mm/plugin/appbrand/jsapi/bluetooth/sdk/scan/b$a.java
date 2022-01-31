package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.support.v4.f.m;
import java.util.List;

@TargetApi(18)
final class b$a
  implements b.e
{
  static final m<e, b.b> gnr = new m();
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    parame = (b.b)gnr.remove(parame);
    if (parame == null) {
      return false;
    }
    paramBluetoothAdapter.stopLeScan(parame);
    return true;
  }
  
  public final boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    paramScanSettingsCompat = (b.b)gnr.get(parame);
    if (paramScanSettingsCompat != null) {
      paramList = paramScanSettingsCompat;
    }
    for (;;)
    {
      return paramBluetoothAdapter.startLeScan(paramList);
      paramList = new b.b(paramList, parame);
      gnr.put(parame, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.a
 * JD-Core Version:    0.7.0.1
 */