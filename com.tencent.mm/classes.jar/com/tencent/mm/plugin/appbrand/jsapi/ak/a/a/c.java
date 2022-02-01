package com.tencent.mm.plugin.appbrand.jsapi.ak.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.net.NetworkSpecifier;
import android.net.wifi.WifiNetworkSpecifier.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl;", "", "()V", "TAG", "", "connectWifi", "", "context", "Landroid/content/Context;", "ssid", "bssid", "password", "timeoutMs", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "tryKeepConnectedWifi", "IListener", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c sOf;
  
  static
  {
    AppMethodBeat.i(325786);
    sOf = new c();
    AppMethodBeat.o(325786);
  }
  
  public static void a(final Context paramContext, String paramString1, final String paramString2, final String paramString3, long paramLong, final a parama)
  {
    AppMethodBeat.i(325780);
    s.u(parama, "listener");
    Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, ssid: " + paramString1 + ", bssid: " + paramString2 + ", timeoutMs: " + paramLong);
    parama = new d(parama);
    if (paramContext == null)
    {
      paramContext = null;
      if (!(paramContext instanceof ConnectivityManager)) {
        break label127;
      }
    }
    label127:
    for (paramContext = (ConnectivityManager)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        break label132;
      }
      Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connectivityManager is null");
      parama.cyp();
      AppMethodBeat.o(325780);
      return;
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null)
      {
        paramContext = null;
        break;
      }
      paramContext = paramContext.getSystemService("connectivity");
      break;
    }
    label132:
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connect params illegal");
      parama.cyp();
      AppMethodBeat.o(325780);
      return;
    }
    try
    {
      localObject1 = new WifiNetworkSpecifier.Builder();
      ((WifiNetworkSpecifier.Builder)localObject1).setSsid(paramString1);
    }
    catch (Exception paramContext)
    {
      int i;
      label208:
      label382:
      Log.w("MicroMsg.AppBrand.WifiConnector29Impl", s.X("connectWifi, build network specifier fail since ", paramContext));
      parama.cyp();
      AppMethodBeat.o(325780);
      return;
    }
    try
    {
      if (((CharSequence)paramString2).length() <= 0) {
        break label382;
      }
      i = 1;
      if (i != 0) {
        ((WifiNetworkSpecifier.Builder)localObject1).setBssid(MacAddress.fromString(paramString2));
      }
    }
    catch (Exception localException)
    {
      break label208;
    }
    if (((CharSequence)paramString3).length() > 0) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((WifiNetworkSpecifier.Builder)localObject1).setWpa2Passphrase(paramString3);
      }
      Object localObject2 = ((WifiNetworkSpecifier.Builder)localObject1).build();
      s.s(localObject2, "try {\n                Wi…     return\n            }");
      localObject1 = new ah.f();
      paramString3 = new ah.f();
      try
      {
        localObject2 = new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier((NetworkSpecifier)localObject2).build();
        paramString3.aqH = new b(paramString1, paramString2, (ah.f)localObject1, parama);
        paramString1 = new c((ah.f)localObject1, paramString3, parama, paramContext);
        if (-1L != paramLong) {
          ((ah.f)localObject1).aqH = h.ahAA.p(new c..ExternalSyntheticLambda0(paramContext, paramString1, parama), paramLong);
        }
        a.a((a.b)paramString3.aqH);
        paramContext.requestNetwork((NetworkRequest)localObject2, (ConnectivityManager.NetworkCallback)paramString1);
        AppMethodBeat.o(325780);
        return;
      }
      catch (Exception paramContext)
      {
        Log.w("MicroMsg.AppBrand.WifiConnector29Impl", s.X("connectWifi, fail since ", paramContext));
        paramContext = (d)((ah.f)localObject1).aqH;
        if (paramContext == null) {
          break label450;
        }
        paramContext.cancel(true);
        paramContext = (a.b)paramString3.aqH;
        if (paramContext == null) {
          break label466;
        }
        a.b(paramContext);
        parama.cyp();
        AppMethodBeat.o(325780);
        return;
      }
      i = 0;
      break;
    }
  }
  
  private static final void a(ConnectivityManager paramConnectivityManager, c paramc, d paramd)
  {
    AppMethodBeat.i(325784);
    s.u(paramc, "$callback");
    s.u(paramd, "$listenerWrapper");
    Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "timeout");
    paramConnectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)paramc);
    paramd.cyp();
    AppMethodBeat.o(325784);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void cyo();
    
    public abstract void cyp();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/ConnectWifiEvents$IListener;", "onConnect", "", "wiFiItem", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/WiFiItem;", "onConnectAcceptIncomplete", "onConnectInternal", "onDisconnect", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.b
  {
    b(String paramString1, String paramString2, ah.f<d<?>> paramf, c.d paramd) {}
    
    public final void a(e parame)
    {
      AppMethodBeat.i(325767);
      s.u(parame, "wiFiItem");
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnect#sysListener");
      AppMethodBeat.o(325767);
    }
    
    public final void b(e parame)
    {
      AppMethodBeat.i(325774);
      s.u(parame, "wiFiItem");
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectAcceptIncomplete#sysListener");
      if (Util.isEqual(this.sOg, parame.sNF)) {
        if (((CharSequence)paramString2).length() != 0) {
          break label117;
        }
      }
      label117:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (Util.isEqual(paramString2, parame.sNG)))
        {
          Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectInternal#sysListener, match");
          parame = (d)this.sOi.aqH;
          if (parame != null) {
            parame.cancel(true);
          }
          a.b((a.b)this);
          parama.cyo();
        }
        AppMethodBeat.o(325774);
        return;
      }
    }
    
    public final void onDisconnect() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$callback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ConnectivityManager.NetworkCallback
  {
    c(ah.f<d<?>> paramf, ah.f<a.b> paramf1, c.d paramd, ConnectivityManager paramConnectivityManager) {}
    
    public final void onAvailable(Network paramNetwork)
    {
      AppMethodBeat.i(325763);
      s.u(paramNetwork, "network");
      super.onAvailable(paramNetwork);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", s.X("onAvailable, network: ", paramNetwork));
      d locald = (d)this.sOi.aqH;
      if (locald != null) {
        locald.cancel(true);
      }
      a.b((a.b)paramString3.aqH);
      parama.cyo();
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", s.X("onAvailable, success: ", Boolean.valueOf(paramContext.bindProcessToNetwork(paramNetwork))));
      AppMethodBeat.o(325763);
    }
    
    public final void onLost(Network paramNetwork)
    {
      AppMethodBeat.i(325771);
      s.u(paramNetwork, "network");
      super.onLost(paramNetwork);
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", s.X("onLost, network: ", paramNetwork));
      paramNetwork = (d)this.sOi.aqH;
      if (paramNetwork != null) {
        paramNetwork.cancel(true);
      }
      a.b((a.b)paramString3.aqH);
      parama.cyp();
      paramContext.bindProcessToNetwork(null);
      paramContext.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)this);
      AppMethodBeat.o(325771);
    }
    
    public final void onUnavailable()
    {
      AppMethodBeat.i(325766);
      super.onUnavailable();
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onUnavailable");
      d locald = (d)this.sOi.aqH;
      if (locald != null) {
        locald.cancel(true);
      }
      a.b((a.b)paramString3.aqH);
      parama.cyp();
      AppMethodBeat.o(325766);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$listenerWrapper$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "called", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements c.a
  {
    private final AtomicBoolean stG;
    
    d(c.a parama)
    {
      AppMethodBeat.i(325761);
      this.stG = new AtomicBoolean(false);
      AppMethodBeat.o(325761);
    }
    
    public final void cyo()
    {
      AppMethodBeat.i(325764);
      if (this.stG.compareAndSet(false, true))
      {
        this.sOm.cyo();
        AppMethodBeat.o(325764);
        return;
      }
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectSuccess, already call");
      AppMethodBeat.o(325764);
    }
    
    public final void cyp()
    {
      AppMethodBeat.i(325769);
      if (this.stG.compareAndSet(false, true))
      {
        this.sOm.cyp();
        AppMethodBeat.o(325769);
        return;
      }
      Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectFailure, already call");
      AppMethodBeat.o(325769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.c
 * JD-Core Version:    0.7.0.1
 */