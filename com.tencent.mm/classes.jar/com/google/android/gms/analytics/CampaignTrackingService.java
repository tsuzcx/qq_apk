package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzbay;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zztm;

public class CampaignTrackingService
  extends Service
{
  private static Boolean zzaby;
  private Handler mHandler;
  
  private Handler getHandler()
  {
    Handler localHandler2 = this.mHandler;
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null)
    {
      localHandler1 = new Handler(getMainLooper());
      this.mHandler = localHandler1;
    }
    return localHandler1;
  }
  
  public static boolean zzal(Context paramContext)
  {
    zzac.zzw(paramContext);
    if (zzaby != null) {
      return zzaby.booleanValue();
    }
    boolean bool = zztm.zzy(paramContext, "com.google.android.gms.analytics.CampaignTrackingService");
    zzaby = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzmt()
  {
    try
    {
      synchronized (CampaignTrackingReceiver.zztX)
      {
        zzbay localzzbay = CampaignTrackingReceiver.zzabw;
        if ((localzzbay != null) && (localzzbay.isHeld())) {
          localzzbay.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    zzsc.zzan(this).zznS().zzbP("CampaignTrackingService is starting up");
  }
  
  public void onDestroy()
  {
    zzsc.zzan(this).zznS().zzbP("CampaignTrackingService is shutting down");
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzmt();
    zzsc localzzsc = zzsc.zzan(this);
    zztd localzztd = localzzsc.zznS();
    String str = paramIntent.getStringExtra("referrer");
    Handler localHandler = getHandler();
    if (TextUtils.isEmpty(str))
    {
      localzztd.zzbS("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
      localzzsc.zznU().zzg(new CampaignTrackingService.1(this, localzztd, localHandler, paramInt2));
      return 2;
    }
    paramInt1 = localzzsc.zznT().zzoZ();
    paramIntent = str;
    if (str.length() > paramInt1)
    {
      localzztd.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(paramInt1));
      paramIntent = str.substring(0, paramInt1);
    }
    localzztd.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(paramInt2), paramIntent);
    localzzsc.zzmA().zza(paramIntent, new CampaignTrackingService.2(this, localzztd, localHandler, paramInt2));
    return 2;
  }
  
  protected void zza(zztd paramzztd, Handler paramHandler, int paramInt)
  {
    paramHandler.post(new CampaignTrackingService.3(this, paramInt, paramzztd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.analytics.CampaignTrackingService
 * JD-Core Version:    0.7.0.1
 */