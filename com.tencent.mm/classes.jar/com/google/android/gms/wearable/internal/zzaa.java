package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class zzaa
  extends CapabilityClient
{
  private final CapabilityApi zzbw;
  
  public zzaa(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
    AppMethodBeat.i(100953);
    this.zzbw = new zzo();
    AppMethodBeat.o(100953);
  }
  
  public zzaa(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
    AppMethodBeat.i(100952);
    this.zzbw = new zzo();
    AppMethodBeat.o(100952);
  }
  
  private final Task<Void> zza(ListenerHolder<CapabilityClient.OnCapabilityChangedListener> paramListenerHolder, CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(100962);
    paramListenerHolder = doRegisterEventListener(new zzaf(paramOnCapabilityChangedListener, paramArrayOfIntentFilter, paramListenerHolder, null), new zzag(paramOnCapabilityChangedListener, paramListenerHolder.getListenerKey(), null));
    AppMethodBeat.o(100962);
    return paramListenerHolder;
  }
  
  public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(100960);
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramUri = zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", paramUri, paramInt);
      paramOnCapabilityChangedListener = zza(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, getLooper(), "CapabilityListener"), paramOnCapabilityChangedListener, new IntentFilter[] { paramUri });
      AppMethodBeat.o(100960);
      return paramOnCapabilityChangedListener;
    }
  }
  
  public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString)
  {
    AppMethodBeat.i(100958);
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    Asserts.checkNotNull(paramString, "capability must not be null");
    IntentFilter localIntentFilter = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
    if (!paramString.startsWith("/"))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "/".concat(paramString);
      }
    }
    for (;;)
    {
      localIntentFilter.addDataPath(paramString, 0);
      Looper localLooper = getLooper();
      String str = String.valueOf(paramString);
      if (str.length() != 0) {}
      for (str = "CapabilityListener:".concat(str);; str = new String("CapabilityListener:"))
      {
        paramOnCapabilityChangedListener = zza(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, localLooper, str), new zzae(paramOnCapabilityChangedListener, paramString), new IntentFilter[] { localIntentFilter });
        AppMethodBeat.o(100958);
        return paramOnCapabilityChangedListener;
        paramString = new String("/");
        break;
      }
    }
  }
  
  public final Task<Void> addLocalCapability(String paramString)
  {
    AppMethodBeat.i(100956);
    Asserts.checkNotNull(paramString, "capability must not be null");
    paramString = PendingResultUtil.toVoidTask(this.zzbw.addLocalCapability(asGoogleApiClient(), paramString));
    AppMethodBeat.o(100956);
    return paramString;
  }
  
  public final Task<Map<String, CapabilityInfo>> getAllCapabilities(int paramInt)
  {
    AppMethodBeat.i(100955);
    Task localTask = PendingResultUtil.toTask(this.zzbw.getAllCapabilities(asGoogleApiClient(), paramInt), zzac.zzbx);
    AppMethodBeat.o(100955);
    return localTask;
  }
  
  public final Task<CapabilityInfo> getCapability(String paramString, int paramInt)
  {
    AppMethodBeat.i(100954);
    Asserts.checkNotNull(paramString, "capability must not be null");
    paramString = PendingResultUtil.toTask(this.zzbw.getCapability(asGoogleApiClient(), paramString, paramInt), zzab.zzbx);
    AppMethodBeat.o(100954);
    return paramString;
  }
  
  public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener)
  {
    AppMethodBeat.i(100961);
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    paramOnCapabilityChangedListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, getLooper(), "CapabilityListener").getListenerKey());
    AppMethodBeat.o(100961);
    return paramOnCapabilityChangedListener;
  }
  
  public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString)
  {
    AppMethodBeat.i(100959);
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    Asserts.checkNotNull(paramString, "capability must not be null");
    if (!paramString.startsWith("/"))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "/".concat(paramString);
      }
    }
    for (;;)
    {
      Looper localLooper = getLooper();
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "CapabilityListener:".concat(paramString);; paramString = new String("CapabilityListener:"))
      {
        paramOnCapabilityChangedListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, localLooper, paramString).getListenerKey());
        AppMethodBeat.o(100959);
        return paramOnCapabilityChangedListener;
        paramString = new String("/");
        break;
      }
    }
  }
  
  public final Task<Void> removeLocalCapability(String paramString)
  {
    AppMethodBeat.i(100957);
    Asserts.checkNotNull(paramString, "capability must not be null");
    paramString = PendingResultUtil.toVoidTask(this.zzbw.removeLocalCapability(asGoogleApiClient(), paramString));
    AppMethodBeat.o(100957);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaa
 * JD-Core Version:    0.7.0.1
 */