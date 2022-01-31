package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  public Activity activity;
  public WifiManager bci;
  public Condition btV;
  public boolean connected = false;
  public long edM;
  public String foj;
  public Lock kmn;
  public BroadcastReceiver kmq;
  public boolean kmu = false;
  public String ssid;
  
  public c(String paramString1, Activity paramActivity, String paramString2)
  {
    this.activity = paramActivity;
    this.edM = 30000L;
    this.ssid = paramString1;
    this.foj = paramString2;
    this.kmn = new ReentrantLock();
    this.btV = this.kmn.newCondition();
    this.bci = ((WifiManager)ae.getContext().getSystemService("wifi"));
  }
  
  public final void aTl()
  {
    try
    {
      this.activity.unregisterReceiver(this.kmq);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c
 * JD-Core Version:    0.7.0.1
 */