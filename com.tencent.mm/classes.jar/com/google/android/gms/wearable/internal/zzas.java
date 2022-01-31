package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzas
  implements Parcelable.Creator<zzar>
{
  static void zza(zzar paramzzar, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzar.statusCode);
    zzc.zzc(paramParcel, 3, paramzzar.zzbUw);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzar zzkZ(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
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
      case 2: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzar(i, j);
  }
  
  public zzar[] zzpB(int paramInt)
  {
    return new zzar[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzas
 * JD-Core Version:    0.7.0.1
 */