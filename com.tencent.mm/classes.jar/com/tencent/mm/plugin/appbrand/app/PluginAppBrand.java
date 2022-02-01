package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.annotation.Keep;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.a.abg;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.as;
import com.tencent.mm.model.cj;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.bp.a;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appstorage.aa.a;
import com.tencent.mm.plugin.appbrand.appstorage.aa.b;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ao;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.bg;
import com.tencent.mm.plugin.appbrand.config.k.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsapi.share.aa;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity;
import com.tencent.mm.plugin.appbrand.m.ac;
import com.tencent.mm.plugin.appbrand.menu.m.a;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.pluginsdk.ui.span.l.b;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import com.tencent.mm.ui.ap;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Queue;

@Keep
public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.model.at, com.tencent.mm.plugin.appbrand.api.c
{
  private static final String[] PRELOAD_SO_NAME = { "gamelog_delegate", "mmv8", "mmnode", "mmj2v8", "mmskia", "canvas", "skia-canvas", "skia-canvas-log-bridge", "mmudp", "owl", "wcwss", "mmwcwss", "native-iv", "wechatsight_v7a" };
  public static final String TAG = "MicroMsg.PluginAppBrand[speedtest]";
  private final com.tencent.mm.plugin.appbrand.utils.h singletonRegistry;
  
  public PluginAppBrand()
  {
    AppMethodBeat.i(44152);
    this.singletonRegistry = new com.tencent.mm.plugin.appbrand.utils.h();
    AppMethodBeat.o(44152);
  }
  
  private void copyWxaDecodeKeyFile()
  {
    AppMethodBeat.i(174699);
    String str = MMApplicationContext.getContext().getApplicationContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
    if ((!com.tencent.mm.vfs.s.YS(str)) || (!"43bff1e72298b0ea0b73e2960d3c97b8".equals(com.tencent.mm.vfs.s.bhK(str))))
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
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    AppMethodBeat.o(44162);
    return localMultiProcessMMKV;
  }
  
  @Deprecated
  private void initJSONABTestGetter()
  {
    AppMethodBeat.i(44163);
    com.tencent.mm.ab.h.a(new com.tencent.mm.ab.e() {});
    AppMethodBeat.o(44163);
  }
  
  static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(44160);
    try
    {
      String str = MMApplicationContext.getPackageName();
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName.startsWith(str + ":appbrand");
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
      boolean bool = SupportProcessIPCService.dkO.equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName);
      AppMethodBeat.o(44161);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(44161);
    }
    return false;
  }
  
  private void preloadRuntimeSoAsync()
  {
    AppMethodBeat.i(226326);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUB, 0);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "preload so [%d]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(226326);
      return;
    }
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226312);
        Log.i("MicroMsg.PluginAppBrand[speedtest]", "preload so start");
        MBRuntime.Ra();
        String[] arrayOfString = PluginAppBrand.PRELOAD_SO_NAME;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          com.tencent.mm.compatible.util.j.load(arrayOfString[i]);
          i += 1;
        }
        Log.i("MicroMsg.PluginAppBrand[speedtest]", "preload so end");
        AppMethodBeat.o(226312);
      }
    });
    AppMethodBeat.o(226326);
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(44157);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "configure()");
    com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.plugin.appbrand.ui.c.a.a.oga);
    if (isAppBrandProcess())
    {
      fixProcessSharedStringFormatLocale();
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a()
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
      CrashReportFactory.addCrashReportExtraMessageGetter(com.tencent.mm.plugin.appbrand.e.a.lhw);
    }
    if ((!MMApplicationContext.isMMProcess()) && (com.tencent.mm.co.i.RwW == null))
    {
      com.tencent.mm.co.i.RwW = new com.tencent.mm.vending.h.h(com.tencent.mm.co.d.b(new MMHandler(DeprecatedThreadFactory.createHandlerThread("WeChat.WORKER").getLooper())), "WeChat.WORKER");
      com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.co.i.RwW);
    }
    com.tencent.mm.vfs.y.b("MixAudio", "MixAudio", 259200000L, 103);
    com.tencent.mm.vfs.y.b("ExoVideoCache", "videocache", 259200000L, 103);
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
    AppMethodBeat.i(44159);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "execute() current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName, Boolean.valueOf(MMHandlerThread.isMainThread()) });
    if (com.tencent.mm.plugin.appbrand.report.a.a.bUC())
    {
      com.tencent.mm.plugin.appbrand.keylogger.c.a(new com.tencent.mm.plugin.appbrand.keylogger.g());
      com.tencent.mm.plugin.appbrand.keylogger.c.bMP();
    }
    com.tencent.mm.plugin.appbrand.keylogger.d.a("WeAppLaunch", com.tencent.mm.plugin.appbrand.report.quality.o.nMe);
    com.tencent.mm.kernel.g.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.r.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.bf()));
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.d.c.class, com.tencent.mm.plugin.appbrand.d.b.lbA);
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.xweb_ext.video.c()));
      bp.a.d(paramg);
    }
    if (!isAppBrandProcess()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    }
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    }
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.n.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.report.c()));
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.s.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.c.g()));
    if (paramg.aBb()) {}
    for (Object localObject1 = aa.b.kTJ;; localObject1 = aa.a.kTH)
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.i.class, com.tencent.mm.plugin.appbrand.openmaterial.b.nkM);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new h()));
      if (isAppBrandProcess())
      {
        localObject1 = com.tencent.mm.plugin.webview.d.a.IQX;
        com.tencent.mm.plugin.webview.d.a.gaR();
        Log.i("MicroMsg.PluginAppBrand[speedtest]", "init DefaultJsApiPool");
        com.tencent.mm.plugin.appbrand.game.c.b.LW();
        preloadRuntimeSoAsync();
        com.tencent.luggage.game.b.c.LV().cuE = new com.tencent.mm.plugin.appbrand.game.d.a();
        com.tencent.mm.plugin.appbrand.ac.g.bZj();
        com.tencent.xweb.s.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.oGK);
      }
      com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44138);
          o localo = new o(paramg);
          if (com.tencent.luggage.bridge.a.a.csR != null)
          {
            Log.e("Luggage.LuggageBoot", "do not setup more than once.");
            AppMethodBeat.o(44138);
            return;
          }
          com.tencent.luggage.bridge.a.a.csR = localo;
          localo.a(new a.1());
          AppMethodBeat.o(44138);
        }
      });
      if (!paramg.aBb()) {
        break;
      }
      com.tencent.mm.plugin.appbrand.m.w.bMH();
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(226313);
          if (((paramAnonymousActivity instanceof KeyStepBaseActivity)) && (!com.tencent.mm.plugin.appbrand.report.a.a.bUC())) {
            paramAnonymousActivity.finish();
          }
          AppMethodBeat.o(226313);
        }
      });
      paramg = com.tencent.mm.msgsubscription.api.b.jza;
      com.tencent.mm.msgsubscription.api.b.a("name_wxa", new com.tencent.mm.msgsubscription.b.a(com.tencent.mm.msgsubscription.d.c.jAF)
      {
        public final void a(Context paramAnonymousContext, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(226314);
          Log.i("MicroMsg.PluginAppBrand[speedtest]", "goToSettingManagerUI bizUsername: %s, nickname: %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          Intent localIntent = new Intent(paramAnonymousContext, BizSubscribeMsgManagerUI.class);
          localIntent.putExtra("key_biz_username", paramAnonymousString1);
          localIntent.putExtra("key_biz_nickname", paramAnonymousString2);
          localIntent.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
          if ((paramAnonymousContext instanceof Activity))
          {
            ((Activity)paramAnonymousContext).startActivityForResult(localIntent, 100);
            AppMethodBeat.o(226314);
            return;
          }
          paramAnonymousString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousContext, paramAnonymousString1.axQ(), "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$6", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousContext.startActivity((Intent)paramAnonymousString1.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousContext, "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$6", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(226314);
        }
      });
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(44140);
          com.tencent.mm.plugin.appbrand.ui.banner.d.bYb();
          AppMethodBeat.o(44140);
        }
        
        public final void cQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(44141);
          AppMethodBeat.o(44141);
        }
      });
      com.tencent.mm.plugin.x.c.DlS.a(new com.tencent.mm.plugin.appbrand.bf());
      com.tencent.mm.plugin.x.c.DlS.a(new bg());
      a.bus();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recent.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new l()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.q.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.w()));
      com.tencent.mm.kernel.g.a(t.class, new com.tencent.mm.kernel.c.e(new i()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.api.e.class, new com.tencent.mm.kernel.c.e(new p()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.a.b.class, new com.tencent.mm.kernel.c.e(new q()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.x.class, new com.tencent.mm.kernel.c.e(new ao()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.utils.n()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new d()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[] { "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_monkey_bringtofront", "//appbrand_monkey_test_skip_appbrand_process_suicide", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_ps", "//xweb_video_player", "//xweb_video_proxy", "//xweb_video_hls_proxy", "//xweb_hls_video_player", "//xweb_video", "//showad", "//allshowad", "//localwxalibrary" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.plugin.appbrand.xweb_ext.b.LW();
      com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(226315);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).initialize();
          AppMethodBeat.o(226315);
        }
        
        public final void cQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(226316);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).shutdown();
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().exit();
          AppMethodBeat.o(226316);
        }
      });
      if (DebuggerShell.bAy()) {
        com.tencent.mm.kernel.g.b(DebuggerShell.class, new DebuggerShell());
      }
      com.tencent.mm.plugin.appbrand.appcache.ae.a(new com.tencent.mm.plugin.appbrand.appcache.x());
      com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdM(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdO(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.cdL(), null);
      com.tencent.mm.pluginsdk.ui.span.l.Krg = new l.b()
      {
        public final boolean enable()
        {
          AppMethodBeat.i(226317);
          com.tencent.mm.plugin.appbrand.shortlink.d locald = com.tencent.mm.plugin.appbrand.shortlink.d.nNQ;
          boolean bool = ((Boolean)com.tencent.mm.plugin.appbrand.shortlink.d.bVA().invoke()).booleanValue();
          AppMethodBeat.o(226317);
          return bool;
        }
      };
      if ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isAppBrandProcess())) {
        com.tencent.mm.plugin.appbrand.report.r.init();
      }
      AppMethodBeat.o(44159);
      return;
    }
    Object localObject2;
    boolean bool;
    if (isAppBrandProcess())
    {
      com.tencent.mm.plugin.appbrand.debugger.b.setup();
      com.tencent.mm.kernel.g.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.o()));
      com.tencent.mm.kernel.g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recent.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataTokenStorageIPC()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.flutter.a.a.class, new com.tencent.mm.plugin.flutter.b());
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new m()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(c.kIc));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.kOX));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.v.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.kQn));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.kQa));
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.ca;
      Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.ca;
      ((com.tencent.mm.plugin.appbrand.utils.h)localObject1).ogL = true;
      ((com.tencent.mm.plugin.appbrand.utils.h)localObject1).app = ((Application)localObject2);
      localObject1 = this.singletonRegistry;
      localObject2 = com.tencent.mm.plugin.appbrand.utils.a.a.ohL;
      Log.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject2 });
      ((com.tencent.mm.plugin.appbrand.utils.h)localObject1).ogJ.offer(localObject2);
      com.tencent.mm.plugin.appbrand.i.i(paramg.ca);
      ap.i(paramg.ca);
      localObject1 = com.tencent.mm.plugin.appbrand.luggage.b.c.nac;
      localObject2 = paramg.ca;
      kotlin.g.b.p.h(localObject2, "app");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdM(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdO(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.cdL(), null);
      com.tencent.mm.picker.c.a.jKQ = new k();
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.mCD;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.mCD;
      bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.bKL();
      localObject1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
      if (localObject1 == null) {
        break label1929;
      }
      bool = ((com.tencent.mm.plugin.expt.b.b)localObject1).a(b.a.rVo, bool);
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "useContentInferer, expt is ".concat(String.valueOf(bool)));
    }
    label1929:
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.hS(bool);
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(c.kIc));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.kOX));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new m()));
        com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
        com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTX, 0) != 1) {
          break label1906;
        }
      }
      label1906:
      for (bool = true;; bool = false)
      {
        com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().a(MMApplicationContext.getContext(), bool, bool, com.tencent.mm.plugin.appbrand.xweb_ext.video.a.cdL(), new com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.v.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.kQn));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.kQa));
        if (isAppBrandProcess())
        {
          MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
          {
            public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
            {
              AppMethodBeat.i(226311);
              if (Util.nullAsNil(paramAnonymousString).contains(".plugin.appbrand"))
              {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(365L, 3L, 1L, false);
                KVCommCrossProcessReceiver.eOD();
              }
              AppMethodBeat.o(226311);
            }
          });
          AppBrandProcessSuicideLogic.c(paramg.ca);
          e.j(paramg.ca);
        }
        try
        {
          localObject1 = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "pref_appbrand_process", 4);
          localObject2 = MMApplicationContext.getProcessName() + ":start_time";
          SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
          if (((SharedPreferences)localObject1).contains((String)localObject2))
          {
            localEditor.remove((String)localObject2);
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(365L, 2L, 1L, false);
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(365L, 4L, 1L, false);
          localEditor.putLong((String)localObject2, System.currentTimeMillis());
          localEditor.commit();
          Log.v("MicroMsg.AppBrandReporter", "onProcessStart");
          KVCommCrossProcessReceiver.eOB();
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessStart()", new Object[0]);
          }
        }
        com.tencent.mm.plugin.appbrand.task.preload.h.c(paramg.ca);
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.a()));
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
        if (isSupportProcess())
        {
          com.tencent.mm.plugin.appbrand.dynamic.h.e.dI(MMApplicationContext.getContext());
          com.tencent.mm.ab.h.initialize();
        }
        if (!MMApplicationContext.isToolsProcess()) {
          break;
        }
        com.tencent.mm.ab.h.initialize();
        break;
      }
    }
  }
  
  final n getCore()
  {
    AppMethodBeat.i(44154);
    n localn = a.but();
    AppMethodBeat.o(44154);
    return localn;
  }
  
  public final List<as> getDataTransferList()
  {
    AppMethodBeat.i(44153);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new k.1(new com.tencent.mm.plugin.appbrand.config.k()));
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.ae());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.e());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.s());
    localLinkedList.add(new ac());
    localLinkedList.add(new m.a());
    AppMethodBeat.o(44153);
    return localLinkedList;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(44155);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "installed()");
    alias(com.tencent.mm.plugin.appbrand.api.c.class);
    if (!isAppBrandProcess()) {
      new IListener() {}.alive();
    }
    AppMethodBeat.o(44155);
  }
  
  public final String name()
  {
    return "plugin-appbrand";
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(226325);
    a.bus();
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.af(a.class));
    AppMethodBeat.o(226325);
  }
  
  static final class a
    extends com.tencent.mm.model.y
    implements com.tencent.mm.app.o, com.tencent.mm.kernel.a.b.b
  {
    private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a kIK;
    private com.tencent.mm.plugin.appbrand.debugger.k kIL;
    private com.tencent.mm.plugin.teenmode.a.c kIM;
    
    private a()
    {
      super();
      AppMethodBeat.i(44144);
      this.kIL = new com.tencent.mm.plugin.appbrand.debugger.k();
      this.kIM = new com.tencent.mm.plugin.teenmode.a.c()
      {
        public final void onDataChanged()
        {
          AppMethodBeat.i(226318);
          boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
          int i = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
          Log.i("MicroMsg.PluginAppBrand[speedtest]", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if ((bool) && (i != 1)) {
            com.tencent.mm.plugin.appbrand.task.h.bWb().bVX();
          }
          AppMethodBeat.o(226318);
        }
      };
      AppMethodBeat.o(44144);
    }
    
    private static void a(String paramString, z paramz)
    {
      AppMethodBeat.i(226323);
      Log.i("MicroMsg.PluginAppBrand[speedtest]", "AppBrandCompatCore tryPreloadNextTaskProcess (both waservice and wagame) reason[%s]", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPD, paramz);
      com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPE, paramz);
      AppMethodBeat.o(226323);
    }
    
    static void bus()
    {
      AppMethodBeat.i(226321);
      try
      {
        if (com.tencent.mm.kernel.g.af(a.class) == null) {
          com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(226321);
      }
    }
    
    static n but()
    {
      AppMethodBeat.i(226322);
      try
      {
        n localn = (n)at(n.class);
        return localn;
      }
      finally
      {
        AppMethodBeat.o(226322);
      }
    }
    
    public final void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(44145);
      super.onAccountInitialized(paramc);
      Log.d("MicroMsg.PluginAppBrand[speedtest]", "onAccountInitialized, WAKeyStepKvLogger.ENABLE=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.appbrand.report.quality.o.bVk()) });
      com.tencent.mm.plugin.appbrand.appcache.at.a(ar.kLY);
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramc = new com.tencent.mm.plugin.appbrand.appusage.e();
        if (paramc.rT(com.tencent.mm.protocal.d.KyO)) {
          paramc.transfer(com.tencent.mm.protocal.d.KyO);
        }
        paramc = new ac();
        if (paramc.rT(com.tencent.mm.protocal.d.KyO)) {
          paramc.transfer(com.tencent.mm.protocal.d.KyO);
        }
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        com.tencent.mm.plugin.appbrand.appusage.j.bxQ().bxR();
      }
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
      paramc = new com.tencent.mm.plugin.appbrand.appusage.s();
      if (paramc.rT(com.tencent.mm.protocal.d.KyO)) {
        paramc.transfer(com.tencent.mm.protocal.d.KyO);
      }
      paramc = new com.tencent.mm.plugin.appbrand.appusage.r();
      if (paramc.rT(com.tencent.mm.protocal.d.KyO)) {
        paramc.transfer(com.tencent.mm.protocal.d.KyO);
      }
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.f());
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.e());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.api.b.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.y.kLv));
      com.tencent.mm.kernel.g.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.p()));
      com.tencent.mm.kernel.g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.u.bth()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.h()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.d()));
      com.tencent.mm.kernel.g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.v.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.b()));
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.kPf);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.ngr);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.ngd);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.message.h.ngD);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.ngh);
      this.kIK = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
      com.tencent.mm.plugin.downloader.model.f.cBv();
      com.tencent.mm.plugin.downloader.model.c.a(this.kIK);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.kIL);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(new AppBrandMixExportLogicService()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.launching.b.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.launching.b.a.mXV));
      com.tencent.mm.blink.b.ake().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226319);
          PluginAppBrand.a.b("FirstScreenArrangement", z.nMx);
          AppMethodBeat.o(226319);
        }
      });
      com.tencent.mm.plugin.appbrand.appcache.h.a(new h.a()
      {
        public final com.tencent.mm.co.f<c.a<byz>> a(com.tencent.mm.plugin.appbrand.appcache.h paramAnonymoush)
        {
          AppMethodBeat.i(226320);
          paramAnonymoush = com.tencent.mm.plugin.appbrand.launching.v.b(paramAnonymoush);
          AppMethodBeat.o(226320);
          return paramAnonymoush;
        }
      });
      paramc = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT;
      com.tencent.mm.plugin.appbrand.widget.recent.c.ccR();
      com.tencent.mm.plugin.appbrand.appcache.w.setup();
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
      com.tencent.mm.plugin.appbrand.launching.f.a.init();
      aa.init();
      com.tencent.mm.plugin.appbrand.ui.u.install(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).ca);
      AppMethodBeat.o(44145);
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(44150);
      com.tencent.mm.kernel.g.ag(ah.class);
      com.tencent.mm.kernel.g.ag(ag.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.widget.recent.l.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.service.f.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
      com.tencent.mm.kernel.g.ag(IAppBrandBatchPreloadController.class);
      com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.appbrand.appusage.c.class);
      super.onAccountRelease();
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_view_wxapp");
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.kPf);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.ngr);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.ngd);
      com.tencent.mm.plugin.downloader.model.f.cBv();
      com.tencent.mm.plugin.downloader.model.c.b(this.kIK);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.kIL);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.ngh);
      com.tencent.mm.plugin.appbrand.x.a.bUc();
      Object localObject = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT;
      com.tencent.mm.plugin.appbrand.widget.recent.c.release();
      localObject = com.tencent.mm.plugin.appbrand.shortlink.b.nNN;
      com.tencent.mm.plugin.appbrand.shortlink.b.clearAll();
      AppMethodBeat.o(44150);
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(44148);
      paramString = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
      com.tencent.mm.plugin.appbrand.ipc.a.a.bDV();
      paramString = com.tencent.mm.plugin.appbrand.shortlink.d.nNQ;
      com.tencent.mm.plugin.appbrand.shortlink.d.bVz();
      AppMethodBeat.o(44148);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(44147);
      a("onAppForeground:".concat(String.valueOf(paramString)), z.nMy);
      AppMethodBeat.o(44147);
    }
    
    public final void parallelsDependency()
    {
      AppMethodBeat.i(44149);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class));
      AppMethodBeat.o(44149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */