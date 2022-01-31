package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class SignInAccount
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<SignInAccount> CREATOR = new zzc();
  final int versionCode;
  @Deprecated
  String zzadi;
  @Deprecated
  String zzaka;
  private GoogleSignInAccount zzakt;
  
  SignInAccount(int paramInt, String paramString1, GoogleSignInAccount paramGoogleSignInAccount, String paramString2)
  {
    this.versionCode = paramInt;
    this.zzakt = paramGoogleSignInAccount;
    this.zzaka = zzac.zzh(paramString1, "8.3 and 8.4 SDKs require non-null email");
    this.zzadi = zzac.zzh(paramString2, "8.3 and 8.4 SDKs require non-null userId");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public GoogleSignInAccount zzro()
  {
    return this.zzakt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.SignInAccount
 * JD-Core Version:    0.7.0.1
 */