package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzvi
  extends zza
{
  public static final Parcelable.Creator<zzvi> CREATOR = new zzvj();
  final int zzaiI;
  private final PasswordSpecification zzajb;
  
  zzvi(int paramInt, PasswordSpecification paramPasswordSpecification)
  {
    this.zzaiI = paramInt;
    this.zzajb = paramPasswordSpecification;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzvj.zza(this, paramParcel, paramInt);
  }
  
  public final PasswordSpecification zzqT()
  {
    return this.zzajb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzvi
 * JD-Core Version:    0.7.0.1
 */