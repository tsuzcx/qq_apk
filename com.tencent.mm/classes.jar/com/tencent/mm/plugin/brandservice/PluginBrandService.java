package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.an;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.c
{
  private o.a appForegroundListener;
  private i.a fNK;
  private x.c obB;
  private q obC;
  private q obD;
  private q obE;
  private q obF;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.fNK = new PluginBrandService.5(this);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(208386);
        paramAnonymousString = p.IIi;
        p.OzN = false;
        if (p.IIg) {
          p.fsM();
        }
        AppMethodBeat.o(208386);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        boolean bool = false;
        AppMethodBeat.i(208385);
        paramAnonymousString = p.IIi;
        p.fwP();
        paramAnonymousString = com.tencent.mm.pluginsdk.c.Fbx;
        if (com.tencent.mm.pluginsdk.c.fcy())
        {
          paramAnonymousString = com.tencent.mm.pluginsdk.c.Fbx;
          if (com.tencent.mm.pluginsdk.c.fcz()) {
            break label63;
          }
        }
        for (;;)
        {
          if (bool)
          {
            paramAnonymousString = com.tencent.mm.pluginsdk.c.Fbx;
            com.tencent.mm.pluginsdk.c.fcB();
          }
          if (y.ftG()) {
            y.abs(y.IJg);
          }
          AppMethodBeat.o(208385);
          return;
          label63:
          bool = com.tencent.mm.pluginsdk.c.bOc().getBoolean("biz_time_preload_at_foreground", false);
          ae.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.obB = new PluginBrandService.7(this);
    this.obC = new PluginBrandService.8(this);
    this.obD = new PluginBrandService.9(this);
    this.obE = new PluginBrandService.10(this);
    this.obF = new PluginBrandService.2(this);
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
    AppMethodBeat.o(5555);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(5556);
    com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
    AppMethodBeat.o(5556);
  }
  
  private void registerVFS()
  {
    AppMethodBeat.i(208390);
    ae.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    com.tencent.mm.vfs.u.b("WebPrefetchContent", "webprefetch/content", 86400000L, 68);
    com.tencent.mm.vfs.u.b("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 68);
    com.tencent.mm.vfs.u.b("WebPrefetchResource", "webprefetch/resource", 604800000L, 68);
    AppMethodBeat.o(208390);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    ae.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.akL())
    {
      registerVFS();
      pin(new com.tencent.mm.model.u(d.class));
      ((s)com.tencent.mm.kernel.g.ad(s.class)).setBizTimeLineCallback(new com.tencent.mm.plugin.messenger.foundation.a.b()
      {
        public final boolean ay(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(208379);
          ae.i("MicroMsg.PluginBrandService", "testInsertBizAd %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 1) {
            p.IIi.abj(2);
          }
          for (;;)
          {
            AppMethodBeat.o(208379);
            return true;
            if (paramAnonymousInt == 2)
            {
              ay localay = ay.aRX("brandService");
              localay.encode("BizTimeLineAdTestMode", bu.getInt(paramAnonymousString, 0));
              localay.apply();
            }
          }
        }
      });
    }
    AppMethodBeat.o(5551);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5552);
    com.tencent.mm.br.c.aPn("brandservice");
    ae.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.akL()) || (paramg.xO(":tools")) || (paramg.xO(":toolsmp")) || (paramg.xP(":appbrand")))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.d.class, new e());
    }
    h.CA();
    paramg = a.obd;
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.bOb() });
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
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.fNK, Looper.getMainLooper());
    ag.aGv().a(this.obB, Looper.getMainLooper());
    ag.aGw().a(this.obB, Looper.getMainLooper());
    this.appForegroundListener.alive();
    if (y.bOd())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.d();
      ae.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYn, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVc("officialaccounts");
        ag.aGv().ftq();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYn, Integer.valueOf(i | 0x1));
      }
    }
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.obC);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.obE);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("BizNotification", this.obF);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("BizRecommendExpt", this.obD);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.fNK);
    ag.aGv().a(this.obB);
    ag.aGw().a(this.obB);
    this.appForegroundListener.dead();
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.obC);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.obE);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("BizNotification", this.obF);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("BizRecommendExpt", this.obD);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */