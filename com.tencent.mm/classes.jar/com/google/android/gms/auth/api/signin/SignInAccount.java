package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInAccount
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<SignInAccount> CREATOR;
  @Deprecated
  private String zzeo;
  private GoogleSignInAccount zzep;
  @Deprecated
  private String zzeq;
  
  static
  {
    AppMethodBeat.i(88296);
    CREATOR = new zze();
    AppMethodBeat.o(88296);
  }
  
  SignInAccount(String paramString1, GoogleSignInAccount paramGoogleSignInAccount, String paramString2)
  {
    AppMethodBeat.i(88294);
    this.zzep = paramGoogleSignInAccount;
    this.zzeo = Preconditions.checkNotEmpty(paramString1, "8.3 and 8.4 SDKs require non-null email");
    this.zzeq = Preconditions.checkNotEmpty(paramString2, "8.3 and 8.4 SDKs require non-null userId");
    AppMethodBeat.o(88294);
  }
  
  public final GoogleSignInAccount getGoogleSignInAccount()
  {
    return this.zzep;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88295);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzeo, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, this.zzep, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzeq, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(88295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.SignInAccount
 * JD-Core Version:    0.7.0.1
 */