package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class zzab
  implements PendingResult.StatusListener
{
  zzab(zzaa paramzzaa, BasePendingResult paramBasePendingResult) {}
  
  public final void onComplete(Status paramStatus)
  {
    AppMethodBeat.i(11175);
    zzaa.zza(this.zzgz).remove(this.zzgy);
    AppMethodBeat.o(11175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzab
 * JD-Core Version:    0.7.0.1
 */