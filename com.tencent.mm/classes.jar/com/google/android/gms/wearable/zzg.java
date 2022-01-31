package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzg
  implements Parcelable.Creator<ConnectionConfiguration>
{
  static void zza(ConnectionConfiguration paramConnectionConfiguration, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 2, paramConnectionConfiguration.getName(), false);
    zzc.zza(paramParcel, 3, paramConnectionConfiguration.getAddress(), false);
    zzc.zzc(paramParcel, 4, paramConnectionConfiguration.getType());
    zzc.zzc(paramParcel, 5, paramConnectionConfiguration.getRole());
    zzc.zza(paramParcel, 6, paramConnectionConfiguration.isEnabled());
    zzc.zza(paramParcel, 7, paramConnectionConfiguration.isConnected());
    zzc.zza(paramParcel, 8, paramConnectionConfiguration.zzUd(), false);
    zzc.zza(paramParcel, 9, paramConnectionConfiguration.zzUe());
    zzc.zza(paramParcel, 10, paramConnectionConfiguration.getNodeId(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public ConnectionConfiguration zzkL(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    String str1 = null;
    boolean bool1 = false;
    String str2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    int j = 0;
    String str3 = null;
    String str4 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 2: 
        str4 = zzb.zzq(paramParcel, m);
        break;
      case 3: 
        str3 = zzb.zzq(paramParcel, m);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, m);
        break;
      case 5: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 6: 
        bool3 = zzb.zzc(paramParcel, m);
        break;
      case 7: 
        bool2 = zzb.zzc(paramParcel, m);
        break;
      case 8: 
        str2 = zzb.zzq(paramParcel, m);
        break;
      case 9: 
        bool1 = zzb.zzc(paramParcel, m);
        break;
      case 10: 
        str1 = zzb.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new ConnectionConfiguration(str4, str3, j, i, bool3, bool2, str2, bool1, str1);
  }
  
  public ConnectionConfiguration[] zzpk(int paramInt)
  {
    return new ConnectionConfiguration[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.zzg
 * JD-Core Version:    0.7.0.1
 */