package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;
import java.util.UUID;

public final class c
{
  public static boolean AB(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static boolean AC(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean AD(int paramInt)
  {
    return (paramInt & 0x4) > 0;
  }
  
  public static boolean AE(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public static boolean AF(int paramInt)
  {
    return (paramInt & 0x20) > 0;
  }
  
  public static boolean HC(String paramString)
  {
    AppMethodBeat.i(144660);
    if (androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(144660);
      return true;
    }
    AppMethodBeat.o(144660);
    return false;
  }
  
  public static byte[] aW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183548);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      a.e("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
      AppMethodBeat.o(183548);
      return new byte[0];
    }
    AppMethodBeat.o(183548);
    return paramArrayOfByte;
  }
  
  public static boolean aar(String paramString)
  {
    AppMethodBeat.i(144663);
    try
    {
      UUID.fromString(paramString);
      AppMethodBeat.o(144663);
      return true;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(144663);
    }
    return false;
  }
  
  public static boolean c(BluetoothGatt paramBluetoothGatt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(144665);
    if (paramBluetoothGatt != null) {}
    for (;;)
    {
      try
      {
        Method localMethod = BluetoothGatt.class.getMethod("refresh", new Class[0]);
        if (localMethod == null) {
          break label61;
        }
        localMethod.setAccessible(true);
        boolean bool2 = ((Boolean)localMethod.invoke(paramBluetoothGatt, new Object[0])).booleanValue();
        bool1 = bool2;
      }
      catch (Exception paramBluetoothGatt)
      {
        continue;
      }
      AppMethodBeat.o(144665);
      return bool1;
      label61:
      bool1 = false;
    }
  }
  
  public static BluetoothManager crr()
  {
    try
    {
      AppMethodBeat.i(144657);
      BluetoothManager localBluetoothManager = (BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth");
      AppMethodBeat.o(144657);
      return localBluetoothManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static BluetoothAdapter crs()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 103
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 105	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/c:crr	()Landroid/bluetooth/BluetoothManager;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull +18 -> 31
    //   16: aload_0
    //   17: invokevirtual 108	android/bluetooth/BluetoothManager:getAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   20: astore_0
    //   21: ldc 103
    //   23: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: ldc 40
    //   33: ldc 110
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 48	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aconst_null
    //   43: astore_0
    //   44: ldc 103
    //   46: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -23 -> 26
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	33	0	localObject1	Object
    //   52	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	52	finally
    //   16	26	52	finally
    //   31	42	52	finally
    //   44	49	52	finally
  }
  
  public static boolean crt()
  {
    AppMethodBeat.i(144659);
    if ((!d.rc(18)) && (crv()))
    {
      AppMethodBeat.o(144659);
      return true;
    }
    AppMethodBeat.o(144659);
    return false;
  }
  
  public static boolean cru()
  {
    AppMethodBeat.i(144661);
    if (crs() == null)
    {
      AppMethodBeat.o(144661);
      return false;
    }
    boolean bool = crs().isEnabled();
    AppMethodBeat.o(144661);
    return bool;
  }
  
  private static boolean crv()
  {
    AppMethodBeat.i(144662);
    boolean bool = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(144662);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */