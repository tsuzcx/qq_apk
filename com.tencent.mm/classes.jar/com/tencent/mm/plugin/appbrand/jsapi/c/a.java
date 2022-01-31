package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class a
{
  public static BroadcastReceiver hFt;
  public static boolean hFu;
  public static Map<String, a.a> map;
  
  static
  {
    AppMethodBeat.i(94358);
    map = new ConcurrentHashMap();
    AppMethodBeat.o(94358);
  }
  
  public static a.a Ca(String paramString)
  {
    AppMethodBeat.i(94356);
    paramString = (a.a)map.get(paramString);
    AppMethodBeat.o(94356);
    return paramString;
  }
  
  public static void a(String paramString, a.a parama)
  {
    AppMethodBeat.i(94355);
    map.put(paramString, parama);
    if (hFt == null)
    {
      ab.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
      hFt = new a.1();
      paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      ah.getContext().registerReceiver(hFt, paramString);
    }
    AppMethodBeat.o(94355);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(94357);
    map.remove(paramString);
    ab.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[] { paramString });
    if ((map.size() == 0) && (hFt != null))
    {
      ab.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
      ah.getContext().unregisterReceiver(hFt);
      hFt = null;
    }
    AppMethodBeat.o(94357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a
 * JD-Core Version:    0.7.0.1
 */