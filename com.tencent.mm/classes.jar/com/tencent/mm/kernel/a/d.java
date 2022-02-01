package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> gDb = com.tencent.mm.kernel.a.b.e.akg();
  private final HashSet<String> gDc = new HashSet();
  
  public static void ah(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.ajy().Z(paramClass);
  }
  
  protected static void xd(String paramString)
  {
    com.tencent.mm.kernel.g.ajy().wU(paramString);
  }
  
  public void LE()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      ad.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.gDb.init(i);
      c localc = c.ajP();
      localc.gCx.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.gCw.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.gCy.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, an.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.gCy;
      ((com.tencent.mm.kernel.a.b.g)localObject).gDM = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).gDM;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).gBe.gCq = new c.1(localc);
      com.tencent.mm.blink.a.ub("helloWeChat");
      return;
    }
  }
  
  public boolean LR()
  {
    return true;
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.gDb.a(new e.b(), c.gCH, c.ajP().gCx, "configure-functional plugins");
    com.tencent.mm.blink.a.ub("configurePlugins");
    paramg = new ov();
    com.tencent.mm.sdk.b.a.IbL.l(paramg);
  }
  
  public final void ajN()
  {
    com.tencent.mm.kernel.g.ajy().aiZ();
    this.gDb.prepare();
    Iterator localIterator = this.gDb.aki().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.ajP().f(localc.cTP.getLooper());
    }
    com.tencent.mm.blink.a.ub("makeDependency");
  }
  
  public final void ajO()
  {
    this.gDb.a(new e.b(), c.gCI, c.ajP().gCw, "task-functional plugins");
    com.tencent.mm.blink.a.ub("executeTasks");
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.k("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.akw())
    {
      localObject1 = c.ajP();
      localObject2 = com.tencent.mm.kernel.g.ajy().aja().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).br((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.ajA().aiK()) {
        com.tencent.mm.kernel.g.ajA().aiA();
      }
    }
    com.tencent.mm.blink.a.ub("installPendingPlugins");
    long l = System.nanoTime();
    if (this.gDc.size() > 0)
    {
      localObject1 = this.gDc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajy().w((String)localObject2, true);
      }
      this.gDc.clear();
      com.tencent.mm.blink.a.p("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajy().aiZ();
      com.tencent.mm.blink.a.ub("installPendingPlugins dependency made.");
      localObject1 = new ow();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    boolean bool = LR();
    int i;
    if ((paramg.akw()) && (com.tencent.mm.kernel.g.ajA().aiK()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.ajA().aiM();
      }
      paramg = com.tencent.mm.blink.b.Wi();
      ad.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label297;
      }
      paramg.a(b.b.fDC);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.ajA().aiM();
      }
      com.tencent.mm.blink.a.ub("afterAccountInit");
      return;
      i = 0;
      break;
      label297:
      aq.o(new b.2(paramg), 1000L);
    }
  }
  
  protected final void xe(String paramString)
  {
    this.gDc.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */