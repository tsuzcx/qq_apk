package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzcs
  extends zza
{
  public static final Parcelable.Creator<zzcs> CREATOR = new zzct();
  public final int statusCode;
  public final long zzbUT;
  public final List<zzcg> zzbUV;
  
  public zzcs(int paramInt, long paramLong, List<zzcg> paramList)
  {
    this.statusCode = paramInt;
    this.zzbUT = paramLong;
    this.zzbUV = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzct.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcs
 * JD-Core Version:    0.7.0.1
 */