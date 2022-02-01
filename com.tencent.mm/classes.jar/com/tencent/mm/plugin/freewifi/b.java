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
  Lock aIY;
  private BroadcastReceiver broadcastReceiver;
  private long cAH;
  Condition cPA;
  private WifiManager cde;
  private Context context;
  String ssid;
  boolean tkE;
  boolean tkF;
  
  public b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(24638);
    this.tkE = false;
    this.tkF = false;
    this.cAH = 15000L;
    this.ssid = paramString;
    this.aIY = new ReentrantLock();
    this.cPA = this.aIY.newCondition();
    this.cde = ((WifiManager)paramContext.getSystemService("wifi"));
    this.context = paramContext;
    AppMethodBeat.o(24638);
  }
  
  private void cQG()
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
  
  public final int cQH()
  {
    AppMethodBeat.i(24639);
    if ((((ConnectivityManager)this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (this.ssid.equals(d.cRr())))
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
            ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { b.this.ssid, m.ajK("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramAnonymousContext.isConnected()), Boolean.valueOf(paramAnonymousContext.isConnectedOrConnecting()), paramAnonymousContext.getExtraInfo(), Integer.valueOf(paramAnonymousContext.getType()), paramAnonymousContext.toString() });
          }
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()) && (paramAnonymousContext.getType() == 1) && (b.this.ssid.equals(m.ajI(paramAnonymousContext.getExtraInfo())))) {
            try
            {
              b.this.aIY.lock();
              b.this.tkE = true;
              ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
              b.this.cPA.signalAll();
              return;
            }
            finally
            {
              b.this.aIY.unlock();
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
            ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { b.this.ssid, m.ajK("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramAnonymousContext.isConnected()), Boolean.valueOf(paramAnonymousContext.isConnectedOrConnecting()), paramAnonymousContext.getExtraInfo(), Integer.valueOf(paramAnonymousContext.getType()), paramAnonymousContext.toString() });
          }
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()) && (paramAnonymousContext.getType() == 1) && (b.this.ssid.equals(m.ajI(paramAnonymousContext.getExtraInfo())))) {
            try
            {
              b.this.aIY.lock();
              b.this.tkF = true;
              ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
              b.this.cPA.signalAll();
              return;
            }
            finally
            {
              b.this.aIY.unlock();
              AppMethodBeat.o(24637);
            }
          }
        }
        AppMethodBeat.o(24637);
      }
    };
    try
    {
      this.aIY.lock();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.broadcastReceiver, (IntentFilter)localObject1);
      if (!this.cde.isWifiEnabled())
      {
        i = new f(this.context).cQI();
        ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(i)));
        if (i != 0) {
          return i;
        }
      }
      int i = d.ajR(this.ssid);
      if (i != 0)
      {
        cQG();
        return i;
      }
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        try
        {
          if (this.tkE)
          {
            bool2 = bool1;
            if (this.tkF) {
              break;
            }
          }
          long l = System.currentTimeMillis();
          bool1 = this.cPA.await(this.cAH, TimeUnit.MILLISECONDS);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          l = System.currentTimeMillis() - l;
          this.cAH -= l;
          ad.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + l + "; left timeout=" + this.cAH);
          if (this.cAH > 0L)
          {
            l = this.cAH;
            this.cAH = l;
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
      cQG();
      this.aIY.unlock();
      AppMethodBeat.o(24639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b
 * JD-Core Version:    0.7.0.1
 */