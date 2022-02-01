package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public final class d
  implements e
{
  public String cVh;
  public Context context;
  public final String crG;
  public h kHY;
  public g kHZ;
  public b kIb;
  public BluetoothGatt kIc;
  private List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> kId;
  public Map<String, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c>> kIe;
  private final c kIf;
  
  public d(Context paramContext, String paramString, c paramc)
  {
    AppMethodBeat.i(183544);
    this.crG = ("MicroMsg.Ble.BleConnectWorker#" + hashCode());
    this.context = paramContext;
    this.cVh = paramString;
    this.kIf = paramc;
    AppMethodBeat.o(183544);
  }
  
  private void ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144560);
    if (this.kHY != null) {
      this.kHY.an(paramString, paramBoolean);
    }
    AppMethodBeat.o(144560);
  }
  
  private void gt(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(183545);
      if (this.kIc != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "deviceId:%s innerCloseMyself", new Object[] { this.cVh });
        if (paramBoolean) {
          ao(this.cVh, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.kHN) {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.a(this.kIc);
        }
        this.kIc.close();
        this.kIc = null;
      }
      AppMethodBeat.o(183545);
      return;
    }
    finally {}
  }
  
  public final BluetoothGatt bjY()
  {
    return this.kIc;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> getServices()
  {
    AppMethodBeat.i(175630);
    if (this.kIc == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.crG, "[getServices] bluetoothGatt is null, err", new Object[0]);
      AppMethodBeat.o(175630);
      return null;
    }
    if (bu.isNullOrNil(this.cVh))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.crG, "[getServices] deviceId is null, err", new Object[0]);
      AppMethodBeat.o(175630);
      return null;
    }
    Object localObject1;
    if (this.kId == null)
    {
      Object localObject2 = this.kIc.getServices();
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crG, "[getServices] bluetoothGattServices is null, err", new Object[0]);
        AppMethodBeat.o(175630);
        return null;
      }
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e locale = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e();
        locale.uuid = localBluetoothGattService.getUuid().toString().toUpperCase();
        if (localBluetoothGattService.getType() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          locale.kIO = bool;
          if ((!locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) && (!locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB"))) {
            break label234;
          }
          localArrayList.add(locale);
          break;
        }
        label234:
        ((List)localObject1).add(locale);
      }
      if (localArrayList.size() > 0) {
        ((List)localObject1).addAll(localArrayList);
      }
      this.kId = ((List)localObject1);
    }
    for (;;)
    {
      localObject1 = this.kId;
      AppMethodBeat.o(175630);
      return localObject1;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "[getServices] use cache", new Object[0]);
    }
  }
  
  /* Error */
  public final void gs(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 216
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:crG	Ljava/lang/String;
    //   11: ldc 218
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cVh	Ljava/lang/String;
    //   23: aastore
    //   24: invokestatic 95	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: iload_1
    //   29: invokespecial 220	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:gt	(Z)V
    //   32: aload_0
    //   33: getfield 222	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIb	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   36: ifnull +15 -> 51
    //   39: aload_0
    //   40: getfield 222	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIb	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   43: invokevirtual 227	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b:uninit	()V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 222	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIb	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   51: aload_0
    //   52: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kId	Ljava/util/List;
    //   55: ifnull +17 -> 72
    //   58: aload_0
    //   59: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kId	Ljava/util/List;
    //   62: invokeinterface 230 1 0
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 140	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kId	Ljava/util/List;
    //   72: aload_0
    //   73: getfield 232	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIe	Ljava/util/Map;
    //   76: ifnull +17 -> 93
    //   79: aload_0
    //   80: getfield 232	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIe	Ljava/util/Map;
    //   83: invokeinterface 235 1 0
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 232	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIe	Ljava/util/Map;
    //   93: aload_0
    //   94: getfield 69	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:kIf	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cVh	Ljava/lang/String;
    //   102: astore_3
    //   103: aload_2
    //   104: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:kHX	Ljava/util/Map;
    //   107: ifnonnull +22 -> 129
    //   110: ldc 242
    //   112: ldc 244
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 147	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: ldc 216
    //   123: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: aload_2
    //   130: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:kHX	Ljava/util/Map;
    //   133: aload_3
    //   134: invokeinterface 248 2 0
    //   139: pop
    //   140: ldc 216
    //   142: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: goto -19 -> 126
    //   148: astore_2
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	d
    //   0	153	1	paramBoolean	boolean
    //   97	33	2	localc	c
    //   148	4	2	localObject	Object
    //   102	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	51	148	finally
    //   51	72	148	finally
    //   72	93	148	finally
    //   93	126	148	finally
    //   129	145	148	finally
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144564);
    String str3 = this.crG;
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label184;
      }
    }
    label184:
    for (String str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str3, "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", new Object[] { str1, str2 });
      this.kIb.onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
      if (this.kHZ != null)
      {
        str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
        paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
        str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
        this.kHZ.h(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
      }
      AppMethodBeat.o(144564);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144562);
    String str3 = this.crG;
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label197;
      }
    }
    label197:
    for (String str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str3, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { str1, str2, f.sV(paramInt) });
      this.kIb.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
      if (paramInt == 0)
      {
        str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
        paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
        str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
        this.kHZ.h(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
      }
      AppMethodBeat.o(144562);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144563);
    String str3 = this.crG;
    String str1;
    String str2;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label120;
      }
      str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      label41:
      if (paramBluetoothGattCharacteristic == null) {
        break label128;
      }
    }
    label128:
    for (Object localObject = Arrays.asList(new byte[][] { paramBluetoothGattCharacteristic.getValue() });; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str3, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { str1, str2, localObject, f.sV(paramInt) });
      this.kIb.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
      AppMethodBeat.o(144563);
      return;
      str1 = "";
      break;
      label120:
      str2 = "";
      break label41;
    }
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144559);
    String str3 = this.crG;
    String str1;
    String str4;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      str4 = f.sV(paramInt1);
      if (paramInt2 != 2) {
        break label111;
      }
    }
    label111:
    for (String str2 = "CONNECTED";; str2 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str3, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { str1, str4, str2 });
      this.kIb.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
      if ((paramInt1 != 0) || ((paramInt2 != 2) && (paramInt2 == 0))) {
        gs(true);
      }
      AppMethodBeat.o(144559);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144565);
    String str3 = this.crG;
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label88;
      }
    }
    label88:
    for (String str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str3, "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
      this.kIb.onDescriptorRead(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
      AppMethodBeat.o(144565);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144566);
    String str3 = this.crG;
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label88;
      }
    }
    label88:
    for (String str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str3, "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
      this.kIb.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
      AppMethodBeat.o(144566);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144569);
    String str2 = this.crG;
    if (paramBluetoothGatt != null) {}
    for (String str1 = paramBluetoothGatt.getDevice().getAddress();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { str1, Integer.valueOf(paramInt1), f.sV(paramInt2) });
      this.kIb.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
      AppMethodBeat.o(144569);
      return;
    }
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144568);
    String str2 = this.crG;
    if (paramBluetoothGatt != null) {}
    for (String str1 = paramBluetoothGatt.getDevice().getAddress();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { str1, Integer.valueOf(paramInt1), f.sV(paramInt2) });
      this.kIb.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
      AppMethodBeat.o(144568);
      return;
    }
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144567);
    String str2 = this.crG;
    if (paramBluetoothGatt != null) {}
    for (String str1 = paramBluetoothGatt.getDevice().getAddress();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { str1, f.sV(paramInt) });
      this.kIb.onReliableWriteCompleted(paramBluetoothGatt, paramInt);
      AppMethodBeat.o(144567);
      return;
    }
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144561);
    String str2 = this.crG;
    if (paramBluetoothGatt != null) {}
    for (String str1 = paramBluetoothGatt.getDevice().getAddress();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { str1, f.sV(paramInt) });
      this.kIb.onServicesDiscovered(paramBluetoothGatt, paramInt);
      if (paramInt == 0) {
        ao(paramBluetoothGatt.getDevice().getAddress(), true);
      }
      AppMethodBeat.o(144561);
      return;
    }
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(208352);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "uninit deviceId:%s", new Object[] { this.cVh });
      gt(true);
      if (this.kIb != null)
      {
        this.kIb.uninit();
        this.kIb = null;
      }
      if (this.kId != null)
      {
        this.kId.clear();
        this.kId = null;
      }
      if (this.kIe != null)
      {
        this.kIe.clear();
        this.kIe = null;
      }
      AppMethodBeat.o(208352);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */