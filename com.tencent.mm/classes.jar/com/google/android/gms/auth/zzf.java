package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<TokenData>
{
  static void zza(TokenData paramTokenData, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramTokenData.zzaiI);
    zzc.zza(paramParcel, 2, paramTokenData.getToken(), false);
    zzc.zza(paramParcel, 3, paramTokenData.zzqO(), false);
    zzc.zza(paramParcel, 4, paramTokenData.zzqP());
    zzc.zza(paramParcel, 5, paramTokenData.zzqQ());
    zzc.zzb(paramParcel, 6, paramTokenData.zzqR(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public TokenData zzJ(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    ArrayList localArrayList = null;
    boolean bool1 = false;
    boolean bool2 = false;
    Long localLong = null;
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        localLong = zzb.zzj(paramParcel, k);
        break;
      case 4: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, k);
        break;
      case 6: 
        localArrayList = zzb.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new TokenData(i, str, localLong, bool2, bool1, localArrayList);
  }
  
  public TokenData[] zzaY(int paramInt)
  {
    return new TokenData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.zzf
 * JD-Core Version:    0.7.0.1
 */