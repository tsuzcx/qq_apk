package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<Asset>
{
  static void zza(Asset paramAsset, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramAsset.getData(), false);
    zzc.zza(paramParcel, 3, paramAsset.getDigest(), false);
    zzc.zza(paramParcel, 4, paramAsset.zzbSQ, paramInt, false);
    zzc.zza(paramParcel, 5, paramAsset.uri, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public Asset zzkK(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    Uri localUri = null;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    String str = null;
    byte[] arrayOfByte = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        arrayOfByte = zzb.zzt(paramParcel, j);
        break;
      case 3: 
        str = zzb.zzq(paramParcel, j);
        break;
      case 4: 
        localParcelFileDescriptor = (ParcelFileDescriptor)zzb.zza(paramParcel, j, ParcelFileDescriptor.CREATOR);
        break;
      case 5: 
        localUri = (Uri)zzb.zza(paramParcel, j, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new Asset(arrayOfByte, str, localParcelFileDescriptor, localUri);
  }
  
  public Asset[] zzpj(int paramInt)
  {
    return new Asset[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.zze
 * JD-Core Version:    0.7.0.1
 */