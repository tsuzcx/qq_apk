package com.tencent.mm.plugin.appbrand.p;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
  public final Map<b, NsdManager.DiscoveryListener> lxw;
  
  static
  {
    AppMethodBeat.i(144459);
    lxv = new p("INSTANCE");
    lxx = new p[] { lxv };
    AppMethodBeat.o(144459);
  }
  
  private p()
  {
    AppMethodBeat.i(144455);
    this.lxw = new ConcurrentHashMap();
    AppMethodBeat.o(144455);
  }
  
  public static NsdManager bpt()
  {
    AppMethodBeat.i(144457);
    NsdManager localNsdManager = (NsdManager)ai.getContext().getSystemService("servicediscovery");
    AppMethodBeat.o(144457);
    return localNsdManager;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(144456);
    synchronized (this.lxw)
    {
      if (!this.lxw.containsKey(paramb))
      {
        AppMethodBeat.o(144456);
        return;
      }
      NsdManager localNsdManager = bpt();
      try
      {
        localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.lxw.get(paramb));
        this.lxw.remove(paramb);
        AppMethodBeat.o(144456);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LocalServiceMgr", localThrowable, "Throwable: stopScanServices", new Object[0]);
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
    
    public abstract void bhP();
    
    public abstract void bhQ();
    
    public abstract void bhR();
    
    public abstract void bhS();
  }
  
  public static final class c
  {
    public String hlM;
    public String ip;
    public Map<String, String> lxE;
    public String lxF;
    public int port;
    
    public c()
    {
      AppMethodBeat.i(144452);
      this.lxE = new HashMap();
      AppMethodBeat.o(144452);
    }
    
    @TargetApi(21)
    c(NsdServiceInfo paramNsdServiceInfo)
    {
      AppMethodBeat.i(144451);
      this.lxE = new HashMap();
      Object localObject = paramNsdServiceInfo.getHost();
      if (localObject != null) {
        this.ip = ((InetAddress)localObject).getHostAddress();
      }
      this.port = paramNsdServiceInfo.getPort();
      this.lxF = paramNsdServiceInfo.getServiceName();
      this.hlM = paramNsdServiceInfo.getServiceType();
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
              this.lxE.put(str, new String(Base64.encode(arrayOfByte, 2)));
            }
          }
        }
        AppMethodBeat.o(144451);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.p
 * JD-Core Version:    0.7.0.1
 */