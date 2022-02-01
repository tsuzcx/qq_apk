package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

public final class b
  extends h.c
{
  private final String appId;
  private com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b lKM;
  volatile a lKN;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public static boolean bFf()
  {
    AppMethodBeat.i(144488);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE();
    AppMethodBeat.o(144488);
    return bool;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    AppMethodBeat.i(144485);
    Object localObject = bFg();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).lMr.ZE(paramString);
      if (localObject != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).cDW, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).dGL, parama });
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).lMF;
        if (paramString == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.lNb = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject);
        parama.a(paramString);
        parama.lNd = paramb;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.lMj)
        {
          paramb = paramString.lMu;
          if (paramb == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramb.add(parama);
          paramString.bFo();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.lMh)
        {
          paramString.aDv.postDelayed(new b.1(paramString, parama), parama.lNg);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> b(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(215144);
    Object localObject = bFg();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).lMr;
      if (paramBoolean)
      {
        paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).bB(paramList);
        AppMethodBeat.o(215144);
        return paramList;
      }
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramList = c.a.lME;
        paramList = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.bFq();
        AppMethodBeat.o(215144);
        return paramList;
      }
      paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).bB(paramList);
      AppMethodBeat.o(215144);
      return paramList;
    }
    AppMethodBeat.o(215144);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg()
  {
    try
    {
      AppMethodBeat.i(215145);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.lKM;
      if (localb == null) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
      }
      AppMethodBeat.o(215145);
      return localb;
    }
    finally {}
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> dn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    Object localObject1 = bFg();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).lMr;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).lMA == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).lMA.get(paramString1);
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).lMG;
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (Util.isNullOrNil(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] serviceId is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ZH(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Map localMap = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).lMI;
      if (localMap == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      paramString1 = (List)localMap.get(paramString2);
      if (paramString1 == null)
      {
        paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
        if (paramString1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        localObject2 = paramString1.getCharacteristics();
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] characteristics is null, err", new Object[0]);
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
          localc.lNl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wU(i);
          localc.lNm = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wV(i);
          localc.lNn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wW(i);
          localc.iDl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wX(i);
          localc.lNo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wY(i);
          paramString1.add(localc);
        }
        localMap.put(paramString2, paramString1);
      }
      while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).lMG == null)
      {
        AppMethodBeat.o(144487);
        return null;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cDW, "[getCharacteristics] use cache", new Object[0]);
      }
      AppMethodBeat.o(144487);
      return paramString1;
    }
    AppMethodBeat.o(144487);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> hn(boolean paramBoolean)
  {
    AppMethodBeat.i(215143);
    Object localObject = bFg();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).lMr;
      if (paramBoolean)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).bFp();
        AppMethodBeat.o(215143);
        return localObject;
      }
      localObject = c.a.lME;
      localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.bFq();
      AppMethodBeat.o(215143);
      return localObject;
    }
    AppMethodBeat.o(215143);
    return null;
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(215142);
      this.lKM = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(MMApplicationContext.getContext());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.lKM;
      localb.lMr.init();
      localb.lMs.init();
      AppMethodBeat.o(215142);
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
    a.ZD(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(144490);
      if (this.lKM != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.lKM;
        localb.lMr.uninit();
        localb.lMs.uninit();
        this.lKM = null;
      }
      AppMethodBeat.o(144490);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void ho(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */