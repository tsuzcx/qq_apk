package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  extends e.c
{
  private String appId;
  com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b hFw;
  b.a hFx;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public final List<e> BW(String paramString)
  {
    AppMethodBeat.i(94175);
    if (this.hFw != null)
    {
      Object localObject1 = this.hFw;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa;
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).hGi.get(paramString) != null)
        {
          paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).hGi.get(paramString);
          if (paramString.hGn != null) {
            break label81;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGatt is null, err", new Object[0]);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94175);
        return null;
        label81:
        if (bo.isNullOrNil(paramString.bYu))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] deviceId is null, err", new Object[0]);
        }
        else
        {
          if (paramString.hGo != null) {
            break label309;
          }
          localObject2 = paramString.hGn.getServices();
          if (localObject2 != null) {
            break;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGattServices is null, err", new Object[0]);
        }
      }
      paramString.hGo = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        e locale = new e();
        locale.eAx = localBluetoothGattService.getUuid().toString().toUpperCase();
        if (localBluetoothGattService.getType() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          locale.hGM = bool;
          if ((!locale.eAx.equals("00001800-0000-1000-8000-00805F9B34FB")) && (!locale.eAx.equals("00001801-0000-1000-8000-00805F9B34FB"))) {
            break label274;
          }
          ((List)localObject1).add(locale);
          break;
        }
        label274:
        paramString.hGo.add(locale);
      }
      if (((List)localObject1).size() > 0) {
        paramString.hGo.addAll((Collection)localObject1);
      }
      label309:
      paramString = paramString.hGo;
      AppMethodBeat.o(94175);
      return paramString;
    }
    AppMethodBeat.o(94175);
    return null;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    AppMethodBeat.i(94174);
    if (this.hFw != null)
    {
      Object localObject1 = this.hFw;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa;
        Object localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localc.hGi.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d(localc.context, paramString);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "init deviceId:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).bYu });
          if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm == null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b();
            localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm;
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).hGd = new ConcurrentLinkedQueue();
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).hGf = new ArrayList();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm;
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGp = new ConcurrentHashMap();
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGk = new c.1(localc);
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGj = new c.2(localc);
          localc.hGi.put(paramString, localObject1);
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).bYu, parama });
        parama.a((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1);
        parama.a(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm);
        parama.hGx = paramb;
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).hGm;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.hFT)
        {
          paramString.hGd.add(parama);
          paramString.aCn();
          AppMethodBeat.o(94174);
          return;
        }
        if (parama.hFR)
        {
          paramString.bTu.postDelayed(new b.1(paramString, parama), parama.hGA);
          AppMethodBeat.o(94174);
          return;
        }
        parama.aCp();
      }
    }
    AppMethodBeat.o(94174);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> aCl()
  {
    AppMethodBeat.i(94173);
    if (this.hFw != null)
    {
      Object localObject1 = this.hFw;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa;
        localObject1 = new ArrayList();
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).hGi.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((Iterator)localObject2).next();
          if (locald.hGn != null) {
            ((List)localObject1).add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bo.nullAsNil(locald.hGn.getDevice().getName()), locald.bYu));
          }
        }
        AppMethodBeat.o(94173);
        return localObject1;
      }
      AppMethodBeat.o(94173);
      return null;
    }
    AppMethodBeat.o(94173);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(94176);
    if (this.hFw != null)
    {
      Object localObject = this.hFw;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).hGa != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).hGa;
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).hGi.get(paramString1) != null)
        {
          locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).hGi.get(paramString1);
          if (locald.hGn != null) {
            break label92;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94176);
        return null;
        label92:
        if (bo.isNullOrNil(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is null, err", new Object[0]);
        }
        else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.BY(paramString2))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        }
        else
        {
          localObject = (List)locald.hGp.get(paramString2);
          paramString1 = (String)localObject;
          if (localObject != null) {
            break label358;
          }
          paramString1 = locald.hGn.getService(UUID.fromString(paramString2));
          if (paramString1 == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
          }
          else
          {
            localObject = paramString1.getCharacteristics();
            if (localObject != null) {
              break;
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristics is null, err", new Object[0]);
          }
        }
      }
      paramString1 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)((Iterator)localObject).next();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
        localc.eAx = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        int i = localBluetoothGattCharacteristic.getProperties();
        localc.hGE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nW(i);
        localc.hGF = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nX(i);
        localc.hGG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nY(i);
        localc.flD = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nZ(i);
        localc.hGH = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.oa(i);
        paramString1.add(localc);
      }
      locald.hGp.put(paramString2, paramString1);
      label358:
      AppMethodBeat.o(94176);
      return paramString1;
    }
    AppMethodBeat.o(94176);
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94177);
    a.BV(this.appId);
    AppMethodBeat.o(94177);
  }
  
  public final void uninit()
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc;
    try
    {
      AppMethodBeat.i(94178);
      if (this.hFw == null) {
        break label398;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.hFw;
      if (localb.hGa == null) {
        break label252;
      }
      localc = localb.hGa;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (localc.hGi == null) {
        break label252;
      }
      Iterator localIterator = localc.hGi.values().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localIterator.next();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "uninit deviceId:%s", new Object[] { locald.bYu });
        locald.ee(true);
        if (locald.hGm != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb1 = locald.hGm;
          if (localb1.hGd != null)
          {
            localb1.hGd.clear();
            localb1.hGd = null;
          }
          if (localb1.hGf != null)
          {
            localb1.hGf.clear();
            localb1.hGf = null;
          }
          locald.hGm = null;
        }
        if (locald.hGo != null)
        {
          locald.hGo.clear();
          locald.hGo = null;
        }
        if (locald.hGp != null)
        {
          locald.hGp.clear();
          locald.hGp = null;
        }
      }
      localc.hGi.clear();
    }
    finally {}
    localc.hGi = null;
    label252:
    if (localObject.hGb != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a locala = localObject.hGb;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "uninit", new Object[0]);
      locala.chl.set(false);
      locala.aCr();
      if (locala.hHi != null) {
        locala.hHi.clear();
      }
      if (locala.hHk != null) {
        locala.hHk.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCv() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCv().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCv().cancelDiscovery();
      }
      if ((locala.hFt != null) && (locala.context != null))
      {
        ab.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener uninit");
        locala.context.unregisterReceiver(locala.hFt);
        locala.hFt = null;
      }
      locala.hHg = null;
      locala.context = null;
    }
    this.hFw = null;
    label398:
    AppMethodBeat.o(94178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */