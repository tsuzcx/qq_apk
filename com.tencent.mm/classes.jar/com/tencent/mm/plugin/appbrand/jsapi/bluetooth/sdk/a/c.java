package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class c
{
  private final Context context;
  public Map<String, d> oIQ;
  public volatile h oIR;
  public volatile g oIS;
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bQU()
  {
    AppMethodBeat.i(199259);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRj();
    if (localObject == null)
    {
      a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevicesSysImpl, bluetoothManager is null", new Object[0]);
      AppMethodBeat.o(199259);
      return localArrayList;
    }
    localObject = ((BluetoothManager)localObject).getConnectedDevices(7).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BluetoothDevice localBluetoothDevice = (BluetoothDevice)((Iterator)localObject).next();
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(localBluetoothDevice.getName(), localBluetoothDevice.getAddress()));
    }
    AppMethodBeat.o(199259);
    return localArrayList;
  }
  
  private static boolean j(List<String> paramList1, List<String> paramList2)
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
  public final d ahs(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 123	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:oIQ	Ljava/util/Map;
    //   11: ifnonnull +25 -> 36
    //   14: ldc 53
    //   16: ldc 125
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 61	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/d/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aconst_null
    //   26: astore_2
    //   27: ldc 121
    //   29: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: getfield 123	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:oIQ	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 131 2 0
    //   46: checkcast 133	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: ifnonnull +57 -> 110
    //   56: new 133	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d
    //   59: dup
    //   60: aload_0
    //   61: getfield 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:context	Landroid/content/Context;
    //   64: aload_1
    //   65: aload_0
    //   66: invokespecial 136	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 139	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:init	()V
    //   74: aload_2
    //   75: new 6	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$1
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 142	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;)V
    //   83: putfield 144	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIS	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/g;
    //   86: aload_2
    //   87: new 8	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$2
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 145	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c$2:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c;)V
    //   95: putfield 147	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/d:oIR	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/h;
    //   98: aload_0
    //   99: getfield 123	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/a/c:oIQ	Ljava/util/Map;
    //   102: aload_1
    //   103: aload_2
    //   104: invokeinterface 151 3 0
    //   109: pop
    //   110: ldc 121
    //   112: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -83 -> 32
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	c
    //   0	123	1	paramString	String
    //   26	78	2	localObject	Object
    //   49	4	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	25	118	finally
    //   27	32	118	finally
    //   36	50	118	finally
    //   56	110	118	finally
    //   110	115	118	finally
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bQT()
  {
    AppMethodBeat.i(199251);
    ArrayList localArrayList = new ArrayList();
    if (this.oIQ == null)
    {
      a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
      AppMethodBeat.o(199251);
      return localArrayList;
    }
    Iterator localIterator = this.oIQ.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      BluetoothGatt localBluetoothGatt = locald.oIW;
      if (localBluetoothGatt != null) {
        localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(Util.nullAsNil(localBluetoothGatt.getDevice().getName()), locald.fzB));
      }
    }
    AppMethodBeat.o(199251);
    return localArrayList;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bz(List<String> paramList)
  {
    AppMethodBeat.i(199255);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = bQT();
      AppMethodBeat.o(199255);
      return paramList;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.oIQ == null)
    {
      a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
      AppMethodBeat.o(199255);
      return localArrayList1;
    }
    Iterator localIterator = this.oIQ.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      BluetoothGatt localBluetoothGatt = locald.oIW;
      if (localBluetoothGatt != null)
      {
        Object localObject = locald.bQX();
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
            if (locale.oJH) {
              localArrayList2.add(locale.uuid);
            }
          }
          if (j(paramList, localArrayList2)) {
            localArrayList1.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(Util.nullAsNil(localBluetoothGatt.getDevice().getName()), locald.fzB));
          }
        }
      }
    }
    AppMethodBeat.o(199255);
    return localArrayList1;
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(199242);
      a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (this.oIQ == null) {
        this.oIQ = new ConcurrentHashMap();
      }
      this.oIQ.clear();
      AppMethodBeat.o(199242);
      return;
    }
    finally {}
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(199248);
      a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (this.oIQ == null) {
        break label83;
      }
      Iterator localIterator = this.oIQ.values().iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).uninit();
      }
      this.oIQ.clear();
    }
    finally {}
    this.oIQ = null;
    label83:
    AppMethodBeat.o(199248);
  }
  
  public static abstract interface a
  {
    public static final a oIU = new a() {};
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */