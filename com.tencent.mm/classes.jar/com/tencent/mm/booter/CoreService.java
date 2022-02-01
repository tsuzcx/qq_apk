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
import com.tencent.mm.g.a.rg;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.ad.b;
import com.tencent.mm.network.af;
import com.tencent.mm.network.aj;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.14;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.service.ProcessService.MMProcessService;
import java.util.ArrayList;

public class CoreService
  extends Service
  implements PlatformComm.IReportCrash, PlatformComm.IResetProcess, ad.b, m
{
  private static b fFT = null;
  private t fFR;
  private f fFS;
  private boolean fFU;
  private a fFV;
  private final ai.b fFW;
  private int fFX;
  private int fFY;
  private long fFZ;
  private long fGa;
  private long fGb;
  private WakerLock fGc;
  private q fGd;
  private aw fGe;
  
  public CoreService()
  {
    AppMethodBeat.i(131845);
    this.fFS = new f();
    this.fFU = true;
    this.fFV = null;
    this.fFW = new ai.b()
    {
      public final void cancel()
      {
        AppMethodBeat.i(131838);
        MMReceivers.AlarmReceiver.bN(CoreService.this.getApplicationContext());
        AppMethodBeat.o(131838);
      }
      
      public final void prepare()
      {
        AppMethodBeat.i(131837);
        MMReceivers.AlarmReceiver.bM(CoreService.this.getApplicationContext());
        AppMethodBeat.o(131837);
      }
    };
    this.fFX = -1;
    this.fFY = -1;
    this.fFZ = 0L;
    this.fGa = 0L;
    this.fGb = 0L;
    this.fGc = null;
    this.fGd = new q();
    this.fGe = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(193537);
        q localq = CoreService.a(CoreService.this);
        int i;
        if (bu.aO(localq.iQh) < localq.iQf)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + localq.iQh + ", cur=" + bu.HQ() + ", retries=" + localq.iQi);
          if (localq.iQi <= 0)
          {
            i = 0;
            if (i != 0) {
              break label249;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
          }
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(CoreService.c(CoreService.this)), Long.valueOf(CoreService.d(CoreService.this)), Long.valueOf(bu.fpO() - CoreService.e(CoreService.this)) });
          CoreService.f(CoreService.this);
          CoreService.g(CoreService.this);
          CoreService.h(CoreService.this);
          new aw(new aw.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(193536);
              CoreService.i(CoreService.this).unLock();
              AppMethodBeat.o(193536);
              return false;
            }
          }, false).ay(500L, 500L);
          AppMethodBeat.o(193537);
          return true;
          for (localq.iQi -= 1;; localq.iQi = localq.iQg)
          {
            localq.iQh = bu.HQ();
            i = 1;
            break;
          }
          label249:
          boolean bool1 = CoreService.b(CoreService.this).iHF.aFm();
          boolean bool2 = ad.aPK().aPm();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (!bool2) && (g.a(1, 0, null, CoreService.b(CoreService.this).iHF.mR(1), bu.fpO())))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
            AppMethodBeat.o(193537);
            return true;
          }
          CoreService.WE();
        }
      }
    }, false);
    AppMethodBeat.o(131845);
  }
  
  public static void WE()
  {
    AppMethodBeat.i(131854);
    Intent localIntent = new Intent(ad.getContext(), NotifyReceiver.class);
    localIntent.putExtra("notify_option_type", 1);
    localIntent.putExtra("notify_uin", ad.aPK().iHF.getUin());
    long l = WG();
    localIntent.putExtra("notfiy_sync_num", l);
    try
    {
      ad.getContext().sendBroadcast(localIntent);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "sendBorastToNotifyReceiver syncNum:%s", new Object[] { Long.valueOf(l) });
      if (bu.lX(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_android_receive_msg_use_mmservice_switch", "0", false, true), "1"))
      {
        localIntent.setClass(ad.getContext(), NotifyReceiver.NotifyReceiverService.class);
        localIntent.putExtra("notfiy_recv_time", bu.fpO());
        com.tencent.mm.service.c.a(localIntent, "mm", true, new Intent(ak.getContext(), ProcessService.MMProcessService.class));
        e.ywz.idkeyStat(1042L, 62L, 1L, false);
      }
      AppMethodBeat.o(131854);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[] { localException.toString() });
      AppMethodBeat.o(131854);
    }
  }
  
  private void WF()
  {
    AppMethodBeat.i(131855);
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
    ad.aPL().m(3, 10000, "");
    Mars.onDestroy();
    try
    {
      MMReceivers.AlarmReceiver.bP(getApplicationContext());
      MMReceivers.AlarmReceiver.bN(getApplicationContext());
      Alarm.resetAlarm(getApplicationContext());
      com.tencent.mm.sdk.platformtools.ae.appenderClose();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/booter/CoreService", "doExit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/booter/CoreService", "doExit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(131855);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.CoreService", localException, "", new Object[0]);
      }
    }
  }
  
  private static long WG()
  {
    AppMethodBeat.i(131858);
    ay localay = ay.aRW("msg_receive_number");
    long l = localay.getLong("send_num", 0L) + 1L;
    localay.edit().putLong("send_num", l);
    AppMethodBeat.o(131858);
    return l;
  }
  
  public static void WH()
  {
    AppMethodBeat.i(193539);
    ay localay = ay.aRW("msg_receive_number");
    long l1 = localay.getLong("recv_num", 0L);
    long l2 = localay.getLong("send_num", 0L);
    long l3 = l1 - l2;
    if (l3 > 0L)
    {
      localay.edit().putLong("send_num", 1L + l1);
      e.ywz.f(19779, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "checkSyncNum() why?????? diffValue:%s recvNum:%s sendNum:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(193539);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "checkSyncNum() no problem");
    AppMethodBeat.o(193539);
  }
  
  public static void a(b paramb)
  {
    fFT = paramb;
  }
  
  private static IDKey cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193538);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "idkeyPushSetupTimeReport %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1391);
    localIDKey.SetKey(paramInt1);
    localIDKey.SetValue(paramInt2);
    AppMethodBeat.o(193538);
    return localIDKey;
  }
  
  public static long qS(long paramLong)
  {
    AppMethodBeat.i(131859);
    ay localay = ay.aRW("msg_receive_number");
    long l = paramLong - localay.getLong("recv_num", 0L);
    if (l > 0L)
    {
      localay.edit().putLong("recv_num", paramLong);
      AppMethodBeat.o(131859);
      return 1L;
    }
    AppMethodBeat.o(131859);
    return l;
  }
  
  public final void cx(boolean paramBoolean)
  {
    AppMethodBeat.i(131853);
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.CoreService", "[NETWORK LOST]");
      ad.aPG().iJo = false;
      ad.aPH().qK(0);
      if (this.fFU)
      {
        ad.aPK().aPf();
        f localf = this.fFS;
        localf.fGr = null;
        localf.fGt = "";
        localf.fGs = "";
        localf.fGu = -1;
      }
      this.fFU = false;
      AppMethodBeat.o(131853);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
    ad.aPG().iJo = true;
    paramBoolean = this.fFS.WO();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "lastConnected %s, isNetWorkChange %s", new Object[] { Boolean.valueOf(this.fFU), Boolean.valueOf(paramBoolean) });
    if ((this.fFU) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "network not change or can't get network info");
      AppMethodBeat.o(131853);
      return;
    }
    if (paramBoolean) {
      ad.aPK().aPf();
    }
    this.fFU = true;
    ad.aPH().qK(6);
    if (this.fGc == null) {
      this.fGc = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
    }
    if (!this.fGc.isLocking())
    {
      this.fGc.lock(6000L, "CoreService.setNetworkAvailable");
      this.fFZ += 1L;
    }
    if (0L == this.fGb) {
      this.fGa = bu.fpO();
    }
    this.fGb += 1L;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(this.fFZ), Long.valueOf(this.fGb), Long.valueOf(bu.fpO() - this.fGa) });
    this.fGe.ay(3000L, 3000L);
    AppMethodBeat.o(131853);
  }
  
  public final boolean f(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131852);
    if (l.co(this))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
      AppMethodBeat.o(131852);
      return false;
    }
    if (paramInt == -255) {
      paramInt = 138;
    }
    for (;;)
    {
      boolean bool1 = ad.aPD().getBoolean("is_in_notify_mode", false);
      boolean bool2 = this.fFR.iHF.aFm();
      boolean bool3 = ad.aPK().aPm();
      if ((bool1) && (bool2) && (!bool3) && (g.a(2, paramInt, paramArrayOfByte, this.fFR.iHF.mR(1), bu.fpO())))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "deal with notify sync in push");
        AppMethodBeat.o(131852);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      Intent localIntent = new Intent(this, NotifyReceiver.class);
      localIntent.putExtra("notify_option_type", 2);
      localIntent.putExtra("notify_uin", this.fFR.iHF.getUin());
      localIntent.putExtra("notify_respType", paramInt);
      localIntent.putExtra("notify_respBuf", paramArrayOfByte);
      localIntent.putExtra("notify_skey", this.fFR.iHF.mR(1));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "notify broadcast:" + localIntent.getAction() + ", type=" + paramInt);
      try
      {
        long l = WG();
        localIntent.putExtra("notfiy_sync_num", l);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d syncNum:%s", new Object[] { Long.valueOf(localIntent.getLongExtra("notfiy_recv_time", 0L)), Integer.valueOf(localIntent.getIntExtra("notify_uin", 0)), Integer.valueOf(localIntent.getIntExtra("notify_respType", 0)), Integer.valueOf(bu.n(localIntent.getByteArrayExtra("notify_respBuf"), new byte[0]).length), Long.valueOf(l) });
        localIntent.putExtra("notfiy_recv_time", bu.fpO());
        sendBroadcast(localIntent);
        e.ywz.idkeyStat(1042L, 60L, 1L, false);
        com.tencent.mm.ap.a.y(paramInt, l);
        if (bu.lX(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_android_receive_msg_use_mmservice_switch", "0", false, true), "1"))
        {
          localIntent.setClass(this, NotifyReceiver.NotifyReceiverService.class);
          localIntent.putExtra("notfiy_recv_time", bu.fpO());
          com.tencent.mm.service.c.a(localIntent, "mm", true, new Intent(ak.getContext(), ProcessService.MMProcessService.class));
          e.ywz.idkeyStat(1042L, 62L, 1L, false);
        }
        AppMethodBeat.o(131852);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[] { bu.o(paramArrayOfByte) });
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(131850);
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), new Object[] { Integer.valueOf(this.fFY), Integer.valueOf(i) });
    if (i != this.fFY)
    {
      this.fFY = i;
      e.ywz.idkeyStat(99L, 147L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        e.ywz.idkeyStat(99L, 146L, 1L, false);
      }
      i = (int)(SystemClock.elapsedRealtime() - j.ajX());
      paramIntent = new ArrayList();
      paramIntent.add(cn(5, i));
      if (i > 1000L) {
        break label216;
      }
      i = 10;
    }
    for (;;)
    {
      paramIntent.add(cn(i, 1));
      paramIntent.add(cn(0, 1));
      e.ywz.b(paramIntent, false);
      com.tencent.e.h.MqF.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193535);
          CoreService.WI();
          AppMethodBeat.o(193535);
        }
      }, 3000L);
      paramIntent = this.fFR;
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    try
    {
      this.fFV = ((a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", new Object[] { this.fFV });
      this.fFV.registerBroadcasts();
      if ((com.tencent.mm.compatible.util.d.lB(26)) && (Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.g.abt()))
      {
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(-1213, new Notification());
        }
      }
      else
      {
        localObject1 = new aq(Looper.getMainLooper());
        Mars.init(ak.getContext(), (aq)localObject1);
        StnLogic.setCallBack(new aj());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.aik();
        com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
        ad.aPE();
        ai.a(this.fFW);
        if (PlatformComm.resetprocessimp == null) {
          PlatformComm.resetprocessimp = this;
        }
        if (PlatformComm.reportCrashImp == null) {
          PlatformComm.reportCrashImp = this;
        }
        ad.a((aq)localObject1);
        ad.setContext(getApplicationContext());
        ad.a(new com.tencent.mm.network.ae());
        ad.a(new af());
        ad.a(this);
        ad.a(new z());
        this.fFR = ad.aPK();
        if (this.fFR != null) {
          break label774;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "autoAuth is null and new one");
        this.fFR = new t(ad.aPI());
        ad.g(this.fFR);
        Mars.onCreate(true);
        if (ad.aPL() != null) {
          break label792;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
        ad.a(new ac());
        if (ad.aPM() == null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
          ad.a(new ab());
          ad.aPM().iIV = this;
        }
        localObject4 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).fHC;
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).fHC = d.bL(getApplicationContext());
          localObject1 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).fHC;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "summerauths init debug here[%s]", new Object[] { localObject1 });
        }
        if (localObject1 != null)
        {
          localObject4 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.http");
          str1 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.http");
          localObject6 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.socket");
          String str2 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.socket");
          this.fFR.e((String)localObject4, str1, (String)localObject6, str2);
          localObject4 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.host");
          str1 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.ip");
          localObject6 = this.fFR;
          if ((!bu.isNullOrNil((String)localObject4)) && (!bu.V(new String[0]))) {
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
        this.fFR.setNewDnsDebugHost((String)localObject4, (String)localObject1);
        MMReceivers.AlarmReceiver.bP(getApplicationContext());
        MMReceivers.AlarmReceiver.bO(getApplicationContext());
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "networkInfo.state: %s", new Object[] { localObject1 });
          ad.aPG().iJo = false;
          ad.aPH().qK(0);
          ((PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class)).LGp.a(this);
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131840);
              if (Build.VERSION.SDK_INT > 23) {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "KeepAliveService.scheduleKeepAliveJob() flag:%s", new Object[] { Boolean.valueOf(KeepAliveService.WN()) });
              }
              AppMethodBeat.o(131840);
            }
          }, 1000L);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "CoreService OnCreate ");
          AppMethodBeat.o(131846);
          return;
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException1.getMessage() });
          continue;
          if (getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv()).getBoolean("set_service", false))
          {
            startForeground(-1213, new Notification());
            startService(new Intent(this, CoreService.InnerService.class));
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "set service for push.");
            continue;
            label774:
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.fFR.reset();
            continue;
            label792:
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            ad.aPL().reset();
            continue;
            label809:
            new t.14((t)localObject6, (String)localObject4, str1).b(((t)localObject6).handler);
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
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.CoreService", localException2, "", new Object[0]);
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[] { localException2.getMessage() });
          Object localObject3 = localObject5;
          continue;
          label920:
          localObject3 = ((NetworkInfo)localObject3).getState();
          continue;
          label928:
          ad.aPG().iJo = true;
          ad.aPH().qK(6);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131848);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
    try
    {
      ((PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class)).LGp.b(this);
      com.tencent.mm.jni.a.a.ail();
      super.onDestroy();
      WF();
      if (this.fFV == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.fFV.unRegisterBroadcasts();
          AppMethodBeat.o(131848);
          return;
        }
        catch (Exception localException2)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException2.getMessage() });
        }
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CoreService", "onDestroy onDestroy() mCoreServiceLifecycleCallbacks Exception: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(131848);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(131851);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
    AppMethodBeat.o(131851);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131847);
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[] { Integer.valueOf(this.fFX), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (i != this.fFX)
    {
      this.fFX = i;
      e.ywz.idkeyStat(99L, 141L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        e.ywz.idkeyStat(99L, 140L, 1L, false);
      }
    }
    AppMethodBeat.o(131847);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(131849);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
    ad.aPG().iJn = null;
    ad.aPN().iIP = null;
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(131849);
    return bool;
  }
  
  public void reportIdkey()
  {
    AppMethodBeat.i(131857);
    ay localay = ay.aRW("alarm_crash");
    long l = localay.getLong("report_time", 0L);
    if (ch.aDa() - l > 86400000L)
    {
      localay.edit().putLong("report_time", ch.aDa());
      e.ywz.idkeyStat(1204L, 0L, 1L, false);
    }
    AppMethodBeat.o(131857);
  }
  
  public void restartProcess()
  {
    AppMethodBeat.i(131856);
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.CoreService", "restartProcess");
    WF();
    AppMethodBeat.o(131856);
  }
  
  public static abstract interface a
  {
    public abstract void registerBroadcasts();
    
    public abstract void unRegisterBroadcasts();
  }
  
  public static abstract interface b
  {
    public abstract void br(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService
 * JD-Core Version:    0.7.0.1
 */