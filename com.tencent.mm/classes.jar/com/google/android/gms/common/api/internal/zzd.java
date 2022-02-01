package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzd<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>
  extends zzb
{
  private final A zzdv;
  
  public zzd(int paramInt, A paramA)
  {
    super(paramInt);
    this.zzdv = paramA;
  }
  
  public final void zza(Status paramStatus)
  {
    AppMethodBeat.i(11394);
    this.zzdv.setFailedResult(paramStatus);
    AppMethodBeat.o(11394);
  }
  
  public final void zza(GoogleApiManager.zza<?> paramzza)
  {
    AppMethodBeat.i(11393);
    try
    {
      this.zzdv.run(paramzza.zzae());
      AppMethodBeat.o(11393);
      return;
    }
    catch (RuntimeException paramzza)
    {
      zza(paramzza);
      AppMethodBeat.o(11393);
    }
  }
  
  public final void zza(zzaa paramzzaa, boolean paramBoolean)
  {
    AppMethodBeat.i(11396);
    paramzzaa.zza(this.zzdv, paramBoolean);
    AppMethodBeat.o(11396);
  }
  
  public final void zza(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(11395);
    String str = paramRuntimeException.getClass().getSimpleName();
    paramRuntimeException = paramRuntimeException.getLocalizedMessage();
    paramRuntimeException = new Status(10, String.valueOf(str).length() + 2 + String.valueOf(paramRuntimeException).length() + str + ": " + paramRuntimeException);
    this.zzdv.setFailedResult(paramRuntimeException);
    AppMethodBeat.o(11395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzd
 * JD-Core Version:    0.7.0.1
 */