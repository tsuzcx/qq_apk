package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.au;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.by;
import java.util.LinkedList;
import java.util.Map;

public class PluginBrandService
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.api.e
{
  private q.a appForegroundListener;
  private i.a lzk;
  private ac.c vAF;
  private t vAG;
  private t vAH;
  private t vAI;
  private t vAJ;
  private t vAK;
  private t vAL;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.lzk = new PluginBrandService.7(this);
    this.appForegroundListener = new PluginBrandService.8(this);
    this.vAF = new ac.c()
    {
      public final void onNotifyChange(Object paramAnonymousObject, ac.a paramAnonymousa)
      {
        AppMethodBeat.i(301478);
        b.a("UpdateBizMainCellThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5543);
            ad.iYO();
            AppMethodBeat.o(5543);
          }
        }, 0L);
        AppMethodBeat.o(301478);
      }
    };
    this.vAG = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final g.a paramAnonymousa)
      {
        AppMethodBeat.i(5546);
        b.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5545);
            ad.c(paramAnonymousMap, paramAnonymousa);
            AppMethodBeat.o(5545);
          }
        });
        AppMethodBeat.o(5546);
      }
    };
    this.vAH = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(5548);
        b.au(new PluginBrandService.11.1(this, paramAnonymousa, paramAnonymousMap));
        AppMethodBeat.o(5548);
      }
    };
    this.vAI = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final g.a paramAnonymousa)
      {
        AppMethodBeat.i(301498);
        b.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301502);
            if ((paramAnonymousa != null) && (paramAnonymousa.mpN != null) && (paramAnonymousa.mpN.YFG != null)) {
              com.tencent.mm.storage.r.acDM.ax(paramAnonymousMap, w.a(paramAnonymousa.mpN.YFG));
            }
            AppMethodBeat.o(301502);
          }
        });
        AppMethodBeat.o(301498);
      }
    };
    this.vAJ = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final g.a paramAnonymousa)
      {
        AppMethodBeat.i(301469);
        b.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301501);
            if ((paramAnonymousa != null) && (paramAnonymousa.mpN != null) && (paramAnonymousa.mpN.YFG != null) && (Util.getInt((String)paramAnonymousMap.get(".sysmsg.bizlivenotify.op_flag"), 1) == 1))
            {
              Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.deD();
              if ((localObject == null) || (Util.isNullOrNil(((fmz)localObject).abNc)))
              {
                AppMethodBeat.o(301501);
                return;
              }
              localObject = ((fmz)localObject).abNc;
              com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
              com.tencent.mm.pluginsdk.model.c.cp((LinkedList)localObject);
            }
            AppMethodBeat.o(301501);
          }
        });
        AppMethodBeat.o(301469);
      }
    };
    this.vAK = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(301465);
        b.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5541);
            com.tencent.mm.plugin.brandservice.model.b.vBC.ab(paramAnonymousMap);
            AppMethodBeat.o(5541);
          }
        });
        AppMethodBeat.o(301465);
      }
    };
    this.vAL = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final g.a paramAnonymousa)
      {
        AppMethodBeat.i(301468);
        b.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301497);
            Object localObject = com.tencent.mm.plugin.biz.b.b.vto;
            Map localMap = paramAnonymousMap;
            g.a locala = paramAnonymousa;
            if (locala == null) {}
            for (localObject = null; (localObject == null) || (locala.mpN.YFG == null) || (localMap == null); localObject = locala.mpN)
            {
              Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
              AppMethodBeat.o(301497);
              return;
            }
            com.tencent.mm.plugin.biz.b.b.i(localMap, w.a(locala.mpN.YFG));
            AppMethodBeat.o(301497);
          }
        });
        AppMethodBeat.o(301468);
      }
    };
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    new PluginBrandService.2(this, com.tencent.mm.app.f.hfK).alive();
    AppMethodBeat.o(5555);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(5556);
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    AppMethodBeat.o(5556);
  }
  
  private void registerVFS()
  {
    AppMethodBeat.i(301506);
    Log.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    com.tencent.mm.vfs.af.a("WebPrefetchContent", "webprefetch/content", 86400000L, 70);
    com.tencent.mm.vfs.af.a("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 70);
    com.tencent.mm.vfs.af.a("WebPrefetchResource", "webprefetch/resource", 604800000L, 70);
    com.tencent.mm.vfs.af.b("webview_tmpl", "webview_tmpl", 536870912L, 259200000L, 518);
    AppMethodBeat.o(301506);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    Log.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.bbA())
    {
      registerVFS();
      pin(new y(SubCoreBrandService.class));
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setBizTimeLineCallback(new d()
      {
        public final boolean aQ(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(301483);
          Log.i("MicroMsg.PluginBrandService", "testInsertBizAd %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 1) {
            com.tencent.mm.storage.r.acDM.ayv(2);
          }
          for (;;)
          {
            AppMethodBeat.o(301483);
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
  
  public void dependency()
  {
    AppMethodBeat.i(301522);
    dependsOn(com.tencent.mm.plugin.teenmode.a.c.class);
    AppMethodBeat.o(301522);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5552);
    com.tencent.mm.br.b.bsa("brandservice");
    Log.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.bbA()) || (paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FI(":appbrand")))
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.brandservice.api.c.class, new c());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.brandservice.api.h.class, new e());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.brandservice.api.f.class, new com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.b());
      if (!paramg.bbA()) {
        break label162;
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.init();
      com.tencent.mm.kernel.h.b(com.tencent.mm.api.r.class, com.tencent.mm.model.q.ojI);
    }
    for (;;)
    {
      j.aoW();
      paramg = a.vAp;
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.dbq() });
      AppMethodBeat.o(5552);
      return;
      label162:
      com.tencent.mm.kernel.h.b(com.tencent.mm.api.r.class, new com.tencent.mm.model.r());
    }
  }
  
  public void installed()
  {
    AppMethodBeat.i(5550);
    alias(com.tencent.mm.plugin.brandservice.api.e.class);
    AppMethodBeat.o(5550);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(5553);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.lzk, Looper.getMainLooper());
    com.tencent.mm.an.af.bHl().a(this.vAF, Looper.getMainLooper());
    com.tencent.mm.an.af.bHo().a(this.vAF, Looper.getMainLooper());
    this.appForegroundListener.alive();
    new com.tencent.mm.plugin.brandservice.ui.timeline.c();
    Log.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWJ, Integer.valueOf(0))).intValue();
    if ((i & 0x1) == 0)
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxO("officialaccounts");
      com.tencent.mm.an.af.bHl().iYA();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWJ, Integer.valueOf(i | 0x1));
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.vAG);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.vAK);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("BizNotification", this.vAL);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("BizRecommendExpt", this.vAH);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("BizAdNotify", this.vAI);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("bizlivenotify", this.vAJ);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.lzk);
    com.tencent.mm.an.af.bHl().a(this.vAF);
    com.tencent.mm.an.af.bHo().a(this.vAF);
    this.appForegroundListener.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.vAG);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.vAK);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("BizNotification", this.vAL);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("BizRecommendExpt", this.vAH);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("BizAdNotify", this.vAI);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("bizlivenotify", this.vAJ);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */