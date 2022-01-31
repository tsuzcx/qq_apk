package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.t.o;
import com.tencent.mm.plugin.appbrand.t.o.a;
import java.util.Iterator;
import java.util.LinkedList;

public class b<Service extends c>
  extends e<Service>
{
  private com.tencent.luggage.sdk.b.a.a.c bBj;
  private com.tencent.luggage.sdk.b.a.a.a bBk;
  volatile boolean bEC;
  private volatile boolean bED;
  private volatile boolean bEE;
  private final LinkedList<Runnable> bEF;
  
  public b(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(140735);
    this.bEC = false;
    this.bED = false;
    this.bEE = false;
    this.bEF = new LinkedList();
    AppMethodBeat.o(140735);
  }
  
  private void uX()
  {
    AppMethodBeat.i(140743);
    try
    {
      Object localObject = ((c)this.bDN).aAO();
      if (localObject == null)
      {
        AppMethodBeat.o(140743);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.i.n)((com.tencent.mm.plugin.appbrand.i.i)localObject).v(com.tencent.mm.plugin.appbrand.i.n.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.i.n)localObject).setThreadPriority(-2);
      }
      AppMethodBeat.o(140743);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.luggage.g.d.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(140743);
    }
  }
  
  private void wy()
  {
    AppMethodBeat.i(140746);
    if (this.bEC)
    {
      AppMethodBeat.o(140746);
      return;
    }
    if (this.bEE)
    {
      AppMethodBeat.o(140746);
      return;
    }
    ag.a(((c)this.bDN).wj(), ((c)this.bDN).aAO());
    String str = ax.c(((c)this.bDN).wj(), "app-service.js");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(140746);
      return;
    }
    long l = System.currentTimeMillis();
    o.a(((c)this.bDN).wj(), ((c)this.bDN).aAO(), "app-service.js", str, o.a.iXQ, new b.2(this, str, l));
    this.bEE = true;
    AppMethodBeat.o(140746);
  }
  
  private void wz()
  {
    AppMethodBeat.i(140747);
    if (!this.bED)
    {
      String str = wx();
      com.tencent.mm.plugin.appbrand.t.n.a(((c)this.bDN).aAO(), str, new b.3(this));
      long l = System.currentTimeMillis();
      str = ((c)this.bDN).asY().yl("WAService.js");
      o.a((r)this.bDN, ((c)this.bDN).aAO(), "WAService.js", "", "", str, o.a.iXP, new b.4(this, str, l));
      this.bED = true;
    }
    AppMethodBeat.o(140747);
  }
  
  protected a a(com.tencent.mm.plugin.appbrand.i.i parami, q paramq)
  {
    AppMethodBeat.i(140739);
    parami = new f((c)this.bDN, paramq);
    AppMethodBeat.o(140739);
    return parami;
  }
  
  protected void a(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(140740);
    uX();
    AppMethodBeat.o(140740);
  }
  
  protected final void bT(String arg1)
  {
    AppMethodBeat.i(140748);
    b.5 local5 = new b.5(this, ???);
    if (((c)this.bDN).isRunning())
    {
      local5.run();
      AppMethodBeat.o(140748);
      return;
    }
    synchronized (this.bEF)
    {
      this.bEF.add(local5);
      AppMethodBeat.o(140748);
      return;
    }
  }
  
  protected final void tW()
  {
    AppMethodBeat.i(140744);
    ((c)this.bDN).wF();
    wz();
    wy();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.bEF)
    {
      localLinkedList.addAll(this.bEF);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    ((c)this.bDN).auf();
    AppMethodBeat.o(140744);
  }
  
  protected void u(String paramString1, String paramString2) {}
  
  public final boolean uQ()
  {
    return this.bEC;
  }
  
  protected com.tencent.mm.plugin.appbrand.i.i uR()
  {
    AppMethodBeat.i(140736);
    com.tencent.mm.plugin.appbrand.i.c localc = new com.tencent.mm.plugin.appbrand.i.c(null, null);
    AppMethodBeat.o(140736);
    return localc;
  }
  
  protected void uS()
  {
    AppMethodBeat.i(140737);
    super.uS();
    com.tencent.mm.plugin.appbrand.i.i locali = ((c)this.bDN).aAO();
    Object localObject = (q)locali.v(q.class);
    if (localObject != null)
    {
      localObject = a(locali, (q)localObject);
      if (localObject != null)
      {
        locali.addJavascriptInterface(localObject, "WeixinJSContext");
        ((a)localObject).vl();
      }
    }
    for (this.bEC = true;; this.bEC = false)
    {
      locali.setJsExceptionHandler(new b.1(this, locali));
      this.bBj = new com.tencent.luggage.sdk.b.a.a.c();
      this.bBj.d(locali);
      this.bBk = new com.tencent.luggage.sdk.b.a.a.a();
      this.bBk.b(((c)this.bDN).aAO());
      AppMethodBeat.o(140737);
      return;
    }
  }
  
  protected void uT()
  {
    AppMethodBeat.i(140745);
    super.uT();
    if (this.bBj != null) {
      this.bBj.e(((c)this.bDN).aAO());
    }
    if (this.bBk != null) {
      this.bBk.c(((c)this.bDN).aAO());
    }
    AppMethodBeat.o(140745);
  }
  
  public final void vb()
  {
    AppMethodBeat.i(140741);
    super.vb();
    uX();
    AppMethodBeat.o(140741);
  }
  
  public final void vc()
  {
    AppMethodBeat.i(140742);
    super.vc();
    try
    {
      Object localObject = ((c)this.bDN).aAO();
      if (localObject == null)
      {
        AppMethodBeat.o(140742);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.i.n)((com.tencent.mm.plugin.appbrand.i.i)localObject).v(com.tencent.mm.plugin.appbrand.i.n.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.i.n)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(140742);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.luggage.g.d.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(140742);
    }
  }
  
  protected final void vj()
  {
    AppMethodBeat.i(140749);
    wz();
    AppMethodBeat.o(140749);
  }
  
  protected String wx()
  {
    AppMethodBeat.i(140738);
    String str = com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/android.js");
    AppMethodBeat.o(140738);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */