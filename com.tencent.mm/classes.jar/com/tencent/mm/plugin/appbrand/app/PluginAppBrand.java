package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.VideoCacheServiceIPC;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.appstorage.x.a;
import com.tencent.mm.plugin.appbrand.appstorage.x.b;
import com.tencent.mm.plugin.appbrand.appusage.ad;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.am;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.config.g.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Queue;

@Keep
public final class PluginAppBrand
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.model.aj, com.tencent.mm.plugin.appbrand.a.c
{
  public static final String TAG = "MicroMsg.PluginAppBrand";
  private final com.tencent.mm.plugin.appbrand.t.f singletonRegistry;
  private com.tencent.mm.sdk.b.c<wm> xWebViewInitCompleteEventIListener;
  
  static
  {
    AppMethodBeat.i(129236);
    com.tencent.mm.compatible.util.k.a("appbrandcommon", an.class.getClassLoader());
    com.tencent.mm.compatible.util.k.a("wechatzstd", PluginAppBrand.class.getClassLoader());
    AppMethodBeat.o(129236);
  }
  
  public PluginAppBrand()
  {
    AppMethodBeat.i(129226);
    this.xWebViewInitCompleteEventIListener = new PluginAppBrand.1(this);
    this.singletonRegistry = new com.tencent.mm.plugin.appbrand.t.f();
    AppMethodBeat.o(129226);
  }
  
  private static void fixProcessSharedStringFormatLocale()
  {
    AppMethodBeat.i(154851);
    if (Build.VERSION.SDK_INT >= 24) {
      Locale.setDefault(Locale.Category.FORMAT, Locale.ENGLISH);
    }
    AppMethodBeat.o(154851);
  }
  
  private void initJSONABTestGetter()
  {
    AppMethodBeat.i(129235);
    com.tencent.mm.aa.h.a(new PluginAppBrand.7(this));
    AppMethodBeat.o(129235);
  }
  
  static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(129233);
    try
    {
      String str = com.tencent.mm.sdk.platformtools.ah.getPackageName();
      boolean bool = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName.startsWith(str + ":appbrand");
      AppMethodBeat.o(129233);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(129233);
    }
    return false;
  }
  
  static boolean isSupportProcess()
  {
    AppMethodBeat.i(129234);
    try
    {
      boolean bool = "com.tencent.mm:support".equals(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName);
      AppMethodBeat.o(129234);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(129234);
    }
    return false;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129231);
    ab.i("MicroMsg.PluginAppBrand", "configure()");
    if (isAppBrandProcess())
    {
      fixProcessSharedStringFormatLocale();
      paramg.bX.registerActivityLifecycleCallbacks(new PluginAppBrand.2(this));
      paramg.bX.registerComponentCallbacks(new PluginAppBrand.3(this));
      com.tencent.mm.sdk.a.b.b(com.tencent.mm.plugin.appbrand.d.a.hkV);
    }
    if (!com.tencent.mm.sdk.platformtools.ah.brt())
    {
      com.tencent.mm.cm.i.AZz = new com.tencent.mm.vending.h.h(com.tencent.mm.cm.d.c(m.aNS().caB()), "WeChat.WORKER");
      com.tencent.mm.vending.h.g.a("WeChat.WORKER", com.tencent.mm.cm.i.AZz);
    }
    AppMethodBeat.o(129231);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(129230);
    ab.i("MicroMsg.PluginAppBrand", "dependency()");
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    dependsOn(com.tencent.mm.plugin.appbrand.compat.a.c.class);
    AppMethodBeat.o(129230);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129232);
    ab.i("MicroMsg.PluginAppBrand", "execute() current process name = %s, isMainThread %b", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName, Boolean.valueOf(al.isMainThread()) });
    q.a.a(com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.ioC);
    com.tencent.mm.kernel.g.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.ao()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.w.a.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.b.g()));
    Object localObject1;
    if (paramg.SD())
    {
      localObject1 = x.b.haG;
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a)localObject1);
      com.tencent.mm.plugin.appbrand.game.c.b.uD();
      com.tencent.luggage.game.c.c.uC().bAe = new com.tencent.mm.plugin.appbrand.game.d.a();
      initJSONABTestGetter();
      localObject1 = new h(paramg);
      if (com.tencent.luggage.bridge.a.a.byu == null) {
        break label761;
      }
      com.tencent.luggage.g.d.e("Luggage.LuggageBoot", "do not setup more than once.");
    }
    for (;;)
    {
      if (!paramg.SD()) {
        break label781;
      }
      com.tencent.mm.kernel.g.RM().a(new PluginAppBrand.4(this));
      paramg = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c.jgP;
      com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c.init(com.tencent.mm.sdk.platformtools.ah.getContext());
      com.tencent.mm.plugin.w.c.qSb.a(new com.tencent.mm.plugin.appbrand.ai());
      com.tencent.mm.plugin.w.c.qSb.a(new com.tencent.mm.plugin.appbrand.aj());
      com.tencent.mm.kernel.g.a(PluginAppBrand.a.class, new com.tencent.mm.kernel.c.e(new PluginAppBrand.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.kernel.c.e(new e()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.o()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new d()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.d.class, new com.tencent.mm.kernel.c.e(new i()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new com.tencent.mm.kernel.c.e(new j()));
      com.tencent.mm.kernel.g.a(n.class, new com.tencent.mm.kernel.c.e(new am()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.j.e()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.j.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.t.j()));
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[] { "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_player", "//xweb_video", "//localwxalibrary" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[] { "//widget" });
      com.tencent.mm.plugin.appbrand.w.a.uD();
      com.tencent.mm.kernel.g.RM().a(new PluginAppBrand.5(this));
      if (DebuggerShell.ayR()) {
        com.tencent.mm.kernel.g.b(DebuggerShell.class, new DebuggerShell());
      }
      z.a(new s());
      AppBrandVideoWrapper.aCz();
      AppMethodBeat.o(129232);
      return;
      localObject1 = x.a.haE;
      break;
      label761:
      com.tencent.luggage.bridge.a.a.byu = (a.b)localObject1;
      ((a.b)localObject1).a(new a.1());
    }
    label781:
    Object localObject2;
    if ((com.tencent.mm.sdk.platformtools.ah.dsW()) || (com.tencent.mm.sdk.platformtools.ah.dsX()) || (isAppBrandProcess()))
    {
      com.tencent.mm.plugin.appbrand.report.model.i.aLk();
      com.tencent.mm.ipcinvoker.g.ma("com.tencent.mm:tools");
      com.tencent.mm.kernel.g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.o()));
      com.tencent.mm.kernel.g.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.c()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataTokenStorageIPC()));
      com.tencent.mm.kernel.g.b(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.b.class, VideoCacheServiceIPC.bId);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.kernel.c.e(new f()));
      com.tencent.mm.plugin.appbrand.launching.precondition.i.cT(com.tencent.mm.sdk.platformtools.ah.getContext());
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.bX;
      ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
      ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
      localObject1 = this.singletonRegistry;
      localObject2 = paramg.bX;
      ((com.tencent.mm.plugin.appbrand.t.f)localObject1).iXE = true;
      ((com.tencent.mm.plugin.appbrand.t.f)localObject1).app = ((Application)localObject2);
      localObject1 = this.singletonRegistry;
      localObject2 = com.tencent.mm.plugin.appbrand.t.a.a.iYk;
      ab.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[] { localObject2 });
      ((com.tencent.mm.plugin.appbrand.t.f)localObject1).iXC.offer(localObject2);
      com.tencent.mm.plugin.appbrand.f.e(paramg.bX);
      com.tencent.mm.ui.ah.e(paramg.bX);
    }
    if ((com.tencent.mm.sdk.platformtools.ah.dsW()) || (com.tencent.mm.sdk.platformtools.ah.dsX()))
    {
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
      com.tencent.mm.sdk.platformtools.ao.a(new PluginAppBrand.6(this));
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.ah.dsW()) {
        com.tencent.mm.aa.h.initialize();
      }
      AppMethodBeat.o(129232);
      return;
      if (isAppBrandProcess())
      {
        AppBrandProcessSuicideLogic.f(paramg.bX);
        try
        {
          localObject1 = MultiProcessSharedPreferences.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.getContext(), "pref_appbrand_process", 4);
          localObject2 = com.tencent.mm.sdk.platformtools.ah.getProcessName() + ":start_time";
          SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
          if (((SharedPreferences)localObject1).contains((String)localObject2))
          {
            localEditor.remove((String)localObject2);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(365L, 2L, 1L, false);
          }
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(365L, 4L, 1L, false);
          localEditor.putLong((String)localObject2, System.currentTimeMillis());
          localEditor.commit();
          ab.v("MicroMsg.AppBrandReporter", "onProcessStart");
          KVCommCrossProcessReceiver.chK();
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessStart()", new Object[0]);
          }
        }
        com.tencent.mm.plugin.appbrand.task.a.c.f(paramg.bX);
        continue;
      }
      if (isSupportProcess())
      {
        com.tencent.mm.plugin.appbrand.dynamic.h.e.cH(com.tencent.mm.sdk.platformtools.ah.getContext());
        com.tencent.mm.aa.h.initialize();
      }
    }
  }
  
  final g getCore()
  {
    AppMethodBeat.i(129228);
    g localg = (g)q.S(g.class);
    AppMethodBeat.o(129228);
    return localg;
  }
  
  public final List<com.tencent.mm.model.ai> getDataTransferList()
  {
    AppMethodBeat.i(129227);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new g.1(new com.tencent.mm.plugin.appbrand.config.g()));
    localLinkedList.add(new ad());
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appusage.e());
    AppMethodBeat.o(129227);
    return localLinkedList;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(129229);
    ab.i("MicroMsg.PluginAppBrand", "installed()");
    alias(com.tencent.mm.plugin.appbrand.a.c.class);
    this.xWebViewInitCompleteEventIListener.alive();
    AppMethodBeat.o(129229);
  }
  
  public final String name()
  {
    return "plugin-appbrand";
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand
 * JD-Core Version:    0.7.0.1
 */