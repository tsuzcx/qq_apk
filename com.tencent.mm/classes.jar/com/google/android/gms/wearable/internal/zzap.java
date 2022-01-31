package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzap
  implements Parcelable.Creator<zzao>
{
  static void zza(zzao paramzzao, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramzzao.getUri(), paramInt, false);
    zzc.zza(paramParcel, 4, paramzzao.zzUf(), false);
    zzc.zza(paramParcel, 5, paramzzao.getData(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzao zzkY(Parcel paramParcel)
  {
    int i = zzb.zzaY(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzao(localUri, localBundle, arrayOfByte);
  }
  
  public zzao[] zzpA(int paramInt)
  {
    return new zzao[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzap
 * JD-Core Version:    0.7.0.1
 */