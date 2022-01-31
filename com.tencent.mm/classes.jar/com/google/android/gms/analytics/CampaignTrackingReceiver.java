package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzbay;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zztm;

public class CampaignTrackingReceiver
  extends BroadcastReceiver
{
  static zzbay zzabw;
  static Boolean zzabx;
  static Object zztX = new Object();
  
  public static boolean zzak(Context paramContext)
  {
    zzac.zzw(paramContext);
    if (zzabx != null) {
      return zzabx.booleanValue();
    }
    boolean bool = zztm.zza(paramContext, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
    zzabx = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    localzztd = zzsc.zzan(paramContext).zznS();
    if (??? == null)
    {
      localzztd.zzbS("CampaignTrackingReceiver received null intent");
      return;
    }
    String str = ???.getStringExtra("referrer");
    ??? = ???.getAction();
    localzztd.zza("CampaignTrackingReceiver received", ???);
    if ((!"com.android.vending.INSTALL_REFERRER".equals(???)) || (TextUtils.isEmpty(str)))
    {
      localzztd.zzbS("CampaignTrackingReceiver received unexpected intent without referrer extra");
      return;
    }
    boolean bool = CampaignTrackingService.zzal(paramContext);
    if (!bool) {
      localzztd.zzbS("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
    }
    zzw(paramContext, str);
    ??? = zzms();
    zzac.zzw(???);
    Intent localIntent = new Intent(paramContext, ???);
    localIntent.putExtra("referrer", str);
    synchronized (zztX)
    {
      paramContext.startService(localIntent);
      if (!bool) {
        return;
      }
    }
    try
    {
      if (zzabw == null)
      {
        paramContext = new zzbay(paramContext, 1, "Analytics campaign WakeLock");
        zzabw = paramContext;
        paramContext.setReferenceCounted(false);
      }
      zzabw.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzztd.zzbS("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
  
  public Class<? extends CampaignTrackingService> zzms()
  {
    return CampaignTrackingService.class;
  }
  
  public void zzw(Context paramContext, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.analytics.CampaignTrackingReceiver
 * JD-Core Version:    0.7.0.1
 */