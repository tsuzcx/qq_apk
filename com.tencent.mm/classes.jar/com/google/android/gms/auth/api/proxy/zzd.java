package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzd
  implements Parcelable.Creator<ProxyResponse>
{
  static void zza(ProxyResponse paramProxyResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramProxyResponse.googlePlayServicesStatusCode);
    zzc.zza(paramParcel, 2, paramProxyResponse.recoveryAction, paramInt, false);
    zzc.zzc(paramParcel, 3, paramProxyResponse.statusCode);
    zzc.zza(paramParcel, 4, paramProxyResponse.zzajR, false);
    zzc.zza(paramParcel, 5, paramProxyResponse.body, false);
    zzc.zzc(paramParcel, 1000, paramProxyResponse.versionCode);
    zzc.zzJ(paramParcel, i);
  }
  
  public ProxyResponse zzV(Parcel paramParcel)
  {
    int m = zzb.zzaY(paramParcel);
    byte[] arrayOfByte = null;
    Bundle localBundle = null;
    int i = 0;
    PendingIntent localPendingIntent = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        localPendingIntent = (PendingIntent)zzb.zza(paramParcel, n, PendingIntent.CREATOR);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        localBundle = zzb.zzs(paramParcel, n);
        break;
      case 5: 
        arrayOfByte = zzb.zzt(paramParcel, n);
        break;
      case 1000: 
        k = zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new ProxyResponse(k, j, localPendingIntent, i, localBundle, arrayOfByte);
  }
  
  public ProxyResponse[] zzbk(int paramInt)
  {
    return new ProxyResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zzd
 * JD-Core Version:    0.7.0.1
 */