package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzav
  extends zza
{
  public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
  public final int statusCode;
  public final zzo zzbUy;
  
  public zzav(int paramInt, zzo paramzzo)
  {
    this.statusCode = paramInt;
    this.zzbUy = paramzzo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaw.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzav
 * JD-Core Version:    0.7.0.1
 */