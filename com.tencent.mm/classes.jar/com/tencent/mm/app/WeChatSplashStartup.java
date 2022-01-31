package com.tencent.mm.app;

import android.app.Application;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.kernel.h.2;
import com.tencent.mm.kernel.h.3;
import com.tencent.mm.kernel.k;
import com.tencent.mm.splash.n.a;
import com.tencent.mm.splash.p.a;
import com.tencent.mm.vending.g.f;
import junit.framework.Assert;

public class WeChatSplashStartup
  implements n.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(p.a parama)
  {
    com.tencent.mm.blink.a.fP(2);
    boolean bool;
    if (parama == null) {
      bool = true;
    }
    for (;;)
    {
      Object localObject1 = this.profile;
      ((com.tencent.mm.kernel.b.h)localObject1).dMV.a(new com.tencent.mm.kernel.b.h.1((com.tencent.mm.kernel.b.h)localObject1));
      localObject1 = new g();
      Object localObject2 = this.profile.dKl;
      Assert.assertNotNull(localObject1);
      com.tencent.mm.kernel.h.DT().DM().Dr();
      ((com.tencent.mm.kernel.a.a)localObject2).dLu = ((b)localObject1);
      if (!bool)
      {
        com.tencent.mm.splash.i.csV();
        new WeChatSplashStartup.1(this, parama).cqo();
      }
      localObject2 = com.tencent.mm.kernel.g.DQ();
      if (!bool)
      {
        if (i.bwu == null) {
          i.bwu = new i("initThread");
        }
        localObject1 = i.bwu;
        ((i)localObject1).sQ();
        com.tencent.mm.kernel.g.DQ().a(new WeChatSplashStartup.5(this, (i)localObject1));
        com.tencent.mm.kernel.a.c.DY().b(((i)localObject1).bwv.getLooper());
        localObject1 = ((i)localObject1).bww;
        label168:
        localObject2 = ((com.tencent.mm.kernel.g)localObject2).dKP;
        k.el("startup");
      }
      synchronized (((com.tencent.mm.kernel.h)localObject2).dLi)
      {
        if (((com.tencent.mm.kernel.h)localObject2).dLj)
        {
          com.tencent.mm.kernel.a.a.j("warning, mmskeleton has started up already.", new Object[0]);
          com.tencent.mm.splash.i.a(new WeChatSplashStartup.2(this));
          com.tencent.mm.splash.i.a(n.bwZ);
          com.tencent.mm.kernel.g.DQ().a(new WeChatSplashStartup.3(this, bool, parama));
          com.tencent.mm.kernel.g.DQ().a(new WeChatSplashStartup.4(this));
          return;
          bool = false;
          continue;
          localObject1 = null;
          break label168;
        }
        ??? = ((com.tencent.mm.kernel.h)localObject2).DM().Dr();
        long l1 = System.currentTimeMillis();
        com.tencent.mm.kernel.a.a.j("mmskeleton boot startup for process [%s]...", new Object[] { ((com.tencent.mm.kernel.b.g)???).dIA });
        com.tencent.mm.kernel.a.a locala = ((com.tencent.mm.kernel.b.g)???).dKl;
        Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", locala.dLu);
        com.tencent.mm.vending.g.c localc = f.cLb().oa(true);
        com.tencent.mm.kernel.a.a.dLw = SystemClock.elapsedRealtime();
        com.tencent.mm.kernel.a.a.j("hello WeChat.", new Object[0]);
        locala.dLu.sJ();
        long l2 = System.currentTimeMillis();
        com.tencent.mm.kernel.a.a.j("boot install plugins...", new Object[0]);
        locala.dLu.sK();
        locala.mConfigured = true;
        com.tencent.mm.kernel.a.a.j("boot all installed plugins : %s...", new Object[] { com.tencent.mm.kernel.h.DT().DL().Dq() });
        com.tencent.mm.kernel.a.a.j("boot install plugins done in [%s].", new Object[] { com.tencent.mm.kernel.a.a.by(l2) });
        k.el("installPlugins");
        l2 = System.currentTimeMillis();
        com.tencent.mm.kernel.a.a.j("boot make dependency of plugins...", new Object[0]);
        locala.dLu.DW();
        com.tencent.mm.kernel.a.a.j("boot make dependency of done in [%s].", new Object[] { com.tencent.mm.kernel.a.a.by(l2) });
        l2 = System.currentTimeMillis();
        com.tencent.mm.kernel.a.a.j("boot configure plugins...", new Object[0]);
        locala.dLu.a((com.tencent.mm.kernel.b.g)???);
        com.tencent.mm.kernel.a.a.j("boot configure plugins done in [%s].", new Object[] { com.tencent.mm.kernel.a.a.by(l2) });
        if (localObject1 != null) {
          localc.a((com.tencent.mm.vending.h.d)localObject1);
        }
        localc.c(new com.tencent.mm.kernel.h.1((com.tencent.mm.kernel.h)localObject2, locala, (com.tencent.mm.kernel.b.g)???));
        localc.c(new h.2((com.tencent.mm.kernel.h)localObject2, locala, (com.tencent.mm.kernel.b.g)???));
        localc.a(com.tencent.mm.vending.h.d.wtY, new h.3((com.tencent.mm.kernel.h)localObject2, l1));
      }
    }
  }
  
  public final void a(p.a parama)
  {
    b(parama);
  }
  
  public final void b(Application paramApplication, String paramString)
  {
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = t.bxn;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.dMV.a(new h.6(paramApplication, paramString));
  }
  
  public final void ti()
  {
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */