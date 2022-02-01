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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

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
        ad.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", new Object[] { paramAnonymousString });
        if ((!AppForegroundDelegate.cKE.csU) && (com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).ie(false);
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).ij(false);
        }
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).id(AppForegroundDelegate.cKE.csU);
        }
        AppMethodBeat.o(106007);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(106006);
        ad.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", new Object[] { paramAnonymousString });
        if ((AppForegroundDelegate.cKE.csU) && (com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).jdMethod_if(true);
          ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).ij(true);
        }
        AppMethodBeat.o(106006);
      }
    };
    AppMethodBeat.o(106008);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(106009);
    ad.i("MicroMsg.PluginBall", "dependency");
    if (aj.cbe()) {
      dependsOn(a.class);
    }
    dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(106009);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(106012);
    ad.i("MicroMsg.PluginBall", "execute");
    if (paramg.agu())
    {
      ad.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.c.class, com.tencent.mm.plugin.ball.service.d.bzH());
      paramg = com.tencent.mm.plugin.ball.service.c.mDO;
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, c.a.bzF());
      AppMethodBeat.o(106012);
      return;
    }
    paramg = new FloatBallServiceProxy();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.c.class, paramg);
    FloatBallReportServiceProxy.a locala = FloatBallReportServiceProxy.mDS;
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, FloatBallReportServiceProxy.a.bzG());
    ad.i("MicroMsg.PluginBall", "register IFloatBallService in non-MM process, proxy:%s", new Object[] { paramg });
    AppMethodBeat.o(106012);
  }
  
  public void installed()
  {
    AppMethodBeat.i(106010);
    ad.i("MicroMsg.PluginBall", "installed");
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
    ad.i("MicroMsg.PluginBall", "onAccountInitialized");
    this.appForegroundListener.alive();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).byP();
    }
    AppMethodBeat.o(106013);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(106014);
    ad.i("MicroMsg.PluginBall", "onAccountRelease");
    this.appForegroundListener.dead();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).onAccountRelease();
    }
    AppMethodBeat.o(106014);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(106011);
    ad.i("MicroMsg.PluginBall", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(106011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.PluginBall
 * JD-Core Version:    0.7.0.1
 */