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
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.an;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.appstorage.y.a;
import com.tencent.mm.plugin.appbrand.appstorage.y.b;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.appusage.ao;
import com.tencent.mm.plugin.appbrand.at;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.config.j.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsruntime.ab;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity;
import com.tencent.mm.plugin.appbrand.launching.bn;
import com.tencent.mm.plugin.appbrand.menu.k.a;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.task.preload.d.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Queue;

@Keep
public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, an, com.tencent.mm.plugin.appbrand.api.c
{
  public static final String TAG = "MicroMsg.PluginAppBrand[speedtest]";
  private final com.tencent.mm.plugin.appbrand.utils.g singletonRegistry;
  
  public PluginAppBrand()
  {
    AppMethodBeat.i(44152);
    this.singletonRegistry = new com.tencent.mm.plugin.appbrand.utils.g();
    AppMethodBeat.o(44152);
  }
  
  private void copyWxaDecodeKeyFile()
  {
    AppMethodBeat.i(174699);
    String str = aj.getContext().getApplicationContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
    if ((!com.tencent.mm.vfs.i.fv(str)) || (!"43bff1e72298b0ea0b73e2960d3c97b8".equals(com.tencent.mm.vfs.i.aPK(str))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.PluginAppBrand[speedtest]", "copy key file ok: %b", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.p.S(aj.getContext(), "wasae.dat", str)) });
      AppMethodBeat.o(174699);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.PluginAppBrand[speedtest]", "key file exist, skip copy");
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
    Object localObject = d.jDy;
    localObject = d.Lv();
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
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName.startsWith(str + ":appbrand");
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
      boolean bool = "com.tencent.mm:support".equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PluginAppBrand[speedtest]", "configure()");
    com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.plugin.appbrand.ui.c.a.a.mNT);
    if (isAppBrandProcess())
    {
      fixProcessSharedStringFormatLocale();
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.z.a()
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
      com.tencent.mm.sdk.a.b.b(com.tencent.mm.plugin.appbrand.e.a.kaA);
    }
    if ((!aj.cnC()) && (com.tencent.mm.cn.i.LAV == null))
    {
      com.tencent.mm.cn.i.LAV = new com.tencent.mm.vending.h.h(com.tencent.mm.cn.d.c(new ap(com.tencent.mm.sdk.g.a.aRF("WeChat.WORKER").getLooper())), "WeChat.WORKER");
      com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.cn.i.LAV);
    }
    AppMethodBeat.o(44157);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(44156);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PluginAppBrand[speedtest]", "dependency()");
    if (aj.cmR()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(44156);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44159);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PluginAppBrand[speedtest]", "execute() current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName, Boolean.valueOf(com.tencent.mm.sdk.platformtools.aq.isMainThread()) });
    if (com.tencent.mm.plugin.appbrand.report.a.a.bxr())
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(new com.tencent.mm.plugin.appbrand.keylogger.g());
      com.tencent.mm.plugin.appbrand.keylogger.c.bqt();
    }
    com.tencent.mm.plugin.appbrand.keylogger.d.a("WeAppLaunch", com.tencent.mm.plugin.appbrand.report.quality.n.mwc);
    com.tencent.mm.kernel.g.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.o.class, new com.tencent.mm.kernel.c.e(new bn()));
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.d.c.class, com.tencent.mm.plugin.appbrand.d.b.jVl);
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.xweb_ext.video.c()));
    }
    if (!isAppBrandProcess()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    }
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    }
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.report.c()));
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.c.g()));
    if (paramg.akw()) {}
    for (Object localObject1 = y.b.jNI;; localObject1 = y.a.jNG)
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      if (isAppBrandProcess())
      {
        localObject1 = com.tencent.mm.plugin.webview.c.a.DMt;
        com.tencent.mm.plugin.webview.c.a.eOu();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PluginAppBrand[speedtest]", "init DefaultJsApiPool");
        com.tencent.mm.plugin.appbrand.game.c.b.Cx();
        com.tencent.luggage.game.b.c.Cw().ciJ = new com.tencent.mm.plugin.appbrand.game.d.a();
        com.tencent.mm.plugin.appbrand.z.g.bBl();
        com.tencent.xweb.s.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.nrn);
      }
      com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl", new PluginAppBrand.6(this, paramg));
      if (!paramg.akw()) {
        break;
      }
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.z.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(187985);
          if (((paramAnonymousActivity instanceof KeyStepBaseActivity)) && (!com.tencent.mm.plugin.appbrand.report.a.a.bxr())) {
            paramAnonymousActivity.finish();
          }
          AppMethodBeat.o(187985);
        }
      });
      paramg = com.tencent.mm.msgsubscription.storage.f.iBR;
      com.tencent.mm.msgsubscription.storage.f.a("name_wxa", new com.tencent.mm.msgsubscription.storage.a()
      {
        public final com.tencent.mm.msgsubscription.storage.d aOt()
        {
          return com.tencent.mm.am.b.b.hSI;
        }
      });
      com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
      {
        public final void MP()
        {
          AppMethodBeat.i(44140);
          com.tencent.mm.plugin.appbrand.ui.banner.d.bAb();
          AppMethodBeat.o(44140);
        }
        
        public final void cg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(44141);
          AppMethodBeat.o(44141);
        }
      });
      paramg = com.tencent.mm.plugin.appbrand.widget.desktop.a.b.mZh;
      com.tencent.mm.plugin.appbrand.widget.desktop.a.b.init(aj.getContext());
      com.tencent.mm.plugin.y.c.yQR.a(new at());
      com.tencent.mm.plugin.y.c.yQR.a(new com.tencent.mm.plugin.appbrand.au());
      com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.n.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.t()));
      com.tencent.mm.kernel.g.a(q.class, new com.tencent.mm.kernel.c.e(new f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.api.e.class, new com.tencent.mm.kernel.c.e(new l()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.a.b.class, new com.tencent.mm.kernel.c.e(new m()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.s.class, new com.tencent.mm.kernel.c.e(new ao()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.utils.m()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new b()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[] { "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_monkey_bringtofront", "//appbrand_monkey_test_skip_appbrand_process_suicide", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_ps", "//xweb_video_player", "//xweb_video_proxy", "//xweb_video_hls_proxy", "//xweb_hls_video_player", "//xweb_video", "//showad", "//allshowad", "//localwxalibrary" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.plugin.appbrand.xweb_ext.b.Cx();
      com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
      {
        public final void MP()
        {
          AppMethodBeat.i(187986);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).initialize();
          AppMethodBeat.o(187986);
        }
        
        public final void cg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(187987);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).shutdown();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDE().exit();
          AppMethodBeat.o(187987);
        }
      });
      if (DebuggerShell.bex()) {
        com.tencent.mm.kernel.g.b(DebuggerShell.class, new DebuggerShell());
      }
      com.tencent.mm.plugin.appbrand.appcache.ad.a(new com.tencent.mm.plugin.appbrand.appcache.w());
      com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().a(aj.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bGo(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bGq(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.bGn(), null);
      AppMethodBeat.o(44159);
      return;
    }
    Object localObject2;
    if (isAppBrandProcess())
    {
      com.tencent.mm.plugin.appbrand.debugger.b.setup();
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.ca;
      ((com.tencent.mm.plugin.appbrand.utils.g)localObject1).mOF = true;
      ((com.tencent.mm.plugin.appbrand.utils.g)localObject1).app = ((Application)localObject2);
      localObject1 = this.singletonRegistry;
      localObject2 = com.tencent.mm.plugin.appbrand.utils.a.a.mPB;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject2 });
      ((com.tencent.mm.plugin.appbrand.utils.g)localObject1).mOD.offer(localObject2);
      com.tencent.mm.plugin.appbrand.h.i(paramg.ca);
      com.tencent.mm.ui.am.i(paramg.ca);
      localObject1 = com.tencent.mm.plugin.appbrand.luggage.b.c.lOb;
      localObject2 = paramg.ca;
      d.g.b.p.h(localObject2, "app");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().a(aj.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bGo(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.bGq(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.bGn(), null);
    }
    if ((aj.fkI()) || (aj.fkJ()))
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new i()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qux, 0) != 1) {
        break label1647;
      }
    }
    label1647:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().a(aj.getContext(), bool, bool, com.tencent.mm.plugin.appbrand.xweb_ext.video.a.bGn(), new com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a());
      if (isAppBrandProcess())
      {
        com.tencent.mm.sdk.platformtools.au.a(new au.c()
        {
          public final void a(com.tencent.mm.sdk.platformtools.au paramAnonymousau, String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(187988);
            if (bt.nullAsNil(paramAnonymousString).contains(".plugin.appbrand"))
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(365L, 3L, 1L, false);
              KVCommCrossProcessReceiver.dKl();
            }
            AppMethodBeat.o(187988);
          }
        });
        AppBrandProcessSuicideLogic.c(paramg.ca);
        c.j(paramg.ca);
      }
      try
      {
        localObject1 = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "pref_appbrand_process", 4);
        localObject2 = aj.getProcessName() + ":start_time";
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        if (((SharedPreferences)localObject1).contains((String)localObject2))
        {
          localEditor.remove((String)localObject2);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 2L, 1L, false);
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 4L, 1L, false);
        localEditor.putLong((String)localObject2, System.currentTimeMillis());
        localEditor.commit();
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandReporter", "onProcessStart");
        KVCommCrossProcessReceiver.dKj();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessStart()", new Object[0]);
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
        com.tencent.mm.plugin.appbrand.dynamic.h.e.dl(aj.getContext());
        com.tencent.mm.ac.h.initialize();
      }
      if (aj.fkI()) {
        com.tencent.mm.ac.h.initialize();
      }
      AppMethodBeat.o(44159);
      return;
    }
  }
  
  final j getCore()
  {
    AppMethodBeat.i(44154);
    j localj = (j)com.tencent.mm.model.t.ap(j.class);
    AppMethodBeat.o(44154);
    return localj;
  }
  
  public final List<com.tencent.mm.model.am> getDataTransferList()
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PluginAppBrand[speedtest]", "installed()");
    alias(com.tencent.mm.plugin.appbrand.api.c.class);
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
    extends com.tencent.mm.model.t
    implements com.tencent.mm.app.n, com.tencent.mm.kernel.a.b.b
  {
    private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a jDP;
    private com.tencent.mm.plugin.appbrand.debugger.k jDQ;
    
    a()
    {
      super();
      AppMethodBeat.i(44144);
      this.jDQ = new com.tencent.mm.plugin.appbrand.debugger.k();
      AppMethodBeat.o(44144);
    }
    
    private static void a(String paramString, d.a parama)
    {
      AppMethodBeat.i(44146);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PluginAppBrand[speedtest]", "AppBrandCompatCore tryPreloadNextTaskProcess (both waservice and wagame) reason[%s]", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.task.f.a(com.tencent.mm.plugin.appbrand.task.e.myg, parama);
      com.tencent.mm.plugin.appbrand.task.f.a(com.tencent.mm.plugin.appbrand.task.e.myh, parama);
      AppMethodBeat.o(44146);
    }
    
    public final void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(44145);
      super.onAccountInitialized(paramc);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.PluginAppBrand[speedtest]", "onAccountInitialized, WAKeyStepKvLogger.ENABLE=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.appbrand.report.quality.n.bxY()) });
      as.a(com.tencent.mm.plugin.appbrand.appcache.aq.jHb);
      if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
      {
        paramc = new com.tencent.mm.plugin.appbrand.appusage.e();
        if (paramc.op(com.tencent.mm.protocal.d.Fnj)) {
          paramc.transfer(com.tencent.mm.protocal.d.Fnj);
        }
        paramc = new ab();
        if (paramc.op(com.tencent.mm.protocal.d.Fnj)) {
          paramc.transfer(com.tencent.mm.protocal.d.Fnj);
        }
      }
      if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
        com.tencent.mm.plugin.appbrand.appusage.j.bbX().bbY();
      }
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
      paramc = new com.tencent.mm.plugin.appbrand.appusage.s();
      if (paramc.op(com.tencent.mm.protocal.d.Fnj)) {
        paramc.transfer(com.tencent.mm.protocal.d.Fnj);
      }
      paramc = new com.tencent.mm.plugin.appbrand.appusage.r();
      if (paramc.op(com.tencent.mm.protocal.d.Fnj)) {
        paramc.transfer(com.tencent.mm.protocal.d.Fnj);
      }
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.f());
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.e());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.api.b.class, new com.tencent.mm.kernel.c.e(x.jGy));
      com.tencent.mm.kernel.g.a(ai.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.p()));
      com.tencent.mm.kernel.g.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.s.aXG()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.i()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.r.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.b.d()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.vfs.i.cZ(aj.getContext().getFilesDir().getParent() + "/voice_split_joint/", true);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.f.jJY);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.lUi);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.lTU);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.message.h.lUu);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.lTY);
      this.jDP = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
      com.tencent.mm.plugin.downloader.model.f.ccl();
      com.tencent.mm.plugin.downloader.model.c.a(this.jDP);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.jDQ);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(new AppBrandMixExportLogicService()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.launching.b.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.launching.b.a.lMh));
      com.tencent.mm.blink.b.Wi().w(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44143);
          PluginAppBrand.a.b("FirstScreenArrangement", d.a.mza);
          AppMethodBeat.o(44143);
        }
      });
      com.tencent.mm.plugin.appbrand.appcache.h.a(new h.a()
      {
        public final com.tencent.mm.cn.f<com.tencent.mm.al.a.a<blq>> a(com.tencent.mm.plugin.appbrand.appcache.h paramAnonymoush)
        {
          AppMethodBeat.i(180188);
          paramAnonymoush = com.tencent.mm.plugin.appbrand.launching.w.b(paramAnonymoush);
          AppMethodBeat.o(180188);
          return paramAnonymoush;
        }
      });
      paramc = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.nan;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.c.bDD();
      v.setup();
      AppMethodBeat.o(44145);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(44150);
      com.tencent.mm.kernel.g.ac(ai.class);
      com.tencent.mm.kernel.g.ac(ah.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.service.f.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
      com.tencent.mm.kernel.g.ac(IAppBrandBatchPreloadController.class);
      com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.appbrand.appusage.c.class);
      super.onAccountRelease();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.f.jJY);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.lUi);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.lTU);
      com.tencent.mm.plugin.downloader.model.f.ccl();
      com.tencent.mm.plugin.downloader.model.c.b(this.jDP);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.jDQ);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.lTY);
      com.tencent.mm.plugin.appbrand.u.a.bwX();
      com.tencent.mm.plugin.appbrand.widget.desktop.b.c localc = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.nan;
      com.tencent.mm.plugin.appbrand.widget.desktop.b.c.release();
      AppMethodBeat.o(44150);
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(44148);
      paramString = com.tencent.mm.plugin.appbrand.ipc.a.a.kqd;
      com.tencent.mm.plugin.appbrand.ipc.a.a.bhY();
      AppMethodBeat.o(44148);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(44147);
      a("onAppForeground:".concat(String.valueOf(paramString)), d.a.mzb);
      AppMethodBeat.o(44147);
    }
    
    public final void parallelsDependency()
    {
      AppMethodBeat.i(44149);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class));
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.appbrand.api.c.class));
      AppMethodBeat.o(44149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */