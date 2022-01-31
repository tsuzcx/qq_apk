package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzc
  implements Parcelable.Creator<SignInAccount>
{
  static void zza(SignInAccount paramSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, paramSignInAccount.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramSignInAccount.zzaka, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, paramSignInAccount.zzro(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, paramSignInAccount.zzadi, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, i);
  }
  
  public SignInAccount zzY(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String str1 = "";
    GoogleSignInAccount localGoogleSignInAccount = null;
    String str2 = "";
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      case 2: 
      case 3: 
      case 5: 
      case 6: 
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 4: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 7: 
        localGoogleSignInAccount = (GoogleSignInAccount)zzb.zza(paramParcel, k, GoogleSignInAccount.CREATOR);
        break;
      case 8: 
        str2 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new SignInAccount(i, str1, localGoogleSignInAccount, str2);
  }
  
  public SignInAccount[] zzbn(int paramInt)
  {
    return new SignInAccount[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzc
 * JD-Core Version:    0.7.0.1
 */