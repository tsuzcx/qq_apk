package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> hsw = com.tencent.mm.kernel.a.b.e.aAL();
  private final HashSet<String> hsx = new HashSet();
  
  protected static void FW(String paramString)
  {
    com.tencent.mm.kernel.g.aAd().FO(paramString);
  }
  
  public static void al(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.aAd().ad(paramClass);
  }
  
  protected final void FX(String paramString)
  {
    this.hsx.add(paramString);
  }
  
  public void VZ()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      Log.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.hsw.init(i);
      c localc = c.aAu();
      localc.hrS.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.hrR.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.hrT.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, at.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.hrT;
      ((com.tencent.mm.kernel.a.b.g)localObject).hth = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).hth;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).hqy.hrL = new c.1(localc);
      com.tencent.mm.blink.a.CM("helloWeChat");
      return;
    }
  }
  
  public boolean Wm()
  {
    return true;
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.hsw.a(new e.b(), c.hsc, c.aAu().hrS, "configure-functional plugins");
    com.tencent.mm.blink.a.CM("configurePlugins");
    paramg = new po();
    EventCenter.instance.publish(paramg);
  }
  
  public final void aAs()
  {
    com.tencent.mm.kernel.g.aAd().azE();
    this.hsw.prepare();
    Iterator localIterator = this.hsw.aAN().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.aAu().f(localc.dli.getLooper());
    }
    com.tencent.mm.blink.a.CM("makeDependency");
  }
  
  public final void aAt()
  {
    this.hsw.a(new e.b(), c.hsd, c.aAu().hrR, "task-functional plugins");
    com.tencent.mm.blink.a.CM("executeTasks");
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.k("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.aBb())
    {
      localObject1 = c.aAu();
      localObject2 = com.tencent.mm.kernel.g.aAd().azF().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).bA((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.aAf().azp()) {
        com.tencent.mm.kernel.g.aAf().azf();
      }
    }
    com.tencent.mm.blink.a.CM("installPendingPlugins");
    long l = System.nanoTime();
    if (this.hsx.size() > 0)
    {
      localObject1 = this.hsx.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAd().x((String)localObject2, true);
      }
      this.hsx.clear();
      com.tencent.mm.blink.a.q("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAd().azE();
      com.tencent.mm.blink.a.CM("installPendingPlugins dependency made.");
      localObject1 = new pp();
      EventCenter.instance.publish((IEvent)localObject1);
    }
    boolean bool = Wm();
    int i;
    if ((paramg.aBb()) && (com.tencent.mm.kernel.g.aAf().azp()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.aAf().azr();
      }
      paramg = com.tencent.mm.blink.b.ake();
      Log.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label297;
      }
      paramg.a(b.b.gkQ);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.aAf().azr();
      }
      com.tencent.mm.blink.a.CM("afterAccountInit");
      return;
      i = 0;
      break;
      label297:
      MMHandlerThread.postToMainThreadDelayed(new b.2(paramg), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */