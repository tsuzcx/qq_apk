package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc
  extends zza
{
  public static final Parcelable.Creator<zzc> CREATOR = new zzd();
  public final String name;
  public final int version;
  
  public zzc(String paramString, int paramInt)
  {
    this.name = paramString;
    this.version = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.zzc
 * JD-Core Version:    0.7.0.1
 */