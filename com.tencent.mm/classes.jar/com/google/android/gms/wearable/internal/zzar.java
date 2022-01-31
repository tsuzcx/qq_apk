package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzar
  extends zza
{
  public static final Parcelable.Creator<zzar> CREATOR = new zzas();
  public final int statusCode;
  public final int zzbUw;
  
  public zzar(int paramInt1, int paramInt2)
  {
    this.statusCode = paramInt1;
    this.zzbUw = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzas.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzar
 * JD-Core Version:    0.7.0.1
 */