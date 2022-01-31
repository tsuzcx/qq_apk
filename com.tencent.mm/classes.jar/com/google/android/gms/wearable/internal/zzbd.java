package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbd
  implements Parcelable.Creator<zzbe>
{
  static void zza(zzbe paramzzbe, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzbe.statusCode);
    zzc.zza(paramParcel, 3, paramzzbe.zzbUB);
    zzc.zza(paramParcel, 4, paramzzbe.zzbUC);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzbe zzlf(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    boolean bool2 = false;
    boolean bool1 = false;
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
        bool1 = zzb.zzc(paramParcel, k);
        break;
      case 4: 
        bool2 = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbe(i, bool1, bool2);
  }
  
  public zzbe[] zzpH(int paramInt)
  {
    return new zzbe[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbd
 * JD-Core Version:    0.7.0.1
 */