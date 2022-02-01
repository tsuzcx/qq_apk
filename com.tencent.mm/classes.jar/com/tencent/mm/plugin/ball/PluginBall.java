package com.tencent.mm.plugin.ball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy.a;
import com.tencent.mm.plugin.ball.service.FloatBallServiceProxy;
import com.tencent.mm.plugin.ball.service.c.a;
import com.tencent.mm.plugin.ball.service.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class PluginBall
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.ball.c.c
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
        Log.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", new Object[] { paramAnonymousString });
        if ((!AppForegroundDelegate.djR.cPB) && (com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).jL(false);
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).jQ(false);
        }
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
          ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).jK(AppForegroundDelegate.djR.cPB);
        }
        AppMethodBeat.o(106007);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(106006);
        Log.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", new Object[] { paramAnonymousString });
        if ((AppForegroundDelegate.djR.cPB) && (com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null))
        {
          boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
          Log.i("MicroMsg.PluginBall", "alvinluo onAppForeground isTopApplication: %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).jM(true);
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).jQ(true);
          }
        }
        AppMethodBeat.o(106006);
      }
    };
    AppMethodBeat.o(106008);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(106009);
    Log.i("MicroMsg.PluginBall", "dependency");
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(106009);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(106012);
    Log.i("MicroMsg.PluginBall", "execute");
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, d.ciB());
      paramg = com.tencent.mm.plugin.ball.service.c.oWM;
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.a.class, c.a.ciA());
      AppMethodBeat.o(106012);
      return;
    }
    paramg = new FloatBallServiceProxy();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.b.class, paramg);
    Object localObject = FloatBallReportServiceProxy.oWQ;
    localObject = FloatBallReportServiceProxy.aJW();
    FloatBallReportServiceProxy.a locala = FloatBallReportServiceProxy.oWQ;
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ball.c.a.class, (FloatBallReportServiceProxy)((kotlin.f)localObject).getValue());
    Log.i("MicroMsg.PluginBall", "register IFloatBallService in non-MM process, proxy:%s", new Object[] { paramg });
    AppMethodBeat.o(106012);
  }
  
  public void installed()
  {
    AppMethodBeat.i(106010);
    Log.i("MicroMsg.PluginBall", "installed");
    alias(com.tencent.mm.plugin.ball.c.c.class);
    AppMethodBeat.o(106010);
  }
  
  public String name()
  {
    return "plugin-ball";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(106013);
    Log.i("MicroMsg.PluginBall", "onAccountInitialized");
    this.appForegroundListener.alive();
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chL();
    }
    AppMethodBeat.o(106013);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(106014);
    Log.i("MicroMsg.PluginBall", "onAccountRelease");
    this.appForegroundListener.dead();
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
    }
    AppMethodBeat.o(106014);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(106011);
    Log.i("MicroMsg.PluginBall", "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(106011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.PluginBall
 * JD-Core Version:    0.7.0.1
 */