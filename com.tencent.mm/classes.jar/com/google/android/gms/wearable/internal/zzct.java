package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzct
  implements Parcelable.Creator<zzcs>
{
  static void zza(zzcs paramzzcs, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzcs.statusCode);
    zzc.zza(paramParcel, 3, paramzzcs.zzbUT);
    zzc.zzc(paramParcel, 4, paramzzcs.zzbUV, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzcs zzlv(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    long l = 0L;
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
        l = zzb.zzi(paramParcel, k);
        break;
      case 4: 
        localArrayList = zzb.zzc(paramParcel, k, zzcg.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzcs(i, l, localArrayList);
  }
  
  public zzcs[] zzpX(int paramInt)
  {
    return new zzcs[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzct
 * JD-Core Version:    0.7.0.1
 */