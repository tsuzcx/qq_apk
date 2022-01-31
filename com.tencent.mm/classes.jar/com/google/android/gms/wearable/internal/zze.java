package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze
  extends zza
{
  public static final Parcelable.Creator<zze> CREATOR = new zzf();
  public final int statusCode;
  
  public zze(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zze
 * JD-Core Version:    0.7.0.1
 */