package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class PluginLiteApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, b
{
  private o.a appForegroundListener;
  private Timer mTimer;
  private c vkb;
  private com.tencent.mm.sdk.b.c vkc;
  
  public PluginLiteApp()
  {
    AppMethodBeat.i(217774);
    this.vkb = null;
    this.vkc = null;
    this.mTimer = null;
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(217770);
        ae.d("MicroMsg.AppLite.PluginLiteApp", "onAppForeground");
        PluginLiteApp.access$000(PluginLiteApp.this);
        AppMethodBeat.o(217770);
      }
    };
    AppMethodBeat.o(217774);
  }
  
  private void preloadLiteService()
  {
    AppMethodBeat.i(217777);
    com.tencent.mm.plugin.lite.logic.c.diz();
    if ((com.tencent.mm.plugin.lite.logic.c.diw()) || (j.DEBUG) || (bv.fpR()))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(ak.getContext(), WxaLiteAppTaskPreloadReceiver.class);
      localIntent.addFlags(268435456);
      ak.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(217777);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(217776);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiteAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.d.f.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LiteAppAuthInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.d.d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(217776);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    if (ak.coh()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.lite.a.a.class, new e());
    }
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(217775);
    ae.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", new Object[] { paramg.mProcessName });
    if (ak.foH()) {
      h.a("com.tencent.mm", new Bundle(), com.tencent.mm.plugin.lite.f.a.class, new com.tencent.mm.ipcinvoker.d() {});
    }
    AppMethodBeat.o(217775);
  }
  
  public String name()
  {
    return "plugin-liteapp";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146366);
    ae.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
    if (ak.coh())
    {
      if (this.vkb == null) {
        this.vkb = new c();
      }
      if (this.vkc == null)
      {
        this.vkc = new a();
        com.tencent.mm.sdk.b.a.IvT.b(this.vkc);
      }
      if (this.mTimer == null)
      {
        com.tencent.mm.plugin.lite.logic.c.diz();
        if (com.tencent.mm.plugin.lite.logic.c.diC())
        {
          this.mTimer = new Timer();
          this.mTimer.schedule(new TimerTask()
          {
            public final void run()
            {
              AppMethodBeat.i(217773);
              ae.i("MicroMsg.AppLite.PluginLiteApp", "begin to checkLiteApp");
              com.tencent.mm.plugin.lite.logic.c.diz().diB();
              String[] arrayOfString = LiteAppCenter.LITE_APP_PACKAGES;
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str = arrayOfString[i];
                com.tencent.mm.plugin.lite.logic.c.diz().a(str, null);
                i += 1;
              }
              AppMethodBeat.o(217773);
            }
          }, 180000L, 86400000L);
        }
      }
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.vkb);
      this.appForegroundListener.alive();
      preloadLiteService();
    }
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    ae.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (ak.coh()) {
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.vkb);
    }
    this.appForegroundListener.dead();
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */