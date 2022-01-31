package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.c;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.e.a;
import com.tencent.mm.booter.e.b;
import com.tencent.mm.booter.e.c;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.loader.f.1;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.m.1;
import com.tencent.mm.model.m.2;
import com.tencent.mm.model.m.3;
import com.tencent.mm.model.m.4;
import com.tencent.mm.model.m.5;
import com.tencent.mm.model.m.6;
import com.tencent.mm.model.m.7;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.chatting.h.b.1;
import com.tencent.mm.ui.chatting.h.b.2;
import com.tencent.mm.ui.chatting.viewitems.j.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class PluginBigBallOfMud
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket
{
  private static final String TAG = "MicroMsg.PluginBigBallOfMud";
  public Application app;
  private final MMAppMgr appMgr;
  private com.tencent.mm.compatible.loader.e mProfileCompat;
  
  public PluginBigBallOfMud()
  {
    AppMethodBeat.i(18300);
    this.appMgr = new MMAppMgr();
    AppMethodBeat.o(18300);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(18302);
    com.tencent.mm.ui.d.a(new PluginBigBallOfMud.1(this));
    MMReceivers.ToolsProcessReceiver.a(new e.c());
    MMReceivers.ToolsMpProcessReceiver.a(new e.a());
    MMReceivers.SandBoxProcessReceiver.a(new e.b());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new j());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new o());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new g());
    ab.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.bX;
    com.tencent.mm.modelstat.d.d(this.app);
    long l = System.currentTimeMillis();
    com.tencent.mm.compatible.loader.f localf = new com.tencent.mm.compatible.loader.f();
    localObject1 = this.app;
    Object localObject2 = paramg.mProcessName;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      HandlerThread localHandlerThread = com.tencent.mm.sdk.g.d.aqu("ProfileFactoryImp_handlerThread");
      localHandlerThread.start();
      localObject2 = (String)new f.1(localf).b(new ak(localHandlerThread.getLooper()));
      localHandlerThread.getLooper().quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        ab.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.e)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.SD()))
        {
          ab.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        ab.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.d.aY(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.bX.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3329;
        }
      }
      label3329:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          ab.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.mProcessName, Long.valueOf(com.tencent.mm.sdk.platformtools.bo.hl(com.tencent.mm.app.b.bXE)), Long.valueOf(com.tencent.mm.sdk.platformtools.bo.hl(l)), Integer.valueOf(i), ac.eQv, com.tencent.mm.compatible.util.e.eQx });
          com.tencent.mm.l.a.a.a(new PluginBigBallOfMud.12(this));
          com.tencent.mm.compatible.d.a.a(new PluginBigBallOfMud.13(this));
          if (paramg.SD())
          {
            com.tencent.mm.modelfriend.a.fBk = new PluginBigBallOfMud.14(this);
            com.tencent.mm.cg.f.a(new PluginBigBallOfMud.15(this));
            com.tencent.mm.storage.e.yww = new PluginBigBallOfMud.16(this);
            u.a(new PluginBigBallOfMud.17(this));
            v.b(new PluginBigBallOfMud.18(this));
            paramg = new com.tencent.mm.modelmulti.a();
            r.a.a(69, paramg);
            r.a.a(68, paramg);
            r.a.a(22, paramg);
            r.a.a(13, paramg);
            r.a.a(15, paramg);
            r.a.a(23, paramg);
            r.a.a(25, paramg);
            r.a.a(24, paramg);
            r.a.a(33, paramg);
            r.a.a(35, paramg);
            r.a.a(44, paramg);
            r.a.a(999999, paramg);
            r.a.a(53, paramg);
            r.a.a(204, paramg);
            paramg = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(paramg);
            com.tencent.mm.kernel.g.Rc().a(681, paramg);
            v.a(5, new l());
            v.a(1, new r());
            v.a(4, new h());
            ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new a());
            paramg = new m();
            ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.q.class)).a(paramg);
            ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.q.class)).a(paramg);
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new q().alive();
            com.tencent.mm.kernel.g.Rc().b(138, n.jMI);
            com.tencent.mm.kernel.g.Rc().b(39, n.jMI);
            com.tencent.mm.kernel.g.Rc().b(268369922, n.jMI);
            if (n.jMI == null) {
              n.jMI = new n();
            }
            com.tencent.mm.kernel.g.Rc().a(138, n.jMI);
            com.tencent.mm.kernel.g.Rc().a(39, n.jMI);
            com.tencent.mm.kernel.g.Rc().a(268369922, n.jMI);
            p.cT(this.app);
            com.tencent.mm.ay.a.a.a("delchatroommember", new m.1());
            com.tencent.mm.ay.a.a.a("NewXmlChatRoomAccessVerifyApplication", new m.2());
            com.tencent.mm.ay.a.a.a("NewXmlChatRoomAccessVerifyApproval", new m.3());
            com.tencent.mm.ay.a.a.a("chatroommuteexpt", new m.4());
            com.tencent.mm.ay.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new m.5());
            com.tencent.mm.ay.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new m.6());
            ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new m.7());
            com.tencent.mm.ay.a.a.a("invokeMessage", new b.1());
            com.tencent.mm.ay.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new b.2());
            com.tencent.mm.model.bo.Zi();
            com.tencent.mm.model.k.Zi();
            paramg = this.appMgr;
            localObject1 = this.app;
            if (paramg.zbM == null) {
              paramg.zbM = new MMAppMgr.Receiver(paramg);
            }
            MMActivity.setMainProcess();
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject2).addAction("MINIQB_OPEN_RET");
            ((Context)localObject1).registerReceiver(paramg.zbM, (IntentFilter)localObject2, "com.tencent.mm.permission.MM_MESSAGE", null);
            paramg = new w(com.tencent.mm.booter.d.bt(this.app));
            paramg.kt("MM");
            ae.gkQ = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            ae.gjY = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.display_errcode"), false);
            ae.gjZ = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.display_msgstate"), false);
            ae.gka = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            ae.gkb = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.network.force_touch"), false);
            ae.gkc = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            ae.gkd = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.crashIsExit"), false);
            ae.gkC = com.tencent.mm.sdk.platformtools.bo.getInt(com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            ae.gkD = com.tencent.mm.sdk.platformtools.bo.getInt(com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            ae.gkf = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.album_drop_table"), false);
            ae.gkg = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.album_dle_file"), false);
            ae.gkh = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.album_show_info"), false);
            ae.gki = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.location_help"), false);
            ae.gkl = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.force_soso"), false);
            ae.gkm = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            ae.gkn = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            ae.gko = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            ae.gkr = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.filterfpnp"), false);
            ae.gks = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.testForPull"), false);
            i = com.tencent.mm.sdk.platformtools.bo.a(paramg.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            ae.gkp = i;
            if ((i != 4) && (ae.gkp > 0))
            {
              com.tencent.mm.storage.ab.yxm = ae.gkp;
              ab.e("MicroMsg.WorkerDebugger", "cdn thread num " + ae.gkp);
            }
            ae.gkq = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            ae.gkt = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.server.host.http"), "");
            ae.gku = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.show_full_version"), false)) {
              com.tencent.mm.sdk.platformtools.g.ymL = true;
            }
          }
          try
          {
            i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.MA(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception paramg)
          {
            try
            {
              localObject1 = paramg.getString(".com.tencent.mm.debug.log.setapilevel");
              if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String)localObject1))
              {
                com.tencent.mm.protocal.d.eQs = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.whD = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.whF = String.valueOf(localObject1);
                com.tencent.mm.sdk.a.b.aoP((String)localObject1);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eQs).append(" ").append(com.tencent.mm.sdk.a.b.dsg());
              }
            }
            catch (Exception paramg)
            {
              try
              {
                l = Long.decode(paramg.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.whG).append(" new: ").append(l);
                com.tencent.mm.protocal.d.whG = l;
              }
              catch (Exception paramg)
              {
                try
                {
                  i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  paramg.dZN.dYP = i;
                }
                catch (Exception paramg)
                {
                  try
                  {
                    boolean bool1 = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.c(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    ae.gkx = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.update_test"), false);
                    ae.gky = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.scan_save_image"), false);
                    ae.gkA = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    ae.gkB = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    ae.gkF = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    ab.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + ae.gkF);
                    ae.gkU = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.cdn.front"), "");
                    ae.gkV = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.cdn.zone"), "");
                    ae.gkW = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    ae.gkX = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    ae.gkY = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    ae.gkZ = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cdn.usestream"), false);
                    ae.gla = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    ae.glb = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    ae.gld = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    ae.gle = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    ae.glf = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    ae.gll = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    ab.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + ae.gll);
                    ae.glm = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    ae.gln = com.tencent.mm.sdk.platformtools.bo.getInt(com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    ae.gli = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.cursormode_enabled"), true);
                    ae.glO = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    ae.glP = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    ae.glQ = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    ae.gly = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    ae.glA = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    ae.glz = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    ae.glB = com.tencent.mm.sdk.platformtools.bo.bf(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    ae.glI = com.tencent.mm.sdk.platformtools.bo.a(paramg.ku(".com.tencent.mm.debug.netmock"), false);
                    paramg = com.tencent.mm.sdk.platformtools.bo.hn(ah.getContext());
                    if ((paramg != null) && (paramg.getPackageName().equals(ah.getPackageName())) && (paramg.getClassName().equals(ah.dsN())))
                    {
                      WorkerProfile.BW().bZE = true;
                      WorkerProfile.BW().bZF = true;
                      ab.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                      com.tencent.mm.model.d.b.acd();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(ah.getContext()));
                      SmcLogic.setCallBack(new i());
                      i.qtk = (WorkerProfile)this.mProfileCompat;
                      com.tencent.mm.compatible.util.k.a(com.tencent.mm.sdk.a.ylY, getClass().getClassLoader());
                    }
                  }
                  catch (Exception paramg)
                  {
                    try
                    {
                      BaseEvent.onCreate();
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.qrL);
                      if (getClass().getClassLoader() == null)
                      {
                        i = -1;
                        if (Thread.currentThread().getContextClassLoader() != null) {
                          break label3299;
                        }
                        j = -1;
                        ab.i("MicroMsg.PluginBigBallOfMud", "SmcLogic, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                      }
                    }
                    catch (Throwable paramg)
                    {
                      try
                      {
                        for (;;)
                        {
                          if (com.tencent.mm.compatible.util.d.fw(20))
                          {
                            ab.i("MicroMsg.PluginBigBallOfMud", "weird");
                            SmcLogic.setUin(0L);
                          }
                          paramg = (com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class);
                          localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.zero.a.d.class);
                          new com.tencent.mm.plugin.e.d().after(paramg).before(this);
                          localObject2 = (com.tencent.mm.plugin.e.b)new com.tencent.mm.plugin.e.b().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.f().after((com.tencent.mm.kernel.b.a)localObject2).before(this);
                          new com.tencent.mm.plugin.e.c().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.a().after((com.tencent.mm.kernel.b.a)localObject1);
                          com.tencent.mm.bq.d.dpT();
                          com.tencent.mm.pluginsdk.g.a.a.m.a(new PluginBigBallOfMud.19(this));
                          j.c.a(new PluginBigBallOfMud.2(this));
                          j.c.a(new com.tencent.mm.cm.c() {});
                          j.c.a(new PluginBigBallOfMud.4(this));
                          j.c.a(new com.tencent.mm.cm.c() {});
                          j.c.a(new PluginBigBallOfMud.6(this));
                          j.c.a(new PluginBigBallOfMud.7(this));
                          j.c.a(new PluginBigBallOfMud.8(this));
                          j.c.a(new PluginBigBallOfMud.9(this));
                          j.c.a(new PluginBigBallOfMud.10(this));
                          com.tencent.mm.sdk.b.a.ymk.c(new com.tencent.mm.sdk.b.c() {});
                          AppMethodBeat.o(18302);
                          return;
                          ah.setProcessName((String)localObject2);
                          if (((String)localObject2).equals(ah.getPackageName())) {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.WorkerProfile");
                          }
                          for (;;)
                          {
                            ab.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                            break;
                            if (((String)localObject2).equals(ah.getPackageName() + ":push"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.PusherProfile");
                            }
                            else if (((String)localObject2).startsWith(ah.getPackageName() + ":tools"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.ToolsProfile");
                            }
                            else if (((String)localObject2).equals(ah.getPackageName() + ":sandbox"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.SandBoxProfile");
                            }
                            else if (((String)localObject2).equals(ah.getPackageName() + ":exdevice"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.ExDeviceProfile");
                            }
                            else if (((String)localObject2).equals(ah.getPackageName() + ":TMAssistantDownloadSDKService"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.TMAssistantProfile");
                            }
                            else if (((String)localObject2).equals(ah.getPackageName() + ":nospace"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.NoSpaceProfile");
                            }
                            else if (((String)localObject2).equals(ah.getPackageName() + ":patch"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.PatchProfile");
                            }
                            else if (((String)localObject2).startsWith(ah.getPackageName() + ":appbrand"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.AppBrandProfile");
                            }
                            else
                            {
                              if (!((String)localObject2).startsWith(ah.getPackageName() + ":support")) {
                                break label3125;
                              }
                              localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.SupportProfile");
                            }
                          }
                          label3125:
                          com.tencent.mm.sdk.a.b.G("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                          localObject1 = null;
                          break;
                          localException1 = localException1;
                          ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException2 = localException2;
                          ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException3 = localException3;
                          ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException4 = localException4;
                          ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException5 = localException5;
                          ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          if (paramg != null) {
                            ab.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                          }
                          while ((paramg != null) && (!paramg.getPackageName().equals(ah.getPackageName())))
                          {
                            WorkerProfile.BW().bZE = true;
                            break;
                            ab.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
                          }
                          paramg = paramg;
                          BaseEvent.onCreate();
                          continue;
                          i = getClass().getClassLoader().hashCode();
                        }
                        label3299:
                        int j = Thread.currentThread().getContextClassLoader().hashCode();
                      }
                      catch (Throwable paramg)
                      {
                        for (;;)
                        {
                          ab.printErrStackTrace("MicroMsg.PluginBigBallOfMud", paramg, "", new Object[0]);
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
    AppMethodBeat.i(18301);
    dependsOn(com.tencent.mm.plugin.auth.a.b.class);
    dependsOn(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    AppMethodBeat.o(18301);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(18304);
    Resources localResources = ah.getResources();
    if ((localResources instanceof com.tencent.mm.cc.b)) {
      ((com.tencent.mm.cc.b)localResources).onConfigurationChanged(paramConfiguration);
    }
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(18304);
  }
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate()
  {
    AppMethodBeat.i(18303);
    ab.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { ah.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.zbM != null) {
      localApplication.unregisterReceiver(localMMAppMgr.zbM);
    }
    AppMethodBeat.o(18303);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(18305);
    ab.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), ah.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
    Object localObject = com.tencent.mm.memory.a.a.b.Yc();
    ab.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).fdR.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).Yd();
    }
    AppMethodBeat.o(18305);
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