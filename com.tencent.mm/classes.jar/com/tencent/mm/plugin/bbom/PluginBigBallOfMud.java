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
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.d.b.3;
import com.tencent.mm.model.q.1;
import com.tencent.mm.model.q.2;
import com.tencent.mm.model.q.3;
import com.tencent.mm.model.q.4;
import com.tencent.mm.model.q.5;
import com.tencent.mm.model.q.6;
import com.tencent.mm.model.q.7;
import com.tencent.mm.model.q.8;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x.a;
import com.tencent.mm.plugin.voip.ui.VoipViewFragment;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.b.a;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.j.b.1;
import com.tencent.mm.ui.chatting.j.b.2;
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
        com.tencent.mm.plugin.report.e.ywz.f(14976, new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString1, paramAnonymousString2 });
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
    ae.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.ca;
    ae.i("MicroMsg.PluginBigBallOfMud", "app. %s", new Object[] { this.app });
    com.tencent.mm.modelstat.d.i(this.app);
    ae.i("MicroMsg.PluginBigBallOfMud", "ClickFlowStatSender registerActivityLifeCycle");
    long l = System.currentTimeMillis();
    com.tencent.mm.compatible.loader.e locale = new com.tencent.mm.compatible.loader.e();
    localObject1 = this.app;
    Object localObject2 = paramg.mProcessName;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      com.tencent.e.j.a locala = com.tencent.e.j.a.bbi("ProfileFactoryImp_handlerThread");
      localObject2 = (String)new e.1(locale).b(new aq(locala));
      locala.Msx.quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        ae.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.d)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.akL()))
        {
          ae.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        ae.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.f.bl(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.ca.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3625;
        }
      }
      label3595:
      label3625:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          ae.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.mProcessName, Long.valueOf(com.tencent.mm.sdk.platformtools.bu.DD(com.tencent.mm.app.d.cUa)), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.DD(l)), Integer.valueOf(i), am.IKh, com.tencent.mm.loader.j.b.asd() });
          if (paramg.akL()) {
            com.tencent.mm.m.a.a.a(new com.tencent.mm.m.a()
            {
              public final String J(String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(22396);
                if (com.tencent.mm.al.g.vz(paramAnonymousString))
                {
                  paramAnonymousString = com.tencent.mm.al.a.e.EW(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramAnonymousInt).eNd);
                  AppMethodBeat.o(22396);
                  return paramAnonymousString;
                }
                paramAnonymousString = bn.aCy();
                AppMethodBeat.o(22396);
                return paramAnonymousString;
              }
              
              public final void n(bv paramAnonymousbv)
              {
                AppMethodBeat.i(22395);
                if (com.tencent.mm.al.g.vz(paramAnonymousbv.field_talker))
                {
                  paramAnonymousbv.tk(com.tencent.mm.al.a.e.We());
                  AppMethodBeat.o(22395);
                  return;
                }
                paramAnonymousbv.tk(bn.aCy());
                AppMethodBeat.o(22395);
              }
              
              public final String o(bv paramAnonymousbv)
              {
                AppMethodBeat.i(22397);
                if (com.tencent.mm.al.g.vz(paramAnonymousbv.field_talker))
                {
                  paramAnonymousbv = com.tencent.mm.al.a.e.EW(paramAnonymousbv.eNd);
                  AppMethodBeat.o(22397);
                  return paramAnonymousbv;
                }
                paramAnonymousbv = bn.aCy();
                AppMethodBeat.o(22397);
                return paramAnonymousbv;
              }
              
              public final boolean vz(String paramAnonymousString)
              {
                AppMethodBeat.i(22398);
                boolean bool = com.tencent.mm.al.g.vz(paramAnonymousString);
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
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(paramAnonymousLong1, paramAnonymousLong2, 1L, false);
              AppMethodBeat.o(22402);
            }
          });
          com.tencent.mm.sdk.platformtools.b.a(new b.a()
          {
            public final void M(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22404);
              com.tencent.mm.ui.base.b.bj(paramAnonymousActivity);
              AppMethodBeat.o(22404);
            }
            
            public final boolean N(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22405);
              boolean bool = com.tencent.mm.ui.base.b.bf(paramAnonymousActivity.getClass());
              AppMethodBeat.o(22405);
              return bool;
            }
            
            public final void zc(int paramAnonymousInt)
            {
              AppMethodBeat.i(22403);
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(1221L, paramAnonymousInt, 1L, false);
              AppMethodBeat.o(22403);
            }
          });
          if (paramg.akL())
          {
            com.tencent.mm.modelfriend.a.hZK = new com.tencent.mm.modelfriend.a.a()
            {
              public final String aIc()
              {
                AppMethodBeat.i(22406);
                if (k.IwL)
                {
                  str = ak.getContext().getString(2131762749);
                  AppMethodBeat.o(22406);
                  return str;
                }
                String str = ak.getContext().getString(2131762748);
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
                for (int i = com.tencent.mm.kernel.g.ajU().foN();; i = 0)
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
                    localb = com.tencent.mm.model.d.b.aDO();
                    boolean bool1 = ar.isMainThread();
                    String str1 = paramAnonymousSQLiteDatabase.getPath();
                    com.tencent.matrix.c.a.a(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousLong);
                    if (((paramAnonymousLong > localb.hMQ) && (bool1)) || ((paramAnonymousLong > localb.hMS) && (!bool1)))
                    {
                      paramAnonymousSQLiteDatabase = com.tencent.mm.model.d.b.hMY.iterator();
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
                    if ((paramAnonymousInt == 2) && (bool1) && (paramAnonymousLong < localb.hMR)) {
                      continue;
                    }
                    if (localb.hMw) {
                      break label492;
                    }
                    paramAnonymousString = paramAnonymousString.trim().toUpperCase();
                    if ((!paramAnonymousString.startsWith("INSERT")) && (!paramAnonymousString.startsWith("UPDATE")) && (!paramAnonymousString.startsWith("DELETE")) && (!paramAnonymousString.startsWith("COMMIT")) && (!paramAnonymousString.startsWith("SELECT")))
                    {
                      paramAnonymousSQLiteDatabase = null;
                      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramAnonymousSQLiteDatabase))
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
                        ae.d("MicroMsg.SQLTraceManager", "SQL Trace mark : ".concat(String.valueOf(paramAnonymousSQLiteDatabase)));
                        bc.ajU().aw(new b.3(localb, paramAnonymousSQLiteDatabase));
                      }
                      AppMethodBeat.o(22407);
                      return;
                    }
                  }
                  catch (Exception paramAnonymousSQLiteDatabase)
                  {
                    ae.printErrStackTrace("MicroMsg.SQLiteTrace", paramAnonymousSQLiteDatabase, "Failed to send trace.", new Object[0]);
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
                      if (paramAnonymousLong <= localb.hMT) {
                        break label503;
                      }
                      paramAnonymousSQLiteDatabase = paramAnonymousString + "task:" + com.tencent.mm.sdk.platformtools.bu.fpN();
                    }
                  }
                  label492:
                  ae.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                  continue;
                  label503:
                  paramAnonymousSQLiteDatabase = null;
                  continue;
                  label508:
                  paramAnonymousSQLiteDatabase = "0";
                }
              }
            });
            com.tencent.mm.storage.e.IHT = new com.tencent.mm.plugin.messenger.foundation.a.n()
            {
              public final String ab(bv paramAnonymousbv)
              {
                AppMethodBeat.i(22409);
                int i;
                if ((paramAnonymousbv.field_bizChatId != -1L) && (com.tencent.mm.al.g.vz(paramAnonymousbv.field_talker)))
                {
                  i = 1;
                  if (i == 0) {
                    break label91;
                  }
                  paramAnonymousbv = paramAnonymousbv.field_talker + ":" + paramAnonymousbv.field_bizChatId;
                  ae.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { paramAnonymousbv });
                }
                for (;;)
                {
                  AppMethodBeat.o(22409);
                  return paramAnonymousbv;
                  i = 0;
                  break;
                  label91:
                  paramAnonymousbv = paramAnonymousbv.field_talker;
                }
              }
            };
            y.a(new y.a()
            {
              public final boolean a(String paramAnonymousString1, String paramAnonymousString2, PInt paramAnonymousPInt)
              {
                AppMethodBeat.i(22410);
                if (com.tencent.mm.model.x.Ao(paramAnonymousString1))
                {
                  if (com.tencent.mm.al.g.vz(paramAnonymousString1)) {
                    if (com.tencent.mm.al.a.e.ES(paramAnonymousString2)) {
                      paramAnonymousPInt.value = 5;
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(22410);
                    return true;
                    paramAnonymousPInt.value = 4;
                    continue;
                    if (com.tencent.mm.al.g.Er(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 3;
                    } else if (com.tencent.mm.al.g.Es(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 0;
                    } else if (com.tencent.mm.al.g.En(paramAnonymousString1)) {
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
            ab.b(new com.tencent.mm.cm.c() {});
            paramg = new com.tencent.mm.modelmulti.a();
            x.a.a(69, paramg);
            x.a.a(68, paramg);
            x.a.a(22, paramg);
            x.a.a(13, paramg);
            x.a.a(15, paramg);
            x.a.a(23, paramg);
            x.a.a(25, paramg);
            x.a.a(24, paramg);
            x.a.a(33, paramg);
            x.a.a(35, paramg);
            x.a.a(44, paramg);
            x.a.a(999999, paramg);
            x.a.a(53, paramg);
            x.a.a(204, paramg);
            x.a.a(219, paramg);
            paramg = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.e.class)).addContactAssembler(paramg);
            com.tencent.mm.kernel.g.ajj().a(681, paramg);
            com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.h.a.class, this.deleteContactService);
            ab.a(5, new n());
            ab.a(1, new t());
            ab.a(4, new i());
            ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new a());
            paramg = new o();
            ((w)com.tencent.mm.kernel.g.ab(w.class)).a(paramg);
            ((w)com.tencent.mm.kernel.g.ab(w.class)).a(paramg);
            ((w)com.tencent.mm.kernel.g.ab(w.class)).a(new h());
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new s().alive();
            com.tencent.mm.kernel.g.ajj().b(138, p.nUo);
            com.tencent.mm.kernel.g.ajj().b(39, p.nUo);
            com.tencent.mm.kernel.g.ajj().b(268369922, p.nUo);
            if (p.nUo == null) {
              p.nUo = new p();
            }
            com.tencent.mm.kernel.g.ajj().a(138, p.nUo);
            com.tencent.mm.kernel.g.ajj().a(39, p.nUo);
            com.tencent.mm.kernel.g.ajj().a(268369922, p.nUo);
            r.er(this.app);
            com.tencent.mm.az.a.a.a("delchatroommember", new q.1());
            com.tencent.mm.az.a.a.a("NewXmlChatRoomAccessVerifyApplication", new q.2());
            com.tencent.mm.az.a.a.a("NewXmlChatRoomAccessVerifyApproval", new q.3());
            com.tencent.mm.az.a.a.a("chatroommuteexpt", new q.4());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new q.5());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new q.6());
            com.tencent.mm.az.a.a.a("FinderPersonalMsgSysMsg", new q.7());
            ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new q.8());
            com.tencent.mm.az.a.a.a("invokeMessage", new b.1());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new b.2());
            com.tencent.mm.model.bu.aAt();
            com.tencent.mm.model.n.aAt();
            paramg = this.appMgr;
            localObject1 = this.app;
            if (paramg.JwT == null) {
              paramg.JwT = new MMAppMgr.Receiver(paramg);
            }
            MMActivity.setMainProcess();
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject2).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject2).addAction("MINIQB_OPEN_RET");
            ((Context)localObject1).registerReceiver(paramg.JwT, (IntentFilter)localObject2, "com.tencent.mm.permission.MM_MESSAGE", null);
            paramg = new com.tencent.mm.booter.x(com.tencent.mm.booter.d.bL(this.app));
            paramg.ux("MM");
            ac.iRN = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            ac.iQV = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.display_errcode"), false);
            ac.iQW = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.display_msgstate"), false);
            ac.iQX = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            ac.iQY = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.network.force_touch"), false);
            ac.iQZ = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            ac.iRa = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.crashIsExit"), false);
            ac.iRz = com.tencent.mm.sdk.platformtools.bu.getInt(com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            ac.iRA = com.tencent.mm.sdk.platformtools.bu.getInt(com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            ac.iRc = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.album_drop_table"), false);
            ac.iRd = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.album_dle_file"), false);
            ac.iRe = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.album_show_info"), false);
            ac.iRf = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.location_help"), false);
            ac.iRi = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.force_soso"), false);
            ac.iRj = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            ac.iRk = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            ac.iRl = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            ac.iRo = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.filterfpnp"), false);
            ac.iRp = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.testForPull"), false);
            i = com.tencent.mm.sdk.platformtools.bu.a(paramg.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            ac.iRm = i;
            if ((i != 4) && (ac.iRm > 0))
            {
              com.tencent.mm.storage.al.IKf = ac.iRm;
              ae.e("MicroMsg.WorkerDebugger", "cdn thread num " + ac.iRm);
            }
            ac.iRn = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            ac.iRq = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.server.host.http"), "");
            ac.iRr = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.show_full_version"), false)) {
              k.IwI = true;
            }
          }
          try
          {
            i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aag(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception paramg)
          {
            try
            {
              localObject1 = paramg.getString(".com.tencent.mm.debug.log.setapilevel");
              if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject1))
              {
                com.tencent.mm.protocal.d.hjv = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.FFD = "android-".concat(String.valueOf(localObject1));
                com.tencent.mm.protocal.d.FFF = String.valueOf(localObject1);
                com.tencent.mm.sdk.a.b.aRu((String)localObject1);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hjv).append(" ").append(com.tencent.mm.sdk.a.b.fnG());
              }
            }
            catch (Exception paramg)
            {
              try
              {
                l = Long.decode(paramg.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.FFG).append(" new: ").append(l);
                com.tencent.mm.protocal.d.FFG = l;
              }
              catch (Exception paramg)
              {
                try
                {
                  i = Integer.decode(paramg.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  paramg.fHC.fGh = i;
                }
                catch (Exception paramg)
                {
                  try
                  {
                    boolean bool1 = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    ac.iRu = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.update_test"), false);
                    ac.iRv = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.scan_save_image"), false);
                    ac.iRx = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    ac.iRy = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    ac.iRC = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    ae.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + ac.iRC);
                    ac.iRR = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.cdn.front"), "");
                    ac.iRS = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.cdn.zone"), "");
                    ac.iRT = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    ac.iRU = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    ac.iRV = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    ac.iRW = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cdn.usestream"), false);
                    ac.iRX = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    ac.iRY = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    ac.iSa = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    ac.iSb = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    ac.iSc = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    ac.iSk = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    ae.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + ac.iSk);
                    ac.iSl = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    ac.iSm = com.tencent.mm.sdk.platformtools.bu.getInt(com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    ac.iSh = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.cursormode_enabled"), true);
                    ac.iSR = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    ac.iSS = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    ac.iST = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    ac.iSA = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    ac.iSC = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    ac.iSB = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    ac.iSD = com.tencent.mm.sdk.platformtools.bu.bI(paramg.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    ac.iSK = com.tencent.mm.sdk.platformtools.bu.a(paramg.uy(".com.tencent.mm.debug.netmock"), false);
                    paramg = com.tencent.mm.sdk.platformtools.bu.js(ak.getContext());
                    if ((paramg != null) && (paramg.getPackageName().equals(ak.getPackageName())) && (paramg.getClassName().equals(ak.fou())))
                    {
                      WorkerProfile.MU().cWM = true;
                      WorkerProfile.MU().cWN = true;
                      ae.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                      com.tencent.mm.model.d.b.aDO();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(ak.getContext()));
                      SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.i());
                      com.tencent.mm.plugin.report.service.i.yyn = (WorkerProfile)this.mProfileCompat;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.vN("wechatbase");
                      paramg = com.tencent.mm.sdk.a.IvK;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.vN(paramg);
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.vN("wechatmm");
                    }
                  }
                  catch (Exception paramg)
                  {
                    try
                    {
                      Mars.onCreate();
                      if (ak.coh()) {
                        SmcLogic.onCreate();
                      }
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.ywG);
                      if (getClass().getClassLoader() == null)
                      {
                        i = -1;
                        if (Thread.currentThread().getContextClassLoader() != null) {
                          break label3595;
                        }
                        j = -1;
                        ae.i("MicroMsg.PluginBigBallOfMud", "SmcLogic, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                      }
                    }
                    catch (Throwable paramg)
                    {
                      try
                      {
                        for (;;)
                        {
                          if (com.tencent.mm.compatible.util.d.lB(20))
                          {
                            ae.i("MicroMsg.PluginBigBallOfMud", "weird");
                            SmcLogic.setUin(0L);
                          }
                          paramg = (com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class);
                          localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.zero.a.d.class);
                          new com.tencent.mm.plugin.e.d().after(paramg).before(this);
                          localObject2 = (com.tencent.mm.plugin.e.b)new com.tencent.mm.plugin.e.b().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.f().after((com.tencent.mm.kernel.b.a)localObject2).before(this);
                          new com.tencent.mm.plugin.e.c().after(paramg).before(this);
                          new com.tencent.mm.plugin.e.a().after((com.tencent.mm.kernel.b.a)localObject1);
                          com.tencent.mm.br.d.fjw();
                          com.tencent.mm.ui.chatting.g.a.dhH();
                          com.tencent.mm.pluginsdk.j.a.a.m.a(new com.tencent.mm.pluginsdk.j.a.a.a.a()
                          {
                            public final boolean zb(int paramAnonymousInt)
                            {
                              AppMethodBeat.i(22385);
                              if ((paramAnonymousInt == 39) && (!com.tencent.mm.plugin.ipcall.d.dgc()))
                              {
                                AppMethodBeat.o(22385);
                                return true;
                              }
                              AppMethodBeat.o(22385);
                              return false;
                            }
                          });
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          k.c.a(new com.tencent.mm.cm.c() {});
                          com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
                          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.modelsimple.b());
                          AppMethodBeat.o(22414);
                          return;
                          if (((String)localObject2).equals(ak.getPackageName())) {
                            localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.WorkerProfile");
                          }
                          for (;;)
                          {
                            ae.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                            break;
                            if (((String)localObject2).equals(ak.getPackageName() + ":push"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.PusherProfile");
                            }
                            else if (((String)localObject2).startsWith(ak.getPackageName() + ":tools"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.ToolsProfile");
                            }
                            else if (((String)localObject2).equals(ak.getPackageName() + ":sandbox"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.SandBoxProfile");
                            }
                            else if (((String)localObject2).equals(ak.getPackageName() + ":exdevice"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.ExDeviceProfile");
                            }
                            else if (((String)localObject2).equals(ak.getPackageName() + ":TMAssistantDownloadSDKService"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.TMAssistantProfile");
                            }
                            else if (((String)localObject2).equals(ak.getPackageName() + ":nospace"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.NoSpaceProfile");
                            }
                            else if (((String)localObject2).equals(ak.getPackageName() + ":patch"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.PatchProfile");
                            }
                            else if (((String)localObject2).startsWith(ak.getPackageName() + ":appbrand"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.AppBrandProfile");
                            }
                            else if (((String)localObject2).startsWith(ak.getPackageName() + ":support"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.SupportProfile");
                            }
                            else
                            {
                              if (!((String)localObject2).startsWith(ak.getPackageName() + ":lite")) {
                                break label3421;
                              }
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.LiteAppProfile");
                            }
                          }
                          label3421:
                          localObject1 = null;
                          break;
                          localException1 = localException1;
                          ae.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException2 = localException2;
                          ae.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException3 = localException3;
                          ae.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException4 = localException4;
                          ae.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          localException5 = localException5;
                          ae.i("MicroMsg.WorkerDebugger", "no debugger was got");
                          continue;
                          if (paramg != null) {
                            ae.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { paramg.getPackageName(), paramg.getClassName() });
                          }
                          while ((paramg != null) && (!paramg.getPackageName().equals(ak.getPackageName())))
                          {
                            WorkerProfile.MU().cWM = true;
                            break;
                            ae.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
                          }
                          paramg = paramg;
                          Mars.onCreate();
                          if (ak.coh())
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
                          ae.printErrStackTrace("MicroMsg.PluginBigBallOfMud", paramg, "", new Object[0]);
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
    if (ak.coh())
    {
      dependsOn(com.tencent.mm.plugin.auth.a.b.class);
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    }
    AppMethodBeat.o(22413);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(22416);
    if ((al.fCb()) && (al.fBV()))
    {
      XWalkEnvironment.setForceDarkMode(al.i(paramConfiguration));
      MMWebView.yY(al.i(paramConfiguration));
      if (ak.coh())
      {
        if (com.tencent.mm.cc.c.h(paramConfiguration))
        {
          ae.i("MicroMsg.PluginBigBallOfMud", "dancy test uiModeChange true, uimode:%s", new Object[] { Integer.valueOf(paramConfiguration.uiMode) });
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          com.tencent.mm.modelappbrand.a.b.aEl().clearCache();
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null)
          {
            ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).onAccountRelease();
            ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).bKT();
            if (com.tencent.mm.kernel.g.ajP().aiZ())
            {
              localObject = com.tencent.mm.plugin.voip.c.eyt();
              if (((com.tencent.mm.plugin.voip.ui.d)localObject).CBe != null)
              {
                localObject = ((com.tencent.mm.plugin.voip.ui.d)localObject).CBe;
                BaseSmallView localBaseSmallView = ((VoipViewFragment)localObject).CBM;
                if (localBaseSmallView != null) {
                  localBaseSmallView.eCS();
                }
                localObject = ((VoipViewFragment)localObject).CBL;
                if (localObject != null) {
                  ((BaseSmallView)localObject).eCS();
                }
              }
            }
          }
        }
        com.tencent.mm.cc.c.a(paramConfiguration, al.isDarkMode());
        if (ak.getContext().getResources() != null) {
          ak.getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
        }
      }
    }
    Object localObject = ak.getResources();
    if ((localObject instanceof com.tencent.mm.cc.b)) {
      ((com.tencent.mm.cc.b)localObject).onConfigurationChanged(paramConfiguration);
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
    ae.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { ak.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.JwT != null) {
      localApplication.unregisterReceiver(localMMAppMgr.JwT);
    }
    AppMethodBeat.o(22415);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(22417);
    ae.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), ak.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
    Object localObject = com.tencent.mm.memory.a.a.b.aze();
    ae.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).hzz.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).azf();
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