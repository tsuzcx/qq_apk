package com.tencent.mm.plugin.appbrand.t;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public enum o
{
  public final Map<b, NsdManager.DiscoveryListener> toE;
  
  static
  {
    AppMethodBeat.i(144459);
    toD = new o("INSTANCE");
    toF = new o[] { toD };
    AppMethodBeat.o(144459);
  }
  
  private o()
  {
    AppMethodBeat.i(144455);
    this.toE = new ConcurrentHashMap();
    AppMethodBeat.o(144455);
  }
  
  public static NsdManager cCu()
  {
    AppMethodBeat.i(144457);
    NsdManager localNsdManager = (NsdManager)MMApplicationContext.getContext().getSystemService("servicediscovery");
    AppMethodBeat.o(144457);
    return localNsdManager;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(144456);
    synchronized (this.toE)
    {
      if (!this.toE.containsKey(paramb))
      {
        AppMethodBeat.o(144456);
        return;
      }
      NsdManager localNsdManager = cCu();
      try
      {
        localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.toE.get(paramb));
        this.toE.remove(paramb);
        AppMethodBeat.o(144456);
        return;
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LocalServiceMgr", localThrowable, "Throwable: stopScanServices", new Object[0]);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(o.c paramc);
    
    public abstract void d(o.c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void a(o.c paramc);
    
    public abstract void b(o.c paramc);
    
    public abstract void cts();
    
    public abstract void ctt();
    
    public abstract void ctu();
    
    public abstract void ctv();
  }
  
  public static final class c
  {
    public String ip;
    public String nVK;
    public int port;
    public String serviceName;
    public Map<String, String> toM;
    
    public c()
    {
      AppMethodBeat.i(144452);
      this.toM = new HashMap();
      AppMethodBeat.o(144452);
    }
    
    c(NsdServiceInfo paramNsdServiceInfo)
    {
      AppMethodBeat.i(144451);
      this.toM = new HashMap();
      Object localObject = paramNsdServiceInfo.getHost();
      if (localObject != null) {
        this.ip = ((InetAddress)localObject).getHostAddress();
      }
      this.port = paramNsdServiceInfo.getPort();
      this.serviceName = paramNsdServiceInfo.getServiceName();
      this.nVK = paramNsdServiceInfo.getServiceType();
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
              this.toM.put(str, new String(Base64.encode(arrayOfByte, 2)));
            }
          }
        }
        AppMethodBeat.o(144451);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.o
 * JD-Core Version:    0.7.0.1
 */