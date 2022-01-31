package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GoogleSignInOptions>
{
  static void zza(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zzc(paramParcel, 1, paramGoogleSignInOptions.versionCode);
    zzc.zzc(paramParcel, 2, paramGoogleSignInOptions.zzrj(), false);
    zzc.zza(paramParcel, 3, paramGoogleSignInOptions.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 4, paramGoogleSignInOptions.isIdTokenRequested());
    zzc.zza(paramParcel, 5, paramGoogleSignInOptions.zzrk());
    zzc.zza(paramParcel, 6, paramGoogleSignInOptions.zzrl());
    zzc.zza(paramParcel, 7, paramGoogleSignInOptions.getServerClientId(), false);
    zzc.zza(paramParcel, 8, paramGoogleSignInOptions.zzrm(), false);
    zzc.zzc(paramParcel, 9, paramGoogleSignInOptions.zzrn(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public GoogleSignInOptions zzX(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    ArrayList localArrayList1 = null;
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    ArrayList localArrayList2 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzdc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 3: 
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4: 
        bool3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 6: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 7: 
        str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 8: 
        str1 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 9: 
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k, zzg.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInOptions(i, localArrayList2, localAccount, bool3, bool2, bool1, str2, str1, localArrayList1);
  }
  
  public GoogleSignInOptions[] zzbm(int paramInt)
  {
    return new GoogleSignInOptions[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzb
 * JD-Core Version:    0.7.0.1
 */