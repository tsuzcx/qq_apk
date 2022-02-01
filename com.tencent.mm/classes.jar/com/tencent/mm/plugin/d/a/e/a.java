package com.tencent.mm.plugin.d.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static boolean bNN()
  {
    AppMethodBeat.i(22629);
    if (BluetoothAdapter.getDefaultAdapter() != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(22629);
      return bool;
    }
  }
  
  public static boolean bNP()
  {
    AppMethodBeat.i(22630);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(22630);
      return false;
    }
    boolean bool = localBluetoothAdapter.isEnabled();
    ae.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22630);
    return bool;
  }
  
  public static boolean et(Context paramContext)
  {
    AppMethodBeat.i(22628);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    ae.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22628);
    return bool;
  }
  
  @Deprecated
  public static String tw(long paramLong)
  {
    AppMethodBeat.i(224180);
    String str = b.vf(paramLong);
    AppMethodBeat.o(224180);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.e.a
 * JD-Core Version:    0.7.0.1
 */