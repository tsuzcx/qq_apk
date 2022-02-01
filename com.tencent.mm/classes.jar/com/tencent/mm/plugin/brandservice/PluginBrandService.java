package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.y;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Map;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.c
{
  private n.a appForegroundListener;
  private i.a fLG;
  private x.c nVS;
  private q nVT;
  private q nVU;
  private q nVV;
  private q nVW;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.fLG = new i.a()
    {
      public final void a(i paramAnonymousi, final i.c paramAnonymousc)
      {
        AppMethodBeat.i(209431);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(209431);
          return;
        }
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5541);
            int i;
            if ((("insert".equals(paramAnonymousc.vKe)) || ("update".equals(paramAnonymousc.vKe))) && (paramAnonymousc.gNE != null))
            {
              i = 0;
              while (i < paramAnonymousc.gNE.size())
              {
                bu localbu = (bu)paramAnonymousc.gNE.get(i);
                if (localbu.field_isSend != 1) {
                  y.aJ(localbu);
                }
                i += 1;
              }
              AppMethodBeat.o(5541);
              return;
            }
            if (("delete".equals(paramAnonymousc.vKe)) && (paramAnonymousc.gNE != null))
            {
              i = 0;
              while (i < paramAnonymousc.gNE.size())
              {
                y.aK((bu)paramAnonymousc.gNE.get(i));
                i += 1;
              }
            }
            AppMethodBeat.o(5541);
          }
        }, 0L);
        AppMethodBeat.o(209431);
      }
    };
    this.appForegroundListener = new PluginBrandService.6(this);
    this.nVS = new x.c()
    {
      public final void a(Object paramAnonymousObject, x.a paramAnonymousa)
      {
        AppMethodBeat.i(209433);
        b.a("UpdateBizMainCellThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5543);
            y.fpD();
            AppMethodBeat.o(5543);
          }
        }, 0L);
        AppMethodBeat.o(209433);
      }
    };
    this.nVT = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final e.a paramAnonymousa)
      {
        AppMethodBeat.i(5546);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5545);
            y.c(paramAnonymousMap, paramAnonymousa);
            AppMethodBeat.o(5545);
          }
        }, 0L);
        AppMethodBeat.o(5546);
      }
    };
    this.nVU = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(5548);
        b.a("BrandServiceWorkerThread", new PluginBrandService.9.1(this, paramAnonymousMap, paramAnonymousa), 0L);
        AppMethodBeat.o(5548);
      }
    };
    this.nVV = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(209435);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209434);
            com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.nWn;
            com.tencent.mm.plugin.brandservice.b.a.R(paramAnonymousMap);
            AppMethodBeat.o(209434);
          }
        }, 0L);
        AppMethodBeat.o(209435);
      }
    };
    this.nVW = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final e.a paramAnonymousa)
      {
        AppMethodBeat.i(209428);
        b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209427);
            Object localObject = com.tencent.mm.plugin.biz.b.a.nOO;
            Map localMap = paramAnonymousMap;
            e.a locala = paramAnonymousa;
            if (locala != null) {}
            for (localObject = locala.gqE; (localObject == null) || (locala.gqE.Fvk == null) || (localMap == null); localObject = null)
            {
              ad.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
              AppMethodBeat.o(209427);
              return;
            }
            com.tencent.mm.plugin.biz.b.a.f(localMap, com.tencent.mm.platformtools.z.a(locala.gqE.Fvk));
            AppMethodBeat.o(209427);
          }
        }, 0L);
        AppMethodBeat.o(209428);
      }
    };
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    com.tencent.mm.sdk.b.a.IbL.c(new PluginBrandService.3(this));
    AppMethodBeat.o(5555);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(5556);
    com.tencent.mm.sdk.b.a.IbL.b(new PluginBrandService.4(this));
    AppMethodBeat.o(5556);
  }
  
  private void registerVFS()
  {
    AppMethodBeat.i(209436);
    ad.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    o.b("WebPrefetchContent", "webprefetch/content", 86400000L, 68);
    o.b("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 68);
    o.b("WebPrefetchResource", "webprefetch/resource", 604800000L, 68);
    AppMethodBeat.o(209436);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    ad.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.akw())
    {
      registerVFS();
      pin(new t(d.class));
      ((r)com.tencent.mm.kernel.g.ad(r.class)).setBizTimeLineCallback(new com.tencent.mm.plugin.messenger.foundation.a.b()
      {
        public final boolean az(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(209426);
          ad.i("MicroMsg.PluginBrandService", "testInsertBizAd %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 1) {
            p.InU.aaD(2);
          }
          for (;;)
          {
            AppMethodBeat.o(209426);
            return true;
            if (paramAnonymousInt == 2)
            {
              ax localax = ax.aQA("brandService");
              localax.encode("BizTimeLineAdTestMode", bt.getInt(paramAnonymousString, 0));
              localax.apply();
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
    com.tencent.mm.bs.c.aNQ("brandservice");
    ad.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.akw()) || (paramg.xf(":tools")) || (paramg.xf(":toolsmp")) || (paramg.xg(":appbrand")))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.d.class, new e());
    }
    h.Cx();
    paramg = a.nVw;
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.bNd() });
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
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.fLG, Looper.getMainLooper());
    ag.aGf().a(this.nVS, Looper.getMainLooper());
    ag.aGg().a(this.nVS, Looper.getMainLooper());
    this.appForegroundListener.alive();
    if (y.bNf())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.d();
      ad.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDN, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTB("officialaccounts");
        ag.aGf().fpr();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDN, Integer.valueOf(i | 0x1));
      }
    }
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.nVT);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.nVV);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("BizNotification", this.nVW);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("BizRecommendExpt", this.nVU);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.fLG);
    ag.aGf().a(this.nVS);
    ag.aGg().a(this.nVS);
    this.appForegroundListener.dead();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.nVT);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.nVV);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("BizNotification", this.nVW);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("BizRecommendExpt", this.nVU);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */