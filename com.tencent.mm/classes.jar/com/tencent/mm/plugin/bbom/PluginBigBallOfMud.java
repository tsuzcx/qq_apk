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
import com.tencent.mm.ah.k.c;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.e.a;
import com.tencent.mm.booter.e.b;
import com.tencent.mm.booter.e.c;
import com.tencent.mm.compatible.loader.e.1;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.live.b.l;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.d.b.3;
import com.tencent.mm.model.p.1;
import com.tencent.mm.model.p.2;
import com.tencent.mm.model.p.3;
import com.tencent.mm.model.p.4;
import com.tencent.mm.model.p.5;
import com.tencent.mm.model.p.6;
import com.tencent.mm.model.p.7;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.i.b.1;
import com.tencent.mm.ui.chatting.i.b.2;
import com.tencent.mm.ui.chatting.viewitems.k.a;
import com.tencent.mm.ui.d.a;
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
  private i deleteContactService;
  private com.tencent.mm.compatible.loader.d mProfileCompat;
  
  public PluginBigBallOfMud()
  {
    AppMethodBeat.i(22412);
    this.appMgr = new MMAppMgr();
    this.deleteContactService = new i();
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
        com.tencent.mm.plugin.report.e.wTc.f(14976, new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(22384);
      }
    });
    MMReceivers.ToolsProcessReceiver.a(new e.c());
    MMReceivers.ToolsMpProcessReceiver.a(new e.a());
    MMReceivers.SandBoxProcessReceiver.a(new e.b());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new k());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new p());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new g());
    ac.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.ca;
    ac.i("MicroMsg.PluginBigBallOfMud", "app. %s", new Object[] { this.app });
    com.tencent.mm.modelstat.d.f(this.app);
    ac.i("MicroMsg.PluginBigBallOfMud", "ClickFlowStatSender registerActivityLifeCycle");
    long l = System.currentTimeMillis();
    com.tencent.mm.compatible.loader.e locale = new com.tencent.mm.compatible.loader.e();
    localObject1 = this.app;
    Object localObject2 = paramg.mProcessName;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      com.tencent.e.j.a locala = com.tencent.e.j.a.aTF("ProfileFactoryImp_handlerThread");
      localObject2 = (String)new e.1(locale).b(new ao(locala));
      locala.KbG.quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        ac.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.d)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.ahL()))
        {
          ac.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        ac.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.f.bk(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.ca.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3582;
        }
      }
      label3369:
      label3552:
      label3582:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          ac.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.mProcessName, Long.valueOf(bs.Ap(com.tencent.mm.app.d.cIh)), Long.valueOf(bs.Ap(l)), Integer.valueOf(i), ah.GDu, com.tencent.mm.loader.j.b.apb() });
          if (paramg.ahL()) {
            com.tencent.mm.l.a.a.a(new com.tencent.mm.l.a()
            {
              public final String F(String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(22396);
                if (com.tencent.mm.al.f.so(paramAnonymousString))
                {
                  paramAnonymousString = com.tencent.mm.al.a.e.Bv(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramAnonymousInt).eul);
                  AppMethodBeat.o(22396);
                  return paramAnonymousString;
                }
                paramAnonymousString = bk.aze();
                AppMethodBeat.o(22396);
                return paramAnonymousString;
              }
              
              public final void n(bo paramAnonymousbo)
              {
                AppMethodBeat.i(22395);
                if (com.tencent.mm.al.f.so(paramAnonymousbo.field_talker))
                {
                  paramAnonymousbo.qf(com.tencent.mm.al.a.e.TG());
                  AppMethodBeat.o(22395);
                  return;
                }
                paramAnonymousbo.qf(bk.aze());
                AppMethodBeat.o(22395);
              }
              
              public final String o(bo paramAnonymousbo)
              {
                AppMethodBeat.i(22397);
                if (com.tencent.mm.al.f.so(paramAnonymousbo.field_talker))
                {
                  paramAnonymousbo = com.tencent.mm.al.a.e.Bv(paramAnonymousbo.eul);
                  AppMethodBeat.o(22397);
                  return paramAnonymousbo;
                }
                paramAnonymousbo = bk.aze();
                AppMethodBeat.o(22397);
                return paramAnonymousbo;
              }
              
              public final boolean so(String paramAnonymousString)
              {
                AppMethodBeat.i(22398);
                boolean bool = com.tencent.mm.al.f.so(paramAnonymousString);
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
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(paramAnonymousLong1, paramAnonymousLong2, 1L, false);
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
              boolean bool = com.tencent.mm.ui.base.b.bd(paramAnonymousActivity.getClass());
              AppMethodBeat.o(22405);
              return bool;
            }
            
            public final void yj(int paramAnonymousInt)
            {
              AppMethodBeat.i(22403);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1221L, paramAnonymousInt, 1L, false);
              AppMethodBeat.o(22403);
            }
          });
          if (paramg.ahL())
          {
            com.tencent.mm.modelfriend.a.hEn = new com.tencent.mm.modelfriend.a.a()
            {
              public final String aEG()
              {
                AppMethodBeat.i(22406);
                if (com.tencent.mm.sdk.platformtools.i.GqM)
                {
                  str = ai.getContext().getString(2131762749);
                  AppMethodBeat.o(22406);
                  return str;
                }
                String str = ai.getContext().getString(2131762748);
                AppMethodBeat.o(22406);
                return str;
              }
            };
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
                for (int i = com.tencent.mm.kernel.g.agU().eVl();; i = 0)
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
                for (;;)
                {
                  com.tencent.mm.model.d.b localb;
                  try
                  {
                    localb = com.tencent.mm.model.d.b.aAv();
                    boolean bool1 = ap.isMainThread();
                    String str1 = paramAnonymousSQLiteDatabase.getPath();
                    com.tencent.matrix.c.a.a(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousLong);
                    if (((paramAnonymousLong > localb.hrF) && (bool1)) || ((paramAnonymousLong > localb.hrH) && (!bool1)))
                    {
                      paramAnonymousSQLiteDatabase = com.tencent.mm.model.d.b.hrN.iterator();
                      if (paramAnonymousSQLiteDatabase.hasNext())
                      {
                        String str2 = (String)paramAnonymousSQLiteDatabase.next();
                        if (bool1) {
                          continue;
                        }
                        boolean bool2 = str1.contains(str2);
                        if (!bool2) {
                          continue;
                        }
                      }
                    }
                    else
                    {
                      AppMethodBeat.o(22407);
                      return;
                    }
                    if ((paramAnonymousInt == 2) && (bool1) && (paramAnonymousLong < localb.hrG)) {
                      continue;
                    }
                    if (localb.hrl) {
                      break label492;
                    }
                    paramAnonymousString = paramAnonymousString.trim().toUpperCase();
                    if ((!paramAnonymousString.startsWith("INSERT")) && (!paramAnonymousString.startsWith("UPDATE")) && (!paramAnonymousString.startsWith("DELETE")) && (!paramAnonymousString.startsWith("COMMIT")) && (!paramAnonymousString.startsWith("SELECT")))
                    {
                      paramAnonymousSQLiteDatabase = null;
                      if (!bs.isNullOrNil(paramAnonymousSQLiteDatabase))
                      {
                        paramAnonymousString = new StringBuilder();
                        com.tencent.mm.model.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), paramAnonymousString);
                        com.tencent.mm.model.d.b.a("sql", paramAnonymousSQLiteDatabase, paramAnonymousString);
                        com.tencent.mm.model.d.b.a("lastTime", String.valueOf(paramAnonymousLong), paramAnonymousString);
                        if (!com.tencent.mm.sdk.a.b.foreground) {
                          break label508;
                        }
                        paramAnonymousSQLiteDatabase = "1";
                        com.tencent.mm.model.d.b.a("foreground", paramAnonymousSQLiteDatabase, paramAnonymousString);
                        com.tencent.mm.model.d.b.a("tname", Thread.currentThread().getName(), paramAnonymousString);
                        paramAnonymousSQLiteDatabase = paramAnonymousString.toString();
                        ac.d("MicroMsg.SQLTraceManager", "SQL Trace mark : ".concat(String.valueOf(paramAnonymousSQLiteDatabase)));
                        az.agU().az(new b.3(localb, paramAnonymousSQLiteDatabase));
                      }
                      AppMethodBeat.o(22407);
                      return;
                    }
                  }
                  catch (Exception paramAnonymousSQLiteDatabase)
                  {
                    ac.printErrStackTrace("MicroMsg.SQLiteTrace", paramAnonymousSQLiteDatabase, "Failed to send trace.", new Object[0]);
                    AppMethodBeat.o(22407);
                    return;
                  }
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
                      if (paramAnonymousLong <= localb.hrI) {
                        break label503;
                      }
                      paramAnonymousSQLiteDatabase = paramAnonymousString + "task:" + bs.eWi();
                    }
                  }
                  label492:
                  ac.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                  continue;
                  label503:
                  paramAnonymousSQLiteDatabase = null;
                  continue;
                  label508:
                  paramAnonymousSQLiteDatabase = "0";
                }
              }
            });
            com.tencent.mm.storage.e.GBO = new com.tencent.mm.plugin.messenger.foundation.a.m()
            {
              public final String Z(bo paramAnonymousbo)
              {
                AppMethodBeat.i(22409);
                int i;
                if ((paramAnonymousbo.field_bizChatId != -1L) && (com.tencent.mm.al.f.so(paramAnonymousbo.field_talker)))
                {
                  i = 1;
                  if (i == 0) {
                    break label91;
                  }
                  paramAnonymousbo = paramAnonymousbo.field_talker + ":" + paramAnonymousbo.field_bizChatId;
                  ac.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { paramAnonymousbo });
                }
                for (;;)
                {
                  AppMethodBeat.o(22409);
                  return paramAnonymousbo;
                  i = 0;
                  break;
                  label91:
                  paramAnonymousbo = paramAnonymousbo.field_talker;
                }
              }
            };
            com.tencent.mm.model.x.a(new x.a()
            {
              public final boolean a(String paramAnonymousString1, String paramAnonymousString2, PInt paramAnonymousPInt)
              {
                AppMethodBeat.i(22410);
                if (w.wH(paramAnonymousString1))
                {
                  if (com.tencent.mm.al.f.so(paramAnonymousString1)) {
                    if (com.tencent.mm.al.a.e.Br(paramAnonymousString2)) {
                      paramAnonymousPInt.value = 5;
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(22410);
                    return true;
                    paramAnonymousPInt.value = 4;
                    continue;
                    if (com.tencent.mm.al.f.AQ(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 3;
                    } else if (com.tencent.mm.al.f.AR(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 0;
                    } else if (com.tencent.mm.al.f.AM(paramAnonymousString1)) {
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
            y.b(new com.tencent.mm.cn.c() {});
            paramg = new com.tencent.mm.modelmulti.a();
            u.a.a(69, paramg);
            u.a.a(68, paramg);
            u.a.a(22, paramg);
            u.a.a(13, paramg);
            u.a.a(15, paramg);
            u.a.a(23, paramg);
            u.a.a(25, paramg);
            u.a.a(24, paramg);
            u.a.a(33, paramg);
            u.a.a(35, paramg);
            u.a.a(44, paramg);
            u.a.a(999999, paramg);
            u.a.a(53, paramg);
            u.a.a(204, paramg);
            u.a.a(219, paramg);
            paramg = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.d.class)).addContactAssembler(paramg);
            com.tencent.mm.kernel.g.agi().a(681, paramg);
            com.tencent.mm.kernel.g.agi().a(681, this.deleteContactService);
            com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.f.a.class, this.deleteContactService);
            y.a(5, new m());
            y.a(1, new s());
            y.a(4, new h());
            ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new a());
            paramg = new n();
            ((t)com.tencent.mm.kernel.g.ab(t.class)).a(paramg);
            ((t)com.tencent.mm.kernel.g.ab(t.class)).a(paramg);
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new r().alive();
            com.tencent.mm.kernel.g.agi().b(138, o.nnU);
            com.tencent.mm.kernel.g.agi().b(39, o.nnU);
            com.tencent.mm.kernel.g.agi().b(268369922, o.nnU);
            if (o.nnU == null) {
              o.nnU = new o();
            }
            com.tencent.mm.kernel.g.agi().a(138, o.nnU);
            com.tencent.mm.kernel.g.agi().a(39, o.nnU);
            com.tencent.mm.kernel.g.agi().a(268369922, o.nnU);
            q.en(this.app);
            com.tencent.mm.az.a.a.a("delchatroommember", new p.1());
            com.tencent.mm.az.a.a.a("NewXmlChatRoomAccessVerifyApplication", new p.2());
            com.tencent.mm.az.a.a.a("NewXmlChatRoomAccessVerifyApproval", new p.3());
            com.tencent.mm.az.a.a.a("chatroommuteexpt", new p.4());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new p.5());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new p.6());
            ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new p.7());
            com.tencent.mm.az.a.a.a("invokeMessage", new b.1());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new b.2());
            br.axo();
            com.tencent.mm.model.n.axo();
            paramg = this.appMgr;
            localObject1 = this.app;
            if (paramg.HoD == null) {
              paramg.HoD = new MMAppMgr.Receiver(paramg);
            }
            MMActivity.setMainProcess();
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject2).addAction("MINIQB_OPEN_RET");
            ((Context)localObject1).registerReceiver(paramg.HoD, (IntentFilter)localObject2, "com.tencent.mm.permission.MM_MESSAGE", null);
            paramg = new com.tencent.mm.booter.x(com.tencent.mm.booter.d.bK(this.app));
            paramg.rq("MM");
            ab.ivM = bs.a(paramg.rr(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            ab.iuU = bs.a(paramg.rr(".com.tencent.mm.debug.test.display_errcode"), false);
            ab.iuV = bs.a(paramg.rr(".com.tencent.mm.debug.test.display_msgstate"), false);
            ab.iuW = bs.a(paramg.rr(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            ab.iuX = bs.a(paramg.rr(".com.tencent.mm.debug.test.network.force_touch"), false);
            ab.iuY = bs.a(paramg.rr(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            ab.iuZ = bs.a(paramg.rr(".com.tencent.mm.debug.test.crashIsExit"), false);
            ab.ivy = bs.getInt(bs.bG(paramg.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            ab.ivz = bs.getInt(bs.bG(paramg.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            ab.ivb = bs.a(paramg.rr(".com.tencent.mm.debug.test.album_drop_table"), false);
            ab.ivc = bs.a(paramg.rr(".com.tencent.mm.debug.test.album_dle_file"), false);
            ab.ivd = bs.a(paramg.rr(".com.tencent.mm.debug.test.album_show_info"), false);
            ab.ive = bs.a(paramg.rr(".com.tencent.mm.debug.test.location_help"), false);
            ab.ivh = bs.a(paramg.rr(".com.tencent.mm.debug.test.force_soso"), false);
            ab.ivi = bs.a(paramg.rr(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            ab.ivj = bs.a(paramg.rr(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            ab.ivk = bs.a(paramg.rr(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            ab.ivn = bs.a(paramg.rr(".com.tencent.mm.debug.test.filterfpnp"), false);
            ab.ivo = bs.a(paramg.rr(".com.tencent.mm.debug.test.testForPull"), false);
            i = bs.a(paramg.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            ab.ivl = i;
            if ((i != 4) && (ab.ivl > 0))
            {
              com.tencent.mm.storage.ag.GDs = ab.ivl;
              ac.e("MicroMsg.WorkerDebugger", "cdn thread num " + ab.ivl);
            }
            ab.ivm = bs.a(paramg.rr(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            ab.ivp = bs.bG(paramg.getString(".com.tencent.mm.debug.server.host.http"), "");
            ab.ivq = bs.bG(paramg.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bs.a(paramg.rr(".com.tencent.mm.debug.test.show_full_version"), false)) {
              com.tencent.mm.sdk.platformtools.i.GqJ = true;
            }
          }
          try
          {
            i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.XE(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception paramg)
          {
            try
            {
              localObject1 = paramg.getString(".com.tencent.mm.debug.log.setapilevel");
              if (!bs.isNullOrNil((String)localObject1))
              {
                com.tencent.mm.protocal.d.gMK = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.DHY = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.DIa = String.valueOf(localObject1);
                com.tencent.mm.sdk.a.b.aKr((String)localObject1);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.gMK).append(" ").append(com.tencent.mm.sdk.a.b.eUl());
              }
            }
            catch (Exception paramg)
            {
              try
              {
                l = Long.decode(paramg.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.DIb).append(" new: ").append(l);
                com.tencent.mm.protocal.d.DIb = l;
              }
              catch (Exception paramg)
              {
                try
                {
                  i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  paramg.fnq.flW = i;
                }
                catch (Exception paramg)
                {
                  try
                  {
                    boolean bool1 = bs.a(paramg.rr(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = bs.a(paramg.rr(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = bs.a(paramg.rr(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = bs.a(paramg.rr(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.b.c.d(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    ab.ivt = bs.a(paramg.rr(".com.tencent.mm.debug.test.update_test"), false);
                    ab.ivu = bs.a(paramg.rr(".com.tencent.mm.debug.test.scan_save_image"), false);
                    ab.ivw = bs.a(paramg.rr(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    ab.ivx = bs.a(paramg.rr(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    ab.ivB = bs.bG(paramg.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    ac.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + ab.ivB);
                    ab.ivQ = bs.bG(paramg.getString(".com.tencent.mm.debug.cdn.front"), "");
                    ab.ivR = bs.bG(paramg.getString(".com.tencent.mm.debug.cdn.zone"), "");
                    ab.ivS = bs.bG(paramg.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    ab.ivT = bs.bG(paramg.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    ab.ivU = bs.bG(paramg.getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    ab.ivV = bs.a(paramg.rr(".com.tencent.mm.debug.cdn.usestream"), false);
                    ab.ivW = bs.a(paramg.rr(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    ab.ivX = bs.a(paramg.rr(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    ab.ivZ = bs.a(paramg.rr(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    ab.iwa = bs.a(paramg.rr(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    ab.iwb = bs.a(paramg.rr(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    ab.iwj = bs.a(paramg.rr(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    ac.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + ab.iwj);
                    ab.iwk = bs.bG(paramg.getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    ab.iwl = bs.getInt(bs.bG(paramg.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    ab.iwg = bs.a(paramg.rr(".com.tencent.mm.debug.cursormode_enabled"), true);
                    ab.iwP = bs.a(paramg.rr(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    ab.iwQ = bs.a(paramg.rr(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    ab.iwR = bs.a(paramg.rr(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    ab.iwz = bs.a(paramg.rr(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    ab.iwB = bs.bG(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    ab.iwA = bs.a(paramg.rr(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    ab.iwC = bs.bG(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    ab.iwJ = bs.a(paramg.rr(".com.tencent.mm.debug.netmock"), false);
                    paramg = bs.jc(ai.getContext());
                    if ((paramg != null) && (paramg.getPackageName().equals(ai.getPackageName())) && (paramg.getClassName().equals(ai.eUV())))
                    {
                      WorkerProfile.Lr().cKC = true;
                      WorkerProfile.Lr().cKD = true;
                      ac.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                      com.tencent.mm.model.d.b.aAv();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(ai.getContext()));
                      SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.j());
                      com.tencent.mm.plugin.report.service.j.wUQ = (WorkerProfile)this.mProfileCompat;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.sC("wechatbase");
                      paramg = com.tencent.mm.sdk.a.GpP;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.sC(paramg);
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.sC("wechatmm");
                    }
                  }
                  catch (Exception paramg)
                  {
                    try
                    {
                      Mars.onCreate();
                      if (ai.cin()) {
                        SmcLogic.onCreate();
                      }
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.b.c.wTf);
                      if (getClass().getClassLoader() == null)
                      {
                        i = -1;
                        if (Thread.currentThread().getContextClassLoader() != null) {
                          break label3552;
                        }
                        j = -1;
                        ac.i("MicroMsg.PluginBigBallOfMud", "SmcLogic, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                      }
                    }
                    catch (Throwable paramg)
                    {
                      try
                      {
                        for (;;)
                        {
                          if (com.tencent.mm.compatible.util.d.la(20))
                          {
                            ac.i("MicroMsg.PluginBigBallOfMud", "weird");
                            SmcLogic.setUin(0L);
                          }
                          paramg = (com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
                          localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
                          new com.tencent.mm.plugin.e.d().after(paramg).before(this);
                          localObject2 = (com.tencent.mm.plugin.e.b)new com.tencent.mm.plugin.e.b().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.f().after((com.tencent.mm.kernel.b.a)localObject2).before(this);
                          new com.tencent.mm.plugin.e.c().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.a().after((com.tencent.mm.kernel.b.a)localObject1);
                          com.tencent.mm.br.d.eQC();
                          com.tencent.mm.ui.chatting.f.a.cVE();
                          com.tencent.mm.pluginsdk.h.a.a.m.a(new com.tencent.mm.pluginsdk.h.a.a.a.a()
                          {
                            public final boolean yi(int paramAnonymousInt)
                            {
                              AppMethodBeat.i(22385);
                              if ((paramAnonymousInt == 39) && (!com.tencent.mm.plugin.ipcall.d.cTZ()))
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
                          com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
                          AppMethodBeat.o(22414);
                          return;
                          ai.setProcessName((String)localObject2);
                          if (((String)localObject2).equals(ai.getPackageName())) {
                            localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.WorkerProfile");
                          }
                          for (;;)
                          {
                            ac.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                            break;
                            if (((String)localObject2).equals(ai.getPackageName() + ":push"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.PusherProfile");
                            }
                            else if (((String)localObject2).startsWith(ai.getPackageName() + ":tools"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.ToolsProfile");
                            }
                            else if (((String)localObject2).equals(ai.getPackageName() + ":sandbox"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.SandBoxProfile");
                            }
                            else if (((String)localObject2).equals(ai.getPackageName() + ":exdevice"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.ExDeviceProfile");
                            }
                            else if (((String)localObject2).equals(ai.getPackageName() + ":TMAssistantDownloadSDKService"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.TMAssistantProfile");
                            }
                            else if (((String)localObject2).equals(ai.getPackageName() + ":nospace"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.NoSpaceProfile");
                            }
                            else if (((String)localObject2).equals(ai.getPackageName() + ":patch"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.PatchProfile");
                            }
                            else if (((String)localObject2).startsWith(ai.getPackageName() + ":appbrand"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.AppBrandProfile");
                            }
                            else if (((String)localObject2).startsWith(ai.getPackageName() + ":support"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.SupportProfile");
                            }
                            else
                            {
                              if (!((String)localObject2).startsWith(ai.getPackageName() + ":lite")) {
                                break label3369;
                              }
                              localObject1 = com.tencent.mm.compatible.loader.e.c((Application)localObject1, ".app.LiteAppProfile");
                            }
                          }
                          com.tencent.mm.sdk.a.b.N("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                          localObject1 = null;
                          break;
                          localException1 = localException1;
                          ac.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException2 = localException2;
                          ac.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException3 = localException3;
                          ac.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException4 = localException4;
                          ac.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException5 = localException5;
                          ac.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          if (paramg != null) {
                            ac.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                          }
                          while ((paramg != null) && (!paramg.getPackageName().equals(ai.getPackageName())))
                          {
                            WorkerProfile.Lr().cKC = true;
                            break;
                            ac.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
                          }
                          paramg = paramg;
                          Mars.onCreate();
                          if (ai.cin())
                          {
                            SmcLogic.onCreate();
                            continue;
                            i = getClass().getClassLoader().hashCode();
                          }
                        }
                        int j = Thread.currentThread().getContextClassLoader().hashCode();
                      }
                      catch (Throwable paramg)
                      {
                        for (;;)
                        {
                          ac.printErrStackTrace("MicroMsg.PluginBigBallOfMud", paramg, "", new Object[0]);
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
    if (ai.cin())
    {
      dependsOn(com.tencent.mm.plugin.auth.a.b.class);
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    }
    AppMethodBeat.o(22413);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(22416);
    if ((aj.fhJ()) && (aj.fhE()))
    {
      XWalkEnvironment.setForceDarkMode(aj.i(paramConfiguration));
      MMWebView.xW(aj.i(paramConfiguration));
      if (ai.cin())
      {
        if (com.tencent.mm.cd.c.h(paramConfiguration))
        {
          ac.i("MicroMsg.PluginBigBallOfMud", "dancy test uiModeChange true, uimode:%s", new Object[] { Integer.valueOf(paramConfiguration.uiMode) });
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          com.tencent.mm.modelappbrand.a.b.aAS().clearCache();
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null)
          {
            ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).onAccountRelease();
            ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).bFL();
            if (com.tencent.mm.kernel.g.agP().afY())
            {
              localObject = com.tencent.mm.plugin.voip.c.ehc();
              if (((com.tencent.mm.plugin.voip.ui.d)localObject).AKy != null) {
                ((com.tencent.mm.plugin.voip.ui.d)localObject).AKy.elA();
              }
            }
          }
        }
        com.tencent.mm.cd.c.a(paramConfiguration, aj.DT());
        if (ai.getContext().getResources() != null) {
          ai.getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
        }
      }
    }
    Object localObject = ai.getResources();
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
    ac.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { ai.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.HoD != null) {
      localApplication.unregisterReceiver(localMMAppMgr.HoD);
    }
    AppMethodBeat.o(22415);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(22417);
    ac.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), ai.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
    Object localObject = com.tencent.mm.memory.a.a.b.awc();
    ac.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).heD.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).awd();
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