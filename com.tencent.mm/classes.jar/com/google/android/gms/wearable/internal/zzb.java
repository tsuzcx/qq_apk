package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb<T>
  extends zzn<Status>
{
  private T zzaw;
  private ListenerHolder<T> zzax;
  private zzc<T> zzay;
  
  private zzb(GoogleApiClient paramGoogleApiClient, T paramT, ListenerHolder<T> paramListenerHolder, zzc<T> paramzzc)
  {
    super(paramGoogleApiClient);
    AppMethodBeat.i(101043);
    this.zzaw = Preconditions.checkNotNull(paramT);
    this.zzax = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    this.zzay = ((zzc)Preconditions.checkNotNull(paramzzc));
    AppMethodBeat.o(101043);
  }
  
  static <T> PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zzc<T> paramzzc, T paramT)
  {
    AppMethodBeat.i(101042);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzb(paramGoogleApiClient, paramT, paramGoogleApiClient.registerListener(paramT), paramzzc));
    AppMethodBeat.o(101042);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzb
 * JD-Core Version:    0.7.0.1
 */