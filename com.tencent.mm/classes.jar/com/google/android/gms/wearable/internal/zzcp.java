package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzcp
  implements Parcelable.Creator<zzco>
{
  static void zza(zzco paramzzco, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzco.statusCode);
    zzc.zzc(paramParcel, 3, paramzzco.zzbhZ);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzco zzlu(Parcel paramParcel)
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
    return new zzco(i, j);
  }
  
  public zzco[] zzpW(int paramInt)
  {
    return new zzco[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcp
 * JD-Core Version:    0.7.0.1
 */