package com.tencent.mm.plugin.ball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy.a;
import com.tencent.mm.plugin.ball.service.FloatBallServiceProxy;
import com.tencent.mm.plugin.ball.service.c.a;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public class PluginBall
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.ball.c.d
{
  private o.a appForegroundListener;
  
  public PluginBall()
  {
    AppMethodBeat.i(106008);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(106007);
        ae.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", new Object[] { paramAnonymousString });
        if ((!AppForegroundDelegate.cTA.cBB) && (com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iM(false);
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iR(false);
        }
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).iL(AppForegroundDelegate.cTA.cBB);
        }
        AppMethodBeat.o(106007);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(106006);
        ae.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", new Object[] { paramAnonymousString });
        if ((AppForegroundDelegate.cTA.cBB) && (com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iN(true);
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).iR(true);
        }
        AppMethodBeat.o(106006);
      }
    };
    AppMethodBeat.o(106008);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(106009);
    ae.i("MicroMsg.PluginBall", "dependency");
    if (ak.coh()) {
      dependsOn(a.class);
    }
    dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(106009);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(106012);
    ae.i("MicroMsg.PluginBall", "execute");
    if (paramg.akL())
    {
      ae.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.c.class, com.tencent.mm.plugin.ball.service.d.bLK());
      paramg = com.tencent.mm.plugin.ball.service.c.nLS;
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, c.a.bLJ());
      AppMethodBeat.o(106012);
      return;
    }
    paramg = new FloatBallServiceProxy();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.c.class, paramg);
    Object localObject = FloatBallReportServiceProxy.nLW;
    localObject = FloatBallReportServiceProxy.arx();
    FloatBallReportServiceProxy.a locala = FloatBallReportServiceProxy.nLW;
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, (FloatBallReportServiceProxy)((d.f)localObject).getValue());
    ae.i("MicroMsg.PluginBall", "register IFloatBallService in non-MM process, proxy:%s", new Object[] { paramg });
    AppMethodBeat.o(106012);
  }
  
  public void installed()
  {
    AppMethodBeat.i(106010);
    ae.i("MicroMsg.PluginBall", "installed");
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
    ae.i("MicroMsg.PluginBall", "onAccountInitialized");
    this.appForegroundListener.alive();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).bKT();
    }
    AppMethodBeat.o(106013);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(106014);
    ae.i("MicroMsg.PluginBall", "onAccountRelease");
    this.appForegroundListener.dead();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).onAccountRelease();
    }
    AppMethodBeat.o(106014);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(106011);
    ae.i("MicroMsg.PluginBall", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(106011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.PluginBall
 * JD-Core Version:    0.7.0.1
 */