package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;

public final class b
{
  public static int FAILED = -1;
  public static int SUCCESS = 0;
  public int gQH;
  public String gQI = com.tencent.mm.compatible.util.e.dzB + "appbrand/";
  public SSLContext gQJ;
  public final String gQK;
  protected final ArrayList<String> gQL = new ArrayList();
  public final Map<String, ConcurrentLinkedQueue<Runnable>> gQM;
  public final ArrayList<com.tencent.mm.plugin.appbrand.o.a.b> gQN = new ArrayList();
  public c geu;
  
  public b(c paramc)
  {
    this.geu = paramc;
    paramc = (a)paramc.D(a.class);
    this.gQH = paramc.fQb;
    this.gQK = paramc.gQG;
    this.gQJ = j.a(paramc);
    if (this.gQH >= 0) {}
    for (int i = this.gQH;; i = 5)
    {
      this.gQM = new Hashtable(i);
      return;
    }
  }
  
  private void vo(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.gQN)
    {
      Iterator localIterator = this.gQN.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.o.a.b localb = (com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next();
        if (paramString.equals(localb.gep)) {
          this.gQN.remove(localb);
        }
      }
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.o.a.b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.gQL.add(paramb.gep);
    vo(paramb.gep);
    paramb.amP();
  }
  
  public final void vn(String paramString)
  {
    com.tencent.mm.sdk.f.e.post(new b.2(this, paramString), "appbrand_download_thread");
  }
  
  public final com.tencent.mm.plugin.appbrand.o.a.b vp(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    synchronized (this.gQN)
    {
      Iterator localIterator = this.gQN.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.o.a.b localb = (com.tencent.mm.plugin.appbrand.o.a.b)localIterator.next();
        if (paramString.equals(localb.gep)) {
          return localb;
        }
      }
    }
    return null;
  }
  
  public final boolean vq(String paramString)
  {
    return this.gQL.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.b
 * JD-Core Version:    0.7.0.1
 */