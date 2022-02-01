package com.google.android.gms.auth.account;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.auth.zze;

public abstract class zzg
  extends zze
  implements zzf
{
  public static zzf zzf(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
    if ((localIInterface instanceof zzf)) {
      return (zzf)localIInterface;
    }
    return new zzh(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.account.zzg
 * JD-Core Version:    0.7.0.1
 */