package com.tencent.mm.plugin.appbrand.o;

import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;

public final class o$2
  implements NsdManager.ResolveListener
{
  public o$2(o paramo, o.a parama) {}
  
  public final void onResolveFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt)
  {
    this.gRM.c(new o.c(paramNsdServiceInfo));
  }
  
  public final void onServiceResolved(NsdServiceInfo paramNsdServiceInfo)
  {
    this.gRM.d(new o.c(paramNsdServiceInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.o.2
 * JD-Core Version:    0.7.0.1
 */