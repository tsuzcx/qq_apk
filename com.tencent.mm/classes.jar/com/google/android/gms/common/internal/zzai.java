package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzai
  implements Parcelable.Creator<zzah>
{
  static void zza(zzah paramzzah, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzah.zzaiI);
    zzc.zzc(paramParcel, 2, paramzzah.zzyk());
    zzc.zzc(paramParcel, 3, paramzzah.zzyl());
    zzc.zza(paramParcel, 4, paramzzah.zzym(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzah zzaV(Parcel paramParcel)
  {
    int m = zzb.zzaY(paramParcel);
    Scope[] arrayOfScope = null;
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
      case 1: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 3: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, n, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzah(i, j, k, arrayOfScope);
  }
  
  public zzah[] zzda(int paramInt)
  {
    return new zzah[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzai
 * JD-Core Version:    0.7.0.1
 */