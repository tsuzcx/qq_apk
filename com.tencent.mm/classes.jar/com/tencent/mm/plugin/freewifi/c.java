package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  public Lock aHh;
  public Activity activity;
  public WifiManager bSR;
  public BroadcastReceiver broadcastReceiver;
  public Condition cEv;
  public boolean connected;
  public long cpQ;
  public String dlV;
  public boolean sog;
  public String ssid;
  
  public c(String paramString1, Activity paramActivity, String paramString2)
  {
    AppMethodBeat.i(24645);
    this.connected = false;
    this.sog = false;
    this.activity = paramActivity;
    this.cpQ = 30000L;
    this.ssid = paramString1;
    this.dlV = paramString2;
    this.aHh = new ReentrantLock();
    this.cEv = this.aHh.newCondition();
    this.bSR = ((WifiManager)ai.getContext().getSystemService("wifi"));
    AppMethodBeat.o(24645);
  }
  
  public final void cIr()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c
 * JD-Core Version:    0.7.0.1
 */