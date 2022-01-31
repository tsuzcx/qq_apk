package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzcf
  implements Parcelable.Creator<zzce>
{
  static void zza(zzce paramzzce, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzce.statusCode);
    zzc.zza(paramParcel, 3, paramzzce.zzbUa, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzce zzlp(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    zzu localzzu = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 2: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 3: 
        localzzu = (zzu)zzb.zza(paramParcel, k, zzu.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzce(i, localzzu);
  }
  
  public zzce[] zzpR(int paramInt)
  {
    return new zzce[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcf
 * JD-Core Version:    0.7.0.1
 */