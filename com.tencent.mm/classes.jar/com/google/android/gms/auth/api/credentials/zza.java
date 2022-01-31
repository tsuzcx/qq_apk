package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<Credential>
{
  static void zza(Credential paramCredential, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramCredential.getId(), false);
    zzc.zza(paramParcel, 2, paramCredential.getName(), false);
    zzc.zza(paramParcel, 3, paramCredential.getProfilePictureUri(), paramInt, false);
    zzc.zzc(paramParcel, 4, paramCredential.getIdTokens(), false);
    zzc.zza(paramParcel, 5, paramCredential.getPassword(), false);
    zzc.zza(paramParcel, 6, paramCredential.getAccountType(), false);
    zzc.zza(paramParcel, 7, paramCredential.getGeneratedPassword(), false);
    zzc.zzc(paramParcel, 1000, paramCredential.zzaiI);
    zzc.zza(paramParcel, 8, paramCredential.zzqV(), false);
    zzc.zza(paramParcel, 9, paramCredential.getGivenName(), false);
    zzc.zza(paramParcel, 10, paramCredential.getFamilyName(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public Credential zzK(Parcel paramParcel)
  {
    int j = zzb.zzaY(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    ArrayList localArrayList = null;
    Uri localUri = null;
    String str7 = null;
    String str8 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        str8 = zzb.zzq(paramParcel, k);
        break;
      case 2: 
        str7 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        localUri = (Uri)zzb.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 4: 
        localArrayList = zzb.zzc(paramParcel, k, IdToken.CREATOR);
        break;
      case 5: 
        str6 = zzb.zzq(paramParcel, k);
        break;
      case 6: 
        str5 = zzb.zzq(paramParcel, k);
        break;
      case 7: 
        str4 = zzb.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 8: 
        str3 = zzb.zzq(paramParcel, k);
        break;
      case 9: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 10: 
        str1 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new Credential(i, str8, str7, localUri, localArrayList, str6, str5, str4, str3, str2, str1);
  }
  
  public Credential[] zzaZ(int paramInt)
  {
    return new Credential[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zza
 * JD-Core Version:    0.7.0.1
 */