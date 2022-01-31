package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class SignInConfiguration
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzm();
  final int versionCode;
  private final String zzakG;
  private GoogleSignInOptions zzakH;
  
  SignInConfiguration(int paramInt, String paramString, GoogleSignInOptions paramGoogleSignInOptions)
  {
    this.versionCode = paramInt;
    this.zzakG = zzac.zzdr(paramString);
    this.zzakH = paramGoogleSignInOptions;
  }
  
  public SignInConfiguration(String paramString, GoogleSignInOptions paramGoogleSignInOptions)
  {
    this(3, paramString, paramGoogleSignInOptions);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (SignInConfiguration)paramObject;
        if (this.zzakG.equals(paramObject.zzry())) {
          if (this.zzakH == null)
          {
            if (paramObject.zzrz() != null) {
              continue;
            }
          }
          else
          {
            boolean bool = this.zzakH.equals(paramObject.zzrz());
            if (!bool) {
              continue;
            }
          }
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    return new zzh().zzq(this.zzakG).zzq(this.zzakH).zzru();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public final String zzry()
  {
    return this.zzakG;
  }
  
  public final GoogleSignInOptions zzrz()
  {
    return this.zzakH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInConfiguration
 * JD-Core Version:    0.7.0.1
 */