package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzo
  implements CapabilityApi
{
  private static PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101444);
    paramGoogleApiClient = zzb.zza(paramGoogleApiClient, new zzt(paramArrayOfIntentFilter), paramCapabilityListener);
    AppMethodBeat.o(101444);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    AppMethodBeat.i(101442);
    Asserts.checkNotNull(paramString, "capability must not be null");
    zzv localzzv = new zzv(paramCapabilityListener, paramString);
    IntentFilter localIntentFilter = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
    if (!paramString.startsWith("/"))
    {
      paramCapabilityListener = String.valueOf(paramString);
      if (paramCapabilityListener.length() != 0) {
        paramCapabilityListener = "/".concat(paramCapabilityListener);
      }
    }
    for (;;)
    {
      localIntentFilter.addDataPath(paramCapabilityListener, 0);
      paramGoogleApiClient = zza(paramGoogleApiClient, localzzv, new IntentFilter[] { localIntentFilter });
      AppMethodBeat.o(101442);
      return paramGoogleApiClient;
      paramCapabilityListener = new String("/");
      continue;
      paramCapabilityListener = paramString;
    }
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101443);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramGoogleApiClient = zza(paramGoogleApiClient, paramCapabilityListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", paramUri, paramInt) });
      AppMethodBeat.o(101443);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    AppMethodBeat.i(101440);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzr(this, paramGoogleApiClient, paramString));
    AppMethodBeat.o(101440);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(101439);
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label49;
      }
    }
    label49:
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzq(this, paramGoogleApiClient, paramInt));
      AppMethodBeat.o(101439);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(101438);
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label53;
      }
    }
    label53:
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzp(this, paramGoogleApiClient, paramString, paramInt));
      AppMethodBeat.o(101438);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    AppMethodBeat.i(101445);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzz(paramGoogleApiClient, new zzv(paramCapabilityListener, paramString), null));
    AppMethodBeat.o(101445);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    AppMethodBeat.i(101446);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzz(paramGoogleApiClient, paramCapabilityListener, null));
    AppMethodBeat.o(101446);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    AppMethodBeat.i(101441);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzs(this, paramGoogleApiClient, paramString));
    AppMethodBeat.o(101441);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzo
 * JD-Core Version:    0.7.0.1
 */