package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static BroadcastReceiver kGi;
  public static boolean kGj;
  public static a.a kGk;
  private static Map<String, b> map;
  
  static
  {
    AppMethodBeat.i(144483);
    map = new ConcurrentHashMap();
    kGk = new a.1();
    AppMethodBeat.o(144483);
  }
  
  public static b Qb(String paramString)
  {
    AppMethodBeat.i(144479);
    paramString = (b)map.get(paramString);
    AppMethodBeat.o(144479);
    return paramString;
  }
  
  public static j Qc(String paramString)
  {
    AppMethodBeat.i(144480);
    ae.i("MicroMsg.Ble.BleManager", "close appId:%s", new Object[] { paramString });
    if (!map.containsKey(paramString))
    {
      paramString = j.kIP;
      AppMethodBeat.o(144480);
      return paramString;
    }
    b localb = (b)map.remove(paramString);
    com.tencent.mm.plugin.appbrand.h.b(paramString, localb);
    localb.uninit();
    if (map.size() == 0) {
      bjO();
    }
    paramString = j.kIP;
    AppMethodBeat.o(144480);
    return paramString;
  }
  
  public static j a(String paramString, b.a parama, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h paramh, g paramg)
  {
    AppMethodBeat.i(144478);
    ae.i("MicroMsg.Ble.BleManager", "open appId:%s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkh())
    {
      ae.e("MicroMsg.Ble.BleManager", "api version is below 18");
      paramString = j.kJa;
      AppMethodBeat.o(144478);
      return paramString;
    }
    if (!map.containsKey(paramString))
    {
      b localb = new b(paramString);
      localb.kGl = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(ak.getContext());
      Object localObject1 = localb.kGl;
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHP;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kHX == null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kHX = new ConcurrentHashMap();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kHX.clear();
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kHQ;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).crG, "init", new Object[0]);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).dfX.set(true);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kge = new HashMap();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kJm = new ArrayList();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kJk = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kGi == null)
      {
        ae.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).crG, "bluetoothStateListener init");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kGi = new BleScanWorker.3((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
        localObject2 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).context.registerReceiver(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kGi, (IntentFilter)localObject2);
      }
      localb.kGm = parama;
      if (localb.kGl != null)
      {
        parama = localb.kGl;
        if (parama.kHP != null) {
          parama.kHP.kHY = paramh;
        }
      }
      if (localb.kGl != null)
      {
        parama = localb.kGl;
        if (parama.kHP != null) {
          parama.kHP.kHZ = paramg;
        }
      }
      map.put(paramString, localb);
      com.tencent.mm.plugin.appbrand.h.a(paramString, localb);
      bjN();
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.kKn = kGk;
    }
    while (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())
    {
      ae.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
      paramString = j.kIS;
      AppMethodBeat.o(144478);
      return paramString;
      ae.i("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[] { paramString });
    }
    paramString = j.kIP;
    AppMethodBeat.o(144478);
    return paramString;
  }
  
  private static void bjN()
  {
    try
    {
      AppMethodBeat.i(144481);
      if (kGi == null)
      {
        ae.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
        kGi = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            boolean bool2 = false;
            AppMethodBeat.i(144477);
            if (paramAnonymousIntent == null)
            {
              ae.i("MicroMsg.Ble.BleManager", "Receive intent failed");
              AppMethodBeat.o(144477);
              return;
            }
            paramAnonymousContext = BluetoothAdapter.getDefaultAdapter();
            if (paramAnonymousContext != null)
            {
              int i = paramAnonymousContext.getState();
              ae.d("MicroMsg.Ble.BleManager", "state:%d", new Object[] { Integer.valueOf(i) });
              boolean bool1;
              if (i == 12) {
                bool1 = true;
              }
              while (((a.kGj) && (!bool1)) || ((!a.kGj) && (bool1)))
              {
                paramAnonymousContext = a.abd().values().iterator();
                while (paramAnonymousContext.hasNext())
                {
                  paramAnonymousIntent = (b)paramAnonymousContext.next();
                  if (paramAnonymousIntent.kGm != null) {
                    paramAnonymousIntent.kGm.gq(bool1);
                  }
                }
                bool1 = bool2;
                if (i == 10) {
                  bool1 = bool2;
                }
              }
              a.kGj = bool1;
            }
            AppMethodBeat.o(144477);
          }
        };
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ak.getContext().registerReceiver(kGi, localIntentFilter);
        kGj = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki();
      }
      AppMethodBeat.o(144481);
      return;
    }
    finally {}
  }
  
  private static void bjO()
  {
    try
    {
      AppMethodBeat.i(144482);
      if (kGi != null)
      {
        ae.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
        ak.getContext().unregisterReceiver(kGi);
        kGi = null;
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