package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<WebImage>
{
  static void zza(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramWebImage.zzaiI);
    zzc.zza(paramParcel, 2, paramWebImage.getUrl(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramWebImage.getWidth());
    zzc.zzc(paramParcel, 4, paramWebImage.getHeight());
    zzc.zzJ(paramParcel, i);
  }
  
  public WebImage zzaP(Parcel paramParcel)
  {
    int m = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    Uri localUri = null;
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzdc(n))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, n);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, n);
        break;
      case 2: 
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, n, Uri.CREATOR);
        break;
      case 3: 
        j = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, n);
        break;
      case 4: 
        k = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new WebImage(i, localUri, j, k);
  }
  
  public WebImage[] zzcP(int paramInt)
  {
    return new WebImage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.zzb
 * JD-Core Version:    0.7.0.1
 */