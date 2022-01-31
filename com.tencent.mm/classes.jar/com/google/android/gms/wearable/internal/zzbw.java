package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbw
  implements DataApi
{
  private static PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(71119);
    paramGoogleApiClient = zzb.zza(paramGoogleApiClient, new zzce(paramArrayOfIntentFilter), paramDataListener);
    AppMethodBeat.o(71119);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    AppMethodBeat.i(71117);
    paramGoogleApiClient = zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED") });
    AppMethodBeat.o(71117);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(71118);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramGoogleApiClient = zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", paramUri, paramInt) });
      AppMethodBeat.o(71118);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(71113);
    paramGoogleApiClient = deleteDataItems(paramGoogleApiClient, paramUri, 0);
    AppMethodBeat.o(71113);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71114);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label61;
      }
    }
    label61:
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "invalid filter type");
      paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcb(this, paramGoogleApiClient, paramUri, paramInt));
      AppMethodBeat.o(71114);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(71109);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzby(this, paramGoogleApiClient, paramUri));
    AppMethodBeat.o(71109);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(71110);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbz(this, paramGoogleApiClient));
    AppMethodBeat.o(71110);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(71111);
    paramGoogleApiClient = getDataItems(paramGoogleApiClient, paramUri, 0);
    AppMethodBeat.o(71111);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71112);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label61;
      }
    }
    label61:
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "invalid filter type");
      paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzca(this, paramGoogleApiClient, paramUri, paramInt));
      AppMethodBeat.o(71112);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, Asset paramAsset)
  {
    AppMethodBeat.i(71115);
    if (paramAsset == null)
    {
      paramGoogleApiClient = new IllegalArgumentException("asset is null");
      AppMethodBeat.o(71115);
      throw paramGoogleApiClient;
    }
    if (paramAsset.getDigest() == null)
    {
      paramGoogleApiClient = new IllegalArgumentException("invalid asset");
      AppMethodBeat.o(71115);
      throw paramGoogleApiClient;
    }
    if (paramAsset.getData() != null)
    {
      paramGoogleApiClient = new IllegalArgumentException("invalid asset");
      AppMethodBeat.o(71115);
      throw paramGoogleApiClient;
    }
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcc(this, paramGoogleApiClient, paramAsset));
    AppMethodBeat.o(71115);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, DataItemAsset paramDataItemAsset)
  {
    AppMethodBeat.i(71116);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcd(this, paramGoogleApiClient, paramDataItemAsset));
    AppMethodBeat.o(71116);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, PutDataRequest paramPutDataRequest)
  {
    AppMethodBeat.i(71108);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbx(this, paramGoogleApiClient, paramPutDataRequest));
    AppMethodBeat.o(71108);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    AppMethodBeat.i(71120);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcf(this, paramGoogleApiClient, paramDataListener));
    AppMethodBeat.o(71120);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbw
 * JD-Core Version:    0.7.0.1
 */