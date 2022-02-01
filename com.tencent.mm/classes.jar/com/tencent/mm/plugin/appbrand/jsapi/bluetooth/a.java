package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static BroadcastReceiver kCT;
  public static boolean kCU;
  public static a.a kCV;
  private static Map<String, b> map;
  
  static
  {
    AppMethodBeat.i(144483);
    map = new ConcurrentHashMap();
    kCV = new a.1();
    AppMethodBeat.o(144483);
  }
  
  public static b Pt(String paramString)
  {
    AppMethodBeat.i(144479);
    paramString = (b)map.get(paramString);
    AppMethodBeat.o(144479);
    return paramString;
  }
  
  public static j Pu(String paramString)
  {
    AppMethodBeat.i(144480);
    ad.i("MicroMsg.Ble.BleManager", "close appId:%s", new Object[] { paramString });
    if (!map.containsKey(paramString))
    {
      paramString = j.kFA;
      AppMethodBeat.o(144480);
      return paramString;
    }
    b localb = (b)map.remove(paramString);
    com.tencent.mm.plugin.appbrand.g.b(paramString, localb);
    localb.uninit();
    if (map.size() == 0) {
      bjf();
    }
    paramString = j.kFA;
    AppMethodBeat.o(144480);
    return paramString;
  }
  
  public static j a(String paramString, b.a parama, h paramh, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g paramg)
  {
    AppMethodBeat.i(144478);
    ad.i("MicroMsg.Ble.BleManager", "open appId:%s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjy())
    {
      ad.e("MicroMsg.Ble.BleManager", "api version is below 18");
      paramString = j.kFL;
      AppMethodBeat.o(144478);
      return paramString;
    }
    if (!map.containsKey(paramString))
    {
      b localb = new b(paramString);
      localb.kCW = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(aj.getContext());
      Object localObject1 = localb.kCW;
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEA;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kEI == null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kEI = new ConcurrentHashMap();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kEI.clear();
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEB;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).crd, "init", new Object[0]);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).deV.set(true);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kcN = new HashMap();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kFX = new ArrayList();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kFV = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kCT == null)
      {
        ad.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).crd, "bluetoothStateListener init");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kCT = new BleScanWorker.3((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
        localObject2 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).context.registerReceiver(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kCT, (IntentFilter)localObject2);
      }
      localb.kCX = parama;
      if (localb.kCW != null)
      {
        parama = localb.kCW;
        if (parama.kEA != null) {
          parama.kEA.kEJ = paramh;
        }
      }
      if (localb.kCW != null)
      {
        parama = localb.kCW;
        if (parama.kEA != null) {
          parama.kEA.kEK = paramg;
        }
      }
      map.put(paramString, localb);
      com.tencent.mm.plugin.appbrand.g.a(paramString, localb);
      bje();
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.kGY = kCV;
    }
    while (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      ad.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
      paramString = j.kFD;
      AppMethodBeat.o(144478);
      return paramString;
      ad.i("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[] { paramString });
    }
    paramString = j.kFA;
    AppMethodBeat.o(144478);
    return paramString;
  }
  
  private static void bje()
  {
    try
    {
      AppMethodBeat.i(144481);
      if (kCT == null)
      {
        ad.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
        kCT = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            boolean bool2 = false;
            AppMethodBeat.i(144477);
            if (paramAnonymousIntent == null)
            {
              ad.i("MicroMsg.Ble.BleManager", "Receive intent failed");
              AppMethodBeat.o(144477);
              return;
            }
            paramAnonymousContext = BluetoothAdapter.getDefaultAdapter();
            if (paramAnonymousContext != null)
            {
              int i = paramAnonymousContext.getState();
              ad.d("MicroMsg.Ble.BleManager", "state:%d", new Object[] { Integer.valueOf(i) });
              boolean bool1;
              if (i == 12) {
                bool1 = true;
              }
              while (((a.kCU) && (!bool1)) || ((!a.kCU) && (bool1)))
              {
                paramAnonymousContext = a.aaU().values().iterator();
                while (paramAnonymousContext.hasNext())
                {
                  paramAnonymousIntent = (b)paramAnonymousContext.next();
                  if (paramAnonymousIntent.kCX != null) {
                    paramAnonymousIntent.kCX.gs(bool1);
                  }
                }
                bool1 = bool2;
                if (i == 10) {
                  bool1 = bool2;
                }
              }
              a.kCU = bool1;
            }
            AppMethodBeat.o(144477);
          }
        };
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        aj.getContext().registerReceiver(kCT, localIntentFilter);
        kCU = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz();
      }
      AppMethodBeat.o(144481);
      return;
    }
    finally {}
  }
  
  private static void bjf()
  {
    try
    {
      AppMethodBeat.i(144482);
      if (kCT != null)
      {
        ad.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
        aj.getContext().unregisterReceiver(kCT);
        kCT = null;
      }
      AppMethodBeat.o(144482);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */