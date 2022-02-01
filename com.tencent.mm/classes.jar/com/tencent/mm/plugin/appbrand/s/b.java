package com.tencent.mm.plugin.appbrand.s;

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
  public f lqg;
  public final String mGo;
  public boolean mgB;
  public int nhP;
  public String nhQ;
  public SSLContext nhR;
  protected final ArrayList<String> nhS;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> nhT;
  public final ArrayList<com.tencent.mm.plugin.appbrand.s.a.b> nhU;
  
  public b(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(144302);
    this.nhQ = (com.tencent.mm.loader.j.b.aKM() + "appbrand/");
    this.mgB = false;
    this.nhS = new ArrayList();
    this.nhU = new ArrayList();
    this.lqg = paramf;
    paramf = (a)paramf.av(a.class);
    this.nhP = paramf.cyM;
    this.mGo = paramf.nhM;
    this.nhR = j.a(paramf);
    this.nhT = new Hashtable(10);
    this.mgB = paramBoolean;
    AppMethodBeat.o(144302);
  }
  
  private void EN(String paramString)
  {
    AppMethodBeat.i(144304);
    if (paramString == null)
    {
      AppMethodBeat.o(144304);
      return;
    }
    synchronized (this.nhU)
    {
      Iterator localIterator = this.nhU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.s.a.b localb = (com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next();
        if (paramString.equals(localb.jEY)) {
          this.nhU.remove(localb);
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
    this.nhS.add(paramb.jEY);
    EN(paramb.jEY);
    paramb.bPN();
    AppMethodBeat.o(144306);
  }
  
  public final void acR(final String paramString)
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
  
  public final com.tencent.mm.plugin.appbrand.s.a.b acS(String paramString)
  {
    AppMethodBeat.i(144305);
    if (paramString == null)
    {
      AppMethodBeat.o(144305);
      return null;
    }
    synchronized (this.nhU)
    {
      Iterator localIterator = this.nhU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.s.a.b localb = (com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next();
        if (paramString.equals(localb.jEY))
        {
          AppMethodBeat.o(144305);
          return localb;
        }
      }
      AppMethodBeat.o(144305);
      return null;
    }
  }
  
  public final boolean acT(String paramString)
  {
    AppMethodBeat.i(144307);
    boolean bool = this.nhS.contains(paramString);
    AppMethodBeat.o(144307);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void J(JSONObject paramJSONObject);
    
    public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap);
    
    public abstract void ah(int paramInt, String paramString);
    
    public abstract void h(int paramInt, long paramLong1, long paramLong2);
  }
  
  public static abstract interface b
  {
    public abstract boolean btA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b
 * JD-Core Version:    0.7.0.1
 */