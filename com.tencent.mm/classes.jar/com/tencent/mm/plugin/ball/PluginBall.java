package com.tencent.mm.plugin.ball;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o.a;
import com.tencent.mm.app.z;
import com.tencent.mm.app.z.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy.a;
import com.tencent.mm.plugin.ball.service.FloatBallServiceProxy;
import com.tencent.mm.plugin.ball.service.b.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.List;

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
        AppMethodBeat.i(188340);
        Log.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", new Object[] { paramAnonymousString });
        if ((!AppForegroundDelegate.fby.cQt) && (h.aHB()) && (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).kV(false);
          ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).la(false);
        }
        if (h.ae(com.tencent.mm.plugin.ball.c.a.class) != null) {
          ((com.tencent.mm.plugin.ball.c.a)h.ae(com.tencent.mm.plugin.ball.c.a.class)).kU(AppForegroundDelegate.fby.cQt);
        }
        AppMethodBeat.o(188340);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(188336);
        Log.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", new Object[] { paramAnonymousString });
        if ((AppForegroundDelegate.fby.cQt) && (h.aHB()) && (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null))
        {
          boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
          Log.i("MicroMsg.PluginBall", "alvinluo onAppForeground isTopApplication: %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).kW(true);
            ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).la(true);
          }
        }
        AppMethodBeat.o(188336);
      }
    };
    AppMethodBeat.o(106008);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(187772);
    super.configure(paramg);
    z.abb().fdS = new z.a()
    {
      public final List<? extends Class<? extends View>> abe()
      {
        AppMethodBeat.i(186848);
        List localList = Arrays.asList(new Class[] { FloatBallView.class, FloatMenuView.class });
        AppMethodBeat.o(186848);
        return localList;
      }
      
      public final boolean abf()
      {
        AppMethodBeat.i(186849);
        if (MMApplicationContext.isMainProcess())
        {
          List localList = ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).cvc();
          if (localList != null)
          {
            if (!localList.isEmpty())
            {
              AppMethodBeat.o(186849);
              return true;
            }
            AppMethodBeat.o(186849);
            return false;
          }
        }
        AppMethodBeat.o(186849);
        return false;
      }
    };
    AppMethodBeat.o(187772);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(106009);
    Log.i("MicroMsg.PluginBall", "dependency");
    if (MMApplicationContext.isMainProcess())
    {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
      dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    }
    dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(106009);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(106012);
    Log.i("MicroMsg.PluginBall", "execute");
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
      h.b(com.tencent.mm.plugin.ball.c.b.class, com.tencent.mm.plugin.ball.service.c.cvT());
      paramg = com.tencent.mm.plugin.ball.service.b.rYN;
      h.b(com.tencent.mm.plugin.ball.c.a.class, b.a.cvS());
      AppMethodBeat.o(106012);
      return;
    }
    paramg = new FloatBallServiceProxy();
    h.b(com.tencent.mm.plugin.ball.c.b.class, paramg);
    Object localObject = FloatBallReportServiceProxy.rYR;
    localObject = FloatBallReportServiceProxy.aRW();
    FloatBallReportServiceProxy.a locala = FloatBallReportServiceProxy.rYR;
    h.b(com.tencent.mm.plugin.ball.c.a.class, (FloatBallReportServiceProxy)((kotlin.f)localObject).getValue());
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
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(106013);
    Log.i("MicroMsg.PluginBall", "onAccountInitialized");
    this.appForegroundListener.alive();
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).aGp();
    }
    AppMethodBeat.o(106013);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(106014);
    Log.i("MicroMsg.PluginBall", "onAccountRelease");
    this.appForegroundListener.dead();
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.PluginBall
 * JD-Core Version:    0.7.0.1
 */