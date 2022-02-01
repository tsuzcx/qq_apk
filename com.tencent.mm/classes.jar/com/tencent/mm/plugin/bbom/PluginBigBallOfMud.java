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
import com.tencent.mm.ag.k.c;
import com.tencent.mm.api.v;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.e.a;
import com.tencent.mm.booter.e.b;
import com.tencent.mm.booter.e.c;
import com.tencent.mm.compatible.loader.e.1;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.live.b.y;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.ac.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.by;
import com.tencent.mm.model.cj;
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
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x.a;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.voip.ui.VoipViewFragment;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.AndroidOSafety.ISafetyCallback;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.j.b.1;
import com.tencent.mm.ui.chatting.j.b.2;
import com.tencent.mm.ui.chatting.multitask.uic.FileMultiTaskUIC;
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
        com.tencent.mm.plugin.report.e.Cxv.a(14976, new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(22384);
      }
    });
    MMReceivers.ToolsProcessReceiver.a(new e.c());
    MMReceivers.ToolsMpProcessReceiver.a(new e.a());
    MMReceivers.SandBoxProcessReceiver.a(new e.b());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new l());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new q());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new g());
    Log.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = paramg.ca;
    Log.i("MicroMsg.PluginBigBallOfMud", "app. %s", new Object[] { this.app });
    com.tencent.mm.modelstat.d.h(this.app);
    Log.i("MicroMsg.PluginBigBallOfMud", "ClickFlowStatSender registerActivityLifeCycle");
    long l = System.currentTimeMillis();
    Object localObject3 = new com.tencent.mm.compatible.loader.e();
    localObject1 = this.app;
    Object localObject2 = paramg.mProcessName;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      com.tencent.f.j.a locala = com.tencent.f.j.a.bqt("ProfileFactoryImp_handlerThread");
      localObject2 = (String)new e.1((com.tencent.mm.compatible.loader.e)localObject3).exec(new MMHandler(locala));
      locala.RUS.quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        Log.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.d)localObject1);
        if ((this.mProfileCompat != null) && (!paramg.aBb()))
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        Log.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        com.tencent.mm.app.f.bF(this.app.getApplicationContext());
        ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat = this.mProfileCompat;
        localObject1 = paramg.ca.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3862;
        }
      }
      label3862:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0) {
        for (;;)
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { paramg.mProcessName, Long.valueOf(Util.milliSecondsToNow(com.tencent.mm.app.d.dkt)), Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(i), ar.NSe, com.tencent.mm.loader.j.b.aKD() });
          if (paramg.aBb()) {
            com.tencent.mm.m.a.a.a(new com.tencent.mm.m.a()
            {
              public final boolean DQ(String paramAnonymousString)
              {
                AppMethodBeat.i(22398);
                boolean bool = com.tencent.mm.al.g.DQ(paramAnonymousString);
                AppMethodBeat.o(22398);
                return bool;
              }
              
              public final String K(String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(22396);
                if (com.tencent.mm.al.g.DQ(paramAnonymousString))
                {
                  paramAnonymousString = com.tencent.mm.al.a.e.NK(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramAnonymousInt).fqK);
                  AppMethodBeat.o(22396);
                  return paramAnonymousString;
                }
                paramAnonymousString = br.aVW();
                AppMethodBeat.o(22396);
                return paramAnonymousString;
              }
              
              public final void n(ca paramAnonymousca)
              {
                AppMethodBeat.i(22395);
                if (com.tencent.mm.al.g.DQ(paramAnonymousca.field_talker))
                {
                  paramAnonymousca.BB(com.tencent.mm.al.a.e.ajw());
                  AppMethodBeat.o(22395);
                  return;
                }
                paramAnonymousca.BB(br.aVW());
                AppMethodBeat.o(22395);
              }
              
              public final String o(ca paramAnonymousca)
              {
                AppMethodBeat.i(22397);
                if (com.tencent.mm.al.g.DQ(paramAnonymousca.field_talker))
                {
                  paramAnonymousca = com.tencent.mm.al.a.e.NK(paramAnonymousca.fqK);
                  AppMethodBeat.o(22397);
                  return paramAnonymousca;
                }
                paramAnonymousca = br.aVW();
                AppMethodBeat.o(22397);
                return paramAnonymousca;
              }
            });
          }
          com.tencent.mm.compatible.d.a.a(new com.tencent.mm.compatible.d.a.a()
          {
            public final void c(int paramAnonymousInt, Object... paramAnonymousVarArgs)
            {
              AppMethodBeat.i(231638);
              com.tencent.mm.plugin.report.service.h.CyF.a(paramAnonymousInt, paramAnonymousVarArgs);
              AppMethodBeat.o(231638);
            }
            
            public final void w(long paramAnonymousLong1, long paramAnonymousLong2)
            {
              AppMethodBeat.i(22402);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(paramAnonymousLong1, paramAnonymousLong2, 1L, false);
              AppMethodBeat.o(22402);
            }
          });
          AndroidOSafety.setISafetyCallback(new AndroidOSafety.ISafetyCallback()
          {
            public final void invokeToOpaque(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22404);
              com.tencent.mm.ui.base.b.bp(paramAnonymousActivity);
              AppMethodBeat.o(22404);
            }
            
            public final void reportState(int paramAnonymousInt, Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(231647);
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1221L, paramAnonymousInt, 1L, false);
              AppMethodBeat.o(231647);
            }
            
            public final boolean supportSwipe(Activity paramAnonymousActivity)
            {
              AppMethodBeat.i(22405);
              boolean bool = com.tencent.mm.ui.base.b.bf(paramAnonymousActivity.getClass());
              AppMethodBeat.o(22405);
              return bool;
            }
          });
          if (paramg.aBb())
          {
            com.tencent.mm.modelfriend.a.iUI = new com.tencent.mm.modelfriend.a.a()
            {
              public final String bbV()
              {
                AppMethodBeat.i(22406);
                if (ChannelUtil.isNokiaAol)
                {
                  str = MMApplicationContext.getContext().getString(2131764834);
                  AppMethodBeat.o(22406);
                  return str;
                }
                String str = MMApplicationContext.getContext().getString(2131764833);
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
                for (int i = com.tencent.mm.kernel.g.aAk().getProcessTid();; i = 0)
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
                  localb = com.tencent.mm.model.d.b.aXA();
                  boolean bool1 = MMHandlerThread.isMainThread();
                  String str1 = paramAnonymousSQLiteDatabase.getPath();
                  com.tencent.matrix.c.b.a(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousLong);
                  if (((paramAnonymousLong > localb.iHT) && (bool1)) || ((paramAnonymousLong > localb.iHW) && (!bool1)))
                  {
                    paramAnonymousSQLiteDatabase = com.tencent.mm.model.d.b.iIc.iterator();
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
                  while ((paramAnonymousInt == 2) && (bool1) && (paramAnonymousLong < localb.iHU))
                  {
                    String str2;
                    boolean bool2;
                    AppMethodBeat.o(22407);
                    return;
                  }
                  if ((paramAnonymousInt == 1) && (paramAnonymousLong > localb.iHV) && (com.tencent.mm.model.d.b.aXC()))
                  {
                    paramAnonymousSQLiteDatabase = com.tencent.mm.model.d.b.iId.iterator();
                    while (paramAnonymousSQLiteDatabase.hasNext())
                    {
                      str1 = (String)paramAnonymousSQLiteDatabase.next();
                      if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.contains(str1))) {
                        com.tencent.mm.plugin.report.service.h.CyF.a(21577, new Object[] { Long.valueOf(paramAnonymousLong), str1, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                      }
                    }
                  }
                  if (localb.iHz) {
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
                  bg.aAk().postToWorker(new b.3(localb, paramAnonymousSQLiteDatabase));
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
                      if (paramAnonymousLong <= localb.iHX) {
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
            com.tencent.mm.storage.e.NOM = new com.tencent.mm.plugin.messenger.foundation.a.n()
            {
              public final String am(ca paramAnonymousca)
              {
                AppMethodBeat.i(22409);
                int i;
                if ((paramAnonymousca.field_bizChatId != -1L) && (com.tencent.mm.al.g.DQ(paramAnonymousca.field_talker)))
                {
                  i = 1;
                  if (i == 0) {
                    break label91;
                  }
                  paramAnonymousca = paramAnonymousca.field_talker + ":" + paramAnonymousca.field_bizChatId;
                  Log.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { paramAnonymousca });
                }
                for (;;)
                {
                  AppMethodBeat.o(22409);
                  return paramAnonymousca;
                  i = 0;
                  break;
                  label91:
                  paramAnonymousca = paramAnonymousca.field_talker;
                }
              }
            };
            com.tencent.mm.model.ac.a(new ac.a()
            {
              public final boolean a(String paramAnonymousString1, String paramAnonymousString2, PInt paramAnonymousPInt)
              {
                AppMethodBeat.i(22410);
                if (com.tencent.mm.model.ab.IT(paramAnonymousString1))
                {
                  if (com.tencent.mm.al.g.DQ(paramAnonymousString1)) {
                    if (com.tencent.mm.al.a.e.NG(paramAnonymousString2)) {
                      paramAnonymousPInt.value = 5;
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(22410);
                    return true;
                    paramAnonymousPInt.value = 4;
                    continue;
                    if (com.tencent.mm.al.g.Nf(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 3;
                    } else if (com.tencent.mm.al.g.Ng(paramAnonymousString1)) {
                      paramAnonymousPInt.value = 0;
                    } else if (com.tencent.mm.al.g.Nb(paramAnonymousString1)) {
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
            com.tencent.mm.plugin.messenger.foundation.a.ab.b(new com.tencent.mm.co.c() {});
            localObject1 = new com.tencent.mm.modelmulti.a();
            x.a.a(69, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(68, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(22, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(13, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(15, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(23, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(25, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(24, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(33, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(35, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(44, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(999999, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(53, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(204, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            x.a.a(219, (com.tencent.mm.plugin.messenger.foundation.a.x)localObject1);
            localObject1 = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.e.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.d)localObject1);
            com.tencent.mm.kernel.g.azz().a(681, (com.tencent.mm.ak.i)localObject1);
            com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.h.a.class, this.deleteContactService);
            com.tencent.mm.plugin.messenger.foundation.a.ab.a(5, new n());
            com.tencent.mm.plugin.messenger.foundation.a.ab.a(1, new t());
            com.tencent.mm.plugin.messenger.foundation.a.ab.a(4, new i());
            ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new a());
            localObject1 = new o();
            ((w)com.tencent.mm.kernel.g.af(w.class)).a((com.tencent.mm.plugin.messenger.foundation.a.o)localObject1);
            ((w)com.tencent.mm.kernel.g.af(w.class)).a((com.tencent.mm.plugin.messenger.foundation.a.h)localObject1);
            ((w)com.tencent.mm.kernel.g.af(w.class)).a(new h());
            com.tencent.mm.model.e.a(new b());
            new com.tencent.mm.permission.a();
            new s().alive();
            com.tencent.mm.kernel.g.azz().b(138, p.pfc);
            com.tencent.mm.kernel.g.azz().b(39, p.pfc);
            com.tencent.mm.kernel.g.azz().b(268369922, p.pfc);
            if (p.pfc == null) {
              p.pfc = new p();
            }
            com.tencent.mm.kernel.g.azz().a(138, p.pfc);
            com.tencent.mm.kernel.g.azz().a(39, p.pfc);
            com.tencent.mm.kernel.g.azz().a(268369922, p.pfc);
            r.eJ(this.app);
            com.tencent.mm.az.a.a.a("delchatroommember", new u.1());
            com.tencent.mm.az.a.a.a("NewXmlChatRoomAccessVerifyApplication", new u.2());
            com.tencent.mm.az.a.a.a("NewXmlChatRoomAccessVerifyApproval", new u.3());
            com.tencent.mm.az.a.a.a("chatroommuteexpt", new u.4());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new u.5());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new u.6());
            com.tencent.mm.az.a.a.a("FinderPersonalMsgSysMsg", new u.7());
            ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new u.8());
            com.tencent.mm.az.a.a.a("invokeMessage", new b.1());
            com.tencent.mm.az.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new b.2());
            by.aTB();
            com.tencent.mm.model.n.aTB();
            localObject1 = this.appMgr;
            localObject2 = this.app;
            if (((MMAppMgr)localObject1).OHn == null) {
              ((MMAppMgr)localObject1).OHn = new MMAppMgr.Receiver((MMAppMgr)localObject1);
            }
            MMActivity.setMainProcess();
            localObject3 = new IntentFilter();
            ((IntentFilter)localObject3).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            ((IntentFilter)localObject3).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            ((IntentFilter)localObject3).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            ((IntentFilter)localObject3).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            ((IntentFilter)localObject3).addAction("MINIQB_OPEN_RET");
            ((Context)localObject2).registerReceiver(((MMAppMgr)localObject1).OHn, (IntentFilter)localObject3, WeChatPermissions.PERMISSION_MM_MESSAGE(), null);
            localObject1 = new com.tencent.mm.booter.x(com.tencent.mm.booter.d.cg(this.app));
            ((com.tencent.mm.booter.x)localObject1).CN("MM");
            com.tencent.mm.platformtools.ac.jOI = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            com.tencent.mm.platformtools.ac.jNP = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.display_errcode"), false);
            com.tencent.mm.platformtools.ac.jNQ = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.display_msgstate"), false);
            com.tencent.mm.platformtools.ac.jNR = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            com.tencent.mm.platformtools.ac.jNS = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.network.force_touch"), false);
            com.tencent.mm.platformtools.ac.jNT = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            com.tencent.mm.platformtools.ac.jNU = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.crashIsExit"), false);
            com.tencent.mm.platformtools.ac.jOu = Util.getInt(Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            com.tencent.mm.platformtools.ac.jOv = Util.getInt(Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            com.tencent.mm.platformtools.ac.jNW = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.album_drop_table"), false);
            com.tencent.mm.platformtools.ac.jNX = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.album_dle_file"), false);
            com.tencent.mm.platformtools.ac.jNY = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.album_show_info"), false);
            com.tencent.mm.platformtools.ac.jNZ = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.location_help"), false);
            com.tencent.mm.platformtools.ac.jOc = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.force_soso"), false);
            com.tencent.mm.platformtools.ac.jOd = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            com.tencent.mm.platformtools.ac.jOe = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            com.tencent.mm.platformtools.ac.jOf = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            com.tencent.mm.platformtools.ac.jOi = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.filterfpnp"), false);
            com.tencent.mm.platformtools.ac.jOj = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.testForPull"), false);
            i = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            com.tencent.mm.platformtools.ac.jOg = i;
            if ((i != 4) && (com.tencent.mm.platformtools.ac.jOg > 0))
            {
              com.tencent.mm.storage.aq.NSc = com.tencent.mm.platformtools.ac.jOg;
              Log.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.ac.jOg);
            }
            com.tencent.mm.platformtools.ac.jOh = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            com.tencent.mm.platformtools.ac.jOk = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.server.host.http"), "");
            com.tencent.mm.platformtools.ac.jOl = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.show_full_version"), false)) {
              ChannelUtil.fullVersionInfo = true;
            }
          }
          try
          {
            i = Integer.decode(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aiV(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception localThrowable1)
          {
            try
            {
              localObject2 = ((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
              if (!Util.isNullOrNil((String)localObject2))
              {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(localObject2));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(localObject2));
                com.tencent.mm.protocal.d.KyM = String.valueOf(localObject2);
                CrashReportFactory.setDebugerApiLevel((String)localObject2);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
              }
            }
            catch (Exception localThrowable1)
            {
              try
              {
                l = Long.decode(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(l);
                com.tencent.mm.protocal.d.KyN = l;
              }
              catch (Exception localThrowable1)
              {
                try
                {
                  i = Integer.decode(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  ((com.tencent.mm.booter.q)localObject1).gmN.glq = i;
                }
                catch (Exception localThrowable1)
                {
                  try
                  {
                    boolean bool1 = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    com.tencent.mm.platformtools.ac.jOo = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.update_test"), false);
                    com.tencent.mm.platformtools.ac.jOp = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.tablet"), false);
                    com.tencent.mm.platformtools.ac.jOq = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.scan_save_image"), false);
                    com.tencent.mm.platformtools.ac.jOs = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    com.tencent.mm.platformtools.ac.jOt = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    com.tencent.mm.platformtools.ac.jOx = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    Log.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ac.jOx);
                    com.tencent.mm.platformtools.ac.jOM = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.cdn.front"), "");
                    com.tencent.mm.platformtools.ac.jON = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.cdn.zone"), "");
                    com.tencent.mm.platformtools.ac.jOO = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    com.tencent.mm.platformtools.ac.jOP = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    com.tencent.mm.platformtools.ac.jOQ = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    com.tencent.mm.platformtools.ac.jOR = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cdn.usestream"), false);
                    com.tencent.mm.platformtools.ac.jOS = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    com.tencent.mm.platformtools.ac.jOT = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    com.tencent.mm.platformtools.ac.jOV = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    com.tencent.mm.platformtools.ac.jOW = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    com.tencent.mm.platformtools.ac.jOX = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    com.tencent.mm.platformtools.ac.jPf = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    Log.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.ac.jPf);
                    com.tencent.mm.platformtools.ac.jPg = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    com.tencent.mm.platformtools.ac.jPh = Util.getInt(Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    com.tencent.mm.platformtools.ac.jPc = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.cursormode_enabled"), true);
                    com.tencent.mm.platformtools.ac.jPM = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    com.tencent.mm.platformtools.ac.jPN = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    com.tencent.mm.platformtools.ac.jPO = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    com.tencent.mm.platformtools.ac.jPv = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    com.tencent.mm.platformtools.ac.jPx = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    com.tencent.mm.platformtools.ac.jPw = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    com.tencent.mm.platformtools.ac.jPy = Util.nullAs(((com.tencent.mm.booter.x)localObject1).getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    com.tencent.mm.platformtools.ac.jPF = Util.nullAs(((com.tencent.mm.booter.x)localObject1).CO(".com.tencent.mm.debug.netmock"), false);
                    localObject1 = Util.getTopActivity(MMApplicationContext.getContext());
                    if ((localObject1 != null) && (((ComponentName)localObject1).getPackageName().equals(MMApplicationContext.getPackageName())) && (((ComponentName)localObject1).getClassName().equals(MMApplicationContext.getLaunchName())))
                    {
                      WorkerProfile.Xg().dnn = true;
                      WorkerProfile.Xg().dno = true;
                      Log.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { ((ComponentName)localObject1).getPackageName(), ((ComponentName)localObject1).getClassName() });
                      com.tencent.mm.model.d.b.aXA();
                      com.tencent.mm.model.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
                      SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.j());
                      com.tencent.mm.plugin.report.service.j.Czl = (WorkerProfile)this.mProfileCompat;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.Ed("wechatbase");
                      localObject1 = CommLibFileName.quic;
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.Ed((String)localObject1);
                      getClass().getClassLoader();
                      com.tencent.mm.compatible.util.j.Ed("wechatmm");
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
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.CxC);
                      if (getClass().getClassLoader() == null)
                      {
                        i = -1;
                        if (Thread.currentThread().getContextClassLoader() != null) {
                          break label3830;
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
                          if (com.tencent.mm.compatible.util.d.oE(20))
                          {
                            Log.i("MicroMsg.PluginBigBallOfMud", "weird");
                            SmcLogic.setUin(0L);
                          }
                          localObject1 = (com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
                          localObject2 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.zero.a.d.class);
                          new com.tencent.mm.plugin.e.d().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                          localObject3 = (com.tencent.mm.plugin.e.b)new com.tencent.mm.plugin.e.b().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                          new com.tencent.mm.plugin.e.f().after((com.tencent.mm.kernel.b.a)localObject3).before(this);
                          new com.tencent.mm.plugin.e.c().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                          new com.tencent.mm.plugin.e.a().after((com.tencent.mm.kernel.b.a)localObject2);
                          com.tencent.mm.br.c.gsW();
                          com.tencent.mm.ui.chatting.g.a.ebz();
                          com.tencent.mm.ui.chatting.multitask.b.ebz();
                          ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(4, FileMultiTaskUIC.class);
                          com.tencent.mm.pluginsdk.j.a.a.m.a(new com.tencent.mm.pluginsdk.j.a.a.a.a()
                          {
                            public final boolean CI(int paramAnonymousInt)
                            {
                              AppMethodBeat.i(22385);
                              if ((paramAnonymousInt == 39) && (!com.tencent.mm.plugin.ipcall.d.dZW()))
                              {
                                AppMethodBeat.o(22385);
                                return true;
                              }
                              AppMethodBeat.o(22385);
                              return false;
                            }
                          });
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          k.c.a(new com.tencent.mm.co.c() {});
                          EventCenter.instance.addListener(new PluginBigBallOfMud.30(this));
                          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.o.class, new com.tencent.mm.modelsimple.b());
                          if (paramg.aBb())
                          {
                            Log.i("MicroMsg.PluginBigBallOfMud", "hy: register magic emoji. temp here");
                            com.tencent.mm.kernel.g.b(v.class, com.tencent.mm.ui.l.a.b.Qlr);
                          }
                          AppMethodBeat.o(22414);
                          return;
                          if (((String)localObject2).equals(MMApplicationContext.getPackageName())) {
                            localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.WorkerProfile");
                          }
                          for (;;)
                          {
                            Log.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                            break;
                            if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":push"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.PusherProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":tools"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.ToolsProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":sandbox"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.SandBoxProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":exdevice"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.ExDeviceProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":TMAssistantDownloadSDKService"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.TMAssistantProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":nospace"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.NoSpaceProfile");
                            }
                            else if (((String)localObject2).equals(MMApplicationContext.getPackageName() + ":patch"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.PatchProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":appbrand"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.AppBrandProfile");
                            }
                            else if (((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":support"))
                            {
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.SupportProfile");
                            }
                            else
                            {
                              if (!((String)localObject2).startsWith(MMApplicationContext.getPackageName() + ":lite")) {
                                break label3650;
                              }
                              localObject1 = com.tencent.mm.compatible.loader.e.b((Application)localObject1, ".app.LiteAppProfile");
                            }
                          }
                          label3650:
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
                            WorkerProfile.Xg().dnn = true;
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
                        label3830:
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
    if ((ao.awS()) && (ao.awN()))
    {
      XWalkEnvironment.setForceDarkMode(ao.i(paramConfiguration));
      MMWebView.CU(ao.i(paramConfiguration));
      if (MMApplicationContext.isMainProcess())
      {
        if (com.tencent.mm.cc.c.h(paramConfiguration))
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "dancy test uiModeChange true, uimode:%s", new Object[] { Integer.valueOf(paramConfiguration.uiMode) });
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          com.tencent.mm.modelappbrand.a.b.aXY().clearCache();
          if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null)
          {
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chL();
            if (com.tencent.mm.kernel.g.aAf().azp())
            {
              localObject = com.tencent.mm.plugin.voip.c.fFh();
              if (((com.tencent.mm.plugin.voip.ui.d)localObject).HeX != null)
              {
                localObject = ((com.tencent.mm.plugin.voip.ui.d)localObject).HeX;
                BaseSmallView localBaseSmallView = ((VoipViewFragment)localObject).HfC;
                if (localBaseSmallView != null) {
                  localBaseSmallView.eoM();
                }
                localObject = ((VoipViewFragment)localObject).HfB;
                if (localObject != null) {
                  ((BaseSmallView)localObject).eoM();
                }
              }
              localObject = com.tencent.mm.plugin.multitalk.model.ac.eon().zTM;
              if (localObject != null) {
                ((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject).eoM();
              }
            }
          }
        }
        com.tencent.mm.cc.c.a(paramConfiguration, ao.isDarkMode());
        if (MMApplicationContext.getContext().getResources() != null) {
          MMApplicationContext.getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
        }
      }
    }
    Object localObject = MMApplicationContext.getResources();
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
    Log.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { MMApplicationContext.getProcessName() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.OHn != null) {
      localApplication.unregisterReceiver(localMMAppMgr.OHn);
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
    Object localObject = com.tencent.mm.memory.a.a.b.aSk();
    Log.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).itH.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).aSl();
    }
    AppMethodBeat.o(22417);
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