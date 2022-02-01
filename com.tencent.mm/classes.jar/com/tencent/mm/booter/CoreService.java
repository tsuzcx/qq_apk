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
import com.tencent.mm.kernel.j;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.ad.a;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.14;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.service.c;
import java.util.ArrayList;

public class CoreService
  extends Service
  implements PlatformComm.IReportCrash, PlatformComm.IResetProcess, ad.a, m
{
  private static CoreService.b fin = null;
  private t fil;
  private f fim;
  private boolean fio;
  private a fip;
  private final ah.b fiq;
  private int fir;
  private int fit;
  private long fiu;
  private long fiv;
  private long fiw;
  private WakerLock fix;
  private q fiy;
  private av fiz;
  
  public CoreService()
  {
    AppMethodBeat.i(131845);
    this.fim = new f();
    this.fio = true;
    this.fip = null;
    this.fiq = new CoreService.1(this);
    this.fir = -1;
    this.fit = -1;
    this.fiu = 0L;
    this.fiv = 0L;
    this.fiw = 0L;
    this.fix = null;
    this.fiy = new q();
    this.fiz = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(192864);
        q localq = CoreService.a(CoreService.this);
        int i;
        if (bt.aS(localq.hUg) < localq.hUe)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + localq.hUg + ", cur=" + bt.GC() + ", retries=" + localq.hUh);
          if (localq.hUh <= 0)
          {
            i = 0;
            if (i != 0) {
              break label249;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
          }
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(CoreService.c(CoreService.this)), Long.valueOf(CoreService.d(CoreService.this)), Long.valueOf(bt.eGO() - CoreService.e(CoreService.this)) });
          CoreService.f(CoreService.this);
          CoreService.g(CoreService.this);
          CoreService.h(CoreService.this);
          new av(new av.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(192863);
              CoreService.i(CoreService.this).unLock();
              AppMethodBeat.o(192863);
              return false;
            }
          }, false).av(500L, 500L);
          AppMethodBeat.o(192864);
          return true;
          for (localq.hUh -= 1;; localq.hUh = localq.hUf)
          {
            localq.hUg = bt.GC();
            i = 1;
            break;
          }
          label249:
          boolean bool1 = CoreService.b(CoreService.this).hKZ.ava();
          boolean bool2 = com.tencent.mm.network.ad.aFo().aEO();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (!bool2) && (g.a(1, 0, null, CoreService.b(CoreService.this).hKZ.mq(1), bt.eGO())))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
            AppMethodBeat.o(192864);
            return true;
          }
          CoreService.Tl();
        }
      }
    }, false);
    AppMethodBeat.o(131845);
  }
  
  public static void Tl()
  {
    AppMethodBeat.i(131854);
    Intent localIntent = new Intent(com.tencent.mm.network.ad.getContext(), NotifyReceiver.class);
    localIntent.putExtra("notify_option_type", 1);
    localIntent.putExtra("notify_uin", com.tencent.mm.network.ad.aFo().hKZ.getUin());
    long l = Tn();
    localIntent.putExtra("notfiy_sync_num", l);
    try
    {
      com.tencent.mm.network.ad.getContext().sendBroadcast(localIntent);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "sendBorastToNotifyReceiver syncNum:%s", new Object[] { Long.valueOf(l) });
      if (bt.kU(b.ceD().b("clicfg_android_receive_msg_use_mmservice_switch", "0", false, true), "1"))
      {
        localIntent.setClass(com.tencent.mm.network.ad.getContext(), NotifyReceiver.NotifyReceiverService.class);
        localIntent.putExtra("notfiy_recv_time", bt.eGO());
        c.a(localIntent, "mm", true, new Intent(com.tencent.mm.sdk.platformtools.aj.getContext(), ProcessService.MMProcessService.class));
        e.vIY.idkeyStat(1042L, 62L, 1L, false);
      }
      AppMethodBeat.o(131854);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[] { localException.toString() });
      AppMethodBeat.o(131854);
    }
  }
  
  private void Tm()
  {
    AppMethodBeat.i(131855);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
    com.tencent.mm.network.ad.aFp().m(3, 10000, "");
    Mars.onDestroy();
    try
    {
      MMReceivers.AlarmReceiver.bL(getApplicationContext());
      MMReceivers.AlarmReceiver.bJ(getApplicationContext());
      Alarm.resetAlarm(getApplicationContext());
      com.tencent.mm.sdk.platformtools.ad.appenderClose();
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(131855);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.CoreService", localException, "", new Object[0]);
      }
    }
  }
  
  private static long Tn()
  {
    AppMethodBeat.i(131858);
    ax localax = ax.aFC("msg_receive_number");
    long l = localax.getLong("send_num", 0L) + 1L;
    localax.edit().putLong("send_num", l);
    AppMethodBeat.o(131858);
    return l;
  }
  
  public static void To()
  {
    AppMethodBeat.i(192866);
    ax localax = ax.aFC("msg_receive_number");
    long l1 = localax.getLong("recv_num", 0L);
    long l2 = localax.getLong("send_num", 0L);
    long l3 = l1 - l2;
    if (l3 > 0L)
    {
      localax.edit().putLong("send_num", 1L + l1);
      e.vIY.f(19779, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "checkSyncNum() why?????? diffValue:%s recvNum:%s sendNum:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(192866);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "checkSyncNum() no problem");
    AppMethodBeat.o(192866);
  }
  
  public static void a(CoreService.b paramb)
  {
    fin = paramb;
  }
  
  private static IDKey cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192865);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "idkeyPushSetupTimeReport %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1391);
    localIDKey.SetKey(paramInt1);
    localIDKey.SetValue(paramInt2);
    AppMethodBeat.o(192865);
    return localIDKey;
  }
  
  public static long ld(long paramLong)
  {
    AppMethodBeat.i(131859);
    ax localax = ax.aFC("msg_receive_number");
    long l = paramLong - localax.getLong("recv_num", 0L);
    if (l > 0L)
    {
      localax.edit().putLong("recv_num", paramLong);
      AppMethodBeat.o(131859);
      return 1L;
    }
    AppMethodBeat.o(131859);
    return l;
  }
  
  public final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(131853);
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CoreService", "[NETWORK LOST]");
      com.tencent.mm.network.ad.aFk().hMG = false;
      com.tencent.mm.network.ad.aFl().pr(0);
      if (this.fio)
      {
        com.tencent.mm.network.ad.aFo().aEH();
        f localf = this.fim;
        localf.fiM = null;
        localf.fiO = "";
        localf.fiN = "";
        localf.fiP = -1;
      }
      this.fio = false;
      AppMethodBeat.o(131853);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
    com.tencent.mm.network.ad.aFk().hMG = true;
    paramBoolean = this.fim.Tv();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "lastConnected %s, isNetWorkChange %s", new Object[] { Boolean.valueOf(this.fio), Boolean.valueOf(paramBoolean) });
    if ((this.fio) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "network not change or can't get network info");
      AppMethodBeat.o(131853);
      return;
    }
    if (paramBoolean) {
      com.tencent.mm.network.ad.aFo().aEH();
    }
    this.fio = true;
    com.tencent.mm.network.ad.aFl().pr(6);
    if (this.fix == null) {
      this.fix = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
    }
    if (!this.fix.isLocking())
    {
      this.fix.lock(6000L, "CoreService.setNetworkAvailable");
      this.fiu += 1L;
    }
    if (0L == this.fiw) {
      this.fiv = bt.eGO();
    }
    this.fiw += 1L;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(this.fiu), Long.valueOf(this.fiw), Long.valueOf(bt.eGO() - this.fiv) });
    this.fiz.av(3000L, 3000L);
    AppMethodBeat.o(131853);
  }
  
  public final boolean f(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131852);
    if (l.cj(this))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
      AppMethodBeat.o(131852);
      return false;
    }
    if (paramInt == -255) {
      paramInt = 138;
    }
    for (;;)
    {
      boolean bool1 = com.tencent.mm.network.ad.aFh().getBoolean("is_in_notify_mode", false);
      boolean bool2 = this.fil.hKZ.ava();
      boolean bool3 = com.tencent.mm.network.ad.aFo().aEO();
      if ((bool1) && (bool2) && (!bool3) && (g.a(2, paramInt, paramArrayOfByte, this.fil.hKZ.mq(1), bt.eGO())))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "deal with notify sync in push");
        AppMethodBeat.o(131852);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      Intent localIntent = new Intent(this, NotifyReceiver.class);
      localIntent.putExtra("notify_option_type", 2);
      localIntent.putExtra("notify_uin", this.fil.hKZ.getUin());
      localIntent.putExtra("notify_respType", paramInt);
      localIntent.putExtra("notify_respBuf", paramArrayOfByte);
      localIntent.putExtra("notify_skey", this.fil.hKZ.mq(1));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "notify broadcast:" + localIntent.getAction() + ", type=" + paramInt);
      try
      {
        long l = Tn();
        localIntent.putExtra("notfiy_sync_num", l);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d syncNum:%s", new Object[] { Long.valueOf(localIntent.getLongExtra("notfiy_recv_time", 0L)), Integer.valueOf(localIntent.getIntExtra("notify_uin", 0)), Integer.valueOf(localIntent.getIntExtra("notify_respType", 0)), Integer.valueOf(bt.m(localIntent.getByteArrayExtra("notify_respBuf"), new byte[0]).length), Long.valueOf(l) });
        localIntent.putExtra("notfiy_recv_time", bt.eGO());
        sendBroadcast(localIntent);
        e.vIY.idkeyStat(1042L, 60L, 1L, false);
        com.tencent.mm.aq.a.y(paramInt, l);
        if (bt.kU(b.ceD().b("clicfg_android_receive_msg_use_mmservice_switch", "0", false, true), "1"))
        {
          localIntent.setClass(this, NotifyReceiver.NotifyReceiverService.class);
          localIntent.putExtra("notfiy_recv_time", bt.eGO());
          c.a(localIntent, "mm", true, new Intent(com.tencent.mm.sdk.platformtools.aj.getContext(), ProcessService.MMProcessService.class));
          e.vIY.idkeyStat(1042L, 62L, 1L, false);
        }
        AppMethodBeat.o(131852);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[] { bt.m(paramArrayOfByte) });
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(131850);
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), new Object[] { Integer.valueOf(this.fit), Integer.valueOf(i) });
    if (i != this.fit)
    {
      this.fit = i;
      e.vIY.idkeyStat(99L, 147L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        e.vIY.idkeyStat(99L, 146L, 1L, false);
      }
      i = (int)(SystemClock.elapsedRealtime() - j.afH());
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
      e.vIY.b(paramIntent, false);
      com.tencent.e.h.Iye.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192862);
          CoreService.Tp();
          AppMethodBeat.o(192862);
        }
      }, 3000L);
      paramIntent = this.fil;
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    try
    {
      this.fip = ((a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", new Object[] { this.fip });
      this.fip.registerBroadcasts();
      if ((com.tencent.mm.compatible.util.d.lg(26)) && (Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.g.XL()))
      {
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(-1213, new Notification());
        }
      }
      else
      {
        localObject1 = new ap(Looper.getMainLooper());
        Mars.init(com.tencent.mm.sdk.platformtools.aj.getContext(), (ap)localObject1);
        StnLogic.setCallBack(new com.tencent.mm.network.aj());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.adT();
        com.tencent.mm.sdk.b.a.ESL.c(new CoreService.2(this));
        com.tencent.mm.network.ad.aFi();
        ah.a(this.fiq);
        if (PlatformComm.resetprocessimp == null) {
          PlatformComm.resetprocessimp = this;
        }
        if (PlatformComm.reportCrashImp == null) {
          PlatformComm.reportCrashImp = this;
        }
        com.tencent.mm.network.ad.a((ap)localObject1);
        com.tencent.mm.network.ad.setContext(getApplicationContext());
        com.tencent.mm.network.ad.a(new ae());
        com.tencent.mm.network.ad.a(new af());
        com.tencent.mm.network.ad.a(this);
        com.tencent.mm.network.ad.a(new z());
        this.fil = com.tencent.mm.network.ad.aFo();
        if (this.fil != null) {
          break label774;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "autoAuth is null and new one");
        this.fil = new t(com.tencent.mm.network.ad.aFm());
        com.tencent.mm.network.ad.g(this.fil);
        Mars.onCreate(true);
        if (com.tencent.mm.network.ad.aFp() != null) {
          break label792;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
        com.tencent.mm.network.ad.a(new ac());
        if (com.tencent.mm.network.ad.aFq() == null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
          com.tencent.mm.network.ad.a(new ab());
          com.tencent.mm.network.ad.aFq().hMo = this;
        }
        localObject4 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).fjW;
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).fjW = d.bH(getApplicationContext());
          localObject1 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).fjW;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "summerauths init debug here[%s]", new Object[] { localObject1 });
        }
        if (localObject1 != null)
        {
          localObject4 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.http");
          str1 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.http");
          localObject6 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.socket");
          String str2 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.socket");
          this.fil.d((String)localObject4, str1, (String)localObject6, str2);
          localObject4 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.host");
          str1 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.ip");
          localObject6 = this.fil;
          if ((!bt.isNullOrNil((String)localObject4)) && (!bt.T(new String[0]))) {
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
        this.fil.setNewDnsDebugHost((String)localObject4, (String)localObject1);
        MMReceivers.AlarmReceiver.bL(getApplicationContext());
        MMReceivers.AlarmReceiver.bK(getApplicationContext());
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
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "networkInfo.state: %s", new Object[] { localObject1 });
          com.tencent.mm.network.ad.aFk().hMG = false;
          com.tencent.mm.network.ad.aFl().pr(0);
          ((PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class)).Lwr.a(this);
          aq.n(new CoreService.3(this), 1000L);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "CoreService OnCreate ");
          AppMethodBeat.o(131846);
          return;
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException1.getMessage() });
          continue;
          if (getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN()).getBoolean("set_service", false))
          {
            startForeground(-1213, new Notification());
            startService(new Intent(this, CoreService.InnerService.class));
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "set service for push.");
            continue;
            label774:
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.fil.reset();
            continue;
            label792:
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            com.tencent.mm.network.ad.aFp().reset();
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
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.CoreService", localException2, "", new Object[0]);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[] { localException2.getMessage() });
          Object localObject3 = localObject5;
          continue;
          label920:
          localObject3 = ((NetworkInfo)localObject3).getState();
          continue;
          label928:
          com.tencent.mm.network.ad.aFk().hMG = true;
          com.tencent.mm.network.ad.aFl().pr(6);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131848);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
    try
    {
      ((PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class)).Lwr.b(this);
      com.tencent.mm.jni.a.a.adU();
      super.onDestroy();
      Tm();
      if (this.fip == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.fip.unRegisterBroadcasts();
          AppMethodBeat.o(131848);
          return;
        }
        catch (Exception localException2)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException2.getMessage() });
        }
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CoreService", "onDestroy onDestroy() mCoreServiceLifecycleCallbacks Exception: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(131848);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(131851);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
    AppMethodBeat.o(131851);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131847);
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[] { Integer.valueOf(this.fir), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (i != this.fir)
    {
      this.fir = i;
      e.vIY.idkeyStat(99L, 141L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        e.vIY.idkeyStat(99L, 140L, 1L, false);
      }
    }
    AppMethodBeat.o(131847);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(131849);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
    com.tencent.mm.network.ad.aFk().hMF = null;
    com.tencent.mm.network.ad.aFr().hMi = null;
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(131849);
    return bool;
  }
  
  public void reportIdkey()
  {
    AppMethodBeat.i(131857);
    ax localax = ax.aFC("alarm_crash");
    long l = localax.getLong("report_time", 0L);
    if (ce.asQ() - l > 86400000L)
    {
      localax.edit().putLong("report_time", ce.asQ());
      e.vIY.idkeyStat(1204L, 0L, 1L, false);
    }
    AppMethodBeat.o(131857);
  }
  
  public void restartProcess()
  {
    AppMethodBeat.i(131856);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CoreService", "restartProcess");
    Tm();
    AppMethodBeat.o(131856);
  }
  
  public static abstract interface a
  {
    public abstract void registerBroadcasts();
    
    public abstract void unRegisterBroadcasts();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService
 * JD-Core Version:    0.7.0.1
 */