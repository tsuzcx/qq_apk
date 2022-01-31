package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg
  extends zza
{
  public static final Parcelable.Creator<zzg> CREATOR = new zzf();
  final int versionCode;
  private Bundle zzaic;
  private int zzakD;
  
  zzg(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.versionCode = paramInt1;
    this.zzakD = paramInt2;
    this.zzaic = paramBundle;
  }
  
  public zzg(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    this(1, 1, paramGoogleSignInOptionsExtension.toBundle());
  }
  
  public Bundle getBundle()
  {
    return this.zzaic;
  }
  
  public int getType()
  {
    return this.zzakD;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg
 * JD-Core Version:    0.7.0.1
 */