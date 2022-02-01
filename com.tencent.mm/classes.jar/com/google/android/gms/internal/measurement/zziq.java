package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zziq
  implements Runnable
{
  zziq(zzii paramzzii, boolean paramBoolean1, boolean paramBoolean2, zzeu paramzzeu, zzdz paramzzdz, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(1852);
    zzey localzzey = zzii.zzd(this.zzape);
    if (localzzey == null)
    {
      this.zzape.zzge().zzim().log("Discarding data. Failed to send event to service");
      AppMethodBeat.o(1852);
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
      AppMethodBeat.o(1852);
      return;
      localObject = this.zzank;
      break;
      try
      {
        if (!TextUtils.isEmpty(this.zzanj)) {
          break label140;
        }
        localzzey.zza(this.zzank, this.zzane);
      }
      catch (RemoteException localRemoteException)
      {
        this.zzape.zzge().zzim().zzg("Failed to send event to the service", localRemoteException);
      }
      continue;
      label140:
      localzzey.zza(this.zzank, this.zzanj, this.zzape.zzge().zziv());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zziq
 * JD-Core Version:    0.7.0.1
 */