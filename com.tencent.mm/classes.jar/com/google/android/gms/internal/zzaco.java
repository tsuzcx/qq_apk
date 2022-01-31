package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzaco
  implements Parcelable.Creator<zzacn>
{
  static void zza(zzacn paramzzacn, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzacn.zzaiI);
    zzc.zza(paramParcel, 2, paramzzacn.zzyo(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzacn zzbb(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    zzacp localzzacp = null;
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
        localzzacp = (zzacp)zzb.zza(paramParcel, k, zzacp.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzacn(i, localzzacp);
  }
  
  public zzacn[] zzdf(int paramInt)
  {
    return new zzacn[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaco
 * JD-Core Version:    0.7.0.1
 */