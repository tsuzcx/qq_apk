package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Map;

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
  
  public abstract PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener, String paramString);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener);
  
  public abstract PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString);
  
  @Deprecated
  public static abstract interface AddLocalCapabilityResult
    extends Result
  {}
  
  @Deprecated
  public static abstract interface CapabilityListener
  {
    public abstract void onCapabilityChanged(CapabilityInfo paramCapabilityInfo);
  }
  
  @Deprecated
  public static abstract interface GetAllCapabilitiesResult
    extends Result
  {
    public abstract Map<String, CapabilityInfo> getAllCapabilities();
  }
  
  @Deprecated
  public static abstract interface GetCapabilityResult
    extends Result
  {
    public abstract CapabilityInfo getCapability();
  }
  
  @Deprecated
  public static abstract interface RemoveLocalCapabilityResult
    extends Result
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.CapabilityApi
 * JD-Core Version:    0.7.0.1
 */