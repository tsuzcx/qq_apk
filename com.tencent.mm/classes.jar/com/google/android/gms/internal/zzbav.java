package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzad;

public class zzbav
  implements Parcelable.Creator<zzbau>
{
  static void zza(zzbau paramzzbau, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbau.zzaiI);
    zzc.zza(paramParcel, 2, paramzzbau.zzPS(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzbau zzjx(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    zzad localzzad = null;
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
        localzzad = (zzad)zzb.zza(paramParcel, k, zzad.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbau(i, localzzad);
  }
  
  public zzbau[] zznx(int paramInt)
  {
    return new zzbau[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzbav
 * JD-Core Version:    0.7.0.1
 */