package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
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
  public c kmw;
  public boolean lbl;
  public final String lza;
  public int maa;
  public String mab;
  public SSLContext mad;
  protected final ArrayList<String> mae;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> maf;
  public final ArrayList<com.tencent.mm.plugin.appbrand.o.a.b> mag;
  
  public b(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.mab = (com.tencent.mm.loader.j.b.asm() + "appbrand/");
    this.lbl = false;
    this.mae = new ArrayList();
    this.mag = new ArrayList();
    this.kmw = paramc;
    paramc = (a)paramc.ar(a.class);
    this.maa = paramc.cmQ;
    this.lza = paramc.lZX;
    this.mad = j.a(paramc);
    this.maf = new Hashtable(10);
    this.lbl = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void wy(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.mag)
    {
      Iterator localIterator = this.mag.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.o.a.b localb = (com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next();
        if (paramString.equals(localb.iIu)) {
          this.mag.remove(localb);
        }
      }
      AppMethodBeat.o(144304);
      return;
    }
  }
  
  public final void Tn(final String paramString)
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
          ae.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { paramString, Integer.valueOf(localConcurrentLinkedQueue.size()) });
          Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
          if (localRunnable != null)
          {
            localRunnable.run();
            localConcurrentLinkedQueue.poll();
            if (localConcurrentLinkedQueue.size() > 0)
            {
              ae.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
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
  
  public final com.tencent.mm.plugin.appbrand.o.a.b To(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.mag)
    {
      Iterator localIterator = this.mag.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.o.a.b localb = (com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next();
        if (paramString.equals(localb.iIu))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean Tp(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.mae.contains(paramString);
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
    this.mae.add(paramb.iIu);
    wy(paramb.iIu);
    paramb.bug();
    AppMethodBeat.o(144306);
  }
  
  public final void release()
  {
    AppMethodBeat.i(193481);
    synchronized (this.mag)
    {
      Iterator localIterator = this.mag.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next()).isRunning = false;
      }
    }
    this.mag.clear();
    AppMethodBeat.o(193481);
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
    public abstract boolean aYn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.b
 * JD-Core Version:    0.7.0.1
 */