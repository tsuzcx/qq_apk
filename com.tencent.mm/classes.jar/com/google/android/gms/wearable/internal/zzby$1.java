package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

class zzby$1
  extends zzm<MessageApi.SendMessageResult>
{
  zzby$1(zzby paramzzby, GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbTV, this.zzbUK, this.zzbMs);
  }
  
  protected MessageApi.SendMessageResult zzca(Status paramStatus)
  {
    return new zzby.zzb(paramStatus, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzby.1
 * JD-Core Version:    0.7.0.1
 */