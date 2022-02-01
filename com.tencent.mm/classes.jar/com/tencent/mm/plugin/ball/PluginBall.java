package com.tencent.mm.plugin.ball;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.ac;
import com.tencent.mm.app.ac.a;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.a;
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
import kotlin.j;

public class PluginBall
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.ball.c.c
{
  private q.a appForegroundListener;
  
  public PluginBall()
  {
    AppMethodBeat.i(106008);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(288254);
        Log.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", new Object[] { paramAnonymousString });
        if ((!AppForegroundDelegate.heY.eLx) && (h.baz()) && (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null))
        {
          ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mi(false);
          ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mn(false);
        }
        if (h.ax(a.class) != null) {
          ((a)h.ax(a.class)).mh(AppForegroundDelegate.heY.eLx);
        }
        AppMethodBeat.o(288254);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(288250);
        Log.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", new Object[] { paramAnonymousString });
        if ((AppForegroundDelegate.heY.eLx) && (h.baz()) && (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null))
        {
          boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
          Log.i("MicroMsg.PluginBall", "alvinluo onAppForeground isTopApplication: %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mj(true);
            ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mn(true);
          }
        }
        AppMethodBeat.o(288250);
      }
    };
    AppMethodBeat.o(106008);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(288240);
    super.configure(paramg);
    ac.aCN().hhI = new ac.a()
    {
      public final List<? extends Class<? extends View>> aCQ()
      {
        AppMethodBeat.i(288252);
        List localList = Arrays.asList(new Class[] { FloatBallView.class, FloatMenuView.class });
        AppMethodBeat.o(288252);
        return localList;
      }
      
      public final boolean aCR()
      {
        AppMethodBeat.i(288258);
        if (MMApplicationContext.isMainProcess())
        {
          List localList = ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXM();
          if (localList != null)
          {
            if (!localList.isEmpty())
            {
              AppMethodBeat.o(288258);
              return true;
            }
            AppMethodBeat.o(288258);
            return false;
          }
        }
        AppMethodBeat.o(288258);
        return false;
      }
    };
    AppMethodBeat.o(288240);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(106009);
    Log.i("MicroMsg.PluginBall", "dependency");
    if (MMApplicationContext.isMainProcess())
    {
      dependsOn(com.tencent.mm.plugin.comm.a.b.class);
      dependsOn(com.tencent.mm.plugin.teenmode.a.c.class);
    }
    dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(106009);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(106012);
    Log.i("MicroMsg.PluginBall", "execute");
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
      h.b(com.tencent.mm.plugin.ball.c.b.class, com.tencent.mm.plugin.ball.service.c.cYC());
      paramg = com.tencent.mm.plugin.ball.service.b.vkc;
      h.b(a.class, b.a.cYB());
      AppMethodBeat.o(106012);
      return;
    }
    paramg = new FloatBallServiceProxy();
    h.b(com.tencent.mm.plugin.ball.c.b.class, paramg);
    FloatBallReportServiceProxy.a locala = FloatBallReportServiceProxy.vki;
    h.b(a.class, (FloatBallReportServiceProxy)FloatBallReportServiceProxy.blL().getValue());
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
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).aZq();
    }
    AppMethodBeat.o(106013);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(106014);
    Log.i("MicroMsg.PluginBall", "onAccountRelease");
    this.appForegroundListener.dead();
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.PluginBall
 * JD-Core Version:    0.7.0.1
 */