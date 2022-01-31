package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public abstract class Task$Builder
{
  protected Bundle extras;
  protected String gcmTaskService;
  protected boolean isPersisted;
  protected int requiredNetworkState;
  protected boolean requiresCharging;
  protected String tag;
  protected boolean updateCurrent;
  protected Set<Uri> zzau = Collections.emptySet();
  protected zzl zzaw = zzl.zzao;
  
  public abstract Task build();
  
  protected void checkConditions()
  {
    if (this.gcmTaskService != null) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
      GcmNetworkManager.zzd(this.tag);
      localObject = this.zzaw;
      if (localObject == null) {
        break label195;
      }
      i = ((zzl)localObject).zzh();
      if ((i == 1) || (i == 0)) {
        break;
      }
      throw new IllegalArgumentException(45 + "Must provide a valid RetryPolicy: " + i);
    }
    int j = ((zzl)localObject).zzi();
    int k = ((zzl)localObject).zzj();
    if ((i == 0) && (j < 0)) {
      throw new IllegalArgumentException(52 + "InitialBackoffSeconds can't be negative: " + j);
    }
    if ((i == 1) && (j < 10)) {
      throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
    }
    if (k < j)
    {
      i = ((zzl)localObject).zzj();
      throw new IllegalArgumentException(77 + "MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + i);
    }
    label195:
    if (this.isPersisted) {
      Task.zzg(this.extras);
    }
    if ((!this.zzau.isEmpty()) && (this.requiredNetworkState == 2)) {
      throw new IllegalArgumentException("Required URIs may not be used with NETWORK_STATE_ANY");
    }
    Object localObject = this.zzau.iterator();
    while (((Iterator)localObject).hasNext()) {
      Task.zze((Uri)((Iterator)localObject).next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.gcm.Task.Builder
 * JD-Core Version:    0.7.0.1
 */