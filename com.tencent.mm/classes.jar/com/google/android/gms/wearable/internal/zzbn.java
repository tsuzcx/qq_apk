package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbn
  extends zza
{
  public static final Parcelable.Creator<zzbn> CREATOR = new zzbo();
  public final int statusCode;
  public final zzao zzbUG;
  
  public zzbn(int paramInt, zzao paramzzao)
  {
    this.statusCode = paramInt;
    this.zzbUG = paramzzao;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbo.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbn
 * JD-Core Version:    0.7.0.1
 */