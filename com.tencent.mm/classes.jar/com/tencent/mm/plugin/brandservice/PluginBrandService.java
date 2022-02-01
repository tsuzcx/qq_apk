package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.c;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.r;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.p;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.d
{
  private o.a appForegroundListener;
  private i.a gsV;
  private q pmA;
  private q pmB;
  private aa.c pmx;
  private q pmy;
  private q pmz;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.gsV = new i.a()
    {
      public final void a(i paramAnonymousi, final i.c paramAnonymousc)
      {
        AppMethodBeat.i(194848);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(194848);
          return;
        }
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5541);
            int i;
            if ((("insert".equals(paramAnonymousc.zqn)) || ("update".equals(paramAnonymousc.zqn))) && (paramAnonymousc.hIs != null))
            {
              i = 0;
              while (i < paramAnonymousc.hIs.size())
              {
                ca localca = (ca)paramAnonymousc.hIs.get(i);
                if (localca.field_isSend != 1) {
                  ab.aV(localca);
                }
                i += 1;
              }
              AppMethodBeat.o(5541);
              return;
            }
            if (("delete".equals(paramAnonymousc.zqn)) && (paramAnonymousc.hIs != null))
            {
              i = 0;
              while (i < paramAnonymousc.hIs.size())
              {
                ab.aW((ca)paramAnonymousc.hIs.get(i));
                i += 1;
              }
            }
            AppMethodBeat.o(5541);
          }
        }, 0L);
        AppMethodBeat.o(194848);
      }
    };
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(194850);
        paramAnonymousString = r.NPl;
        r.gzU();
        AppMethodBeat.o(194850);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        boolean bool2 = true;
        AppMethodBeat.i(194849);
        paramAnonymousString = r.NPl;
        r.gzV();
        paramAnonymousString = com.tencent.mm.pluginsdk.c.JSr;
        if (com.tencent.mm.pluginsdk.c.glJ())
        {
          paramAnonymousString = com.tencent.mm.pluginsdk.c.JSr;
          if (com.tencent.mm.pluginsdk.c.glK()) {
            break label78;
          }
          bool1 = false;
          if (bool1) {
            com.tencent.mm.pluginsdk.c.JSr.glN();
          }
        }
        paramAnonymousString = ad.NRn;
        if (BuildInfo.DEBUG) {
          bool1 = bool2;
        }
        for (;;)
        {
          if (bool1)
          {
            paramAnonymousString = ad.NRn;
            ad.aka(ab.NQO);
          }
          AppMethodBeat.o(194849);
          return;
          label78:
          bool1 = com.tencent.mm.pluginsdk.c.aTI().getBoolean("biz_time_preload_at_foreground", false);
          Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool1) });
          break;
          if (!ad.gBi())
          {
            bool1 = false;
          }
          else
          {
            if (ad.NRl == null) {
              break label145;
            }
            paramAnonymousString = ad.NRl;
            if (paramAnonymousString == null) {
              p.hyc();
            }
            bool1 = paramAnonymousString.booleanValue();
          }
        }
        label145:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTM, 0) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ad.NRl = Boolean.valueOf(bool1);
          Log.i("MicroMsg.BizTimeLineResortLogic", "isForeGroundBizMsgResortOpen open %b", new Object[] { ad.NRl });
          paramAnonymousString = ad.NRl;
          if (paramAnonymousString == null) {
            p.hyc();
          }
          bool1 = paramAnonymousString.booleanValue();
          break;
        }
      }
    };
    this.pmx = new aa.c()
    {
      public final void a(Object paramAnonymousObject, aa.a paramAnonymousa)
      {
        AppMethodBeat.i(194851);
        b.a("UpdateBizMainCellThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5543);
            ab.gBa();
            AppMethodBeat.o(5543);
          }
        }, 0L);
        AppMethodBeat.o(194851);
      }
    };
    this.pmy = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(5546);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5545);
            ab.c(paramAnonymousMap, paramAnonymousa);
            AppMethodBeat.o(5545);
          }
        }, 0L);
        AppMethodBeat.o(5546);
      }
    };
    this.pmz = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(5548);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5547);
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if ((paramAnonymousa != null) && (paramAnonymousa.heO != null) && (paramAnonymousa.heO.KHn != null))
            {
              localObject1 = paramAnonymousMap;
              localObject2 = z.a(paramAnonymousa.heO.KHn);
              p.h(localObject1, "values");
              p.h(localObject2, "content");
              if (af.gBp())
              {
                localObject3 = af.bV((Map)localObject1);
                if (localObject3 == null)
                {
                  AppMethodBeat.o(5547);
                  return;
                }
                if (!af.b((ege)localObject3, null))
                {
                  Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
                  AppMethodBeat.o(5547);
                  return;
                }
                switch (((ege)localObject3).MOD)
                {
                }
              }
            }
            for (;;)
            {
              localObject2 = com.tencent.mm.plugin.webcanvas.l.IAx;
              com.tencent.mm.plugin.webcanvas.l.LV(81L);
              long l = Util.getLong((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.RecID"), 0L);
              int i = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Pos"), -1);
              int j = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Weight"), -1);
              int k = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
              localObject2 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.CardID");
              localObject3 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExpType");
              localObject1 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExtraData");
              Object localObject4 = com.tencent.mm.storage.s.NPC;
              com.tencent.mm.storage.s.a(i, j, k, 5, 1001, l, (String)localObject2, (String)localObject3, (String)localObject1);
              AppMethodBeat.o(5547);
              return;
              localObject4 = MultiProcessMMKV.getSingleMMKV("brandService");
              StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
              p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
              ((MultiProcessMMKV)localObject4).encode(com.tencent.mm.kernel.a.ayV(), (String)localObject2);
              r.NPl.b((ege)localObject3);
              continue;
              af.f((ege)localObject3);
              continue;
              localObject4 = ac.NRc;
              ac.bjb((String)localObject2);
              r.NPl.b((ege)localObject3);
              localObject2 = ac.NRc;
              ac.Nd(2L);
            }
          }
        }, 0L);
        AppMethodBeat.o(5548);
      }
    };
    this.pmA = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(194853);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194852);
            com.tencent.mm.plugin.brandservice.b.a.pmT.ab(paramAnonymousMap);
            AppMethodBeat.o(194852);
          }
        }, 0L);
        AppMethodBeat.o(194853);
      }
    };
    this.pmB = new PluginBrandService.2(this);
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    EventCenter.instance.addListener(new IListener() {});
    AppMethodBeat.o(5555);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(5556);
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(5556);
  }
  
  private void registerVFS()
  {
    AppMethodBeat.i(194854);
    Log.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    com.tencent.mm.vfs.y.b("WebPrefetchContent", "webprefetch/content", 86400000L, 68);
    com.tencent.mm.vfs.y.b("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 68);
    com.tencent.mm.vfs.y.b("WebPrefetchResource", "webprefetch/resource", 604800000L, 68);
    AppMethodBeat.o(194854);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    Log.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.aBb())
    {
      registerVFS();
      pin(new com.tencent.mm.model.y(d.class));
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setBizTimeLineCallback(new com.tencent.mm.plugin.messenger.foundation.a.b()
      {
        public final boolean aB(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(194843);
          Log.i("MicroMsg.PluginBrandService", "testInsertBizAd %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 1) {
            r.NPl.ajP(2);
          }
          for (;;)
          {
            AppMethodBeat.o(194843);
            return true;
            if (paramAnonymousInt == 2)
            {
              MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
              localMultiProcessMMKV.encode("BizTimeLineAdTestMode", Util.getInt(paramAnonymousString, 0));
              localMultiProcessMMKV.apply();
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
    com.tencent.mm.br.b.bfQ("brandservice");
    Log.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.aBb()) || (paramg.FY(":tools")) || (paramg.FY(":toolsmp")) || (paramg.FZ(":appbrand")))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.e.class, new e());
    }
    j.LW();
    paramg = a.pma;
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.clb() });
    AppMethodBeat.o(5552);
  }
  
  public void installed()
  {
    AppMethodBeat.i(5550);
    alias(com.tencent.mm.plugin.brandservice.a.d.class);
    AppMethodBeat.o(5550);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(5553);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.gsV, Looper.getMainLooper());
    ag.ban().a(this.pmx, Looper.getMainLooper());
    ag.bap().a(this.pmx, Looper.getMainLooper());
    this.appForegroundListener.alive();
    if (ab.clc())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.c();
      Log.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgK, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bka("officialaccounts");
        ag.ban().gAQ();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgK, Integer.valueOf(i | 0x1));
      }
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.pmy);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.pmA);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("BizNotification", this.pmB);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("BizRecommendExpt", this.pmz);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.gsV);
    ag.ban().a(this.pmx);
    ag.bap().a(this.pmx);
    this.appForegroundListener.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.pmy);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.pmA);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("BizNotification", this.pmB);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("BizRecommendExpt", this.pmz);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */