package com.tencent.mm.plugin.d.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static boolean aWc()
  {
    AppMethodBeat.i(18518);
    if (BluetoothAdapter.getDefaultAdapter() != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(18518);
      return bool;
    }
  }
  
  public static boolean aWe()
  {
    AppMethodBeat.i(18519);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(18519);
      return false;
    }
    boolean bool = localBluetoothAdapter.isEnabled();
    ab.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(18519);
    return bool;
  }
  
  public static boolean dA(Context paramContext)
  {
    AppMethodBeat.i(18517);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    ab.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(18517);
    return bool;
  }
  
  @Deprecated
  public static String hO(long paramLong)
  {
    AppMethodBeat.i(156899);
    String str = b.jw(paramLong);
    AppMethodBeat.o(156899);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.e.a
 * JD-Core Version:    0.7.0.1
 */