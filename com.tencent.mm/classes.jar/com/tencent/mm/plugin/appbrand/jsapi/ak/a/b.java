package com.tencent.mm.plugin.appbrand.jsapi.ak.a;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/GetCurrentWiFiLogic;", "", "()V", "ACCEPT_INCOMPLETE_WIFI_ITEM_DEFAULT_VALUE", "", "ACCEPT_INCOMPLETE_WIFI_ITEM_PARAM_KEY", "", "TAG", "acceptIncompleteWiFiItem", "get", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/WiFiItem;", "ssid", "bssid", "fillBestEffort", "", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b sND;
  private static volatile boolean sNE;
  
  static
  {
    AppMethodBeat.i(325794);
    sND = new b();
    AppMethodBeat.o(325794);
  }
  
  public static boolean cye()
  {
    return sNE;
  }
  
  public static e jS(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(325788);
    Log.i("MicroMsg.AppBrand.GetCurrentWiFiLogic", s.X("get, acceptIncompleteWiFiItem: ", Boolean.valueOf(paramBoolean)));
    e locale = g.cyh();
    Object localObject1 = locale;
    if (locale == null)
    {
      if (!paramBoolean) {
        break label251;
      }
      localObject1 = d.cys();
      if (localObject1 == null) {
        break label251;
      }
      Log.i("MicroMsg.AppBrand.GetCurrentWiFiLogic", "get, wifiInfo.ssid: " + ((WifiInfo)localObject1).getSSID() + ", wifiInfo.bssid: " + ((WifiInfo)localObject1).getBSSID());
      locale = new e();
      locale.sNF = ((WifiInfo)localObject1).getSSID();
      locale.sNG = ((WifiInfo)localObject1).getBSSID();
      localObject1 = d.cys();
      if ((localObject1 != null) && (s.p(locale.sNG, ((WifiInfo)localObject1).getBSSID())))
      {
        Log.i("MicroMsg.AppBrand.GetCurrentWiFiLogic", "fillBestEffort, wifiInfo got");
        locale.sNH = Integer.valueOf(d.BE(((WifiInfo)localObject1).getRssi()));
      }
      String str = locale.sNG;
      List localList = d.cyq();
      localObject1 = localObject2;
      if (localList != null) {
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.b.k(str, localList);
      }
      if (localObject1 != null)
      {
        Log.i("MicroMsg.AppBrand.GetCurrentWiFiLogic", "fillBestEffort, wifiConfig not null");
        if (2 != com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.e.e((WifiConfiguration)localObject1)) {
          break label246;
        }
      }
    }
    label246:
    for (paramBoolean = true;; paramBoolean = false)
    {
      locale.sNI = Boolean.valueOf(paramBoolean);
      Log.i("MicroMsg.AppBrand.GetCurrentWiFiLogic", "fillBestEffort, signalStrength: " + locale.sNH + ", security: " + locale.sNI);
      localObject1 = locale;
      AppMethodBeat.o(325788);
      return localObject1;
    }
    label251:
    AppMethodBeat.o(325788);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.b
 * JD-Core Version:    0.7.0.1
 */