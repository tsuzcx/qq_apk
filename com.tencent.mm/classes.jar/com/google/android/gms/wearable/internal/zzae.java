package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzae
  extends zza
{
  public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
  public final int statusCode;
  
  public zzae(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaf.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzae
 * JD-Core Version:    0.7.0.1
 */