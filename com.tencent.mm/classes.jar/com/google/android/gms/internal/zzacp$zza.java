package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzacp$zza
  extends zza
{
  public static final Parcelable.Creator<zza> CREATOR = new zzacr();
  final int versionCode;
  final String zzaGV;
  final int zzaGW;
  
  zzacp$zza(int paramInt1, String paramString, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.zzaGV = paramString;
    this.zzaGW = paramInt2;
  }
  
  zzacp$zza(String paramString, int paramInt)
  {
    this.versionCode = 1;
    this.zzaGV = paramString;
    this.zzaGW = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacr.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzacp.zza
 * JD-Core Version:    0.7.0.1
 */