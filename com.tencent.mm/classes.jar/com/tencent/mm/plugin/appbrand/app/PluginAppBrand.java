package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.annotation.Keep;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.al;
import com.tencent.mm.model.am;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.y.a;
import com.tencent.mm.plugin.appbrand.appstorage.y.b;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.appusage.ao;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.at;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.config.j.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsruntime.ab;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity;
import com.tencent.mm.plugin.appbrand.launching.bk;
import com.tencent.mm.plugin.appbrand.menu.k.a;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.task.preload.d.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ak;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Queue;

@Keep
public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, am, com.tencent.mm.plugin.appbrand.a.c
{
  public static final String TAG = "MicroMsg.PluginAppBrand[speedtest]";
  private final com.tencent.mm.plugin.appbrand.utils.f singletonRegistry;
  
  public PluginAppBrand()
  {
    AppMethodBeat.i(44152);
    this.singletonRegistry = new com.tencent.mm.plugin.appbrand.utils.f();
    AppMethodBeat.o(44152);
  }
  
  private void copyWxaDecodeKeyFile()
  {
    AppMethodBeat.i(174699);
    String str = aj.getContext().getApplicationContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
    if ((!com.tencent.mm.vfs.i.eK(str)) || (!"43bff1e72298b0ea0b73e2960d3c97b8".equals(com.tencent.mm.vfs.i.aEN(str))))
    {
      ad.d("MicroMsg.PluginAppBrand[speedtest]", "copy key file ok: %b", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.o.Q(aj.getContext(), "wasae.dat", str)) });
      AppMethodBeat.o(174699);
      return;
    }
    ad.d("MicroMsg.PluginAppBrand[speedtest]", "key file exist, skip copy");
    AppMethodBeat.o(174699);
  }
  
  private static void fixProcessSharedStringFormatLocale()
  {
    AppMethodBeat.i(44158);
    if (Build.VERSION.SDK_INT >= 24) {
      Locale.setDefault(Locale.Category.FORMAT, Locale.ENGLISH);
    }
    AppMethodBeat.o(44158);
  }
  
  public static SharedPreferences getProcessSharedPrefs()
  {
    AppMethodBeat.i(44162);
    Object localObject = d.iJD;
    localObject = d.Km();
    AppMethodBeat.o(44162);
    return localObject;
  }
  
  @Deprecated
  private void initJSONABTestGetter()
  {
    AppMethodBeat.i(44163);
    com.tencent.mm.ac.h.a(new com.tencent.mm.ac.e() {});
    AppMethodBeat.o(44163);
  }
  
  static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(44160);
    try
    {
      String str = aj.getPackageName();
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName.startsWith(str + ":appbrand");
      AppMethodBeat.o(44160);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(44160);
    }
    return false;
  }
  
  static boolean isSupportProcess()
  {
    AppMethodBeat.i(44161);
    try
    {
      boolean bool = "com.tencent.mm:support".equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName);
      AppMethodBeat.o(44161);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(44161);
    }
    return false;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44157);
    ad.i("MicroMsg.PluginAppBrand[speedtest]", "configure()");
    com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.plugin.appbrand.ui.c.a.a.lLu);
    if (isAppBrandProcess())
    {
      fixProcessSharedStringFormatLocale();
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.aa.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(44135);
          PluginAppBrand.access$100();
          AppMethodBeat.o(44135);
        }
        
        public final void onActivityStarted(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(44136);
          PluginAppBrand.access$100();
          AppMethodBeat.o(44136);
        }
      });
      paramg.ca.registerComponentCallbacks(new ComponentCallbacks()
      {
        public final void onConfigurationChanged(Configuration paramAnonymousConfiguration)
        {
          AppMethodBeat.i(44137);
          PluginAppBrand.access$100();
          AppMethodBeat.o(44137);
        }
        
        public final void onLowMemory() {}
      });
      com.tencent.mm.sdk.a.b.b(com.tencent.mm.plugin.appbrand.f.a.jgc);
    }
    if ((!aj.cbv()) && (com.tencent.mm.co.i.Igq == null))
    {
      com.tencent.mm.co.i.Igq = new com.tencent.mm.vending.h.h(com.tencent.mm.co.d.c(new com.tencent.mm.sdk.platformtools.ap(com.tencent.mm.sdk.g.a.aGG("WeChat.WORKER").getLooper())), "WeChat.WORKER");
      com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.co.i.Igq);
    }
    AppMethodBeat.o(44157);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(44156);
    ad.i("MicroMsg.PluginAppBrand[speedtest]", "dependency()");
    if (aj.cbe()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(44156);
  }
  
  public final void execute(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44159);
    ad.i("MicroMsg.PluginAppBrand[speedtest]", "execute() current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName, Boolean.valueOf(aq.isMainThread()) });
    if (com.tencent.mm.plugin.appbrand.report.a.a.bmq())
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(new com.tencent.mm.plugin.appbrand.keylogger.g());
      com.tencent.mm.plugin.appbrand.keylogger.c.bfO();
    }
    com.tencent.mm.plugin.appbrand.keylogger.d.a("WeAppLaunch", com.tencent.mm.plugin.appbrand.report.quality.n.lut);
    com.tencent.mm.kernel.g.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.n.class, new com.tencent.mm.kernel.c.e(new bk()));
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.e.c.class, com.tencent.mm.plugin.appbrand.e.b.jbd);
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.xweb_ext.video.c()));
    }
    if (!isAppBrandProcess()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    }
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.o.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.c.g()));
    if (paramg.agu()) {}
    for (Object localObject1 = y.b.iTD;; localObject1 = y.a.iTB)
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      if (isAppBrandProcess())
      {
        localObject1 = com.tencent.mm.plugin.webview.c.a.ARa;
        com.tencent.mm.plugin.webview.c.a.ekk();
        ad.i("MicroMsg.PluginAppBrand[speedtest]", "init DefaultJsApiPool");
        com.tencent.mm.plugin.appbrand.game.c.b.Bu();
        com.tencent.luggage.game.b.c.Bt().cbu = new com.tencent.mm.plugin.appbrand.game.d.a();
        com.tencent.mm.plugin.appbrand.aa.g.bqi();
        com.tencent.xweb.r.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.moM);
      }
      com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44138);
          k localk = new k(paramg);
          if (com.tencent.luggage.bridge.a.a.bZK != null)
          {
            ad.e("Luggage.LuggageBoot", "do not setup more than once.");
            AppMethodBeat.o(44138);
            return;
          }
          com.tencent.luggage.bridge.a.a.bZK = localk;
          localk.a(new a.1());
          AppMethodBeat.o(44138);
        }
      });
      if (!paramg.agu()) {
        break;
      }
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.aa.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(195597);
          if (((paramAnonymousActivity instanceof KeyStepBaseActivity)) && (!com.tencent.mm.plugin.appbrand.report.a.a.bmq())) {
            paramAnonymousActivity.finish();
          }
          AppMethodBeat.o(195597);
        }
      });
      paramg = com.tencent.mm.msgsubscription.storage.f.hHV;
      com.tencent.mm.msgsubscription.storage.f.a("name_wxa", new com.tencent.mm.msgsubscription.storage.a()
      {
        public final com.tencent.mm.msgsubscription.storage.d aEs()
        {
          return com.tencent.mm.am.b.b.gZO;
        }
      });
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(44140);
          com.tencent.mm.plugin.appbrand.ui.banner.d.bpa();
          AppMethodBeat.o(44140);
        }
        
        public final void ce(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(44141);
          AppMethodBeat.o(44141);
        }
      });
      paramg = com.tencent.mm.plugin.appbrand.widget.desktop.a.b.lWx;
      com.tencent.mm.plugin.appbrand.widget.desktop.a.b.init(aj.getContext());
      com.tencent.mm.plugin.x.c.wqQ.a(new as());
      com.tencent.mm.plugin.x.c.wqQ.a(new at());
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.s()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.p.class, new com.tencent.mm.kernel.c.e(new f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.e.class, new com.tencent.mm.kernel.c.e(new l()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new com.tencent.mm.kernel.c.e(new m()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.r.class, new com.tencent.mm.kernel.c.e(new ao()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.n.f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.n.b()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.utils.m()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.kernel.c.e(new a()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[] { "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_monkey_bringtofront", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_ps", "//xweb_video_player", "//xweb_video_proxy", "//xweb_video_hls_proxy", "//xweb_hls_video_player", "//xweb_video", "//showad", "//allshowad", "//localwxalibrary" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.plugin.appbrand.xweb_ext.b.Bu();
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(195598);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).initialize();
          AppMethodBeat.o(195598);
        }
        
        public final void ce(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(195599);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).shutdown();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().exit();
          AppMethodBeat.o(195599);
        }
      });
      if (DebuggerShell.aTZ()) {
        com.tencent.mm.kernel.g.b(DebuggerShell.class, new DebuggerShell());
      }
      ac.a(new v());
      com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK().a(aj.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bvn(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bvp(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.bvm(), null);
      AppMethodBeat.o(44159);
      return;
    }
    Object localObject2;
    if (isAppBrandProcess())
    {
      com.tencent.mm.kernel.g.a(ai.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.o()));
      com.tencent.mm.kernel.g.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataTokenStorageIPC()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.flutter.a.a.class, new com.tencent.mm.plugin.flutter.b());
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new i()));
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.ca;
      ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.ca;
      ((com.tencent.mm.plugin.appbrand.utils.f)localObject1).lMf = true;
      ((com.tencent.mm.plugin.appbrand.utils.f)localObject1).app = ((Application)localObject2);
      localObject1 = this.singletonRegistry;
      localObject2 = com.tencent.mm.plugin.appbrand.utils.a.a.lMW;
      ad.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject2 });
      ((com.tencent.mm.plugin.appbrand.utils.f)localObject1).lMd.offer(localObject2);
      com.tencent.mm.plugin.appbrand.h.g(paramg.ca);
      ak.g(paramg.ca);
      localObject1 = com.tencent.mm.plugin.appbrand.luggage.b.c.kPe;
      localObject2 = paramg.ca;
      d.g.b.k.h(localObject2, "app");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK().a(aj.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bvn(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bvp(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.bvm(), null);
    }
    if ((aj.eFJ()) || (aj.eFK()))
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new i()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmK, 0) != 1) {
        break label1610;
      }
    }
    label1610:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK().a(aj.getContext(), bool, bool, com.tencent.mm.plugin.appbrand.xweb_ext.video.a.bvm(), new com.tencent.luggage.k.a.a.b.a.a.a());
      if (isAppBrandProcess())
      {
        au.a(new au.c()
        {
          public final void b(String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(195600);
            if (bt.nullAsNil(paramAnonymousString).contains(".plugin.appbrand"))
            {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(365L, 3L, 1L, false);
              KVCommCrossProcessReceiver.dkK();
            }
            AppMethodBeat.o(195600);
          }
        });
        AppBrandProcessSuicideLogic.c(paramg.ca);
        c.h(paramg.ca);
      }
      try
      {
        localObject1 = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "pref_appbrand_process", 4);
        localObject2 = aj.getProcessName() + ":start_time";
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        if (((SharedPreferences)localObject1).contains((String)localObject2))
        {
          localEditor.remove((String)localObject2);
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 2L, 1L, false);
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 4L, 1L, false);
        localEditor.putLong((String)localObject2, System.currentTimeMillis());
        localEditor.commit();
        ad.v("MicroMsg.AppBrandReporter", "onProcessStart");
        KVCommCrossProcessReceiver.dkI();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessStart()", new Object[0]);
        }
      }
      com.tencent.mm.plugin.appbrand.task.preload.f.c(paramg.ca);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.b()));
      copyWxaDecodeKeyFile();
      CdnLogic.InitSavePath("/data/user/0/com.tencent.mm/MicroMsg/CronetCache/appbrand/cache/", new CdnLogic.AppCallback()
      {
        public final void onBadNetworkProbed() {}
        
        public final void reportFlow(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
        
        public final void requestGetCDN(int paramAnonymousInt) {}
        
        public final String[] resolveHost(String paramAnonymousString, boolean paramAnonymousBoolean, int[] paramAnonymousArrayOfInt)
        {
          return new String[0];
        }
      });
      if (isSupportProcess())
      {
        com.tencent.mm.plugin.appbrand.dynamic.h.e.de(aj.getContext());
        com.tencent.mm.ac.h.initialize();
      }
      if (aj.eFJ()) {
        com.tencent.mm.ac.h.initialize();
      }
      AppMethodBeat.o(44159);
      return;
    }
  }
  
  final j getCore()
  {
    AppMethodBeat.i(44154);
    j localj = (j)t.ap(j.class);
    AppMethodBeat.o(44154);
    return localj;
  }
  
  public final List<al> getDataTransferList()
  {
    AppMethodBeat.i(44153);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new j.1(new com.tencent.mm.plugin.appbrand.config.j()));
    localLinkedList.add(new af());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.e());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.s());
    localLinkedList.add(new ab());
    localLinkedList.add(new k.a());
    AppMethodBeat.o(44153);
    return localLinkedList;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(44155);
    ad.i("MicroMsg.PluginAppBrand[speedtest]", "installed()");
    alias(com.tencent.mm.plugin.appbrand.a.c.class);
    if (!isAppBrandProcess()) {
      new com.tencent.mm.sdk.b.c() {}.alive();
    }
    AppMethodBeat.o(44155);
  }
  
  public final String name()
  {
    return "plugin-appbrand";
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease() {}
  
  static final class a
    extends t
    implements com.tencent.mm.app.n, com.tencent.mm.kernel.a.b.b
  {
    private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a iJT;
    private com.tencent.mm.plugin.appbrand.debugger.j iJU;
    
    a()
    {
      super();
      AppMethodBeat.i(44144);
      this.iJU = new com.tencent.mm.plugin.appbrand.debugger.j();
      AppMethodBeat.o(44144);
    }
    
    private static void a(String paramString, d.a parama)
    {
      AppMethodBeat.i(44146);
      ad.i("MicroMsg.PluginAppBrand[speedtest]", "AppBrandCompatCore tryPreloadNextTaskProcess (both waservice and wagame) reason[%s]", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.task.f.a(com.tencent.mm.plugin.appbrand.task.e.lwx, parama);
      com.tencent.mm.plugin.appbrand.task.f.a(com.tencent.mm.plugin.appbrand.task.e.lwy, parama);
      AppMethodBeat.o(44146);
    }
    
    public final void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(44145);
      super.onAccountInitialized(paramc);
      ar.a(com.tencent.mm.plugin.appbrand.appcache.ap.iMW);
      if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
      {
        paramc = new com.tencent.mm.plugin.appbrand.appusage.e();
        if (paramc.nb(com.tencent.mm.protocal.d.CpK)) {
          paramc.transfer(com.tencent.mm.protocal.d.CpK);
        }
        paramc = new ab();
        if (paramc.nb(com.tencent.mm.protocal.d.CpK)) {
          paramc.transfer(com.tencent.mm.protocal.d.CpK);
        }
      }
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
        com.tencent.mm.plugin.appbrand.appusage.j.aRE().aRF();
      }
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
      paramc = new com.tencent.mm.plugin.appbrand.appusage.s();
      if (paramc.nb(com.tencent.mm.protocal.d.CpK)) {
        paramc.transfer(com.tencent.mm.protocal.d.CpK);
      }
      paramc = new com.tencent.mm.plugin.appbrand.appusage.r();
      if (paramc.nb(com.tencent.mm.protocal.d.CpK)) {
        paramc.transfer(com.tencent.mm.protocal.d.CpK);
      }
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.n.e());
      ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.n.d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.b.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.w.iMv));
      com.tencent.mm.kernel.g.a(ai.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.p()));
      com.tencent.mm.kernel.g.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.s.aNE()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.i()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.q.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.b.d()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.vfs.i.cO(aj.getContext().getFilesDir().getParent() + "/voice_split_joint/", true);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.f.iPU);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.n.c.kTu);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("weapp_pushmsg", com.tencent.mm.plugin.appbrand.n.a.kTk);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.n.g.kTG);
      this.iJT = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
      com.tencent.mm.plugin.downloader.model.f.bQt();
      com.tencent.mm.plugin.downloader.model.c.a(this.iJT);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.iJU);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new AppBrandMixExportLogicService()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.launching.b.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.launching.b.a.kNq));
      com.tencent.mm.blink.b.SX().v(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44143);
          PluginAppBrand.a.b("FirstScreenArrangement", d.a.lxq);
          AppMethodBeat.o(44143);
        }
      });
      com.tencent.mm.plugin.appbrand.appcache.h.a(new h.a()
      {
        public final com.tencent.mm.co.f<c.a<bdq>> a(com.tencent.mm.plugin.appbrand.appcache.h paramAnonymoush)
        {
          AppMethodBeat.i(180188);
          paramAnonymoush = com.tencent.mm.plugin.appbrand.launching.w.b(paramAnonymoush);
          AppMethodBeat.o(180188);
          return paramAnonymoush;
        }
      });
      paramc = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.lXD;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.c.bsz();
      AppMethodBeat.o(44145);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(44150);
      com.tencent.mm.kernel.g.ac(ai.class);
      com.tencent.mm.kernel.g.ac(ah.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.service.g.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
      com.tencent.mm.kernel.g.ac(IAppBrandBatchPreloadController.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.appusage.c.class);
      super.onAccountRelease();
      ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afO("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.f.iPU);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.n.c.kTu);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("weapp_pushmsg", com.tencent.mm.plugin.appbrand.n.a.kTk);
      com.tencent.mm.plugin.downloader.model.f.bQt();
      com.tencent.mm.plugin.downloader.model.c.b(this.iJT);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.iJU);
      com.tencent.mm.plugin.appbrand.v.a.blX();
      com.tencent.mm.plugin.appbrand.widget.desktop.b.c localc = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.lXD;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.c.release();
      AppMethodBeat.o(44150);
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(44148);
      paramString = com.tencent.mm.plugin.appbrand.ipc.a.a.jvt;
      com.tencent.mm.plugin.appbrand.ipc.a.a.aXx();
      AppMethodBeat.o(44148);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(44147);
      a("onAppForeground:".concat(String.valueOf(paramString)), d.a.lxr);
      AppMethodBeat.o(44147);
    }
    
    public final void parallelsDependency()
    {
      AppMethodBeat.i(44149);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bB(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class));
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bB(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.appbrand.a.c.class));
      AppMethodBeat.o(44149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */