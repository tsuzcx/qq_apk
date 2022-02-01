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
import androidx.annotation.Keep;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.luggage.sdk.processes.main.LuggageInitTask;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.at;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.bw.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appstorage.ac.a;
import com.tencent.mm.plugin.appbrand.appstorage.ac.b;
import com.tencent.mm.plugin.appbrand.appusage.ae;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ao;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.bh;
import com.tencent.mm.plugin.appbrand.bi;
import com.tencent.mm.plugin.appbrand.config.k.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity;
import com.tencent.mm.plugin.appbrand.launching.bd;
import com.tencent.mm.plugin.appbrand.m.ac;
import com.tencent.mm.plugin.appbrand.menu.o.a;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.pluginsdk.ui.span.l.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Queue;

@Keep
public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.model.au, com.tencent.mm.plugin.appbrand.api.c
{
  public static final String TAG = "MicroMsg.PluginAppBrand[speedtest]";
  public static final long WXA_CACHE_SIZE = 536870912L;
  private static final com.tencent.mm.ipcinvoker.b ipcSerialThreadPoolDelegate;
  private bp mWxaPkgStorageRouter;
  private final com.tencent.mm.plugin.appbrand.utils.j singletonRegistry;
  
  static
  {
    AppMethodBeat.i(275036);
    ipcSerialThreadPoolDelegate = new PluginAppBrand.1();
    AppMethodBeat.o(275036);
  }
  
  public PluginAppBrand()
  {
    AppMethodBeat.i(44152);
    this.singletonRegistry = new com.tencent.mm.plugin.appbrand.utils.j();
    AppMethodBeat.o(44152);
  }
  
  private void copyWxaDecodeKeyFile()
  {
    AppMethodBeat.i(174699);
    String str = MMApplicationContext.getContext().getApplicationContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
    if ((!com.tencent.mm.vfs.u.agG(str)) || (!"43bff1e72298b0ea0b73e2960d3c97b8".equals(com.tencent.mm.vfs.u.buc(str))))
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
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    AppMethodBeat.o(44162);
    return localMultiProcessMMKV;
  }
  
  @Deprecated
  private void initJSONABTestGetter()
  {
    AppMethodBeat.i(44163);
    com.tencent.mm.ad.h.a(new com.tencent.mm.ad.e()
    {
      boolean cSY;
      int nCz;
      
      public final int aGl()
      {
        return this.nCz;
      }
      
      public final boolean isValid()
      {
        return this.cSY;
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
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName.startsWith(str + ":appbrand");
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
      boolean bool = SupportProcessIPCService.PROCESS_NAME.equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName);
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
    com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.plugin.appbrand.ui.c.a.a.rhL);
    if (isAppBrandProcess())
    {
      fixProcessSharedStringFormatLocale();
      paramg.Zw.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(281080);
          PluginAppBrand.access$100();
          AppMethodBeat.o(281080);
        }
        
        public final void onActivityStarted(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(281081);
          PluginAppBrand.access$100();
          AppMethodBeat.o(281081);
        }
      });
      paramg.Zw.registerComponentCallbacks(new ComponentCallbacks()
      {
        public final void onConfigurationChanged(Configuration paramAnonymousConfiguration)
        {
          AppMethodBeat.i(264057);
          PluginAppBrand.access$100();
          AppMethodBeat.o(264057);
        }
        
        public final void onLowMemory() {}
      });
      CrashReportFactory.addCrashReportExtraMessageGetter(com.tencent.mm.plugin.appbrand.e.a.oce);
    }
    if ((!MMApplicationContext.isMMProcess()) && (com.tencent.mm.cw.i.YYx == null))
    {
      com.tencent.mm.cw.i.YYx = new com.tencent.mm.vending.h.h(com.tencent.mm.cw.d.b(new MMHandler(DeprecatedThreadFactory.createHandlerThread("WeChat.WORKER").getLooper())), "WeChat.WORKER");
      com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.cw.i.YYx);
    }
    com.tencent.mm.vfs.ab.a("MixAudio", "MixAudio", 259200000L, 101);
    com.tencent.mm.vfs.ab.a("ExoVideoCache", "videocache", 259200000L, 101);
    com.tencent.mm.vfs.ab.a("wagamefiles", "wagamefiles", 86400000L, 517);
    com.tencent.mm.vfs.ab.a("WxaCommCacheFiles", "wxacache/", 536870912L, 7776000000L, 37);
    com.tencent.mm.vfs.ab.a("AppBrandEmojiCache", "appbrand/emojicache/", 536870912L, 259200000L, 6);
    com.tencent.mm.vfs.ab.a("wxaFlattenFileSystem", "wxafiles/", 9223372036854775807L, 517);
    com.tencent.mm.vfs.ab.a("wxaNonFlattenFileSystem", "wxanewfiles/", 9223372036854775807L, 517);
    com.tencent.mm.vfs.ab.a("WxaJsCodeCache", "appbrand/jscache/", 9223372036854775807L, 6);
    com.tencent.mm.vfs.ab.a("WxaWASMCache", "appbrand/wasmcache/", 9223372036854775807L, 6);
    com.tencent.mm.vfs.e.hY("appbrand", 6);
    com.tencent.mm.vfs.ab.a("ThumbVideoCache", "ThumbVideoCache", 259200000L, 101);
    com.tencent.mm.vfs.ab.a("WxaSecureInput", "appbrand/secureInput/", 9223372036854775807L, 6);
    AppMethodBeat.o(44157);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(44156);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "dependency()");
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(44156);
  }
  
  public final void execute(final com.tencent.mm.kernel.b.g paramg)
  {
    int k = 2;
    Object localObject2 = null;
    AppMethodBeat.i(44159);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "execute() current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName, Boolean.valueOf(MMHandlerThread.isMainThread()) });
    if (com.tencent.mm.plugin.appbrand.report.a.a.chM())
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(new com.tencent.mm.plugin.appbrand.keylogger.g());
      com.tencent.mm.plugin.appbrand.keylogger.c.bZg();
    }
    com.tencent.mm.plugin.appbrand.keylogger.d.a("WeAppLaunch", com.tencent.mm.plugin.appbrand.report.quality.o.qOt);
    com.tencent.mm.kernel.h.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.r.class, new com.tencent.mm.kernel.c.e(new bd()));
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.d.c.class, com.tencent.mm.plugin.appbrand.d.b.nVI);
    if (paramg.aIE())
    {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.xweb_ext.video.d()));
      bw.a.e(paramg);
    }
    if (!isAppBrandProcess()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    }
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    }
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.n.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.report.c()));
    }
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.s.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.c.g()));
    if (paramg.aIE()) {}
    for (Object localObject1 = ac.b.nOj;; localObject1 = ac.a.nOh)
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.i.class, com.tencent.mm.plugin.appbrand.openmaterial.b.qmk);
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new h()));
      if (isAppBrandProcess())
      {
        localObject1 = com.tencent.mm.plugin.webview.d.a.PNm;
        com.tencent.mm.plugin.webview.d.a.gTJ();
        Log.i("MicroMsg.PluginAppBrand[speedtest]", "init DefaultJsApiPool");
        com.tencent.mm.plugin.appbrand.game.c.b.OO();
        com.tencent.luggage.game.b.d.ON().csQ = new com.tencent.mm.plugin.appbrand.game.d.a();
        com.tencent.mm.plugin.appbrand.ac.g.clR();
        com.tencent.xweb.s.a(com.tencent.mm.plugin.appbrand.xweb_ext.g.rIA);
        new LuggageInitTask(MMApplicationContext.getProcessName()).bsM();
      }
      com.tencent.luggage.sdk.h.d.a("WeChatMultiProcessInitDelegateImpl", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264498);
          n localn = new n(paramg);
          if (com.tencent.luggage.bridge.a.a.cqW != null)
          {
            Log.e("Luggage.LuggageBoot", "do not setup more than once.");
            AppMethodBeat.o(264498);
            return;
          }
          com.tencent.luggage.bridge.a.a.cqW = localn;
          localn.a(new a.1());
          AppMethodBeat.o(264498);
        }
      });
      localObject1 = com.tencent.mm.plugin.appbrand.utils.m.riE;
      com.tencent.mm.modelappbrand.a.b.gf(com.tencent.mm.plugin.appbrand.utils.m.isEnable());
      if (!paramg.aIE()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.m.w.bYY();
      paramg.Zw.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(272006);
          if (((paramAnonymousActivity instanceof KeyStepBaseActivity)) && (!com.tencent.mm.plugin.appbrand.report.a.a.chM())) {
            paramAnonymousActivity.finish();
          }
          AppMethodBeat.o(272006);
        }
      });
      paramg = com.tencent.mm.msgsubscription.api.b.moG;
      com.tencent.mm.msgsubscription.api.b.a("name_wxa", new PluginAppBrand.14(this, com.tencent.mm.msgsubscription.d.c.mqn));
      com.tencent.mm.kernel.h.aHH().a(new com.tencent.mm.kernel.api.g()
      {
        public final void abB()
        {
          AppMethodBeat.i(271029);
          com.tencent.mm.plugin.appbrand.ui.banner.d.ckM();
          AppMethodBeat.o(271029);
        }
        
        public final void dn(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.plugin.am.c.Jru.a(new bh());
      com.tencent.mm.plugin.am.c.Jru.a(new bi());
      a.bFv();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.api.e.class, new com.tencent.mm.kernel.c.e(new o()));
      new PluginAppBrand.2(this).alive();
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.widget.recent.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new k()));
      com.tencent.mm.kernel.h.a(q.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.w()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.t.class, new com.tencent.mm.kernel.c.e(new i()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.widget.a.b.class, new com.tencent.mm.kernel.c.e(new p()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.x.class, new com.tencent.mm.kernel.c.e(new ao()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.c()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.utils.p()));
      com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new d()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.e(), new String[] { "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_monkey_bringtofront", "//appbrand_monkey_test_skip_appbrand_process_suicide", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_ps", "//xweb_video_player", "//xweb_video_proxy", "//xweb_video_hls_proxy", "//xweb_video", "//showad", "//allshowad", "//localwxalibrary", "//appbrand_video", "//enable_appbrand_file_size_statistics_debug", "//enableweappallhalfscreen" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.plugin.appbrand.xweb_ext.b.OO();
      com.tencent.mm.kernel.h.aHH().a(new com.tencent.mm.kernel.api.g()
      {
        public final void abB()
        {
          AppMethodBeat.i(268312);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).initialize();
          AppMethodBeat.o(268312);
        }
        
        public final void dn(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(268313);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).shutdown();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgQ().exit();
          AppMethodBeat.o(268313);
        }
      });
      if (DebuggerShell.bLT()) {
        com.tencent.mm.kernel.h.b(DebuggerShell.class, new DebuggerShell());
      }
      af.a(new com.tencent.mm.plugin.appbrand.appcache.y());
      com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
      com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.utils.c.clY(), com.tencent.mm.plugin.appbrand.utils.c.cma(), com.tencent.mm.plugin.appbrand.xweb_ext.video.c.cqY(), null);
      com.tencent.mm.pluginsdk.ui.span.l.Rsn = new l.b()
      {
        public final boolean bFu()
        {
          AppMethodBeat.i(269138);
          com.tencent.mm.plugin.appbrand.shortlink.d locald = com.tencent.mm.plugin.appbrand.shortlink.d.qQm;
          boolean bool = ((Boolean)com.tencent.mm.plugin.appbrand.shortlink.d.ciH().invoke()).booleanValue();
          AppMethodBeat.o(269138);
          return bool;
        }
      };
      if ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isAppBrandProcess())) {
        com.tencent.mm.plugin.appbrand.report.s.init();
      }
      AppMethodBeat.o(44159);
      return;
    }
    boolean bool;
    if (isAppBrandProcess())
    {
      com.tencent.mm.plugin.performance.watchdogs.c.fou().GQO = com.tencent.mm.plugin.appbrand.report.h.qJl;
      com.tencent.mm.plugin.appbrand.debugger.b.setup();
      com.tencent.mm.kernel.h.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.o()));
      com.tencent.mm.kernel.h.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.widget.recent.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.g()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataTokenStorageIPC()));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.flutter.a.a.class, new com.tencent.mm.plugin.flutter.b());
      com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new l()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(c.nBS));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.nJc));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.v.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.nKs));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.nKf));
      localObject1 = this.singletonRegistry;
      Object localObject3 = paramg.Zw;
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject3).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject3 = paramg.Zw;
      ((com.tencent.mm.plugin.appbrand.utils.j)localObject1).riz = true;
      ((com.tencent.mm.plugin.appbrand.utils.j)localObject1).app = ((Application)localObject3);
      localObject1 = this.singletonRegistry;
      localObject3 = com.tencent.mm.plugin.appbrand.utils.a.a.rjz;
      Log.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject3 });
      ((com.tencent.mm.plugin.appbrand.utils.j)localObject1).rix.offer(localObject3);
      com.tencent.mm.plugin.appbrand.l.l(paramg.Zw);
      com.tencent.mm.ui.as.l(paramg.Zw);
      localObject1 = com.tencent.mm.plugin.appbrand.luggage.b.c.qar;
      localObject3 = paramg.Zw;
      kotlin.g.b.p.k(localObject3, "app");
      ((Application)localObject3).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.utils.c.clY(), com.tencent.mm.plugin.appbrand.utils.c.cma(), com.tencent.mm.plugin.appbrand.xweb_ext.video.c.cqY(), null);
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
      bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.bWm();
      localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
      if (localObject1 == null) {
        break label2542;
      }
      bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.vBG, bool);
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useContentInferer, expt is ".concat(String.valueOf(bool)));
    }
    label1638:
    label2542:
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.g.iI(bool);
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
      bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.bWn();
      localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.vBH, bool);
        Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "contentInferUseNewInputStream, expt is ".concat(String.valueOf(bool)));
      }
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.jsapi.video.e.g.iJ(bool);
        int i;
        int j;
        if (com.tencent.mm.plugin.appbrand.utils.c.ccu())
        {
          i = 2;
          localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
          j = i;
          if (localObject1 != null)
          {
            j = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.vBT, i);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "notifyErrorWorkaroundChannel, expt is ".concat(String.valueOf(j)));
          }
          if (!MultiProcessMMKV.getMMKV("xweb_abtest_command").contains("video_fix_notify_error_command_value")) {
            break label2461;
          }
          localObject1 = Boolean.valueOf(MultiProcessMMKV.getMMKV("xweb_abtest_command").getBoolean("video_fix_notify_error_command_value", false));
          if (localObject1 == null) {
            break label2534;
          }
          if (!((Boolean)localObject1).booleanValue()) {
            break label2467;
          }
          i = k;
        }
        for (;;)
        {
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "notifyErrorWorkaroundChannel: ".concat(String.valueOf(i)));
          com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.pAA = i;
          bool = com.tencent.mm.plugin.appbrand.utils.c.ccu();
          localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
          if (localObject1 != null)
          {
            bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.vBU, bool);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useMultiProcessImpl, expt is ".concat(String.valueOf(bool)));
          }
          for (;;)
          {
            if (MultiProcessMMKV.getMMKV("xweb_abtest_command").contains("video_lock_cache_command_value"))
            {
              localObject1 = Boolean.valueOf(MultiProcessMMKV.getMMKV("xweb_abtest_command").getBoolean("video_lock_cache_command_value", false));
              if (localObject1 != null) {
                bool = ((Boolean)localObject1).booleanValue();
              }
              Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useMultiProcessImpl: ".concat(String.valueOf(bool)));
              Log.i("MicroMsg.AppBrand.AppBrandExoVideoCacheService", "useMultiProcessImpl#set, value: ".concat(String.valueOf(bool)));
              com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.b.pBJ = bool;
              localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c.pAQ;
              bool = com.tencent.mm.plugin.appbrand.utils.c.ccu();
              localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
              if (localObject1 == null) {
                break label2528;
              }
              bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.vBW, bool);
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
              com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c.iK(bool);
              Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "init");
              switch (com.tencent.mm.plugin.appbrand.utils.c.cmd())
              {
              default: 
                bool = com.tencent.mm.plugin.appbrand.utils.c.ccu();
                localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
                if (localObject1 != null)
                {
                  bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.vBX, bool);
                  Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useLiveJSAdapterV2, expt is ".concat(String.valueOf(bool)));
                }
                break;
              }
              for (;;)
              {
                Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useLiveJSAdapterV2: ".concat(String.valueOf(bool)));
                Log.i("MicroMsg.AppBrand.TXLiveJSAdapter", "set#useV2, value: ".concat(String.valueOf(bool)));
                com.tencent.mm.plugin.appbrand.jsapi.live.m.oVP = bool;
                com.tencent.luggage.xweb_ext.extendplugin.component.e.enable();
                if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
                {
                  com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(c.nBS));
                  com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.nJc));
                  com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new l()));
                  com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
                  com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
                  if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAC, 0) != 1) {
                    break label2519;
                  }
                }
                for (bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().a(MMApplicationContext.getContext(), bool, bool, com.tencent.mm.plugin.appbrand.xweb_ext.video.c.cqY(), new com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a());
                  com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.v.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.nKs));
                  com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.nKf));
                  if (isAppBrandProcess())
                  {
                    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new PluginAppBrand.5(this));
                    AppBrandProcessSuicideLogic.e(paramg.Zw);
                    e.m(paramg.Zw);
                    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(365L, 4L, 1L, false);
                    KVCommCrossProcessReceiver.fBw();
                    com.tencent.mm.plugin.appbrand.task.preload.h.e(paramg.Zw);
                    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.a()));
                    copyWxaDecodeKeyFile();
                    localObject1 = new CdnLogic.AppCallback()
                    {
                      public final void onBadNetworkProbed() {}
                      
                      public final void reportFlow(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
                      
                      public final void requestGetCDN(int paramAnonymousInt) {}
                      
                      public final String[] resolveHost(String paramAnonymousString, boolean paramAnonymousBoolean, int[] paramAnonymousArrayOfInt)
                      {
                        return new String[0];
                      }
                    };
                    CdnLogic.InitSavePath("/data/user/0/" + paramg.getPackageName() + "/MicroMsg/CronetCache/appbrand/cache/", (CdnLogic.AppCallback)localObject1);
                  }
                  if (isSupportProcess())
                  {
                    com.tencent.mm.plugin.appbrand.dynamic.h.e.dH(MMApplicationContext.getContext());
                    com.tencent.mm.ad.h.initialize();
                  }
                  if (!MMApplicationContext.isToolsProcess()) {
                    break;
                  }
                  com.tencent.mm.ad.h.initialize();
                  break;
                  i = 0;
                  break label1638;
                  localObject1 = null;
                  break label1717;
                  i = 0;
                  break label1733;
                  localObject1 = null;
                  break label1838;
                  Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "init, use ThumbPlayer");
                  localObject1 = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
                  localObject1 = MMApplicationContext.getContext();
                  kotlin.g.b.p.k(localObject1, "context");
                  if (!com.tencent.mm.plugin.appbrand.ae.a.a.c.rkj) {
                    break label2048;
                  }
                  com.tencent.mm.plugin.appbrand.ae.a.a.c.eu((Context)localObject1);
                  break label2048;
                }
              }
            }
          }
          i = j;
        }
      }
    }
  }
  
  final m getCore()
  {
    AppMethodBeat.i(44154);
    m localm = a.bFw();
    AppMethodBeat.o(44154);
    return localm;
  }
  
  public final List<at> getDataTransferList()
  {
    AppMethodBeat.i(44153);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new k.1(new com.tencent.mm.plugin.appbrand.config.k()));
    localLinkedList.add(new ae());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.e());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.s());
    localLinkedList.add(new ac());
    localLinkedList.add(new o.a());
    AppMethodBeat.o(44153);
    return localLinkedList;
  }
  
  public final bp getWxaPkgStorageRouter()
  {
    return this.mWxaPkgStorageRouter;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(44155);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "installed()");
    alias(com.tencent.mm.plugin.appbrand.api.c.class);
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.plugin.appbrand.task.i.b(com.tencent.mm.plugin.appbrand.task.k.cjd());
    }
    com.tencent.mm.ipcinvoker.i.jYL = ipcSerialThreadPoolDelegate;
    if (!isAppBrandProcess()) {
      new PluginAppBrand.8(this).alive();
    }
    if (MMApplicationContext.isMainProcess()) {
      new PluginAppBrand.9(this).alive();
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
    AppMethodBeat.i(275027);
    a.bFv();
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.h.ae(a.class));
    AppMethodBeat.o(275027);
  }
  
  static final class a
    extends com.tencent.mm.model.y
    implements com.tencent.mm.app.o, com.tencent.mm.kernel.a.b.b
  {
    private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a nCA;
    private com.tencent.mm.plugin.appbrand.debugger.m nCB;
    private com.tencent.mm.plugin.teenmode.a.c nCC;
    
    private a()
    {
      super();
      AppMethodBeat.i(44144);
      this.nCB = new com.tencent.mm.plugin.appbrand.debugger.m();
      this.nCC = new com.tencent.mm.plugin.teenmode.a.c()
      {
        public final void onDataChanged()
        {
          AppMethodBeat.i(284123);
          boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
          int i = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks();
          Log.i("MicroMsg.PluginAppBrand[speedtest]", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if ((bool) && (i != 1))
          {
            Iterator localIterator = ((Iterable)com.tencent.mm.plugin.appbrand.task.i.cjb().RS()).iterator();
            while (localIterator.hasNext())
            {
              com.tencent.mm.plugin.appbrand.task.d locald = (com.tencent.mm.plugin.appbrand.task.d)localIterator.next();
              Object localObject2 = (Iterable)locald.RO();
              Object localObject1 = (Collection)new ArrayList();
              localObject2 = ((Iterable)localObject2).iterator();
              label185:
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                if (!((com.tencent.luggage.sdk.processes.e)localObject3).cxb) {}
                for (i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label185;
                  }
                  ((Collection)localObject1).add(localObject3);
                  break;
                }
              }
              localObject2 = (Iterable)localObject1;
              localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((Collection)localObject1).add(((com.tencent.luggage.sdk.processes.e)((Iterator)localObject2).next()).appId);
              }
              localObject1 = ((Iterable)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                com.tencent.luggage.sdk.processes.c.a(locald, (LuggageClientProcessMessage)new AppBrandKillByClientMessage((String)((Iterator)localObject1).next(), com.tencent.luggage.sdk.processes.b.cBm.ordinal()));
              }
            }
          }
          AppMethodBeat.o(284123);
        }
      };
      AppMethodBeat.o(44144);
    }
    
    private static void a(String paramString, com.tencent.mm.plugin.appbrand.service.z paramz)
    {
      AppMethodBeat.i(284542);
      Log.i("MicroMsg.PluginAppBrand[speedtest]", "AppBrandCompatCore tryPreloadNextTaskProcess (both waservice and wagame) reason[%s]", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.task.i.cjb().a(LuggageServiceType.cBP, paramz);
      com.tencent.mm.plugin.appbrand.task.i.cjb().a(LuggageServiceType.cBQ, paramz);
      AppMethodBeat.o(284542);
    }
    
    static void bFv()
    {
      AppMethodBeat.i(284540);
      try
      {
        if (com.tencent.mm.kernel.h.ae(a.class) == null) {
          com.tencent.mm.kernel.h.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(284540);
      }
    }
    
    static m bFw()
    {
      AppMethodBeat.i(284541);
      try
      {
        m localm = (m)as(m.class);
        return localm;
      }
      finally
      {
        AppMethodBeat.o(284541);
      }
    }
    
    public final void onAccountInitialized(f.c paramc)
    {
      AppMethodBeat.i(44145);
      super.onAccountInitialized(paramc);
      Log.d("MicroMsg.PluginAppBrand[speedtest]", "onAccountInitialized, WAKeyStepKvLogger.ENABLE=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.appbrand.report.quality.o.civ()) });
      com.tencent.mm.plugin.appbrand.appcache.au.a(com.tencent.mm.plugin.appbrand.appcache.as.nFR);
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramc = new com.tencent.mm.plugin.appbrand.appusage.e();
        if (paramc.uQ(com.tencent.mm.protocal.d.RAD)) {
          paramc.uP(com.tencent.mm.protocal.d.RAD);
        }
        paramc = new ac();
        if (paramc.uQ(com.tencent.mm.protocal.d.RAD)) {
          paramc.uP(com.tencent.mm.protocal.d.RAD);
        }
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        com.tencent.mm.plugin.appbrand.appusage.j.bJf().bJg();
      }
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
      paramc = new com.tencent.mm.plugin.appbrand.appusage.s();
      if (paramc.uQ(com.tencent.mm.protocal.d.RAD)) {
        paramc.uP(com.tencent.mm.protocal.d.RAD);
      }
      paramc = new com.tencent.mm.plugin.appbrand.appusage.r();
      if (paramc.uQ(com.tencent.mm.protocal.d.RAD)) {
        paramc.uP(com.tencent.mm.protocal.d.RAD);
      }
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.f());
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.e());
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.api.b.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.z.nFo));
      com.tencent.mm.kernel.h.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.p()));
      com.tencent.mm.kernel.h.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.x.bEd()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.h()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.h()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.d()));
      com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.v.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.c()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.b()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.debugger.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.debugger.j()));
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.nJl);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.qhb);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.qgN);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.message.h.qhn);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.qgR);
      this.nCA = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
      com.tencent.mm.plugin.downloader.model.f.cPZ();
      com.tencent.mm.plugin.downloader.model.c.a(this.nCA);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.nCB);
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(new AppBrandMixExportLogicService()));
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.launching.b.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.launching.b.a.pYu));
      com.tencent.mm.blink.b.aqa().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(274561);
          PluginAppBrand.a.b("FirstScreenArrangement", com.tencent.mm.plugin.appbrand.service.z.qOP);
          AppMethodBeat.o(274561);
        }
      });
      com.tencent.mm.plugin.appbrand.appcache.i.a(new PluginAppBrand.a.3(this));
      paramc = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB;
      com.tencent.mm.plugin.appbrand.widget.recent.c.cqg();
      com.tencent.mm.plugin.appbrand.appcache.x.setup();
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.nCC);
      com.tencent.mm.plugin.appbrand.launching.f.a.init();
      com.tencent.mm.plugin.appbrand.jsapi.share.ab.init();
      com.tencent.mm.plugin.appbrand.ui.t.install(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw);
      AppMethodBeat.o(44145);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(44150);
      com.tencent.mm.kernel.h.af(ah.class);
      com.tencent.mm.kernel.h.af(ag.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.service.f.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
      com.tencent.mm.kernel.h.af(IAppBrandBatchPreloadController.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.api.e.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.debugger.f.class);
      com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.appbrand.appusage.c.class);
      super.onAccountRelease();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.e.class)).aOe("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.e.class)).aOf("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.nJl);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.qhb);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.qgN);
      com.tencent.mm.plugin.downloader.model.f.cPZ();
      com.tencent.mm.plugin.downloader.model.c.b(this.nCA);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.nCB);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.qgR);
      com.tencent.mm.plugin.appbrand.x.a.chi();
      Object localObject = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB;
      com.tencent.mm.plugin.appbrand.widget.recent.c.release();
      localObject = com.tencent.mm.plugin.appbrand.shortlink.b.qQj;
      com.tencent.mm.plugin.appbrand.shortlink.b.clearAll();
      AppMethodBeat.o(44150);
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(44148);
      paramString = com.tencent.mm.plugin.appbrand.ipc.a.a.orU;
      com.tencent.mm.plugin.appbrand.ipc.a.a.bPv();
      paramString = com.tencent.mm.plugin.appbrand.shortlink.d.qQm;
      com.tencent.mm.plugin.appbrand.shortlink.d.ciG();
      AppMethodBeat.o(44148);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(44147);
      if (MMApplicationContext.isMainProcess()) {
        com.tencent.mm.plugin.appbrand.task.i.b(com.tencent.mm.plugin.appbrand.task.k.cjd());
      }
      a("onAppForeground:".concat(String.valueOf(paramString)), com.tencent.mm.plugin.appbrand.service.z.qOQ);
      AppMethodBeat.o(44147);
    }
    
    public final void parallelsDependency()
    {
      AppMethodBeat.i(44149);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class));
      AppMethodBeat.o(44149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */