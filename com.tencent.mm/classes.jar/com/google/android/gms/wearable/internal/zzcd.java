package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzcd
  implements Parcelable.Creator<zzcc>
{
  static void zza(zzcc paramzzcc, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzcc.getId(), false);
    zzc.zza(paramParcel, 3, paramzzcc.getDisplayName(), false);
    zzc.zzc(paramParcel, 4, paramzzcc.getHopCount());
    zzc.zza(paramParcel, 5, paramzzcc.isNearby());
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzcc zzlo(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    boolean bool = false;
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 2: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 4: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 5: 
        bool = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzcc(str1, str2, i, bool);
  }
  
  public zzcc[] zzpQ(int paramInt)
  {
    return new zzcc[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcd
 * JD-Core Version:    0.7.0.1
 */