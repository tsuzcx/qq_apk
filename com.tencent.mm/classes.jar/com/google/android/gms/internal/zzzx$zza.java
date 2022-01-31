package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzzx$zza
  extends zzzx
{
  protected final TaskCompletionSource<Void> zzazE;
  
  public zzzx$zza(int paramInt, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    super(paramInt);
    this.zzazE = paramTaskCompletionSource;
  }
  
  public void zza(zzaal paramzzaal, boolean paramBoolean) {}
  
  public final void zza(zzaax.zza<?> paramzza)
  {
    try
    {
      zzb(paramzza);
      return;
    }
    catch (DeadObjectException paramzza)
    {
      zzz(zzzx.zzb(paramzza));
      throw paramzza;
    }
    catch (RemoteException paramzza)
    {
      zzz(zzzx.zzb(paramzza));
    }
  }
  
  protected abstract void zzb(zzaax.zza<?> paramzza);
  
  public void zzz(Status paramStatus)
  {
    this.zzazE.trySetException(new zza(paramStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzzx.zza
 * JD-Core Version:    0.7.0.1
 */