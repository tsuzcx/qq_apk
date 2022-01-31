package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class a
{
  public static BroadcastReceiver glu;
  public static boolean glv;
  public static Map<String, a.a> map = new ConcurrentHashMap();
  
  public static void a(String paramString, a.a parama)
  {
    map.put(paramString, parama);
    if (glu == null)
    {
      y.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
      glu = new a.1();
      paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      ae.getContext().registerReceiver(glu, paramString);
    }
  }
  
  public static void remove(String paramString)
  {
    map.remove(paramString);
    y.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[] { paramString });
    if ((map.size() == 0) && (glu != null))
    {
      y.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
      ae.getContext().unregisterReceiver(glu);
      glu = null;
    }
  }
  
  public static a.a ub(String paramString)
  {
    return (a.a)map.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a
 * JD-Core Version:    0.7.0.1
 */