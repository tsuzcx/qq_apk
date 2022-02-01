package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
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
  public f rot;
  public final String sKB;
  public boolean sjY;
  public int tnk;
  public String tnl;
  public SSLContext tnm;
  protected final ArrayList<String> tnn;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> tno;
  public final ArrayList<com.tencent.mm.plugin.appbrand.t.a.b> tnp;
  
  public b(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.tnl = (com.tencent.mm.loader.i.b.bmC() + "appbrand/");
    this.sjY = false;
    this.tnn = new ArrayList();
    this.tnp = new ArrayList();
    this.rot = paramf;
    paramf = (a)paramf.aN(a.class);
    this.tnk = paramf.epJ;
    this.sKB = paramf.tnh;
    this.tnm = i.a(paramf);
    this.tno = new Hashtable(10);
    this.sjY = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void Em(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.tnp)
    {
      Iterator localIterator = this.tnp.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.t.a.b localb = (com.tencent.mm.plugin.appbrand.t.a.b)localIterator.next();
        if (paramString.equals(localb.ppa)) {
          this.tnp.remove(localb);
        }
      }
      AppMethodBeat.o(144304);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.t.a.b paramb)
  {
    AppMethodBeat.i(144306);
    if (paramb == null)
    {
      AppMethodBeat.o(144306);
      return;
    }
    this.tnn.add(paramb.ppa);
    Em(paramb.ppa);
    paramb.cCx();
    AppMethodBeat.o(144306);
  }
  
  public final void adS(final String paramString)
  {
    AppMethodBeat.i(144303);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144301);
        synchronized (b.a(b.this))
        {
          ConcurrentLinkedQueue localConcurrentLinkedQueue = (ConcurrentLinkedQueue)b.a(b.this).get(paramString);
          Log.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { paramString, Integer.valueOf(localConcurrentLinkedQueue.size()) });
          Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
          if (localRunnable != null)
          {
            localRunnable.run();
            localConcurrentLinkedQueue.poll();
            if (localConcurrentLinkedQueue.size() > 0)
            {
              Log.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
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
  
  public final com.tencent.mm.plugin.appbrand.t.a.b adT(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.tnp)
    {
      Iterator localIterator = this.tnp.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.t.a.b localb = (com.tencent.mm.plugin.appbrand.t.a.b)localIterator.next();
        if (paramString.equals(localb.ppa))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean adU(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.tnn.contains(paramString);
    AppMethodBeat.o(144307);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void X(JSONObject paramJSONObject);
    
    public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap);
    
    public abstract void at(int paramInt, String paramString);
    
    public abstract void j(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean cdJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b
 * JD-Core Version:    0.7.0.1
 */