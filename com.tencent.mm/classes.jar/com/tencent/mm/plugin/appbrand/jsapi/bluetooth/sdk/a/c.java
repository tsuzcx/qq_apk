package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private final Context context;
  public Map<String, d> rMA;
  public volatile i rMB = null;
  public volatile h rMC = null;
  public volatile g rMD = null;
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> a(a parama)
  {
    AppMethodBeat.i(329732);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crr();
    if (localObject == null)
    {
      a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevicesSysImpl, bluetoothManager is null", new Object[0]);
      AppMethodBeat.o(329732);
      return localArrayList;
    }
    localObject = ((BluetoothManager)localObject).getConnectedDevices(7).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BluetoothDevice localBluetoothDevice = (BluetoothDevice)((Iterator)localObject).next();
      if (parama.crd()) {
        localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(localBluetoothDevice.getName(), localBluetoothDevice.getAddress()));
      }
    }
    AppMethodBeat.o(329732);
    return localArrayList;
  }
  
  private static boolean n(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(175629);
    String str;
    Iterator localIterator;
    do
    {
      paramList1 = paramList1.iterator();
      while (!localIterator.hasNext())
      {
        if (!paramList1.hasNext()) {
          break;
        }
        str = (String)paramList1.next();
        localIterator = paramList2.iterator();
      }
    } while (!Objects.equals(str, (String)localIterator.next()));
    AppMethodBeat.o(175629);
    return true;
    AppMethodBeat.o(175629);
    return false;
  }
  
  /* Error */
  public final d aap(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 128
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 130	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:rMA	Ljava/util/Map;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 57
    //   16: ldc 132
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 65	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aconst_null
    //   26: astore_2
    //   27: ldc 128
    //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: getfield 130	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:rMA	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 138 2 0
    //   46: checkcast 140	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: ifnonnull +65 -> 118
    //   56: new 140	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d
    //   59: dup
    //   60: aload_0
    //   61: getfield 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:context	Landroid/content/Context;
    //   64: aload_1
    //   65: aload_0
    //   66: invokespecial 143	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 146	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:init	()V
    //   74: aload_2
    //   75: new 6	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$1
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 149	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;)V
    //   83: putfield 150	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMC	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/h;
    //   86: aload_2
    //   87: new 8	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$2
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 151	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$2:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;)V
    //   95: putfield 152	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMB	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/i;
    //   98: aload_2
    //   99: aload_0
    //   100: getfield 35	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:rMD	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/g;
    //   103: putfield 153	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:rMD	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/g;
    //   106: aload_0
    //   107: getfield 130	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:rMA	Ljava/util/Map;
    //   110: aload_1
    //   111: aload_2
    //   112: invokeinterface 157 3 0
    //   117: pop
    //   118: ldc 128
    //   120: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -91 -> 32
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	c
    //   0	131	1	paramString	String
    //   26	86	2	localObject	Object
    //   49	4	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	25	126	finally
    //   27	32	126	finally
    //   36	50	126	finally
    //   56	118	126	finally
    //   118	123	126	finally
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> crc()
  {
    AppMethodBeat.i(329747);
    ArrayList localArrayList = new ArrayList();
    if (this.rMA == null)
    {
      a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
      AppMethodBeat.o(329747);
      return localArrayList;
    }
    Iterator localIterator = this.rMA.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      BluetoothGatt localBluetoothGatt = locald.rMH;
      if (localBluetoothGatt != null) {
        localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(Util.nullAsNil(localBluetoothGatt.getDevice().getName()), locald.hEl));
      }
    }
    AppMethodBeat.o(329747);
    return localArrayList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> dk(List<String> paramList)
  {
    AppMethodBeat.i(329756);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = crc();
      AppMethodBeat.o(329756);
      return paramList;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.rMA == null)
    {
      a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
      AppMethodBeat.o(329756);
      return localArrayList1;
    }
    Iterator localIterator = this.rMA.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      BluetoothGatt localBluetoothGatt = locald.rMH;
      if (localBluetoothGatt != null)
      {
        Object localObject = locald.crf();
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, services is empty", new Object[0]);
        }
        else
        {
          ArrayList localArrayList2 = new ArrayList(((List)localObject).size());
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            e locale = (e)((Iterator)localObject).next();
            if (locale.rNy) {
              localArrayList2.add(locale.uuid);
            }
          }
          if (n(paramList, localArrayList2)) {
            localArrayList1.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(Util.nullAsNil(localBluetoothGatt.getDevice().getName()), locald.hEl));
          }
        }
      }
    }
    AppMethodBeat.o(329756);
    return localArrayList1;
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(329734);
      a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (this.rMA == null) {
        this.rMA = new ConcurrentHashMap();
      }
      this.rMA.clear();
      AppMethodBeat.o(329734);
      return;
    }
    finally {}
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(329739);
      a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (this.rMA == null) {
        break label83;
      }
      Iterator localIterator = this.rMA.values().iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).uninit();
      }
      this.rMA.clear();
    }
    finally {}
    this.rMA = null;
    label83:
    this.rMB = null;
    this.rMC = null;
    this.rMD = null;
    AppMethodBeat.o(329739);
  }
  
  public static abstract interface a
  {
    public static final a rMF = new a()
    {
      public final boolean crd()
      {
        return true;
      }
    };
    
    public abstract boolean crd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */