package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mars.Mars;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.c;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.e.a;
import com.tencent.mm.booter.e.b;
import com.tencent.mm.booter.e.c;
import com.tencent.mm.booter.x;
import com.tencent.mm.compatible.loader.d.1;
import com.tencent.mm.f.a.tu;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.d.b.3;
import com.tencent.mm.model.u.1;
import com.tencent.mm.model.u.2;
import com.tencent.mm.model.u.3;
import com.tencent.mm.model.u.4;
import com.tencent.mm.model.u.5;
import com.tencent.mm.model.u.6;
import com.tencent.mm.model.u.7;
import com.tencent.mm.model.u.8;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ab.a;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.voip.ui.VoipViewFragment;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.AndroidOSafety.ISafetyCallback;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.chatting.k.b.1;
import com.tencent.mm.ui.chatting.k.b.2;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
  private com.tencent.mm.compatible.loader.c mProfileCompat;
  
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
    com.tencent.mm.ui.e.a(new PluginBigBallOfMud.1(this));
    MMReceivers.ToolsProcessReceiver.a(new e.c());
    MMReceivers.ToolsMpProcessReceiver.a(new e.a());
    MMReceivers.SandBoxProcessReceiver.a(new e.b());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new l());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new q());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new g());
    Log.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.Zw;
    Log.i("MicroMsg.PluginBigBallOfMud", "app. %s", new Object[] { this.app });
    com.tencent.mm.modelstat.d.j(this.app);
    Log.i("MicroMsg.PluginBigBallOfMud", "ClickFlowStatSender registerActivityLifeCycle");
    long l = System.currentTimeMillis();
    Object localObject3 = new com.tencent.mm.compatible.loader.d();
    localObject1 = this.app;
    Object localObject2 = paramg.mProcessName;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      com.tencent.e.j.a locala = com.tencent.e.j.a.bDn("ProfileFactoryImp_handlerThread");
      localObject2 = (String)new d.1((com.tencent.mm.compatible.loader.d)localObject3).exec(new MMHandler(locala));
      locala.Zxu.quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        Log.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.c)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.aIE()))
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        Log.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.f.bE(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.Zw.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3836;
        }
      }
      label3624:
      label3804:
      label3836:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.mProcessName, Long.valueOf(Util.milliSecondsToNow(com.tencent.mm.app.d.fcc)), Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(i), com.tencent.mm.storage.ar.Vgb, com.tencent.mm.loader.j.b.aSF() });
          if (paramg.aIE()) {
            com.tencent.mm.m.a.a.a(new PluginBigBallOfMud.12(this));
          }
          com.tencent.mm.compatible.d.a.a(new PluginBigBallOfMud.23(this));
          AndroidOSafety.setISafetyCallback(new AndroidOSafety.ISafetyCallback()
          {
            public final void invokeToOpaque(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22404);
              com.tencent.mm.ui.base.b.bv(paramAnonymousActivity);
              AppMethodBeat.o(22404);
            }
            
            public final void reportState(int paramAnonymousInt, Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(280990);
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1221L, paramAnonymousInt, 1L, false);
              AppMethodBeat.o(280990);
            }
            
            public final boolean supportSwipe(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22405);
              boolean bool = com.tencent.mm.ui.base.b.bA(paramAnonymousActivity.getClass());
              AppMethodBeat.o(22405);
              return bool;
            }
          });
          if (paramg.aIE())
          {
            com.tencent.mm.modelfriend.a.lLa = new PluginBigBallOfMud.34(this);
            com.tencent.mm.storagebase.f.a(new SQLiteTrace()
            {
              public final void onConnectionObtained(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, long paramAnonymousLong, boolean paramAnonymousBoolean) {}
              
              public final void onConnectionPoolBusy(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, long paramAnonymousLong, boolean paramAnonymousBoolean, List<SQLiteTrace.TraceInfo<String>> paramAnonymousList, List<SQLiteTrace.TraceInfo<StackTraceElement[]>> paramAnonymousList1)
              {
                AppMethodBeat.i(22408);
                paramAnonymousBoolean = WXHardCoderJNI.hcDBEnable;
                int j = WXHardCoderJNI.hcDBDelayWrite;
                int k = WXHardCoderJNI.hcDBCPU;
                int m = WXHardCoderJNI.hcDBIO;
                if (WXHardCoderJNI.hcDBThr) {}
                for (int i = com.tencent.mm.kernel.h.aHJ().getProcessTid();; i = 0)
                {
                  WXHardCoderJNI.startPerformance(paramAnonymousBoolean, j, k, m, i, WXHardCoderJNI.hcDBTimeoutBusy, 501, WXHardCoderJNI.hcDBActionWrite, "MicroMsg.PluginBigBallOfMud");
                  AppMethodBeat.o(22408);
                  return;
                }
              }
              
              public final void onDatabaseCorrupted(SQLiteDatabase paramAnonymousSQLiteDatabase) {}
              
              public final void onSQLExecuted(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(22407);
                com.tencent.mm.model.d.b localb;
                try
                {
                  localb = com.tencent.mm.model.d.b.bgH();
                  boolean bool1 = MMHandlerThread.isMainThread();
                  String str1 = paramAnonymousSQLiteDatabase.getPath();
                  com.tencent.matrix.c.d.a(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousLong);
                  if (((paramAnonymousLong > localb.lxV) && (bool1)) || ((paramAnonymousLong > localb.lxY) && (!bool1)))
                  {
                    paramAnonymousSQLiteDatabase = com.tencent.mm.model.d.b.lye.iterator();
                    do
                    {
                      do
                      {
                        if (!paramAnonymousSQLiteDatabase.hasNext()) {
                          break;
                        }
                        str2 = (String)paramAnonymousSQLiteDatabase.next();
                      } while (bool1);
                      bool2 = str1.contains(str2);
                    } while (!bool2);
                  }
                  while ((paramAnonymousInt == 2) && (bool1) && (paramAnonymousLong < localb.lxW))
                  {
                    String str2;
                    boolean bool2;
                    AppMethodBeat.o(22407);
                    return;
                  }
                  if ((paramAnonymousInt == 1) && (paramAnonymousLong > localb.lxX) && (com.tencent.mm.model.d.b.bgJ()))
                  {
                    paramAnonymousSQLiteDatabase = com.tencent.mm.model.d.b.lyf.iterator();
                    while (paramAnonymousSQLiteDatabase.hasNext())
                    {
                      str1 = (String)paramAnonymousSQLiteDatabase.next();
                      if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.contains(str1))) {
                        com.tencent.mm.plugin.report.service.h.IzE.a(21577, new Object[] { Long.valueOf(paramAnonymousLong), str1, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                      }
                    }
                  }
                  if (localb.lxB) {
                    break label602;
                  }
                }
                catch (Exception paramAnonymousSQLiteDatabase)
                {
                  Log.printErrStackTrace("MicroMsg.SQLiteTrace", paramAnonymousSQLiteDatabase, "Failed to send trace.", new Object[0]);
                  AppMethodBeat.o(22407);
                  return;
                }
                paramAnonymousString = paramAnonymousString.trim().toUpperCase();
                if ((!paramAnonymousString.startsWith("INSERT")) && (!paramAnonymousString.startsWith("UPDATE")) && (!paramAnonymousString.startsWith("DELETE")) && (!paramAnonymousString.startsWith("COMMIT")) && (!paramAnonymousString.startsWith("SELECT")))
                {
                  paramAnonymousSQLiteDatabase = null;
                  label327:
                  if (!Util.isNullOrNil(paramAnonymousSQLiteDatabase))
                  {
                    paramAnonymousString = new StringBuilder();
                    com.tencent.mm.model.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), paramAnonymousString);
                    com.tencent.mm.model.d.b.a("sql", paramAnonymousSQLiteDatabase, paramAnonymousString);
                    com.tencent.mm.model.d.b.a("lastTime", String.valueOf(paramAnonymousLong), paramAnonymousString);
                    if (!CrashReportFactory.foreground) {
                      break label619;
                    }
                  }
                }
                label602:
                label614:
                label619:
                for (paramAnonymousSQLiteDatabase = "1";; paramAnonymousSQLiteDatabase = "0")
                {
                  com.tencent.mm.model.d.b.a("foreground", paramAnonymousSQLiteDatabase, paramAnonymousString);
                  com.tencent.mm.model.d.b.a("tname", Thread.currentThread().getName(), paramAnonymousString);
                  paramAnonymousSQLiteDatabase = paramAnonymousString.toString();
                  Log.d("MicroMsg.SQLTraceManager", "SQL Trace mark : ".concat(String.valueOf(paramAnonymousSQLiteDatabase)));
                  bh.aHJ().postToWorker(new b.3(localb, paramAnonymousSQLiteDatabase));
                  AppMethodBeat.o(22407);
                  return;
                  if (paramAnonymousString.startsWith("INSERT")) {
                    paramAnonymousSQLiteDatabase = paramAnonymousString.substring(0, paramAnonymousString.indexOf("(", 0));
                  }
                  for (;;)
                  {
                    paramAnonymousString = paramAnonymousSQLiteDatabase;
                    if (paramAnonymousSQLiteDatabase.length() > 512) {
                      paramAnonymousString = paramAnonymousSQLiteDatabase.substring(0, 512) + "...";
                    }
                    paramAnonymousSQLiteDatabase = paramAnonymousString;
                    if (paramAnonymousString.trim().endsWith(";")) {
                      break;
                    }
                    paramAnonymousSQLiteDatabase = paramAnonymousString + ";";
                    break;
                    paramAnonymousSQLiteDatabase = paramAnonymousString;
                    if (paramAnonymousString.startsWith("COMMIT"))
                    {
                      if (paramAnonymousLong <= localb.lxZ) {
                        break label614;
                      }
                      paramAnonymousSQLiteDatabase = paramAnonymousString + "task:" + Util.getStack();
                    }
                  }
                  Log.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                  break;
                  paramAnonymousSQLiteDatabase = null;
                  break label327;
                }
              }
            });
            com.tencent.mm.storage.e.Vcv = new PluginBigBallOfMud.36(this);
            com.tencent.mm.model.ac.a(new PluginBigBallOfMud.37(this));
            af.b(new PluginBigBallOfMud.38(this));
            localObject1 = new com.tencent.mm.modelmulti.a();
            ab.a.a(69, (ab)localObject1);
            ab.a.a(68, (ab)localObject1);
            ab.a.a(22, (ab)localObject1);
            ab.a.a(13, (ab)localObject1);
            ab.a.a(15, (ab)localObject1);
            ab.a.a(23, (ab)localObject1);
            ab.a.a(25, (ab)localObject1);
            ab.a.a(24, (ab)localObject1);
            ab.a.a(33, (ab)localObject1);
            ab.a.a(35, (ab)localObject1);
            ab.a.a(44, (ab)localObject1);
            ab.a.a(999999, (ab)localObject1);
            ab.a.a(53, (ab)localObject1);
            ab.a.a(204, (ab)localObject1);
            ab.a.a(219, (ab)localObject1);
            localObject1 = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.g.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.f)localObject1);
            com.tencent.mm.kernel.h.aGY().a(681, (com.tencent.mm.an.i)localObject1);
            com.tencent.mm.kernel.h.b(com.tencent.mm.pluginsdk.i.a.class, this.deleteContactService);
            af.a(5, new n());
            af.a(1, new t());
            af.a(4, new i());
            ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new a());
            localObject1 = new o();
            ((aa)com.tencent.mm.kernel.h.ae(aa.class)).a((com.tencent.mm.plugin.messenger.foundation.a.q)localObject1);
            ((aa)com.tencent.mm.kernel.h.ae(aa.class)).a((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1);
            ((aa)com.tencent.mm.kernel.h.ae(aa.class)).a(new h());
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new s().alive();
            p.cxH();
            r.eM(this.app);
            com.tencent.mm.bc.a.a.a("delchatroommember", new u.1());
            com.tencent.mm.bc.a.a.a("NewXmlChatRoomAccessVerifyApplication", new u.2());
            com.tencent.mm.bc.a.a.a("NewXmlChatRoomAccessVerifyApproval", new u.3());
            com.tencent.mm.bc.a.a.a("chatroommuteexpt", new u.4());
            com.tencent.mm.bc.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new u.5());
            com.tencent.mm.bc.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new u.6());
            com.tencent.mm.bc.a.a.a("FinderPersonalMsgSysMsg", new u.7());
            ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new u.8());
            com.tencent.mm.bc.a.a.a("invokeMessage", new b.1());
            com.tencent.mm.bc.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new b.2());
            bz.bcA();
            com.tencent.mm.model.n.bcA();
            localObject1 = this.appMgr;
            localObject2 = this.app;
            if (((MMAppMgr)localObject1).WaI == null) {
              ((MMAppMgr)localObject1).WaI = new MMAppMgr.Receiver((MMAppMgr)localObject1);
            }
            MMActivity.setMainProcess();
            localObject3 = new IntentFilter();
            ((IntentFilter)localObject3).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject3).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject3).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject3).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject3).addAction("MINIQB_OPEN_RET");
            ((Context)localObject2).registerReceiver(((MMAppMgr)localObject1).WaI, (IntentFilter)localObject3, WeChatPermissions.PERMISSION_MM_MESSAGE(), null);
            localObject1 = new x(com.tencent.mm.booter.d.cc(this.app));
            ((x)localObject1).JC("MM");
            com.tencent.mm.platformtools.ac.mFS = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            com.tencent.mm.platformtools.ac.mEX = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.display_errcode"), false);
            com.tencent.mm.platformtools.ac.mEY = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.display_msgstate"), false);
            com.tencent.mm.platformtools.ac.mEZ = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            com.tencent.mm.platformtools.ac.mFa = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.network.force_touch"), false);
            com.tencent.mm.platformtools.ac.mFb = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            com.tencent.mm.platformtools.ac.mFc = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.crashIsExit"), false);
            com.tencent.mm.platformtools.ac.mFE = Util.getInt(Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            com.tencent.mm.platformtools.ac.mFF = Util.getInt(Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            com.tencent.mm.platformtools.ac.mFf = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.album_drop_table"), false);
            com.tencent.mm.platformtools.ac.mFg = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.album_dle_file"), false);
            com.tencent.mm.platformtools.ac.mFh = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.album_show_info"), false);
            com.tencent.mm.platformtools.ac.mFi = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.location_help"), false);
            com.tencent.mm.platformtools.ac.mFl = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.force_soso"), false);
            com.tencent.mm.platformtools.ac.mFm = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            com.tencent.mm.platformtools.ac.mFn = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            com.tencent.mm.platformtools.ac.mFo = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            com.tencent.mm.platformtools.ac.mFr = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.filterfpnp"), false);
            com.tencent.mm.platformtools.ac.mFs = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.testForPull"), false);
            i = Util.nullAs(((x)localObject1).JD(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            com.tencent.mm.platformtools.ac.mFp = i;
            if ((i != 4) && (com.tencent.mm.platformtools.ac.mFp > 0))
            {
              com.tencent.mm.storage.aq.VfZ = com.tencent.mm.platformtools.ac.mFp;
              Log.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.ac.mFp);
            }
            com.tencent.mm.platformtools.ac.mFq = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            com.tencent.mm.platformtools.ac.mFt = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.server.host.http"), "");
            com.tencent.mm.platformtools.ac.mFu = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.show_full_version"), false)) {
              com.tencent.mm.sdk.platformtools.ChannelUtil.fullVersionInfo = true;
            }
          }
          try
          {
            i = Integer.decode(((x)localObject1).getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.arg(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception localThrowable1)
          {
            try
            {
              localObject2 = ((x)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
              if (!Util.isNullOrNil((String)localObject2))
              {
                com.tencent.mm.protocal.d.kQZ = "android-".concat(String.valueOf(localObject2));
                com.tencent.mm.protocal.d.RAy = "android-".concat(String.valueOf(localObject2));
                com.tencent.mm.protocal.d.RAA = String.valueOf(localObject2);
                CrashReportFactory.setDebugerApiLevel((String)localObject2);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.kQZ).append(" ").append(CrashReportFactory.getDebugerApiLevel());
              }
            }
            catch (Exception localThrowable1)
            {
              try
              {
                l = Long.decode(((x)localObject1).getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.RAC).append(" new: ").append(l);
                com.tencent.mm.protocal.d.RAC = l;
              }
              catch (Exception localThrowable1)
              {
                try
                {
                  i = Integer.decode(((x)localObject1).getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  ((com.tencent.mm.booter.q)localObject1).iQW.iPy = i;
                }
                catch (Exception localThrowable1)
                {
                  try
                  {
                    boolean bool1 = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    com.tencent.mm.platformtools.ac.mFx = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.update_test"), false);
                    com.tencent.mm.platformtools.ac.mFy = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.tablet"), false);
                    com.tencent.mm.platformtools.ac.mFz = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.scan_save_image"), false);
                    com.tencent.mm.platformtools.ac.mFB = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    com.tencent.mm.platformtools.ac.mFC = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    com.tencent.mm.platformtools.ac.mFH = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    Log.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ac.mFH);
                    com.tencent.mm.platformtools.ac.mFW = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.cdn.front"), "");
                    com.tencent.mm.platformtools.ac.mFX = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.cdn.zone"), "");
                    com.tencent.mm.platformtools.ac.mFY = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    com.tencent.mm.platformtools.ac.mFZ = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    com.tencent.mm.platformtools.ac.mGa = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    com.tencent.mm.platformtools.ac.mGb = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cdn.usestream"), false);
                    com.tencent.mm.platformtools.ac.mGc = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    com.tencent.mm.platformtools.ac.mGd = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    com.tencent.mm.platformtools.ac.mGf = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    com.tencent.mm.platformtools.ac.mGg = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    com.tencent.mm.platformtools.ac.mGh = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    com.tencent.mm.platformtools.ac.mGp = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    Log.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.ac.mGp);
                    com.tencent.mm.platformtools.ac.mGq = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    com.tencent.mm.platformtools.ac.mGr = Util.getInt(Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    com.tencent.mm.platformtools.ac.mGm = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.cursormode_enabled"), true);
                    com.tencent.mm.platformtools.ac.mGW = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    com.tencent.mm.platformtools.ac.mGX = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    com.tencent.mm.platformtools.ac.mGY = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    com.tencent.mm.platformtools.ac.mGF = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    com.tencent.mm.platformtools.ac.mGH = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    com.tencent.mm.platformtools.ac.mGG = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    com.tencent.mm.platformtools.ac.mGI = Util.nullAs(((x)localObject1).getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    com.tencent.mm.platformtools.ac.mGP = Util.nullAs(((x)localObject1).JE(".com.tencent.mm.debug.netmock"), false);
                    localObject1 = Util.getTopActivity(MMApplicationContext.getContext());
                    if ((localObject1 != null) && (((ComponentName)localObject1).getPackageName().equals(MMApplicationContext.getPackageName())) && (((ComponentName)localObject1).getClassName().equals(MMApplicationContext.getLaunchName())))
                    {
                      WorkerProfile.abJ().ffA = true;
                      WorkerProfile.abJ().ffB = true;
                      Log.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { ((ComponentName)localObject1).getPackageName(), ((ComponentName)localObject1).getClassName() });
                      com.tencent.mm.model.d.b.bgH();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
                      SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.j());
                      com.tencent.mm.plugin.report.service.j.IAk = (WorkerProfile)this.mProfileCompat;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.KW("wechatbase");
                      localObject1 = CommLibFileName.quic;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.KW((String)localObject1);
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.KW("wechatmm");
                    }
                  }
                  catch (Exception localThrowable1)
                  {
                    try
                    {
                      Mars.onCreate();
                      if (MMApplicationContext.isMainProcess()) {
                        SmcLogic.onCreate();
                      }
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.IyE);
                      if (getClass().getClassLoader() == null)
                      {
                        i = -1;
                        if (Thread.currentThread().getContextClassLoader() != null) {
                          break label3804;
                        }
                        j = -1;
                        Log.i("MicroMsg.PluginBigBallOfMud", "SmcLogic, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                      }
                    }
                    catch (Throwable localThrowable1)
                    {
                      try
                      {
                        for (;;)
                        {
                          if (com.tencent.mm.compatible.util.d.qW(20))
                          {
                            Log.i("MicroMsg.PluginBigBallOfMud", "weird");
                            SmcLogic.setUin(0L);
                          }
                          localObject1 = (com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
                          localObject2 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.zero.a.d.class);
                          new com.tencent.mm.plugin.g.d().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                          localObject3 = (com.tencent.mm.plugin.g.b)new com.tencent.mm.plugin.g.b().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                          new com.tencent.mm.plugin.g.f().after((com.tencent.mm.kernel.b.a)localObject3).before(this);
                          new com.tencent.mm.plugin.g.c().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                          new com.tencent.mm.plugin.g.a().after((com.tencent.mm.kernel.b.a)localObject2);
                          com.tencent.mm.by.c.hoj();
                          com.tencent.mm.ui.chatting.g.a.eKx();
                          com.tencent.mm.ui.chatting.j.b.eKx();
                          ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).registerMultiTaskUIC(4, com.tencent.mm.ui.chatting.j.a.a.class);
                          com.tencent.mm.pluginsdk.k.a.a.m.a(new com.tencent.mm.pluginsdk.k.a.a.a.a()
                          {
                            public final boolean Gn(int paramAnonymousInt)
                            {
                              AppMethodBeat.i(22385);
                              if ((paramAnonymousInt == 39) && (!com.tencent.mm.plugin.ipcall.d.eIU()))
                              {
                                AppMethodBeat.o(22385);
                                return true;
                              }
                              AppMethodBeat.o(22385);
                              return false;
                            }
                          });
                          k.c.a(new PluginBigBallOfMud.3(this));
                          k.c.a(new PluginBigBallOfMud.4(this));
                          k.c.a(new PluginBigBallOfMud.5(this));
                          k.c.a(new PluginBigBallOfMud.6(this));
                          k.c.a(new PluginBigBallOfMud.7(this));
                          k.c.a(new PluginBigBallOfMud.8(this));
                          k.c.a(new PluginBigBallOfMud.9(this));
                          k.c.a(new PluginBigBallOfMud.10(this));
                          k.c.a(new PluginBigBallOfMud.11(this));
                          k.c.a(new PluginBigBallOfMud.13(this));
                          k.c.a(new PluginBigBallOfMud.14(this));
                          k.c.a(new PluginBigBallOfMud.15(this));
                          k.c.a(new PluginBigBallOfMud.16(this));
                          k.c.a(new PluginBigBallOfMud.17(this));
                          k.c.a(new PluginBigBallOfMud.18(this));
                          k.c.a(new PluginBigBallOfMud.19(this));
                          k.c.a(new PluginBigBallOfMud.20(this));
                          k.c.a(new PluginBigBallOfMud.21(this));
                          k.c.a(new PluginBigBallOfMud.22(this));
                          k.c.a(new PluginBigBallOfMud.24(this));
                          k.c.a(new PluginBigBallOfMud.25(this));
                          k.c.a(new PluginBigBallOfMud.26(this));
                          k.c.a(new PluginBigBallOfMud.27(this));
                          k.c.a(new PluginBigBallOfMud.28(this));
                          k.c.a(new PluginBigBallOfMud.29(this));
                          k.c.a(new PluginBigBallOfMud.30(this));
                          k.c.a(new PluginBigBallOfMud.31(this));
                          EventCenter.instance.addListener(new IListener() {});
                          com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.o.class, new com.tencent.mm.modelsimple.b());
                          if (paramg.aIE())
                          {
                            Log.i("MicroMsg.PluginBigBallOfMud", "hy: register magic emoji. temp here");
                            com.tencent.mm.kernel.h.b(com.tencent.mm.api.v.class, com.tencent.mm.ui.n.a.b.XJa);
                          }
                          AppMethodBeat.o(22414);
                          return;
                          if (((String)localObject2).equals(MMApplicationContext.getPackageName())) {
                            localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.WorkerProfile");
                          }
                          for (;;)
                          {
                            Log.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                            break;
                            if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":push"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.PusherProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":tools"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.ToolsProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":sandbox"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.SandBoxProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":exdevice"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.ExDeviceProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":TMAssistantDownloadSDKService"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.TMAssistantProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":nospace"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.NoSpaceProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":patch"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.PatchProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":appbrand"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.AppBrandProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":support"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.SupportProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":lite"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.LiteAppProfile");
                            }
                            else
                            {
                              if (!((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":hld")) {
                                break label3624;
                              }
                              localObject1 = com.tencent.mm.compatible.loader.d.b((Application)localObject1, ".app.WxImeProfile");
                            }
                          }
                          localObject1 = null;
                          break;
                          localException1 = localException1;
                          Log.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException2 = localException2;
                          Log.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException3 = localException3;
                          Log.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException4 = localException4;
                          Log.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException5 = localException5;
                          Log.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          if (localObject1 != null) {
                            Log.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { ((ComponentName)localObject1).getPackageName(), ((ComponentName)localObject1).getClassName() });
                          }
                          while ((localObject1 != null) && (!((ComponentName)localObject1).getPackageName().equals(MMApplicationContext.getPackageName())))
                          {
                            WorkerProfile.abJ().ffA = true;
                            break;
                            Log.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
                          }
                          localThrowable1 = localThrowable1;
                          Mars.onCreate();
                          if (MMApplicationContext.isMainProcess())
                          {
                            SmcLogic.onCreate();
                            continue;
                            i = getClass().getClassLoader().hashCode();
                          }
                        }
                        int j = Thread.currentThread().getContextClassLoader().hashCode();
                      }
                      catch (Throwable localThrowable2)
                      {
                        for (;;)
                        {
                          Log.printErrStackTrace("MicroMsg.PluginBigBallOfMud", localThrowable2, "", new Object[0]);
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
    if (MMApplicationContext.isMainProcess())
    {
      dependsOn(com.tencent.mm.plugin.auth.a.c.class);
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.v.class);
    }
    AppMethodBeat.o(22413);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(22416);
    if ((com.tencent.mm.ui.ar.aEk()) && (com.tencent.mm.ui.ar.aEf()))
    {
      XWalkEnvironment.setForceDarkMode(com.tencent.mm.ui.ar.h(paramConfiguration));
      MMWebView.Ho(com.tencent.mm.ui.ar.h(paramConfiguration));
      if (MMApplicationContext.isMainProcess())
      {
        if (com.tencent.mm.cj.c.g(paramConfiguration))
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "dancy test uiModeChange true, uimode:%s", new Object[] { Integer.valueOf(paramConfiguration.uiMode) });
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          com.tencent.mm.modelappbrand.a.b.bhh().clearCache();
          if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class) != null)
          {
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).aGp();
            if (com.tencent.mm.kernel.h.aHE().aGM())
            {
              localObject = com.tencent.mm.plugin.voip.c.gxt();
              if (((com.tencent.mm.plugin.voip.ui.d)localObject).NVO != null)
              {
                localObject = ((com.tencent.mm.plugin.voip.ui.d)localObject).NVO;
                BaseSmallView localBaseSmallView = ((VoipViewFragment)localObject).NWs;
                if (localBaseSmallView != null) {
                  localBaseSmallView.eYD();
                }
                localObject = ((VoipViewFragment)localObject).NWr;
                if (localObject != null) {
                  ((BaseSmallView)localObject).eYD();
                }
              }
              localObject = ad.eYd().Fzo;
              if (localObject != null) {
                ((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject).eYD();
              }
            }
          }
        }
        com.tencent.mm.cj.c.a(paramConfiguration, com.tencent.mm.ui.ar.isDarkMode());
        if (MMApplicationContext.getContext().getResources() != null) {
          MMApplicationContext.getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
        }
      }
    }
    Object localObject = MMApplicationContext.getResources();
    if ((localObject instanceof com.tencent.mm.cj.b)) {
      ((com.tencent.mm.cj.b)localObject).onConfigurationChanged(paramConfiguration);
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
    Log.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { MMApplicationContext.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.WaI != null) {
      localApplication.unregisterReceiver(localMMAppMgr.WaI);
    }
    AppMethodBeat.o(22415);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(22417);
    Log.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), MMApplicationContext.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
    Object localObject = com.tencent.mm.memory.a.a.b.bbh();
    Log.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).liQ.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).bbi();
    }
    AppMethodBeat.o(22417);
  }
  
  public String toString()
  {
    return "plugin-big-ball-of-mud";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud
 * JD-Core Version:    0.7.0.1
 */