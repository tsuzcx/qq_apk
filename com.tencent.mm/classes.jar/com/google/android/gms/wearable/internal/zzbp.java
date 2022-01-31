package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbp
  extends zza
{
  public static final Parcelable.Creator<zzbp> CREATOR = new zzbq();
  public final int statusCode;
  public final ParcelFileDescriptor zzbyh;
  
  public zzbp(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.statusCode = paramInt;
    this.zzbyh = paramParcelFileDescriptor;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbq.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbp
 * JD-Core Version:    0.7.0.1
 */