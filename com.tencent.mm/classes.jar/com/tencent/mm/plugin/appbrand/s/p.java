package com.tencent.mm.plugin.appbrand.s;

import android.annotation.TargetApi;
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

public enum p
{
  public final Map<b, NsdManager.DiscoveryListener> njd;
  
  static
  {
    AppMethodBeat.i(144459);
    njc = new p("INSTANCE");
    nje = new p[] { njc };
    AppMethodBeat.o(144459);
  }
  
  private p()
  {
    AppMethodBeat.i(144455);
    this.njd = new ConcurrentHashMap();
    AppMethodBeat.o(144455);
  }
  
  public static NsdManager bPK()
  {
    AppMethodBeat.i(144457);
    NsdManager localNsdManager = (NsdManager)MMApplicationContext.getContext().getSystemService("servicediscovery");
    AppMethodBeat.o(144457);
    return localNsdManager;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(144456);
    synchronized (this.njd)
    {
      if (!this.njd.containsKey(paramb))
      {
        AppMethodBeat.o(144456);
        return;
      }
      NsdManager localNsdManager = bPK();
      try
      {
        localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.njd.get(paramb));
        this.njd.remove(paramb);
        AppMethodBeat.o(144456);
        return;
      }
      catch (Throwable localThrowable)
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
    public abstract void c(p.c paramc);
    
    public abstract void d(p.c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void a(p.c paramc);
    
    public abstract void b(p.c paramc);
    
    public abstract void bHE();
    
    public abstract void bHF();
    
    public abstract void bHG();
    
    public abstract void bHH();
  }
  
  public static final class c
  {
    public String iBb;
    public String ip;
    public Map<String, String> njl;
    public int port;
    public String serviceName;
    
    public c()
    {
      AppMethodBeat.i(144452);
      this.njl = new HashMap();
      AppMethodBeat.o(144452);
    }
    
    @TargetApi(21)
    c(NsdServiceInfo paramNsdServiceInfo)
    {
      AppMethodBeat.i(144451);
      this.njl = new HashMap();
      Object localObject = paramNsdServiceInfo.getHost();
      if (localObject != null) {
        this.ip = ((InetAddress)localObject).getHostAddress();
      }
      this.port = paramNsdServiceInfo.getPort();
      this.serviceName = paramNsdServiceInfo.getServiceName();
      this.iBb = paramNsdServiceInfo.getServiceType();
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
              this.njl.put(str, new String(Base64.encode(arrayOfByte, 2)));
            }
          }
        }
        AppMethodBeat.o(144451);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.p
 * JD-Core Version:    0.7.0.1
 */