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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static BroadcastReceiver kia;
  public static boolean kib;
  public static a.a kic;
  private static Map<String, b> map;
  
  static
  {
    AppMethodBeat.i(144483);
    map = new ConcurrentHashMap();
    kic = new a.a()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(144473);
        ac.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(144473);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(144475);
        ac.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(144475);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(144474);
        ac.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(144474);
      }
    };
    AppMethodBeat.o(144483);
  }
  
  public static b LX(String paramString)
  {
    AppMethodBeat.i(144479);
    paramString = (b)map.get(paramString);
    AppMethodBeat.o(144479);
    return paramString;
  }
  
  public static j LY(String paramString)
  {
    AppMethodBeat.i(144480);
    ac.i("MicroMsg.Ble.BleManager", "close appId:%s", new Object[] { paramString });
    if (!map.containsKey(paramString))
    {
      paramString = j.kkA;
      AppMethodBeat.o(144480);
      return paramString;
    }
    b localb = (b)map.remove(paramString);
    com.tencent.mm.plugin.appbrand.g.b(paramString, localb);
    localb.uninit();
    if (map.size() == 0) {
      bfC();
    }
    paramString = j.kkA;
    AppMethodBeat.o(144480);
    return paramString;
  }
  
  public static j a(String paramString, b.a parama, h paramh, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g paramg)
  {
    AppMethodBeat.i(144478);
    ac.i("MicroMsg.Ble.BleManager", "open appId:%s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfU())
    {
      ac.e("MicroMsg.Ble.BleManager", "api version is below 18");
      paramString = j.kkL;
      AppMethodBeat.o(144478);
      return paramString;
    }
    if (!map.containsKey(paramString))
    {
      b localb = new b(paramString);
      localb.kid = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(ai.getContext());
      Object localObject1 = localb.kid;
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjC;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kjK == null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kjK = new ConcurrentHashMap();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject2).kjK.clear();
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kjD;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).cgL, "init", new Object[0]);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).cTF.set(true);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).jIB = new HashMap();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kkX = new ArrayList();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kkV = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kia == null)
      {
        ac.i(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).cgL, "bluetoothStateListener init");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kia = new BleScanWorker.3((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
        localObject2 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).context.registerReceiver(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).kia, (IntentFilter)localObject2);
      }
      localb.kie = parama;
      if (localb.kid != null)
      {
        parama = localb.kid;
        if (parama.kjC != null) {
          parama.kjC.kjL = paramh;
        }
      }
      if (localb.kid != null)
      {
        parama = localb.kid;
        if (parama.kjC != null) {
          parama.kjC.kjM = paramg;
        }
      }
      map.put(paramString, localb);
      com.tencent.mm.plugin.appbrand.g.a(paramString, localb);
      bfB();
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.klY = kic;
    }
    while (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())
    {
      ac.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
      paramString = j.kkD;
      AppMethodBeat.o(144478);
      return paramString;
      ac.i("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[] { paramString });
    }
    paramString = j.kkA;
    AppMethodBeat.o(144478);
    return paramString;
  }
  
  private static void bfB()
  {
    try
    {
      AppMethodBeat.i(144481);
      if (kia == null)
      {
        ac.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
        kia = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            boolean bool2 = false;
            AppMethodBeat.i(144477);
            if (paramAnonymousIntent == null)
            {
              ac.i("MicroMsg.Ble.BleManager", "Receive intent failed");
              AppMethodBeat.o(144477);
              return;
            }
            paramAnonymousContext = BluetoothAdapter.getDefaultAdapter();
            if (paramAnonymousContext != null)
            {
              int i = paramAnonymousContext.getState();
              ac.d("MicroMsg.Ble.BleManager", "state:%d", new Object[] { Integer.valueOf(i) });
              boolean bool1;
              if (i == 12) {
                bool1 = true;
              }
              while (((a.kib) && (!bool1)) || ((!a.kib) && (bool1)))
              {
                paramAnonymousContext = a.Ys().values().iterator();
                while (paramAnonymousContext.hasNext())
                {
                  paramAnonymousIntent = (b)paramAnonymousContext.next();
                  if (paramAnonymousIntent.kie != null) {
                    paramAnonymousIntent.kie.gm(bool1);
                  }
                }
                bool1 = bool2;
                if (i == 10) {
                  bool1 = bool2;
                }
              }
              a.kib = bool1;
            }
            AppMethodBeat.o(144477);
          }
        };
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ai.getContext().registerReceiver(kia, localIntentFilter);
        kib = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV();
      }
      AppMethodBeat.o(144481);
      return;
    }
    finally {}
  }
  
  private static void bfC()
  {
    try
    {
      AppMethodBeat.i(144482);
      if (kia != null)
      {
        ac.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
        ai.getContext().unregisterReceiver(kia);
        kia = null;
      }
      AppMethodBeat.o(144482);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */