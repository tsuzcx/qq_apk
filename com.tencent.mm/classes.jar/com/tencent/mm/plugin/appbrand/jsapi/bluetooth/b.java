package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  extends g.c
{
  private String appId;
  public com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b kCW;
  a kCX;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public static boolean bjh()
  {
    AppMethodBeat.i(144488);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz();
    AppMethodBeat.o(144488);
    return bool;
  }
  
  public final List<e> Pv(String paramString)
  {
    AppMethodBeat.i(144486);
    if (this.kCW != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.kCW;
      if (localb.kEA != null)
      {
        paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localb.kEA.kEI.get(paramString);
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
    if (this.kCW != null)
    {
      Object localObject1 = this.kCW;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA;
        Object localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localc.kEI.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d(localc.context, paramString, localc);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "init deviceId:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cUi });
          if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM == null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b();
            localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM;
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).kED = new ConcurrentLinkedQueue();
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).kEF = new ArrayList();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM;
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEP = new ConcurrentHashMap();
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEK = new c.1(localc);
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEJ = new c.2(localc);
          localc.kEI.put(paramString, localObject1);
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cUi, parama });
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.kFh = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1);
        parama.a(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM);
        parama.kFj = paramb;
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEM;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.kEt)
        {
          if (paramString.kED == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramString.kED.add(parama);
          paramString.bjo();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.kEr)
        {
          paramString.aCF.postDelayed(new b.1(paramString, parama), parama.kFm);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bjg()
  {
    AppMethodBeat.i(144484);
    if (this.kCW != null)
    {
      Object localObject = this.kCW;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).kEA != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).kEA.bjg();
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
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bm(List<String> paramList)
  {
    AppMethodBeat.i(175627);
    if (this.kCW != null)
    {
      Object localObject1 = this.kCW;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA;
        if ((paramList == null) || (paramList.isEmpty()))
        {
          paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).bjg();
          AppMethodBeat.o(175627);
          return paramList;
        }
        localObject1 = new ArrayList();
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kEI.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((Iterator)localObject2).next();
          if (locald.kEN != null)
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
                if (locale.kFz) {
                  localArrayList.add(locale.uuid);
                }
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.g(paramList, localArrayList)) {
                ((List)localObject1).add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bt.nullAsNil(locald.kEN.getDevice().getName()), locald.cUi));
              }
            }
          }
        }
        AppMethodBeat.o(175627);
        return localObject1;
      }
      ad.w("MicroMsg.Ble.BleManager", "getConnectedBleDevices, bleConnectMgr is null");
      AppMethodBeat.o(175627);
      return null;
    }
    ad.w("MicroMsg.ble.BleWorker", "getConnectedBleDevices, bleManager is null");
    AppMethodBeat.o(175627);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> cV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    if (this.kCW != null)
    {
      Object localObject1 = this.kCW;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA.kEI.get(paramString1);
        if (localObject1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEN;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (bt.isNullOrNil(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] serviceId is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Py(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEP == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        paramString1 = (List)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEP.get(paramString2);
        if (paramString1 == null)
        {
          paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
          if (paramString1 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
            AppMethodBeat.o(144487);
            return null;
          }
          localObject2 = paramString1.getCharacteristics();
          if (localObject2 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] characteristics is null, err", new Object[0]);
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
            localc.kFr = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sV(i);
            localc.kFs = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sW(i);
            localc.kFt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sX(i);
            localc.hFJ = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sY(i);
            localc.kFu = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sZ(i);
            paramString1.add(localc);
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEP.put(paramString2, paramString1);
        }
        while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kEN == null)
        {
          AppMethodBeat.o(144487);
          return null;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).crd, "[getCharacteristics] use cache", new Object[0]);
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
    a.Pu(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc;
    try
    {
      AppMethodBeat.i(144490);
      if (this.kCW == null) {
        break label257;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.kCW;
      if (localb.kEA == null) {
        break label109;
      }
      localc = localb.kEA;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (localc.kEI == null) {
        break label109;
      }
      Iterator localIterator = localc.kEI.values().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localIterator.next()).uninit();
      }
      localc.kEI.clear();
    }
    finally {}
    localc.kEI = null;
    label109:
    if (localObject.kEB != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a locala = localObject.kEB;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(locala.crd, "uninit", new Object[0]);
      locala.bjr();
      locala.deV.set(false);
      if (locala.kcN != null) {
        locala.kcN.clear();
      }
      if (locala.kFX != null) {
        locala.kFX.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjx() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjx().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjx().cancelDiscovery();
      }
      if ((locala.kCT != null) && (locala.context != null))
      {
        ad.i(locala.crd, "bluetoothStateListener uninit");
        locala.context.unregisterReceiver(locala.kCT);
        locala.kCT = null;
      }
      locala.kFV = null;
      locala.context = null;
    }
    this.kCW = null;
    label257:
    AppMethodBeat.o(144490);
  }
  
  public static abstract interface a
  {
    public abstract void gs(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */