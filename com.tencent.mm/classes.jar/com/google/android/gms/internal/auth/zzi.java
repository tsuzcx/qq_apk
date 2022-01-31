package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzi
  extends zze
  implements zzh
{
  public static zzh zzd(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
    if ((localIInterface instanceof zzh)) {
      return (zzh)localIInterface;
    }
    return new zzj(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzi
 * JD-Core Version:    0.7.0.1
 */