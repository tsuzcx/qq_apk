package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbc
  extends zza
{
  public static final Parcelable.Creator<zzbc> CREATOR = new zzbb();
  public final int statusCode;
  public final boolean zzbUA;
  
  public zzbc(int paramInt, boolean paramBoolean)
  {
    this.statusCode = paramInt;
    this.zzbUA = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbb.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbc
 * JD-Core Version:    0.7.0.1
 */