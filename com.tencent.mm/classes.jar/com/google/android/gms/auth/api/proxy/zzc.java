package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzc
  implements Parcelable.Creator<ProxyRequest>
{
  static void zza(ProxyRequest paramProxyRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 1, paramProxyRequest.url, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 2, paramProxyRequest.httpMethod);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 3, paramProxyRequest.timeoutMillis);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramProxyRequest.body, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramProxyRequest.zzajR, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1000, paramProxyRequest.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, paramInt);
  }
  
  public ProxyRequest zzU(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    long l = 0L;
    Bundle localBundle = null;
    byte[] arrayOfByte = null;
    int i = 0;
    String str = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        str = zzb.zzq(paramParcel, m);
        break;
      case 2: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 3: 
        l = zzb.zzi(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = zzb.zzt(paramParcel, m);
        break;
      case 5: 
        localBundle = zzb.zzs(paramParcel, m);
        break;
      case 1000: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new ProxyRequest(j, str, i, l, arrayOfByte, localBundle);
  }
  
  public ProxyRequest[] zzbj(int paramInt)
  {
    return new ProxyRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zzc
 * JD-Core Version:    0.7.0.1
 */