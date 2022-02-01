package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.sdk.processes.main.LuggageInitTask;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.bv.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appstorage.ag.a;
import com.tencent.mm.plugin.appbrand.appstorage.ag.b;
import com.tencent.mm.plugin.appbrand.appusage.ad;
import com.tencent.mm.plugin.appbrand.appusage.an;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.bo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.l.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity;
import com.tencent.mm.plugin.appbrand.launching.bh;
import com.tencent.mm.plugin.appbrand.menu.o.a;
import com.tencent.mm.plugin.appbrand.n.ac;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.a.d;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import com.tencent.mm.ui.ay;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Queue;

public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.model.av, com.tencent.mm.plugin.appbrand.api.c
{
  public static final String TAG = "MicroMsg.PluginAppBrand[speedtest]";
  public static final long WXA_CACHE_SIZE = 536870912L;
  private static final com.tencent.mm.ipcinvoker.b ipcSerialThreadPoolDelegate;
  private com.tencent.mm.plugin.appbrand.appcache.bp mWxaPkgStorageRouter;
  private final com.tencent.mm.plugin.appbrand.utils.n singletonRegistry;
  
  static
  {
    AppMethodBeat.i(317828);
    ipcSerialThreadPoolDelegate = new PluginAppBrand.1();
    AppMethodBeat.o(317828);
  }
  
  public PluginAppBrand()
  {
    AppMethodBeat.i(44152);
    this.singletonRegistry = new com.tencent.mm.plugin.appbrand.utils.n();
    AppMethodBeat.o(44152);
  }
  
  private void copyWxaDecodeKeyFile()
  {
    AppMethodBeat.i(174699);
    String str = MMApplicationContext.getContext().getApplicationContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
    if ((!com.tencent.mm.vfs.y.ZC(str)) || (!"43bff1e72298b0ea0b73e2960d3c97b8".equals(com.tencent.mm.vfs.y.bub(str))))
    {
      Log.d("MicroMsg.PluginAppBrand[speedtest]", "copy key file ok: %b", new Object[] { Boolean.valueOf(FilesCopy.copyAssets(MMApplicationContext.getContext(), "wasae.dat", str)) });
      AppMethodBeat.o(174699);
      return;
    }
    Log.d("MicroMsg.PluginAppBrand[speedtest]", "key file exist, skip copy");
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
    Object localObject = f.qBv;
    localObject = f.aBP();
    AppMethodBeat.o(44162);
    return localObject;
  }
  
  @Deprecated
  private void initJSONABTestGetter()
  {
    AppMethodBeat.i(44163);
    com.tencent.mm.ad.h.a(new com.tencent.mm.ad.e()
    {
      boolean clZ;
      int qCs;
      
      public final int aZm()
      {
        return this.qCs;
      }
      
      public final boolean isValid()
      {
        return this.clZ;
      }
    });
    AppMethodBeat.o(44163);
  }
  
  static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(44160);
    try
    {
      String str = MMApplicationContext.getPackageName();
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName.startsWith(str + ":appbrand");
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
      boolean bool = SupportProcessIPCService.PROCESS_NAME.equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName);
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
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "configure()");
    com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.plugin.appbrand.ui.b.a.a.upG);
    if (isAppBrandProcess())
    {
      fixProcessSharedStringFormatLocale();
      paramg.bGP.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.af.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(317734);
          PluginAppBrand.access$100();
          AppMethodBeat.o(317734);
        }
        
        public final void onActivityStarted(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(317737);
          PluginAppBrand.access$100();
          AppMethodBeat.o(317737);
        }
      });
      paramg.bGP.registerComponentCallbacks(new ComponentCallbacks()
      {
        public final void onConfigurationChanged(Configuration paramAnonymousConfiguration)
        {
          AppMethodBeat.i(317645);
          PluginAppBrand.access$100();
          AppMethodBeat.o(317645);
        }
        
        public final void onLowMemory() {}
      });
      CrashReportFactory.addCrashReportExtraMessageGetter(com.tencent.mm.plugin.appbrand.crash_report.a.rcS);
    }
    if ((!MMApplicationContext.isMMProcess()) && (com.tencent.mm.cp.i.agWI == null))
    {
      com.tencent.mm.cp.i.agWI = new com.tencent.mm.vending.h.h(com.tencent.mm.cp.d.c(new MMHandler(DeprecatedThreadFactory.createHandlerThread("WeChat.WORKER").getLooper())), "WeChat.WORKER");
      com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.cp.i.agWI);
    }
    com.tencent.mm.vfs.af.a("MixAudio", "MixAudio", 259200000L, 101);
    com.tencent.mm.vfs.af.a("ExoVideoCache", "videocache", 259200000L, 101);
    com.tencent.mm.vfs.af.a("wagamefiles", "wagamefiles", 86400000L, 517);
    com.tencent.mm.vfs.af.b("WxaCommCacheFiles", "wxacache/", 536870912L, 7776000000L, 37);
    com.tencent.mm.vfs.af.b("AppBrandEmojiCache", "appbrand/emojicache/", 536870912L, 259200000L, 6);
    com.tencent.mm.vfs.af.a("wxaFlattenFileSystem", "wxafiles/", 9223372036854775807L, 517);
    com.tencent.mm.vfs.af.a("wxaNonFlattenFileSystem", "wxanewfiles/", 9223372036854775807L, 517);
    com.tencent.mm.vfs.af.a("WxaJsCodeCache", "appbrand/jscache/", 9223372036854775807L, 6);
    com.tencent.mm.vfs.af.a("WxaWASMCache", "appbrand/wasmcache/", 9223372036854775807L, 6);
    com.tencent.mm.vfs.g.aQ(null, "appbrand", 6);
    com.tencent.mm.vfs.af.aR("WxaCodePkgsCache", "appbrand", 2);
    com.tencent.mm.vfs.af.a("ThumbVideoCache", "ThumbVideoCache", 259200000L, 101);
    com.tencent.mm.vfs.af.a("WxaSecureInput", "appbrand/secureInput/", 9223372036854775807L, 6);
    com.tencent.mm.vfs.af.a("QQMusicCache", "QQMusic", 259200000L, 102);
    com.tencent.mm.vfs.af.b("AppBrandXnetModelCache", "appbrand/appBrandXnetModelCache/", 536870912L, 1296000000L, 97);
    AppMethodBeat.o(44157);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(44156);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "dependency()");
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    }
    AppMethodBeat.o(44156);
  }
  
  public final void execute(final com.tencent.mm.kernel.b.g paramg)
  {
    Object localObject2 = null;
    int k = 2;
    AppMethodBeat.i(44159);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "execute() current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName, Boolean.valueOf(MMHandlerThread.isMainThread()) });
    if (com.tencent.mm.plugin.appbrand.report.a.a.cIH())
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(new com.tencent.mm.plugin.appbrand.keylogger.g());
      com.tencent.mm.plugin.appbrand.keylogger.c.czs();
    }
    com.tencent.mm.plugin.appbrand.keylogger.d.a("WeAppLaunch", com.tencent.mm.plugin.appbrand.report.quality.n.tTb);
    com.tencent.mm.kernel.h.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.t.class, new com.tencent.mm.kernel.c.e(new bh()));
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.e.c.class, com.tencent.mm.plugin.appbrand.e.b.qVq);
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.xweb_ext.video.d()));
      bv.a.f(paramg);
    }
    if (!isAppBrandProcess()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    }
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    }
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.report.c()));
    }
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.c.g()));
    if (paramg.bbA()) {}
    for (Object localObject1 = ag.b.qOc;; localObject1 = ag.a.qOa)
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.j.class, com.tencent.mm.plugin.appbrand.openmaterial.b.tre);
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.kernel.c.e(new i()));
      com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.platform.window.a.j.class, new com.tencent.mm.plugin.appbrand.report.u());
      if (isAppBrandProcess())
      {
        localObject1 = com.tencent.mm.plugin.webview.jsapi.b.WDu;
        com.tencent.mm.plugin.webview.jsapi.b.its();
        Log.i("MicroMsg.PluginAppBrand[speedtest]", "init DefaultJsApiPool");
        com.tencent.mm.plugin.appbrand.game.c.b.aoW();
        com.tencent.luggage.game.b.d.aoV().ekK = new com.tencent.mm.plugin.appbrand.game.d.a();
        com.tencent.mm.plugin.appbrand.af.i.cNj();
        com.tencent.xweb.u.a(com.tencent.mm.plugin.appbrand.xweb_ext.g.uTP);
        new LuggageInitTask(MMApplicationContext.getProcessName()).bQt();
        com.tencent.mm.kernel.h.b(com.tencent.mm.api.ab.class, new com.tencent.mm.plugin.webview.p());
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.sns.c.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.sns.ad.c()));
      }
      com.tencent.luggage.sdk.h.d.a("WeChatMultiProcessInitDelegateImpl", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(317649);
          o localo = new o(paramg);
          if (com.tencent.luggage.bridge.a.a.eiP != null)
          {
            Log.e("Luggage.LuggageBoot", "do not setup more than once.");
            AppMethodBeat.o(317649);
            return;
          }
          com.tencent.luggage.bridge.a.a.eiP = localo;
          localo.a(new a.1());
          AppMethodBeat.o(317649);
        }
      });
      localObject1 = com.tencent.mm.plugin.appbrand.utils.e.uqt;
      com.tencent.mm.modelappbrand.a.b.gW(com.tencent.mm.plugin.appbrand.utils.e.cNv());
      com.tencent.mm.plugin.appbrand.widget.a.c.a(new PluginAppBrand.12(this));
      if (!paramg.bbA()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.n.w.czm();
      paramg.bGP.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.af.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(317653);
          if (((paramAnonymousActivity instanceof KeyStepBaseActivity)) && (!com.tencent.mm.plugin.appbrand.report.a.a.cIH())) {
            paramAnonymousActivity.finish();
          }
          AppMethodBeat.o(317653);
        }
      });
      paramg = com.tencent.mm.msgsubscription.api.b.piw;
      com.tencent.mm.msgsubscription.api.b.a("name_wxa", new PluginAppBrand.14(this, com.tencent.mm.msgsubscription.d.c.pjX));
      com.tencent.mm.kernel.h.baF().a(new PluginAppBrand.15(this));
      com.tencent.mm.plugin.an.c.PET.a(new bo());
      com.tencent.mm.plugin.an.c.PET.a(new com.tencent.mm.plugin.appbrand.bp());
      PluginAppBrand.a.ceS();
      com.tencent.mm.plugin.appbrand.appcache.av.a(at.qFK);
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.api.e.class, new com.tencent.mm.kernel.c.e(new p()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.widget.recent.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new l()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.s.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.ab()));
      com.tencent.mm.kernel.h.a(v.class, new com.tencent.mm.kernel.c.e(new j()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.widget.b.b.class, new com.tencent.mm.kernel.c.e(new q()));
      com.tencent.mm.kernel.h.a(z.class, new com.tencent.mm.kernel.c.e(new an()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.r.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.c()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.o.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.utils.s()));
      com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.kernel.c.e(new d()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.e(), new String[] { "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_monkey_bringtofront", "//appbrand_monkey_test_skip_appbrand_process_suicide", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_ps", "//xweb_video_player", "//xweb_video_proxy", "//xweb_video_hls_proxy", "//xweb_video", "//showad", "//allshowad", "//localwxalibrary", "//appbrand_video", "//enable_appbrand_file_size_statistics_debug", "//enableweappallhalfscreen", "//appbrand_profile", "//appbrand_weishi", "//deletexnetlibdebugdir", "//xnetusingdebugso" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.plugin.appbrand.xweb_ext.b.aoW();
      com.tencent.mm.kernel.h.baF().a(new PluginAppBrand.3(this));
      if (DebuggerShell.clt()) {
        com.tencent.mm.kernel.h.b(DebuggerShell.class, new DebuggerShell());
      }
      com.tencent.mm.plugin.appbrand.appcache.ag.a(new aa());
      com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
      com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.utils.d.cNp(), com.tencent.mm.plugin.appbrand.utils.d.cNr(), com.tencent.mm.plugin.appbrand.xweb_ext.video.c.cTF(), null);
      com.tencent.mm.pluginsdk.ui.span.p.YoG = new PluginAppBrand.4(this);
      if ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isAppBrandProcess())) {
        com.tencent.mm.plugin.appbrand.report.t.init();
      }
      paramg = com.tencent.mm.plugin.appbrand.debugger.console.f.rfJ;
      com.tencent.mm.plugin.appbrand.debugger.console.f.enable();
      AppMethodBeat.o(44159);
      return;
    }
    boolean bool;
    if (isAppBrandProcess())
    {
      com.tencent.mm.plugin.performance.watchdogs.d.gzs().MOg = com.tencent.mm.plugin.appbrand.report.h.tNO;
      com.tencent.mm.plugin.appbrand.debugger.b.setup();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.appusage.ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.n()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.appusage.af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.widget.recent.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataTokenStorageIPC()));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.flutter.a.a.class, new com.tencent.mm.plugin.flutter.b());
      com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new m()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(c.qBk));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.y.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.qIN));
      com.tencent.mm.kernel.h.a(x.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.qJV));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.qJO));
      localObject1 = this.singletonRegistry;
      Object localObject3 = paramg.bGP;
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject3).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject3 = paramg.bGP;
      ((com.tencent.mm.plugin.appbrand.utils.n)localObject1).uqK = true;
      ((com.tencent.mm.plugin.appbrand.utils.n)localObject1).app = ((Application)localObject3);
      localObject1 = this.singletonRegistry;
      localObject3 = com.tencent.mm.plugin.appbrand.utils.a.a.urT;
      Log.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject3 });
      ((com.tencent.mm.plugin.appbrand.utils.n)localObject1).uqI.offer(localObject3);
      com.tencent.mm.plugin.appbrand.l.k(paramg.bGP);
      ay.k(paramg.bGP);
      localObject1 = com.tencent.mm.plugin.appbrand.luggage.b.c.tfv;
      localObject3 = paramg.bGP;
      kotlin.g.b.s.u(localObject3, "app");
      ((Application)localObject3).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.utils.d.cNp(), com.tencent.mm.plugin.appbrand.utils.d.cNr(), com.tencent.mm.plugin.appbrand.xweb_ext.video.c.cTF(), null);
      bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.f.cwx();
      localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
      if (localObject1 == null) {
        break label2589;
      }
      bool = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yPH, bool);
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useContentInferer, expt is ".concat(String.valueOf(bool)));
    }
    label1809:
    label2589:
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.f.jL(bool);
      bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.f.cwy();
      localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yPI, bool);
        Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "contentInferUseNewInputStream, expt is ".concat(String.valueOf(bool)));
      }
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.jsapi.video.e.f.jM(bool);
        localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
        if (localObject1 != null)
        {
          bool = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yPJ, true);
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "enableExoByteRangeFix, expt is ".concat(String.valueOf(bool)));
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.e.c.c.jN(bool);
          bool = com.tencent.mm.plugin.appbrand.utils.d.cCQ();
          localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
          if (localObject1 != null) {
            bool = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yPQ, bool);
          }
          for (;;)
          {
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "enableFixExoVideoSize, ".concat(String.valueOf(bool)));
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j.jR(bool);
            int i;
            int j;
            if (com.tencent.mm.plugin.appbrand.utils.d.cCQ())
            {
              i = 2;
              localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
              j = i;
              if (localObject1 != null)
              {
                j = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yQa, i);
                Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "notifyErrorWorkaroundChannel, expt is ".concat(String.valueOf(j)));
              }
              if (!MultiProcessMMKV.getMMKV("xweb_abtest_command").contains("video_fix_notify_error_command_value")) {
                break label2464;
              }
              localObject1 = Boolean.valueOf(MultiProcessMMKV.getMMKV("xweb_abtest_command").getBoolean("video_fix_notify_error_command_value", false));
              label1888:
              if (localObject1 == null) {
                break label2572;
              }
              if (!((Boolean)localObject1).booleanValue()) {
                break label2470;
              }
              i = k;
            }
            for (;;)
            {
              label1904:
              Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "notifyErrorWorkaroundChannel: ".concat(String.valueOf(i)));
              com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m.sGH = i;
              localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e.sFN;
              bool = com.tencent.mm.plugin.appbrand.utils.d.cCQ();
              localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
              if (localObject1 != null)
              {
                bool = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yQd, bool);
                Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "cancelCacheWhenPlay, expt is ".concat(String.valueOf(bool)));
              }
              for (;;)
              {
                localObject1 = localObject2;
                if (MultiProcessMMKV.getMMKV("xweb_abtest_command").contains("video_cancel_cache_when_play_command_value")) {
                  localObject1 = Boolean.valueOf(MultiProcessMMKV.getMMKV("xweb_abtest_command").getBoolean("video_cancel_cache_when_play_command_value", false));
                }
                if (localObject1 != null) {
                  bool = ((Boolean)localObject1).booleanValue();
                }
                Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "cancelCacheWhenPlay: ".concat(String.valueOf(bool)));
                com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e.jO(bool);
                Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "init");
                switch (com.tencent.mm.plugin.appbrand.utils.d.cNu())
                {
                default: 
                  label2084:
                  i = BuildInfo.LIVE_JS_ADAPTER_VERSION;
                  if (i != 0) {
                    if (1 != i) {
                      bool = true;
                    }
                  }
                  break;
                }
                for (;;)
                {
                  label2100:
                  Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useLiveJSAdapterV2: ".concat(String.valueOf(bool)));
                  Log.i("MicroMsg.AppBrand.TXLiveJSAdapter", kotlin.g.b.s.X("set#useV2, value: ", Boolean.valueOf(bool)));
                  com.tencent.mm.plugin.appbrand.jsapi.live.m.sbn = bool;
                  com.tencent.luggage.xweb_ext.extendplugin.component.e.enable();
                  com.tencent.mm.plugin.appbrand.permission.a.a.a(new a.c()
                  {
                    public final com.tencent.mm.plugin.appbrand.permission.a.a a(a.d paramAnonymousd, com.tencent.mm.plugin.appbrand.permission.a.c paramAnonymousc)
                    {
                      AppMethodBeat.i(317731);
                      paramAnonymousd = new com.tencent.mm.plugin.appbrand.permission.a.a(paramAnonymousd, paramAnonymousc)
                      {
                        public final boolean P(AppBrandRuntime paramAnonymous2AppBrandRuntime)
                        {
                          AppMethodBeat.i(317747);
                          boolean bool = false;
                          if ((paramAnonymous2AppBrandRuntime instanceof com.tencent.mm.plugin.appbrand.w)) {
                            bool = ((com.tencent.mm.plugin.appbrand.w)paramAnonymous2AppBrandRuntime).getInitConfig().qAT.isEnable();
                          }
                          AppMethodBeat.o(317747);
                          return bool;
                        }
                        
                        public final deb a(deb paramAnonymous2deb)
                        {
                          AppMethodBeat.i(317756);
                          if ((com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.rgV.cmM()) && (paramAnonymous2deb != null))
                          {
                            paramAnonymous2deb.aaJD = com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.rgX;
                            localObject1 = paramAnonymous2deb.aans;
                            if (localObject1 == null)
                            {
                              localObject1 = null;
                              if (localObject1 == null) {
                                break label121;
                              }
                              ((eul)localObject1).IGG = com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.cmN().IGG;
                              ((eul)localObject1).abxn = com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.cmN().abxn;
                            }
                          }
                          else
                          {
                            AppMethodBeat.o(317756);
                            return paramAnonymous2deb;
                          }
                          Object localObject2 = ((Iterable)localObject1).iterator();
                          do
                          {
                            if (!((Iterator)localObject2).hasNext()) {
                              break;
                            }
                            localObject1 = ((Iterator)localObject2).next();
                          } while (!kotlin.g.b.s.p("scope.bluetooth", ((eul)localObject1).YVX));
                          for (;;)
                          {
                            localObject1 = (eul)localObject1;
                            break;
                            localObject1 = null;
                          }
                          label121:
                          Object localObject1 = paramAnonymous2deb.aans;
                          kotlin.g.b.s.s(localObject1, "response.ScopeList");
                          localObject2 = ((Iterable)localObject1).iterator();
                          do
                          {
                            if (!((Iterator)localObject2).hasNext()) {
                              break;
                            }
                            localObject1 = ((Iterator)localObject2).next();
                          } while (!kotlin.g.b.s.p("scope.bluetoothBackground", ((eul)localObject1).YVX));
                          for (;;)
                          {
                            localObject1 = (eul)localObject1;
                            if (localObject1 == null) {
                              break;
                            }
                            localObject2 = paramAnonymous2deb.aans;
                            if (localObject2 != null) {
                              ((LinkedList)localObject2).add(com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.cmN());
                            }
                            ((eul)localObject1).IGG = com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.cmN().IGG;
                            ((eul)localObject1).abxn = com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f.cmN().abxn;
                            break;
                            localObject1 = null;
                          }
                        }
                      };
                      AppMethodBeat.o(317731);
                      return paramAnonymousd;
                    }
                  });
                  if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
                  {
                    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(c.qBk));
                    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.y.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.qIN));
                    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new m()));
                    com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
                    com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
                    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOr, 0) != 1) {
                      break label2560;
                    }
                  }
                  for (bool = true;; bool = false)
                  {
                    com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().a(MMApplicationContext.getContext(), bool, bool, com.tencent.mm.plugin.appbrand.xweb_ext.video.c.cTF(), new com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a());
                    com.tencent.mm.kernel.h.a(x.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.qJV));
                    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.qJO));
                    if (isAppBrandProcess())
                    {
                      AppBrandProcessSuicideLogic.f(paramg.bGP);
                      e.l(paramg.bGP);
                      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(365L, 4L, 1L, false);
                      KVCommCrossProcessReceiver.ahu(1000);
                      com.tencent.mm.plugin.appbrand.task.preload.f.f(paramg.bGP);
                      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.a()));
                      copyWxaDecodeKeyFile();
                      localObject1 = new PluginAppBrand.6(this);
                      CdnLogic.InitSavePath("/data/user/0/" + paramg.getPackageName() + "/MicroMsg/CronetCache/appbrand/cache/", (CdnLogic.AppCallback)localObject1);
                      com.tencent.luggage.sdk.h.d.a("SkylineBoot#Init", new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(317730);
                          Object localObject = com.tencent.luggage.h.a.b.ewj;
                          localObject = com.tencent.mm.plugin.appbrand.ab.d.tVn;
                          com.tencent.luggage.h.c.mw(com.tencent.mm.plugin.appbrand.ab.d.cJB());
                          Log.i("Luggage.SkylineBoot", "init " + MMApplicationContext.getProcessName() + " renderBackend:" + com.tencent.luggage.h.c.asS());
                          localObject = com.tencent.luggage.h.c.evV;
                          if (com.tencent.luggage.h.c.asU()) {}
                          for (boolean bool = MMApplicationContext.isAppBrandProcess();; bool = false)
                          {
                            if (bool)
                            {
                              localObject = com.tencent.luggage.h.e.evY;
                              Context localContext = MMApplicationContext.getContext();
                              kotlin.g.b.s.s(localContext, "getContext()");
                              ((com.tencent.luggage.h.e)localObject).br(localContext);
                            }
                            AppMethodBeat.o(317730);
                            return;
                          }
                        }
                      });
                    }
                    if (!MMApplicationContext.isToolsProcess()) {
                      break;
                    }
                    com.tencent.mm.ad.h.initialize();
                    break;
                    i = 0;
                    break label1809;
                    label2464:
                    localObject1 = null;
                    break label1888;
                    label2470:
                    i = 0;
                    break label1904;
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "init, use ThumbPlayer");
                    localObject1 = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
                    localObject1 = MMApplicationContext.getContext();
                    kotlin.g.b.s.u(localObject1, "context");
                    if (!com.tencent.mm.plugin.appbrand.ag.b.a.c.ute) {
                      break label2084;
                    }
                    com.tencent.mm.plugin.appbrand.ag.b.a.c.fq((Context)localObject1);
                    break label2084;
                    bool = false;
                    break label2100;
                    bool = com.tencent.mm.plugin.appbrand.utils.d.cCQ();
                    localObject1 = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
                    if (localObject1 == null) {
                      break label2566;
                    }
                    bool = ((com.tencent.mm.plugin.expt.b.c)localObject1).a(c.a.yQe, bool);
                    break label2100;
                  }
                }
              }
              i = j;
            }
          }
          bool = true;
        }
      }
    }
  }
  
  final n getCore()
  {
    AppMethodBeat.i(44154);
    n localn = PluginAppBrand.a.ceT();
    AppMethodBeat.o(44154);
    return localn;
  }
  
  public final List<au> getDataTransferList()
  {
    AppMethodBeat.i(44153);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new l.1(new com.tencent.mm.plugin.appbrand.config.l()));
    localLinkedList.add(new ad());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.d());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.r());
    localLinkedList.add(new ac());
    localLinkedList.add(new o.a());
    AppMethodBeat.o(44153);
    return localLinkedList;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.bp getWxaPkgStorageRouter()
  {
    return this.mWxaPkgStorageRouter;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(44155);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "installed()");
    alias(com.tencent.mm.plugin.appbrand.api.c.class);
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.plugin.appbrand.task.i.a(com.tencent.mm.plugin.appbrand.task.j.cJX());
    }
    com.tencent.mm.ipcinvoker.i.myG = ipcSerialThreadPoolDelegate;
    if (!isAppBrandProcess()) {
      new PluginAppBrand.2(this, com.tencent.mm.app.f.hfK).alive();
    }
    if (isAppBrandProcess())
    {
      com.tencent.mm.plugin.appbrand.crash_report.b.setup();
      com.tencent.mm.kernel.h.b(com.tencent.mm.api.ab.class, new com.tencent.mm.plugin.webview.p());
    }
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a locala = com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a.tmI;
      com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a.initialize();
    }
    AppMethodBeat.o(44155);
  }
  
  public final String name()
  {
    return "plugin-appbrand";
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(317917);
    PluginAppBrand.a.ceS();
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(com.tencent.mm.kernel.h.ax(PluginAppBrand.a.class));
    AppMethodBeat.o(317917);
  }
  
  final void setWxaPkgStorageRouter(com.tencent.mm.plugin.appbrand.appcache.bp parambp)
  {
    this.mWxaPkgStorageRouter = parambp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */