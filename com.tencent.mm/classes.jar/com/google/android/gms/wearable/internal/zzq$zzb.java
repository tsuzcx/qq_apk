package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzq$zzb
  extends zzm<Status>
{
  private final String zzaiJ;
  private ChannelApi.ChannelListener zzbTX;
  
  zzq$zzb(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener, String paramString)
  {
    super(paramGoogleApiClient);
    this.zzbTX = ((ChannelApi.ChannelListener)zzac.zzw(paramChannelListener));
    this.zzaiJ = paramString;
  }
  
  protected final void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbTX, this.zzaiJ);
    this.zzbTX = null;
  }
  
  public final Status zzb(Status paramStatus)
  {
    this.zzbTX = null;
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzq.zzb
 * JD-Core Version:    0.7.0.1
 */