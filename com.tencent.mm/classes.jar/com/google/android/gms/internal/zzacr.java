package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacr
  implements Parcelable.Creator<zzacp.zza>
{
  static void zza(zzacp.zza paramzza, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzza.versionCode);
    zzc.zza(paramParcel, 2, paramzza.zzaGV, false);
    zzc.zzc(paramParcel, 3, paramzza.zzaGW);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzacp.zza zzbd(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    String str = null;
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
        str = zzb.zzq(paramParcel, m);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzacp.zza(i, str, j);
  }
  
  public zzacp.zza[] zzdh(int paramInt)
  {
    return new zzacp.zza[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzacr
 * JD-Core Version:    0.7.0.1
 */