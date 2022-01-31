package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;

class zzu$3
  extends zzm<Channel.GetInputStreamResult>
{
  zzu$3(zzu paramzzu, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzy(this, zzu.zza(this.zzbUb));
  }
  
  public Channel.GetInputStreamResult zzbU(Status paramStatus)
  {
    return new zzu.zza(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzu.3
 * JD-Core Version:    0.7.0.1
 */