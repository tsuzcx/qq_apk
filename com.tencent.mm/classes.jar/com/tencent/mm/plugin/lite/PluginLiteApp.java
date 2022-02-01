package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class PluginLiteApp
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.lite.a.b
{
  private n.a appForegroundListener;
  private Timer mTimer;
  private c tVJ;
  private com.tencent.mm.sdk.b.c tVK;
  
  public PluginLiteApp()
  {
    AppMethodBeat.i(205687);
    this.tVJ = null;
    this.tVK = null;
    this.mTimer = null;
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(205682);
        ac.d("MicroMsg.AppLite.PluginLiteApp", "onAppForeground");
        PluginLiteApp.access$000(PluginLiteApp.this);
        AppMethodBeat.o(205682);
      }
    };
    AppMethodBeat.o(205687);
  }
  
  private void preloadLiteService()
  {
    AppMethodBeat.i(205690);
    com.tencent.mm.plugin.lite.logic.c.cWu();
    if (com.tencent.mm.plugin.lite.logic.c.dzy())
    {
      Intent localIntent = new Intent();
      localIntent.setClass(ai.getContext(), WxaLiteAppTaskPreloadReceiver.class);
      localIntent.addFlags(268435456);
      ai.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(205690);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(205689);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiteAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.d.c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(205689);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    if (ai.cin()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.lite.a.a.class, new e());
    }
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(205688);
    ac.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", new Object[] { paramg.mProcessName });
    if (ai.eVh()) {
      h.a("com.tencent.mm", new Bundle(), com.tencent.mm.plugin.lite.f.a.class, new com.tencent.mm.ipcinvoker.d() {});
    }
    AppMethodBeat.o(205688);
  }
  
  public String name()
  {
    return "plugin-liteapp";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146366);
    ac.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
    if (ai.cin())
    {
      if (this.tVJ == null) {
        this.tVJ = new c();
      }
      if (this.tVK == null)
      {
        this.tVK = new a();
        com.tencent.mm.sdk.b.a.GpY.b(this.tVK);
      }
      if (this.mTimer == null)
      {
        com.tencent.mm.plugin.lite.logic.c.cWu();
        if (com.tencent.mm.plugin.lite.logic.c.exo())
        {
          this.mTimer = new Timer();
          this.mTimer.schedule(new TimerTask()
          {
            public final void run()
            {
              AppMethodBeat.i(205686);
              ac.i("MicroMsg.AppLite.PluginLiteApp", "begin to checkLiteApp");
              com.tencent.mm.plugin.lite.logic.c.cWu();
              final com.tencent.mm.plugin.lite.d.b localb = com.tencent.mm.plugin.lite.logic.c.ajL("wxalitebaselibrary");
              com.tencent.mm.plugin.lite.logic.c.cWu().a("wxalitebaselibrary", new com.tencent.mm.plugin.lite.logic.a()
              {
                public final void a(com.tencent.mm.plugin.lite.d.b paramAnonymous2b)
                {
                  AppMethodBeat.i(205685);
                  if (paramAnonymous2b == null)
                  {
                    AppMethodBeat.o(205685);
                    return;
                  }
                  if (localb != null)
                  {
                    if (!localb.field_pkgPath.equals(paramAnonymous2b.field_pkgPath))
                    {
                      com.tencent.mm.plugin.lite.logic.c.cWu();
                      if (!com.tencent.mm.plugin.lite.logic.c.dzy()) {}
                    }
                  }
                  else
                  {
                    Intent localIntent = new Intent();
                    localIntent.setClass(ai.getContext(), WxaLiteAppTaskPreloadReceiver.class);
                    localIntent.addFlags(268435456);
                    localIntent.putExtra("task", "updateBaseLibPath");
                    localIntent.putExtra("path", paramAnonymous2b.field_pkgPath);
                    ai.getContext().sendBroadcast(localIntent);
                  }
                  AppMethodBeat.o(205685);
                }
                
                public final void cOG() {}
              });
              com.tencent.mm.plugin.lite.logic.c.cWu().a("wxalited0d6cb88ac866bcdf3b738f1f3df8872", null);
              AppMethodBeat.o(205686);
            }
          }, 180000L, 86400000L);
        }
      }
      ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.tVJ);
      this.appForegroundListener.alive();
      preloadLiteService();
    }
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    ac.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (ai.cin()) {
      ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.tVJ);
    }
    this.appForegroundListener.dead();
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */