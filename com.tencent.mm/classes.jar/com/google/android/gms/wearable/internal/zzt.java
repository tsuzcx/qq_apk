package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzt
  implements Parcelable.Creator<zzs>
{
  static void zza(zzs paramzzs, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzs.zzbUa, paramInt, false);
    zzc.zzc(paramParcel, 3, paramzzs.type);
    zzc.zzc(paramParcel, 4, paramzzs.zzbTY);
    zzc.zzc(paramParcel, 5, paramzzs.zzbTZ);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzs zzkS(Parcel paramParcel)
  {
    int m = zzb.zzaY(paramParcel);
    zzu localzzu = null;
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 2: 
        localzzu = (zzu)zzb.zza(paramParcel, n, zzu.CREATOR);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 5: 
        k = zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzs(localzzu, i, j, k);
  }
  
  public zzs[] zzpt(int paramInt)
  {
    return new zzs[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzt
 * JD-Core Version:    0.7.0.1
 */