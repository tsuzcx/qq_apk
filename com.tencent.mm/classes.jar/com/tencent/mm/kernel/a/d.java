package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.ap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> gFI = com.tencent.mm.kernel.a.b.e.akv();
  private final HashSet<String> gFJ = new HashSet();
  
  public static void ah(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.g.ajN().Z(paramClass);
  }
  
  protected static void xM(String paramString)
  {
    com.tencent.mm.kernel.g.ajN().xD(paramString);
  }
  
  public void LM()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      ae.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.gFI.init(i);
      c localc = c.ake();
      localc.gFe.a(new Class[] { com.tencent.mm.kernel.b.b.class });
      localc.gFd.a(new Class[] { com.tencent.mm.kernel.a.c.b.class });
      localc.gFf.a(new Class[] { com.tencent.mm.kernel.api.h.class, com.tencent.mm.kernel.api.a.class, com.tencent.mm.kernel.api.e.class, ap.class, com.tencent.mm.kernel.api.c.class });
      Object localObject = localc.gFf;
      ((com.tencent.mm.kernel.a.b.g)localObject).gGt = new Class[1];
      localObject = ((com.tencent.mm.kernel.a.b.g)localObject).gGt;
      System.arraycopy(new Class[] { com.tencent.mm.kernel.api.c.class }, 0, localObject, 0, 1);
      ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).gDL.gEX = new c.1(localc);
      com.tencent.mm.blink.a.uw("helloWeChat");
      return;
    }
  }
  
  public boolean LZ()
  {
    return true;
  }
  
  public void a(com.tencent.mm.kernel.b.g paramg)
  {
    this.gFI.a(new e.b(), c.gFo, c.ake().gFe, "configure-functional plugins");
    com.tencent.mm.blink.a.uw("configurePlugins");
    paramg = new ow();
    com.tencent.mm.sdk.b.a.IvT.l(paramg);
  }
  
  public final void akc()
  {
    com.tencent.mm.kernel.g.ajN().ajo();
    this.gFI.prepare();
    Iterator localIterator = this.gFI.akx().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.ake().f(localc.cUO.getLooper());
    }
    com.tencent.mm.blink.a.uw("makeDependency");
  }
  
  public final void akd()
  {
    this.gFI.a(new e.b(), c.gFp, c.ake().gFd, "task-functional plugins");
    com.tencent.mm.blink.a.uw("executeTasks");
  }
  
  public void b(com.tencent.mm.kernel.b.g paramg)
  {
    a.k("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.akL())
    {
      localObject1 = c.ake();
      localObject2 = com.tencent.mm.kernel.g.ajN().ajp().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).br((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.g.ajP().aiZ()) {
        com.tencent.mm.kernel.g.ajP().aiP();
      }
    }
    com.tencent.mm.blink.a.uw("installPendingPlugins");
    long l = System.nanoTime();
    if (this.gFJ.size() > 0)
    {
      localObject1 = this.gFJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajN().w((String)localObject2, true);
      }
      this.gFJ.clear();
      com.tencent.mm.blink.a.p("installPendingPlugins installed", l);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajN().ajo();
      com.tencent.mm.blink.a.uw("installPendingPlugins dependency made.");
      localObject1 = new ox();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    boolean bool = LZ();
    int i;
    if ((paramg.akL()) && (com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.g.ajP().ajb();
      }
      paramg = com.tencent.mm.blink.b.Wq();
      ae.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label297;
      }
      paramg.a(b.b.fFG);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.g.ajP().ajb();
      }
      com.tencent.mm.blink.a.uw("afterAccountInit");
      return;
      i = 0;
      break;
      label297:
      ar.o(new b.2(paramg), 1000L);
    }
  }
  
  protected final void xN(String paramString)
  {
    this.gFJ.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */