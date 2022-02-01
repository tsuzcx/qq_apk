package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.al;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.t.c;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.v;
import com.tencent.mm.vfs.o;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.c
{
  private n.a appForegroundListener;
  private h.a fpE;
  private t.c mSg;
  private p mSh;
  private p mSi;
  private p mSj;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.fpE = new PluginBrandService.3(this);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        boolean bool = false;
        AppMethodBeat.i(5540);
        paramAnonymousString = com.tencent.mm.pluginsdk.b.BMT;
        if (com.tencent.mm.pluginsdk.b.euD())
        {
          paramAnonymousString = com.tencent.mm.pluginsdk.b.BMT;
          if (com.tencent.mm.pluginsdk.b.euE()) {
            break label58;
          }
        }
        for (;;)
        {
          if (bool)
          {
            paramAnonymousString = com.tencent.mm.pluginsdk.b.BMT;
            com.tencent.mm.pluginsdk.b.euG();
          }
          if (u.eKj()) {
            u.Wr(u.FeQ);
          }
          AppMethodBeat.o(5540);
          return;
          label58:
          bool = com.tencent.mm.pluginsdk.b.bCc().getBoolean("biz_time_preload_at_foreground", false);
          ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.mSg = new PluginBrandService.5(this);
    this.mSh = new PluginBrandService.6(this);
    this.mSi = new PluginBrandService.7(this);
    this.mSj = new PluginBrandService.8(this);
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    com.tencent.mm.sdk.b.a.ESL.c(new PluginBrandService.1(this));
    AppMethodBeat.o(5555);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(5556);
    com.tencent.mm.sdk.b.a.ESL.b(new com.tencent.mm.sdk.b.c() {});
    AppMethodBeat.o(5556);
  }
  
  private void registerVFS()
  {
    AppMethodBeat.i(192934);
    ad.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    o.b("WebPrefetchContent", "webprefetch/content", 86400000L, 68, true);
    o.b("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 68, true);
    o.b("WebPrefetchResource", "webprefetch/resource", 604800000L, 68, true);
    AppMethodBeat.o(192934);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    ad.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.agu())
    {
      registerVFS();
      pin(new com.tencent.mm.model.t(d.class));
    }
    AppMethodBeat.o(5551);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5552);
    com.tencent.mm.bs.c.aCW("brandservice");
    ad.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.agu()) || (paramg.ra(":tools")) || (paramg.ra(":toolsmp")) || (paramg.rb(":appbrand")))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.d.class, new e());
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.Bu();
    paramg = a.mRQ;
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.bBP() });
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
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.fpE, Looper.getMainLooper());
    af.awk().a(this.mSg, Looper.getMainLooper());
    af.awl().a(this.mSg, Looper.getMainLooper());
    this.appForegroundListener.alive();
    if (u.bBQ())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.e();
      ad.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftp, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIp("officialaccounts");
        af.awk().eJV();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftp, Integer.valueOf(i | 0x1));
      }
    }
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("BizRejectMsgRecommendNotify", this.mSj);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.mSh);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.mSi);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.fpE);
    af.awk().a(this.mSg);
    af.awl().a(this.mSg);
    this.appForegroundListener.dead();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("BizRejectMsgRecommendNotify", this.mSj);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.mSh);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.mSi);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */