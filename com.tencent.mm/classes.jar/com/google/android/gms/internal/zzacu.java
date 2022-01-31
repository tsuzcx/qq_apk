package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacu
  implements Parcelable.Creator<zzacs.zza>
{
  static void zza(zzacs.zza paramzza, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzza.getVersionCode());
    zzc.zzc(paramParcel, 2, paramzza.zzys());
    zzc.zza(paramParcel, 3, paramzza.zzyt());
    zzc.zzc(paramParcel, 4, paramzza.zzyu());
    zzc.zza(paramParcel, 5, paramzza.zzyv());
    zzc.zza(paramParcel, 6, paramzza.zzyw(), false);
    zzc.zzc(paramParcel, 7, paramzza.zzyx());
    zzc.zza(paramParcel, 8, paramzza.zzyz(), false);
    zzc.zza(paramParcel, 9, paramzza.zzyB(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzacs.zza zzbe(Parcel paramParcel)
  {
    int n = zzb.zzaY(paramParcel);
    zzacn localzzacn = null;
    String str1 = null;
    int i = 0;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(i1))
      {
      default: 
        zzb.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zzb.zzg(paramParcel, i1);
        break;
      case 2: 
        k = zzb.zzg(paramParcel, i1);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, i1);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, i1);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, i1);
        break;
      case 6: 
        str2 = zzb.zzq(paramParcel, i1);
        break;
      case 7: 
        i = zzb.zzg(paramParcel, i1);
        break;
      case 8: 
        str1 = zzb.zzq(paramParcel, i1);
        break;
      case 9: 
        localzzacn = (zzacn)zzb.zza(paramParcel, i1, zzacn.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zzb.zza(37 + "Overread allowed size end=" + n, paramParcel);
    }
    return new zzacs.zza(m, k, bool2, j, bool1, str2, i, str1, localzzacn);
  }
  
  public zzacs.zza[] zzdi(int paramInt)
  {
    return new zzacs.zza[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzacu
 * JD-Core Version:    0.7.0.1
 */