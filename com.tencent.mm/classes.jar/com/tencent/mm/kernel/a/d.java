package com.tencent.mm.kernel.a;

import android.os.HandlerThread;
import com.tencent.mm.autogen.a.rz;
import com.tencent.mm.autogen.a.sa;
import com.tencent.mm.blink.b.2;
import com.tencent.mm.blink.b.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.kernel.a.b.e.b;
import com.tencent.mm.kernel.a.b.e.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class d
  implements b
{
  public com.tencent.mm.kernel.a.b.e<Object> mEB = com.tencent.mm.kernel.a.b.e.bbj();
  private final HashSet<String> mEC = new HashSet();
  
  protected static void FF(String paramString)
  {
    com.tencent.mm.kernel.h.baA().Fx(paramString);
  }
  
  public static void aD(Class<? extends f> paramClass)
  {
    com.tencent.mm.kernel.h.baA().av(paramClass);
  }
  
  protected final void FG(String paramString)
  {
    this.mEC.add(paramString);
  }
  
  public void a(g paramg)
  {
    this.mEB.a(new e.b(), c.mEi, c.baR().mDW, "task-functional plugins");
    com.tencent.mm.blink.a.Ch("executeTasks");
  }
  
  public void aBY()
  {
    boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA();
    double d2 = n.getNumCores();
    if (bool) {}
    for (double d1 = 1.5D;; d1 = 1.0D)
    {
      int i = (int)Math.min(Math.floor(d1 * d2), 6.0D);
      Log.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", new Object[] { Integer.valueOf(i) });
      this.mEB.sE(i);
      c.baR().baS();
      com.tencent.mm.blink.a.Ch("helloWeChat");
      return;
    }
  }
  
  public boolean aCp()
  {
    return true;
  }
  
  public void b(g paramg)
  {
    this.mEB.a(new e.b(), c.mEh, c.baR().mDX, "configure-functional plugins");
    com.tencent.mm.blink.a.Ch("configurePlugins");
    new rz().publish();
  }
  
  public final void baQ()
  {
    com.tencent.mm.kernel.h.baA().bab();
    this.mEB.prepare();
    Iterator localIterator = this.mEB.bbl().iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      c.baR().h(localc.hgw.getLooper());
    }
    com.tencent.mm.blink.a.Ch("makeDependency");
  }
  
  public void c(g paramg)
  {
    a.j("startup final step, account initialize... for parallels", new Object[0]);
    Object localObject1;
    Object localObject2;
    if (paramg.bbA())
    {
      localObject1 = c.baR();
      localObject2 = com.tencent.mm.kernel.h.baA().bac().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((c)localObject1).cT((f)((Iterator)localObject2).next());
      }
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        com.tencent.mm.kernel.h.baC().aZC();
      }
    }
    com.tencent.mm.blink.a.Ch("installPendingPlugins");
    long l = System.nanoTime();
    if (this.mEC.size() > 0)
    {
      localObject1 = this.mEC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baA().B((String)localObject2, true);
      }
      this.mEC.clear();
      com.tencent.mm.blink.a.o("installPendingPlugins installed", l);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baA().bab();
      com.tencent.mm.blink.a.Ch("installPendingPlugins dependency made.");
      new sa().publish();
    }
    boolean bool = aCp();
    int i;
    if ((paramg.bbA()) && (com.tencent.mm.kernel.h.baC().aZN()))
    {
      i = 1;
      if ((i != 0) && (!bool)) {
        com.tencent.mm.kernel.h.baC().aZO();
      }
      paramg = com.tencent.mm.blink.b.aJY();
      Log.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label288;
      }
      paramg.a(b.b.lqT);
    }
    for (;;)
    {
      if ((i != 0) && (bool)) {
        com.tencent.mm.kernel.h.baC().aZO();
      }
      com.tencent.mm.blink.a.Ch("afterAccountInit");
      return;
      i = 0;
      break;
      label288:
      MMHandlerThread.postToMainThreadDelayed(new b.2(paramg), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.d
 * JD-Core Version:    0.7.0.1
 */