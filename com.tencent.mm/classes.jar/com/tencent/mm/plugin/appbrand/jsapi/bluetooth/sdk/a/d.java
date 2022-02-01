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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class d
  implements e
{
  public String cLR;
  public final String cjP;
  public final Context context;
  volatile h jJl;
  volatile g jJm;
  public volatile b jJo;
  public volatile BluetoothGatt jJp;
  private List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> jJq;
  public volatile Map<String, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c>> jJr;
  private final c jJs;
  
  public d(Context paramContext, String paramString, c paramc)
  {
    AppMethodBeat.i(183544);
    this.cjP = ("MicroMsg.Ble.BleConnectWorker#" + hashCode());
    this.context = paramContext;
    this.cLR = paramString;
    this.jJs = paramc;
    AppMethodBeat.o(183544);
  }
  
  private b aYQ()
  {
    try
    {
      AppMethodBeat.i(193698);
      b localb2 = this.jJo;
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        localb1.init();
        this.jJo = localb1;
      }
      AppMethodBeat.o(193698);
      return localb1;
    }
    finally {}
  }
  
  private void am(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144560);
    h localh = this.jJl;
    if (localh == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cjP, "notifyConnectionStateChange, onBleConnectionStateChange is null", new Object[0]);
      AppMethodBeat.o(144560);
      return;
    }
    localh.al(paramString, paramBoolean);
    AppMethodBeat.o(144560);
  }
  
  private void fT(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(183545);
      BluetoothGatt localBluetoothGatt = this.jJp;
      if (localBluetoothGatt != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cjP, "deviceId:%s innerCloseMyself", new Object[] { this.cLR });
        if (paramBoolean) {
          am(this.cLR, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.jIN.jIZ) {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.a(localBluetoothGatt);
        }
        localBluetoothGatt.close();
        this.jJp = null;
      }
      AppMethodBeat.o(183545);
      return;
    }
    finally {}
  }
  
  public final BluetoothGatt aYP()
  {
    return this.jJp;
  }
  
  /* Error */
  public final void fS(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cjP	Ljava/lang/String;
    //   11: ldc 140
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cLR	Ljava/lang/String;
    //   23: aastore
    //   24: invokestatic 111	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: iload_1
    //   29: invokespecial 142	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:fT	(Z)V
    //   32: aload_0
    //   33: getfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJo	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +12 -> 50
    //   41: aload_2
    //   42: invokevirtual 145	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b:uninit	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJo	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   50: aload_0
    //   51: getfield 147	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJq	Ljava/util/List;
    //   54: ifnull +17 -> 71
    //   57: aload_0
    //   58: getfield 147	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJq	Ljava/util/List;
    //   61: invokeinterface 152 1 0
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 147	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJq	Ljava/util/List;
    //   71: aload_0
    //   72: getfield 154	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJr	Ljava/util/Map;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +14 -> 91
    //   80: aload_2
    //   81: invokeinterface 157 1 0
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 154	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJr	Ljava/util/Map;
    //   91: aload_0
    //   92: getfield 69	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:jJs	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;
    //   95: astore_2
    //   96: aload_0
    //   97: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:cLR	Ljava/lang/String;
    //   100: astore_3
    //   101: aload_2
    //   102: getfield 162	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:jJk	Ljava/util/Map;
    //   105: ifnonnull +22 -> 127
    //   108: ldc 164
    //   110: ldc 166
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 97	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: ldc 138
    //   121: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_0
    //   125: monitorexit
    //   126: return
    //   127: aload_2
    //   128: getfield 162	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:jJk	Ljava/util/Map;
    //   131: aload_3
    //   132: invokeinterface 170 2 0
    //   137: pop
    //   138: ldc 138
    //   140: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: goto -19 -> 124
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	d
    //   0	151	1	paramBoolean	boolean
    //   36	92	2	localObject1	Object
    //   146	4	2	localObject2	Object
    //   100	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	37	146	finally
    //   41	50	146	finally
    //   50	71	146	finally
    //   71	76	146	finally
    //   80	91	146	finally
    //   91	124	146	finally
    //   127	143	146	finally
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> getServices()
  {
    List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> localList = null;
    Object localObject2;
    label139:
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e locale;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(175630);
        localObject3 = this.jJp;
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cjP, "[getServices] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          return localList;
        }
        if (bt.isNullOrNil(this.cLR))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cjP, "[getServices] deviceId is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          continue;
        }
        if (this.jJq != null) {
          break label286;
        }
      }
      finally {}
      Object localObject3 = ((BluetoothGatt)localObject3).getServices();
      if (localObject3 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cjP, "[getServices] bluetoothGattServices is null, err", new Object[0]);
        AppMethodBeat.o(175630);
      }
      else
      {
        this.jJq = new ArrayList();
        localObject2 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject3).next();
          locale = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e();
          locale.uuid = localBluetoothGattService.getUuid().toString().toUpperCase();
          if (localBluetoothGattService.getType() != 0) {
            break label302;
          }
        }
      }
    }
    label286:
    label302:
    for (boolean bool = true;; bool = false)
    {
      locale.bnd = bool;
      if ((locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) || (locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")))
      {
        ((List)localObject2).add(locale);
        break label139;
      }
      this.jJq.add(locale);
      break label139;
      if (((List)localObject2).size() > 0) {
        this.jJq.addAll((Collection)localObject2);
      }
      for (;;)
      {
        localObject2 = this.jJq;
        AppMethodBeat.o(175630);
        break;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cjP, "[getServices] use cache", new Object[0]);
      }
    }
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(193696);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cjP, "init deviceId:%s", new Object[] { this.cLR });
      this.jJo = aYQ();
      this.jJr = new ConcurrentHashMap();
      AppMethodBeat.o(193696);
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
    String str2 = this.cjP;
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
      localObject = this.jJo;
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
    Object localObject = this.jJm;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cjP, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144564);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cjP, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((g)localObject).g(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144564);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144562);
    String str2 = this.cjP;
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { localObject, str1, f.rB(paramInt) });
      localObject = this.jJo;
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
    Object localObject = this.jJm;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cjP, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144562);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cjP, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((g)localObject).g(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144562);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144563);
    String str2 = this.cjP;
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { localObject1, str1, localObject2, f.rB(paramInt) });
      localObject1 = this.jJo;
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
    String str2 = this.cjP;
    Object localObject;
    String str3;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      str3 = f.rB(paramInt1);
      if (paramInt2 != 2) {
        break label94;
      }
    }
    label94:
    for (String str1 = "CONNECTED";; str1 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { localObject, str3, str1 });
      localObject = this.jJo;
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
      fS(true);
    }
    AppMethodBeat.o(144559);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144565);
    String str2 = this.cjP;
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
      localObject = this.jJo;
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
    String str2 = this.cjP;
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
      localObject = this.jJo;
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
    String str = this.cjP;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.rB(paramInt2) });
      localObject = this.jJo;
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
    String str = this.cjP;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.rB(paramInt2) });
      localObject = this.jJo;
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
    String str = this.cjP;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { localObject, f.rB(paramInt) });
      localObject = this.jJo;
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
    String str = this.cjP;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { localObject, f.rB(paramInt) });
      localObject = this.jJo;
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
      am(paramBluetoothGatt.getDevice().getAddress(), true);
    }
    AppMethodBeat.o(144561);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(193697);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cjP, "uninit deviceId:%s", new Object[] { this.cLR });
      fT(true);
      Object localObject1 = this.jJo;
      if (localObject1 != null)
      {
        ((b)localObject1).uninit();
        this.jJo = null;
      }
      if (this.jJq != null)
      {
        this.jJq.clear();
        this.jJq = null;
      }
      localObject1 = this.jJr;
      if (localObject1 != null)
      {
        ((Map)localObject1).clear();
        this.jJr = null;
      }
      AppMethodBeat.o(193697);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */