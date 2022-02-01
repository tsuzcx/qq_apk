package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> gjr = com.tencent.mm.kernel.a.b.e.ahv();
  private final HashSet<String> gjs = new HashSet();
  
  public static void ah(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.agN().Z(paramClass);
  }
  
  protected static void un(String paramString)
  {
    com.tencent.mm.kernel.g.agN().ue(paramString);
  }
  
  public void Kf()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      ac.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.gjr.init(i);
      c localc = c.ahe();
      localc.giN.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.giM.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.giO.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, am.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.giO;
      ((com.tencent.mm.kernel.a.b.g)localObject).gkc = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).gkc;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ghu.giG = new c.1(localc);
      com.tencent.mm.blink.a.rp("helloWeChat");
      return;
    }
  }
  
  public boolean Ko()
  {
    return true;
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.gjr.a(new e.b(), c.giX, c.ahe().giN, "configure-functional plugins");
    com.tencent.mm.blink.a.rp("configurePlugins");
    paramg = new om();
    com.tencent.mm.sdk.b.a.GpY.l(paramg);
  }
  
  public final void ahc()
  {
    com.tencent.mm.kernel.g.agN().agn();
    this.gjr.prepare();
    Iterator localIterator = this.gjr.ahx().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.ahe().f(localc.cIH.getLooper());
    }
    com.tencent.mm.blink.a.rp("makeDependency");
  }
  
  public final void ahd()
  {
    this.gjr.a(new e.b(), c.giY, c.ahe().giM, "task-functional plugins");
    com.tencent.mm.blink.a.rp("executeTasks");
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.h("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.ahL())
    {
      localObject1 = c.ahe();
      localObject2 = com.tencent.mm.kernel.g.agN().ago().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).bp((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.agP().afY()) {
        com.tencent.mm.kernel.g.agP().afO();
      }
    }
    com.tencent.mm.blink.a.rp("installPendingPlugins");
    long l = System.nanoTime();
    if (this.gjs.size() > 0)
    {
      localObject1 = this.gjs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agN().w((String)localObject2, true);
      }
      this.gjs.clear();
      com.tencent.mm.blink.a.p("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agN().agn();
      com.tencent.mm.blink.a.rp("installPendingPlugins dependency made.");
      localObject1 = new on();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    boolean bool = Ko();
    int i;
    if ((paramg.ahL()) && (com.tencent.mm.kernel.g.agP().afY()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.agP().aga();
      }
      paramg = com.tencent.mm.blink.b.TR();
      ac.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label297;
      }
      paramg.a(b.b.flv);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.agP().aga();
      }
      com.tencent.mm.blink.a.rp("afterAccountInit");
      return;
      i = 0;
      break;
      label297:
      ap.n(new b.2(paramg), 1000L);
    }
  }
  
  protected final void uo(String paramString)
  {
    this.gjs.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */