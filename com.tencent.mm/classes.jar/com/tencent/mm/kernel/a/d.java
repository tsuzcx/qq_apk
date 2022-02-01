package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.f.a.qm;
import com.tencent.mm.f.a.qn;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
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
  public com.tencent.mm.kernel.a.b.e<Object> ker = com.tencent.mm.kernel.a.b.e.aIo();
  private final HashSet<String> kes = new HashSet();
  
  protected static void MW(String paramString)
  {
    com.tencent.mm.kernel.h.aHC().MO(paramString);
  }
  
  public static void ak(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.h.aHC().ac(paramClass);
  }
  
  protected final void MX(String paramString)
  {
    this.kes.add(paramString);
  }
  
  public void a(g paramg)
  {
    this.ker.a(new e.b(), c.kdX, c.aHV().kdN, "configure-functional plugins");
    com.tencent.mm.blink.a.JB("configurePlugins");
    paramg = new qm();
    EventCenter.instance.publish(paramg);
  }
  
  public final void aHT()
  {
    com.tencent.mm.kernel.h.aHC().aHd();
    this.ker.prepare();
    Iterator localIterator = this.ker.aIq().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.aHV().g(localc.fcO.getLooper());
    }
    com.tencent.mm.blink.a.JB("makeDependency");
  }
  
  public final void aHU()
  {
    this.ker.a(new e.b(), c.kdY, c.aHV().kdM, "task-functional plugins");
    com.tencent.mm.blink.a.JB("executeTasks");
  }
  
  public boolean aaI()
  {
    return true;
  }
  
  public void aau()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      Log.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.ker.init(i);
      c.aHV().aHW();
      com.tencent.mm.blink.a.JB("helloWeChat");
      return;
    }
  }
  
  public void b(g paramg)
  {
    a.j("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.aIE())
    {
      localObject1 = c.aHV();
      localObject2 = com.tencent.mm.kernel.h.aHC().aHe().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).bA((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.h.aHE().aGM()) {
        com.tencent.mm.kernel.h.aHE().aGA();
      }
    }
    com.tencent.mm.blink.a.JB("installPendingPlugins");
    long l = System.nanoTime();
    if (this.kes.size() > 0)
    {
      localObject1 = this.kes.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHC().z((String)localObject2, true);
      }
      this.kes.clear();
      com.tencent.mm.blink.a.n("installPendingPlugins installed", l);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHC().aHd();
      com.tencent.mm.blink.a.JB("installPendingPlugins dependency made.");
      localObject1 = new qn();
      EventCenter.instance.publish((IEvent)localObject1);
    }
    boolean bool = aaI();
    int i;
    if ((paramg.aIE()) && (com.tencent.mm.kernel.h.aHE().aGM()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.h.aHE().aGO();
      }
      paramg = com.tencent.mm.blink.b.aqa();
      Log.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label295;
      }
      paramg.a(b.b.iOX);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.h.aHE().aGO();
      }
      com.tencent.mm.blink.a.JB("afterAccountInit");
      return;
      i = 0;
      break;
      label295:
      MMHandlerThread.postToMainThreadDelayed(new b.2(paramg), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */