package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import java.util.Map;

public abstract class CapabilityClient
  extends GoogleApi<Wearable.WearableOptions>
{
  public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
  public static final int FILTER_ALL = 0;
  public static final int FILTER_LITERAL = 0;
  public static final int FILTER_PREFIX = 1;
  public static final int FILTER_REACHABLE = 1;
  
  public CapabilityClient(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, Wearable.API, null, paramSettings);
  }
  
  public CapabilityClient(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, Wearable.API, null, paramSettings);
  }
  
  public abstract Task<Void> addListener(OnCapabilityChangedListener paramOnCapabilityChangedListener, Uri paramUri, int paramInt);
  
  public abstract Task<Void> addListener(OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString);
  
  public abstract Task<Void> addLocalCapability(String paramString);
  
  public abstract Task<Map<String, CapabilityInfo>> getAllCapabilities(int paramInt);
  
  public abstract Task<CapabilityInfo> getCapability(String paramString, int paramInt);
  
  public abstract Task<Boolean> removeListener(OnCapabilityChangedListener paramOnCapabilityChangedListener);
  
  public abstract Task<Boolean> removeListener(OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString);
  
  public abstract Task<Void> removeLocalCapability(String paramString);
  
  public static abstract interface OnCapabilityChangedListener
    extends CapabilityApi.CapabilityListener
  {
    public abstract void onCapabilityChanged(CapabilityInfo paramCapabilityInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.CapabilityClient
 * JD-Core Version:    0.7.0.1
 */