package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgo
  extends zzgm<Status>
{
  public zzgo(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zzb(zzbt paramzzbt)
  {
    AppMethodBeat.i(71376);
    zza(new Status(paramzzbt.statusCode));
    AppMethodBeat.o(71376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgo
 * JD-Core Version:    0.7.0.1
 */