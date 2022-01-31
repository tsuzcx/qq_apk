package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

final class zzcl
  implements zzcn
{
  zzcl(zzck paramzzck) {}
  
  public final void zzc(BasePendingResult<?> paramBasePendingResult)
  {
    AppMethodBeat.i(60896);
    this.zzmq.zzmo.remove(paramBasePendingResult);
    AppMethodBeat.o(60896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcl
 * JD-Core Version:    0.7.0.1
 */