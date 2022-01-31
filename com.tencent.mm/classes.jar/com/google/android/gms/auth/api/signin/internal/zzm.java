package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzm
  implements Parcelable.Creator<SignInConfiguration>
{
  static void zza(SignInConfiguration paramSignInConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramSignInConfiguration.versionCode);
    zzc.zza(paramParcel, 2, paramSignInConfiguration.zzry(), false);
    zzc.zza(paramParcel, 5, paramSignInConfiguration.zzrz(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public SignInConfiguration zzaa(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    GoogleSignInOptions localGoogleSignInOptions = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      case 3: 
      case 4: 
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, k);
        break;
      case 5: 
        localGoogleSignInOptions = (GoogleSignInOptions)zzb.zza(paramParcel, k, GoogleSignInOptions.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new SignInConfiguration(i, str, localGoogleSignInOptions);
  }
  
  public SignInConfiguration[] zzbp(int paramInt)
  {
    return new SignInConfiguration[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzm
 * JD-Core Version:    0.7.0.1
 */