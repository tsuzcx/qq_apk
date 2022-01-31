package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataItemResult;

class zzah$2
  extends zzm<DataApi.DataItemResult>
{
  zzah$2(zzah paramzzah, GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbBz);
  }
  
  protected DataApi.DataItemResult zzbW(Status paramStatus)
  {
    return new zzah.zza(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.2
 * JD-Core Version:    0.7.0.1
 */