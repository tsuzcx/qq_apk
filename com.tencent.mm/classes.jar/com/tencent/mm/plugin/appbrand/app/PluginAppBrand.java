package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.mm.h.a.ur;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.appcache.t;
import com.tencent.mm.plugin.appbrand.appstorage.r.a;
import com.tencent.mm.plugin.appbrand.appstorage.r.b;
import com.tencent.mm.plugin.appbrand.appusage.ad;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.am;
import com.tencent.mm.plugin.appbrand.appusage.o;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.config.h.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.dynamic.e.b.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Keep
public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.model.ai, com.tencent.mm.plugin.appbrand.a.b
{
  public static final String TAG = "MicroMsg.PluginAppBrand";
  private final com.tencent.mm.plugin.appbrand.v.d singletonRegistry = new com.tencent.mm.plugin.appbrand.v.d();
  private com.tencent.mm.sdk.b.c<ur> xWebViewInitCompleteEventIListener = new PluginAppBrand.1(this);
  
  static
  {
    com.tencent.mm.compatible.util.k.b("appbrandcommon", PluginAppBrand.class.getClassLoader());
  }
  
  private void initJSONABTestGetter()
  {
    com.tencent.mm.ab.h.a(new com.tencent.mm.ab.e() {});
  }
  
  static boolean isAppBrandProcess()
  {
    try
    {
      String str = com.tencent.mm.sdk.platformtools.ae.getPackageName();
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).dIA.startsWith(str + ":appbrand");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  static boolean isSupportProcess()
  {
    try
    {
      boolean bool = "com.tencent.mm:support".equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).dIA);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency()
  {
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    dependsOn(com.tencent.mm.plugin.appbrand.compat.a.c.class);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.d("MicroMsg.PluginAppBrand", "current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).dIA, Boolean.valueOf(com.tencent.mm.sdk.platformtools.ai.isMainThread()) });
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.ae()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.b.g()));
    Object localObject1;
    if (paramg.Ex())
    {
      localObject1 = r.b.fHN;
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      com.tencent.mm.plugin.appbrand.game.b.c.adn();
      initJSONABTestGetter();
      localObject1 = new f();
      if (com.tencent.luggage.bridge.a.a.bhU == null) {
        break label567;
      }
      com.tencent.luggage.j.c.e("Luggage.LuggageBoot", "do not setup more than once.");
    }
    for (;;)
    {
      if (!paramg.Ex()) {
        break label587;
      }
      com.tencent.mm.kernel.g.DQ().a(new PluginAppBrand.2(this));
      com.tencent.mm.plugin.af.c.odU.a(new ab());
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.a.class, new com.tencent.mm.kernel.c.e(new d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.p()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.f.class, new com.tencent.mm.kernel.c.e(new c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.c.class, new com.tencent.mm.kernel.c.e(new g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new com.tencent.mm.kernel.c.e(new h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.g.class, new com.tencent.mm.kernel.c.e(new am()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.r.b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.l.e()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.l.a()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[] { "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//localwxalibrary" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.kernel.g.DQ().a(new PluginAppBrand.3(this));
      if (DebuggerShell.aev()) {
        com.tencent.mm.kernel.g.a(DebuggerShell.class, new DebuggerShell());
      }
      t.a(new m());
      return;
      localObject1 = r.a.fHL;
      break;
      label567:
      com.tencent.luggage.bridge.a.a.bhU = (a.b)localObject1;
      ((a.b)localObject1).a(new a.1());
    }
    label587:
    if ((com.tencent.mm.sdk.platformtools.ae.cqX()) || (com.tencent.mm.sdk.platformtools.ae.cqY()) || (isAppBrandProcess()))
    {
      com.tencent.mm.plugin.appbrand.report.model.i.aol();
      com.tencent.mm.kernel.g.a(ag.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.g.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
      com.tencent.mm.plugin.appbrand.launching.precondition.j.cs(com.tencent.mm.sdk.platformtools.ae.getContext());
      localObject1 = this.singletonRegistry;
      Object localObject2 = paramg.bT;
      y.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.bT;
      ((com.tencent.mm.plugin.appbrand.v.d)localObject1).hlj = true;
      ((com.tencent.mm.plugin.appbrand.v.d)localObject1).app = ((Application)localObject2);
      localObject1 = this.singletonRegistry;
      localObject2 = com.tencent.mm.plugin.appbrand.v.a.a.hlJ;
      y.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject2 });
      ((com.tencent.mm.plugin.appbrand.v.d)localObject1).hlh.offer(localObject2);
    }
    if ((com.tencent.mm.sdk.platformtools.ae.cqX()) || (com.tencent.mm.sdk.platformtools.ae.cqY()))
    {
      com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
      al.a(new al.c()
      {
        public final void c(String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          if (bk.pm(paramAnonymousString).contains(".plugin.appbrand"))
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(365L, 3L, 1L, false);
            KVCommCrossProcessReceiver.bwU();
          }
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.cqX();
      return;
      if (isAppBrandProcess())
      {
        AppBrandProcessSuicideLogic.d(paramg.bT);
      }
      else if (isSupportProcess())
      {
        com.tencent.mm.plugin.appbrand.dynamic.e.b.a(new b.a()
        {
          public final void aaK()
          {
            com.tencent.mm.plugin.appbrand.dynamic.h.e.ce(com.tencent.mm.sdk.platformtools.ae.getContext());
          }
        });
        com.tencent.mm.plugin.appbrand.dynamic.e.b.initialize();
      }
    }
  }
  
  final e getCore()
  {
    return (e)com.tencent.mm.model.p.B(e.class);
  }
  
  public final List<ah> getDataTransferList()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new h.1(new com.tencent.mm.plugin.appbrand.config.h()));
    localLinkedList.add(new ad());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.e());
    return localLinkedList;
  }
  
  public final void installed()
  {
    alias(com.tencent.mm.plugin.appbrand.a.b.class);
    this.xWebViewInitCompleteEventIListener.cqo();
  }
  
  public final String name()
  {
    return "plugin-appbrand";
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease() {}
  
  private static final class a
    extends com.tencent.mm.model.p
    implements com.tencent.mm.kernel.a.b.b
  {
    private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a fAT;
    private final com.tencent.mm.sdk.b.c fAU = new PluginAppBrand.a.1(this);
    private com.tencent.mm.plugin.appbrand.debugger.h fAV = new com.tencent.mm.plugin.appbrand.debugger.h();
    
    a()
    {
      super();
    }
    
    public final void onAccountInitialized(e.c paramc)
    {
      super.onAccountInitialized(paramc);
      if (com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED)
      {
        paramc = new com.tencent.mm.plugin.appbrand.appusage.e();
        if (paramc.hJ(com.tencent.mm.protocal.d.spa)) {
          paramc.transfer(com.tencent.mm.protocal.d.spa);
        }
      }
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
      com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.l.d());
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.l.c());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.n.fCD));
      com.tencent.mm.kernel.g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.p()));
      com.tencent.mm.kernel.g.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
      com.tencent.mm.vfs.e.K(com.tencent.mm.sdk.platformtools.ae.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint/", true);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.c.fFe);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.l.b.gPM);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.l.f.gPZ);
      this.fAT = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
      com.tencent.mm.plugin.downloader.model.d.aFP();
      com.tencent.mm.plugin.downloader.model.b.a(this.fAT);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.fAV);
    }
    
    public final void onAccountRelease()
    {
      com.tencent.mm.kernel.g.s(ag.class);
      com.tencent.mm.kernel.g.s(af.class);
      com.tencent.mm.kernel.g.s(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      com.tencent.mm.kernel.g.s(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class);
      com.tencent.mm.kernel.g.s(com.tencent.mm.plugin.appbrand.appusage.c.class);
      super.onAccountRelease();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hb("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.c.fFe);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.l.b.gPM);
      com.tencent.mm.plugin.downloader.model.d.aFP();
      com.tencent.mm.plugin.downloader.model.b.b(this.fAT);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.fAV);
    }
    
    public final void parallelsDependency()
    {
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).ao(com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class));
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).ao(com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.appbrand.a.b.class));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */