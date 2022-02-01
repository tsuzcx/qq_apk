package com.tencent.mm.plugin.appbrand.q;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public enum p
{
  public final Map<b, NsdManager.DiscoveryListener> kVM;
  
  static
  {
    AppMethodBeat.i(144459);
    kVL = new p("INSTANCE");
    kVN = new p[] { kVL };
    AppMethodBeat.o(144459);
  }
  
  private p()
  {
    AppMethodBeat.i(144455);
    this.kVM = new ConcurrentHashMap();
    AppMethodBeat.o(144455);
  }
  
  public static NsdManager biz()
  {
    AppMethodBeat.i(144457);
    NsdManager localNsdManager = (NsdManager)aj.getContext().getSystemService("servicediscovery");
    AppMethodBeat.o(144457);
    return localNsdManager;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(144456);
    synchronized (this.kVM)
    {
      if (!this.kVM.containsKey(paramb))
      {
        AppMethodBeat.o(144456);
        return;
      }
      NsdManager localNsdManager = biz();
      try
      {
        localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.kVM.get(paramb));
        this.kVM.remove(paramb);
        AppMethodBeat.o(144456);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.LocalServiceMgr", localThrowable, "Throwable: stopScanServices", new Object[0]);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(p.c paramc);
    
    public abstract void d(p.c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void a(p.c paramc);
    
    public abstract void b(p.c paramc);
    
    public abstract void baX();
    
    public abstract void baY();
    
    public abstract void baZ();
    
    public abstract void bba();
  }
  
  public static final class c
  {
    public String gLm;
    public String ip;
    public Map<String, String> kVU;
    public String kVV;
    public int port;
    
    public c()
    {
      AppMethodBeat.i(144452);
      this.kVU = new HashMap();
      AppMethodBeat.o(144452);
    }
    
    @TargetApi(21)
    c(NsdServiceInfo paramNsdServiceInfo)
    {
      AppMethodBeat.i(144451);
      this.kVU = new HashMap();
      Object localObject = paramNsdServiceInfo.getHost();
      if (localObject != null) {
        this.ip = ((InetAddress)localObject).getHostAddress();
      }
      this.port = paramNsdServiceInfo.getPort();
      this.kVV = paramNsdServiceInfo.getServiceName();
      this.gLm = paramNsdServiceInfo.getServiceType();
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramNsdServiceInfo = paramNsdServiceInfo.getAttributes();; paramNsdServiceInfo = null)
      {
        if (paramNsdServiceInfo != null)
        {
          localObject = paramNsdServiceInfo.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            byte[] arrayOfByte = (byte[])paramNsdServiceInfo.get(str);
            if (arrayOfByte != null) {
              this.kVU.put(str, new String(Base64.encode(arrayOfByte, 2)));
            }
          }
        }
        AppMethodBeat.o(144451);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.p
 * JD-Core Version:    0.7.0.1
 */