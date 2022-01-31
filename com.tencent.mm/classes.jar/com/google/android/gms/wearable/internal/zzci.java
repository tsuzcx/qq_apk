package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzci
  extends zza
{
  public static final Parcelable.Creator<zzci> CREATOR = new zzcj();
  public final int statusCode;
  public final zzao zzbUG;
  
  public zzci(int paramInt, zzao paramzzao)
  {
    this.statusCode = paramInt;
    this.zzbUG = paramzzao;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzcj.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzci
 * JD-Core Version:    0.7.0.1
 */