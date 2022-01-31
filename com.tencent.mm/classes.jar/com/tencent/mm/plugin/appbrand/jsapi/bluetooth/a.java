package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static BroadcastReceiver hFt;
  public static boolean hFu;
  public static a.a hFv;
  private static Map<String, b> map;
  
  static
  {
    AppMethodBeat.i(94172);
    map = new ConcurrentHashMap();
    hFv = new a.1();
    AppMethodBeat.o(94172);
  }
  
  public static b BU(String paramString)
  {
    AppMethodBeat.i(94168);
    paramString = (b)map.get(paramString);
    AppMethodBeat.o(94168);
    return paramString;
  }
  
  public static j BV(String paramString)
  {
    AppMethodBeat.i(94169);
    ab.i("MicroMsg.Ble.BleManager", "close appId:%s", new Object[] { paramString });
    if (!map.containsKey(paramString))
    {
      paramString = j.hGN;
      AppMethodBeat.o(94169);
      return paramString;
    }
    b localb = (b)map.remove(paramString);
    e.b(paramString, localb);
    localb.uninit();
    if (map.size() == 0) {
      aCk();
    }
    paramString = j.hGN;
    AppMethodBeat.o(94169);
    return paramString;
  }
  
  public static j a(String paramString, b.a parama, h paramh, g paramg)
  {
    AppMethodBeat.i(94167);
    ab.i("MicroMsg.Ble.BleManager", "open appId:%s", new Object[] { paramString });
    if ((!d.fw(18)) && (ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.e("MicroMsg.Ble.BleManager", "api version is below 18");
      paramString = j.hGY;
      AppMethodBeat.o(94167);
      return paramString;
    }
    b localb;
    Object localObject1;
    Object localObject2;
    if (!map.containsKey(paramString))
    {
      ab.w("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[] { paramString });
      localb = new b(paramString);
      localb.hFw = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(ah.getContext());
      localObject1 = localb.hFw;
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGa;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (((c)localObject2).hGi == null) {
        ((c)localObject2).hGi = new ConcurrentHashMap();
      }
      ((c)localObject2).hGi.clear();
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGb;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "init", new Object[0]);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).chl.set(true);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHi = new HashMap();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHk = new ArrayList();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHg = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
      if (!"middle".equals("low")) {
        break label447;
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHh = new ScanSettingsCompat.a().nV(0).aCt();
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hFt == null)
      {
        ab.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener init");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hFt = new BleScanWorker.3((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
        localObject2 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).context.registerReceiver(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hFt, (IntentFilter)localObject2);
      }
      localb.hFx = parama;
      if (localb.hFw != null)
      {
        parama = localb.hFw;
        if (parama.hGa != null) {
          parama.hGa.hGj = paramh;
        }
      }
      if (localb.hFw != null)
      {
        parama = localb.hFw;
        if (parama.hGa != null) {
          parama.hGa.hGk = paramg;
        }
      }
      map.put(paramString, localb);
      e.a(paramString, localb);
      aCj();
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.hIj = hFv;
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw()) {
        break;
      }
      ab.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
      paramString = j.hGQ;
      AppMethodBeat.o(94167);
      return paramString;
      label447:
      if ("middle".equals("middle")) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHh = new ScanSettingsCompat.a().nV(1).aCt();
      } else if ("middle".equals("high")) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHh = new ScanSettingsCompat.a().nV(2).aCt();
      } else {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).hHh = new ScanSettingsCompat.a().nV(0).aCt();
      }
    }
    paramString = j.hGN;
    AppMethodBeat.o(94167);
    return paramString;
  }
  
  private static void aCj()
  {
    try
    {
      AppMethodBeat.i(94170);
      if (hFt == null)
      {
        ab.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
        hFt = new a.2();
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ah.getContext().registerReceiver(hFt, localIntentFilter);
        hFu = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw();
      }
      AppMethodBeat.o(94170);
      return;
    }
    finally {}
  }
  
  private static void aCk()
  {
    try
    {
      AppMethodBeat.i(94171);
      if (hFt != null)
      {
        ab.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
        ah.getContext().unregisterReceiver(hFt);
        hFt = null;
      }
      AppMethodBeat.o(94171);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */