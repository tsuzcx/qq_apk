package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbal
  implements Parcelable.Creator<zzbak>
{
  static void zza(zzbak paramzzbak, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbak.zzaiI);
    zzc.zzc(paramParcel, 2, paramzzbak.zzPO());
    zzc.zza(paramParcel, 3, paramzzbak.zzPP(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzbak zzju(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    Intent localIntent = null;
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
        localIntent = (Intent)zzb.zza(paramParcel, m, Intent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzbak(i, j, localIntent);
  }
  
  public zzbak[] zznt(int paramInt)
  {
    return new zzbak[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzbal
 * JD-Core Version:    0.7.0.1
 */