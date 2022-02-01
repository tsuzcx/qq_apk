package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  extends k.c
  implements j
{
  private final String appId;
  volatile boolean rJY;
  private com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b rJZ;
  final List<a> rKa;
  final List<i> rKb;
  
  public b(String paramString)
  {
    AppMethodBeat.i(329523);
    this.rJY = false;
    this.rKa = new CopyOnWriteArrayList();
    this.rKb = new CopyOnWriteArrayList();
    this.appId = paramString;
    AppMethodBeat.o(329523);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c a(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    AppMethodBeat.i(329601);
    Object localObject = cqF();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).rMr;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).rMA == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).rMA.get(paramString1);
      if (localObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorker is null", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      paramString1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).rMH;
      if (paramString1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "[getCharacteristic] serviceId is null, err", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aar(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aar(paramString3))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      paramString1 = paramString1.getService(UUID.fromString(paramString2));
      if (paramString1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
      }
      paramString2 = UUID.fromString(paramString3);
      if (paramInteger != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] handle: %d", new Object[] { paramInteger });
        paramString3 = paramString1.getCharacteristics().iterator();
        do
        {
          if (!paramString3.hasNext()) {
            break;
          }
          paramString1 = (BluetoothGattCharacteristic)paramString3.next();
        } while ((!paramString2.equals(paramString1.getUuid())) || (paramInteger.intValue() != paramString1.getInstanceId()));
      }
      while (paramString1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "[getCharacteristic] characteristics is null, err", new Object[0]);
        AppMethodBeat.o(329601);
        return null;
        paramString1 = null;
        continue;
        paramString1 = paramString1.getCharacteristic(paramString2);
      }
      paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
      paramString2.uuid = paramString1.getUuid().toString().toUpperCase();
      int i = paramString1.getProperties();
      paramString2.rNn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AB(i);
      paramString2.rNo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AC(i);
      paramString2.rNp = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AD(i);
      paramString2.okL = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AE(i);
      paramString2.rNq = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AF(i);
      paramString2.rNr = paramString1.getInstanceId();
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] handle: %d, instanceId: %d", new Object[] { paramInteger, Integer.valueOf(paramString1.getInstanceId()) });
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).rMH == null)
      {
        AppMethodBeat.o(329601);
        return null;
      }
      AppMethodBeat.o(329601);
      return paramString2;
    }
    AppMethodBeat.o(329601);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(329527);
    this.rKa.add(parama);
    AppMethodBeat.o(329527);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(329612);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.ble.BleWorker", "onAuthorizeStateChange, newState: ".concat(String.valueOf(paramc)), new Object[0]);
    switch (2.rKd[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(329612);
      return;
      a.aao(this.appId);
      AppMethodBeat.o(329612);
      return;
      this.rJY = false;
      AppMethodBeat.o(329612);
      return;
      this.rJY = true;
    }
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(329544);
    this.rKb.add(parami);
    AppMethodBeat.o(329544);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    AppMethodBeat.i(144485);
    Object localObject = cqF();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).rMr.aap(paramString);
      if (localObject != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).exO, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).hEl, parama });
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).rMG;
        if (paramString == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.rNd = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject);
        parama.a(paramString);
        parama.rNf = paramb;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.rMh)
        {
          paramb = paramString.rMu;
          if (paramb == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramb.add(parama);
          paramString.crb();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.rMf)
        {
          paramString.mainHandler.postDelayed(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1(paramString, parama), parama.rNi);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<e> aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(329575);
    Object localObject = cqF();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).rMr;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).rMA == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(329575);
        return null;
      }
      paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).rMA.get(paramString);
      if (paramString == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
        AppMethodBeat.o(329575);
        return null;
      }
      if (paramBoolean)
      {
        paramString = paramString.crf();
        AppMethodBeat.o(329575);
        return paramString;
      }
      paramString = paramString.crg();
      AppMethodBeat.o(329575);
      return paramString;
    }
    AppMethodBeat.o(329575);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b cqF()
  {
    try
    {
      AppMethodBeat.i(329621);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.rJZ;
      if (localb == null) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
      }
      AppMethodBeat.o(329621);
      return localb;
    }
    finally {}
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> dP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    Object localObject1 = cqF();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).rMr;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).rMA == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).rMA.get(paramString1);
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).rMH;
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (Util.isNullOrNil(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] serviceId is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aar(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Map localMap = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).rMJ;
      if (localMap == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      paramString1 = (List)localMap.get(paramString2);
      if (paramString1 == null)
      {
        paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
        if (paramString1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        localObject2 = paramString1.getCharacteristics();
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] characteristics is null, err", new Object[0]);
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
          localc.rNn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AB(i);
          localc.rNo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AC(i);
          localc.rNp = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AD(i);
          localc.okL = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AE(i);
          localc.rNq = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.AF(i);
          localc.rNr = localBluetoothGattCharacteristic.getInstanceId();
          paramString1.add(localc);
        }
        localMap.put(paramString2, paramString1);
      }
      while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).rMH == null)
      {
        AppMethodBeat.o(144487);
        return null;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).exO, "[getCharacteristics] use cache", new Object[0]);
      }
      AppMethodBeat.o(144487);
      return paramString1;
    }
    AppMethodBeat.o(144487);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> e(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(329559);
    Object localObject = cqF();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).rMr;
      if (paramBoolean)
      {
        paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).dk(paramList);
        AppMethodBeat.o(329559);
        return paramList;
      }
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramList = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.a(c.a.rMF);
        AppMethodBeat.o(329559);
        return paramList;
      }
      paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).dk(paramList);
      AppMethodBeat.o(329559);
      return paramList;
    }
    AppMethodBeat.o(329559);
    return null;
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(329538);
      this.rJZ = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(MMApplicationContext.getContext());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.rJZ;
      localb.rMr.init();
      localb.rMs.init();
      localb = this.rJZ;
      i local1 = new i()
      {
        public final void aC(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(329565);
          Iterator localIterator = b.this.rKb.iterator();
          while (localIterator.hasNext()) {
            ((i)localIterator.next()).aC(paramAnonymousString, paramAnonymousBoolean);
          }
          AppMethodBeat.o(329565);
        }
      };
      localb.rMr.rMB = local1;
      AppMethodBeat.o(329538);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> jd(boolean paramBoolean)
  {
    AppMethodBeat.i(329553);
    Object localObject = cqF();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).rMr;
      if (paramBoolean)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).crc();
        AppMethodBeat.o(329553);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.a(c.a.rMF);
      AppMethodBeat.o(329553);
      return localObject;
    }
    AppMethodBeat.o(329553);
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144489);
    a.aao(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(144490);
      if (this.rJZ != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.rJZ;
        localb.rMr.uninit();
        localb.rMs.uninit();
        this.rJZ = null;
      }
      this.rKb.clear();
      this.rKa.clear();
      this.rJY = false;
      AppMethodBeat.o(144490);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void onBluetoothStateChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */