package com.tencent.mm.plugin.g.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static boolean daZ()
  {
    AppMethodBeat.i(22629);
    if (BluetoothAdapter.getDefaultAdapter() != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(22629);
      return bool;
    }
  }
  
  public static boolean dbb()
  {
    AppMethodBeat.i(22630);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(22630);
      return false;
    }
    boolean bool = localBluetoothAdapter.isEnabled();
    Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22630);
    return bool;
  }
  
  public static boolean fL(Context paramContext)
  {
    AppMethodBeat.i(22628);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22628);
    return bool;
  }
  
  @Deprecated
  public static String kg(long paramLong)
  {
    AppMethodBeat.i(369736);
    String str = b.lO(paramLong);
    AppMethodBeat.o(369736);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.e.a
 * JD-Core Version:    0.7.0.1
 */