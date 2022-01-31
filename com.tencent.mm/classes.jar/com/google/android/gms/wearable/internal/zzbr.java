package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbr
  extends zza
{
  public static final Parcelable.Creator<zzbr> CREATOR = new zzbs();
  public final int statusCode;
  public final zzcc zzbUH;
  
  public zzbr(int paramInt, zzcc paramzzcc)
  {
    this.statusCode = paramInt;
    this.zzbUH = paramzzcc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbs.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbr
 * JD-Core Version:    0.7.0.1
 */