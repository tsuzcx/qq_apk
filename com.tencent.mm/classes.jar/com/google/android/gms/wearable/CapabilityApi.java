package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public abstract interface CapabilityApi
{
  public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
  public static final int FILTER_ALL = 0;
  public static final int FILTER_LITERAL = 0;
  public static final int FILTER_PREFIX = 1;
  public static final int FILTER_REACHABLE = 1;
  
  public abstract PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener, String paramString);
  
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener, Uri paramUri, int paramInt);
  
  public abstract PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener, String paramString);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener);
  
  public abstract PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CapabilityFilterType {}
  
  @Deprecated
  public static abstract interface CapabilityListener
  {
    public abstract void onCapabilityChanged(CapabilityInfo paramCapabilityInfo);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NodeFilterType {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.CapabilityApi
 * JD-Core Version:    0.7.0.1
 */