package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

@TargetApi(18)
public final class b
{
  static final b.e gnq = new b.a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (!a.gma)
    {
      y.i("MicroMsg.ble.BleScannerCompat", "use 18");
      gnq = new b.a();
      return;
    }
    if (i >= 21)
    {
      y.i("MicroMsg.ble.BleScannerCompat", "use 21");
      gnq = new b.c();
      return;
    }
    y.i("MicroMsg.ble.BleScannerCompat", "use 18");
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    return gnq.a(paramBluetoothAdapter, parame);
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    return gnq.a(paramBluetoothAdapter, paramList, paramScanSettingsCompat, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b
 * JD-Core Version:    0.7.0.1
 */