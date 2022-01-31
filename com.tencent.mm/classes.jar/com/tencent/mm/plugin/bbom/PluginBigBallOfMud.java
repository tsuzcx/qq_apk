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
import com.tencent.mm.ae.g.b;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.d.b;
import com.tencent.mm.booter.d.c;
import com.tencent.mm.booter.x;
import com.tencent.mm.compatible.loader.f.1;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.l.1;
import com.tencent.mm.model.l.2;
import com.tencent.mm.model.l.3;
import com.tencent.mm.model.l.4;
import com.tencent.mm.model.l.5;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.chatting.g.b.1;

public class PluginBigBallOfMud
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket
{
  private static final String TAG = "MicroMsg.PluginBigBallOfMud";
  public Application app;
  private final MMAppMgr appMgr = new MMAppMgr();
  private com.tencent.mm.compatible.loader.e mProfileCompat;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.ui.d.a(new com.tencent.mm.ui.d.a()
    {
      public final void a(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
      {
        com.tencent.mm.plugin.report.f.nEG.f(14976, new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString1, paramAnonymousString2 });
      }
    });
    MMReceivers.ToolsProcessReceiver.a(new d.c());
    MMReceivers.ToolsMpProcessReceiver.a(new d.c());
    MMReceivers.SandBoxProcessReceiver.a(new d.b());
    MMReceivers.ExdeviceProcessReceiver.a(new com.tencent.mm.booter.d.a());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new j());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new o());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new g());
    y.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.bT;
    com.tencent.mm.modelstat.d.c(this.app);
    y.i("MicroMsg.PluginBigBallOfMud", "app.getResources() is:" + paramg.bT.getResources());
    com.tencent.mm.sdk.platformtools.ae.d(com.tencent.mm.cc.a.a(paramg.bT.getResources(), paramg.bT));
    long l = System.currentTimeMillis();
    com.tencent.mm.compatible.loader.f localf = new com.tencent.mm.compatible.loader.f();
    localObject1 = this.app;
    Object localObject2 = paramg.dIA;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.aap("ProfileFactoryImp_handlerThread");
      localHandlerThread.start();
      localObject2 = (String)new f.1(localf).b(new ah(localHandlerThread.getLooper()));
      localHandlerThread.getLooper().quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        y.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.e)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.Ex()))
        {
          y.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        y.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.d.aA(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.bT.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3283;
        }
      }
      label3086:
      label3239:
      label3253:
      label3283:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          y.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.dIA, Long.valueOf(bk.co(com.tencent.mm.app.b.bvZ)), Long.valueOf(bk.co(l)), Integer.valueOf(i), ac.dOP, com.tencent.mm.compatible.util.e.bkF });
          com.tencent.mm.l.a.a.a(new PluginBigBallOfMud.8(this));
          com.tencent.mm.compatible.d.a.a(new PluginBigBallOfMud.9(this));
          if (paramg.Ex())
          {
            com.tencent.mm.modelfriend.a.ekT = new PluginBigBallOfMud.10(this);
            com.tencent.mm.cf.f.a(new PluginBigBallOfMud.11(this));
            com.tencent.mm.storage.e.umQ = new PluginBigBallOfMud.12(this);
            t.a(new PluginBigBallOfMud.13(this));
            u.b(new PluginBigBallOfMud.14(this));
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
            ((com.tencent.mm.plugin.messenger.foundation.a.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(paramg);
            com.tencent.mm.kernel.g.Dk().a(681, paramg);
            u.a(5, new l());
            u.a(1, new r());
            u.a(4, new h());
            ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new a());
            paramg = new m();
            ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.q.class)).a(paramg);
            ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.q.class)).a(paramg);
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new q().cqo();
            com.tencent.mm.kernel.g.Dk().b(138, n.hSV);
            com.tencent.mm.kernel.g.Dk().b(39, n.hSV);
            com.tencent.mm.kernel.g.Dk().b(268369922, n.hSV);
            if (n.hSV == null) {
              n.hSV = new n();
            }
            com.tencent.mm.kernel.g.Dk().a(138, n.hSV);
            com.tencent.mm.kernel.g.Dk().a(39, n.hSV);
            com.tencent.mm.kernel.g.Dk().a(268369922, n.hSV);
            p.cs(this.app);
            com.tencent.mm.ax.a.a.a("delchatroommember", new l.1());
            com.tencent.mm.ax.a.a.a("NewXmlChatRoomAccessVerifyApplication", new l.2());
            com.tencent.mm.ax.a.a.a("NewXmlChatRoomAccessVerifyApproval", new l.3());
            com.tencent.mm.ax.a.a.a("chatroommuteexpt", new l.4());
            ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new l.5());
            com.tencent.mm.ax.a.a.a("invokeMessage", new b.1());
            bm.Ic();
            paramg = this.appMgr;
            localObject1 = this.app;
            if (paramg.uNJ == null) {
              paramg.uNJ = new MMAppMgr.Receiver(paramg);
            }
            MMActivity.czj();
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject2).addAction("MINIQB_OPEN_RET");
            ((Context)localObject1).registerReceiver(paramg.uNJ, (IntentFilter)localObject2, "com.tencent.mm.permission.MM_MESSAGE", null);
            paramg = new x(com.tencent.mm.booter.c.aS(this.app));
            paramg.em("MM");
            com.tencent.mm.platformtools.ae.eSV = bk.a(paramg.en(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            com.tencent.mm.platformtools.ae.eSd = bk.a(paramg.en(".com.tencent.mm.debug.test.display_errcode"), false);
            com.tencent.mm.platformtools.ae.eSe = bk.a(paramg.en(".com.tencent.mm.debug.test.display_msgstate"), false);
            com.tencent.mm.platformtools.ae.eSf = bk.a(paramg.en(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            com.tencent.mm.platformtools.ae.eSg = bk.a(paramg.en(".com.tencent.mm.debug.test.network.force_touch"), false);
            com.tencent.mm.platformtools.ae.eSh = bk.a(paramg.en(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            com.tencent.mm.platformtools.ae.eSi = bk.a(paramg.en(".com.tencent.mm.debug.test.crashIsExit"), false);
            com.tencent.mm.platformtools.ae.eSH = bk.getInt(bk.aM(paramg.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            com.tencent.mm.platformtools.ae.eSI = bk.getInt(bk.aM(paramg.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            com.tencent.mm.platformtools.ae.eSk = bk.a(paramg.en(".com.tencent.mm.debug.test.album_drop_table"), false);
            com.tencent.mm.platformtools.ae.eSl = bk.a(paramg.en(".com.tencent.mm.debug.test.album_dle_file"), false);
            com.tencent.mm.platformtools.ae.eSm = bk.a(paramg.en(".com.tencent.mm.debug.test.album_show_info"), false);
            com.tencent.mm.platformtools.ae.eSn = bk.a(paramg.en(".com.tencent.mm.debug.test.location_help"), false);
            com.tencent.mm.platformtools.ae.eSq = bk.a(paramg.en(".com.tencent.mm.debug.test.force_soso"), false);
            com.tencent.mm.platformtools.ae.eSr = bk.a(paramg.en(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            com.tencent.mm.platformtools.ae.eSs = bk.a(paramg.en(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            com.tencent.mm.platformtools.ae.eSt = bk.a(paramg.en(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            com.tencent.mm.platformtools.ae.eSw = bk.a(paramg.en(".com.tencent.mm.debug.test.filterfpnp"), false);
            com.tencent.mm.platformtools.ae.eSx = bk.a(paramg.en(".com.tencent.mm.debug.test.testForPull"), false);
            i = bk.a(paramg.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            com.tencent.mm.platformtools.ae.eSu = i;
            if ((i != 4) && (com.tencent.mm.platformtools.ae.eSu > 0))
            {
              com.tencent.mm.storage.ab.unv = com.tencent.mm.platformtools.ae.eSu;
              y.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.ae.eSu);
            }
            com.tencent.mm.platformtools.ae.eSv = bk.a(paramg.en(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            com.tencent.mm.platformtools.ae.eSy = bk.aM(paramg.getString(".com.tencent.mm.debug.server.host.http"), "");
            com.tencent.mm.platformtools.ae.eSz = bk.aM(paramg.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bk.a(paramg.en(".com.tencent.mm.debug.test.show_full_version"), false)) {
              com.tencent.mm.sdk.platformtools.e.uek = true;
            }
          }
          try
          {
            i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.EC(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception localException5)
          {
            try
            {
              localObject1 = paramg.getString(".com.tencent.mm.debug.log.setapilevel");
              if (!bk.bl((String)localObject1))
              {
                com.tencent.mm.protocal.d.dOM = "android-" + (String)localObject1;
                com.tencent.mm.protocal.d.soW = "android-" + (String)localObject1;
                com.tencent.mm.protocal.d.soY = (String)localObject1;
                com.tencent.mm.sdk.a.b.YR((String)localObject1);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.dOM).append(" ").append(com.tencent.mm.sdk.a.b.cql());
              }
            }
            catch (Exception localException5)
            {
              try
              {
                l = Long.decode(paramg.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.soZ).append(" new: ").append(l);
                com.tencent.mm.protocal.d.soZ = l;
              }
              catch (Exception localException5)
              {
                try
                {
                  i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  paramg.diu.dhC = i;
                }
                catch (Exception localException5)
                {
                  try
                  {
                    boolean bool1 = bk.a(paramg.en(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = bk.a(paramg.en(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = bk.a(paramg.en(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = bk.a(paramg.en(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    com.tencent.mm.platformtools.ae.eSC = bk.a(paramg.en(".com.tencent.mm.debug.test.update_test"), false);
                    com.tencent.mm.platformtools.ae.eSD = bk.a(paramg.en(".com.tencent.mm.debug.test.scan_save_image"), false);
                    com.tencent.mm.platformtools.ae.eSF = bk.a(paramg.en(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    com.tencent.mm.platformtools.ae.eSG = bk.a(paramg.en(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    com.tencent.mm.platformtools.ae.eSK = bk.aM(paramg.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    y.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ae.eSK);
                    com.tencent.mm.platformtools.ae.eSZ = bk.aM(paramg.getString(".com.tencent.mm.debug.cdn.front"), "");
                    com.tencent.mm.platformtools.ae.eTa = bk.aM(paramg.getString(".com.tencent.mm.debug.cdn.zone"), "");
                    com.tencent.mm.platformtools.ae.eTb = bk.aM(paramg.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    com.tencent.mm.platformtools.ae.eTc = bk.aM(paramg.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    com.tencent.mm.platformtools.ae.eTd = bk.aM(paramg.getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    com.tencent.mm.platformtools.ae.eTe = bk.a(paramg.en(".com.tencent.mm.debug.cdn.usestream"), false);
                    com.tencent.mm.platformtools.ae.eTf = bk.a(paramg.en(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    com.tencent.mm.platformtools.ae.eTg = bk.a(paramg.en(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    com.tencent.mm.platformtools.ae.eTi = bk.a(paramg.en(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    com.tencent.mm.platformtools.ae.eTj = bk.a(paramg.en(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    com.tencent.mm.platformtools.ae.eTk = bk.a(paramg.en(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    com.tencent.mm.platformtools.ae.eTq = bk.a(paramg.en(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    y.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.ae.eTq);
                    com.tencent.mm.platformtools.ae.eTr = bk.aM(paramg.getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    com.tencent.mm.platformtools.ae.eTs = bk.getInt(bk.aM(paramg.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    com.tencent.mm.platformtools.ae.eTn = bk.a(paramg.en(".com.tencent.mm.debug.cursormode_enabled"), true);
                    com.tencent.mm.platformtools.ae.eTQ = bk.a(paramg.en(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    com.tencent.mm.platformtools.ae.eTR = bk.a(paramg.en(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    com.tencent.mm.platformtools.ae.eTS = bk.a(paramg.en(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    com.tencent.mm.platformtools.ae.eTD = bk.a(paramg.en(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    com.tencent.mm.platformtools.ae.eTF = bk.aM(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    com.tencent.mm.platformtools.ae.eTE = bk.a(paramg.en(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    com.tencent.mm.platformtools.ae.eTG = bk.aM(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    com.tencent.mm.platformtools.ae.eTN = bk.a(paramg.en(".com.tencent.mm.debug.netmock"), false);
                    paramg = bk.fX(com.tencent.mm.sdk.platformtools.ae.getContext());
                    if ((paramg != null) && (paramg.getPackageName().equals(com.tencent.mm.sdk.platformtools.ae.getPackageName())) && (paramg.getClassName().equals(com.tencent.mm.sdk.platformtools.ae.cqP())))
                    {
                      WorkerProfile.ts().bxC = true;
                      WorkerProfile.ts().bxD = true;
                      y.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                      com.tencent.mm.model.d.b.Jg();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(com.tencent.mm.sdk.platformtools.ae.getContext()));
                      SmcLogic.setCallBack(new i());
                      i.nGg = (WorkerProfile)this.mProfileCompat;
                      k.b(com.tencent.mm.sdk.a.udJ, getClass().getClassLoader());
                      BaseEvent.onCreate();
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.nEJ);
                      if (getClass().getClassLoader() != null) {
                        break label3239;
                      }
                      i = -1;
                      if (Thread.currentThread().getContextClassLoader() != null) {
                        break label3253;
                      }
                      j = -1;
                      y.i("MicroMsg.PluginBigBallOfMud", "SmcLogic, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                    }
                  }
                  catch (Exception localException5)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (com.tencent.mm.compatible.util.d.gG(20))
                        {
                          y.i("MicroMsg.PluginBigBallOfMud", "weird");
                          SmcLogic.setUin(0L);
                        }
                        paramg = (com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class);
                        localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.zero.a.d.class);
                        new com.tencent.mm.plugin.g.d().after(paramg).before(this);
                        localObject2 = (com.tencent.mm.plugin.g.b)new com.tencent.mm.plugin.g.b().after(paramg).before(this);
                        new com.tencent.mm.plugin.g.f().after((com.tencent.mm.kernel.b.a)localObject2).before(this);
                        new com.tencent.mm.plugin.g.c().after(paramg).before(this);
                        new com.tencent.mm.plugin.g.a().after((com.tencent.mm.kernel.b.a)localObject1);
                        com.tencent.mm.pluginsdk.g.a.a.m.a(new PluginBigBallOfMud.15(this));
                        g.b.a(new com.tencent.mm.ck.c() {});
                        g.b.a(new PluginBigBallOfMud.3(this));
                        g.b.a(new PluginBigBallOfMud.4(this));
                        g.b.a(new com.tencent.mm.ck.c() {});
                        g.b.a(new PluginBigBallOfMud.6(this));
                        g.b.a(new PluginBigBallOfMud.7(this));
                        return;
                        com.tencent.mm.sdk.platformtools.ae.bw((String)localObject2);
                        if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName())) {
                          localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.WorkerProfile");
                        }
                        for (;;)
                        {
                          y.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                          break;
                          if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":push"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.PusherProfile");
                          }
                          else if (((String)localObject2).startsWith(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":tools"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.ToolsProfile");
                          }
                          else if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":sandbox"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.SandBoxProfile");
                          }
                          else if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":exdevice"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.ExDeviceProfile");
                          }
                          else if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":TMAssistantDownloadSDKService"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.TMAssistantProfile");
                          }
                          else if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":nospace"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.NoSpaceProfile");
                          }
                          else if (((String)localObject2).equals(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":patch"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.PatchProfile");
                          }
                          else if (((String)localObject2).startsWith(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":appbrand"))
                          {
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.AppBrandProfile");
                          }
                          else
                          {
                            if (!((String)localObject2).startsWith(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":support")) {
                              break label3086;
                            }
                            localObject1 = com.tencent.mm.compatible.loader.f.c((Application)localObject1, ".app.SupportProfile");
                          }
                        }
                        com.tencent.mm.sdk.a.b.t("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                        localObject1 = null;
                        break;
                        localException1 = localException1;
                        y.i("MicroMsg.WorkerDebugger", "no debugger was got");
                        continue;
                        localException2 = localException2;
                        y.i("MicroMsg.WorkerDebugger", "no debugger was got");
                        continue;
                        localException3 = localException3;
                        y.i("MicroMsg.WorkerDebugger", "no debugger was got");
                        continue;
                        localException4 = localException4;
                        y.i("MicroMsg.WorkerDebugger", "no debugger was got");
                        continue;
                        localException5 = localException5;
                        y.i("MicroMsg.WorkerDebugger", "no debugger was got");
                        continue;
                        if (paramg != null) {
                          y.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                        }
                        while ((paramg != null) && (!paramg.getPackageName().equals(com.tencent.mm.sdk.platformtools.ae.getPackageName())))
                        {
                          WorkerProfile.ts().bxC = true;
                          break;
                          y.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
                        }
                        i = getClass().getClassLoader().hashCode();
                      }
                      int j = Thread.currentThread().getContextClassLoader().hashCode();
                    }
                    catch (Throwable paramg)
                    {
                      for (;;)
                      {
                        y.printErrStackTrace("MicroMsg.PluginBigBallOfMud", paramg, "", new Object[0]);
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
    dependsOn(com.tencent.mm.plugin.auth.a.b.class);
    dependsOn(com.tencent.mm.plugin.messenger.foundation.a.p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Resources localResources = com.tencent.mm.sdk.platformtools.ae.getResources();
    if ((localResources instanceof com.tencent.mm.cc.a)) {
      ((com.tencent.mm.cc.a)localResources).onConfigurationChanged(paramConfiguration);
    }
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate()
  {
    y.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { com.tencent.mm.sdk.platformtools.ae.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.uNJ != null) {
      localApplication.unregisterReceiver(localMMAppMgr.uNJ);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    y.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.sdk.platformtools.ae.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
  }
  
  public String toString()
  {
    return "plugin-big-ball-of-mud";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud
 * JD-Core Version:    0.7.0.1
 */