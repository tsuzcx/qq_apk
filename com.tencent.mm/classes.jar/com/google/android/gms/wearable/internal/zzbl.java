package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzbl
  extends zza
{
  public static final Parcelable.Creator<zzbl> CREATOR = new zzbm();
  public final int statusCode;
  public final List<zzcc> zzbUF;
  
  public zzbl(int paramInt, List<zzcc> paramList)
  {
    this.statusCode = paramInt;
    this.zzbUF = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbm.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbl
 * JD-Core Version:    0.7.0.1
 */