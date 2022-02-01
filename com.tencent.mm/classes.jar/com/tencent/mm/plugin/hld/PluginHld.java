package com.tencent.mm.plugin.hld;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.qb;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.k.e;
import com.tencent.mm.plugin.hld.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.ab;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/PluginHld;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "isLogin", "", "logoutListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "otherLogoutListener", "Lcom/tencent/mm/autogen/events/OtherLogoutEvent;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "handleLogout", "name", "", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "plugin-hld_release"})
public final class PluginHld
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.d
{
  public static final String CLASS = "com.tencent.mm.plugin.hld.PluginHld";
  public static final a Companion;
  public static final String STORAGE_WX_IME = "wxime";
  public static final String TAG = "WxIme.PluginHld";
  private o.a appForegroundListener;
  private boolean isLogin;
  private final IListener<mr> logoutListener;
  private final IListener<qb> otherLogoutListener;
  
  static
  {
    AppMethodBeat.i(213006);
    Companion = new a((byte)0);
    AppMethodBeat.o(213006);
  }
  
  public PluginHld()
  {
    AppMethodBeat.i(213004);
    this.logoutListener = ((IListener)new c(this));
    this.otherLogoutListener = ((IListener)new e(this));
    this.appForegroundListener = ((o.a)new b());
    AppMethodBeat.o(213004);
  }
  
  private final void handleLogout()
  {
    AppMethodBeat.i(213002);
    if (this.isLogin)
    {
      Intent localIntent = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      localIntent.putExtra("ime_logout", true);
      com.tencent.mm.by.c.l(localIntent, "hld");
    }
    this.isLogin = false;
    AppMethodBeat.o(213002);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(212996);
    Log.d("WxIme.PluginHld", "configure");
    if ((paramg != null) && (paramg.aIE())) {
      ab.aE("wxime", "wxime", 1);
    }
    AppMethodBeat.o(212996);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(212991);
    Log.d("WxIme.PluginHld", "execute");
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.hld.a.d.class, (com.tencent.mm.kernel.c.c)new e((a)new q()));
    if (paramg != null)
    {
      if (paramg.aIE())
      {
        paramg = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eHa())
        {
          paramg = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
          if (paramg != null) {
            paramg.eCB();
          }
          paramg = k.DDb;
          if (!k.eEz())
          {
            paramg = com.tencent.mm.plugin.hld.f.l.DHK;
            paramg = com.tencent.mm.plugin.hld.f.l.getKV();
            if ((paramg != null) && (paramg.getBoolean("ime_if_report_client_environment", false) == true))
            {
              AppMethodBeat.o(212991);
              return;
            }
            com.tencent.e.h.ZvG.be((Runnable)k.e.DDi);
          }
        }
      }
      AppMethodBeat.o(212991);
      return;
    }
    AppMethodBeat.o(212991);
  }
  
  public final String name()
  {
    return "plugin-hld";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(212999);
    Log.d("WxIme.PluginHld", "onAccountInitialized");
    this.isLogin = true;
    this.appForegroundListener.alive();
    com.tencent.e.h.ZvG.be((Runnable)d.Dtu);
    this.logoutListener.alive();
    this.otherLogoutListener.alive();
    paramc = com.tencent.mm.kernel.h.ae(n.class);
    p.j(paramc, "MMKernel.service(IMessengerStorage::class.java)");
    paramc = ((n)paramc).bbL();
    com.tencent.mm.plugin.hld.f.c localc = com.tencent.mm.plugin.hld.f.c.DGO;
    paramc.add(com.tencent.mm.plugin.hld.f.c.eFW());
    paramc = com.tencent.mm.plugin.hld.f.l.DHK;
    paramc = MMApplicationContext.getContext();
    p.j(paramc, "MMApplicationContext.getContext()");
    if (com.tencent.mm.plugin.hld.f.l.hi(paramc))
    {
      paramc = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      paramc.putExtra("ime_login", true);
      com.tencent.mm.by.c.l(paramc, "hld");
    }
    paramc = (n)com.tencent.mm.kernel.h.ae(n.class);
    if (paramc != null)
    {
      paramc = paramc.eRY();
      if (paramc != null)
      {
        paramc.a((h.a)com.tencent.mm.plugin.hld.b.d.Dvn);
        AppMethodBeat.o(212999);
        return;
      }
    }
    AppMethodBeat.o(212999);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(213000);
    Log.d("WxIme.PluginHld", "onAccountRelease");
    this.logoutListener.dead();
    this.otherLogoutListener.dead();
    this.appForegroundListener.dead();
    Object localObject = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbL();
    com.tencent.mm.plugin.hld.f.c localc = com.tencent.mm.plugin.hld.f.c.DGO;
    ((bv)localObject).remove(com.tencent.mm.plugin.hld.f.c.eFW());
    this.isLogin = false;
    localObject = (n)com.tencent.mm.kernel.h.ae(n.class);
    if (localObject != null)
    {
      localObject = ((n)localObject).eRY();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).b((h.a)com.tencent.mm.plugin.hld.b.d.Dvn);
        AppMethodBeat.o(213000);
        return;
      }
    }
    AppMethodBeat.o(213000);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/PluginHld$Companion;", "", "()V", "CLASS", "", "STORAGE_WX_IME", "TAG", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/PluginHld$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "handleLogic", "", "onAppBackground", "activity", "", "onAppForeground", "plugin-hld_release"})
  public static final class b
    extends o.a
  {
    private static void eCk()
    {
      AppMethodBeat.i(210938);
      Object localObject;
      boolean bool2;
      if (com.tencent.mm.kernel.h.aHB())
      {
        localObject = com.tencent.mm.kernel.h.aHE();
        p.j(localObject, "MMKernel.account()");
        if ((((b)localObject).aGN()) && (!b.aGE()))
        {
          localObject = com.tencent.mm.kernel.h.aHF();
          p.j(localObject, "MMKernel.network()");
          localObject = ((com.tencent.mm.kernel.c)localObject).aGY();
          p.j(localObject, "MMKernel.network().netSceneQueue");
          if (((t)localObject).aHc() != null)
          {
            localObject = com.tencent.mm.plugin.hld.f.l.DHK;
            boolean bool1 = com.tencent.mm.plugin.hld.f.l.eHs();
            localObject = com.tencent.mm.plugin.hld.f.l.DHK;
            localObject = MMApplicationContext.getContext();
            p.j(localObject, "MMApplicationContext.getContext()");
            bool2 = com.tencent.mm.plugin.hld.f.l.he((Context)localObject);
            if (bool1 != bool2)
            {
              localObject = k.DDb;
              if (!bool2) {
                break label123;
              }
            }
          }
        }
      }
      label123:
      for (int i = 3;; i = 4)
      {
        k.hM(i, 1);
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.tg(bool2);
        AppMethodBeat.o(210938);
        return;
      }
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(210935);
      p.k(paramString, "activity");
      eCk();
      AppMethodBeat.o(210935);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(210934);
      p.k(paramString, "activity");
      Log.i("WxIme.PluginHld", "onAppForeground ".concat(String.valueOf(paramString)));
      eCk();
      AppMethodBeat.o(210934);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/PluginHld$logoutListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-hld_release"})
  public static final class c
    extends IListener<mr>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d Dtu;
    
    static
    {
      AppMethodBeat.i(210895);
      Dtu = new d();
      AppMethodBeat.o(210895);
    }
    
    public final void run()
    {
      AppMethodBeat.i(210892);
      Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.eHa())
      {
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        if (!com.tencent.mm.plugin.hld.f.l.gJ((Context)localObject))
        {
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          if (com.tencent.mm.plugin.hld.f.l.eCG())
          {
            Log.e("WxIme.PluginHld", "filter enable ime");
            AppMethodBeat.o(210892);
            return;
          }
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject = MMApplicationContext.getContext();
          p.j(localObject, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.hld.f.l.gH((Context)localObject);
          if (!((com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class)).eCC()) {
            ((com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class)).eCB();
          }
          localObject = new StringBuilder("inInputMethod:");
          com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
          Log.i("WxIme.PluginHld", com.tencent.mm.plugin.hld.f.l.eCH());
          AppMethodBeat.o(210892);
          return;
        }
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        boolean bool = com.tencent.mm.plugin.hld.f.l.gK((Context)localObject);
        if (bool)
        {
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          com.tencent.mm.plugin.hld.f.l.eHe();
        }
        Log.i("WxIme.PluginHld", "isInImeList:".concat(String.valueOf(bool)));
      }
      AppMethodBeat.o(210892);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/PluginHld$otherLogoutListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OtherLogoutEvent;", "callback", "", "event", "plugin-hld_release"})
  public static final class e
    extends IListener<qb>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.PluginHld
 * JD-Core Version:    0.7.0.1
 */