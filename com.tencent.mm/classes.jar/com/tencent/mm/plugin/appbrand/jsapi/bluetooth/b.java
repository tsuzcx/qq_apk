package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

public final class b
  extends g.c
{
  private final String appId;
  private com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b jHE;
  volatile a jHF;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public static boolean aYH()
  {
    AppMethodBeat.i(144488);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZd();
    AppMethodBeat.o(144488);
    return bool;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    AppMethodBeat.i(144485);
    Object localObject = aYI();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).jJb.HU(paramString);
      if (localObject != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).cjP, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).cLR, parama });
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).jJo;
        if (paramString == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.jJH = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject);
        parama.a(paramString);
        parama.jJJ = paramb;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.jIU)
        {
          paramb = paramString.jJe;
          if (paramb == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramb.add(parama);
          paramString.aYO();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.jIS)
        {
          paramString.azU.postDelayed(new b.1(paramString, parama), parama.jJM);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> aYG()
  {
    AppMethodBeat.i(144484);
    Object localObject = aYI();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).jJb.aYG();
      AppMethodBeat.o(144484);
      return localObject;
    }
    AppMethodBeat.o(144484);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b aYI()
  {
    try
    {
      AppMethodBeat.i(193691);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.jHE;
      if (localb == null) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
      }
      AppMethodBeat.o(193691);
      return localb;
    }
    finally {}
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bm(List<String> paramList)
  {
    AppMethodBeat.i(175627);
    Object localObject1 = aYI();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).jJb;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).aYG();
        AppMethodBeat.o(175627);
        return paramList;
      }
      localObject1 = new ArrayList();
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).jJk == null) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(175627);
        return localObject1;
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).jJk.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((Iterator)localObject2).next();
          BluetoothGatt localBluetoothGatt = locald.jJp;
          if (localBluetoothGatt != null)
          {
            Object localObject3 = locald.getServices();
            if ((localObject3 == null) || (((List)localObject3).isEmpty()))
            {
              com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, services is empty", new Object[0]);
            }
            else
            {
              ArrayList localArrayList = new ArrayList(((List)localObject3).size());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                e locale = (e)((Iterator)localObject3).next();
                if (locale.bnd) {
                  localArrayList.add(locale.uuid);
                }
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.g(paramList, localArrayList)) {
                ((List)localObject1).add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bt.nullAsNil(localBluetoothGatt.getDevice().getName()), locald.cLR));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(175627);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    Object localObject1 = aYI();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).jJb;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).jJk == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).jJk.get(paramString1);
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).jJp;
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (bt.isNullOrNil(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] serviceId is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.HX(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Map localMap = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).jJr;
      if (localMap == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      paramString1 = (List)localMap.get(paramString2);
      if (paramString1 == null)
      {
        paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
        if (paramString1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        localObject2 = paramString1.getCharacteristics();
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] characteristics is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        paramString1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)((Iterator)localObject2).next();
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
          localc.uuid = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
          int i = localBluetoothGattCharacteristic.getProperties();
          localc.jJR = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.rE(i);
          localc.jJS = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.rF(i);
          localc.jJT = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.rG(i);
          localc.gMR = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.rH(i);
          localc.jJU = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.rI(i);
          paramString1.add(localc);
        }
        localMap.put(paramString2, paramString1);
      }
      while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).jJp == null)
      {
        AppMethodBeat.o(144487);
        return null;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cjP, "[getCharacteristics] use cache", new Object[0]);
      }
      AppMethodBeat.o(144487);
      return paramString1;
    }
    AppMethodBeat.o(144487);
    return null;
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(193690);
      this.jHE = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(aj.getContext());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.jHE;
      localb.jJb.init();
      localb.jJc.init();
      AppMethodBeat.o(193690);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144489);
    a.HT(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(144490);
      if (this.jHE != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.jHE;
        localb.jJb.uninit();
        localb.jJc.uninit();
        this.jHE = null;
      }
      AppMethodBeat.o(144490);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void fQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */