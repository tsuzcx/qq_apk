package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabh;

final class zzb<T>
  extends zzm<Status>
{
  private T mListener;
  private zzabh<T> zzaDf;
  private zzb.zza<T> zzbTA;
  
  private zzb(GoogleApiClient paramGoogleApiClient, T paramT, zzabh<T> paramzzabh, zzb.zza<T> paramzza)
  {
    super(paramGoogleApiClient);
    this.mListener = zzac.zzw(paramT);
    this.zzaDf = ((zzabh)zzac.zzw(paramzzabh));
    this.zzbTA = ((zzb.zza)zzac.zzw(paramzza));
  }
  
  static <T> PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zzb.zza<T> paramzza, T paramT)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramT, paramGoogleApiClient.zzr(paramT), paramzza));
  }
  
  protected final void zza(zzcx paramzzcx)
  {
    this.zzbTA.zza(paramzzcx, this, this.mListener, this.zzaDf);
    this.mListener = null;
    this.zzaDf = null;
  }
  
  protected final Status zzb(Status paramStatus)
  {
    this.mListener = null;
    this.zzaDf = null;
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzb
 * JD-Core Version:    0.7.0.1
 */