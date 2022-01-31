package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzae
  implements Parcelable.Creator<zzad>
{
  static void zza(zzad paramzzad, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzad.zzaiI);
    zzc.zza(paramParcel, 2, paramzzad.getAccount(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramzzad.getSessionId());
    zzc.zza(paramParcel, 4, paramzzad.zzyf(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzad zzaT(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    GoogleSignInAccount localGoogleSignInAccount = null;
    int j = 0;
    Account localAccount = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        localAccount = (Account)zzb.zza(paramParcel, m, Account.CREATOR);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, m);
        break;
      case 4: 
        localGoogleSignInAccount = (GoogleSignInAccount)zzb.zza(paramParcel, m, GoogleSignInAccount.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzad(i, localAccount, j, localGoogleSignInAccount);
  }
  
  public zzad[] zzcY(int paramInt)
  {
    return new zzad[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzae
 * JD-Core Version:    0.7.0.1
 */