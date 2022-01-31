package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzbj
  extends zza
{
  public static final Parcelable.Creator<zzbj> CREATOR = new zzbk();
  public final int statusCode;
  public final ConnectionConfiguration[] zzbUE;
  
  public zzbj(int paramInt, ConnectionConfiguration[] paramArrayOfConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.zzbUE = paramArrayOfConnectionConfiguration;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbk.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbj
 * JD-Core Version:    0.7.0.1
 */