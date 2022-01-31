package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacv
  implements Parcelable.Creator<zzacw.zzb>
{
  static void zza(zzacw.zzb paramzzb, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzb.versionCode);
    zzc.zza(paramParcel, 2, paramzzb.zzaB, false);
    zzc.zza(paramParcel, 3, paramzzb.zzaHl, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzacw.zzb zzbf(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    zzacs.zza localzza = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        localzza = (zzacs.zza)zzb.zza(paramParcel, k, zzacs.zza.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzacw.zzb(i, str, localzza);
  }
  
  public zzacw.zzb[] zzdj(int paramInt)
  {
    return new zzacw.zzb[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzacv
 * JD-Core Version:    0.7.0.1
 */