package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

class zzq$1
  extends zzm<ChannelApi.OpenChannelResult>
{
  zzq$1(zzq paramzzq, GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zze(this, this.zzbTV, this.zzJB);
  }
  
  public ChannelApi.OpenChannelResult zzbT(Status paramStatus)
  {
    return new zzq.zza(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzq.1
 * JD-Core Version:    0.7.0.1
 */