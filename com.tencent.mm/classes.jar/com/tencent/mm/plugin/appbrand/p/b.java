package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
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
  public c jOV;
  public boolean kBv;
  public final String kXC;
  public int lwk;
  public String lwl;
  public SSLContext lwm;
  protected final ArrayList<String> lwn;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> lwo;
  public final ArrayList<com.tencent.mm.plugin.appbrand.p.a.b> lwp;
  
  public b(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.lwl = (com.tencent.mm.loader.j.b.apj() + "appbrand/");
    this.kBv = false;
    this.lwn = new ArrayList();
    this.lwp = new ArrayList();
    this.jOV = paramc;
    paramc = (a)paramc.ar(a.class);
    this.lwk = paramc.ccx;
    this.kXC = paramc.lwh;
    this.lwm = j.a(paramc);
    this.lwo = new Hashtable(10);
    this.kBv = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void tc(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.lwp)
    {
      Iterator localIterator = this.lwp.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.p.a.b localb = (com.tencent.mm.plugin.appbrand.p.a.b)localIterator.next();
        if (paramString.equals(localb.imk)) {
          this.lwp.remove(localb);
        }
      }
      AppMethodBeat.o(144304);
      return;
    }
  }
  
  public final void Pc(final String paramString)
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
          ac.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { paramString, Integer.valueOf(localConcurrentLinkedQueue.size()) });
          Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
          if (localRunnable != null)
          {
            localRunnable.run();
            localConcurrentLinkedQueue.poll();
            if (localConcurrentLinkedQueue.size() > 0)
            {
              ac.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
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
  
  public final com.tencent.mm.plugin.appbrand.p.a.b Pd(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.lwp)
    {
      Iterator localIterator = this.lwp.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.p.a.b localb = (com.tencent.mm.plugin.appbrand.p.a.b)localIterator.next();
        if (paramString.equals(localb.imk))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean Pe(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.lwn.contains(paramString);
    AppMethodBeat.o(144307);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.p.a.b paramb)
  {
    AppMethodBeat.i(144306);
    if (paramb == null)
    {
      AppMethodBeat.o(144306);
      return;
    }
    this.lwn.add(paramb.imk);
    tc(paramb.imk);
    paramb.bpw();
    AppMethodBeat.o(144306);
  }
  
  public final void release()
  {
    AppMethodBeat.i(199908);
    synchronized (this.lwp)
    {
      Iterator localIterator = this.lwp.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.p.a.b)localIterator.next()).isRunning = false;
      }
    }
    this.lwp.clear();
    AppMethodBeat.o(199908);
  }
  
  public static abstract interface a
  {
    public abstract void C(JSONObject paramJSONObject);
    
    public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap);
    
    public abstract void ac(int paramInt, String paramString);
    
    public abstract void g(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean aUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.b
 * JD-Core Version:    0.7.0.1
 */