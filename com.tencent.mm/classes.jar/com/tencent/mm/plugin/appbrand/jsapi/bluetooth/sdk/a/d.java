package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

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
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class d
  implements e
{
  public final Context context;
  public final String exO;
  public String hEl;
  volatile i rMB;
  volatile h rMC;
  volatile g rMD;
  public volatile b rMG;
  public volatile BluetoothGatt rMH;
  private List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> rMI;
  public volatile Map<String, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c>> rMJ;
  private final c rMK;
  public volatile int rML;
  
  public d(Context paramContext, String paramString, c paramc)
  {
    AppMethodBeat.i(183544);
    this.exO = ("MicroMsg.Ble.BleConnectWorker#" + hashCode());
    this.rMB = null;
    this.rMC = null;
    this.rMD = null;
    this.rML = -1;
    this.context = paramContext;
    this.hEl = paramString;
    this.rMK = paramc;
    AppMethodBeat.o(183544);
  }
  
  private void aD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144560);
    i locali = this.rMB;
    if (locali == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "notifyConnectionStateChange, onBleConnectionStateChange is null", new Object[0]);
      AppMethodBeat.o(144560);
      return;
    }
    locali.aC(paramString, paramBoolean);
    AppMethodBeat.o(144560);
  }
  
  private b cre()
  {
    try
    {
      AppMethodBeat.i(329737);
      b localb2 = this.rMG;
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        localb1.init();
        this.rMG = localb1;
      }
      AppMethodBeat.o(329737);
      return localb1;
    }
    finally {}
  }
  
  private void ji(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(183545);
      BluetoothGatt localBluetoothGatt = this.rMH;
      if (localBluetoothGatt != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "deviceId:%s innerCloseMyself", new Object[] { this.hEl });
        if (paramBoolean) {
          aD(this.hEl, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMm)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "deviceId:%s refreshGattCache", new Object[] { this.hEl });
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.c(this.rMH);
        }
        localBluetoothGatt.close();
        this.rMH = null;
      }
      AppMethodBeat.o(183545);
      return;
    }
    finally {}
  }
  
  public final void a(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(329782);
    if (paramBluetoothGatt == null)
    {
      AppMethodBeat.o(329782);
      return;
    }
    if (paramInt == 0) {
      aD(paramBluetoothGatt.getDevice().getAddress(), true);
    }
    AppMethodBeat.o(329782);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> crf()
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
        localObject2 = this.rMH;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.exO, "[getServices] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          return localList;
        }
        if (Util.isNullOrNil(this.hEl))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.exO, "[getServices] deviceId is null, err", new Object[0]);
          AppMethodBeat.o(175630);
          continue;
        }
        if (this.rMI != null) {
          break label293;
        }
      }
      finally {}
      Object localObject2 = ((BluetoothGatt)localObject2).getServices();
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "[getServices] bluetoothGattServices is null, err", new Object[0]);
        AppMethodBeat.o(175630);
      }
      else
      {
        this.rMI = new ArrayList();
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
      locale.rNy = bool;
      if ((locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) || (locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")))
      {
        localArrayList.add(locale);
        break label139;
      }
      this.rMI.add(locale);
      break label139;
      if (localArrayList.size() > 0) {
        this.rMI.addAll(localArrayList);
      }
      for (;;)
      {
        localArrayList = new ArrayList(this.rMI);
        AppMethodBeat.o(175630);
        break;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "[getServices] use cache", new Object[0]);
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> crg()
  {
    List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> localList = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(329774);
        localObject2 = this.rMH;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.exO, "[getServicesNoCache] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(329774);
          return localList;
        }
        if (Util.isNullOrNil(this.hEl))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.exO, "[getServicesNoCache] deviceId is null, err", new Object[0]);
          AppMethodBeat.o(329774);
          continue;
        }
        localObject2 = ((BluetoothGatt)localObject2).getServices();
      }
      finally {}
      if (localObject2 != null) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "[getServicesNoCache] bluetoothGattServices is null, err", new Object[0]);
      AppMethodBeat.o(329774);
    }
    this.rMI = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    label133:
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e locale;
    if (((Iterator)localObject2).hasNext())
    {
      BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
      locale = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e();
      locale.uuid = localBluetoothGattService.getUuid().toString().toUpperCase();
      if (localBluetoothGattService.getType() != 0) {
        break label287;
      }
    }
    label287:
    for (boolean bool = true;; bool = false)
    {
      locale.rNy = bool;
      if ((locale.uuid.equals("00001800-0000-1000-8000-00805F9B34FB")) || (locale.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")))
      {
        localArrayList.add(locale);
        break label133;
      }
      this.rMI.add(locale);
      break label133;
      if (localArrayList.size() > 0) {
        this.rMI.addAll(localArrayList);
      }
      localArrayList = new ArrayList(this.rMI);
      AppMethodBeat.o(329774);
      break;
    }
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(329748);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "init deviceId:%s", new Object[] { this.hEl });
      this.rMG = cre();
      this.rMJ = new ConcurrentHashMap();
      AppMethodBeat.o(329748);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void jh(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 268
    //   5: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 64	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:exO	Ljava/lang/String;
    //   12: ldc_w 270
    //   15: iconst_1
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield 76	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:hEl	Ljava/lang/String;
    //   25: aastore
    //   26: invokestatic 118	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: iload_1
    //   31: invokespecial 272	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:ji	(Z)V
    //   34: aload_0
    //   35: getfield 103	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMG	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +12 -> 52
    //   43: aload_2
    //   44: invokevirtual 275	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b:uninit	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 103	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMG	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/b;
    //   52: aload_0
    //   53: getfield 173	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMI	Ljava/util/List;
    //   56: ifnull +17 -> 73
    //   59: aload_0
    //   60: getfield 173	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMI	Ljava/util/List;
    //   63: invokeinterface 278 1 0
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 173	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMI	Ljava/util/List;
    //   73: aload_0
    //   74: getfield 266	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMJ	Ljava/util/Map;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +14 -> 93
    //   82: aload_2
    //   83: invokeinterface 281 1 0
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 266	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMJ	Ljava/util/Map;
    //   93: aload_0
    //   94: getfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMK	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 76	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:hEl	Ljava/lang/String;
    //   102: astore_3
    //   103: aload_2
    //   104: getfield 286	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:rMA	Ljava/util/Map;
    //   107: ifnonnull +25 -> 132
    //   110: ldc_w 288
    //   113: ldc_w 290
    //   116: iconst_0
    //   117: anewarray 4	java/lang/Object
    //   120: invokestatic 93	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc_w 268
    //   126: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: monitorexit
    //   131: return
    //   132: aload_2
    //   133: getfield 286	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:rMA	Ljava/util/Map;
    //   136: aload_3
    //   137: invokeinterface 294 2 0
    //   142: pop
    //   143: ldc_w 268
    //   146: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: goto -20 -> 129
    //   152: astore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	d
    //   0	157	1	paramBoolean	boolean
    //   38	95	2	localObject1	Object
    //   152	4	2	localObject2	Object
    //   102	35	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	39	152	finally
    //   43	52	152	finally
    //   52	73	152	finally
    //   73	78	152	finally
    //   82	93	152	finally
    //   93	129	152	finally
    //   132	149	152	finally
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144564);
    String str2 = this.exO;
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
      localObject = this.rMG;
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
    Object localObject = this.rMC;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144564);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((h)localObject).i(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144564);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144562);
    String str2 = this.exO;
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { localObject, str1, f.Ay(paramInt) });
      localObject = this.rMG;
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
    Object localObject = this.rMC;
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "[change] onBleCharacteristicValueChange is null", new Object[0]);
      AppMethodBeat.o(144562);
      return;
    }
    str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
    paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
    str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
    ((h)localObject).i(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    AppMethodBeat.o(144562);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144563);
    String str2 = this.exO;
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { localObject1, str1, localObject2, f.Ay(paramInt) });
      localObject1 = this.rMG;
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
    String str2 = this.exO;
    Object localObject;
    String str3;
    if (paramBluetoothGatt != null)
    {
      localObject = paramBluetoothGatt.getDevice().getAddress();
      str3 = f.Ay(paramInt1);
      if (paramInt2 != 2) {
        break label94;
      }
    }
    label94:
    for (String str1 = "CONNECTED";; str1 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str2, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { localObject, str3, str1 });
      localObject = this.rMG;
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
      jh(true);
    }
    AppMethodBeat.o(144559);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144565);
    String str2 = this.exO;
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
      localObject = this.rMG;
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
    String str2 = this.exO;
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
      localObject = this.rMG;
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
    Object localObject2 = this.exO;
    if (paramBluetoothGatt != null) {}
    for (Object localObject1 = paramBluetoothGatt.getDevice().getAddress();; localObject1 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i((String)localObject2, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { localObject1, Integer.valueOf(paramInt1), f.Ay(paramInt2) });
      if (paramBluetoothGatt != null) {
        break;
      }
      AppMethodBeat.o(144569);
      return;
    }
    if (paramInt2 == 0)
    {
      this.rML = paramInt1;
      localObject1 = paramBluetoothGatt.getDevice().getAddress();
      localObject2 = this.rMD;
      if (localObject2 != null) {
        ((g)localObject2).cE((String)localObject1, paramInt1);
      }
    }
    localObject1 = this.rMG;
    if (localObject1 == null)
    {
      AppMethodBeat.o(144569);
      return;
    }
    ((b)localObject1).onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    AppMethodBeat.o(144569);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144568);
    String str = this.exO;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { localObject, Integer.valueOf(paramInt1), f.Ay(paramInt2) });
      localObject = this.rMG;
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
    String str = this.exO;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { localObject, f.Ay(paramInt) });
      localObject = this.rMG;
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
    String str = this.exO;
    if (paramBluetoothGatt != null) {}
    for (Object localObject = paramBluetoothGatt.getDevice().getAddress();; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { localObject, f.Ay(paramInt) });
      localObject = this.rMG;
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
      AppMethodBeat.i(329754);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "uninit deviceId:%s", new Object[] { this.hEl });
      ji(true);
      Object localObject1 = this.rMG;
      if (localObject1 != null)
      {
        ((b)localObject1).uninit();
        this.rMG = null;
      }
      if (this.rMI != null)
      {
        this.rMI.clear();
        this.rMI = null;
      }
      localObject1 = this.rMJ;
      if (localObject1 != null)
      {
        ((Map)localObject1).clear();
        this.rMJ = null;
      }
      this.rMB = null;
      this.rMC = null;
      this.rMD = null;
      AppMethodBeat.o(329754);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */