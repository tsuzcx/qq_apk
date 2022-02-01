package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b
{
  Lock aGr;
  private WifiManager bVj;
  private BroadcastReceiver broadcastReceiver;
  Condition cHn;
  private Context context;
  private long csI;
  boolean rfj;
  boolean rfk;
  String ssid;
  
  public b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(24638);
    this.rfj = false;
    this.rfk = false;
    this.csI = 15000L;
    this.ssid = paramString;
    this.aGr = new ReentrantLock();
    this.cHn = this.aGr.newCondition();
    this.bVj = ((WifiManager)paramContext.getSystemService("wifi"));
    this.context = paramContext;
    AppMethodBeat.o(24638);
  }
  
  private void cvf()
  {
    AppMethodBeat.i(24640);
    try
    {
      this.context.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(24640);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(24640);
    }
  }
  
  public final int cvg()
  {
    AppMethodBeat.i(24639);
    if ((((ConnectivityManager)this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (this.ssid.equals(d.cvQ())))
    {
      AppMethodBeat.o(24639);
      return 0;
    }
    Object localObject1;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      localObject1 = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
      AppMethodBeat.o(24639);
      throw ((Throwable)localObject1);
    }
    this.broadcastReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(24637);
        if (paramAnonymousIntent.getAction().equals("android.net.wifi.STATE_CHANGE"))
        {
          paramAnonymousContext = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
          if (paramAnonymousContext != null) {
            ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { b.this.ssid, m.aau("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramAnonymousContext.isConnected()), Boolean.valueOf(paramAnonymousContext.isConnectedOrConnecting()), paramAnonymousContext.getExtraInfo(), Integer.valueOf(paramAnonymousContext.getType()), paramAnonymousContext.toString() });
          }
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()) && (paramAnonymousContext.getType() == 1) && (b.this.ssid.equals(m.aas(paramAnonymousContext.getExtraInfo())))) {
            try
            {
              b.this.aGr.lock();
              b.this.rfj = true;
              ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
              b.this.cHn.signalAll();
              return;
            }
            finally
            {
              b.this.aGr.unlock();
              AppMethodBeat.o(24637);
            }
          }
          AppMethodBeat.o(24637);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          paramAnonymousContext = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
          if (paramAnonymousContext != null) {
            ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { b.this.ssid, m.aau("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramAnonymousContext.isConnected()), Boolean.valueOf(paramAnonymousContext.isConnectedOrConnecting()), paramAnonymousContext.getExtraInfo(), Integer.valueOf(paramAnonymousContext.getType()), paramAnonymousContext.toString() });
          }
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()) && (paramAnonymousContext.getType() == 1) && (b.this.ssid.equals(m.aas(paramAnonymousContext.getExtraInfo())))) {
            try
            {
              b.this.aGr.lock();
              b.this.rfk = true;
              ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
              b.this.cHn.signalAll();
              return;
            }
            finally
            {
              b.this.aGr.unlock();
              AppMethodBeat.o(24637);
            }
          }
        }
        AppMethodBeat.o(24637);
      }
    };
    try
    {
      this.aGr.lock();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.broadcastReceiver, (IntentFilter)localObject1);
      if (!this.bVj.isWifiEnabled())
      {
        i = new f(this.context).cvh();
        ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(i)));
        if (i != 0) {
          return i;
        }
      }
      int i = d.aaB(this.ssid);
      if (i != 0)
      {
        cvf();
        return i;
      }
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        try
        {
          if (this.rfj)
          {
            bool2 = bool1;
            if (this.rfk) {
              break;
            }
          }
          long l = System.currentTimeMillis();
          bool1 = this.cHn.await(this.csI, TimeUnit.MILLISECONDS);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          l = System.currentTimeMillis() - l;
          this.csI -= l;
          ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + l + "; left timeout=" + this.csI);
          if (this.csI > 0L)
          {
            l = this.csI;
            this.csI = l;
          }
          else
          {
            l = 3000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { localInterruptedException.getMessage() });
          return -17;
        }
      }
      if (!bool2) {
        return -16;
      }
      return 0;
    }
    finally
    {
      cvf();
      this.aGr.unlock();
      AppMethodBeat.o(24639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b
 * JD-Core Version:    0.7.0.1
 */