package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzacy
  implements Parcelable.Creator<zzacw.zza>
{
  static void zza(zzacw.zza paramzza, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzza.versionCode);
    zzc.zza(paramParcel, 2, paramzza.className, false);
    zzc.zzc(paramParcel, 3, paramzza.zzaHk, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzacw.zza zzbh(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zzb.zzc(paramParcel, k, zzacw.zzb.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzacw.zza(i, str, localArrayList);
  }
  
  public zzacw.zza[] zzdl(int paramInt)
  {
    return new zzacw.zza[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzacy
 * JD-Core Version:    0.7.0.1
 */