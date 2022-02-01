package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhc
  extends zzgm<Status>
{
  public zzhc(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzbp paramzzbp)
  {
    AppMethodBeat.i(101374);
    zza(new Status(paramzzbp.statusCode));
    AppMethodBeat.o(101374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhc
 * JD-Core Version:    0.7.0.1
 */