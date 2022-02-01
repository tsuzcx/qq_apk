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
    AppMethodBeat.i(101102);
    paramGoogleApiClient = zzb.zza(paramGoogleApiClient, new zzce(paramArrayOfIntentFilter), paramDataListener);
    AppMethodBeat.o(101102);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    AppMethodBeat.i(101100);
    paramGoogleApiClient = zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED") });
    AppMethodBeat.o(101100);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101101);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramGoogleApiClient = zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", paramUri, paramInt) });
      AppMethodBeat.o(101101);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(101096);
    paramGoogleApiClient = deleteDataItems(paramGoogleApiClient, paramUri, 0);
    AppMethodBeat.o(101096);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(101097);
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
      AppMethodBeat.o(101097);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(101092);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzby(this, paramGoogleApiClient, paramUri));
    AppMethodBeat.o(101092);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(101093);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbz(this, paramGoogleApiClient));
    AppMethodBeat.o(101093);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(101094);
    paramGoogleApiClient = getDataItems(paramGoogleApiClient, paramUri, 0);
    AppMethodBeat.o(101094);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(101095);
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
      AppMethodBeat.o(101095);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, Asset paramAsset)
  {
    AppMethodBeat.i(101098);
    if (paramAsset == null)
    {
      paramGoogleApiClient = new IllegalArgumentException("asset is null");
      AppMethodBeat.o(101098);
      throw paramGoogleApiClient;
    }
    if (paramAsset.getDigest() == null)
    {
      paramGoogleApiClient = new IllegalArgumentException("invalid asset");
      AppMethodBeat.o(101098);
      throw paramGoogleApiClient;
    }
    if (paramAsset.getData() != null)
    {
      paramGoogleApiClient = new IllegalArgumentException("invalid asset");
      AppMethodBeat.o(101098);
      throw paramGoogleApiClient;
    }
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcc(this, paramGoogleApiClient, paramAsset));
    AppMethodBeat.o(101098);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, DataItemAsset paramDataItemAsset)
  {
    AppMethodBeat.i(101099);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcd(this, paramGoogleApiClient, paramDataItemAsset));
    AppMethodBeat.o(101099);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, PutDataRequest paramPutDataRequest)
  {
    AppMethodBeat.i(101091);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbx(this, paramGoogleApiClient, paramPutDataRequest));
    AppMethodBeat.o(101091);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    AppMethodBeat.i(101103);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzcf(this, paramGoogleApiClient, paramDataListener));
    AppMethodBeat.o(101103);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbw
 * JD-Core Version:    0.7.0.1
 */