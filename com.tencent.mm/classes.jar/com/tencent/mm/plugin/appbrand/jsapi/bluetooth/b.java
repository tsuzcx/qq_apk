package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

public final class b
  extends k.c
{
  private final String appId;
  private com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b oGZ;
  volatile b.a oHa;
  
  public b(String paramString)
  {
    this.appId = paramString;
  }
  
  public static boolean bQJ()
  {
    AppMethodBeat.i(144488);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm();
    AppMethodBeat.o(144488);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> a(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(198452);
    Object localObject = bQK();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).oIH;
      if (paramBoolean)
      {
        paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).bz(paramList);
        AppMethodBeat.o(198452);
        return paramList;
      }
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramList = c.a.oIU;
        paramList = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.bQU();
        AppMethodBeat.o(198452);
        return paramList;
      }
      paramList = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).bz(paramList);
      AppMethodBeat.o(198452);
      return paramList;
    }
    AppMethodBeat.o(198452);
    return null;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb)
  {
    AppMethodBeat.i(144485);
    Object localObject = bQK();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).oIH.ahs(paramString);
      if (localObject != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).cED, "deviceId:%s aciton:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).fzB, parama });
        paramString = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).oIV;
        if (paramString == null)
        {
          AppMethodBeat.o(144485);
          return;
        }
        parama.oJp = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject);
        parama.a(paramString);
        parama.oJr = paramb;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
        if (parama.oIy)
        {
          paramb = paramString.oIK;
          if (paramb == null)
          {
            AppMethodBeat.o(144485);
            return;
          }
          paramb.add(parama);
          paramString.bQS();
          AppMethodBeat.o(144485);
          return;
        }
        if (parama.oIw)
        {
          paramString.die.postDelayed(new b.1(paramString, parama), parama.oJu);
          AppMethodBeat.o(144485);
          return;
        }
        parama.doAction();
      }
    }
    AppMethodBeat.o(144485);
  }
  
  public final List<e> aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198464);
    Object localObject = bQK();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).oIH;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).oIQ == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(198464);
        return null;
      }
      paramString = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).oIQ.get(paramString);
      if (paramString == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
        AppMethodBeat.o(198464);
        return null;
      }
      if (paramBoolean)
      {
        paramString = paramString.bQX();
        AppMethodBeat.o(198464);
        return paramString;
      }
      paramString = paramString.bQY();
      AppMethodBeat.o(198464);
      return paramString;
    }
    AppMethodBeat.o(198464);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bQK()
  {
    try
    {
      AppMethodBeat.i(198490);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.oGZ;
      if (localb == null) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
      }
      AppMethodBeat.o(198490);
      return localb;
    }
    finally {}
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> dw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144487);
    Object localObject1 = bQK();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).oIH;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).oIQ == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject1).oIQ.get(paramString1);
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).oIW;
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (Util.isNullOrNil(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] serviceId is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ahv(paramString2))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      Map localMap = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).oIY;
      if (localMap == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
        AppMethodBeat.o(144487);
        return null;
      }
      paramString1 = (List)localMap.get(paramString2);
      if (paramString1 == null)
      {
        paramString1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString2));
        if (paramString1 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
          AppMethodBeat.o(144487);
          return null;
        }
        localObject2 = paramString1.getCharacteristics();
        if (localObject2 == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] characteristics is null, err", new Object[0]);
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
          localc.oJz = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Ak(i);
          localc.oJA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Al(i);
          localc.oJB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Am(i);
          localc.ltl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.An(i);
          localc.oJC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Ao(i);
          paramString1.add(localc);
        }
        localMap.put(paramString2, paramString1);
      }
      while (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).oIW == null)
      {
        AppMethodBeat.o(144487);
        return null;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject1).cED, "[getCharacteristics] use cache", new Object[0]);
      }
      AppMethodBeat.o(144487);
      return paramString1;
    }
    AppMethodBeat.o(144487);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> ie(boolean paramBoolean)
  {
    AppMethodBeat.i(198451);
    Object localObject = bQK();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).oIH;
      if (paramBoolean)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).bQT();
        AppMethodBeat.o(198451);
        return localObject;
      }
      localObject = c.a.oIU;
      localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.bQU();
      AppMethodBeat.o(198451);
      return localObject;
    }
    AppMethodBeat.o(198451);
    return null;
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(198450);
      this.oGZ = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(MMApplicationContext.getContext());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.oGZ;
      localb.oIH.init();
      localb.oII.init();
      AppMethodBeat.o(198450);
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
    a.ahr(this.appId);
    AppMethodBeat.o(144489);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(144490);
      if (this.oGZ != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b localb = this.oGZ;
        localb.oIH.uninit();
        localb.oII.uninit();
        this.oGZ = null;
      }
      AppMethodBeat.o(144490);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */