package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> geL = com.tencent.mm.kernel.a.b.e.agf();
  private final HashSet<String> geM = new HashSet();
  
  public static void ah(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.afx().Z(paramClass);
  }
  
  protected static void qY(String paramString)
  {
    com.tencent.mm.kernel.g.afx().qP(paramString);
  }
  
  public boolean KD()
  {
    return true;
  }
  
  public void Kv()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu();
    double d2 = n.WO();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      ad.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.geL.init(i);
      c localc = c.afO();
      localc.geh.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.geg.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.gei.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, am.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.gei;
      ((com.tencent.mm.kernel.a.b.g)localObject).gfw = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).gfw;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).gcO.gea = new c.1(localc);
      com.tencent.mm.blink.a.oj("helloWeChat");
      return;
    }
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.geL.a(new e.b(), c.ger, c.afO().geh, "configure-functional plugins");
    com.tencent.mm.blink.a.oj("configurePlugins");
    paramg = new od();
    com.tencent.mm.sdk.b.a.ESL.l(paramg);
  }
  
  public final void afM()
  {
    com.tencent.mm.kernel.g.afx().aeX();
    this.geL.prepare();
    Iterator localIterator = this.geL.agh().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.afO().f(localc.cLz.getLooper());
    }
    com.tencent.mm.blink.a.oj("makeDependency");
  }
  
  public final void afN()
  {
    this.geL.a(new e.b(), c.ges, c.afO().geg, "task-functional plugins");
    com.tencent.mm.blink.a.oj("executeTasks");
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.h("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.agu())
    {
      localObject1 = c.afO();
      localObject2 = com.tencent.mm.kernel.g.afx().aeY().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).bs((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.afz().aeI()) {
        com.tencent.mm.kernel.g.afz().aey();
      }
    }
    com.tencent.mm.blink.a.oj("installPendingPlugins");
    long l = System.nanoTime();
    if (this.geM.size() > 0)
    {
      localObject1 = this.geM.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afx().w((String)localObject2, true);
      }
      this.geM.clear();
      com.tencent.mm.blink.a.p("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afx().aeX();
      com.tencent.mm.blink.a.oj("installPendingPlugins dependency made.");
      localObject1 = new oe();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    boolean bool = KD();
    int i;
    if ((paramg.agu()) && (com.tencent.mm.kernel.g.afz().aeI()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.afz().aeK();
      }
      paramg = com.tencent.mm.blink.b.SX();
      ad.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label297;
      }
      paramg.a(b.b.fia);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.afz().aeK();
      }
      com.tencent.mm.blink.a.oj("afterAccountInit");
      return;
      i = 0;
      break;
      label297:
      aq.n(new b.2(paramg), 1000L);
    }
  }
  
  protected final void qZ(String paramString)
  {
    this.geM.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */