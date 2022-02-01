package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.aq;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;

public class PluginBrandService
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.e
{
  private o.a appForegroundListener;
  private i.a iXh;
  private aa.c soO;
  private t soP;
  private t soQ;
  private t soR;
  private t soS;
  private t soT;
  private t soU;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(5549);
    this.iXh = new PluginBrandService.7(this);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(258168);
        paramAnonymousString = com.tencent.mm.storage.r.VcW;
        com.tencent.mm.storage.r.hvY();
        AppMethodBeat.o(258168);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        boolean bool2 = false;
        AppMethodBeat.i(258167);
        paramAnonymousString = com.tencent.mm.storage.r.VcW;
        com.tencent.mm.storage.r.hvZ();
        paramAnonymousString = com.tencent.mm.pluginsdk.c.QRw;
        if (com.tencent.mm.pluginsdk.c.hfA())
        {
          paramAnonymousString = com.tencent.mm.pluginsdk.c.QRw;
          if (com.tencent.mm.pluginsdk.c.hfB()) {
            break label78;
          }
          bool1 = false;
          if (bool1) {
            com.tencent.mm.pluginsdk.c.QRw.hfE();
          }
        }
        paramAnonymousString = ad.Vfe;
        if (BuildInfo.DEBUG) {
          bool1 = true;
        }
        for (;;)
        {
          if (bool1)
          {
            paramAnonymousString = ad.Vfe;
            ad.a(1, null, 0L);
          }
          AppMethodBeat.o(258167);
          return;
          label78:
          bool1 = com.tencent.mm.pluginsdk.c.bcJ().getBoolean("biz_time_preload_at_foreground", false);
          Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool1) });
          break;
          bool1 = bool2;
          if (ad.hxt())
          {
            if (ad.Vfc == null) {
              break label142;
            }
            paramAnonymousString = ad.Vfc;
            if (paramAnonymousString == null) {
              p.iCn();
            }
            bool1 = paramAnonymousString.booleanValue();
          }
        }
        label142:
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAt, 0) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ad.Vfc = Boolean.valueOf(bool1);
          Log.i("MicroMsg.BizTimeLineResortLogic", "isForeGroundBizMsgResortOpen open %b", new Object[] { ad.Vfc });
          paramAnonymousString = ad.Vfc;
          if (paramAnonymousString == null) {
            p.iCn();
          }
          bool1 = paramAnonymousString.booleanValue();
          break;
        }
      }
    };
    this.soO = new aa.c()
    {
      public final void a(Object paramAnonymousObject, aa.a paramAnonymousa)
      {
        AppMethodBeat.i(265697);
        b.a("UpdateBizMainCellThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5543);
            com.tencent.mm.storage.ab.hxj();
            AppMethodBeat.o(5543);
          }
        }, 0L);
        AppMethodBeat.o(265697);
      }
    };
    this.soP = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(5546);
        b.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5545);
            com.tencent.mm.storage.ab.c(paramAnonymousMap, paramAnonymousa);
            AppMethodBeat.o(5545);
          }
        });
        AppMethodBeat.o(5546);
      }
    };
    this.soQ = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(5548);
        b.am(new PluginBrandService.11.1(this, paramAnonymousa, paramAnonymousMap));
        AppMethodBeat.o(5548);
      }
    };
    this.soR = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(258898);
        b.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266107);
            if ((paramAnonymousa != null) && (paramAnonymousa.jQG != null) && (paramAnonymousa.jQG.RIF != null))
            {
              com.tencent.mm.storage.r localr = com.tencent.mm.storage.r.VcW;
              com.tencent.mm.storage.r.ad(paramAnonymousMap, z.a(paramAnonymousa.jQG.RIF));
            }
            AppMethodBeat.o(266107);
          }
        });
        AppMethodBeat.o(258898);
      }
    };
    this.soS = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(266538);
        b.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266138);
            if ((paramAnonymousa != null) && (paramAnonymousa.jQG != null) && (paramAnonymousa.jQG.RIF != null) && (Util.getInt((String)paramAnonymousMap.get(".sysmsg.bizlivenotify.op_flag"), 1) == 1))
            {
              Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.cBq();
              if ((localObject == null) || (Util.isNullOrNil(((err)localObject).UtH)))
              {
                AppMethodBeat.o(266138);
                return;
              }
              localObject = ((err)localObject).UtH;
              com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
              com.tencent.mm.pluginsdk.model.b.cd((LinkedList)localObject);
            }
            AppMethodBeat.o(266138);
          }
        });
        AppMethodBeat.o(266538);
      }
    };
    this.soT = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(266757);
        b.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5538);
            com.tencent.mm.plugin.brandservice.b.b.svR.U(paramAnonymousMap);
            AppMethodBeat.o(5538);
          }
        });
        AppMethodBeat.o(266757);
      }
    };
    this.soU = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(266837);
        b.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(267007);
            Object localObject = com.tencent.mm.plugin.biz.b.b.shr;
            Map localMap = paramAnonymousMap;
            h.a locala = paramAnonymousa;
            if (locala != null) {}
            for (localObject = locala.jQG; (localObject == null) || (locala.jQG.RIF == null) || (localMap == null); localObject = null)
            {
              Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
              AppMethodBeat.o(267007);
              return;
            }
            com.tencent.mm.plugin.biz.b.b.g(localMap, z.a(locala.jQG.RIF));
            AppMethodBeat.o(267007);
          }
        });
        AppMethodBeat.o(266837);
      }
    };
    AppMethodBeat.o(5549);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(5555);
    EventCenter.instance.addListener(new PluginBrandService.5(this));
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
    AppMethodBeat.i(259112);
    Log.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
    com.tencent.mm.vfs.ab.a("WebPrefetchContent", "webprefetch/content", 86400000L, 70);
    com.tencent.mm.vfs.ab.a("WebPrefetchManifest", "webprefetch/manifest", 604800000L, 70);
    com.tencent.mm.vfs.ab.a("WebPrefetchResource", "webprefetch/resource", 604800000L, 70);
    com.tencent.mm.vfs.ab.a("webview_tmpl", "webview_tmpl", 536870912L, 259200000L, 518);
    AppMethodBeat.o(259112);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5551);
    Log.i("MicroMsg.PluginBrandService", "configure");
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.aIE())
    {
      registerVFS();
      pin(new y(e.class));
      ((v)h.ag(v.class)).setBizTimeLineCallback(new d()
      {
        public final boolean aD(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(266316);
          Log.i("MicroMsg.PluginBrandService", "testInsertBizAd %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 1) {
            com.tencent.mm.storage.r.VcW.ask(2);
          }
          for (;;)
          {
            AppMethodBeat.o(266316);
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
    AppMethodBeat.i(259109);
    dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    AppMethodBeat.o(259109);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5552);
    com.tencent.mm.by.b.bsj("brandservice");
    Log.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + paramg.mProcessName);
    if ((paramg.aIE()) || (paramg.MY(":tools")) || (paramg.MY(":toolsmp")) || (paramg.MZ(":appbrand")))
    {
      h.b(com.tencent.mm.plugin.brandservice.a.c.class, new c());
      h.b(com.tencent.mm.plugin.brandservice.a.f.class, new f());
      if (!paramg.aIE()) {
        break label147;
      }
      h.b(com.tencent.mm.api.q.class, com.tencent.mm.model.q.lsl);
    }
    for (;;)
    {
      j.OO();
      paramg = a.sos;
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.cyx() });
      AppMethodBeat.o(5552);
      return;
      label147:
      h.b(com.tencent.mm.api.q.class, new com.tencent.mm.model.r());
    }
  }
  
  public void installed()
  {
    AppMethodBeat.i(5550);
    alias(com.tencent.mm.plugin.brandservice.a.e.class);
    AppMethodBeat.o(5550);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(5553);
    ((n)h.ae(n.class)).eSe().a(this.iXh, Looper.getMainLooper());
    af.bjB().a(this.soO, Looper.getMainLooper());
    af.bjD().a(this.soO, Looper.getMainLooper());
    this.appForegroundListener.alive();
    new com.tencent.mm.plugin.brandservice.ui.timeline.c();
    Log.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vva, Integer.valueOf(0))).intValue();
    if ((i & 0x1) == 0)
    {
      ((n)h.ae(n.class)).bbR().bwz("officialaccounts");
      af.bjB().hwY();
      h.aHG().aHp().set(ar.a.Vva, Integer.valueOf(i | 0x1));
    }
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.soP);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.soT);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("BizNotification", this.soU);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("BizRecommendExpt", this.soQ);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("BizAdNotify", this.soR);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("bizlivenotify", this.soS);
    AppMethodBeat.o(5553);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5554);
    ((n)h.ae(n.class)).eSe().a(this.iXh);
    af.bjB().a(this.soO);
    af.bjD().a(this.soO);
    this.appForegroundListener.dead();
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.soP);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.soT);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("BizNotification", this.soU);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("BizRecommendExpt", this.soQ);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("BizAdNotify", this.soR);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("bizlivenotify", this.soS);
    AppMethodBeat.o(5554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */