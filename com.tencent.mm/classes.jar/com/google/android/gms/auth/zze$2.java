package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcb.zza;

final class zze$2
  implements zze.zza<Void>
{
  zze$2(String paramString, Bundle paramBundle) {}
  
  public final Void zzav(IBinder paramIBinder)
  {
    paramIBinder = (Bundle)zze.zzo(zzcb.zza.zza(paramIBinder).zza(this.zzaiD, this.zzaiE));
    String str = paramIBinder.getString("Error");
    if (!paramIBinder.getBoolean("booleanResult")) {
      throw new GoogleAuthException(str);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.zze.2
 * JD-Core Version:    0.7.0.1
 */