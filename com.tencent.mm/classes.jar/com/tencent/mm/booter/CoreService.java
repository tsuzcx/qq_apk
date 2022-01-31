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
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aa.a;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.12;
import com.tencent.mm.network.w;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.a;
import com.tencent.mm.sdk.platformtools.ac.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;

public class CoreService
  extends Service
  implements PlatformComm.IResetProcess, aa.a, m
{
  private t dhp;
  private e dhq = new e();
  private boolean dhr = true;
  private final ac.b dhs = new CoreService.1(this);
  private int dht = -1;
  private long dhu = 0L;
  private long dhv = 0L;
  private long dhw = 0L;
  private WakerLock dhx = null;
  private s dhy = new s();
  private am dhz = new am(new CoreService.4(this), false);
  
  public static void vU()
  {
    Intent localIntent = new Intent(aa.getContext(), NotifyReceiver.class);
    localIntent.putExtra("notify_option_type", 1);
    localIntent.putExtra("notify_uin", aa.Uu().eNL.CK());
    try
    {
      aa.getContext().sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[] { localException.toString() });
    }
  }
  
  private void vV()
  {
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
    aa.Uv().g(3, 10000, "");
    Mars.onDestroy();
    try
    {
      MMReceivers.AlarmReceiver.aW(getApplicationContext());
      MMReceivers.AlarmReceiver.aU(getApplicationContext());
      Alarm.resetAlarm(getApplicationContext());
      com.tencent.mm.sdk.platformtools.y.appenderClose();
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CoreService", localException, "", new Object[0]);
      }
    }
  }
  
  public final void ba(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CoreService", "[NETWORK LOST]");
      aa.Uq().eOY = false;
      aa.Ur().jG(0);
      if (this.dhr)
      {
        aa.Uu().TT();
        e locale = this.dhq;
        locale.dhI = null;
        locale.dhJ = null;
      }
      this.dhr = false;
      return;
    }
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
    aa.Uq().eOY = true;
    paramBoolean = this.dhq.vW();
    if ((this.dhr) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", new Object[] { Boolean.valueOf(this.dhr) });
      return;
    }
    if (paramBoolean) {
      aa.Uu().TT();
    }
    this.dhr = true;
    aa.Ur().jG(6);
    if (this.dhx == null) {
      this.dhx = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
    }
    if (!this.dhx.isLocking())
    {
      this.dhx.lock(6000L, "CoreService.setNetworkAvailable");
      this.dhu += 1L;
    }
    if (0L == this.dhw) {
      this.dhv = bk.UY();
    }
    this.dhw += 1L;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[] { Long.valueOf(this.dhu), Long.valueOf(this.dhw), Long.valueOf(bk.UY() - this.dhv) });
    this.dhz.S(3000L, 3000L);
  }
  
  public final boolean e(int paramInt, byte[] paramArrayOfByte)
  {
    if (l.bm(this))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
      return false;
    }
    if (paramInt == -255) {
      paramInt = 138;
    }
    for (;;)
    {
      boolean bool1 = aa.Un().getBoolean("is_in_notify_mode", false);
      boolean bool2 = bk.bE(this.dhp.eNL.Dj());
      boolean bool3 = aa.Uu().Ub();
      if ((bool1) && (!bool2) && (!bool3) && (f.a(2, paramInt, paramArrayOfByte, this.dhp.eNL.Dj(), bk.UY())))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "deal with notify sync in push");
        return true;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isSessionKeyNull:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      Intent localIntent = new Intent(this, NotifyReceiver.class);
      localIntent.putExtra("notify_option_type", 2);
      localIntent.putExtra("notify_uin", this.dhp.eNL.CK());
      localIntent.putExtra("notify_respType", paramInt);
      localIntent.putExtra("notify_respBuf", paramArrayOfByte);
      localIntent.putExtra("notfiy_recv_time", bk.UY());
      localIntent.putExtra("notify_skey", this.dhp.eNL.Dj());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "notify broadcast:" + localIntent.getAction() + ", type=" + paramInt);
      try
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", new Object[] { Long.valueOf(localIntent.getLongExtra("notfiy_recv_time", 0L)), Integer.valueOf(localIntent.getIntExtra("notify_uin", 0)), Integer.valueOf(localIntent.getIntExtra("notify_respType", 0)), Integer.valueOf(bk.i(localIntent.getByteArrayExtra("notify_respBuf"), new byte[0]).length) });
        sendBroadcast(localIntent);
        com.tencent.mm.am.a.iu(paramInt);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[] { bk.j(paramArrayOfByte) });
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CoreService", "onBind~~~ threadID:" + Thread.currentThread());
    return this.dhp;
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public void onCreate()
  {
    Object localObject4 = null;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    if ((Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.h.zK()))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        break label572;
      }
      startForeground(-1213, new Notification());
    }
    for (;;)
    {
      Object localObject1 = new ah(Looper.getMainLooper());
      Mars.init(ae.getContext(), (ah)localObject1);
      StnLogic.setCallBack(new af());
      IPxxLogic.setCallBack(new p());
      com.tencent.mm.jni.a.a.Co();
      com.tencent.mm.sdk.b.a.udP.c(new CoreService.2(this));
      aa.Uo();
      com.tencent.mm.sdk.platformtools.ac.a(this.dhs);
      if (PlatformComm.resetprocessimp == null) {
        PlatformComm.resetprocessimp = this;
      }
      aa.a((ah)localObject1);
      aa.setContext(getApplicationContext());
      aa.a(new ab());
      aa.a(new com.tencent.mm.network.ac());
      aa.a(this);
      aa.a(new w());
      this.dhp = aa.Uu();
      label230:
      Object localObject3;
      label258:
      String str1;
      Object localObject5;
      if (this.dhp == null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "autoAuth is null and new one");
        this.dhp = new t(aa.Us());
        aa.b(this.dhp);
        Mars.onCreate(true);
        if (aa.Uv() != null) {
          break label650;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
        aa.a(new z());
        if (aa.Uw() == null)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
          aa.a(new com.tencent.mm.network.y());
          aa.Uw().eOF = this;
          if (aa.Uz())
          {
            aa.co(false);
            aa.Us().post(new CoreService.3(this));
          }
        }
        localObject1 = ((com.tencent.mm.kernel.b.h)g.DM().Dr()).diu;
        if (localObject1 != null)
        {
          localObject3 = ((c)localObject1).getString(".com.tencent.mm.debug.server.host.http");
          str1 = ((c)localObject1).getString(".com.tencent.mm.debug.server.ports.http");
          localObject5 = ((c)localObject1).getString(".com.tencent.mm.debug.server.host.socket");
          String str2 = ((c)localObject1).getString(".com.tencent.mm.debug.server.ports.socket");
          this.dhp.d((String)localObject3, str1, (String)localObject5, str2);
          localObject3 = ((c)localObject1).getString(".com.tencent.mm.debug.server.wallet.host");
          str1 = ((c)localObject1).getString(".com.tencent.mm.debug.server.wallet.ip");
          localObject5 = this.dhp;
          if ((!bk.bl((String)localObject3)) && (!bk.H(new String[0]))) {
            break label667;
          }
        }
        label420:
        if (localObject1 != null) {
          break label691;
        }
        localObject1 = null;
        label426:
        if ((localObject1 == null) || (!((String)localObject1).contains(":"))) {
          break label702;
        }
        localObject3 = ((String)localObject1).split(":");
        localObject1 = localObject3[0];
        localObject3 = localObject3[1];
        this.dhp.setNewDnsDebugHost((String)localObject1, (String)localObject3);
        MMReceivers.AlarmReceiver.aW(getApplicationContext());
        MMReceivers.AlarmReceiver.aV(getApplicationContext());
        localObject1 = (ConnectivityManager)getSystemService("connectivity");
      }
      try
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject1 == null) || (((NetworkInfo)localObject1).getState() != NetworkInfo.State.CONNECTED)) {
          if (localObject1 == null)
          {
            localObject1 = "null";
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CoreService", "networkInfo.state: %s", new Object[] { localObject1 });
            aa.Uq().eOY = false;
            aa.Ur().jG(0);
            ((PluginZero)g.t(PluginZero.class)).rSg.a(this);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "CoreService OnCreate ");
            return;
            label572:
            if (!getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
              continue;
            }
            startForeground(-1213, new Notification());
            startService(new Intent(this, CoreService.InnerService.class));
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "set service for push.");
            continue;
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.dhp.reset();
            break label230;
            label650:
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            aa.Uv().reset();
            break label258;
            label667:
            new t.12((t)localObject5, (String)localObject3, str1).b(((t)localObject5).handler);
            break label420;
            label691:
            localObject1 = ((c)localObject1).getString(".com.tencent.mm.debug.server.host.newdns");
            break label426;
            label702:
            localObject3 = null;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CoreService", localException, "", new Object[0]);
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[] { localException.getMessage() });
          Object localObject2 = localObject4;
          continue;
          localObject2 = ((NetworkInfo)localObject2).getState();
          continue;
          aa.Uq().eOY = true;
          aa.Ur().jG(6);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
    ((PluginZero)g.t(PluginZero.class)).rSg.b(this);
    com.tencent.mm.jni.a.a.Cp();
    super.onDestroy();
    vV();
  }
  
  public void onRebind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = Process.myPid();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[] { Integer.valueOf(this.dht), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (i != this.dht)
    {
      this.dht = i;
      com.tencent.mm.plugin.report.f.nEG.a(99L, 141L, 1L, false);
      if ((paramIntent != null) && ("auto".equals(paramIntent.getStringExtra("START_TYPE")))) {
        com.tencent.mm.plugin.report.f.nEG.a(99L, 140L, 1L, false);
      }
    }
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
    aa.Uq().eOX = null;
    aa.Uy().eOy = null;
    return super.onUnbind(paramIntent);
  }
  
  public void restartProcess()
  {
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CoreService", "restartProcess");
    vV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService
 * JD-Core Version:    0.7.0.1
 */