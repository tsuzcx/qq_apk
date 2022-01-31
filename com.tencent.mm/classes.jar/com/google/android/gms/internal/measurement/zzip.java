package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzip
  implements Runnable
{
  zzip(zzii paramzzii, zzdz paramzzdz) {}
  
  public final void run()
  {
    AppMethodBeat.i(69328);
    zzey localzzey = zzii.zzd(this.zzape);
    if (localzzey == null)
    {
      this.zzape.zzge().zzim().log("Failed to send measurementEnabled to service");
      AppMethodBeat.o(69328);
      return;
    }
    try
    {
      localzzey.zzb(this.zzane);
      zzii.zze(this.zzape);
      AppMethodBeat.o(69328);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzape.zzge().zzim().zzg("Failed to send measurementEnabled to the service", localRemoteException);
      AppMethodBeat.o(69328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzip
 * JD-Core Version:    0.7.0.1
 */