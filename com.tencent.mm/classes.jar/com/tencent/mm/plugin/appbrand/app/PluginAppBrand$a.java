package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.aa;
import com.tencent.mm.plugin.appbrand.appcache.i.a;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.o;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.backgroundfetch.l;
import com.tencent.mm.plugin.appbrand.n.ac;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.p;

final class PluginAppBrand$a
  extends com.tencent.mm.model.y
  implements com.tencent.mm.app.q, com.tencent.mm.kernel.a.b.b
{
  private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a qCt;
  private com.tencent.mm.plugin.appbrand.debugger.m qCu;
  private com.tencent.mm.plugin.teenmode.a.g qCv;
  
  private PluginAppBrand$a()
  {
    super(n.class);
    AppMethodBeat.i(44144);
    this.qCu = new com.tencent.mm.plugin.appbrand.debugger.m();
    this.qCv = new com.tencent.mm.plugin.teenmode.a.g()
    {
      public final void onDataChanged()
      {
        AppMethodBeat.i(317748);
        boolean bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        final int i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr();
        Log.i("MicroMsg.PluginAppBrand[speedtest]", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if ((bool) && (i != 1))
        {
          Object localObject1 = com.tencent.mm.plugin.appbrand.task.i.cJV();
          kotlin.g.a.m local1 = new kotlin.g.a.m() {};
          kotlin.g.b.s.u(local1, "predicate");
          localObject1 = ((Iterable)((com.tencent.mm.plugin.appbrand.task.i)localObject1).asg()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            com.tencent.mm.plugin.appbrand.task.d locald = (com.tencent.mm.plugin.appbrand.task.d)((Iterator)localObject1).next();
            kotlin.g.b.s.u(local1, "predicate");
            Object localObject3 = (Iterable)locald.asd();
            Object localObject2 = (Collection)new ArrayList();
            localObject3 = ((Iterable)localObject3).iterator();
            label246:
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = ((Iterator)localObject3).next();
              com.tencent.luggage.sdk.processes.e locale = (com.tencent.luggage.sdk.processes.e)localObject4;
              if ((!locale.epd) && (((Boolean)local1.invoke(locale.appId, Integer.valueOf(locale.eul))).booleanValue())) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label246;
                }
                ((Collection)localObject2).add(localObject4);
                break;
              }
            }
            localObject3 = (Iterable)localObject2;
            localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((Collection)localObject2).add(((com.tencent.luggage.sdk.processes.e)((Iterator)localObject3).next()).appId);
            }
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              com.tencent.luggage.sdk.processes.c.a((com.tencent.luggage.sdk.processes.c)locald, (LuggageClientProcessMessage)new AppBrandKillByClientMessage((String)localObject3, com.tencent.luggage.sdk.processes.b.etS.ordinal()));
            }
          }
        }
        AppMethodBeat.o(317748);
      }
    };
    AppMethodBeat.o(44144);
  }
  
  private static void a(String paramString, com.tencent.mm.plugin.appbrand.service.ab paramab)
  {
    AppMethodBeat.i(317774);
    Log.i("MicroMsg.PluginAppBrand[speedtest]", "AppBrandCompatCore tryPreloadNextTaskProcess (both waservice and wagame) reason[%s]", new Object[] { paramString });
    com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euv, paramab);
    com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euw, paramab);
    AppMethodBeat.o(317774);
  }
  
  static void ceS()
  {
    AppMethodBeat.i(317767);
    try
    {
      if (com.tencent.mm.kernel.h.ax(a.class) == null) {
        com.tencent.mm.kernel.h.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(317767);
    }
  }
  
  static n ceT()
  {
    AppMethodBeat.i(317772);
    try
    {
      n localn = (n)aL(n.class);
      return localn;
    }
    finally
    {
      AppMethodBeat.o(317772);
    }
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(44145);
    super.onAccountInitialized(paramc);
    Log.d("MicroMsg.PluginAppBrand[speedtest]", "onAccountInitialized, WAKeyStepKvLogger.ENABLE=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.appbrand.report.quality.n.cJm()) });
    if (BuildInfo.IS_FLAVOR_RED)
    {
      paramc = new com.tencent.mm.plugin.appbrand.appusage.d();
      if (paramc.vc(com.tencent.mm.protocal.d.Yxh)) {
        paramc.vb(com.tencent.mm.protocal.d.Yxh);
      }
      paramc = new ac();
      if (paramc.vc(com.tencent.mm.protocal.d.Yxh)) {
        paramc.vb(com.tencent.mm.protocal.d.Yxh);
      }
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      com.tencent.mm.plugin.appbrand.appusage.i.ciJ().ciK();
    }
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
    paramc = new r();
    if (paramc.vc(com.tencent.mm.protocal.d.Yxh)) {
      paramc.vb(com.tencent.mm.protocal.d.Yxh);
    }
    paramc = new com.tencent.mm.plugin.appbrand.appusage.q();
    if (paramc.vc(com.tencent.mm.protocal.d.Yxh)) {
      paramc.vb(com.tencent.mm.protocal.d.Yxh);
    }
    com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.f());
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.e());
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.api.b.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.ab.qFk));
    com.tencent.mm.kernel.h.a(ag.class, new com.tencent.mm.kernel.c.e(new o()));
    com.tencent.mm.kernel.h.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.e()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(aa.cdp()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.h()));
    com.tencent.mm.kernel.h.a(k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
    com.tencent.mm.kernel.h.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.h()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.y.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.d()));
    com.tencent.mm.kernel.h.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
    com.tencent.mm.kernel.h.a(x.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.c()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.w.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.b()));
    paramc = com.tencent.mm.plugin.appbrand.config.w.raK;
    com.tencent.mm.plugin.appbrand.config.w.G("gh_fa3775177794@app", "wx1975249228c5cea8", 1205);
    paramc = com.tencent.mm.plugin.appbrand.config.w.raK;
    com.tencent.mm.plugin.appbrand.config.w.G("gh_15a734ca91f5@app", "wx6509e7dc7bdc968d", 1189);
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.debugger.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.debugger.j()));
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.qIT);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.tlM);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.tly);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.message.h.tlY);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.tlC);
    this.qCt = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
    com.tencent.mm.plugin.downloader.model.f.duv();
    com.tencent.mm.plugin.downloader.model.c.a(this.qCt);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.qCu);
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new AppBrandMixExportLogicService()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.appbrand.launching.b.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.launching.b.a.tdl));
    com.tencent.mm.blink.b.aJY().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317743);
        if (AppForegroundDelegate.heY.eLx) {
          PluginAppBrand.a.b("FirstScreenArrangement", com.tencent.mm.plugin.appbrand.service.ab.tTG);
        }
        h.a(h.b.qCb);
        AppMethodBeat.o(317743);
      }
    });
    com.tencent.mm.plugin.appbrand.appcache.i.a(new i.a()
    {
      public final com.tencent.mm.cp.f<b.a<cwu>> a(com.tencent.mm.plugin.appbrand.appcache.i paramAnonymousi)
      {
        AppMethodBeat.i(317755);
        paramAnonymousi = com.tencent.mm.plugin.appbrand.launching.w.b(paramAnonymousi);
        AppMethodBeat.o(317755);
        return paramAnonymousi;
      }
    });
    paramc = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM;
    com.tencent.mm.plugin.appbrand.widget.recent.c.cSL();
    com.tencent.mm.plugin.appbrand.appcache.z.setup();
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(this.qCv);
    com.tencent.mm.plugin.appbrand.launching.teenmode.a.init();
    com.tencent.mm.plugin.appbrand.jsapi.share.z.init();
    com.tencent.mm.plugin.appbrand.ui.y.m(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP);
    AppMethodBeat.o(44145);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44150);
    com.tencent.mm.kernel.h.ay(ag.class);
    com.tencent.mm.kernel.h.ay(af.class);
    com.tencent.mm.kernel.h.ay(k.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.appbrand.service.g.class);
    com.tencent.mm.kernel.h.ay(l.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
    com.tencent.mm.kernel.h.ay(IAppBrandBatchPreloadController.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.appbrand.api.e.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.appbrand.debugger.f.class);
    com.tencent.mm.kernel.h.ay(x.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.appbrand.appusage.c.class);
    super.onAccountRelease();
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).aLc("link_view_wxapp");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).aLd("link_view_wxapp");
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.qIT);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.tlM);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.tly);
    com.tencent.mm.plugin.downloader.model.f.duv();
    com.tencent.mm.plugin.downloader.model.c.b(this.qCt);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.qCu);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.tlC);
    com.tencent.mm.plugin.appbrand.y.a.cIf();
    Object localObject = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM;
    com.tencent.mm.plugin.appbrand.widget.recent.c.release();
    localObject = com.tencent.mm.plugin.appbrand.shortlink.b.tUW;
    com.tencent.mm.plugin.appbrand.shortlink.b.clearAll();
    AppMethodBeat.o(44150);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(44148);
    paramString = com.tencent.mm.plugin.appbrand.ipc.a.a.rvP;
    com.tencent.mm.plugin.appbrand.ipc.a.a.cpC();
    paramString = com.tencent.mm.plugin.appbrand.shortlink.c.tUX;
    com.tencent.mm.plugin.appbrand.shortlink.c.cJy();
    AppMethodBeat.o(44148);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(44147);
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.plugin.appbrand.task.i.a(com.tencent.mm.plugin.appbrand.task.j.cJX());
    }
    a("onAppForeground:".concat(String.valueOf(paramString)), com.tencent.mm.plugin.appbrand.service.ab.tTH);
    com.tencent.mm.plugin.appbrand.s.publish();
    h.a(h.b.qCa);
    AppMethodBeat.o(44147);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(44149);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class));
    AppMethodBeat.o(44149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.a
 * JD-Core Version:    0.7.0.1
 */