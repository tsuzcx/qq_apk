package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzak
  implements Runnable
{
  zzak(zzaj paramzzaj) {}
  
  public final void run()
  {
    AppMethodBeat.i(11241);
    zzaj.zzb(this.zzhv).cancelAvailabilityErrorNotifications(zzaj.zza(this.zzhv));
    AppMethodBeat.o(11241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzak
 * JD-Core Version:    0.7.0.1
 */