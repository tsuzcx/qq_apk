package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;

class zzah$4
  extends zzm<DataItemBuffer>
{
  zzah$4(zzah paramzzah, GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbBz, this.zzbUo);
  }
  
  protected DataItemBuffer zzbX(Status paramStatus)
  {
    return new DataItemBuffer(DataHolder.zzcJ(paramStatus.getStatusCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.4
 * JD-Core Version:    0.7.0.1
 */