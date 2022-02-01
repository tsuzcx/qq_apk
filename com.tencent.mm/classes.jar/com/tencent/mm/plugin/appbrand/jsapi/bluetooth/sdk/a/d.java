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
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class d
  implements e
{
  public final String cDW;
  public final Context context;
  public String dGL;
  volatile h lMB;
  volatile g lMC;
  public volatile b lMF;
  public volatile BluetoothGatt lMG;
  private List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> lMH;
  public volatile Map<String, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c>> lMI;
  private final c lMJ;
  
  public d(Context paramContext, String paramString, c paramc)
  {
    AppMethodBeat.i(183544);
    this.cDW = ("MicroMsg.Ble.BleConnectWorker#" + hashCode());
    this.context = paramContext;
    this.dGL = paramString;
    this.lMJ = paramc;
    AppMethodBeat.o(183544);
  }
  
  private void aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144560);
    h localh = this.lMB;
    if (localh == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "notifyConnectionStateChange, onBleConnectionStateChange is null", new Object[0]);
      AppMethodBeat.o(144560);
      return;
    }
    localh.ap(paramString, paramBoolean);
    AppMethodBeat.o(144560);
  }
  
  private b bFs()
  {
    try
    {
      AppMethodBeat.i(215156);
      b localb2 = this.lMF;
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        localb1.init();
        this.lMF = localb1;
      }
      AppMethodBeat.o(215156);
      return localb1;
    }
    finally {}
  }
  
  private void hr(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(183545);
      BluetoothGatt localBluetoothGatt = this.lMG;
      if (localBluetoothGatt != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "deviceId:%s innerCloseMyself", new Object[] { this.dGL });
        if (paramBoolean) {
          aq(this.dGL, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMo) {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.a(this.lMG);
        }
        localBluetoothGatt.close();
        this.lMG = null;
      }
      AppMethodBeat.o(183545);
      return;
    }
    finally {}
  }
  
  public final BluetoothGatt bFr()
  {
    return this.lMG;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> getServices()
  {
    List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> localList = null;
    ArrayList localArrayList;
    label139:
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e locale;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(175630);
        localObject2 = this.lMG;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cDW, "[getServices] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          return localList;
        }
        if (Util.isNullOrNil(this.dGL))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cDW, "[getServices] deviceId is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          continue;
        }
        if (this.lMH != null) {
          break label293;
        }
      }
      finally {}
      Object localObject2 = ((BluetoothGatt)localObject2).getServices();
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "[getServices] bluetoothGattServices is null, err", new Object[0]);
        AppMethodBeat.o(175630);
      }
      else
      {
        this.lMH = new ArrayList();
        localArrayList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
          locale = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e();
          locale.uuid = localBluetoothGattService.getUuid().toString().toUpperCase();
          if (localBluetoothGattService.getType() != 0) {
            break label309;
          }
        }
      }
    }
    label293:
    label309:
    for (boolean bool = true;; bool = false)
    {
      locale.lNt = bool;
      if ((locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) || (locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")))
      {
        localArrayList.add(locale);
        break label139;
      }
      this.lMH.add(locale);
      break label139;
      if (localArrayList.size() > 0) {
        this.lMH.addAll(localArrayList);
      }
      for (;;)
      {
        localArrayList = new ArrayList(this.lMH);
        AppMethodBeat.o(175630);
        break;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "[getServices] use cache", new Object[0]);
      }
    }
  }
  
  /* Error */
  public final void hq(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cDW	Ljava/lang/String;
    //   11: ldc 234
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:dGL	Ljava/lang/String;
    //   23: aastore
    //   24: invokestatic 111	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: iload_1
    //   29: invokespecial 236	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:hr	(Z)V
    //   32: aload_0
    //   33: getfield 96	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMF	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +12 -> 50
    //   41: aload_2
    //   42: invokevirtual 239	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b:uninit	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMF	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   50: aload_0
    //   51: getfield 156	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMH	Ljava/util/List;
    //   54: ifnull +17 -> 71
    //   57: aload_0
    //   58: getfield 156	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMH	Ljava/util/List;
    //   61: invokeinterface 242 1 0
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 156	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMH	Ljava/util/List;
    //   71: aload_0
    //   72: getfield 244	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMI	Ljava/util/Map;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +14 -> 91
    //   80: aload_2
    //   81: invokeinterface 247 1 0
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 244	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMI	Ljava/util/Map;
    //   91: aload_0
    //   92: getfield 69	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:lMJ	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;
    //   95: astore_2
    //   96: aload_0
    //   97: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:dGL	Ljava/lang/String;
    //   100: astore_3
    //   101: aload_2
    //   102: getfield 252	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:lMA	Ljava/util/Map;
    //   105: ifnonnull +23 -> 128
    //   108: ldc 254
    //   110: ldc_w 256
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 86	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: ldc 232
    //   122: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: aload_2
    //   129: getfield 252	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:lMA	Ljava/util/Map;
    //   132: aload_3
    //   133: invokeinterface 260 2 0
    //   138: pop
    //   139: ldc 232
    //   141: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: goto -19 -> 125
    //   147: astore_2
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_2
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	d
    //   0	152	1	paramBoolean	boolean
    //   36	93	2	localObject1	Object
    //   147	4	2	localObject2	Object
    //   100	33	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	37	147	finally
    //   41	50	147	finally
    //   50	71	147	finally
    //   71	76	147	finally
    //   80	91	147	finally
    //   91	125	147	finally
    //   128	144	147	finally
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(215154);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "init deviceId:%s", new Object[] { this.dGL });
      this.lMF = bFs();
      this.lMI = new ConcurrentHashMap();
      AppMethodBeat.o(215154);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144564);
    String str2 = this.cDW;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label84;
      }
    }
    label84:
    for (String str1 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", new Object[] { localObject, str1 });
      localObject = this.lMF;
      if (localObject != null) {
        break label92;
      }
      AppMethodBeat.o(144564);
      return;
      localObject = "";
      break;
    }
    label92:
    ((b)localObject).onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
    if ((paramBluetoothGatt == null) || (paramBluetoothGattCharacteristic == null))
    {
      AppMethodBeat.o(144564);
      return;
    }
    Object localObject = this.lMC;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144564);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((g)localObject).g(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144564);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144562);
    String str2 = this.cDW;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label96;
      }
    }
    label96:
    for (String str1 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { localObject, str1, f.wR(paramInt) });
      localObject = this.lMF;
      if (localObject != null) {
        break label104;
      }
      AppMethodBeat.o(144562);
      return;
      localObject = "";
      break;
    }
    label104:
    ((b)localObject).onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    if ((paramBluetoothGatt == null) || (paramBluetoothGattCharacteristic == null))
    {
      AppMethodBeat.o(144562);
      return;
    }
    if (paramInt != 0)
    {
      AppMethodBeat.o(144562);
      return;
    }
    Object localObject = this.lMC;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144562);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((g)localObject).g(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144562);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144563);
    String str2 = this.cDW;
    Object localObject1;
    String str1;
    if (paramBluetoothGatt != null)
    {
      localObject1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label121;
      }
      str1 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      label41:
      if (paramBluetoothGattCharacteristic == null) {
        break label129;
      }
    }
    label129:
    for (Object localObject2 = Arrays.asList(new byte[][] { paramBluetoothGattCharacteristic.getValue() });; localObject2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { localObject1, str1, localObject2, f.wR(paramInt) });
      localObject1 = this.lMF;
      if (localObject1 != null) {
        break label137;
      }
      AppMethodBeat.o(144563);
      return;
      localObject1 = "";
      break;
      label121:
      str1 = "";
      break label41;
    }
    label137:
    ((b)localObject1).onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    AppMethodBeat.o(144563);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144559);
    String str2 = this.cDW;
    Object localObject;
    String str3;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      str3 = f.wR(paramInt1);
      if (paramInt2 != 2) {
        break label94;
      }
    }
    label94:
    for (String str1 = "CONNECTED";; str1 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { localObject, str3, str1 });
      localObject = this.lMF;
      if (localObject != null) {
        break label102;
      }
      AppMethodBeat.o(144559);
      return;
      localObject = "";
      break;
    }
    label102:
    ((b)localObject).onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    if ((paramInt1 != 0) || ((paramInt2 != 2) && (paramInt2 == 0))) {
      hq(true);
    }
    AppMethodBeat.o(144559);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144565);
    String str2 = this.cDW;
    Object localObject;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label89;
      }
    }
    label89:
    for (String str1 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", new Object[] { localObject, str1 });
      localObject = this.lMF;
      if (localObject != null) {
        break label97;
      }
      AppMethodBeat.o(144565);
      return;
      localObject = "";
      break;
    }
    label97:
    ((b)localObject).onDescriptorRead(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    AppMethodBeat.o(144565);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144566);
    String str2 = this.cDW;
    Object localObject;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label89;
      }
    }
    label89:
    for (String str1 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", new Object[] { localObject, str1 });
      localObject = this.lMF;
      if (localObject != null) {
        break label97;
      }
      AppMethodBeat.o(144566);
      return;
      localObject = "";
      break;
    }
    label97:
    ((b)localObject).onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    AppMethodBeat.o(144566);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144569);
    String str = this.cDW;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.wR(paramInt2) });
      localObject = this.lMF;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(144569);
      return;
    }
    ((b)localObject).onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    AppMethodBeat.o(144569);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144568);
    String str = this.cDW;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.wR(paramInt2) });
      localObject = this.lMF;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(144568);
      return;
    }
    ((b)localObject).onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
    AppMethodBeat.o(144568);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144567);
    String str = this.cDW;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { localObject, f.wR(paramInt) });
      localObject = this.lMF;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(144567);
      return;
    }
    ((b)localObject).onReliableWriteCompleted(paramBluetoothGatt, paramInt);
    AppMethodBeat.o(144567);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144561);
    String str = this.cDW;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { localObject, f.wR(paramInt) });
      localObject = this.lMF;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(144561);
      return;
    }
    ((b)localObject).onServicesDiscovered(paramBluetoothGatt, paramInt);
    if (paramBluetoothGatt == null)
    {
      AppMethodBeat.o(144561);
      return;
    }
    if (paramInt == 0) {
      aq(paramBluetoothGatt.getDevice().getAddress(), true);
    }
    AppMethodBeat.o(144561);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(215155);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "uninit deviceId:%s", new Object[] { this.dGL });
      hr(true);
      Object localObject1 = this.lMF;
      if (localObject1 != null)
      {
        ((b)localObject1).uninit();
        this.lMF = null;
      }
      if (this.lMH != null)
      {
        this.lMH.clear();
        this.lMH = null;
      }
      localObject1 = this.lMI;
      if (localObject1 != null)
      {
        ((Map)localObject1).clear();
        this.lMI = null;
      }
      AppMethodBeat.o(215155);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */