package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhf
  extends zzgm<Status>
{
  public zzhf(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzbn paramzzbn)
  {
    AppMethodBeat.i(71394);
    zza(new Status(paramzzbn.statusCode));
    AppMethodBeat.o(71394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhf
 * JD-Core Version:    0.7.0.1
 */