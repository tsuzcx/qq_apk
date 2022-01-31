package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzbm
  implements Parcelable.Creator<zzbl>
{
  static void zza(zzbl paramzzbl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbl.statusCode);
    zzc.zzc(paramParcel, 3, paramzzbl.zzbUF, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzbl zzlj(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zzb.zzc(paramParcel, k, zzcc.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbl(i, localArrayList);
  }
  
  public zzbl[] zzpL(int paramInt)
  {
    return new zzbl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbm
 * JD-Core Version:    0.7.0.1
 */