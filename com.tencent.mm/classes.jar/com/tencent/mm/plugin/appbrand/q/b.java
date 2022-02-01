package com.tencent.mm.plugin.appbrand.q;

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
  public c joJ;
  public int kUA;
  public String kUB;
  public SSLContext kUC;
  protected final ArrayList<String> kUD;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> kUE;
  public final ArrayList<com.tencent.mm.plugin.appbrand.q.a.b> kUF;
  public boolean kaI;
  public final String kwo;
  
  public b(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.kUB = (com.tencent.mm.loader.j.b.aij() + "appbrand/");
    this.kaI = false;
    this.kUD = new ArrayList();
    this.kUF = new ArrayList();
    this.joJ = paramc;
    paramc = (a)paramc.ar(a.class);
    this.kUA = paramc.cfA;
    this.kwo = paramc.kUx;
    this.kUC = j.a(paramc);
    this.kUE = new Hashtable(10);
    this.kaI = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void pR(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.kUF)
    {
      Iterator localIterator = this.kUF.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.q.a.b localb = (com.tencent.mm.plugin.appbrand.q.a.b)localIterator.next();
        if (paramString.equals(localb.hLO)) {
          this.kUF.remove(localb);
        }
      }
      AppMethodBeat.o(144304);
      return;
    }
  }
  
  public final void KU(final String paramString)
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
  
  public final com.tencent.mm.plugin.appbrand.q.a.b KV(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.kUF)
    {
      Iterator localIterator = this.kUF.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.q.a.b localb = (com.tencent.mm.plugin.appbrand.q.a.b)localIterator.next();
        if (paramString.equals(localb.hLO))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean KW(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.kUD.contains(paramString);
    AppMethodBeat.o(144307);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.q.a.b paramb)
  {
    AppMethodBeat.i(144306);
    if (paramb == null)
    {
      AppMethodBeat.o(144306);
      return;
    }
    this.kUD.add(paramb.hLO);
    pR(paramb.hLO);
    paramb.biC();
    AppMethodBeat.o(144306);
  }
  
  public final void release()
  {
    AppMethodBeat.i(190829);
    synchronized (this.kUF)
    {
      Iterator localIterator = this.kUF.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.q.a.b)localIterator.next()).isRunning = false;
      }
    }
    this.kUF.clear();
    AppMethodBeat.o(190829);
  }
  
  public static abstract interface a
  {
    public abstract void C(JSONObject paramJSONObject);
    
    public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap);
    
    public abstract void ab(int paramInt, String paramString);
    
    public abstract void g(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean aNS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b
 * JD-Core Version:    0.7.0.1
 */