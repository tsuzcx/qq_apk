package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b
{
  private WifiManager bci;
  Condition btV;
  private Context context;
  private long edM = 15000L;
  Lock kmn;
  boolean kmo = false;
  boolean kmp = false;
  private BroadcastReceiver kmq;
  String ssid;
  
  public b(String paramString, Context paramContext)
  {
    this.ssid = paramString;
    this.kmn = new ReentrantLock();
    this.btV = this.kmn.newCondition();
    this.bci = ((WifiManager)paramContext.getSystemService("wifi"));
    this.context = paramContext;
  }
  
  private void aTl()
  {
    try
    {
      this.context.unregisterReceiver(this.kmq);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public final int aTm()
  {
    if ((((ConnectivityManager)this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (this.ssid.equals(d.aUa()))) {
      return 0;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
    }
    this.kmq = new b.1(this);
    try
    {
      this.kmn.lock();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.kmq, localIntentFilter);
      if (!this.bci.isWifiEnabled())
      {
        i = new f(this.context).aTn();
        y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + i);
        if (i != 0) {
          return i;
        }
      }
      int i = d.Dv(this.ssid);
      if (i != 0)
      {
        aTl();
        return i;
      }
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        try
        {
          if (this.kmo)
          {
            bool2 = bool1;
            if (this.kmp) {
              break;
            }
          }
          long l = System.currentTimeMillis();
          bool1 = this.btV.await(this.edM, TimeUnit.MILLISECONDS);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          l = System.currentTimeMillis() - l;
          this.edM -= l;
          y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + l + "; left timeout=" + this.edM);
          if (this.edM > 0L)
          {
            l = this.edM;
            this.edM = l;
          }
          else
          {
            l = 3000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          y.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { localInterruptedException.getMessage() });
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
      aTl();
      this.kmn.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b
 * JD-Core Version:    0.7.0.1
 */