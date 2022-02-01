package com.tencent.mm.plugin.d.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static boolean bBE()
  {
    AppMethodBeat.i(22629);
    if (BluetoothAdapter.getDefaultAdapter() != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(22629);
      return bool;
    }
  }
  
  public static boolean bBG()
  {
    AppMethodBeat.i(22630);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      AppMethodBeat.o(22630);
      return false;
    }
    boolean bool = localBluetoothAdapter.isEnabled();
    ad.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22630);
    return bool;
  }
  
  public static boolean eh(Context paramContext)
  {
    AppMethodBeat.i(22628);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    ad.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(22628);
    return bool;
  }
  
  @Deprecated
  public static String ny(long paramLong)
  {
    AppMethodBeat.i(204844);
    String str = b.pe(paramLong);
    AppMethodBeat.o(204844);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.e.a
 * JD-Core Version:    0.7.0.1
 */