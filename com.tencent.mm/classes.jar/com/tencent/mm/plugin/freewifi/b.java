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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b
{
  Lock aIR;
  private BroadcastReceiver broadcastReceiver;
  private WifiManager cnK;
  private Context context;
  Condition dgF;
  String ssid;
  private long timeout;
  boolean wMA;
  boolean wMB;
  
  public b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(24638);
    this.wMA = false;
    this.wMB = false;
    this.timeout = 15000L;
    this.ssid = paramString;
    this.aIR = new ReentrantLock();
    this.dgF = this.aIR.newCondition();
    this.cnK = ((WifiManager)paramContext.getSystemService("wifi"));
    this.context = paramContext;
    AppMethodBeat.o(24638);
  }
  
  private void dMu()
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
  
  public final int dMv()
  {
    AppMethodBeat.i(24639);
    if ((((ConnectivityManager)this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (this.ssid.equals(d.dNf())))
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
            Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { b.this.ssid, m.axM("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramAnonymousContext.isConnected()), Boolean.valueOf(paramAnonymousContext.isConnectedOrConnecting()), paramAnonymousContext.getExtraInfo(), Integer.valueOf(paramAnonymousContext.getType()), paramAnonymousContext.toString() });
          }
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()) && (paramAnonymousContext.getType() == 1) && (b.this.ssid.equals(m.removeSsidQuote(paramAnonymousContext.getExtraInfo())))) {
            try
            {
              b.this.aIR.lock();
              b.this.wMA = true;
              Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
              b.this.dgF.signalAll();
              return;
            }
            finally
            {
              b.this.aIR.unlock();
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
            Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[] { b.this.ssid, m.axM("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(paramAnonymousContext.isConnected()), Boolean.valueOf(paramAnonymousContext.isConnectedOrConnecting()), paramAnonymousContext.getExtraInfo(), Integer.valueOf(paramAnonymousContext.getType()), paramAnonymousContext.toString() });
          }
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()) && (paramAnonymousContext.getType() == 1) && (b.this.ssid.equals(m.removeSsidQuote(paramAnonymousContext.getExtraInfo())))) {
            try
            {
              b.this.aIR.lock();
              b.this.wMB = true;
              Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
              b.this.dgF.signalAll();
              return;
            }
            finally
            {
              b.this.aIR.unlock();
              AppMethodBeat.o(24637);
            }
          }
        }
        AppMethodBeat.o(24637);
      }
    };
    try
    {
      this.aIR.lock();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.broadcastReceiver, (IntentFilter)localObject1);
      if (!this.cnK.isWifiEnabled())
      {
        i = new f(this.context).dMw();
        Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(i)));
        if (i != 0) {
          return i;
        }
      }
      int i = d.axT(this.ssid);
      if (i != 0)
      {
        dMu();
        return i;
      }
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        try
        {
          if (this.wMA)
          {
            bool2 = bool1;
            if (this.wMB) {
              break;
            }
          }
          long l = System.currentTimeMillis();
          bool1 = this.dgF.await(this.timeout, TimeUnit.MILLISECONDS);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          l = System.currentTimeMillis() - l;
          this.timeout -= l;
          Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + l + "; left timeout=" + this.timeout);
          if (this.timeout > 0L)
          {
            l = this.timeout;
            this.timeout = l;
          }
          else
          {
            l = 3000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { localInterruptedException.getMessage() });
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
      dMu();
      this.aIR.unlock();
      AppMethodBeat.o(24639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b
 * JD-Core Version:    0.7.0.1
 */