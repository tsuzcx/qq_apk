package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzs
  extends zzo
  implements zzr
{
  public static zzr zza(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    if ((localIInterface instanceof zzr)) {
      return (zzr)localIInterface;
    }
    return new zzt(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzs
 * JD-Core Version:    0.7.0.1
 */