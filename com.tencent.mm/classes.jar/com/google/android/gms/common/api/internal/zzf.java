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
    AppMethodBeat.i(11404);
    Feature[] arrayOfFeature = this.zzdy.zzca();
    AppMethodBeat.o(11404);
    return arrayOfFeature;
  }
  
  public final boolean shouldAutoResolveMissingFeatures()
  {
    AppMethodBeat.i(11405);
    boolean bool = this.zzdy.shouldAutoResolveMissingFeatures();
    AppMethodBeat.o(11405);
    return bool;
  }
  
  public final void zza(Status paramStatus)
  {
    AppMethodBeat.i(11401);
    this.zzdu.trySetException(this.zzdz.getException(paramStatus));
    AppMethodBeat.o(11401);
  }
  
  public final void zza(GoogleApiManager.zza<?> paramzza)
  {
    AppMethodBeat.i(11400);
    try
    {
      this.zzdy.doExecute(paramzza.zzae(), this.zzdu);
      AppMethodBeat.o(11400);
      return;
    }
    catch (DeadObjectException paramzza)
    {
      AppMethodBeat.o(11400);
      throw paramzza;
    }
    catch (RemoteException paramzza)
    {
      zza(zzb.zzb(paramzza));
      AppMethodBeat.o(11400);
      return;
    }
    catch (RuntimeException paramzza)
    {
      zza(paramzza);
      AppMethodBeat.o(11400);
    }
  }
  
  public final void zza(zzaa paramzzaa, boolean paramBoolean)
  {
    AppMethodBeat.i(11403);
    paramzzaa.zza(this.zzdu, paramBoolean);
    AppMethodBeat.o(11403);
  }
  
  public final void zza(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(11402);
    this.zzdu.trySetException(paramRuntimeException);
    AppMethodBeat.o(11402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzf
 * JD-Core Version:    0.7.0.1
 */