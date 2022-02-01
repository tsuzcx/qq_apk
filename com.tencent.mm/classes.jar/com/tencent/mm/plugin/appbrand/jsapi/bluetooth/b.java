package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  extends h.c
{
  private String appId;
  public com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b kGl;
  a kGm;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public static boolean bjQ()
  {
    AppMethodBeat.i(144488);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki();
    AppMethodBeat.o(144488);
    return bool;
  }
  
  public final List<e> Qd(String paramString)
  {
    AppMethodBeat.i(144486);
    if (this.kGl != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.kGl;
      if (localb.kHP != null)
      {
        paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localb.kHP.kHX.get(paramString);
        if (paramString == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
          AppMethodBeat.o(144486);
          return null;
        }
        paramString = paramString.getServices();
        AppMethodBeat.o(144486);
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleManager", "getServices, bleConnectMgr is null", new Object[0]);
      AppMethodBeat.o(144486);
      return null;
    }
    AppMethodBeat.o(144486);
    return null;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    AppMethodBeat.i(144485);
    if (this.kGl != null)
    {
      Object localObject1 = this.kGl;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP;
        Object localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localc.kHX.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d(localc.context, paramString, localc);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "init deviceId:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cVh });
          if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb == null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b();
            localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb;
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).kHS = new ConcurrentLinkedQueue();
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).kHU = new ArrayList();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb;
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIe = new ConcurrentHashMap();
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kHZ = new c.1(localc);
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kHY = new c.2(localc);
          localc.kHX.put(paramString, localObject1);
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cVh, parama });
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.kIw = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1);
        parama.a(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb);
        parama.kIy = paramb;
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIb;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.kHI)
        {
          if (paramString.kHS == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramString.kHS.add(parama);
          paramString.bjX();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.kHG)
        {
          paramString.aCF.postDelayed(new b.1(paramString, parama), parama.kIB);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bjP()
  {
    AppMethodBeat.i(144484);
    if (this.kGl != null)
    {
      Object localObject = this.kGl;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).kHP != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).kHP.bjP();
        AppMethodBeat.o(144484);
        return localObject;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleManager", "getConnectedBleDevices, bleConnectMgr is null", new Object[0]);
      AppMethodBeat.o(144484);
      return null;
    }
    AppMethodBeat.o(144484);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bo(List<String> paramList)
  {
    AppMethodBeat.i(175627);
    if (this.kGl != null)
    {
      Object localObject1 = this.kGl;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP;
        if ((paramList == null) || (paramList.isEmpty()))
        {
          paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).bjP();
          AppMethodBeat.o(175627);
          return paramList;
        }
        localObject1 = new ArrayList();
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kHX.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((Iterator)localObject2).next();
          if (locald.kIc != null)
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
                if (locale.kIO) {
                  localArrayList.add(locale.uuid);
                }
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.g(paramList, localArrayList)) {
                ((List)localObject1).add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bu.nullAsNil(locald.kIc.getDevice().getName()), locald.cVh));
              }
            }
          }
        }
        AppMethodBeat.o(175627);
        return localObject1;
      }
      ae.w("MicroMsg.Ble.BleManager", "getConnectedBleDevices, bleConnectMgr is null");
      AppMethodBeat.o(175627);
      return null;
    }
    ae.w("MicroMsg.ble.BleWorker", "getConnectedBleDevices, bleManager is null");
    AppMethodBeat.o(175627);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> cX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    if (this.kGl != null)
    {
      Object localObject1 = this.kGl;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP.kHX.get(paramString1);
        if (localObject1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIc;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (bu.isNullOrNil(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] serviceId is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Qg(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIe == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        paramString1 = (List)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIe.get(paramString2);
        if (paramString1 == null)
        {
          paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
          if (paramString1 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
            AppMethodBeat.o(144487);
            return null;
          }
          localObject2 = paramString1.getCharacteristics();
          if (localObject2 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] characteristics is null, err", new Object[0]);
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
            localc.kIG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sY(i);
            localc.kIH = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sZ(i);
            localc.kII = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ta(i);
            localc.hIB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.tb(i);
            localc.kIJ = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.tc(i);
            paramString1.add(localc);
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIe.put(paramString2, paramString1);
        }
        while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kIc == null)
        {
          AppMethodBeat.o(144487);
          return null;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crG, "[getCharacteristics] use cache", new Object[0]);
        }
        AppMethodBeat.o(144487);
        return paramString1;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleManager", "getCharacteristics, bleConnectMgr is null", new Object[0]);
      AppMethodBeat.o(144487);
      return null;
    }
    AppMethodBeat.o(144487);
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144489);
    a.Qc(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc;
    try
    {
      AppMethodBeat.i(144490);
      if (this.kGl == null) {
        break label257;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.kGl;
      if (localb.kHP == null) {
        break label109;
      }
      localc = localb.kHP;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (localc.kHX == null) {
        break label109;
      }
      Iterator localIterator = localc.kHX.values().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localIterator.next()).uninit();
      }
      localc.kHX.clear();
    }
    finally {}
    localc.kHX = null;
    label109:
    if (localObject.kHQ != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a locala = localObject.kHQ;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(locala.crG, "uninit", new Object[0]);
      locala.bka();
      locala.dfX.set(false);
      if (locala.kge != null) {
        locala.kge.clear();
      }
      if (locala.kJm != null) {
        locala.kJm.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkg() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkg().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkg().cancelDiscovery();
      }
      if ((locala.kGi != null) && (locala.context != null))
      {
        ae.i(locala.crG, "bluetoothStateListener uninit");
        locala.context.unregisterReceiver(locala.kGi);
        locala.kGi = null;
      }
      locala.kJk = null;
      locala.context = null;
    }
    this.kGl = null;
    label257:
    AppMethodBeat.o(144490);
  }
  
  public static abstract interface a
  {
    public abstract void gq(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */