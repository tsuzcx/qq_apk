package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  public Lock aGr;
  public Activity activity;
  public WifiManager bVj;
  public BroadcastReceiver broadcastReceiver;
  public Condition cHn;
  public boolean connected;
  public long csI;
  public String dom;
  public boolean rfo;
  public String ssid;
  
  public c(String paramString1, Activity paramActivity, String paramString2)
  {
    AppMethodBeat.i(24645);
    this.connected = false;
    this.rfo = false;
    this.activity = paramActivity;
    this.csI = 30000L;
    this.ssid = paramString1;
    this.dom = paramString2;
    this.aGr = new ReentrantLock();
    this.cHn = this.aGr.newCondition();
    this.bVj = ((WifiManager)aj.getContext().getSystemService("wifi"));
    AppMethodBeat.o(24645);
  }
  
  public final void cvf()
  {
    AppMethodBeat.i(24646);
    try
    {
      this.activity.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(24646);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(24646);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c
 * JD-Core Version:    0.7.0.1
 */