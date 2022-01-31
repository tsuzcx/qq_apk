package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzad;

public class zzbau
  extends zza
{
  public static final Parcelable.Creator<zzbau> CREATOR = new zzbav();
  final int zzaiI;
  final zzad zzbEx;
  
  zzbau(int paramInt, zzad paramzzad)
  {
    this.zzaiI = paramInt;
    this.zzbEx = paramzzad;
  }
  
  public zzbau(zzad paramzzad)
  {
    this(1, paramzzad);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbav.zza(this, paramParcel, paramInt);
  }
  
  public zzad zzPS()
  {
    return this.zzbEx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzbau
 * JD-Core Version:    0.7.0.1
 */