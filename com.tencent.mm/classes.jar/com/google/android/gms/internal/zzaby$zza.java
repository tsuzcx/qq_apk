package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zzf;
import java.lang.ref.WeakReference;

class zzaby$zza
  implements IBinder.DeathRecipient, zzaby.zzb
{
  private final WeakReference<zzf> zzaDA;
  private final WeakReference<IBinder> zzaDB;
  private final WeakReference<zzaaf<?>> zzaDz;
  
  private zzaby$zza(zzaaf<?> paramzzaaf, zzf paramzzf, IBinder paramIBinder)
  {
    this.zzaDA = new WeakReference(paramzzf);
    this.zzaDz = new WeakReference(paramzzaaf);
    this.zzaDB = new WeakReference(paramIBinder);
  }
  
  private void zzxe()
  {
    Object localObject = (zzaaf)this.zzaDz.get();
    zzf localzzf = (zzf)this.zzaDA.get();
    if ((localzzf != null) && (localObject != null)) {
      localzzf.remove(((zzaaf)localObject).zzvr().intValue());
    }
    localObject = (IBinder)this.zzaDB.get();
    if (localObject != null) {
      ((IBinder)localObject).unlinkToDeath(this, 0);
    }
  }
  
  public void binderDied()
  {
    zzxe();
  }
  
  public void zzc(zzaaf<?> paramzzaaf)
  {
    zzxe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaby.zza
 * JD-Core Version:    0.7.0.1
 */