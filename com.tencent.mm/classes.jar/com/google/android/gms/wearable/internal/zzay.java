package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzay
  implements Parcelable.Creator<zzax>
{
  static void zza(zzax paramzzax, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 2, paramzzax.statusCode);
    zzc.zza(paramParcel, 3, paramzzax.zzbUz, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzax zzlc(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)zzb.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzax(i, localParcelFileDescriptor);
  }
  
  public zzax[] zzpE(int paramInt)
  {
    return new zzax[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzay
 * JD-Core Version:    0.7.0.1
 */