package com.tencent.mm.plugin.appbrand.m;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdServiceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public enum p
{
  public final Map<p.b, NsdManager.DiscoveryListener> itx;
  
  static
  {
    AppMethodBeat.i(108278);
    itw = new p("INSTANCE");
    ity = new p[] { itw };
    AppMethodBeat.o(108278);
  }
  
  private p()
  {
    AppMethodBeat.i(108274);
    this.itx = new ConcurrentHashMap();
    AppMethodBeat.o(108274);
  }
  
  public static NsdManager aIu()
  {
    AppMethodBeat.i(108276);
    NsdManager localNsdManager = (NsdManager)ah.getContext().getSystemService("servicediscovery");
    AppMethodBeat.o(108276);
    return localNsdManager;
  }
  
  public final void a(p.b paramb)
  {
    AppMethodBeat.i(108275);
    synchronized (this.itx)
    {
      if (!this.itx.containsKey(paramb))
      {
        AppMethodBeat.o(108275);
        return;
      }
      NsdManager localNsdManager = aIu();
      try
      {
        localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.itx.get(paramb));
        this.itx.remove(paramb);
        AppMethodBeat.o(108275);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.LocalServiceMgr", localThrowable, "Throwable: stopScanServices", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.p
 * JD-Core Version:    0.7.0.1
 */