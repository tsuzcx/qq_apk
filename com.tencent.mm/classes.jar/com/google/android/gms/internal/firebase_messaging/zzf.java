package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzf
  extends zzb
  implements zze
{
  public static zze zza(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
    if ((localIInterface instanceof zze)) {
      return (zze)localIInterface;
    }
    return new zzg(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzf
 * JD-Core Version:    0.7.0.1
 */