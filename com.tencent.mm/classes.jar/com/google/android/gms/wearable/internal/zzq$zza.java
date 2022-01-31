package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

final class zzq$zza
  implements ChannelApi.OpenChannelResult
{
  private final Status zzair;
  private final Channel zzbTW;
  
  zzq$zza(Status paramStatus, Channel paramChannel)
  {
    this.zzair = ((Status)zzac.zzw(paramStatus));
    this.zzbTW = paramChannel;
  }
  
  public final Channel getChannel()
  {
    return this.zzbTW;
  }
  
  public final Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzq.zza
 * JD-Core Version:    0.7.0.1
 */