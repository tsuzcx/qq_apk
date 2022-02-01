package com.tencent.mm.plugin.d.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  @Deprecated
  public static String BC(long paramLong)
  {
    AppMethodBeat.i(258232);
    String str = b.Dj(paramLong);
    AppMethodBeat.o(258232);
    return str;
  }
  
  public static boolean ckN()
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
  
  public static boolean ckP()
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
  
  public static boolean eL(Context paramContext)
  {
    AppMethodBeat.i(22628);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22628);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.e.a
 * JD-Core Version:    0.7.0.1
 */