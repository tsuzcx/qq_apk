package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.google.android.gms.wearable.DataClient.GetFdForAssetResponse;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcj
  extends DataClient
{
  private final DataApi zzdi;
  
  public zzcj(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
    AppMethodBeat.i(101124);
    this.zzdi = new zzbw();
    AppMethodBeat.o(101124);
  }
  
  public zzcj(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
    AppMethodBeat.i(101123);
    this.zzdi = new zzbw();
    AppMethodBeat.o(101123);
  }
  
  private final Task<Void> zza(DataClient.OnDataChangedListener paramOnDataChangedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101136);
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramOnDataChangedListener, getLooper(), "DataListener");
    paramOnDataChangedListener = doRegisterEventListener(new zzcv(paramOnDataChangedListener, paramArrayOfIntentFilter, localListenerHolder, null), new zzcw(paramOnDataChangedListener, localListenerHolder.getListenerKey(), null));
    AppMethodBeat.o(101136);
    return paramOnDataChangedListener;
  }
  
  public final Task<Void> addListener(DataClient.OnDataChangedListener paramOnDataChangedListener)
  {
    AppMethodBeat.i(101134);
    paramOnDataChangedListener = zza(paramOnDataChangedListener, new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED") });
    AppMethodBeat.o(101134);
    return paramOnDataChangedListener;
  }
  
  public final Task<Void> addListener(DataClient.OnDataChangedListener paramOnDataChangedListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101135);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramOnDataChangedListener = zza(paramOnDataChangedListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", paramUri, paramInt) });
      AppMethodBeat.o(101135);
      return paramOnDataChangedListener;
    }
  }
  
  public final Task<Integer> deleteDataItems(Uri paramUri)
  {
    AppMethodBeat.i(101130);
    paramUri = PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), paramUri), zzcp.zzbx);
    AppMethodBeat.o(101130);
    return paramUri;
  }
  
  public final Task<Integer> deleteDataItems(Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101131);
    paramUri = PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), paramUri, paramInt), zzcq.zzbx);
    AppMethodBeat.o(101131);
    return paramUri;
  }
  
  public final Task<DataItem> getDataItem(Uri paramUri)
  {
    AppMethodBeat.i(101126);
    paramUri = PendingResultUtil.toTask(this.zzdi.getDataItem(asGoogleApiClient(), paramUri), zzcl.zzbx);
    AppMethodBeat.o(101126);
    return paramUri;
  }
  
  public final Task<DataItemBuffer> getDataItems()
  {
    AppMethodBeat.i(101127);
    Task localTask = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient()), zzcm.zzbx);
    AppMethodBeat.o(101127);
    return localTask;
  }
  
  public final Task<DataItemBuffer> getDataItems(Uri paramUri)
  {
    AppMethodBeat.i(101128);
    paramUri = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), paramUri), zzcn.zzbx);
    AppMethodBeat.o(101128);
    return paramUri;
  }
  
  public final Task<DataItemBuffer> getDataItems(Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101129);
    paramUri = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), paramUri, paramInt), zzco.zzbx);
    AppMethodBeat.o(101129);
    return paramUri;
  }
  
  public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(Asset paramAsset)
  {
    AppMethodBeat.i(101132);
    paramAsset = PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), paramAsset), zzcr.zzbx);
    AppMethodBeat.o(101132);
    return paramAsset;
  }
  
  public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(DataItemAsset paramDataItemAsset)
  {
    AppMethodBeat.i(101133);
    paramDataItemAsset = PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), paramDataItemAsset), zzcs.zzbx);
    AppMethodBeat.o(101133);
    return paramDataItemAsset;
  }
  
  public final Task<DataItem> putDataItem(PutDataRequest paramPutDataRequest)
  {
    AppMethodBeat.i(101125);
    paramPutDataRequest = PendingResultUtil.toTask(this.zzdi.putDataItem(asGoogleApiClient(), paramPutDataRequest), zzck.zzbx);
    AppMethodBeat.o(101125);
    return paramPutDataRequest;
  }
  
  public final Task<Boolean> removeListener(DataClient.OnDataChangedListener paramOnDataChangedListener)
  {
    AppMethodBeat.i(101137);
    paramOnDataChangedListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnDataChangedListener, getLooper(), "DataListener").getListenerKey());
    AppMethodBeat.o(101137);
    return paramOnDataChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcj
 * JD-Core Version:    0.7.0.1
 */