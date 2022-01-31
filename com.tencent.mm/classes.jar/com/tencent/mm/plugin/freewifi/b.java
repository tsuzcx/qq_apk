package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b
{
  Condition bVg;
  private BroadcastReceiver broadcastReceiver;
  private WifiManager bsO;
  private Context context;
  private long ftP;
  Lock mHZ;
  boolean mIa;
  boolean mIb;
  String ssid;
  
  public b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(20561);
    this.mIa = false;
    this.mIb = false;
    this.ftP = 15000L;
    this.ssid = paramString;
    this.mHZ = new ReentrantLock();
    this.bVg = this.mHZ.newCondition();
    this.bsO = ((WifiManager)paramContext.getSystemService("wifi"));
    this.context = paramContext;
    AppMethodBeat.o(20561);
  }
  
  private void bzQ()
  {
    AppMethodBeat.i(20563);
    try
    {
      this.context.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(20563);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(20563);
    }
  }
  
  public final int bzR()
  {
    AppMethodBeat.i(20562);
    if ((((ConnectivityManager)this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) && (this.ssid.equals(d.bAC())))
    {
      AppMethodBeat.o(20562);
      return 0;
    }
    Object localObject1;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      localObject1 = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
      AppMethodBeat.o(20562);
      throw ((Throwable)localObject1);
    }
    this.broadcastReceiver = new b.1(this);
    try
    {
      this.mHZ.lock();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.broadcastReceiver, (IntentFilter)localObject1);
      if (!this.bsO.isWifiEnabled())
      {
        i = new f(this.context).bzS();
        ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(i)));
        if (i != 0) {
          return i;
        }
      }
      int i = d.OD(this.ssid);
      if (i != 0)
      {
        bzQ();
        return i;
      }
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        try
        {
          if (this.mIa)
          {
            bool2 = bool1;
            if (this.mIb) {
              break;
            }
          }
          long l = System.currentTimeMillis();
          bool1 = this.bVg.await(this.ftP, TimeUnit.MILLISECONDS);
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          l = System.currentTimeMillis() - l;
          this.ftP -= l;
          ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + l + "; left timeout=" + this.ftP);
          if (this.ftP > 0L)
          {
            l = this.ftP;
            this.ftP = l;
          }
          else
          {
            l = 3000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[] { localInterruptedException.getMessage() });
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
      bzQ();
      this.mHZ.unlock();
      AppMethodBeat.o(20562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b
 * JD-Core Version:    0.7.0.1
 */