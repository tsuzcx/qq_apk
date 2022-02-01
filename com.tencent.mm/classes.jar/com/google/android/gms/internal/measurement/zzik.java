package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzik
  implements Runnable
{
  zzik(zzii paramzzii, zzdz paramzzdz) {}
  
  public final void run()
  {
    AppMethodBeat.i(1846);
    zzey localzzey = zzii.zzd(this.zzape);
    if (localzzey == null)
    {
      this.zzape.zzge().zzim().log("Failed to reset data on the service; null service");
      AppMethodBeat.o(1846);
      return;
    }
    try
    {
      localzzey.zzd(this.zzane);
      zzii.zze(this.zzape);
      AppMethodBeat.o(1846);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        this.zzape.zzge().zzim().zzg("Failed to reset data on the service", localRemoteException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzik
 * JD-Core Version:    0.7.0.1
 */