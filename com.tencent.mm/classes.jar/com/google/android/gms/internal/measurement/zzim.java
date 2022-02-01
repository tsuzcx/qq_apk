package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzim
  implements Runnable
{
  zzim(zzii paramzzii, zzdz paramzzdz) {}
  
  public final void run()
  {
    AppMethodBeat.i(1848);
    zzey localzzey = zzii.zzd(this.zzape);
    if (localzzey == null)
    {
      this.zzape.zzge().zzim().log("Discarding data. Failed to send app launch");
      AppMethodBeat.o(1848);
      return;
    }
    try
    {
      localzzey.zza(this.zzane);
      this.zzape.zza(localzzey, null, this.zzane);
      zzii.zze(this.zzape);
      AppMethodBeat.o(1848);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzape.zzge().zzim().zzg("Failed to send app launch to the service", localRemoteException);
      AppMethodBeat.o(1848);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzim
 * JD-Core Version:    0.7.0.1
 */