package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class InstanceIDListenerService
  extends Service
{
  static String ACTION = "action";
  private static String zzbgu = "gcm.googleapis.com/refresh";
  private static String zzbhP = "google.com/iid";
  private static String zzbhQ = "CMD";
  MessengerCompat zzbhN = new MessengerCompat(new InstanceIDListenerService.1(this, Looper.getMainLooper()));
  BroadcastReceiver zzbhO = new InstanceIDListenerService.2(this);
  int zzbhR;
  int zzbhS;
  
  static void zza(Context paramContext, zzd paramzzd)
  {
    paramzzd.zzHn();
    paramzzd = new Intent("com.google.android.gms.iid.InstanceID");
    paramzzd.putExtra(zzbhQ, "RST");
    paramzzd.setPackage(paramContext.getPackageName());
    paramContext.startService(paramzzd);
  }
  
  private void zza(Message paramMessage, int paramInt)
  {
    zzc.zzbA(this);
    getPackageManager();
    if ((paramInt != zzc.zzbhY) && (paramInt != zzc.zzbhX))
    {
      int i = zzc.zzbhX;
      int j = zzc.zzbhY;
      new StringBuilder(77).append("Message from unexpected caller ").append(paramInt).append(" mine=").append(i).append(" appid=").append(j);
      return;
    }
    zzn((Intent)paramMessage.obj);
  }
  
  static void zzbz(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra(zzbhQ, "SYNC");
    paramContext.startService(localIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))) {
      return this.zzbhN.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
    localIntentFilter.addCategory(getPackageName());
    registerReceiver(this.zzbhO, localIntentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.zzbhO);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzjJ(paramInt2);
    if (paramIntent == null)
    {
      stop();
      return 2;
    }
    try
    {
      if ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Intent localIntent = (Intent)paramIntent.getParcelableExtra("GSF");
          if (localIntent != null)
          {
            startService(localIntent);
            return 1;
          }
        }
        zzn(paramIntent);
      }
      stop();
      if (paramIntent.getStringExtra("from") != null) {
        WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
      }
      return 2;
    }
    finally
    {
      stop();
    }
  }
  
  public void onTokenRefresh() {}
  
  void stop()
  {
    try
    {
      this.zzbhR -= 1;
      if (this.zzbhR == 0) {
        stopSelf(this.zzbhS);
      }
      if (Log.isLoggable("InstanceID", 3))
      {
        int i = this.zzbhR;
        int j = this.zzbhS;
        new StringBuilder(28).append("Stop ").append(i).append(" ").append(j);
      }
      return;
    }
    finally {}
  }
  
  public void zzaG(boolean paramBoolean)
  {
    onTokenRefresh();
  }
  
  void zzjJ(int paramInt)
  {
    try
    {
      this.zzbhR += 1;
      if (paramInt > this.zzbhS) {
        this.zzbhS = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public void zzn(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("subtype");
    Object localObject1;
    String str1;
    if (str2 == null)
    {
      localObject1 = InstanceID.getInstance(this);
      str1 = paramIntent.getStringExtra(zzbhQ);
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("registration_id") == null)) {
        break label122;
      }
      if (Log.isLoggable("InstanceID", 3))
      {
        str1 = String.valueOf(str2);
        if (str1.length() == 0) {
          break label108;
        }
        "Register result in service ".concat(str1);
      }
      label74:
      ((InstanceID)localObject1).zzHj().zzv(paramIntent);
    }
    label108:
    label122:
    do
    {
      return;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("subtype", str2);
      localObject1 = InstanceID.zza(this, (Bundle)localObject1);
      break;
      new String("Register result in service ");
      break label74;
      Object localObject2;
      if (Log.isLoggable("InstanceID", 3))
      {
        localObject2 = String.valueOf(paramIntent.getExtras());
        new StringBuilder(String.valueOf(str2).length() + 18 + String.valueOf(str1).length() + String.valueOf(localObject2).length()).append("Service command ").append(str2).append(" ").append(str1).append(" ").append((String)localObject2);
      }
      if (paramIntent.getStringExtra("unregistered") != null)
      {
        localObject2 = ((InstanceID)localObject1).zzHi();
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        ((zzd)localObject2).zzeK(str1);
        ((InstanceID)localObject1).zzHj().zzv(paramIntent);
        return;
      }
      if (zzbgu.equals(paramIntent.getStringExtra("from")))
      {
        ((InstanceID)localObject1).zzHi().zzeK(str2);
        zzaG(false);
        return;
      }
      if ("RST".equals(str1))
      {
        ((InstanceID)localObject1).zzHh();
        zzaG(true);
        return;
      }
      if (!"RST_FULL".equals(str1)) {
        break label331;
      }
    } while (((InstanceID)localObject1).zzHi().isEmpty());
    ((InstanceID)localObject1).zzHi().zzHn();
    zzaG(true);
    return;
    label331:
    if ("SYNC".equals(str1))
    {
      ((InstanceID)localObject1).zzHi().zzeK(str2);
      zzaG(false);
      return;
    }
    "PING".equals(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService
 * JD-Core Version:    0.7.0.1
 */