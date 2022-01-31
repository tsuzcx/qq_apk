package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;

class zzah$6
  extends zzm<DataApi.GetFdForAssetResult>
{
  zzah$6(zzah paramzzah, GoogleApiClient paramGoogleApiClient, Asset paramAsset)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbUp);
  }
  
  protected DataApi.GetFdForAssetResult zzbZ(Status paramStatus)
  {
    return new zzah.zzc(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.6
 * JD-Core Version:    0.7.0.1
 */