package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzin
  implements Runnable
{
  zzin(zzii paramzzii, zzie paramzzie) {}
  
  public final void run()
  {
    AppMethodBeat.i(1849);
    zzey localzzey = zzii.zzd(this.zzape);
    if (localzzey == null)
    {
      this.zzape.zzge().zzim().log("Failed to send current screen to service");
      AppMethodBeat.o(1849);
      return;
    }
    try
    {
      if (this.zzaow == null) {
        localzzey.zza(0L, null, null, this.zzape.getContext().getPackageName());
      }
      for (;;)
      {
        zzii.zze(this.zzape);
        AppMethodBeat.o(1849);
        return;
        localzzey.zza(this.zzaow.zzaoj, this.zzaow.zzul, this.zzaow.zzaoi, this.zzape.getContext().getPackageName());
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzape.zzge().zzim().zzg("Failed to send current screen to the service", localRemoteException);
      AppMethodBeat.o(1849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzin
 * JD-Core Version:    0.7.0.1
 */