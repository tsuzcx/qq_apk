package com.tencent.mm.plugin.ball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy.a;
import com.tencent.mm.plugin.ball.service.FloatBallServiceProxy;
import com.tencent.mm.plugin.ball.service.c.a;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class PluginBall
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.ball.c.d
{
  private n.a appForegroundListener;
  
  public PluginBall()
  {
    AppMethodBeat.i(106008);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(106007);
        ac.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", new Object[] { paramAnonymousString });
        if ((!AppForegroundDelegate.cHM.cqc) && (com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iE(false);
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iJ(false);
        }
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).iD(AppForegroundDelegate.cHM.cqc);
        }
        AppMethodBeat.o(106007);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(106006);
        ac.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", new Object[] { paramAnonymousString });
        if ((AppForegroundDelegate.cHM.cqc) && (com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iF(true);
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iJ(true);
        }
        AppMethodBeat.o(106006);
      }
    };
    AppMethodBeat.o(106008);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(106009);
    ac.i("MicroMsg.PluginBall", "dependency");
    if (ai.cin()) {
      dependsOn(a.class);
    }
    dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(106009);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(106012);
    ac.i("MicroMsg.PluginBall", "execute");
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.c.class, com.tencent.mm.plugin.ball.service.d.bGD());
      paramg = com.tencent.mm.plugin.ball.service.c.nfU;
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, c.a.bGB());
      AppMethodBeat.o(106012);
      return;
    }
    paramg = new FloatBallServiceProxy();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.c.class, paramg);
    FloatBallReportServiceProxy.a locala = FloatBallReportServiceProxy.nfY;
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, FloatBallReportServiceProxy.a.bGC());
    ac.i("MicroMsg.PluginBall", "register IFloatBallService in non-MM process, proxy:%s", new Object[] { paramg });
    AppMethodBeat.o(106012);
  }
  
  public void installed()
  {
    AppMethodBeat.i(106010);
    ac.i("MicroMsg.PluginBall", "installed");
    alias(com.tencent.mm.plugin.ball.c.d.class);
    AppMethodBeat.o(106010);
  }
  
  public String name()
  {
    return "plugin-ball";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(106013);
    ac.i("MicroMsg.PluginBall", "onAccountInitialized");
    this.appForegroundListener.alive();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).bFL();
    }
    AppMethodBeat.o(106013);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(106014);
    ac.i("MicroMsg.PluginBall", "onAccountRelease");
    this.appForegroundListener.dead();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).onAccountRelease();
    }
    AppMethodBeat.o(106014);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(106011);
    ac.i("MicroMsg.PluginBall", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(106011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.PluginBall
 * JD-Core Version:    0.7.0.1
 */