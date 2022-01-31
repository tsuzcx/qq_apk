package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.ab.a;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.13;
import com.tencent.mm.network.x;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

public class CoreService
  extends Service
  implements PlatformComm.IResetProcess, ab.a, m
{
  private t dYA;
  private f dYB;
  private boolean dYC;
  private CoreService.a dYD;
  private final af.b dYE;
  private int dYF;
  private int dYG;
  private long dYH;
  private long dYI;
  private long dYJ;
  private WakerLock dYK;
  private s dYL;
  private ap dYM;
  
  public CoreService()
  {
    AppMethodBeat.i(57732);
    this.dYB = new f();
    this.dYC = true;
    this.dYD = null;
    this.dYE = new af.b()
    {
      public final void cancel()
      {
        AppMethodBeat.i(57724);
        MMReceivers.AlarmReceiver.bv(CoreService.this.getApplicationContext());
        AppMethodBeat.o(57724);
      }
      
      public final void prepare()
      {
        AppMethodBeat.i(57723);
        MMReceivers.AlarmReceiver.bu(CoreService.this.getApplicationContext());
        AppMethodBeat.o(57723);
      }
    };
    this.dYF = -1;
    this.dYG = -1;
    this.dYH = 0L;
    this.dYI = 0L;
    this.dYJ = 0L;
    this.dYK = null;
    this.dYL = new s();
    this.dYM = new ap(new CoreService.4(this), false);
    AppMethodBeat.o(57732);
  }
  
  public static void Id()
  {
    AppMethodBeat.i(57741);
    Intent localIntent = new Intent(com.tencent.mm.network.ab.getContext(), NotifyReceiver.class);
    localIntent.putExtra("notify_option_type", 1);
    localIntent.putExtra("notify_uin", com.tencent.mm.network.ab.anF().gdz.getUin());
    try
    {
      com.tencent.mm.network.ab.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(57741);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[] { localException.toString() });
      AppMethodBeat.o(57741);
    }
  }
  
  private void Ie()
  {
    AppMethodBeat.i(57742);
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
    com.tencent.mm.network.ab.anG().k(3, 10000, "");
    Mars.onDestroy();
    try
    {
      MMReceivers.AlarmReceiver.bx(getApplicationContext());
      MMReceivers.AlarmReceiver.bv(getApplicationContext());
      Alarm.resetAlarm(getApplicationContext());
      com.tencent.mm.sdk.platformtools.ab.appenderClose();
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(57742);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.CoreService", localException, "", new Object[0]);
      }
    }
  }
  
  public final void bC(boolean paramBoolean)
  {
    AppMethodBeat.i(57740);
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.CoreService", "[NETWORK LOST]");
      com.tencent.mm.network.ab.anB().geL = false;
      com.tencent.mm.network.ab.anC().mC(0);
      if (this.dYC)
      {
        com.tencent.mm.network.ab.anF().anh();
        f localf = this.dYB;
        localf.dYZ = null;
        localf.dZb = "";
        localf.dZa = "";
        localf.dZc = -1;
      }
      this.dYC = false;
      AppMethodBeat.o(57740);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
    com.tencent.mm.network.ab.anB().geL = true;
    paramBoolean = this.dYB.Ik();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "lastConnected %s, isNetWorkChange %s", new Object[] { Boolean.valueOf(this.dYC), Boolean.valueOf(paramBoolean) });
    if ((this.dYC) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "network not change or can't get network info");
      AppMethodBeat.o(57740);
      return;
    }
    if (paramBoolean) {
      com.tencent.mm.network.ab.anF().anh();
    }
    this.dYC = true;
    com.tencent.mm.network.ab.anC().mC(6);
    if (this.dYK == null) {
      this.dYK = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
    }
    if (!this.dYK.isLocking())
    {
      this.dYK.lock(6000L, "CoreService.setNetworkAvailable");
      this.dYH += 1L;
    }
    if (0L == this.dYJ) {
      this.dYI = bo.aoy();
    }
    this.dYJ += 1L;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(this.dYH), Long.valueOf(this.dYJ), Long.valueOf(bo.aoy() - this.dYI) });
    this.dYM.ag(3000L, 3000L);
    AppMethodBeat.o(57740);
  }
  
  public final boolean e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57739);
    if (l.bQ(this))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
      AppMethodBeat.o(57739);
      return false;
    }
    if (paramInt == -255) {
      paramInt = 138;
    }
    for (;;)
    {
      boolean bool1 = com.tencent.mm.network.ab.any().getBoolean("is_in_notify_mode", false);
      boolean bool2 = this.dYA.gdz.adC();
      boolean bool3 = com.tencent.mm.network.ab.anF().ano();
      if ((bool1) && (bool2) && (!bool3) && (g.a(2, paramInt, paramArrayOfByte, this.dYA.gdz.jN(1), bo.aoy())))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "deal with notify sync in push");
        AppMethodBeat.o(57739);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      Intent localIntent = new Intent(this, NotifyReceiver.class);
      localIntent.putExtra("notify_option_type", 2);
      localIntent.putExtra("notify_uin", this.dYA.gdz.getUin());
      localIntent.putExtra("notify_respType", paramInt);
      localIntent.putExtra("notify_respBuf", paramArrayOfByte);
      localIntent.putExtra("notfiy_recv_time", bo.aoy());
      localIntent.putExtra("notify_skey", this.dYA.gdz.jN(1));
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "notify broadcast:" + localIntent.getAction() + ", type=" + paramInt);
      try
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", new Object[] { Long.valueOf(localIntent.getLongExtra("notfiy_recv_time", 0L)), Integer.valueOf(localIntent.getIntExtra("notify_uin", 0)), Integer.valueOf(localIntent.getIntExtra("notify_respType", 0)), Integer.valueOf(bo.l(localIntent.getByteArrayExtra("notify_respBuf"), new byte[0]).length) });
        sendBroadcast(localIntent);
        com.tencent.mm.an.a.li(paramInt);
        AppMethodBeat.o(57739);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[] { bo.l(paramArrayOfByte) });
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(57737);
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), new Object[] { Integer.valueOf(this.dYG), Integer.valueOf(i) });
    if (i != this.dYG)
    {
      this.dYG = i;
      e.qrI.idkeyStat(99L, 147L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        e.qrI.idkeyStat(99L, 146L, 1L, false);
      }
    }
    paramIntent = this.dYA;
    AppMethodBeat.o(57737);
    return paramIntent;
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public void onCreate()
  {
    Object localObject4 = null;
    AppMethodBeat.i(57733);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    try
    {
      this.dYD = ((CoreService.a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", new Object[] { this.dYD });
      this.dYD.registerBroadcasts();
      if ((com.tencent.mm.compatible.util.d.fw(26)) && (Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.h.Mn()))
      {
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(-1213, new Notification());
        }
      }
      else
      {
        localObject1 = new ak(Looper.getMainLooper());
        Mars.init(ah.getContext(), (ak)localObject1);
        StnLogic.setCallBack(new ag());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.Qh();
        com.tencent.mm.sdk.b.a.ymk.c(new CoreService.2(this));
        com.tencent.mm.network.ab.anz();
        af.a(this.dYE);
        if (PlatformComm.resetprocessimp == null) {
          PlatformComm.resetprocessimp = this;
        }
        com.tencent.mm.network.ab.a((ak)localObject1);
        com.tencent.mm.network.ab.setContext(getApplicationContext());
        com.tencent.mm.network.ab.a(new ac());
        com.tencent.mm.network.ab.a(new ad());
        com.tencent.mm.network.ab.a(this);
        com.tencent.mm.network.ab.a(new x());
        this.dYA = com.tencent.mm.network.ab.anF();
        if (this.dYA != null) {
          break label764;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "autoAuth is null and new one");
        this.dYA = new t(com.tencent.mm.network.ab.anD());
        com.tencent.mm.network.ab.b(this.dYA);
        Mars.onCreate(true);
        if (com.tencent.mm.network.ab.anG() != null) {
          break label782;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
        com.tencent.mm.network.ab.a(new aa());
        if (com.tencent.mm.network.ab.anH() == null)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
          com.tencent.mm.network.ab.a(new z());
          com.tencent.mm.network.ab.anH().ges = this;
        }
        localObject3 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).dZN;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).dZN = d.bt(getApplicationContext());
          localObject1 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).dZN;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "summerauths init debug here[%s]", new Object[] { localObject1 });
        }
        if (localObject1 != null)
        {
          localObject3 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.http");
          str2 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.http");
          localObject5 = ((d)localObject1).getString(".com.tencent.mm.debug.server.host.socket");
          String str3 = ((d)localObject1).getString(".com.tencent.mm.debug.server.ports.socket");
          this.dYA.d((String)localObject3, str2, (String)localObject5, str3);
          localObject3 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.host");
          str2 = ((d)localObject1).getString(".com.tencent.mm.debug.server.wallet.ip");
          localObject5 = this.dYA;
          if ((!bo.isNullOrNil((String)localObject3)) && (!bo.Q(new String[0]))) {
            break label799;
          }
        }
        if (localObject1 != null) {
          break label823;
        }
        localObject1 = null;
        if ((localObject1 == null) || (!((String)localObject1).contains(":"))) {
          break label834;
        }
        localObject3 = ((String)localObject1).split(":");
        localObject1 = localObject3[0];
        localObject3 = localObject3[1];
        this.dYA.setNewDnsDebugHost((String)localObject1, (String)localObject3);
        MMReceivers.AlarmReceiver.bx(getApplicationContext());
        MMReceivers.AlarmReceiver.bw(getApplicationContext());
        localObject1 = (ConnectivityManager)getSystemService("connectivity");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str2;
          Object localObject5;
          Object localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if ((localObject1 != null) && (((NetworkInfo)localObject1).getState() == NetworkInfo.State.CONNECTED)) {
            break label884;
          }
          if (localObject1 != null) {
            break;
          }
          localObject1 = "null";
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "networkInfo.state: %s", new Object[] { localObject1 });
          com.tencent.mm.network.ab.anB().geL = false;
          com.tencent.mm.network.ab.anC().mC(0);
          ((PluginZero)com.tencent.mm.kernel.g.G(PluginZero.class)).yLW.a(this);
          al.p(new CoreService.3(this), 1000L);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "CoreService OnCreate ");
          AppMethodBeat.o(57733);
          return;
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException1.getMessage() });
          continue;
          if (getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getBoolean("set_service", false))
          {
            startForeground(-1213, new Notification());
            startService(new Intent(this, InnerService.class));
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "set service for push.");
            continue;
            label764:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.dYA.reset();
            continue;
            label782:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            com.tencent.mm.network.ab.anG().reset();
            continue;
            label799:
            new t.13((t)localObject5, (String)localObject3, str2).b(((t)localObject5).handler);
            continue;
            label823:
            String str1 = localException1.getString(".com.tencent.mm.debug.server.host.newdns");
          }
        }
        label834:
        Object localObject3 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.CoreService", localException2, "", new Object[0]);
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[] { localException2.getMessage() });
          Object localObject2 = localObject4;
          continue;
          localObject2 = ((NetworkInfo)localObject2).getState();
          continue;
          label884:
          com.tencent.mm.network.ab.anB().geL = true;
          com.tencent.mm.network.ab.anC().mC(6);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(57735);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
    try
    {
      ((PluginZero)com.tencent.mm.kernel.g.G(PluginZero.class)).yLW.b(this);
      com.tencent.mm.jni.a.a.Qi();
      super.onDestroy();
      Ie();
      if (this.dYD == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.dYD.unRegisterBroadcasts();
          AppMethodBeat.o(57735);
          return;
        }
        catch (Exception localException2)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException2.getMessage() });
        }
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "onDestroy onDestroy() mCoreServiceLifecycleCallbacks Exception: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(57735);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(57738);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
    AppMethodBeat.o(57738);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57734);
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[] { Integer.valueOf(this.dYF), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (i != this.dYF)
    {
      this.dYF = i;
      e.qrI.idkeyStat(99L, 141L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        e.qrI.idkeyStat(99L, 140L, 1L, false);
      }
    }
    AppMethodBeat.o(57734);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(57736);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
    com.tencent.mm.network.ab.anB().geK = null;
    com.tencent.mm.network.ab.anJ().gem = null;
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(57736);
    return bool;
  }
  
  public void restartProcess()
  {
    AppMethodBeat.i(57743);
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.CoreService", "restartProcess");
    Ie();
    AppMethodBeat.o(57743);
  }
  
  public static class InnerService
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      AppMethodBeat.i(57730);
      super.onCreate();
      try
      {
        startForeground(-1213, new Notification());
        stopSelf();
        AppMethodBeat.o(57730);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CoreService", "set service for push exception:%s.", new Object[] { localNullPointerException });
        }
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(57731);
      stopForeground(true);
      super.onDestroy();
      AppMethodBeat.o(57731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService
 * JD-Core Version:    0.7.0.1
 */