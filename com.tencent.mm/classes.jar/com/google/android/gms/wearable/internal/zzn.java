package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;

public class zzn
  implements CapabilityApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return zzb.zza(paramGoogleApiClient, zza(paramArrayOfIntentFilter), paramCapabilityListener);
  }
  
  private static zzb.zza<CapabilityApi.CapabilityListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    return new zzn.5(paramArrayOfIntentFilter);
  }
  
  public PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    boolean bool;
    zzn.zzb localzzb;
    IntentFilter localIntentFilter;
    if (paramString != null)
    {
      bool = true;
      zzac.zzb(bool, "capability must not be null");
      localzzb = new zzn.zzb(paramCapabilityListener, paramString);
      localIntentFilter = zzcv.zzip("com.google.android.gms.wearable.CAPABILITY_CHANGED");
      if (paramString.startsWith("/")) {
        break label103;
      }
      paramCapabilityListener = String.valueOf(paramString);
      if (paramCapabilityListener.length() == 0) {
        break label90;
      }
      paramCapabilityListener = "/".concat(paramCapabilityListener);
    }
    for (;;)
    {
      localIntentFilter.addDataPath(paramCapabilityListener, 0);
      return zza(paramGoogleApiClient, localzzb, new IntentFilter[] { localIntentFilter });
      bool = false;
      break;
      label90:
      paramCapabilityListener = new String("/");
      continue;
      label103:
      paramCapabilityListener = paramString;
    }
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, Uri paramUri, int paramInt)
  {
    if (paramUri != null)
    {
      bool = true;
      zzac.zzb(bool, "uri must not be null");
      if ((paramInt != 0) && (paramInt != 1)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramCapabilityListener, new IntentFilter[] { zzcv.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", paramUri, paramInt) });
      bool = false;
      break;
    }
  }
  
  public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzn.3(this, paramGoogleApiClient, paramString));
  }
  
  public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label37;
      }
    }
    label37:
    for (bool1 = bool2;; bool1 = false)
    {
      zzac.zzax(bool1);
      return paramGoogleApiClient.zza(new zzn.2(this, paramGoogleApiClient, paramInt));
    }
  }
  
  public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label41;
      }
    }
    label41:
    for (bool1 = bool2;; bool1 = false)
    {
      zzac.zzax(bool1);
      return paramGoogleApiClient.zza(new zzn.1(this, paramGoogleApiClient, paramString, paramInt));
    }
  }
  
  public PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    return paramGoogleApiClient.zza(new zzn.zzf(paramGoogleApiClient, new zzn.zzb(paramCapabilityListener, paramString), null));
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    return paramGoogleApiClient.zza(new zzn.zzf(paramGoogleApiClient, paramCapabilityListener, null));
  }
  
  public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzn.4(this, paramGoogleApiClient, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn
 * JD-Core Version:    0.7.0.1
 */