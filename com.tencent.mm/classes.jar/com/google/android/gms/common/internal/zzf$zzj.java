package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

public final class zzf$zzj
  extends zzf.zza
{
  public final IBinder zzaFy;
  
  public zzf$zzj(zzf paramzzf, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramzzf, paramInt, paramBundle);
    this.zzaFy = paramIBinder;
  }
  
  protected final void zzm(ConnectionResult paramConnectionResult)
  {
    if (zzf.zzd(this.zzaFu) != null) {
      zzf.zzd(this.zzaFu).onConnectionFailed(paramConnectionResult);
    }
    this.zzaFu.onConnectionFailed(paramConnectionResult);
  }
  
  protected final boolean zzxG()
  {
    try
    {
      Object localObject = this.zzaFy.getInterfaceDescriptor();
      if (!this.zzaFu.zzeA().equals(localObject))
      {
        String str = String.valueOf(this.zzaFu.zzeA());
        new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(localObject).length()).append("service descriptor mismatch: ").append(str).append(" vs. ").append((String)localObject);
      }
      do
      {
        return false;
        localObject = this.zzaFu.zzh(this.zzaFy);
      } while ((localObject == null) || (!zzf.zza(this.zzaFu, 2, 3, (IInterface)localObject)));
      localObject = this.zzaFu.zzuC();
      if (zzf.zzb(this.zzaFu) != null) {
        zzf.zzb(this.zzaFu).onConnected((Bundle)localObject);
      }
      return true;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zzj
 * JD-Core Version:    0.7.0.1
 */