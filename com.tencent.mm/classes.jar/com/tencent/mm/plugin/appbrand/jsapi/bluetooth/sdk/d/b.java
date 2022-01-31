package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Method;
import java.util.UUID;

public final class b
{
  public static boolean BX(String paramString)
  {
    AppMethodBeat.i(94347);
    if (android.support.v4.content.b.checkSelfPermission(ah.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(94347);
      return true;
    }
    AppMethodBeat.o(94347);
    return false;
  }
  
  public static boolean BY(String paramString)
  {
    AppMethodBeat.i(94349);
    try
    {
      UUID.fromString(paramString);
      AppMethodBeat.o(94349);
      return true;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(94349);
    }
    return false;
  }
  
  @TargetApi(18)
  public static boolean a(BluetoothGatt paramBluetoothGatt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(94350);
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
      AppMethodBeat.o(94350);
      return bool1;
      label61:
      bool1 = false;
    }
  }
  
  private static BluetoothManager aCu()
  {
    try
    {
      AppMethodBeat.i(94345);
      BluetoothManager localBluetoothManager = (BluetoothManager)ah.getContext().getSystemService("bluetooth");
      AppMethodBeat.o(94345);
      return localBluetoothManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"MissingPermission", "NewApi"})
  public static BluetoothAdapter aCv()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 91
    //   5: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 93	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/b:aCu	()Landroid/bluetooth/BluetoothManager;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull +18 -> 31
    //   16: aload_0
    //   17: invokevirtual 96	android/bluetooth/BluetoothManager:getAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   20: astore_0
    //   21: ldc 91
    //   23: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: ldc 98
    //   33: ldc 100
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 106	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aconst_null
    //   43: astore_0
    //   44: ldc 91
    //   46: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aCw()
  {
    AppMethodBeat.i(94348);
    if (aCv() == null)
    {
      AppMethodBeat.o(94348);
      return false;
    }
    boolean bool = aCv().isEnabled();
    AppMethodBeat.o(94348);
    return bool;
  }
  
  public static boolean nW(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static boolean nX(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean nY(int paramInt)
  {
    return (paramInt & 0x4) > 0;
  }
  
  public static boolean nZ(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public static boolean oa(int paramInt)
  {
    return (paramInt & 0x20) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */