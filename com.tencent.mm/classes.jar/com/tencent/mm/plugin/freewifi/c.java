package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  public Lock aIR;
  public Activity activity;
  public BroadcastReceiver broadcastReceiver;
  public WifiManager cnK;
  public boolean connected;
  public String dQC;
  public Condition dgF;
  public String ssid;
  public long timeout;
  public boolean wMF;
  
  public c(String paramString1, Activity paramActivity, String paramString2)
  {
    AppMethodBeat.i(24645);
    this.connected = false;
    this.wMF = false;
    this.activity = paramActivity;
    this.timeout = 30000L;
    this.ssid = paramString1;
    this.dQC = paramString2;
    this.aIR = new ReentrantLock();
    this.dgF = this.aIR.newCondition();
    this.cnK = ((WifiManager)MMApplicationContext.getContext().getSystemService("wifi"));
    AppMethodBeat.o(24645);
  }
  
  public final void dMu()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c
 * JD-Core Version:    0.7.0.1
 */