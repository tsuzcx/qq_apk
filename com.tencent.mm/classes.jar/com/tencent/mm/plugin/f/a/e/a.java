package com.tencent.mm.plugin.f.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static boolean awB()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null) {
      return false;
    }
    boolean bool = localBluetoothAdapter.isEnabled();
    y.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean awz()
  {
    if (BluetoothAdapter.getDefaultAdapter() != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @Deprecated
  public static String cM(long paramLong)
  {
    return b.ee(paramLong);
  }
  
  public static boolean cP(Context paramContext)
  {
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    y.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.e.a
 * JD-Core Version:    0.7.0.1
 */