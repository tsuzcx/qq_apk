package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zziv
  implements Runnable
{
  zziv(zzii paramzzii, AtomicReference paramAtomicReference, zzdz paramzzdz, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(1857);
    localAtomicReference = this.zzapf;
    for (;;)
    {
      try
      {
        localzzey = zzii.zzd(this.zzape);
        if (localzzey == null) {
          this.zzape.zzge().zzim().log("Failed to get user properties");
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzey localzzey;
        this.zzape.zzge().zzim().zzg("Failed to get user properties", localRemoteException);
        this.zzapf.notify();
        continue;
      }
      finally
      {
        this.zzapf.notify();
        AppMethodBeat.o(1857);
      }
      try
      {
        this.zzapf.notify();
        return;
      }
      finally
      {
        AppMethodBeat.o(1857);
      }
    }
    this.zzapf.set(localzzey.zza(this.zzane, this.zzanz));
    zzii.zze(this.zzape);
    this.zzapf.notify();
    AppMethodBeat.o(1857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zziv
 * JD-Core Version:    0.7.0.1
 */