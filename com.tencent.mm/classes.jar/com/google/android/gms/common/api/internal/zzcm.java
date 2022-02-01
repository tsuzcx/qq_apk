package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zzcm
  implements IBinder.DeathRecipient, zzcn
{
  private final WeakReference<BasePendingResult<?>> zzmr;
  private final WeakReference<zzc> zzms;
  private final WeakReference<IBinder> zzmt;
  
  private zzcm(BasePendingResult<?> paramBasePendingResult, zzc paramzzc, IBinder paramIBinder)
  {
    AppMethodBeat.i(11389);
    this.zzms = new WeakReference(paramzzc);
    this.zzmr = new WeakReference(paramBasePendingResult);
    this.zzmt = new WeakReference(paramIBinder);
    AppMethodBeat.o(11389);
  }
  
  private final void zzcf()
  {
    AppMethodBeat.i(11392);
    Object localObject = (BasePendingResult)this.zzmr.get();
    zzc localzzc = (zzc)this.zzms.get();
    if ((localzzc != null) && (localObject != null)) {
      localzzc.remove(((PendingResult)localObject).zzo().intValue());
    }
    localObject = (IBinder)this.zzmt.get();
    if (localObject != null) {
      try
      {
        ((IBinder)localObject).unlinkToDeath(this, 0);
        AppMethodBeat.o(11392);
        return;
      }
      catch (NoSuchElementException localNoSuchElementException) {}
    }
    AppMethodBeat.o(11392);
  }
  
  public final void binderDied()
  {
    AppMethodBeat.i(11391);
    zzcf();
    AppMethodBeat.o(11391);
  }
  
  public final void zzc(BasePendingResult<?> paramBasePendingResult)
  {
    AppMethodBeat.i(11390);
    zzcf();
    AppMethodBeat.o(11390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcm
 * JD-Core Version:    0.7.0.1
 */