package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzit
  implements Runnable
{
  zzit(zzii paramzzii, AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzdz paramzzdz) {}
  
  public final void run()
  {
    AppMethodBeat.i(69332);
    localAtomicReference = this.zzapf;
    for (;;)
    {
      try
      {
        localzzey = zzii.zzd(this.zzape);
        if (localzzey == null)
        {
          this.zzape.zzge().zzim().zzd("Failed to get user properties", zzfg.zzbm(this.zzanj), this.zzanh, this.zzani);
          this.zzapf.set(Collections.emptyList());
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzey localzzey;
        this.zzape.zzge().zzim().zzd("Failed to get user properties", zzfg.zzbm(this.zzanj), this.zzanh, localRemoteException);
        this.zzapf.set(Collections.emptyList());
        this.zzapf.notify();
        continue;
      }
      finally
      {
        this.zzapf.notify();
        AppMethodBeat.o(69332);
      }
      try
      {
        this.zzapf.notify();
        return;
      }
      finally
      {
        AppMethodBeat.o(69332);
      }
    }
    if (TextUtils.isEmpty(this.zzanj)) {
      this.zzapf.set(localzzey.zza(this.zzanh, this.zzani, this.zzanz, this.zzane));
    }
    for (;;)
    {
      zzii.zze(this.zzape);
      this.zzapf.notify();
      AppMethodBeat.o(69332);
      return;
      this.zzapf.set(localzzey.zza(this.zzanj, this.zzanh, this.zzani, this.zzanz));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzit
 * JD-Core Version:    0.7.0.1
 */