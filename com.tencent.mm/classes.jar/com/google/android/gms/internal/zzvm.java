package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzvm
  extends zza
{
  public static final Parcelable.Creator<zzvm> CREATOR = new zzvn();
  final int zzaiI;
  private final Credential zzajL;
  
  zzvm(int paramInt, Credential paramCredential)
  {
    this.zzaiI = paramInt;
    this.zzajL = paramCredential;
  }
  
  public zzvm(Credential paramCredential)
  {
    this(1, paramCredential);
  }
  
  public final Credential getCredential()
  {
    return this.zzajL;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzvn.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzvm
 * JD-Core Version:    0.7.0.1
 */