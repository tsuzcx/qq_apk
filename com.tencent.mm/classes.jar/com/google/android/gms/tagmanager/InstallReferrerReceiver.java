package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver
  extends CampaignTrackingReceiver
{
  protected final Class<? extends CampaignTrackingService> zzms()
  {
    return InstallReferrerService.class;
  }
  
  protected final void zzw(Context paramContext, String paramString)
  {
    zzbf.zzhk(paramString);
    zzbf.zzM(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.InstallReferrerReceiver
 * JD-Core Version:    0.7.0.1
 */