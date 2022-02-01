package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.net.NetworkSpecifier;
import android.net.wifi.WifiNetworkSpecifier.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl;", "", "()V", "TAG", "", "connectWifi", "", "context", "Landroid/content/Context;", "ssid", "bssid", "password", "timeoutMs", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "tryKeepConnectedWifi", "IListener", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c
{
  public static final c mIv;
  
  static
  {
    AppMethodBeat.i(215140);
    mIv = new c();
    AppMethodBeat.o(215140);
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(215139);
    p.h(parama, "listener");
    Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, ssid: " + paramString1 + ", bssid: " + paramString2 + ", timeoutMs: 13000");
    c localc = new c(parama);
    if (paramContext != null)
    {
      parama = paramContext.getApplicationContext();
      if (parama != null)
      {
        parama = parama.getSystemService("connectivity");
        if ((parama instanceof ConnectivityManager)) {
          break label370;
        }
        parama = (a)localObject;
      }
    }
    label209:
    label370:
    for (;;)
    {
      parama = (ConnectivityManager)parama;
      if (parama == null)
      {
        Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connectivityManager is null");
        localc.bLO();
        AppMethodBeat.o(215139);
        return;
        parama = null;
        break;
      }
      if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
      {
        Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connect params illegal");
        localc.bLO();
        AppMethodBeat.o(215139);
        return;
      }
      try
      {
        localObject = new WifiNetworkSpecifier.Builder();
        ((WifiNetworkSpecifier.Builder)localObject).setSsid(paramString1);
      }
      catch (Exception paramContext)
      {
        int i;
        Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, build network specifier fail since ".concat(String.valueOf(paramContext)));
        localc.bLO();
        AppMethodBeat.o(215139);
        return;
      }
      try
      {
        if (((CharSequence)paramString2).length() <= 0) {
          break label301;
        }
        i = 1;
        if (i != 0) {
          ((WifiNetworkSpecifier.Builder)localObject).setBssid(MacAddress.fromString(paramString2));
        }
      }
      catch (Exception localException)
      {
        break label209;
      }
      if (((CharSequence)paramString3).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((WifiNetworkSpecifier.Builder)localObject).setWpa2Passphrase(paramString3);
        }
        localObject = ((WifiNetworkSpecifier.Builder)localObject).build();
        p.g(localObject, "try {\n                Wi…     return\n            }");
        try
        {
          parama.requestNetwork(new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier((NetworkSpecifier)localObject).build(), (ConnectivityManager.NetworkCallback)new b(localc, parama, paramContext, paramString1, paramString2, paramString3));
          AppMethodBeat.o(215139);
          return;
        }
        catch (Exception paramContext)
        {
          Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, fail since ".concat(String.valueOf(paramContext)));
          localc.bLO();
          AppMethodBeat.o(215139);
          return;
        }
        i = 0;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"})
  public static abstract interface a
  {
    public abstract void bLN();
    
    public abstract void bLO();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class b
    extends ConnectivityManager.NetworkCallback
  {
    b(c.c paramc, ConnectivityManager paramConnectivityManager, Context paramContext, String paramString1, String paramString2, String paramString3) {}
    
    public final void onAvailable(Network paramNetwork)
    {
      AppMethodBeat.i(215133);
      p.h(paramNetwork, "network");
      super.onAvailable(paramNetwork);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, network: ".concat(String.valueOf(paramNetwork)));
      this.mIw.bLN();
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, success: ".concat(String.valueOf(parama.bindProcessToNetwork(paramNetwork))));
      paramNetwork = c.mIv;
      c.d(paramContext, paramString1, paramString2, paramString3);
      AppMethodBeat.o(215133);
    }
    
    public final void onLost(Network paramNetwork)
    {
      AppMethodBeat.i(215135);
      p.h(paramNetwork, "network");
      super.onLost(paramNetwork);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onLost, network: ".concat(String.valueOf(paramNetwork)));
      this.mIw.bLO();
      parama.bindProcessToNetwork(null);
      parama.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)this);
      AppMethodBeat.o(215135);
    }
    
    public final void onUnavailable()
    {
      AppMethodBeat.i(215134);
      super.onUnavailable();
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onUnavailable");
      this.mIw.bLO();
      AppMethodBeat.o(215134);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$listenerWrapper$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "called", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class c
    implements c.a
  {
    private final AtomicBoolean mIB;
    
    c(c.a parama)
    {
      AppMethodBeat.i(215138);
      this.mIB = new AtomicBoolean(false);
      AppMethodBeat.o(215138);
    }
    
    public final void bLN()
    {
      AppMethodBeat.i(215136);
      if (this.mIB.compareAndSet(false, true))
      {
        this.mIC.bLN();
        AppMethodBeat.o(215136);
        return;
      }
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectSuccess, already call");
      AppMethodBeat.o(215136);
    }
    
    public final void bLO()
    {
      AppMethodBeat.i(215137);
      if (this.mIB.compareAndSet(false, true))
      {
        this.mIC.bLO();
        AppMethodBeat.o(215137);
        return;
      }
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectFailure, already call");
      AppMethodBeat.o(215137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c
 * JD-Core Version:    0.7.0.1
 */