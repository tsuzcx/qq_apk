package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mars.Mars;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.c;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.e.a;
import com.tencent.mm.booter.e.b;
import com.tencent.mm.booter.e.c;
import com.tencent.mm.compatible.loader.e.1;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.p.1;
import com.tencent.mm.model.p.2;
import com.tencent.mm.model.p.3;
import com.tencent.mm.model.p.4;
import com.tencent.mm.model.p.5;
import com.tencent.mm.model.p.6;
import com.tencent.mm.model.p.7;
import com.tencent.mm.model.p.8;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.w.a;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.plugin.voip.ui.VoipViewFragment;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.chatting.j.b.1;
import com.tencent.mm.ui.chatting.j.b.2;
import com.tencent.mm.ui.chatting.viewitems.k.a;
import com.tencent.mm.ui.d.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.xwalk.core.XWalkEnvironment;

public class PluginBigBallOfMud
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket
{
  private static final String TAG = "MicroMsg.PluginBigBallOfMud";
  public Application app;
  private final MMAppMgr appMgr;
  private j deleteContactService;
  private com.tencent.mm.compatible.loader.d mProfileCompat;
  
  public PluginBigBallOfMud()
  {
    AppMethodBeat.i(22412);
    this.appMgr = new MMAppMgr();
    this.deleteContactService = new j();
    AppMethodBeat.o(22412);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22414);
    com.tencent.mm.ui.d.a(new d.a()
    {
      public final void c(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(22384);
        com.tencent.mm.plugin.report.e.ygI.f(14976, new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(22384);
      }
    });
    MMReceivers.ToolsProcessReceiver.a(new e.c());
    MMReceivers.ToolsMpProcessReceiver.a(new e.a());
    MMReceivers.SandBoxProcessReceiver.a(new e.b());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new l());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new q());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new g());
    ad.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.ca;
    ad.i("MicroMsg.PluginBigBallOfMud", "app. %s", new Object[] { this.app });
    com.tencent.mm.modelstat.d.h(this.app);
    ad.i("MicroMsg.PluginBigBallOfMud", "ClickFlowStatSender registerActivityLifeCycle");
    long l = System.currentTimeMillis();
    com.tencent.mm.compatible.loader.e locale = new com.tencent.mm.compatible.loader.e();
    localObject1 = this.app;
    Object localObject2 = paramg.mProcessName;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      com.tencent.e.j.a locala = com.tencent.e.j.a.aZF("ProfileFactoryImp_handlerThread");
      localObject2 = (String)new e.1(locale).b(new ap(locala));
      locala.LVC.quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        ad.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.d)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.akw()))
        {
          ad.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        ad.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.f.bk(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.ca.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3612;
        }
      }
      label3612:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          ad.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.mProcessName, Long.valueOf(bt.Df(com.tencent.mm.app.d.cTp)), Long.valueOf(bt.Df(l)), Integer.valueOf(i), com.tencent.mm.storage.al.IpN, com.tencent.mm.loader.j.b.arO() });
          if (paramg.akw()) {
            com.tencent.mm.m.a.a.a(new com.tencent.mm.m.a()
            {
              public final String I(String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(22396);
                if (com.tencent.mm.am.g.vd(paramAnonymousString))
                {
                  paramAnonymousString = com.tencent.mm.am.a.e.Eu(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramAnonymousInt).eLs);
                  AppMethodBeat.o(22396);
                  return paramAnonymousString;
                }
                paramAnonymousString = bl.aCi();
                AppMethodBeat.o(22396);
                return paramAnonymousString;
              }
              
              public final void n(bu paramAnonymousbu)
              {
                AppMethodBeat.i(22395);
                if (com.tencent.mm.am.g.vd(paramAnonymousbu.field_talker))
                {
                  paramAnonymousbu.sP(com.tencent.mm.am.a.e.VW());
                  AppMethodBeat.o(22395);
                  return;
                }
                paramAnonymousbu.sP(bl.aCi());
                AppMethodBeat.o(22395);
              }
              
              public final String o(bu paramAnonymousbu)
              {
                AppMethodBeat.i(22397);
                if (com.tencent.mm.am.g.vd(paramAnonymousbu.field_talker))
                {
                  paramAnonymousbu = com.tencent.mm.am.a.e.Eu(paramAnonymousbu.eLs);
                  AppMethodBeat.o(22397);
                  return paramAnonymousbu;
                }
                paramAnonymousbu = bl.aCi();
                AppMethodBeat.o(22397);
                return paramAnonymousbu;
              }
              
              public final boolean vd(String paramAnonymousString)
              {
                AppMethodBeat.i(22398);
                boolean bool = com.tencent.mm.am.g.vd(paramAnonymousString);
                AppMethodBeat.o(22398);
                return bool;
              }
            });
          }
          com.tencent.mm.compatible.c.a.a(new com.tencent.mm.compatible.c.a.a()
          {
            public final void u(long paramAnonymousLong1, long paramAnonymousLong2)
            {
              AppMethodBeat.i(22402);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(paramAnonymousLong1, paramAnonymousLong2, 1L, false);
              AppMethodBeat.o(22402);
            }
          });
          com.tencent.mm.sdk.platformtools.a.a(new com.tencent.mm.sdk.platformtools.a.a()
          {
            public final void L(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22404);
              com.tencent.mm.ui.base.b.bi(paramAnonymousActivity);
              AppMethodBeat.o(22404);
            }
            
            public final boolean M(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22405);
              boolean bool = com.tencent.mm.ui.base.b.bf(paramAnonymousActivity.getClass());
              AppMethodBeat.o(22405);
              return bool;
            }
            
            public final void yT(int paramAnonymousInt)
            {
              AppMethodBeat.i(22403);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(1221L, paramAnonymousInt, 1L, false);
              AppMethodBeat.o(22403);
            }
          });
          if (paramg.akw())
          {
            com.tencent.mm.modelfriend.a.hWS = new com.tencent.mm.modelfriend.a.a()
            {
              public final String aHL()
              {
                AppMethodBeat.i(22406);
                if (com.tencent.mm.sdk.platformtools.j.IcA)
                {
                  str = aj.getContext().getString(2131762749);
                  AppMethodBeat.o(22406);
                  return str;
                }
                String str = aj.getContext().getString(2131762748);
                AppMethodBeat.o(22406);
                return str;
              }
            };
            com.tencent.mm.storagebase.f.a(new PluginBigBallOfMud.27(this));
            com.tencent.mm.storage.e.InI = new com.tencent.mm.plugin.messenger.foundation.a.n()
            {
              public final String ac(bu paramAnonymousbu)
              {
                AppMethodBeat.i(22409);
                int i;
                if ((paramAnonymousbu.field_bizChatId != -1L) && (com.tencent.mm.am.g.vd(paramAnonymousbu.field_talker)))
                {
                  i = 1;
                  if (i == 0) {
                    break label91;
                  }
                  paramAnonymousbu = paramAnonymousbu.field_talker + ":" + paramAnonymousbu.field_bizChatId;
                  ad.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { paramAnonymousbu });
                }
                for (;;)
                {
                  AppMethodBeat.o(22409);
                  return paramAnonymousbu;
                  i = 0;
                  break;
                  label91:
                  paramAnonymousbu = paramAnonymousbu.field_talker;
                }
              }
            };
            com.tencent.mm.model.x.a(new x.a()
            {
              public final boolean a(String paramAnonymousString1, String paramAnonymousString2, PInt paramAnonymousPInt)
              {
                AppMethodBeat.i(22410);
                if (w.zE(paramAnonymousString1))
                {
                  if (com.tencent.mm.am.g.vd(paramAnonymousString1)) {
                    if (com.tencent.mm.am.a.e.Eq(paramAnonymousString2)) {
                      paramAnonymousPInt.value = 5;
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(22410);
                    return true;
                    paramAnonymousPInt.value = 4;
                    continue;
                    if (com.tencent.mm.am.g.DP(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 3;
                    } else if (com.tencent.mm.am.g.DQ(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 0;
                    } else if (com.tencent.mm.am.g.DL(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 6;
                    } else {
                      paramAnonymousPInt.value = 7;
                    }
                  }
                }
                AppMethodBeat.o(22410);
                return false;
              }
            });
            aa.b(new com.tencent.mm.cn.c() {});
            paramg = new com.tencent.mm.modelmulti.a();
            w.a.a(69, paramg);
            w.a.a(68, paramg);
            w.a.a(22, paramg);
            w.a.a(13, paramg);
            w.a.a(15, paramg);
            w.a.a(23, paramg);
            w.a.a(25, paramg);
            w.a.a(24, paramg);
            w.a.a(33, paramg);
            w.a.a(35, paramg);
            w.a.a(44, paramg);
            w.a.a(999999, paramg);
            w.a.a(53, paramg);
            w.a.a(204, paramg);
            w.a.a(219, paramg);
            paramg = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.e.class)).addContactAssembler(paramg);
            com.tencent.mm.kernel.g.aiU().a(681, paramg);
            com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.h.a.class, this.deleteContactService);
            aa.a(5, new n());
            aa.a(1, new t());
            aa.a(4, new i());
            ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new a());
            paramg = new o();
            ((v)com.tencent.mm.kernel.g.ab(v.class)).a(paramg);
            ((v)com.tencent.mm.kernel.g.ab(v.class)).a(paramg);
            ((v)com.tencent.mm.kernel.g.ab(v.class)).a(new h());
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new s().alive();
            com.tencent.mm.kernel.g.aiU().b(138, p.nOI);
            com.tencent.mm.kernel.g.aiU().b(39, p.nOI);
            com.tencent.mm.kernel.g.aiU().b(268369922, p.nOI);
            if (p.nOI == null) {
              p.nOI = new p();
            }
            com.tencent.mm.kernel.g.aiU().a(138, p.nOI);
            com.tencent.mm.kernel.g.aiU().a(39, p.nOI);
            com.tencent.mm.kernel.g.aiU().a(268369922, p.nOI);
            r.en(this.app);
            com.tencent.mm.ba.a.a.a("delchatroommember", new p.1());
            com.tencent.mm.ba.a.a.a("NewXmlChatRoomAccessVerifyApplication", new p.2());
            com.tencent.mm.ba.a.a.a("NewXmlChatRoomAccessVerifyApproval", new p.3());
            com.tencent.mm.ba.a.a.a("chatroommuteexpt", new p.4());
            com.tencent.mm.ba.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new p.5());
            com.tencent.mm.ba.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new p.6());
            com.tencent.mm.ba.a.a.a("FinderPersonalMsgSysMsg", new p.7());
            ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new p.8());
            com.tencent.mm.ba.a.a.a("invokeMessage", new b.1());
            com.tencent.mm.ba.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new b.2());
            bs.aAd();
            com.tencent.mm.model.n.aAd();
            paramg = this.appMgr;
            localObject1 = this.app;
            if (paramg.Jcj == null) {
              paramg.Jcj = new MMAppMgr.Receiver(paramg);
            }
            MMActivity.setMainProcess();
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject2).addAction("MINIQB_OPEN_RET");
            ((Context)localObject1).registerReceiver(paramg.Jcj, (IntentFilter)localObject2, "com.tencent.mm.permission.MM_MESSAGE", null);
            paramg = new com.tencent.mm.booter.x(com.tencent.mm.booter.d.bJ(this.app));
            paramg.uc("MM");
            ac.iOT = bt.a(paramg.ud(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            ac.iOb = bt.a(paramg.ud(".com.tencent.mm.debug.test.display_errcode"), false);
            ac.iOc = bt.a(paramg.ud(".com.tencent.mm.debug.test.display_msgstate"), false);
            ac.iOd = bt.a(paramg.ud(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            ac.iOe = bt.a(paramg.ud(".com.tencent.mm.debug.test.network.force_touch"), false);
            ac.iOf = bt.a(paramg.ud(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            ac.iOg = bt.a(paramg.ud(".com.tencent.mm.debug.test.crashIsExit"), false);
            ac.iOF = bt.getInt(bt.bI(paramg.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            ac.iOG = bt.getInt(bt.bI(paramg.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            ac.iOi = bt.a(paramg.ud(".com.tencent.mm.debug.test.album_drop_table"), false);
            ac.iOj = bt.a(paramg.ud(".com.tencent.mm.debug.test.album_dle_file"), false);
            ac.iOk = bt.a(paramg.ud(".com.tencent.mm.debug.test.album_show_info"), false);
            ac.iOl = bt.a(paramg.ud(".com.tencent.mm.debug.test.location_help"), false);
            ac.iOo = bt.a(paramg.ud(".com.tencent.mm.debug.test.force_soso"), false);
            ac.iOp = bt.a(paramg.ud(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            ac.iOq = bt.a(paramg.ud(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            ac.iOr = bt.a(paramg.ud(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            ac.iOu = bt.a(paramg.ud(".com.tencent.mm.debug.test.filterfpnp"), false);
            ac.iOv = bt.a(paramg.ud(".com.tencent.mm.debug.test.testForPull"), false);
            i = bt.a(paramg.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            ac.iOs = i;
            if ((i != 4) && (ac.iOs > 0))
            {
              com.tencent.mm.storage.ak.IpL = ac.iOs;
              ad.e("MicroMsg.WorkerDebugger", "cdn thread num " + ac.iOs);
            }
            ac.iOt = bt.a(paramg.ud(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            ac.iOw = bt.bI(paramg.getString(".com.tencent.mm.debug.server.host.http"), "");
            ac.iOx = bt.bI(paramg.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bt.a(paramg.ud(".com.tencent.mm.debug.test.show_full_version"), false)) {
              com.tencent.mm.sdk.platformtools.j.Icx = true;
            }
          }
          try
          {
            i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.ZA(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception paramg)
          {
            try
            {
              localObject1 = paramg.getString(".com.tencent.mm.debug.log.setapilevel");
              if (!bt.isNullOrNil((String)localObject1))
              {
                com.tencent.mm.protocal.d.hgH = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.Fnf = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.Fnh = String.valueOf(localObject1);
                com.tencent.mm.sdk.a.b.aPX((String)localObject1);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hgH).append(" ").append(com.tencent.mm.sdk.a.b.fjO());
              }
            }
            catch (Exception paramg)
            {
              try
              {
                l = Long.decode(paramg.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(l);
                com.tencent.mm.protocal.d.Fni = l;
              }
              catch (Exception paramg)
              {
                try
                {
                  i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  paramg.fFy.fEd = i;
                }
                catch (Exception paramg)
                {
                  try
                  {
                    boolean bool1 = bt.a(paramg.ud(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = bt.a(paramg.ud(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = bt.a(paramg.ud(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = bt.a(paramg.ud(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    ac.iOA = bt.a(paramg.ud(".com.tencent.mm.debug.test.update_test"), false);
                    ac.iOB = bt.a(paramg.ud(".com.tencent.mm.debug.test.scan_save_image"), false);
                    ac.iOD = bt.a(paramg.ud(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    ac.iOE = bt.a(paramg.ud(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    ac.iOI = bt.bI(paramg.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    ad.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + ac.iOI);
                    ac.iOX = bt.bI(paramg.getString(".com.tencent.mm.debug.cdn.front"), "");
                    ac.iOY = bt.bI(paramg.getString(".com.tencent.mm.debug.cdn.zone"), "");
                    ac.iOZ = bt.bI(paramg.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    ac.iPa = bt.bI(paramg.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    ac.iPb = bt.bI(paramg.getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    ac.iPc = bt.a(paramg.ud(".com.tencent.mm.debug.cdn.usestream"), false);
                    ac.iPd = bt.a(paramg.ud(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    ac.iPe = bt.a(paramg.ud(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    ac.iPg = bt.a(paramg.ud(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    ac.iPh = bt.a(paramg.ud(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    ac.iPi = bt.a(paramg.ud(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    ac.iPq = bt.a(paramg.ud(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    ad.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + ac.iPq);
                    ac.iPr = bt.bI(paramg.getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    ac.iPs = bt.getInt(bt.bI(paramg.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    ac.iPn = bt.a(paramg.ud(".com.tencent.mm.debug.cursormode_enabled"), true);
                    ac.iPY = bt.a(paramg.ud(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    ac.iPZ = bt.a(paramg.ud(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    ac.iQa = bt.a(paramg.ud(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    ac.iPH = bt.a(paramg.ud(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    ac.iPJ = bt.bI(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    ac.iPI = bt.a(paramg.ud(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    ac.iPK = bt.bI(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    ac.iPR = bt.a(paramg.ud(".com.tencent.mm.debug.netmock"), false);
                    paramg = bt.jm(aj.getContext());
                    if ((paramg != null) && (paramg.getPackageName().equals(aj.getPackageName())) && (paramg.getClassName().equals(aj.fkA())))
                    {
                      WorkerProfile.MZ().cVP = true;
                      WorkerProfile.MZ().cVQ = true;
                      ad.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                      com.tencent.mm.model.d.b.aDy();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(aj.getContext()));
                      SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.i());
                      com.tencent.mm.plugin.report.service.i.yiw = (WorkerProfile)this.mProfileCompat;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.vr("wechatbase");
                      paramg = com.tencent.mm.sdk.a.IbC;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.vr(paramg);
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.vr("wechatmm");
                    }
                  }
                  catch (Exception paramg)
                  {
                    try
                    {
                      Mars.onCreate();
                      if (aj.cmR()) {
                        SmcLogic.onCreate();
                      }
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.ygP);
                      if (getClass().getClassLoader() == null)
                      {
                        i = -1;
                        if (Thread.currentThread().getContextClassLoader() != null) {
                          break label3582;
                        }
                        j = -1;
                        ad.i("MicroMsg.PluginBigBallOfMud", "SmcLogic, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                      }
                    }
                    catch (Throwable paramg)
                    {
                      try
                      {
                        for (;;)
                        {
                          if (com.tencent.mm.compatible.util.d.lz(20))
                          {
                            ad.i("MicroMsg.PluginBigBallOfMud", "weird");
                            SmcLogic.setUin(0L);
                          }
                          paramg = (com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class);
                          localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
                          new com.tencent.mm.plugin.e.d().after(paramg).before(this);
                          localObject2 = (com.tencent.mm.plugin.e.b)new com.tencent.mm.plugin.e.b().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.f().after((com.tencent.mm.kernel.b.a)localObject2).before(this);
                          new com.tencent.mm.plugin.e.c().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.a().after((com.tencent.mm.kernel.b.a)localObject1);
                          com.tencent.mm.bs.d.ffG();
                          com.tencent.mm.ui.chatting.g.a.deP();
                          m.a(new com.tencent.mm.pluginsdk.j.a.a.a.a()
                          {
                            public final boolean yS(int paramAnonymousInt)
                            {
                              AppMethodBeat.i(22385);
                              if ((paramAnonymousInt == 39) && (!com.tencent.mm.plugin.ipcall.d.ddk()))
                              {
                                AppMethodBeat.o(22385);
                                return true;
                              }
                              AppMethodBeat.o(22385);
                              return false;
                            }
                          });
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          k.c.a(new com.tencent.mm.cn.c() {});
                          com.tencent.mm.sdk.b.a.IbL.c(new com.tencent.mm.sdk.b.c() {});
                          AppMethodBeat.o(22414);
                          return;
                          if (((String)localObject2).equals(aj.getPackageName())) {
                            localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.WorkerProfile");
                          }
                          for (;;)
                          {
                            ad.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                            break;
                            if (((String)localObject2).equals(aj.getPackageName() + ":push"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.PusherProfile");
                            }
                            else if (((String)localObject2).startsWith(aj.getPackageName() + ":tools"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.ToolsProfile");
                            }
                            else if (((String)localObject2).equals(aj.getPackageName() + ":sandbox"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.SandBoxProfile");
                            }
                            else if (((String)localObject2).equals(aj.getPackageName() + ":exdevice"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.ExDeviceProfile");
                            }
                            else if (((String)localObject2).equals(aj.getPackageName() + ":TMAssistantDownloadSDKService"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.TMAssistantProfile");
                            }
                            else if (((String)localObject2).equals(aj.getPackageName() + ":nospace"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.NoSpaceProfile");
                            }
                            else if (((String)localObject2).equals(aj.getPackageName() + ":patch"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.PatchProfile");
                            }
                            else if (((String)localObject2).startsWith(aj.getPackageName() + ":appbrand"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.AppBrandProfile");
                            }
                            else if (((String)localObject2).startsWith(aj.getPackageName() + ":support"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.SupportProfile");
                            }
                            else
                            {
                              if (!((String)localObject2).startsWith(aj.getPackageName() + ":lite")) {
                                break label3408;
                              }
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.LiteAppProfile");
                            }
                          }
                          label3408:
                          localObject1 = null;
                          break;
                          localException1 = localException1;
                          ad.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException2 = localException2;
                          ad.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException3 = localException3;
                          ad.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException4 = localException4;
                          ad.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException5 = localException5;
                          ad.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          if (paramg != null) {
                            ad.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                          }
                          while ((paramg != null) && (!paramg.getPackageName().equals(aj.getPackageName())))
                          {
                            WorkerProfile.MZ().cVP = true;
                            break;
                            ad.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
                          }
                          paramg = paramg;
                          Mars.onCreate();
                          if (aj.cmR())
                          {
                            SmcLogic.onCreate();
                            continue;
                            i = getClass().getClassLoader().hashCode();
                          }
                        }
                        label3582:
                        int j = Thread.currentThread().getContextClassLoader().hashCode();
                      }
                      catch (Throwable paramg)
                      {
                        for (;;)
                        {
                          ad.printErrStackTrace("MicroMsg.PluginBigBallOfMud", paramg, "", new Object[0]);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22413);
    if (aj.cmR())
    {
      dependsOn(com.tencent.mm.plugin.auth.a.b.class);
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.r.class);
    }
    AppMethodBeat.o(22413);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(22416);
    if ((com.tencent.mm.ui.al.fxZ()) && (com.tencent.mm.ui.al.fxT()))
    {
      XWalkEnvironment.setForceDarkMode(com.tencent.mm.ui.al.i(paramConfiguration));
      MMWebView.yK(com.tencent.mm.ui.al.i(paramConfiguration));
      if (aj.cmR())
      {
        if (com.tencent.mm.cd.c.h(paramConfiguration))
        {
          ad.i("MicroMsg.PluginBigBallOfMud", "dancy test uiModeChange true, uimode:%s", new Object[] { Integer.valueOf(paramConfiguration.uiMode) });
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          com.tencent.mm.modelappbrand.a.b.aDV().clearCache();
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null)
          {
            ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).onAccountRelease();
            ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).bJV();
            if (com.tencent.mm.kernel.g.ajA().aiK())
            {
              localObject = com.tencent.mm.plugin.voip.c.euN();
              if (((com.tencent.mm.plugin.voip.ui.d)localObject).CjA != null)
              {
                localObject = ((com.tencent.mm.plugin.voip.ui.d)localObject).CjA;
                BaseSmallView localBaseSmallView = ((VoipViewFragment)localObject).Cki;
                if (localBaseSmallView != null) {
                  localBaseSmallView.ezk();
                }
                localObject = ((VoipViewFragment)localObject).Ckh;
                if (localObject != null) {
                  ((BaseSmallView)localObject).ezk();
                }
              }
            }
          }
        }
        com.tencent.mm.cd.c.a(paramConfiguration, com.tencent.mm.ui.al.isDarkMode());
        if (aj.getContext().getResources() != null) {
          aj.getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
        }
      }
    }
    Object localObject = aj.getResources();
    if ((localObject instanceof com.tencent.mm.cd.b)) {
      ((com.tencent.mm.cd.b)localObject).onConfigurationChanged(paramConfiguration);
    }
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(22416);
  }
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate()
  {
    AppMethodBeat.i(22415);
    ad.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { aj.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.Jcj != null) {
      localApplication.unregisterReceiver(localMMAppMgr.Jcj);
    }
    AppMethodBeat.o(22415);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(22417);
    ad.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), aj.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
    Object localObject = com.tencent.mm.memory.a.a.b.ayP();
    ad.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).hwL.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).ayQ();
    }
    AppMethodBeat.o(22417);
  }
  
  public String toString()
  {
    return "plugin-big-ball-of-mud";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud
 * JD-Core Version:    0.7.0.1
 */