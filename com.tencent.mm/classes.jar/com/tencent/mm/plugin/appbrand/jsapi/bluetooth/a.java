package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static BroadcastReceiver glu;
  public static boolean glv;
  public static a.a glw = new a.1();
  private static Map<String, b> map = new ConcurrentHashMap();
  
  public static j a(String paramString, b.a parama, h paramh, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g paramg)
  {
    y.i("MicroMsg.Ble.BleManager", "open appId:%s", new Object[] { paramString });
    if ((!d.gG(18)) && (ae.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.e("MicroMsg.Ble.BleManager", "api version is below 18");
      return j.gmZ;
    }
    b localb;
    Object localObject1;
    Object localObject2;
    if (!map.containsKey(paramString))
    {
      y.w("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[] { paramString });
      localb = new b(paramString);
      localb.glx = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(ae.getContext());
      localObject1 = localb.glx;
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).gmb;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (((c)localObject2).gmk == null) {
        ((c)localObject2).gmk = new ConcurrentHashMap();
      }
      ((c)localObject2).gmk.clear();
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).gmc;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "init", new Object[0]);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gnl.set(true);
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gnj = new HashMap();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gnm = new ArrayList();
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gnh = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.2((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
      if (!"middle".equals("low")) {
        break label427;
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gni = new ScanSettingsCompat.a().ll(0).aiy();
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).glu == null)
      {
        y.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener init");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).glu = new BleScanWorker.3((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1);
        localObject2 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).context.registerReceiver(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).glu, (IntentFilter)localObject2);
      }
      localb.gly = parama;
      if (localb.glx != null)
      {
        parama = localb.glx;
        if (parama.gmb != null) {
          parama.gmb.gml = paramh;
        }
      }
      if (localb.glx != null)
      {
        parama = localb.glx;
        if (parama.gmb != null) {
          parama.gmb.gmm = paramg;
        }
      }
      map.put(paramString, localb);
      com.tencent.mm.plugin.appbrand.g.a(paramString, localb);
      aip();
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.gom = glw;
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB()) {
        break;
      }
      y.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
      return j.gmR;
      label427:
      if ("middle".equals("middle")) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gni = new ScanSettingsCompat.a().ll(1).aiy();
      } else if ("middle".equals("high")) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gni = new ScanSettingsCompat.a().ll(2).aiy();
      } else {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a)localObject1).gni = new ScanSettingsCompat.a().ll(0).aiy();
      }
    }
    return j.gmO;
  }
  
  private static void aip()
  {
    try
    {
      if (glu == null)
      {
        y.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
        glu = new a.2();
        IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ae.getContext().registerReceiver(glu, localIntentFilter);
        glv = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void aiq()
  {
    try
    {
      if (glu != null)
      {
        y.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
        ae.getContext().unregisterReceiver(glu);
        glu = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static b tV(String paramString)
  {
    return (b)map.get(paramString);
  }
  
  public static j tW(String paramString)
  {
    y.i("MicroMsg.Ble.BleManager", "close appId:%s", new Object[] { paramString });
    if (!map.containsKey(paramString)) {
      return j.gmO;
    }
    b localb = (b)map.remove(paramString);
    com.tencent.mm.plugin.appbrand.g.b(paramString, localb);
    localb.uninit();
    if (map.size() == 0) {
      aiq();
    }
    return j.gmO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a
 * JD-Core Version:    0.7.0.1
 */