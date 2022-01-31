package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.stats.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzo$zza
  implements ServiceConnection
{
  private int mState;
  private IBinder zzaFz;
  private ComponentName zzaGe;
  private final Set<ServiceConnection> zzaGj;
  private boolean zzaGk;
  private final zzn.zza zzaGl;
  
  public zzo$zza(zzo paramzzo, zzn.zza paramzza)
  {
    this.zzaGl = paramzza;
    this.zzaGj = new HashSet();
    this.mState = 2;
  }
  
  public final IBinder getBinder()
  {
    return this.zzaFz;
  }
  
  public final ComponentName getComponentName()
  {
    return this.zzaGe;
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public final boolean isBound()
  {
    return this.zzaGk;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (zzo.zza(this.zzaGm))
    {
      zzo.zzb(this.zzaGm).removeMessages(1, this.zzaGl);
      this.zzaFz = paramIBinder;
      this.zzaGe = paramComponentName;
      Iterator localIterator = this.zzaGj.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    this.mState = 1;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (zzo.zza(this.zzaGm))
    {
      zzo.zzb(this.zzaGm).removeMessages(1, this.zzaGl);
      this.zzaFz = null;
      this.zzaGe = paramComponentName;
      Iterator localIterator = this.zzaGj.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    this.mState = 2;
  }
  
  public final void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    zzo.zzd(this.zzaGm).zza(zzo.zzc(this.zzaGm), paramServiceConnection, paramString, this.zzaGl.zzxZ());
    this.zzaGj.add(paramServiceConnection);
  }
  
  public final boolean zza(ServiceConnection paramServiceConnection)
  {
    return this.zzaGj.contains(paramServiceConnection);
  }
  
  public final void zzb(ServiceConnection paramServiceConnection, String paramString)
  {
    zzo.zzd(this.zzaGm).zzb(zzo.zzc(this.zzaGm), paramServiceConnection);
    this.zzaGj.remove(paramServiceConnection);
  }
  
  public final void zzdn(String paramString)
  {
    this.mState = 3;
    this.zzaGk = zzo.zzd(this.zzaGm).zza(zzo.zzc(this.zzaGm), paramString, this.zzaGl.zzxZ(), this, 129);
    if (this.zzaGk)
    {
      paramString = zzo.zzb(this.zzaGm).obtainMessage(1, this.zzaGl);
      zzo.zzb(this.zzaGm).sendMessageDelayed(paramString, zzo.zze(this.zzaGm));
      return;
    }
    this.mState = 2;
    try
    {
      zzo.zzd(this.zzaGm).zza(zzo.zzc(this.zzaGm), this);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public final void zzdo(String paramString)
  {
    zzo.zzb(this.zzaGm).removeMessages(1, this.zzaGl);
    zzo.zzd(this.zzaGm).zza(zzo.zzc(this.zzaGm), this);
    this.zzaGk = false;
    this.mState = 2;
  }
  
  public final boolean zzya()
  {
    return this.zzaGj.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzo.zza
 * JD-Core Version:    0.7.0.1
 */