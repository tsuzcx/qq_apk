package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;

class zzah$7
  extends zzm<DataApi.GetFdForAssetResult>
{
  zzah$7(zzah paramzzah, GoogleApiClient paramGoogleApiClient, DataItemAsset paramDataItemAsset)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbUq);
  }
  
  protected DataApi.GetFdForAssetResult zzbZ(Status paramStatus)
  {
    return new zzah.zzc(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.7
 * JD-Core Version:    0.7.0.1
 */