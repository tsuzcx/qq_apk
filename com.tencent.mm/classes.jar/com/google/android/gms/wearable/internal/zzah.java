package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

public final class zzah
  implements DataApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return zzb.zza(paramGoogleApiClient, zza(paramArrayOfIntentFilter), paramDataListener);
  }
  
  private static zzb.zza<DataApi.DataListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    return new zzah.8(paramArrayOfIntentFilter);
  }
  
  private void zza(Asset paramAsset)
  {
    if (paramAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (paramAsset.getDigest() == null) {
      throw new IllegalArgumentException("invalid asset");
    }
    if (paramAsset.getData() != null) {
      throw new IllegalArgumentException("invalid asset");
    }
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    return zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzcv.zzip("com.google.android.gms.wearable.DATA_CHANGED") });
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, Uri paramUri, int paramInt)
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
      return zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzcv.zza("com.google.android.gms.wearable.DATA_CHANGED", paramUri, paramInt) });
      bool = false;
      break;
    }
  }
  
  public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return deleteDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    boolean bool2 = false;
    if (paramUri != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzac.zzb(bool1, "uri must not be null");
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 1) {}
      }
      else
      {
        bool1 = true;
      }
      zzac.zzb(bool1, "invalid filter type");
      return paramGoogleApiClient.zza(new zzah.5(this, paramGoogleApiClient, paramUri, paramInt));
    }
  }
  
  public final PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return paramGoogleApiClient.zza(new zzah.2(this, paramGoogleApiClient, paramUri));
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzah.3(this, paramGoogleApiClient));
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return getDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    boolean bool2 = false;
    if (paramUri != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzac.zzb(bool1, "uri must not be null");
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 1) {}
      }
      else
      {
        bool1 = true;
      }
      zzac.zzb(bool1, "invalid filter type");
      return paramGoogleApiClient.zza(new zzah.4(this, paramGoogleApiClient, paramUri, paramInt));
    }
  }
  
  public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, Asset paramAsset)
  {
    zza(paramAsset);
    return paramGoogleApiClient.zza(new zzah.6(this, paramGoogleApiClient, paramAsset));
  }
  
  public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, DataItemAsset paramDataItemAsset)
  {
    return paramGoogleApiClient.zza(new zzah.7(this, paramGoogleApiClient, paramDataItemAsset));
  }
  
  public final PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    paramGoogleApiClient.zza(new zzm(paramGoogleApiClient)
    {
      protected void zza(zzcx paramAnonymouszzcx)
      {
        paramAnonymouszzcx.zza(this, paramPutDataRequest);
      }
      
      public DataApi.DataItemResult zzbW(Status paramAnonymousStatus)
      {
        return new zzah.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    return paramGoogleApiClient.zza(new zzah.9(this, paramGoogleApiClient, paramDataListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah
 * JD-Core Version:    0.7.0.1
 */