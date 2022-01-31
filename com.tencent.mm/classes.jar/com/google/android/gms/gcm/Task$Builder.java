package com.google.android.gms.gcm;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzac;

public abstract class Task$Builder
{
  protected Bundle extras;
  protected String gcmTaskService;
  protected boolean isPersisted;
  protected int requiredNetworkState;
  protected boolean requiresCharging;
  protected String tag;
  protected boolean updateCurrent;
  protected zzc zzbhd = zzc.zzbgR;
  
  public abstract Task build();
  
  protected void checkConditions()
  {
    if (this.gcmTaskService != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
      GcmNetworkManager.zzey(this.tag);
      Task.zza(this.zzbhd);
      if (this.isPersisted) {
        Task.zzL(this.extras);
      }
      return;
    }
  }
  
  public abstract Builder setExtras(Bundle paramBundle);
  
  public abstract Builder setPersisted(boolean paramBoolean);
  
  public abstract Builder setRequiredNetwork(int paramInt);
  
  public abstract Builder setRequiresCharging(boolean paramBoolean);
  
  public abstract Builder setService(Class<? extends GcmTaskService> paramClass);
  
  public abstract Builder setTag(String paramString);
  
  public abstract Builder setUpdateCurrent(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.gcm.Task.Builder
 * JD-Core Version:    0.7.0.1
 */