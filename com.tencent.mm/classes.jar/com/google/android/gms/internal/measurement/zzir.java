package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzir
  implements Runnable
{
  zzir(zzii paramzzii, boolean paramBoolean1, boolean paramBoolean2, zzed paramzzed1, zzdz paramzzdz, zzed paramzzed2) {}
  
  public final void run()
  {
    AppMethodBeat.i(1853);
    zzey localzzey = zzii.zzd(this.zzape);
    if (localzzey == null)
    {
      this.zzape.zzge().zzim().log("Discarding data. Failed to send conditional user property to service");
      AppMethodBeat.o(1853);
      return;
    }
    Object localObject;
    if (this.zzapg)
    {
      zzii localzzii = this.zzape;
      if (this.zzaph)
      {
        localObject = null;
        localzzii.zza(localzzey, (AbstractSafeParcelable)localObject, this.zzane);
      }
    }
    for (;;)
    {
      zzii.zze(this.zzape);
      AppMethodBeat.o(1853);
      return;
      localObject = this.zzapi;
      break;
      try
      {
        if (!TextUtils.isEmpty(this.zzapj.packageName)) {
          break label143;
        }
        localzzey.zza(this.zzapi, this.zzane);
      }
      catch (RemoteException localRemoteException)
      {
        this.zzape.zzge().zzim().zzg("Failed to send conditional user property to the service", localRemoteException);
      }
      continue;
      label143:
      localzzey.zzb(this.zzapi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzir
 * JD-Core Version:    0.7.0.1
 */