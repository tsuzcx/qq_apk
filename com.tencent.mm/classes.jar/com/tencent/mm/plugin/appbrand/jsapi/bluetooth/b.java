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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b kid;
  a kie;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public static boolean bfE()
  {
    AppMethodBeat.i(144488);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV();
    AppMethodBeat.o(144488);
    return bool;
  }
  
  public final List<e> LZ(String paramString)
  {
    AppMethodBeat.i(144486);
    if (this.kid != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.kid;
      if (localb.kjC != null)
      {
        paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localb.kjC.kjK.get(paramString);
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
    if (this.kid != null)
    {
      Object localObject1 = this.kid;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC;
        Object localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localc.kjK.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d(localc.context, paramString, localc);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "init deviceId:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cIZ });
          if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO == null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b();
            localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO;
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).kjF = new ConcurrentLinkedQueue();
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).kjH = new ArrayList();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO;
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjR = new ConcurrentHashMap();
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjM = new c.1(localc);
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjL = new c.2(localc);
          localc.kjK.put(paramString, localObject1);
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cIZ, parama });
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.kkh = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1);
        parama.a(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO);
        parama.kkj = paramb;
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjO;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.kjv)
        {
          if (paramString.kjF == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramString.kjF.add(parama);
          paramString.bfK();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.kjt)
        {
          paramString.aAO.postDelayed(new b.1(paramString, parama), parama.kkm);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bfD()
  {
    AppMethodBeat.i(144484);
    if (this.kid != null)
    {
      Object localObject = this.kid;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).kjC != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).kjC.bfD();
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
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bk(List<String> paramList)
  {
    AppMethodBeat.i(175627);
    if (this.kid != null)
    {
      Object localObject1 = this.kid;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC;
        if ((paramList == null) || (paramList.isEmpty()))
        {
          paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).bfD();
          AppMethodBeat.o(175627);
          return paramList;
        }
        localObject1 = new ArrayList();
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kjK.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((Iterator)localObject2).next();
          if (locald.kjP != null)
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
                if (locale.kkz) {
                  localArrayList.add(locale.uuid);
                }
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.g(paramList, localArrayList)) {
                ((List)localObject1).add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bs.nullAsNil(locald.kjP.getDevice().getName()), locald.cIZ));
              }
            }
          }
        }
        AppMethodBeat.o(175627);
        return localObject1;
      }
      ac.w("MicroMsg.Ble.BleManager", "getConnectedBleDevices, bleConnectMgr is null");
      AppMethodBeat.o(175627);
      return null;
    }
    ac.w("MicroMsg.ble.BleWorker", "getConnectedBleDevices, bleManager is null");
    AppMethodBeat.o(175627);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> cT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    if (this.kid != null)
    {
      Object localObject1 = this.kid;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC.kjK.get(paramString1);
        if (localObject1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjP;
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (bs.isNullOrNil(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "[getCharacteristics] serviceId is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Mc(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        paramString1 = (List)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjR.get(paramString2);
        if (paramString1 == null)
        {
          paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
          if (paramString1 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
            AppMethodBeat.o(144487);
            return null;
          }
          localObject2 = paramString1.getCharacteristics();
          if (localObject2 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "[getCharacteristics] characteristics is null, err", new Object[0]);
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
            localc.kkr = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.st(i);
            localc.kks = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.su(i);
            localc.kkt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sv(i);
            localc.hnr = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sw(i);
            localc.kku = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sx(i);
            paramString1.add(localc);
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjR.put(paramString2, paramString1);
        }
        while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).kjP == null)
        {
          AppMethodBeat.o(144487);
          return null;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cgL, "[getCharacteristics] use cache", new Object[0]);
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
    a.LY(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc;
    try
    {
      AppMethodBeat.i(144490);
      if (this.kid == null) {
        break label257;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.kid;
      if (localb.kjC == null) {
        break label109;
      }
      localc = localb.kjC;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (localc.kjK == null) {
        break label109;
      }
      Iterator localIterator = localc.kjK.values().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localIterator.next()).uninit();
      }
      localc.kjK.clear();
    }
    finally {}
    localc.kjK = null;
    label109:
    if (localObject.kjD != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a locala = localObject.kjD;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(locala.cgL, "uninit", new Object[0]);
      locala.bfN();
      locala.cTF.set(false);
      if (locala.jIB != null) {
        locala.jIB.clear();
      }
      if (locala.kkX != null) {
        locala.kkX.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfT() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfT().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfT().cancelDiscovery();
      }
      if ((locala.kia != null) && (locala.context != null))
      {
        ac.i(locala.cgL, "bluetoothStateListener uninit");
        locala.context.unregisterReceiver(locala.kia);
        locala.kia = null;
      }
      locala.kkV = null;
      locala.context = null;
    }
    this.kid = null;
    label257:
    AppMethodBeat.o(144490);
  }
  
  public static abstract interface a
  {
    public abstract void gm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */