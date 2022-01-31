package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzcg
  extends zza
{
  public static final Parcelable.Creator<zzcg> CREATOR = new zzch();
  public final String label;
  public final String packageName;
  public final long zzbUT;
  
  public zzcg(String paramString1, String paramString2, long paramLong)
  {
    this.packageName = paramString1;
    this.label = paramString2;
    this.zzbUT = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzch.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcg
 * JD-Core Version:    0.7.0.1
 */