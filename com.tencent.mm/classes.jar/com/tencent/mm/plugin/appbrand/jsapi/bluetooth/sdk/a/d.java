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
  public final String cED;
  public final Context context;
  public String fzB;
  volatile h oIR;
  volatile g oIS;
  public volatile b oIV;
  public volatile BluetoothGatt oIW;
  private List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> oIX;
  public volatile Map<String, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c>> oIY;
  private final c oIZ;
  
  public d(Context paramContext, String paramString, c paramc)
  {
    AppMethodBeat.i(183544);
    this.cED = ("MicroMsg.Ble.BleConnectWorker#" + hashCode());
    this.context = paramContext;
    this.fzB = paramString;
    this.oIZ = paramc;
    AppMethodBeat.o(183544);
  }
  
  private void as(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144560);
    h localh = this.oIR;
    if (localh == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "notifyConnectionStateChange, onBleConnectionStateChange is null", new Object[0]);
      AppMethodBeat.o(144560);
      return;
    }
    localh.ar(paramString, paramBoolean);
    AppMethodBeat.o(144560);
  }
  
  private b bQW()
  {
    try
    {
      AppMethodBeat.i(199803);
      b localb2 = this.oIV;
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        localb1.init();
        this.oIV = localb1;
      }
      AppMethodBeat.o(199803);
      return localb1;
    }
    finally {}
  }
  
  private void ii(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(183545);
      BluetoothGatt localBluetoothGatt = this.oIW;
      if (localBluetoothGatt != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "deviceId:%s innerCloseMyself", new Object[] { this.fzB });
        if (paramBoolean) {
          as(this.fzB, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oID)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "deviceId:%s refreshGattCache", new Object[] { this.fzB });
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.a(this.oIW);
        }
        localBluetoothGatt.close();
        this.oIW = null;
      }
      AppMethodBeat.o(183545);
      return;
    }
    finally {}
  }
  
  public final void a(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(292881);
    if (paramBluetoothGatt == null)
    {
      AppMethodBeat.o(292881);
      return;
    }
    if (paramInt == 0) {
      as(paramBluetoothGatt.getDevice().getAddress(), true);
    }
    AppMethodBeat.o(292881);
  }
  
  public final BluetoothGatt bQV()
  {
    return this.oIW;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> bQX()
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
        localObject2 = this.oIW;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cED, "[getServices] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          return localList;
        }
        if (Util.isNullOrNil(this.fzB))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cED, "[getServices] deviceId is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          continue;
        }
        if (this.oIX != null) {
          break label293;
        }
      }
      finally {}
      Object localObject2 = ((BluetoothGatt)localObject2).getServices();
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "[getServices] bluetoothGattServices is null, err", new Object[0]);
        AppMethodBeat.o(175630);
      }
      else
      {
        this.oIX = new ArrayList();
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
      locale.oJH = bool;
      if ((locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) || (locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")))
      {
        localArrayList.add(locale);
        break label139;
      }
      this.oIX.add(locale);
      break label139;
      if (localArrayList.size() > 0) {
        this.oIX.addAll(localArrayList);
      }
      for (;;)
      {
        localArrayList = new ArrayList(this.oIX);
        AppMethodBeat.o(175630);
        break;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "[getServices] use cache", new Object[0]);
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> bQY()
  {
    List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> localList = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(199831);
        localObject2 = this.oIW;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cED, "[getServicesNoCache] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(199831);
          return localList;
        }
        if (Util.isNullOrNil(this.fzB))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cED, "[getServicesNoCache] deviceId is null, err", new Object[0]);
          AppMethodBeat.o(199831);
          continue;
        }
        localObject2 = ((BluetoothGatt)localObject2).getServices();
      }
      finally {}
      if (localObject2 != null) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "[getServicesNoCache] bluetoothGattServices is null, err", new Object[0]);
      AppMethodBeat.o(199831);
    }
    this.oIX = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    label132:
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e locale;
    if (((Iterator)localObject2).hasNext())
    {
      BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
      locale = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e();
      locale.uuid = localBluetoothGattService.getUuid().toString().toUpperCase();
      if (localBluetoothGattService.getType() != 0) {
        break label286;
      }
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      locale.oJH = bool;
      if ((locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) || (locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")))
      {
        localArrayList.add(locale);
        break label132;
      }
      this.oIX.add(locale);
      break label132;
      if (localArrayList.size() > 0) {
        this.oIX.addAll(localArrayList);
      }
      localArrayList = new ArrayList(this.oIX);
      AppMethodBeat.o(199831);
      break;
    }
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  /* Error */
  public final void ih(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 254
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cED	Ljava/lang/String;
    //   11: ldc_w 256
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:fzB	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 111	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: iload_1
    //   30: invokespecial 258	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:ii	(Z)V
    //   33: aload_0
    //   34: getfield 96	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIV	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +12 -> 51
    //   42: aload_2
    //   43: invokevirtual 261	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b:uninit	()V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIV	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   51: aload_0
    //   52: getfield 167	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIX	Ljava/util/List;
    //   55: ifnull +17 -> 72
    //   58: aload_0
    //   59: getfield 167	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIX	Ljava/util/List;
    //   62: invokeinterface 264 1 0
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 167	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIX	Ljava/util/List;
    //   72: aload_0
    //   73: getfield 266	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIY	Ljava/util/Map;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +14 -> 92
    //   81: aload_2
    //   82: invokeinterface 269 1 0
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 266	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIY	Ljava/util/Map;
    //   92: aload_0
    //   93: getfield 69	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIZ	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:fzB	Ljava/lang/String;
    //   101: astore_3
    //   102: aload_2
    //   103: getfield 274	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:oIQ	Ljava/util/Map;
    //   106: ifnonnull +24 -> 130
    //   109: ldc_w 276
    //   112: ldc_w 278
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 86	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: ldc 254
    //   124: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_2
    //   131: getfield 274	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:oIQ	Ljava/util/Map;
    //   134: aload_3
    //   135: invokeinterface 282 2 0
    //   140: pop
    //   141: ldc 254
    //   143: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: goto -19 -> 127
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	d
    //   0	154	1	paramBoolean	boolean
    //   37	94	2	localObject1	Object
    //   149	4	2	localObject2	Object
    //   101	34	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	38	149	finally
    //   42	51	149	finally
    //   51	72	149	finally
    //   72	77	149	finally
    //   81	92	149	finally
    //   92	127	149	finally
    //   130	146	149	finally
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(199792);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "init deviceId:%s", new Object[] { this.fzB });
      this.oIV = bQW();
      this.oIY = new ConcurrentHashMap();
      AppMethodBeat.o(199792);
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
    String str2 = this.cED;
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
      localObject = this.oIV;
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
    Object localObject = this.oIS;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144564);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((g)localObject).j(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144564);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144562);
    String str2 = this.cED;
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { localObject, str1, f.Ah(paramInt) });
      localObject = this.oIV;
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
    Object localObject = this.oIS;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144562);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((g)localObject).j(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144562);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144563);
    String str2 = this.cED;
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { localObject1, str1, localObject2, f.Ah(paramInt) });
      localObject1 = this.oIV;
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
    String str2 = this.cED;
    Object localObject;
    String str3;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      str3 = f.Ah(paramInt1);
      if (paramInt2 != 2) {
        break label94;
      }
    }
    label94:
    for (String str1 = "CONNECTED";; str1 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { localObject, str3, str1 });
      localObject = this.oIV;
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
      ih(true);
    }
    AppMethodBeat.o(144559);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144565);
    String str2 = this.cED;
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
      localObject = this.oIV;
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
    String str2 = this.cED;
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
      localObject = this.oIV;
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
    String str = this.cED;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.Ah(paramInt2) });
      localObject = this.oIV;
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
    String str = this.cED;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.Ah(paramInt2) });
      localObject = this.oIV;
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
    String str = this.cED;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { localObject, f.Ah(paramInt) });
      localObject = this.oIV;
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
    String str = this.cED;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { localObject, f.Ah(paramInt) });
      localObject = this.oIV;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(144561);
      return;
    }
    ((b)localObject).onServicesDiscovered(paramBluetoothGatt, paramInt);
    AppMethodBeat.o(144561);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(199799);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "uninit deviceId:%s", new Object[] { this.fzB });
      ii(true);
      Object localObject1 = this.oIV;
      if (localObject1 != null)
      {
        ((b)localObject1).uninit();
        this.oIV = null;
      }
      if (this.oIX != null)
      {
        this.oIX.clear();
        this.oIX = null;
      }
      localObject1 = this.oIY;
      if (localObject1 != null)
      {
        ((Map)localObject1).clear();
        this.oIY = null;
      }
      AppMethodBeat.o(199799);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */