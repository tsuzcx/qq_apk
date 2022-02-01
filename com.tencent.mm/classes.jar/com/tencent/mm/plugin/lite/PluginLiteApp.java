package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  private c uYl;
  private com.tencent.mm.sdk.b.c uYm;
  
  public PluginLiteApp()
  {
    AppMethodBeat.i(217164);
    this.uYl = null;
    this.uYm = null;
    this.mTimer = null;
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(217159);
        ad.d("MicroMsg.AppLite.PluginLiteApp", "onAppForeground");
        PluginLiteApp.access$000(PluginLiteApp.this);
        AppMethodBeat.o(217159);
      }
    };
    AppMethodBeat.o(217164);
  }
  
  private void preloadLiteService()
  {
    AppMethodBeat.i(217167);
    com.tencent.mm.plugin.lite.logic.c.dfF();
    if (com.tencent.mm.plugin.lite.logic.c.dfC())
    {
      Intent localIntent = new Intent();
      localIntent.setClass(aj.getContext(), WxaLiteAppTaskPreloadReceiver.class);
      localIntent.addFlags(268435456);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(217167);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(217166);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiteAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.d.c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(217166);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    if (aj.cmR()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.lite.a.a.class, new e());
    }
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(217165);
    ad.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", new Object[] { paramg.mProcessName });
    if (aj.fkM()) {
      h.a("com.tencent.mm", new Bundle(), com.tencent.mm.plugin.lite.f.a.class, new com.tencent.mm.ipcinvoker.d() {});
    }
    AppMethodBeat.o(217165);
  }
  
  public String name()
  {
    return "plugin-liteapp";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146366);
    ad.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
    if (aj.cmR())
    {
      if (this.uYl == null) {
        this.uYl = new c();
      }
      if (this.uYm == null)
      {
        this.uYm = new a();
        com.tencent.mm.sdk.b.a.IbL.b(this.uYm);
      }
      if (this.mTimer == null)
      {
        com.tencent.mm.plugin.lite.logic.c.dfF();
        if (com.tencent.mm.plugin.lite.logic.c.dfG())
        {
          this.mTimer = new Timer();
          this.mTimer.schedule(new TimerTask()
          {
            public final void run()
            {
              AppMethodBeat.i(217163);
              ad.i("MicroMsg.AppLite.PluginLiteApp", "begin to checkLiteApp");
              com.tencent.mm.plugin.lite.logic.c.dfF();
              final com.tencent.mm.plugin.lite.d.b localb = com.tencent.mm.plugin.lite.logic.c.aoy("wxalitebaselibrary");
              com.tencent.mm.plugin.lite.logic.c.dfF().a("wxalitebaselibrary", new com.tencent.mm.plugin.lite.logic.a()
              {
                public final void a(com.tencent.mm.plugin.lite.d.b paramAnonymous2b)
                {
                  AppMethodBeat.i(217162);
                  if (paramAnonymous2b == null)
                  {
                    AppMethodBeat.o(217162);
                    return;
                  }
                  if (localb != null)
                  {
                    if (!localb.field_pkgPath.equals(paramAnonymous2b.field_pkgPath))
                    {
                      com.tencent.mm.plugin.lite.logic.c.dfF();
                      if (!com.tencent.mm.plugin.lite.logic.c.dfC()) {}
                    }
                  }
                  else
                  {
                    Intent localIntent = new Intent();
                    localIntent.setClass(aj.getContext(), WxaLiteAppTaskPreloadReceiver.class);
                    localIntent.addFlags(268435456);
                    localIntent.putExtra("task", "updateBaseLibPath");
                    localIntent.putExtra("path", paramAnonymous2b.field_pkgPath);
                    aj.getContext().sendBroadcast(localIntent);
                  }
                  AppMethodBeat.o(217162);
                }
                
                public final void cXf() {}
              });
              com.tencent.mm.plugin.lite.logic.c.dfF().a("wxalited0d6cb88ac866bcdf3b738f1f3df8872", null);
              AppMethodBeat.o(217163);
            }
          }, 180000L, 86400000L);
        }
      }
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.uYl);
      this.appForegroundListener.alive();
      preloadLiteService();
    }
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    ad.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (aj.cmR()) {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.uYl);
    }
    this.appForegroundListener.dead();
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */