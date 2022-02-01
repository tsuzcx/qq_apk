package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class zzal
  implements BaseGmsClient.ConnectionProgressReportCallbacks
{
  private final Api<?> mApi;
  private final boolean zzfo;
  private final WeakReference<zzaj> zzhw;
  
  public zzal(zzaj paramzzaj, Api<?> paramApi, boolean paramBoolean)
  {
    AppMethodBeat.i(11242);
    this.zzhw = new WeakReference(paramzzaj);
    this.mApi = paramApi;
    this.zzfo = paramBoolean;
    AppMethodBeat.o(11242);
  }
  
  public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
  {
    boolean bool = false;
    AppMethodBeat.i(11243);
    zzaj localzzaj = (zzaj)this.zzhw.get();
    if (localzzaj == null)
    {
      AppMethodBeat.o(11243);
      return;
    }
    if (Looper.myLooper() == zzaj.zzd(localzzaj).zzfq.getLooper()) {
      bool = true;
    }
    Preconditions.checkState(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zzaj.zzc(localzzaj).lock();
    try
    {
      bool = zzaj.zza(localzzaj, 0);
      if (!bool) {
        return;
      }
      if (!paramConnectionResult.isSuccess()) {
        zzaj.zza(localzzaj, paramConnectionResult, this.mApi, this.zzfo);
      }
      if (zzaj.zzk(localzzaj)) {
        zzaj.zzj(localzzaj);
      }
      return;
    }
    finally
    {
      zzaj.zzc(localzzaj).unlock();
      AppMethodBeat.o(11243);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzal
 * JD-Core Version:    0.7.0.1
 */