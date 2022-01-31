package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzh
  implements Parcelable.Creator<PutDataRequest>
{
  static void zza(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramPutDataRequest.getUri(), paramInt, false);
    zzc.zza(paramParcel, 4, paramPutDataRequest.zzUf(), false);
    zzc.zza(paramParcel, 5, paramPutDataRequest.getData(), false);
    zzc.zza(paramParcel, 6, paramPutDataRequest.zzUg());
    zzc.zzJ(paramParcel, i);
  }
  
  public PutDataRequest zzkM(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
    long l = 0L;
    byte[] arrayOfByte = null;
    Bundle localBundle = null;
    Uri localUri = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(j))
      {
      case 3: 
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        localUri = (Uri)zzb.zza(paramParcel, j, Uri.CREATOR);
        break;
      case 4: 
        localBundle = zzb.zzs(paramParcel, j);
        break;
      case 5: 
        arrayOfByte = zzb.zzt(paramParcel, j);
        break;
      case 6: 
        l = zzb.zzi(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new PutDataRequest(localUri, localBundle, arrayOfByte, l);
  }
  
  public PutDataRequest[] zzpl(int paramInt)
  {
    return new PutDataRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.zzh
 * JD-Core Version:    0.7.0.1
 */