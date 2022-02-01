package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.jg.JgMethodChecked;
import com.tencent.e.i;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IReportCrash;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.td;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.l;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.af;
import com.tencent.mm.network.af.b;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.al;
import com.tencent.mm.network.o;
import com.tencent.mm.network.r;
import com.tencent.mm.network.v;
import com.tencent.mm.network.v.14;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MAlarmHandler.IBumper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.ProcessService.MMProcessService;
import java.util.ArrayList;

public class CoreService
  extends Service
  implements PlatformComm.IReportCrash, PlatformComm.IResetProcess, af.b, o
{
  private static b iPk = null;
  private final MAlarmHandler.IBumper bumper;
  private v iPi;
  private f iPj;
  private boolean iPl;
  private a iPm;
  private int iPn;
  private int iPo;
  private long iPp;
  private long iPq;
  private long iPr;
  private WakerLock iPs;
  private q iPt;
  private MTimerHandler iPu;
  
  public CoreService()
  {
    AppMethodBeat.i(131845);
    this.iPj = new f();
    this.iPl = true;
    this.iPm = null;
    this.bumper = new MAlarmHandler.IBumper()
    {
      public final void cancel()
      {
        AppMethodBeat.i(131838);
        MMReceivers.AlarmReceiver.ce(CoreService.this.getApplicationContext());
        AppMethodBeat.o(131838);
      }
      
      public final void prepare()
      {
        AppMethodBeat.i(131837);
        MMReceivers.AlarmReceiver.cd(CoreService.this.getApplicationContext());
        AppMethodBeat.o(131837);
      }
    };
    this.iPn = -1;
    this.iPo = -1;
    this.iPp = 0L;
    this.iPq = 0L;
    this.iPr = 0L;
    this.iPs = null;
    this.iPt = new q();
    this.iPu = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(194747);
        q localq = CoreService.a(CoreService.this);
        int i;
        if (Util.ticksToNow(localq.mEl) < localq.mEj)
        {
          Log.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + localq.mEl + ", cur=" + Util.currentTicks() + ", retries=" + localq.mEm);
          if (localq.mEm <= 0)
          {
            i = 0;
            if (i != 0) {
              break label246;
            }
            Log.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(CoreService.c(CoreService.this)), Long.valueOf(CoreService.d(CoreService.this)), Long.valueOf(Util.nowMilliSecond() - CoreService.e(CoreService.this)) });
          CoreService.f(CoreService.this);
          CoreService.g(CoreService.this);
          CoreService.h(CoreService.this);
          new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(200523);
              CoreService.i(CoreService.this).unLock();
              AppMethodBeat.o(200523);
              return false;
            }
          }, false).startTimer(500L);
          AppMethodBeat.o(194747);
          return true;
          for (localq.mEm -= 1;; localq.mEm = localq.mEk)
          {
            localq.mEl = Util.currentTicks();
            i = 1;
            break;
          }
          label246:
          boolean bool1 = CoreService.b(CoreService.this).muM.biq();
          boolean bool2 = af.btU().btr();
          Log.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (!bool2) && (g.a(1, 0, null, CoreService.b(CoreService.this).muM.sE(1), Util.nowMilliSecond())))
          {
            Log.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
            AppMethodBeat.o(194747);
            return true;
          }
          CoreService.aqo();
        }
      }
    }, false);
    AppMethodBeat.o(131845);
  }
  
  public static long EL(long paramLong)
  {
    AppMethodBeat.i(131859);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("msg_receive_number");
    long l = paramLong - localMultiProcessMMKV.getLong("recv_num", 0L);
    if (l > 0L)
    {
      localMultiProcessMMKV.edit().putLong("recv_num", paramLong);
      AppMethodBeat.o(131859);
      return 1L;
    }
    AppMethodBeat.o(131859);
    return l;
  }
  
  public static void a(b paramb)
  {
    iPk = paramb;
  }
  
  public static void aqo()
  {
    AppMethodBeat.i(131854);
    Intent localIntent = new Intent(af.getContext(), NotifyReceiver.class);
    localIntent.putExtra("notify_option_type", 1);
    localIntent.putExtra("notify_uin", af.btU().muM.getUin());
    long l = aqq();
    localIntent.putExtra("notfiy_sync_num", l);
    try
    {
      af.getContext().sendBroadcast(localIntent);
      Log.i("MicroMsg.CoreService", "sendBorastToNotifyReceiver syncNum:%s", new Object[] { Long.valueOf(l) });
      if (Util.isEqual(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_android_receive_msg_use_mmservice_switch", "0", false, true), "1"))
      {
        localIntent.setClass(af.getContext(), NotifyReceiver.NotifyReceiverService.class);
        localIntent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
        com.tencent.mm.service.c.a(localIntent, "mm", true, new Intent(MMApplicationContext.getContext(), ProcessService.MMProcessService.class));
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1042L, 62L, 1L, false);
      }
      AppMethodBeat.o(131854);
      return;
    }
    catch (Exception localException)
    {
      Log.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[] { localException.toString() });
      AppMethodBeat.o(131854);
    }
  }
  
  private void aqp()
  {
    AppMethodBeat.i(131855);
    Log.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
    af.btV().m(3, 10000, "");
    Mars.onDestroy();
    try
    {
      MMReceivers.AlarmReceiver.cg(getApplicationContext());
      MMReceivers.AlarmReceiver.ce(getApplicationContext());
      Alarm.resetAlarm(getApplicationContext());
      Log.appenderClose();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/booter/CoreService", "doExit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/booter/CoreService", "doExit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(131855);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CoreService", localException, "", new Object[0]);
      }
    }
  }
  
  private static long aqq()
  {
    AppMethodBeat.i(131858);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("msg_receive_number");
    long l = localMultiProcessMMKV.getLong("send_num", 0L) + 1L;
    localMultiProcessMMKV.edit().putLong("send_num", l);
    AppMethodBeat.o(131858);
    return l;
  }
  
  public static void aqr()
  {
    AppMethodBeat.i(194470);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("msg_receive_number");
    long l1 = localMultiProcessMMKV.getLong("recv_num", 0L);
    long l2 = localMultiProcessMMKV.getLong("send_num", 0L);
    long l3 = l1 - l2;
    if (l3 > 0L)
    {
      localMultiProcessMMKV.edit().putLong("send_num", 1L + l1);
      com.tencent.mm.plugin.report.f.Iyx.a(19779, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      Log.i("MicroMsg.CoreService", "checkSyncNum() why?????? diffValue:%s recvNum:%s sendNum:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(194470);
      return;
    }
    Log.i("MicroMsg.CoreService", "checkSyncNum() no problem");
    AppMethodBeat.o(194470);
  }
  
  private static IDKey cH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194458);
    Log.i("MicroMsg.CoreService", "idkeyPushSetupTimeReport %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1391);
    localIDKey.SetKey(paramInt1);
    localIDKey.SetValue(paramInt2);
    AppMethodBeat.o(194458);
    return localIDKey;
  }
  
  public final void dF(boolean paramBoolean)
  {
    AppMethodBeat.i(131853);
    if (!paramBoolean)
    {
      Log.w("MicroMsg.CoreService", "[NETWORK LOST]");
      af.btQ().mwv = false;
      af.btR().networkChange(0);
      if (this.iPl)
      {
        af.btU().btb();
        f localf = this.iPj;
        localf.iPI = null;
        localf.iPK = "";
        localf.iPJ = "";
        localf.iPL = -1;
      }
      this.iPl = false;
      AppMethodBeat.o(131853);
      return;
    }
    Log.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
    af.btQ().mwv = true;
    paramBoolean = this.iPj.aqy();
    Log.i("MicroMsg.CoreService", "lastConnected %s, isNetWorkChange %s", new Object[] { Boolean.valueOf(this.iPl), Boolean.valueOf(paramBoolean) });
    if ((this.iPl) && (!paramBoolean))
    {
      Log.i("MicroMsg.CoreService", "network not change or can't get network info");
      AppMethodBeat.o(131853);
      return;
    }
    if (paramBoolean) {
      af.btU().btb();
    }
    this.iPl = true;
    af.btR().networkChange(6);
    if (this.iPs == null) {
      this.iPs = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
    }
    if (!this.iPs.isLocking())
    {
      this.iPs.lock(6000L, "CoreService.setNetworkAvailable");
      this.iPp += 1L;
    }
    if (0L == this.iPr) {
      this.iPq = Util.nowMilliSecond();
    }
    this.iPr += 1L;
    Log.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(this.iPp), Long.valueOf(this.iPr), Long.valueOf(Util.nowMilliSecond() - this.iPq) });
    this.iPu.startTimer(3000L);
    AppMethodBeat.o(131853);
  }
  
  public final boolean f(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131852);
    if (n.cG(this))
    {
      Log.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
      AppMethodBeat.o(131852);
      return false;
    }
    if (paramInt == -255) {
      paramInt = 138;
    }
    for (;;)
    {
      boolean bool1 = af.btN().getBoolean("is_in_notify_mode", false);
      boolean bool2 = this.iPi.muM.biq();
      boolean bool3 = af.btU().btr();
      if ((bool1) && (bool2) && (!bool3) && (g.a(2, paramInt, paramArrayOfByte, this.iPi.muM.sE(1), Util.nowMilliSecond())))
      {
        Log.i("MicroMsg.CoreService", "deal with notify sync in push");
        AppMethodBeat.o(131852);
        return true;
      }
      Log.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      Intent localIntent = new Intent(this, NotifyReceiver.class);
      localIntent.putExtra("notify_option_type", 2);
      localIntent.putExtra("notify_uin", this.iPi.muM.getUin());
      localIntent.putExtra("notify_respType", paramInt);
      localIntent.putExtra("notify_respBuf", paramArrayOfByte);
      localIntent.putExtra("notify_skey", this.iPi.muM.sE(1));
      Log.i("MicroMsg.CoreService", "notify broadcast:" + localIntent.getAction() + ", type=" + paramInt);
      try
      {
        long l = aqq();
        localIntent.putExtra("notfiy_sync_num", l);
        Log.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d syncNum:%s", new Object[] { Long.valueOf(localIntent.getLongExtra("notfiy_recv_time", 0L)), Integer.valueOf(localIntent.getIntExtra("notify_uin", 0)), Integer.valueOf(localIntent.getIntExtra("notify_respType", 0)), Integer.valueOf(Util.nullAs(localIntent.getByteArrayExtra("notify_respBuf"), new byte[0]).length), Long.valueOf(l) });
        localIntent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
        sendBroadcast(localIntent);
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1042L, 60L, 1L, false);
        com.tencent.mm.as.a.A(paramInt, l);
        if (Util.isEqual(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_android_receive_msg_use_mmservice_switch", "0", false, true), "1"))
        {
          localIntent.setClass(this, NotifyReceiver.NotifyReceiverService.class);
          localIntent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
          com.tencent.mm.service.c.a(localIntent, "mm", true, new Intent(MMApplicationContext.getContext(), ProcessService.MMProcessService.class));
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1042L, 62L, 1L, false);
        }
        AppMethodBeat.o(131852);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          Log.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(131850);
    int i = Process.myPid();
    Log.d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), new Object[] { Integer.valueOf(this.iPo), Integer.valueOf(i) });
    if (i != this.iPo)
    {
      this.iPo = i;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 147L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 146L, 1L, false);
      }
      i = (int)(SystemClock.elapsedRealtime() - l.aHN());
      paramIntent = new ArrayList();
      paramIntent.add(cH(5, i));
      if (i > 1000L) {
        break label216;
      }
      i = 10;
    }
    for (;;)
    {
      paramIntent.add(cH(i, 1));
      paramIntent.add(cH(0, 1));
      com.tencent.mm.plugin.report.f.Iyx.b(paramIntent, false);
      com.tencent.e.h.ZvG.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205574);
          CoreService.aqs();
          AppMethodBeat.o(205574);
        }
      }, 3000L);
      paramIntent = this.iPi;
      AppMethodBeat.o(131850);
      return paramIntent;
      label216:
      if (i <= 2000L) {
        i = 11;
      } else if (i <= 3000L) {
        i = 12;
      } else if (i <= 4000L) {
        i = 13;
      } else if (i <= 5000L) {
        i = 14;
      } else if (i <= 7000L) {
        i = 15;
      } else if (i <= 10000L) {
        i = 16;
      } else if (i <= 15000L) {
        i = 17;
      } else if (i <= 20000L) {
        i = 18;
      } else if (i <= 30000L) {
        i = 19;
      } else if (i <= 40000L) {
        i = 20;
      } else if (i <= 50000L) {
        i = 21;
      } else if (i <= 60000L) {
        i = 22;
      } else if (i <= 120000L) {
        i = 23;
      } else if (i <= 180000L) {
        i = 24;
      } else if (i <= 300000L) {
        i = 25;
      } else if (i <= 420000L) {
        i = 26;
      } else if (i <= 600000L) {
        i = 27;
      } else {
        i = 28;
      }
    }
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public void onCreate()
  {
    Object localObject5 = null;
    AppMethodBeat.i(131846);
    Log.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    try
    {
      this.iPm = ((a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
      Log.d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", new Object[] { this.iPm });
      this.iPm.registerBroadcasts();
      if ((com.tencent.mm.compatible.util.d.qW(26)) && (Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.g.isMIUI()))
      {
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(-1213, new Notification());
        }
      }
      else
      {
        localObject1 = new MMHandler(Looper.getMainLooper());
        Mars.init(MMApplicationContext.getContext(), (MMHandler)localObject1);
        StnLogic.setCallBack(new al());
        IPxxLogic.setCallBack(new r());
        com.tencent.mm.jni.a.a.aFT();
        EventCenter.instance.addListener(new IListener() {});
        af.btO();
        MAlarmHandler.initAlarmBumper(this.bumper);
        if (PlatformComm.resetprocessimp == null) {
          PlatformComm.resetprocessimp = this;
        }
        if (PlatformComm.reportCrashImp == null) {
          PlatformComm.reportCrashImp = this;
        }
        af.a((MMHandler)localObject1);
        af.setContext(getApplicationContext());
        af.a(new ag());
        af.a(new ah());
        af.a(this);
        af.a(new ab());
        this.iPi = af.btU();
        if (this.iPi != null) {
          break label774;
        }
        Log.i("MicroMsg.CoreService", "autoAuth is null and new one");
        this.iPi = new v(af.btS());
        af.g(this.iPi);
        Mars.onCreate(true);
        if (af.btV() != null) {
          break label792;
        }
        Log.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
        af.a(new ae());
        if (af.btW() == null)
        {
          Log.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
          af.a(new ad());
          af.btW().mwc = this;
        }
        localObject4 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).iQW;
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).iQW = d.cc(getApplicationContext());
          localObject1 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).iQW;
          Log.i("MicroMsg.CoreService", "summerauths init debug here[%s]", new Object[] { localObject1 });
        }
        if (localObject1 != null)
        {
          localObject4 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.http");
          str1 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.http");
          localObject6 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.socket");
          String str2 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.socket");
          this.iPi.e((String)localObject4, str1, (String)localObject6, str2);
          localObject4 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.host");
          str1 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.ip");
          localObject6 = this.iPi;
          if ((!Util.isNullOrNil((String)localObject4)) && (!Util.isNullOrNil(new String[0]))) {
            break label809;
          }
        }
        if (localObject1 != null) {
          break label833;
        }
        localObject4 = null;
        if ((localObject4 == null) || (!((String)localObject4).contains("@"))) {
          break label844;
        }
        localObject1 = ((String)localObject4).split("@");
        localObject4 = localObject1[0];
        localObject1 = localObject1[1];
        this.iPi.setNewDnsDebugHost((String)localObject4, (String)localObject1);
        MMReceivers.AlarmReceiver.cg(getApplicationContext());
        MMReceivers.AlarmReceiver.cf(getApplicationContext());
        localObject1 = (ConnectivityManager)getSystemService("connectivity");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Object localObject4;
          String str1;
          Object localObject6;
          Object localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if ((localObject1 != null) && (((NetworkInfo)localObject1).getState() == NetworkInfo.State.CONNECTED)) {
            break label928;
          }
          if (localObject1 != null) {
            break label920;
          }
          localObject1 = "null";
          Log.e("MicroMsg.CoreService", "networkInfo.state: %s", new Object[] { localObject1 });
          af.btQ().mwv = false;
          af.btR().networkChange(0);
          ((PluginZero)com.tencent.mm.kernel.h.ag(PluginZero.class)).SvF.a(this);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131840);
              if (Build.VERSION.SDK_INT > 23) {
                Log.i("MicroMsg.CoreService", "KeepAliveService.scheduleKeepAliveJob() flag:%s", new Object[] { Boolean.valueOf(KeepAliveService.aqx()) });
              }
              AppMethodBeat.o(131840);
            }
          }, 1000L);
          Log.i("MicroMsg.CoreService", "CoreService OnCreate ");
          AppMethodBeat.o(131846);
          return;
          localException1 = localException1;
          Log.e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException1.getMessage() });
          continue;
          if (getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.avK()).getBoolean("set_service", false))
          {
            startForeground(-1213, new Notification());
            startService(new Intent(this, CoreService.InnerService.class));
            Log.i("MicroMsg.CoreService", "set service for push.");
            continue;
            label774:
            Log.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.iPi.reset();
            continue;
            label792:
            Log.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            af.btV().reset();
            continue;
            label809:
            new v.14((v)localObject6, (String)localObject4, str1).exec(((v)localObject6).handler);
            continue;
            label833:
            localObject4 = localException1.getString(".com.tencent.mm.debug.server.host.newdns");
            continue;
            label844:
            if ((localObject4 == null) || (!((String)localObject4).contains(":"))) {
              break;
            }
            localObject2 = ((String)localObject4).split(":");
            localObject4 = localObject2[0];
            localObject2 = localObject2[1];
          }
        }
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.CoreService", localException2, "", new Object[0]);
          Log.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[] { localException2.getMessage() });
          Object localObject3 = localObject5;
          continue;
          label920:
          localObject3 = ((NetworkInfo)localObject3).getState();
          continue;
          label928:
          af.btQ().mwv = true;
          af.btR().networkChange(6);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131848);
    Log.i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
    try
    {
      ((PluginZero)com.tencent.mm.kernel.h.ag(PluginZero.class)).SvF.b(this);
      com.tencent.mm.jni.a.a.aFU();
      super.onDestroy();
      aqp();
      if (this.iPm == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.iPm.unRegisterBroadcasts();
          AppMethodBeat.o(131848);
          return;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException2.getMessage() });
        }
        localException1 = localException1;
        Log.e("MicroMsg.CoreService", "onDestroy onDestroy() mCoreServiceLifecycleCallbacks Exception: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(131848);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(131851);
    Log.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
    AppMethodBeat.o(131851);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131847);
    int i = Process.myPid();
    Log.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[] { Integer.valueOf(this.iPn), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (i != this.iPn)
    {
      this.iPn = i;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 141L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 140L, 1L, false);
      }
    }
    AppMethodBeat.o(131847);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(131849);
    Log.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
    af.btQ().mwu = null;
    af.btX().mvW = null;
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(131849);
    return bool;
  }
  
  public void reportIdkey()
  {
    AppMethodBeat.i(131857);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("alarm_crash");
    long l = localMultiProcessMMKV.getLong("report_time", 0L);
    if (cm.bfC() - l > 86400000L)
    {
      localMultiProcessMMKV.edit().putLong("report_time", cm.bfC());
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1204L, 0L, 1L, false);
    }
    AppMethodBeat.o(131857);
  }
  
  public void restartProcess()
  {
    AppMethodBeat.i(131856);
    Log.w("MicroMsg.CoreService", "restartProcess");
    aqp();
    AppMethodBeat.o(131856);
  }
  
  public static abstract interface a
  {
    public abstract void registerBroadcasts();
    
    public abstract void unRegisterBroadcasts();
  }
  
  public static abstract interface b
  {
    public abstract void bK(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService
 * JD-Core Version:    0.7.0.1
 */