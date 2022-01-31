package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbb
  implements Parcelable.Creator<zzbc>
{
  static void zza(zzbc paramzzbc, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbc.statusCode);
    zzc.zza(paramParcel, 3, paramzzbc.zzbUA);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzbc zzle(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    boolean bool = false;
    int i = 0;
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
        bool = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbc(i, bool);
  }
  
  public zzbc[] zzpG(int paramInt)
  {
    return new zzbc[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbb
 * JD-Core Version:    0.7.0.1
 */