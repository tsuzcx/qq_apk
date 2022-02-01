package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzil
  implements Runnable
{
  zzil(zzii paramzzii, AtomicReference paramAtomicReference, zzdz paramzzdz) {}
  
  public final void run()
  {
    AppMethodBeat.i(1847);
    localAtomicReference = this.zzapf;
    for (;;)
    {
      try
      {
        localObject1 = zzii.zzd(this.zzape);
        if (localObject1 == null) {
          this.zzape.zzge().zzim().log("Failed to get app instance id");
        }
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject1;
        this.zzape.zzge().zzim().zzg("Failed to get app instance id", localRemoteException);
        this.zzapf.notify();
        continue;
      }
      finally
      {
        this.zzapf.notify();
        AppMethodBeat.o(1847);
      }
      try
      {
        this.zzapf.notify();
        return;
      }
      finally
      {
        AppMethodBeat.o(1847);
      }
    }
    this.zzapf.set(((zzey)localObject1).zzc(this.zzane));
    localObject1 = (String)this.zzapf.get();
    if (localObject1 != null)
    {
      this.zzape.zzfu().zzbr((String)localObject1);
      this.zzape.zzgf().zzakb.zzbs((String)localObject1);
    }
    zzii.zze(this.zzape);
    this.zzapf.notify();
    AppMethodBeat.o(1847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzil
 * JD-Core Version:    0.7.0.1
 */