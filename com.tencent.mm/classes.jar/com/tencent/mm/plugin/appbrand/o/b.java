package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class b
{
  public static int FAILED = -1;
  public static int SUCCESS = 0;
  public boolean kXC;
  public c kjg;
  protected final ArrayList<String> lVA;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> lVB;
  public final ArrayList<com.tencent.mm.plugin.appbrand.o.a.b> lVC;
  public int lVx;
  public String lVy;
  public SSLContext lVz;
  public final String luC;
  
  public b(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.lVy = (com.tencent.mm.loader.j.b.arX() + "appbrand/");
    this.kXC = false;
    this.lVA = new ArrayList();
    this.lVC = new ArrayList();
    this.kjg = paramc;
    paramc = (a)paramc.ar(a.class);
    this.lVx = paramc.cmO;
    this.luC = paramc.lVu;
    this.lVz = j.a(paramc);
    this.lVB = new Hashtable(10);
    this.kXC = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void vR(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.lVC)
    {
      Iterator localIterator = this.lVC.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.o.a.b localb = (com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next();
        if (paramString.equals(localb.iFB)) {
          this.lVC.remove(localb);
        }
      }
      AppMethodBeat.o(144304);
      return;
    }
  }
  
  public final void SE(final String paramString)
  {
    AppMethodBeat.i(144303);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144301);
        synchronized (b.a(b.this))
        {
          ConcurrentLinkedQueue localConcurrentLinkedQueue = (ConcurrentLinkedQueue)b.a(b.this).get(paramString);
          ad.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { paramString, Integer.valueOf(localConcurrentLinkedQueue.size()) });
          Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
          if (localRunnable != null)
          {
            localRunnable.run();
            localConcurrentLinkedQueue.poll();
            if (localConcurrentLinkedQueue.size() > 0)
            {
              ad.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
              b.b(b.this, paramString);
            }
          }
          AppMethodBeat.o(144301);
          return;
        }
      }
    }, "appbrand_download_thread");
    AppMethodBeat.o(144303);
  }
  
  public final com.tencent.mm.plugin.appbrand.o.a.b SF(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.lVC)
    {
      Iterator localIterator = this.lVC.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.o.a.b localb = (com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next();
        if (paramString.equals(localb.iFB))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean SG(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.lVA.contains(paramString);
    AppMethodBeat.o(144307);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.o.a.b paramb)
  {
    AppMethodBeat.i(144306);
    if (paramb == null)
    {
      AppMethodBeat.o(144306);
      return;
    }
    this.lVA.add(paramb.iFB);
    vR(paramb.iFB);
    paramb.btv();
    AppMethodBeat.o(144306);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187752);
    synchronized (this.lVC)
    {
      Iterator localIterator = this.lVC.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next()).isRunning = false;
      }
    }
    this.lVC.clear();
    AppMethodBeat.o(187752);
  }
  
  public static abstract interface a
  {
    public abstract void C(JSONObject paramJSONObject);
    
    public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap);
    
    public abstract void ae(int paramInt, String paramString);
    
    public abstract void g(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean aXU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.b
 * JD-Core Version:    0.7.0.1
 */