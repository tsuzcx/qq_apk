package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.al.af;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.u.a;
import com.tencent.mm.storage.u.c;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Map;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.c
{
  private n.a appForegroundListener;
  private h.a ftg;
  private u.c nuw;
  private p nux;
  private p nuy;
  private p nuz;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.ftg = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, final h.c paramAnonymousc)
      {
        AppMethodBeat.i(5539);
        if ((paramAnonymoush == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(5539);
          return;
        }
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5538);
            int i;
            if ((("insert".equals(paramAnonymousc.uHb)) || ("update".equals(paramAnonymousc.uHb))) && (paramAnonymousc.gtT != null))
            {
              i = 0;
              while (i < paramAnonymousc.gtT.size())
              {
                bo localbo = (bo)paramAnonymousc.gtT.get(i);
                if (localbo.field_isSend != 1) {
                  v.aG(localbo);
                }
                i += 1;
              }
              AppMethodBeat.o(5538);
              return;
            }
            if (("delete".equals(paramAnonymousc.uHb)) && (paramAnonymousc.gtT != null))
            {
              i = 0;
              while (i < paramAnonymousc.gtT.size())
              {
                v.aH((bo)paramAnonymousc.gtT.get(i));
                i += 1;
              }
            }
            AppMethodBeat.o(5538);
          }
        }, 0L);
        AppMethodBeat.o(5539);
      }
    };
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        boolean bool = false;
        AppMethodBeat.i(5540);
        paramAnonymousString = com.tencent.mm.pluginsdk.b.Dfd;
        if (com.tencent.mm.pluginsdk.b.eJW())
        {
          paramAnonymousString = com.tencent.mm.pluginsdk.b.Dfd;
          if (com.tencent.mm.pluginsdk.b.eJX()) {
            break label58;
          }
        }
        for (;;)
        {
          if (bool)
          {
            paramAnonymousString = com.tencent.mm.pluginsdk.b.Dfd;
            com.tencent.mm.pluginsdk.b.eJZ();
          }
          if (v.eZG()) {
            v.YB(v.GCA);
          }
          AppMethodBeat.o(5540);
          return;
          label58:
          bool = com.tencent.mm.pluginsdk.b.bJa().getBoolean("biz_time_preload_at_foreground", false);
          ac.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.nuw = new u.c()
    {
      public final void a(Object paramAnonymousObject, u.a paramAnonymousa)
      {
        AppMethodBeat.i(5542);
        b.a("UpdateBizMainCellThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5541);
            v.eZD();
            AppMethodBeat.o(5541);
          }
        }, 0L);
        AppMethodBeat.o(5542);
      }
    };
    this.nux = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final f.a paramAnonymousa)
      {
        AppMethodBeat.i(5544);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5543);
            v.c(paramAnonymousMap, paramAnonymousa);
            AppMethodBeat.o(5543);
          }
        }, 0L);
        AppMethodBeat.o(5544);
      }
    };
    this.nuy = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(5546);
        b.a("BrandServiceWorkerThread", new PluginBrandService.7.1(this, paramAnonymousMap), 0L);
        AppMethodBeat.o(5546);
      }
    };
    this.nuz = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final f.a paramAnonymousa)
      {
        AppMethodBeat.i(5548);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5547);
            v.d(paramAnonymousMap, paramAnonymousa);
            AppMethodBeat.o(5547);
          }
        }, 0L);
        AppMethodBeat.o(5548);
      }
    };
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    com.tencent.mm.sdk.b.a.GpY.c(new PluginBrandService.1(this));
    AppMethodBeat.o(5555);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(5556);
    com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c() {});
    AppMethodBeat.o(5556);
  }
  
  private void registerVFS()
  {
    AppMethodBeat.i(198630);
    ac.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    o.b("WebPrefetchContent", "webprefetch/content", 86400000L, 68);
    o.b("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 68);
    o.b("WebPrefetchResource", "webprefetch/resource", 604800000L, 68);
    AppMethodBeat.o(198630);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    ac.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.ahL())
    {
      registerVFS();
      pin(new t(d.class));
    }
    AppMethodBeat.o(5551);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5552);
    com.tencent.mm.br.c.aIn("brandservice");
    ac.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.ahL()) || (paramg.up(":tools")) || (paramg.up(":toolsmp")) || (paramg.uq(":appbrand")))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.d.class, new e());
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.AY();
    paramg = a.nug;
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.bIN() });
    AppMethodBeat.o(5552);
  }
  
  public void installed()
  {
    AppMethodBeat.i(5550);
    alias(com.tencent.mm.plugin.brandservice.a.c.class);
    AppMethodBeat.o(5550);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(5553);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.ftg, Looper.getMainLooper());
    af.aDc().a(this.nuw, Looper.getMainLooper());
    af.aDd().a(this.nuw, Looper.getMainLooper());
    this.appForegroundListener.alive();
    if (v.bIO())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.e();
      ac.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRj, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNK("officialaccounts");
        af.aDc().eZs();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRj, Integer.valueOf(i | 0x1));
      }
    }
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("BizRejectMsgRecommendNotify", this.nuz);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.nux);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.nuy);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.ftg);
    af.aDc().a(this.nuw);
    af.aDd().a(this.nuw);
    this.appForegroundListener.dead();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("BizRejectMsgRecommendNotify", this.nuz);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.nux);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.nuy);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */