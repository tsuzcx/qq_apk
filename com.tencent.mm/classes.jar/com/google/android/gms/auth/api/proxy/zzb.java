package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<zza>
{
  static void zza(zza paramzza, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramzza.hostname, false);
    zzc.zzc(paramParcel, 2, paramzza.port);
    zzc.zza(paramParcel, 3, paramzza.timeoutMillis);
    zzc.zza(paramParcel, 4, paramzza.body, false);
    zzc.zza(paramParcel, 5, paramzza.method, false);
    zzc.zzc(paramParcel, 1000, paramzza.versionCode);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zza zzT(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    long l = 0L;
    String str1 = null;
    byte[] arrayOfByte = null;
    int i = 0;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzdc(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, m);
        break;
      case 1: 
        str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, m);
        break;
      case 2: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, m);
        break;
      case 3: 
        l = com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, m);
        break;
      case 5: 
        str1 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, m);
        break;
      case 1000: 
        j = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zza(j, str2, i, l, arrayOfByte, str1);
  }
  
  public zza[] zzbi(int paramInt)
  {
    return new zza[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zzb
 * JD-Core Version:    0.7.0.1
 */