package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  extends g.b
{
  private String appId;
  com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b glx;
  b.a gly;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    if (this.glx != null)
    {
      Object localObject1 = this.glx;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).gmb != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).gmb;
        Object localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localc.gmk.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d(localc.context, paramString);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "init deviceId:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).bwK });
          if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo == null)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b();
            localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo;
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).gme = new ConcurrentLinkedQueue();
            ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b)localObject2).gmg = new ArrayList();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo;
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmr = new ConcurrentHashMap();
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmm = new c.1(localc);
          ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gml = new c.2(localc);
          localc.gmk.put(paramString, localObject1);
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).bwK, parama });
        parama.gmv = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1);
        parama.a(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo);
        parama.gmx = paramb;
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).gmo;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (!parama.glU) {
          break label289;
        }
        paramString.gme.add(parama);
        paramString.ait();
      }
    }
    return;
    label289:
    if (parama.glS)
    {
      paramString.gmh.postDelayed(new b.1(paramString, parama), parama.gmA);
      return;
    }
    parama.aiv();
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> air()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.glx != null)
    {
      Object localObject3 = this.glx;
      localObject1 = localObject2;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).gmb != null)
      {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).gmb;
        localObject1 = new ArrayList();
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).gmk.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject3).gmp != null) {
            ((List)localObject1).add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bk.pm(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject3).gmp.getDevice().getName()), ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject3).bwK));
          }
        }
      }
    }
    return localObject1;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> bx(String paramString1, String paramString2)
  {
    if (this.glx != null)
    {
      Object localObject = this.glx;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).gmb != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).gmb;
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).gmk.get(paramString1) != null)
        {
          locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).gmk.get(paramString1);
          if (locald.gmp != null) {
            break label81;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
        }
      }
      for (;;)
      {
        paramString1 = null;
        label81:
        do
        {
          return paramString1;
          if (bk.bl(paramString2))
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is null, err", new Object[0]);
            break;
          }
          if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.tZ(paramString2))
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
            break;
          }
          localObject = (List)locald.gmr.get(paramString2);
          paramString1 = (String)localObject;
        } while (localObject != null);
        paramString1 = locald.gmp.getService(UUID.fromString(paramString2));
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
      paramString1 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)((Iterator)localObject).next();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
        localc.dCX = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        int i = localBluetoothGattCharacteristic.getProperties();
        localc.gmE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lm(i);
        localc.gmF = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.ln(i);
        localc.gmG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lo(i);
        localc.dVu = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lp(i);
        localc.gmH = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lq(i);
        paramString1.add(localc);
      }
      locald.gmr.put(paramString2, paramString1);
      return paramString1;
    }
    return null;
  }
  
  public final void onDestroy()
  {
    a.tW(this.appId);
  }
  
  public final List<e> tX(String paramString)
  {
    if (this.glx != null)
    {
      Object localObject1 = this.glx;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).gmb != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).gmb;
        if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).gmk.get(paramString) != null)
        {
          paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).gmk.get(paramString);
          if (paramString.gmp != null) {
            break label72;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGatt is null, err", new Object[0]);
        }
      }
      for (;;)
      {
        return null;
        label72:
        if (bk.bl(paramString.bwK))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] deviceId is null, err", new Object[0]);
        }
        else
        {
          if (paramString.gmq != null) {
            break label304;
          }
          localObject2 = paramString.gmp.getServices();
          if (localObject2 != null) {
            break;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGattServices is null, err", new Object[0]);
        }
      }
      paramString.gmq = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        e locale = new e();
        locale.dCX = localBluetoothGattService.getUuid().toString().toUpperCase();
        if (localBluetoothGattService.getType() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          locale.gmN = bool;
          if ((!locale.dCX.equals("00001800-0000-1000-8000-00805F9B34FB")) && (!locale.dCX.equals("00001801-0000-1000-8000-00805F9B34FB"))) {
            break label269;
          }
          ((List)localObject1).add(locale);
          break;
        }
        label269:
        paramString.gmq.add(locale);
      }
      if (((List)localObject1).size() > 0) {
        paramString.gmq.addAll((Collection)localObject1);
      }
      label304:
      return paramString.gmq;
    }
    return null;
  }
  
  public final void uninit()
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c localc;
    try
    {
      if (this.glx == null) {
        break label392;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.glx;
      if (localb.gmb == null) {
        break label246;
      }
      localc = localb.gmb;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (localc.gmk == null) {
        break label246;
      }
      Iterator localIterator = localc.gmk.values().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localIterator.next();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "uninit deviceId:%s", new Object[] { locald.bwK });
        locald.da(true);
        if (locald.gmo != null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b localb1 = locald.gmo;
          if (localb1.gme != null)
          {
            localb1.gme.clear();
            localb1.gme = null;
          }
          if (localb1.gmg != null)
          {
            localb1.gmg.clear();
            localb1.gmg = null;
          }
          locald.gmo = null;
        }
        if (locald.gmq != null)
        {
          locald.gmq.clear();
          locald.gmq = null;
        }
        if (locald.gmr != null)
        {
          locald.gmr.clear();
          locald.gmr = null;
        }
      }
      localc.gmk.clear();
    }
    finally {}
    localc.gmk = null;
    label246:
    if (localObject.gmc != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a locala = localObject.gmc;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "uninit", new Object[0]);
      locala.gnl.set(false);
      locala.aiw();
      if (locala.gnj != null) {
        locala.gnj.clear();
      }
      if (locala.gnm != null) {
        locala.gnm.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiA() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiA().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiA().cancelDiscovery();
      }
      if ((locala.glu != null) && (locala.context != null))
      {
        y.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener uninit");
        locala.context.unregisterReceiver(locala.glu);
        locala.glu = null;
      }
      locala.gnh = null;
      locala.context = null;
    }
    this.glx = null;
    label392:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */