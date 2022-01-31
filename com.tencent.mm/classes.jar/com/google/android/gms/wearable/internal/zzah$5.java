package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

class zzah$5
  extends zzm<DataApi.DeleteDataItemsResult>
{
  zzah$5(zzah paramzzah, GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzb(this, this.zzbBz, this.zzbUo);
  }
  
  protected DataApi.DeleteDataItemsResult zzbY(Status paramStatus)
  {
    return new zzah.zzb(paramStatus, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.5
 * JD-Core Version:    0.7.0.1
 */