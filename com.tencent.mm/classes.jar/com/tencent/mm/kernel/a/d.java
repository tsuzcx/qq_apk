package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.h.a.ma;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> dMb = com.tencent.mm.kernel.a.b.e.Ek();
  private final HashSet<String> dMc = new HashSet();
  
  public static void gl(String paramString)
  {
    com.tencent.mm.kernel.g.DL().gf(paramString);
  }
  
  public static void x(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.DL().p(paramClass);
  }
  
  public final void DW()
  {
    com.tencent.mm.kernel.g.DL().Dp();
    this.dMb.prepare();
    Iterator localIterator = this.dMb.Em().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.DY().b(localc.bwv.getLooper());
    }
    com.tencent.mm.blink.a.el("makeDependency");
  }
  
  public final void DX()
  {
    this.dMb.a(new e.b(), c.dLJ, c.DY().dLy, "task-functional plugins");
    com.tencent.mm.blink.a.el("executeTasks");
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.dMb.a(new e.b(), c.dLI, c.DY().dLz, "configure-functional plugins");
    com.tencent.mm.blink.a.el("configurePlugins");
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.j("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.Ex())
    {
      localObject1 = c.DY();
      localObject2 = com.tencent.mm.kernel.g.DL().Dq().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).ah((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.DN().Dc()) {
        com.tencent.mm.kernel.g.DN().CS();
      }
    }
    com.tencent.mm.blink.a.el("installPendingPlugins");
    long l = System.nanoTime();
    if (this.dMc.size() > 0)
    {
      localObject1 = this.dMc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DL().r((String)localObject2, true);
      }
      this.dMc.clear();
      com.tencent.mm.blink.a.h("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DL().Dp();
      com.tencent.mm.blink.a.el("installPendingPlugins dependency made.");
      localObject1 = new ma();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    boolean bool = sM();
    int i;
    if ((paramg.Ex()) && (com.tencent.mm.kernel.g.DN().Dc()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.DN().Dd();
      }
      paramg = com.tencent.mm.blink.b.vG();
      y.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label291;
      }
      paramg.a(b.b.dhd);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.DN().Dd();
      }
      com.tencent.mm.blink.a.el("afterAccountInit");
      return;
      i = 0;
      break;
      label291:
      com.tencent.mm.sdk.platformtools.ai.l(new b.2(paramg), 1000L);
    }
  }
  
  public final void gm(String paramString)
  {
    this.dMc.add(paramString);
  }
  
  public void sJ()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      y.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.dMb.init(i);
      c localc = c.DY();
      localc.dLz.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.dLy.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.dLA.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, com.tencent.mm.model.ai.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.dLA;
      ((com.tencent.mm.kernel.a.b.g)localObject).dML = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).dML;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).dKl.dLt = new c.1(localc);
      com.tencent.mm.blink.a.el("helloWeChat");
      return;
    }
  }
  
  public boolean sM()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */