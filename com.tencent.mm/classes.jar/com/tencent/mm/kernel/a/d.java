package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> eJC = com.tencent.mm.kernel.a.b.e.So();
  private final HashSet<String> eJD = new HashSet();
  
  public static void K(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.RH().C(paramClass);
  }
  
  protected static void mG(String paramString)
  {
    com.tencent.mm.kernel.g.RH().mz(paramString);
  }
  
  public void Bc()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      ab.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.eJC.init(i);
      c localc = c.RX();
      localc.eIY.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.eIX.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.eIZ.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, aj.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.eIZ;
      ((com.tencent.mm.kernel.a.b.g)localObject).eKn = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).eKn;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).eHJ.eIR = new c.1(localc);
      com.tencent.mm.blink.a.ks("helloWeChat");
      return;
    }
  }
  
  public boolean Bf()
  {
    return true;
  }
  
  public final void RV()
  {
    com.tencent.mm.kernel.g.RH().Rh();
    this.eJC.prepare();
    Iterator localIterator = this.eJC.Sq().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.RX().d(localc.bYd.getLooper());
    }
    com.tencent.mm.blink.a.ks("makeDependency");
  }
  
  public final void RW()
  {
    this.eJC.a(new e.b(), c.eJj, c.RX().eIX, "task-functional plugins");
    com.tencent.mm.blink.a.ks("executeTasks");
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.eJC.a(new e.b(), c.eJi, c.RX().eIY, "configure-functional plugins");
    com.tencent.mm.blink.a.ks("configurePlugins");
    paramg = new mr();
    com.tencent.mm.sdk.b.a.ymk.l(paramg);
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.g("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.SD())
    {
      localObject1 = c.RX();
      localObject2 = com.tencent.mm.kernel.g.RH().Ri().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).aq((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.RJ().QU()) {
        com.tencent.mm.kernel.g.RJ().QL();
      }
    }
    com.tencent.mm.blink.a.ks("installPendingPlugins");
    long l = System.nanoTime();
    if (this.eJD.size() > 0)
    {
      localObject1 = this.eJD.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RH().v((String)localObject2, true);
      }
      this.eJD.clear();
      com.tencent.mm.blink.a.p("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RH().Rh();
      com.tencent.mm.blink.a.ks("installPendingPlugins dependency made.");
      localObject1 = new ms();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    boolean bool = Bf();
    int i;
    if ((paramg.SD()) && (com.tencent.mm.kernel.g.RJ().QU()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.RJ().QV();
      }
      paramg = com.tencent.mm.blink.b.HP();
      ab.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label297;
      }
      paramg.a(b.b.dYp);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.RJ().QV();
      }
      com.tencent.mm.blink.a.ks("afterAccountInit");
      return;
      i = 0;
      break;
      label297:
      al.p(new b.2(paramg), 1000L);
    }
  }
  
  protected final void mH(String paramString)
  {
    this.eJD.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */