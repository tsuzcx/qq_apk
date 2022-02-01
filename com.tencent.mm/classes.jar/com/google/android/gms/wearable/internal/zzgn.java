package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgn
  extends zzgm<Status>
{
  public zzgn(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzbt paramzzbt)
  {
    AppMethodBeat.i(101358);
    zza(new Status(paramzzbt.statusCode));
    AppMethodBeat.o(101358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgn
 * JD-Core Version:    0.7.0.1
 */