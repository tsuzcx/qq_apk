package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

final class zzan
  extends zzbe
{
  zzan(zzam paramzzam, zzbc paramzzbc, ConnectionResult paramConnectionResult)
  {
    super(paramzzbc);
  }
  
  @GuardedBy("mLock")
  public final void zzaq()
  {
    AppMethodBeat.i(11245);
    zzaj.zza(this.zzhz.zzhv, this.zzhy);
    AppMethodBeat.o(11245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzan
 * JD-Core Version:    0.7.0.1
 */