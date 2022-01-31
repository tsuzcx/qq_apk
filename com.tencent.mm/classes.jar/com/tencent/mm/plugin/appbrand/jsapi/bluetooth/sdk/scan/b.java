package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

@TargetApi(18)
public final class b
{
  static final b.e hHo;
  
  static
  {
    AppMethodBeat.i(94306);
    int i = Build.VERSION.SDK_INT;
    if (!a.hFZ)
    {
      ab.i("MicroMsg.ble.BleScannerCompat", "use 18");
      hHo = new b.a();
      AppMethodBeat.o(94306);
      return;
    }
    if (i >= 21)
    {
      ab.i("MicroMsg.ble.BleScannerCompat", "use 21");
      hHo = new b.c();
      AppMethodBeat.o(94306);
      return;
    }
    ab.i("MicroMsg.ble.BleScannerCompat", "use 18");
    hHo = new b.a();
    AppMethodBeat.o(94306);
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    AppMethodBeat.i(94305);
    boolean bool = hHo.a(paramBluetoothAdapter, parame);
    AppMethodBeat.o(94305);
    return bool;
  }
  
  public static boolean a(BluetoothAdapter paramBluetoothAdapter, List<ScanFilterCompat> paramList, ScanSettingsCompat paramScanSettingsCompat, e parame)
  {
    AppMethodBeat.i(94304);
    boolean bool = hHo.a(paramBluetoothAdapter, paramList, paramScanSettingsCompat, parame);
    AppMethodBeat.o(94304);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b
 * JD-Core Version:    0.7.0.1
 */