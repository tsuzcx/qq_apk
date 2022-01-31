package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.util.Log;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public abstract class zzzx
{
  public final int zzakD;
  
  public zzzx(int paramInt)
  {
    this.zzakD = paramInt;
  }
  
  private static Status zza(RemoteException paramRemoteException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((zzt.zzzh()) && ((paramRemoteException instanceof TransactionTooLargeException))) {
      localStringBuilder.append("TransactionTooLargeException: ");
    }
    localStringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, localStringBuilder.toString());
  }
  
  public abstract void zza(zzaal paramzzaal, boolean paramBoolean);
  
  public abstract void zza(zzaax.zza<?> paramzza);
  
  public abstract void zzz(Status paramStatus);
  
  public static final class zzd<TResult>
    extends zzzx
  {
    private final TaskCompletionSource<TResult> zzazE;
    private final zzabv<Api.zzb, TResult> zzazI;
    private final zzabs zzazJ;
    
    public zzd(int paramInt, zzabv<Api.zzb, TResult> paramzzabv, TaskCompletionSource<TResult> paramTaskCompletionSource, zzabs paramzzabs)
    {
      super();
      this.zzazE = paramTaskCompletionSource;
      this.zzazI = paramzzabv;
      this.zzazJ = paramzzabs;
    }
    
    public final void zza(zzaal paramzzaal, boolean paramBoolean)
    {
      paramzzaal.zza(this.zzazE, paramBoolean);
    }
    
    public final void zza(zzaax.zza<?> paramzza)
    {
      try
      {
        this.zzazI.zza(paramzza.zzvU(), this.zzazE);
        return;
      }
      catch (DeadObjectException paramzza)
      {
        throw paramzza;
      }
      catch (RemoteException paramzza)
      {
        zzz(zzzx.zzb(paramzza));
      }
    }
    
    public final void zzz(Status paramStatus)
    {
      this.zzazE.trySetException(this.zzazJ.zzA(paramStatus));
    }
  }
  
  public static final class zze
    extends zzzx.zza
  {
    public final zzabh.zzb<?> zzazK;
    
    public zze(zzabh.zzb<?> paramzzb, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super(paramTaskCompletionSource);
      this.zzazK = paramzzb;
    }
    
    public final void zzb(zzaax.zza<?> paramzza)
    {
      paramzza = (zzabn)paramzza.zzwI().remove(this.zzazK);
      if (paramzza != null)
      {
        paramzza.zzazG.zzwX();
        return;
      }
      Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
      this.zzazE.trySetException(new zza(Status.zzazz));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzzx
 * JD-Core Version:    0.7.0.1
 */