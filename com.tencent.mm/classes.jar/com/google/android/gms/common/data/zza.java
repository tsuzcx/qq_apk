package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zza
  implements Parcelable.Creator<BitmapTeleporter>
{
  static void zza(BitmapTeleporter paramBitmapTeleporter, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramBitmapTeleporter.zzaiI);
    zzc.zza(paramParcel, 2, paramBitmapTeleporter.zzSQ, paramInt, false);
    zzc.zzc(paramParcel, 3, paramBitmapTeleporter.zzakD);
    zzc.zzJ(paramParcel, i);
  }
  
  public BitmapTeleporter zzaN(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
      case 1: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        localParcelFileDescriptor = (ParcelFileDescriptor)zzb.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new BitmapTeleporter(i, localParcelFileDescriptor, j);
  }
  
  public BitmapTeleporter[] zzcF(int paramInt)
  {
    return new BitmapTeleporter[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.data.zza
 * JD-Core Version:    0.7.0.1
 */