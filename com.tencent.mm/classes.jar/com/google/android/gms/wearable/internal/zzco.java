package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzco
  extends zza
{
  public static final Parcelable.Creator<zzco> CREATOR = new zzcp();
  public final int statusCode;
  public final int zzbhZ;
  
  public zzco(int paramInt1, int paramInt2)
  {
    this.statusCode = paramInt1;
    this.zzbhZ = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzcp.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzco
 * JD-Core Version:    0.7.0.1
 */