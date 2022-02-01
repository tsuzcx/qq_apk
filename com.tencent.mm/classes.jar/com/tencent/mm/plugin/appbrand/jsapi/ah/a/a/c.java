package com.tencent.mm.plugin.appbrand.jsapi.ah.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.net.NetworkSpecifier;
import android.net.wifi.WifiNetworkSpecifier.Builder;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl;", "", "()V", "TAG", "", "connectWifi", "", "context", "Landroid/content/Context;", "ssid", "bssid", "password", "timeoutMs", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "tryKeepConnectedWifi", "IListener", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c
{
  public static final c pJl;
  
  static
  {
    AppMethodBeat.i(199641);
    pJl = new c();
    AppMethodBeat.o(199641);
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, long paramLong, final a parama)
  {
    AppMethodBeat.i(199639);
    p.k(parama, "listener");
    Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, ssid: " + paramString1 + ", bssid: " + paramString2 + ", timeoutMs: " + paramLong);
    locale = new e(parama);
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {}
    }
    for (paramContext = paramContext.getSystemService("connectivity");; paramContext = null)
    {
      parama = paramContext;
      if (!(paramContext instanceof ConnectivityManager)) {
        parama = null;
      }
      paramContext = (ConnectivityManager)parama;
      if (paramContext != null) {
        break;
      }
      Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connectivityManager is null");
      locale.bXZ();
      AppMethodBeat.o(199639);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connect params illegal");
      locale.bXZ();
      AppMethodBeat.o(199639);
      return;
    }
    try
    {
      parama = new WifiNetworkSpecifier.Builder();
      parama.setSsid(paramString1);
    }
    catch (Exception paramContext)
    {
      int i;
      label205:
      Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, build network specifier fail since ".concat(String.valueOf(paramContext)));
      label396:
      locale.bXZ();
      AppMethodBeat.o(199639);
      return;
    }
    try
    {
      if (((CharSequence)paramString2).length() <= 0) {
        break label396;
      }
      i = 1;
      if (i != 0) {
        parama.setBssid(MacAddress.fromString(paramString2));
      }
    }
    catch (Exception localException)
    {
      break label205;
    }
    if (((CharSequence)paramString3).length() > 0) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        parama.setWpa2Passphrase(paramString3);
      }
      Object localObject = parama.build();
      p.j(localObject, "try {\n                Wi…     return\n            }");
      parama = new aa.f();
      parama.aaBC = null;
      paramString3 = new aa.f();
      paramString3.aaBC = null;
      try
      {
        localObject = new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier((NetworkSpecifier)localObject).build();
        paramString3.aaBC = ((a.b)new b(paramString1, paramString2, parama, locale));
        paramString1 = new d(parama, paramString3, locale, paramContext);
        if (-1L != paramLong) {
          parama.aaBC = h.ZvG.o((Runnable)new c(paramContext, paramString1, locale), paramLong);
        }
        a.a((a.b)paramString3.aaBC);
        paramContext.requestNetwork((NetworkRequest)localObject, (ConnectivityManager.NetworkCallback)paramString1);
        AppMethodBeat.o(199639);
        return;
      }
      catch (Exception paramContext)
      {
        Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, fail since ".concat(String.valueOf(paramContext)));
        paramContext = (com.tencent.e.i.d)parama.aaBC;
        if (paramContext == null) {
          break label470;
        }
        paramContext.cancel(true);
        paramContext = (a.b)paramString3.aaBC;
        if (paramContext == null) {
          break label486;
        }
        a.b(paramContext);
        locale.bXZ();
        AppMethodBeat.o(199639);
        return;
      }
      i = 0;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"})
  public static abstract interface a
  {
    public abstract void bXY();
    
    public abstract void bXZ();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/ConnectWifiEvents$IListener;", "onConnect", "", "wiFiItem", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/WiFiItem;", "onDisconnect", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class b
    implements a.b
  {
    b(String paramString1, String paramString2, aa.f paramf, c.e parame) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.ah.a.d paramd)
    {
      AppMethodBeat.i(199583);
      p.k(paramd, "wiFiItem");
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnect#sysListener");
      if (Util.isEqual(this.pJm, paramd.pIL)) {
        if (((CharSequence)paramString2).length() != 0) {
          break label117;
        }
      }
      label117:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (Util.isEqual(paramString2, paramd.pIM)))
        {
          Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnect#sysListener, match");
          paramd = (com.tencent.e.i.d)parama.aaBC;
          if (paramd != null) {
            paramd.cancel(true);
          }
          a.b((a.b)this);
          locale.bXY();
        }
        AppMethodBeat.o(199583);
        return;
      }
    }
    
    public final void aFw() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ConnectivityManager paramConnectivityManager, c.d paramd, c.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(199694);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "timeout");
      this.pJq.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)paramString1);
      locale.bXZ();
      AppMethodBeat.o(199694);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$callback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class d
    extends ConnectivityManager.NetworkCallback
  {
    d(aa.f paramf1, aa.f paramf2, c.e parame, ConnectivityManager paramConnectivityManager) {}
    
    public final void onAvailable(Network paramNetwork)
    {
      AppMethodBeat.i(199526);
      p.k(paramNetwork, "network");
      super.onAvailable(paramNetwork);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, network: ".concat(String.valueOf(paramNetwork)));
      com.tencent.e.i.d locald = (com.tencent.e.i.d)this.pJo.aaBC;
      if (locald != null) {
        locald.cancel(true);
      }
      a.b((a.b)paramString3.aaBC);
      locale.bXY();
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, success: ".concat(String.valueOf(paramContext.bindProcessToNetwork(paramNetwork))));
      AppMethodBeat.o(199526);
    }
    
    public final void onLost(Network paramNetwork)
    {
      AppMethodBeat.i(199532);
      p.k(paramNetwork, "network");
      super.onLost(paramNetwork);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onLost, network: ".concat(String.valueOf(paramNetwork)));
      paramNetwork = (com.tencent.e.i.d)this.pJo.aaBC;
      if (paramNetwork != null) {
        paramNetwork.cancel(true);
      }
      a.b((a.b)paramString3.aaBC);
      locale.bXZ();
      paramContext.bindProcessToNetwork(null);
      paramContext.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)this);
      AppMethodBeat.o(199532);
    }
    
    public final void onUnavailable()
    {
      AppMethodBeat.i(199527);
      super.onUnavailable();
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onUnavailable");
      com.tencent.e.i.d locald = (com.tencent.e.i.d)this.pJo.aaBC;
      if (locald != null) {
        locald.cancel(true);
      }
      a.b((a.b)paramString3.aaBC);
      locale.bXZ();
      AppMethodBeat.o(199527);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$listenerWrapper$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "called", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class e
    implements c.a
  {
    private final AtomicBoolean pJt;
    
    e(c.a parama)
    {
      AppMethodBeat.i(198938);
      this.pJt = new AtomicBoolean(false);
      AppMethodBeat.o(198938);
    }
    
    public final void bXY()
    {
      AppMethodBeat.i(198934);
      if (this.pJt.compareAndSet(false, true))
      {
        this.pJu.bXY();
        AppMethodBeat.o(198934);
        return;
      }
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectSuccess, already call");
      AppMethodBeat.o(198934);
    }
    
    public final void bXZ()
    {
      AppMethodBeat.i(198935);
      if (this.pJt.compareAndSet(false, true))
      {
        this.pJu.bXZ();
        AppMethodBeat.o(198935);
        return;
      }
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectFailure, already call");
      AppMethodBeat.o(198935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.c
 * JD-Core Version:    0.7.0.1
 */