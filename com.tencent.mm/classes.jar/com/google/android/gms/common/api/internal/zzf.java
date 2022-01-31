package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzf<ResultT>
  extends zzb
{
  private final TaskCompletionSource<ResultT> zzdu;
  private final TaskApiCall<Api.AnyClient, ResultT> zzdy;
  private final StatusExceptionMapper zzdz;
  
  public zzf(int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    super(paramInt);
    this.zzdu = paramTaskCompletionSource;
    this.zzdy = paramTaskApiCall;
    this.zzdz = paramStatusExceptionMapper;
  }
  
  public final Feature[] getRequiredFeatures()
  {
    AppMethodBeat.i(60912);
    Feature[] arrayOfFeature = this.zzdy.zzca();
    AppMethodBeat.o(60912);
    return arrayOfFeature;
  }
  
  public final boolean shouldAutoResolveMissingFeatures()
  {
    AppMethodBeat.i(60913);
    boolean bool = this.zzdy.shouldAutoResolveMissingFeatures();
    AppMethodBeat.o(60913);
    return bool;
  }
  
  public final void zza(Status paramStatus)
  {
    AppMethodBeat.i(60909);
    this.zzdu.trySetException(this.zzdz.getException(paramStatus));
    AppMethodBeat.o(60909);
  }
  
  public final void zza(GoogleApiManager.zza<?> paramzza)
  {
    AppMethodBeat.i(60908);
    try
    {
      this.zzdy.doExecute(paramzza.zzae(), this.zzdu);
      AppMethodBeat.o(60908);
      return;
    }
    catch (DeadObjectException paramzza)
    {
      AppMethodBeat.o(60908);
      throw paramzza;
    }
    catch (RemoteException paramzza)
    {
      zza(zzb.zzb(paramzza));
      AppMethodBeat.o(60908);
      return;
    }
    catch (RuntimeException paramzza)
    {
      zza(paramzza);
      AppMethodBeat.o(60908);
    }
  }
  
  public final void zza(zzaa paramzzaa, boolean paramBoolean)
  {
    AppMethodBeat.i(60911);
    paramzzaa.zza(this.zzdu, paramBoolean);
    AppMethodBeat.o(60911);
  }
  
  public final void zza(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(60910);
    this.zzdu.trySetException(paramRuntimeException);
    AppMethodBeat.o(60910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzf
 * JD-Core Version:    0.7.0.1
 */