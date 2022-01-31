package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzp
  implements Parcelable.Creator<zzo>
{
  static void zza(zzo paramzzo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzo.getName(), false);
    zzc.zzc(paramParcel, 3, paramzzo.zzUs(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzo zzkR(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    ArrayList localArrayList = null;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, j);
        break;
      case 3: 
        localArrayList = zzb.zzc(paramParcel, j, zzcc.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzo(str, localArrayList);
  }
  
  public zzo[] zzpq(int paramInt)
  {
    return new zzo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzp
 * JD-Core Version:    0.7.0.1
 */