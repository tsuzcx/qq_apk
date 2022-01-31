package com.tencent.mm.plugin.appbrand.o;

import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdServiceInfo;
import com.tencent.mm.sdk.platformtools.y;

public final class o$1
  implements NsdManager.DiscoveryListener
{
  public o$1(o paramo, o.b paramb) {}
  
  public final void onDiscoveryStarted(String paramString)
  {
    this.gRK.ajD();
    y.i("MicroMsg.LocalServiceMgr", "onDiscoveryStarted " + paramString);
  }
  
  public final void onDiscoveryStopped(String paramString)
  {
    this.gRK.ajE();
    y.i("MicroMsg.LocalServiceMgr", "onDiscoveryStopped " + paramString);
  }
  
  public final void onServiceFound(NsdServiceInfo paramNsdServiceInfo)
  {
    o.c localc = new o.c(paramNsdServiceInfo);
    this.gRK.a(localc);
    y.i("MicroMsg.LocalServiceMgr", "onServicesFound " + paramNsdServiceInfo.getServiceType());
  }
  
  public final void onServiceLost(NsdServiceInfo paramNsdServiceInfo)
  {
    this.gRK.b(new o.c(paramNsdServiceInfo));
    y.i("MicroMsg.LocalServiceMgr", "onServiceLost " + paramNsdServiceInfo.getServiceType());
  }
  
  public final void onStartDiscoveryFailed(String paramString, int paramInt)
  {
    this.gRK.ajB();
    y.i("MicroMsg.LocalServiceMgr", "onStartDiscoveryFailed " + paramString);
  }
  
  public final void onStopDiscoveryFailed(String paramString, int paramInt)
  {
    this.gRK.ajC();
    y.i("MicroMsg.LocalServiceMgr", "onStopDiscoveryFailed " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.o.1
 * JD-Core Version:    0.7.0.1
 */