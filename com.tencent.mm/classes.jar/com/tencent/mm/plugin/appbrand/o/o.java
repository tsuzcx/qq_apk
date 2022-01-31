package com.tencent.mm.plugin.appbrand.o;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum o
{
  public final Map<o.b, NsdManager.DiscoveryListener> gRI = new ConcurrentHashMap();
  
  private o() {}
  
  public static NsdManager amO()
  {
    return (NsdManager)ae.getContext().getSystemService("servicediscovery");
  }
  
  public final void a(o.b paramb)
  {
    NsdManager localNsdManager;
    synchronized (this.gRI)
    {
      if (!this.gRI.containsKey(paramb)) {
        return;
      }
      localNsdManager = amO();
    }
    try
    {
      localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.gRI.get(paramb));
      label44:
      this.gRI.remove(paramb);
      return;
      paramb = finally;
      throw paramb;
    }
    catch (Throwable localThrowable)
    {
      break label44;
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(o.c paramc);
    
    public abstract void d(o.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.o
 * JD-Core Version:    0.7.0.1
 */