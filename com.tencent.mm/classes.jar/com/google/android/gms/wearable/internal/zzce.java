package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzce
  extends zza
{
  public static final Parcelable.Creator<zzce> CREATOR = new zzcf();
  public final int statusCode;
  public final zzu zzbUa;
  
  public zzce(int paramInt, zzu paramzzu)
  {
    this.statusCode = paramInt;
    this.zzbUa = paramzzu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzcf.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzce
 * JD-Core Version:    0.7.0.1
 */