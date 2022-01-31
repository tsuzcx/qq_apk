package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;

class zzah$3
  extends zzm<DataItemBuffer>
{
  zzah$3(zzah paramzzah, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzw(this);
  }
  
  protected DataItemBuffer zzbX(Status paramStatus)
  {
    return new DataItemBuffer(DataHolder.zzcJ(paramStatus.getStatusCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.3
 * JD-Core Version:    0.7.0.1
 */