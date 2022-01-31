package com.google.android.gms.analytics;

import com.google.android.gms.internal.zztd;

class CampaignTrackingService$3
  implements Runnable
{
  CampaignTrackingService$3(CampaignTrackingService paramCampaignTrackingService, int paramInt, zztd paramzztd) {}
  
  public void run()
  {
    boolean bool = this.zzabB.stopSelfResult(this.zzabA);
    if (bool) {
      this.zzabz.zza("Install campaign broadcast processed", Boolean.valueOf(bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.CampaignTrackingService.3
 * JD-Core Version:    0.7.0.1
 */