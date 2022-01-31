package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;

class zzu$4
  extends zzm<Channel.GetOutputStreamResult>
{
  zzu$4(zzu paramzzu, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzz(this, zzu.zza(this.zzbUb));
  }
  
  public Channel.GetOutputStreamResult zzbV(Status paramStatus)
  {
    return new zzu.zzb(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzu.4
 * JD-Core Version:    0.7.0.1
 */