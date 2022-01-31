package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzn
{
  private static final Object zzaGb = new Object();
  private static zzn zzaGc;
  
  public static zzn zzaU(Context paramContext)
  {
    synchronized (zzaGb)
    {
      if (zzaGc == null) {
        zzaGc = new zzo(paramContext.getApplicationContext());
      }
      return zzaGc;
    }
  }
  
  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zzn.zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  protected abstract boolean zza(zzn.zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  public boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return zza(new zzn.zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zzn.zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  protected abstract void zzb(zzn.zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  public void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    zzb(new zzn.zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzn
 * JD-Core Version:    0.7.0.1
 */