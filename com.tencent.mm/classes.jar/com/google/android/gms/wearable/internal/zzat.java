package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzat
  extends zza
{
  public static final Parcelable.Creator<zzat> CREATOR = new zzau();
  public final int statusCode;
  public final List<zzo> zzbUx;
  
  public zzat(int paramInt, List<zzo> paramList)
  {
    this.statusCode = paramInt;
    this.zzbUx = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzau.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzat
 * JD-Core Version:    0.7.0.1
 */