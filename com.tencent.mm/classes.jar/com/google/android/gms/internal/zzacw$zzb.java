package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzacw$zzb
  extends zza
{
  public static final Parcelable.Creator<zzb> CREATOR = new zzacv();
  final int versionCode;
  final String zzaB;
  final zzacs.zza<?, ?> zzaHl;
  
  zzacw$zzb(int paramInt, String paramString, zzacs.zza<?, ?> paramzza)
  {
    this.versionCode = paramInt;
    this.zzaB = paramString;
    this.zzaHl = paramzza;
  }
  
  zzacw$zzb(String paramString, zzacs.zza<?, ?> paramzza)
  {
    this.versionCode = 1;
    this.zzaB = paramString;
    this.zzaHl = paramzza;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacv.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzacw.zzb
 * JD-Core Version:    0.7.0.1
 */