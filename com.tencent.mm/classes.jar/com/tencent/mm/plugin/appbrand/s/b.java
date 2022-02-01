package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
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
  public e okQ;
  public final String pFt;
  public boolean peH;
  public SSLContext qiA;
  protected final ArrayList<String> qiB;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> qiC;
  public final ArrayList<com.tencent.mm.plugin.appbrand.s.a.b> qiD;
  public int qiy;
  public String qiz;
  
  public b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.qiz = (com.tencent.mm.loader.j.b.aSO() + "appbrand/");
    this.peH = false;
    this.qiB = new ArrayList();
    this.qiD = new ArrayList();
    this.okQ = parame;
    parame = (a)parame.au(a.class);
    this.qiy = parame.cxr;
    this.pFt = parame.qiv;
    this.qiA = j.a(parame);
    this.qiC = new Hashtable(10);
    this.peH = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void LG(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.qiD)
    {
      Iterator localIterator = this.qiD.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.s.a.b localb = (com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next();
        if (paramString.equals(localb.mvB)) {
          this.qiD.remove(localb);
        }
      }
      AppMethodBeat.o(144304);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.s.a.b paramb)
  {
    AppMethodBeat.i(144306);
    if (paramb == null)
    {
      AppMethodBeat.o(144306);
      return;
    }
    this.qiB.add(paramb.mvB);
    LG(paramb.mvB);
    paramb.cce();
    AppMethodBeat.o(144306);
  }
  
  public final void akL(final String paramString)
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
  
  public final com.tencent.mm.plugin.appbrand.s.a.b akM(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.qiD)
    {
      Iterator localIterator = this.qiD.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.s.a.b localb = (com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next();
        if (paramString.equals(localb.mvB))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean akN(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.qiB.contains(paramString);
    AppMethodBeat.o(144307);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void M(JSONObject paramJSONObject);
    
    public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap);
    
    public abstract void aj(int paramInt, String paramString);
    
    public abstract void j(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean bEx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b
 * JD-Core Version:    0.7.0.1
 */