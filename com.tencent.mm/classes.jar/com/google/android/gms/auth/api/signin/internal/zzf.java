package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzf
  implements Parcelable.Creator<zzg>
{
  static void zza(zzg paramzzg, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzg.versionCode);
    zzc.zzc(paramParcel, 2, paramzzg.getType());
    zzc.zza(paramParcel, 3, paramzzg.getBundle(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzg zzZ(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    Bundle localBundle = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, m);
        break;
      case 3: 
        localBundle = zzb.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzg(i, j, localBundle);
  }
  
  public zzg[] zzbo(int paramInt)
  {
    return new zzg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzf
 * JD-Core Version:    0.7.0.1
 */