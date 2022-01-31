package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  public Activity activity;
  public Condition bVg;
  public BroadcastReceiver broadcastReceiver;
  public WifiManager bsO;
  public boolean connected;
  public long ftP;
  public String gFE;
  public Lock mHZ;
  public boolean mIg;
  public String ssid;
  
  public c(String paramString1, Activity paramActivity, String paramString2)
  {
    AppMethodBeat.i(20568);
    this.connected = false;
    this.mIg = false;
    this.activity = paramActivity;
    this.ftP = 30000L;
    this.ssid = paramString1;
    this.gFE = paramString2;
    this.mHZ = new ReentrantLock();
    this.bVg = this.mHZ.newCondition();
    this.bsO = ((WifiManager)ah.getContext().getSystemService("wifi"));
    AppMethodBeat.o(20568);
  }
  
  public final void bzQ()
  {
    AppMethodBeat.i(20569);
    try
    {
      this.activity.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(20569);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(20569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c
 * JD-Core Version:    0.7.0.1
 */